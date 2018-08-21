package build.dream.common.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.env.Environment;

public class ConfigurationUtils {
    private static Environment environment;

    private static Environment obtainEnvironment() {
        if (environment == null) {
            environment = ApplicationHandler.getBean(Environment.class);
        }
        return environment;
    }

    public static String getConfiguration(String configurationKey) {
        String configurationValue = PropertyUtils.getPropertySafe(configurationKey);
        if (StringUtils.isBlank(configurationValue)) {
            configurationValue = obtainEnvironment().getProperty(configurationKey);
        }
        return configurationValue;
    }

    public static String getConfiguration(String configurationKey, String defaultValue) {
        String configurationValue = getConfiguration(configurationKey);
        if (StringUtils.isNotBlank(configurationValue)) {
            return configurationValue;
        }
        return defaultValue;
    }
}
