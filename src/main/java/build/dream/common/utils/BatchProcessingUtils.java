package build.dream.common.utils;

import build.dream.common.beans.BatchProcessingInfo;
import build.dream.common.constants.Constants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BatchProcessingUtils {
    public static List<BatchProcessingInfo> obtainBatchProcessingInfos(long timestamp) {
        String value = CommonRedisUtils.hget(Constants.KEY_BATCH_PROCESSING_INFOS, "_" + timestamp / 1000);
        if (StringUtils.isBlank(value)) {
            return null;
        }

        Set<String> infos = CommonRedisUtils.smembers(value);
        if (CollectionUtils.isEmpty(infos)) {
            return null;
        }
        CommonRedisUtils.del(value);
        List<BatchProcessingInfo> batchProcessingInfos = new ArrayList<BatchProcessingInfo>();
        for (String info : infos) {
            batchProcessingInfos.add(JacksonUtils.readValue(info, BatchProcessingInfo.class));
        }
        return batchProcessingInfos;
    }

    public static void removeBatchProcessingInfo(long timestamp, BatchProcessingInfo batchProcessingInfo) {
        CommonRedisUtils.srem("_" + timestamp / 1000, JacksonUtils.writeValueAsString(batchProcessingInfo));
    }

    public static void addBatchProcessingInfo(long timestamp, BatchProcessingInfo batchProcessingInfo) {
        String field = "_" + timestamp / 1000;
        CommonRedisUtils.hset(Constants.KEY_BATCH_PROCESSING_INFOS, field, field);
        CommonRedisUtils.sadd(field, JacksonUtils.writeValueAsString(batchProcessingInfo));
    }
}
