package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.io.IOException;

public class IdentificationGenerator {
    public synchronized static Long nextIdentification(String sequenceName) throws IOException {
        String deploymentEnvironment = PropertyUtils.getProperty(Constants.DEPLOYMENT_ENVIRONMENT);
        String partitionCode = PropertyUtils.getProperty(Constants.PARTITION_CODE);
        String serviceName = PropertyUtils.getProperty(Constants.SERVICE_NAME);
        String key = String.format("_%s_%s_%s_%s", deploymentEnvironment, partitionCode, serviceName, sequenceName);
        Boolean exists = CommonRedisUtils.exists(key);
        if (exists) {
            return CommonRedisUtils.incrby(key, 1);
        }
        return null;
    }
}
