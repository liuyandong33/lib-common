package build.dream.common.orm;

import java.math.BigInteger;

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
