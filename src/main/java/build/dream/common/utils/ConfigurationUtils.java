package build.dream.common.utils;

import build.dream.common.saas.domains.Configuration;
import build.dream.common.constants.Constants;

import java.io.IOException;
import java.util.List;

public class ConfigurationUtils {
    public static void loadConfigurations(List<Configuration> configurations) throws IOException {
        for (Configuration configuration : configurations) {
            String key = String.format("_%s_%s_%s", configuration.getDeploymentEnvironment(), configuration.getPartitionCode(), configuration.getServiceName());
            CacheUtils.hset(key, configuration.getConfigurationKey(), configuration.getConfigurationValue());
        }
    }

    public static String getConfigurationValue(String configurationKey) throws IOException {
        String deploymentEnvironment = PropertyUtils.getProperty(Constants.DEPLOYMENT_ENVIRONMENT);
        String partitionCode = PropertyUtils.getProperty(Constants.PARTITION_CODE);
        String serviceName = PropertyUtils.getProperty(Constants.SERVICE_NAME);
        String key = String.format("_%s_%s_%s", deploymentEnvironment, partitionCode, serviceName);
        return CacheUtils.hget(key, configurationKey);
    }
}
