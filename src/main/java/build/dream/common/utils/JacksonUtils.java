package build.dream.common.utils;

import build.dream.common.constants.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class JacksonUtils {
    private static ObjectMapper objectMapper = null;

    public static ObjectMapper obtainObjectMapper(String datePattern) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        objectMapper.setDateFormat(new SimpleDateFormat(datePattern));
        return objectMapper;
    }

    public static String writeValueAsString(Object object) throws JsonProcessingException {
        return writeValueAsString(object, Constants.DEFAULT_DATE_PATTERN);
    }

    public static String writeValueAsString(Object object, String datePattern) throws JsonProcessingException {
        return obtainObjectMapper(datePattern).writeValueAsString(object);
    }

    public static <T> T readValue(String content, Class<T> clazz) throws IOException {
        return readValue(content, clazz, Constants.DEFAULT_DATE_PATTERN);
    }

    public static <T> T readValue(String content, Class<T> clazz, String datePattern) throws IOException {
        return obtainObjectMapper(datePattern).readValue(content, clazz);
    }
}
