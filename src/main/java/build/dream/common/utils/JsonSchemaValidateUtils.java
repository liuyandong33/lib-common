package build.dream.common.utils;

import build.dream.common.constants.ErrorConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.JsonValidator;
import com.networknt.schema.ValidationMessage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class JsonSchemaValidateUtils {
    public static JsonSchemaFactory jsonSchemaFactory = null;
    public static Map<String, Map<String, JsonValidator>> validatorsMap = null;
    private static ObjectMapper objectMapper = null;

    private static ObjectMapper obtainObjectMapper() {
        if (Objects.isNull(objectMapper)) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }

    public static JsonSchemaFactory obtainJsonSchemaFactory() {
        if (Objects.isNull(jsonSchemaFactory)) {
            jsonSchemaFactory = JsonSchemaFactory.getInstance();
        }
        return jsonSchemaFactory;
    }

    public static Map<String, JsonValidator> obtainValidators(String schemaFilePath) {
        if (Objects.isNull(validatorsMap)) {
            validatorsMap = new ConcurrentHashMap<String, Map<String, JsonValidator>>();
        }

        Map<String, JsonValidator> validators = validatorsMap.get(schemaFilePath);
        if (Objects.isNull(validators)) {
            try {
                InputStream inputStream = JsonSchemaValidateUtils.class.getClassLoader().getResourceAsStream(schemaFilePath);
                JsonSchema jsonSchema = obtainJsonSchemaFactory().getSchema(inputStream);
                Class<JsonSchema> jsonSchemaClass = JsonSchema.class;
                Field field = jsonSchemaClass.getDeclaredField("validators");
                field.setAccessible(true);
                validators = (Map<String, JsonValidator>) field.get(jsonSchema);
                validatorsMap.put(schemaFilePath, validators);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return validators;
    }

    public static void validateAndThrow(String jsonString, String schemaFilePath) {
        Map<String, JsonValidator> validators = obtainValidators(schemaFilePath);
        if (MapUtils.isNotEmpty(validators)) {
            JsonNode jsonNode = null;
            try {
                jsonNode = obtainObjectMapper().readTree(jsonString);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (JsonValidator validator : validators.values()) {
                Set<ValidationMessage> errors = validator.validate(jsonNode);
                ValidateUtils.isTrue(CollectionUtils.isEmpty(errors), ErrorConstants.INVALID_PARAMETER_ERROR);
            }
        }
    }

    public static boolean validate(String jsonString, String schemaFilePath) {
        Map<String, JsonValidator> validators = obtainValidators(schemaFilePath);
        if (MapUtils.isNotEmpty(validators)) {
            JsonNode jsonNode = null;
            try {
                jsonNode = obtainObjectMapper().readTree(jsonString);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (JsonValidator validator : validators.values()) {
                Set<ValidationMessage> errors = validator.validate(jsonNode);
                if (CollectionUtils.isNotEmpty(errors)) {
                    return false;
                }
            }
        }
        return true;
    }
}
