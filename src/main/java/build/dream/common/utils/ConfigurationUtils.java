package build.dream.common.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.env.Environment;

import java.util.Objects;

public class ConfigurationUtils {
    private static Environment environment;

    private static Environment obtainEnvironment() {
        if (Objects.isNull(environment)) {
            environment = ApplicationHandler.getBean(Environment.class);
        }
        return environment;
    }

    public static String getConfiguration(String configurationKey) {
        String configurationValue = PropertyUtils.getProperty(configurationKey);
        if (StringUtils.isNotBlank(configurationValue)) {
            return configurationValue;
        }
        return obtainEnvironment().getProperty(configurationKey);
    }

    public static String getConfiguration(String configurationKey, String defaultValue) {
        String configurationValue = getConfiguration(configurationKey);
        if (StringUtils.isNotBlank(configurationValue)) {
            return configurationValue;
        }
        return defaultValue;
    }

    public static String resolvePlaceholders(String text) {
        return obtainEnvironment().resolvePlaceholders(text);
    }
}
