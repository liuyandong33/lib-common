package build.dream.common.utils;

import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.constants.Constants;

public class EnvironmentUtils {
    public static boolean isDevelopment() {
        return Constants.DEVELOPMENT.equals(ConfigurationUtils.getConfiguration(ConfigurationKeys.DEPLOYMENT_ENVIRONMENT));
    }

    public static boolean isTest() {
        return Constants.TEST.equals(ConfigurationUtils.getConfiguration(ConfigurationKeys.DEPLOYMENT_ENVIRONMENT));
    }

    public static boolean isBeta() {
        return Constants.BETA.equals(ConfigurationUtils.getConfiguration(ConfigurationKeys.DEPLOYMENT_ENVIRONMENT));
    }

    public static boolean isProduction() {
        return Constants.PRODUCTION.equals(ConfigurationUtils.getConfiguration(ConfigurationKeys.DEPLOYMENT_ENVIRONMENT));
    }
}
