package build.dream.common.snowflake

class SnowflakeIdWorker(val workerId: Long, val dataCenterId: Long, var sequence: Long = 0L) {
    val twepoch = 1288834974657L

    private[this] val workerIdBits = 5L
    private[this] val dataCenterIdBits = 5L
    private[this] val maxWorkerId = -1L ^ (-1L << workerIdBits)
    private[this] val maxDataCenterId = -1L ^ (-1L << dataCenterIdBits)
    private[this] val sequenceBits = 12L

    private[this] val workerIdShift = sequenceBits
    private[this] val dataCenterIdShift = sequenceBits + workerIdBits
    private[this] val timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits
    private[this] val sequenceMask = -1L ^ (-1L << sequenceBits)

    private[this] var lastTimestamp = -1L

    if (workerId > maxWorkerId || workerId < 0) {
        throw new IllegalArgumentException("worker Id can't be greater than %d or less than 0".format(maxWorkerId))
    }

    if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
        throw new IllegalArgumentException("data center Id can't be greater than %d or less than 0".format(maxDataCenterId))
    }

    protected[snowflake] def nextId(): Long = synchronized {
        var timestamp = timeGen()
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id for %d milliseconds".format(lastTimestamp - timestamp))
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp)
            }
        } else {
            sequence = 0
        }
        lastTimestamp = timestamp
        ((timestamp - twepoch) << timestampLeftShift) | (dataCenterId << dataCenterIdShift) | (workerId << workerIdShift) | sequence
    }

    protected def tilNextMillis(lastTimestamp: Long): Long = {
        var timestamp = timeGen()
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen()
        }
        timestamp
    }

    protected def timeGen(): Long = System.currentTimeMillis()
}
