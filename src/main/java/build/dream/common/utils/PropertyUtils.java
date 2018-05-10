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
    private static Properties PROPERTIES = null;

    public static String getProperty(String propertyKey) throws IOException {
        return getProperties().getProperty(propertyKey);
    }

    public static String getProperty(String propertyKey, String defaultPropertyValue) throws IOException {
        return getProperties().getProperty(propertyKey, defaultPropertyValue);
    }

    public static Properties getProperties() throws IOException {
        if (PROPERTIES == null) {
            loadProperties();
        }
        return PROPERTIES;
    }

    public static void loadProperties() throws IOException {
        PROPERTIES = new Properties();
        InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(Constants.PRODUCTION_PROPERTIES);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Constants.CHARSET_UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        PROPERTIES.load(bufferedReader);
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
