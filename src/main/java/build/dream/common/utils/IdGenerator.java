package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.snowflake.SnowflakeIdWorker;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IdGenerator {
    private static SnowflakeIdWorker snowflakeIdWorker = null;

    private static SnowflakeIdWorker initSnowflakeIdWorker() {
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

            snowflakeIdWorker = new SnowflakeIdWorker(Long.parseLong(workerId), Long.parseLong(dataCenterId), 0);
            return snowflakeIdWorker;
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

    public static SnowflakeIdWorker obtainSnowflakeIdWorker() {
        if (snowflakeIdWorker != null) {
            return snowflakeIdWorker;
        }
        return initSnowflakeIdWorker();
    }

    public static long nextSnowflakeId() {
        return obtainSnowflakeIdWorker().nextId();
    }
}
