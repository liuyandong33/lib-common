package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by liuyandong on 2017/5/11.
 */
public class PropertyUtils {
    private static Properties properties = null;

    public static String getProperty(String key) throws IOException {
        return getProperties().getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) throws IOException {
        return getProperties().getProperty(key, defaultValue);
    }

    public static Properties getProperties() throws IOException {
        if (properties == null) {
            loadProperties();
        }
        return properties;
    }

    public static void loadProperties() throws IOException {
        properties = new Properties();
        InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(Constants.PRODUCTION_PROPERTIES);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Constants.CHARSET_UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        properties.load(bufferedReader);
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
