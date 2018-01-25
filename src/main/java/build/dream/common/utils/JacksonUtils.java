package build.dream.common.utils;

import build.dream.common.constants.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JacksonUtils {
    private static ObjectMapper objectMapper = null;

    private static ObjectMapper obtainObjectMapper(String datePattern) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        objectMapper.setDateFormat(new SimpleDateFormat(datePattern));
        return objectMapper;
    }

    public static String writeValueAsString(Object object) {
        return writeValueAsString(object, Constants.DEFAULT_DATE_PATTERN);
    }

    public static String writeValueAsString(Object object, String datePattern) {
        String jsonString = null;
        try {
            jsonString = obtainObjectMapper(datePattern).writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonString;
    }

    public static <T> T readValue(String content, Class<T> clazz) {
        return readValue(content, clazz, Constants.DEFAULT_DATE_PATTERN);
    }

    public static <T> T readValue(String content, Class<T> clazz, String datePattern) {
        T t = null;
        try {
            t = obtainObjectMapper(datePattern).readValue(content, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
