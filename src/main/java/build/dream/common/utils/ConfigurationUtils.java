package build.dream.common.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.env.Environment;

import java.io.IOException;

public class ConfigurationUtils {
    private static Environment environment;

    private static Environment obtainEnvironment() {
        if (environment == null) {
            environment = ApplicationHandler.getBean(Environment.class);
        }
        return environment;
    }

    public static String getConfiguration(String configurationKey) throws IOException {
        String configurationValue = PropertyUtils.getProperty(configurationKey);
        if (StringUtils.isBlank(configurationValue)) {
            configurationValue = obtainEnvironment().getProperty(configurationKey);
        }
        return configurationValue;
    }

    public static String getConfigurationSafe(String configurationKey) {
        try {
            return getConfiguration(configurationKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getConfiguration(String configurationKey, String defaultValue) throws IOException {
        String configurationValue = getConfiguration(configurationKey);
        if (StringUtils.isNotBlank(configurationValue)) {
            return configurationValue;
        }
        return defaultValue;
    }
}
