package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by liuyandong on 2017/5/11.
 */
public class PropertyUtils {
    private static Properties properties = null;

    public static String getProperty(String key) {
        return ApplicationHandler.callMethodSuppressThrow(() -> getProperties().getProperty(key));
    }

    public static String getProperty(String key, String defaultValue) {
        return ApplicationHandler.callMethodSuppressThrow(() -> getProperties().getProperty(key, defaultValue));
    }

    private static Properties getProperties() throws IOException {
        if (Objects.isNull(properties)) {
            loadProperties();
        }
        return properties;
    }

    private static void loadProperties() throws IOException {
        properties = new Properties();
        InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(Constants.DEVELOPMENT_PROPERTIES);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Constants.CHARSET_UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        properties.load(bufferedReader);
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
