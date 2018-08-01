package build.dream.common;

import build.dream.common.utils.ThreadUtils;

import java.util.concurrent.atomic.AtomicLong;

public class IdWorker {
    // 时间基准
    private final long twepoch = 136040000000L;
    private final long workerIdBits = 5L;
    private final long dataCenterIdBits = 3L;
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
    private final long sequenceBits = 12L;
    private final long workerIdShift = sequenceBits;
    private final long dataCenterIdShift = sequenceBits + workerIdBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long dataCenterId;
    private AtomicLong sequence = new AtomicLong(0);
    private volatile long lastTimestamp = -1L;

    public IdWorker(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("dataCenter Id can't be greater than %d or less than 0", maxDataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    public long nextId() {
        long currentSeq;
        long seq;
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        while (true) {
            if (lastTimestamp == timestamp) {
                currentSeq = sequence.incrementAndGet();
                if (currentSeq > sequenceMask) { //当前毫秒的已经用完，计数器清0，等到下一个毫秒
                    timestamp = tilNextMillis(lastTimestamp);
                    sequence.compareAndSet(currentSeq, -1);
                    continue;
                } else {
                    seq = currentSeq & sequenceMask;
                    break;
                }
            }
            lastTimestamp = timestamp;
        }
        return ((timestamp + twepoch) << timestampLeftShift) | (dataCenterId << dataCenterIdShift) | (workerId << workerIdShift) | seq;
    }

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

    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker(1, 1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(idWorker.nextId());
                    ThreadUtils.sleepSafe(1000);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(idWorker.nextId());
                    ThreadUtils.sleepSafe(1000);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(idWorker.nextId());
                    ThreadUtils.sleepSafe(1000);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(idWorker.nextId());
                    ThreadUtils.sleepSafe(1000);
                }
            }
        }).start();
    }
}
