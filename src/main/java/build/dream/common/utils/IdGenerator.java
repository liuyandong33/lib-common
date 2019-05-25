package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.snowflake.SnowflakeIdWorker;

public class IdGenerator {
    private static SnowflakeIdWorker snowflakeIdWorker = null;

    public static SnowflakeIdWorker obtainSnowflakeIdWorker() {
        if (snowflakeIdWorker != null) {
            return snowflakeIdWorker;
        }
        String snowflakeWorkerId = ConfigurationUtils.getConfiguration(Constants.SNOWFLAKE_WORKER_ID);
        ValidateUtils.notBlank(snowflakeWorkerId, "雪花ID生成器初始化失败（未配置机器码）！");

        String snowflakeDataCenterId = ConfigurationUtils.getConfiguration(Constants.SNOWFLAKE_DATA_CENTER_ID);
        ValidateUtils.notBlank(snowflakeWorkerId, "雪花ID生成器初始化失败（未配置机房码）！");

        snowflakeIdWorker = new SnowflakeIdWorker(Long.parseLong(snowflakeWorkerId), Long.parseLong(snowflakeDataCenterId), 0);
        return snowflakeIdWorker;
    }

    public static long nextSnowflakeId() {
        return obtainSnowflakeIdWorker().nextId();
    }
}
