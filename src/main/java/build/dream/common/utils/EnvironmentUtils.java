package build.dream.common.utils;

import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.constants.Constants;

public class EnvironmentUtils {
    public static boolean isDev() {
        return Constants.DEV.equals(ConfigurationUtils.getConfiguration(ConfigurationKeys.DEPLOYMENT_ENVIRONMENT));
    }

    public static boolean isTest() {
        return Constants.DEV.equals(ConfigurationUtils.getConfiguration(ConfigurationKeys.DEPLOYMENT_ENVIRONMENT));
    }

    public static boolean isBata() {
        return Constants.DEV.equals(ConfigurationUtils.getConfiguration(ConfigurationKeys.DEPLOYMENT_ENVIRONMENT));
    }

    public static boolean isProd() {
        return Constants.DEV.equals(ConfigurationUtils.getConfiguration(ConfigurationKeys.DEPLOYMENT_ENVIRONMENT));
    }
}
