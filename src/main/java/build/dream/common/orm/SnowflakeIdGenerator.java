package build.dream.common.orm;

import build.dream.common.constants.Constants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.DatabaseUtils;
import build.dream.common.utils.ValidateUtils;

import java.math.BigInteger;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SnowflakeIdGenerator implements IdGenerator<BigInteger> {
    // 开始时间2019-01-01 00:00:00
    private long twepoch = 1546272000000L;

    private long workerIdBits = 5L;
    private long dataCenterIdBits = 5L;
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long dataCenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);
    private long lastTimestamp = -1L;

    private long workerId;
    private long dataCenterId;
    private long sequence;

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public SnowflakeIdGenerator(long workerId, long dataCenterId, long sequence) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("worker Id can't be greater than " + maxWorkerId + " or less than 0");
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException("data center Id can't be greater than " + maxDataCenterId + " or less than 0");
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
        this.sequence = sequence;
    }

    public SnowflakeIdGenerator() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String url = ConfigurationUtils.getConfiguration(Constants.SNOWFLAKE_ID_CONFIG_DATABASE_URL);
            ValidateUtils.notBlank(url, "雪花ID生成器初始化失败（未检索到相关配置）！");

            String username = ConfigurationUtils.getConfiguration(Constants.SNOWFLAKE_ID_CONFIG_DATABASE_USERNAME);
            ValidateUtils.notBlank(username, "雪花ID生成器初始化失败（未检索到相关配置）！");

            String password = ConfigurationUtils.getConfiguration(Constants.SNOWFLAKE_ID_CONFIG_DATABASE_PASSWORD);
            ValidateUtils.notBlank(password, "雪花ID生成器初始化失败（未检索到相关配置）！");

            String driverClassName = ConfigurationUtils.getConfiguration(Constants.SNOWFLAKE_ID_CONFIG_DATABASE_DRIVER_CLASS_NAME);
            ValidateUtils.notBlank(driverClassName, "雪花ID生成器初始化失败（未检索到相关配置）！");

            Class.forName(driverClassName);

            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement("SELECT * FROM snowflake_id_config WHERE ip_address = ?");

            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            preparedStatement.setString(1, ipAddress);
            resultSet = preparedStatement.executeQuery();
            ValidateUtils.isTrue(resultSet.next(), "雪花ID生成器初始化失败（未检索到相关配置）！");
            String workerId = resultSet.getString("worker_id");
            String dataCenterId = resultSet.getString("data_center_id");

            this.workerId = Long.parseLong(workerId);
            this.dataCenterId = Long.parseLong(dataCenterId);
        } catch (Exception e) {
            if (e instanceof CustomException) {
                CustomException customException = (CustomException) e;
                throw customException;
            } else {
                throw new RuntimeException(e);
            }
        } finally {
            DatabaseUtils.closeResultSet(resultSet);
            DatabaseUtils.closeStatement(preparedStatement);
            DatabaseUtils.closeConnection(connection);
        }
    }

    @Override
    public synchronized BigInteger nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        return BigInteger.valueOf(((timestamp - twepoch) << timestampLeftShift) | (dataCenterId << dataCenterIdShift) | (workerId << workerIdShift) | sequence);
    }
}
