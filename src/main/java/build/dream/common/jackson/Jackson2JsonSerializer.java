package build.dream.common.jackson;

import build.dream.common.constants.Constants;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Jackson2JsonSerializer {
    private Map<String, ObjectMapper> objectMapperMap = new ConcurrentHashMap<String, ObjectMapper>();
    public SimpleModule simpleModule;

    public Jackson2JsonSerializer() {

    }

    public Jackson2JsonSerializer(SimpleModule simpleModule) {
        this.simpleModule = simpleModule;
    }

    private ObjectMapper obtainObjectMapper(String datePattern, JsonInclude.Include serializationInclusion) {
        String key = datePattern;
        if (Objects.nonNull(serializationInclusion)) {
            key += "@@@" + serializationInclusion.name();
        }

        ObjectMapper objectMapper = objectMapperMap.get(key);
        if (Objects.nonNull(objectMapper)) {
            return objectMapper;
        }

        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(datePattern));
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        if (Objects.nonNull(serializationInclusion)) {
            objectMapper.setSerializationInclusion(serializationInclusion);
        }

        if (Objects.nonNull(simpleModule)) {
            objectMapper.registerModule(simpleModule);
        }

        objectMapperMap.put(key, objectMapper);
        return objectMapper;
    }

    public String writeValueAsString(Object object) {
        return writeValueAsString(object, Constants.DEFAULT_DATE_PATTERN, null);
    }

    public String writeValueAsString(Object object, JsonInclude.Include serializationInclusion) {
        return writeValueAsString(object, Constants.DEFAULT_DATE_PATTERN, serializationInclusion);
    }

    public String writeValueAsString(Object object, String datePattern) {
        return writeValueAsString(object, datePattern, null);
    }

    public String writeValueAsString(Object object, String datePattern, JsonInclude.Include serializationInclusion) {
        return ApplicationHandler.callMethodSuppressThrow(() -> obtainObjectMapper(datePattern, serializationInclusion).writeValueAsString(object));
    }
}
