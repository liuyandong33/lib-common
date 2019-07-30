package build.dream.common.utils;

import build.dream.common.annotations.JsonSchema;
import build.dream.common.constants.ErrorConstants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.exceptions.Error;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.AnnotationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class ValidateUtils {
    private static Validator validator;
    private static MessageSource messageSource;

    private static Validator obtainValidator() {
        if (validator == null) {
            validator = ApplicationHandler.obtainValidator();
        }
        return validator;
    }

    private static MessageSource obtainMessageSource() {
        if (messageSource == null) {
            messageSource = ApplicationHandler.obtainMessageSource();
        }
        return messageSource;
    }

    public static List<Field> obtainAllFields(Class<?> modelClass) {
        List<Field> allFields = new ArrayList<Field>();
        while (modelClass != Object.class) {
            Field[] fields = modelClass.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }
                allFields.add(field);
            }
            modelClass = modelClass.getSuperclass();
        }

        return allFields;
    }

    public static boolean validate(Object model) {
        Class<?> modelClass = model.getClass();
        JsonSchema jsonSchema = AnnotationUtils.findAnnotation(modelClass, JsonSchema.class);
        if (jsonSchema != null) {
            return ValidateUtils.isRightJson(JacksonUtils.writeValueAsString(model), jsonSchema.value());
        }
        Validator validator = obtainValidator();
        List<Field> allFields = obtainAllFields(modelClass);
        for (Field field : allFields) {
            Iterator<ConstraintViolation<Object>> iterator = validator.validateProperty(model, field.getName()).iterator();
            if (iterator.hasNext()) {
                return false;
            }
        }
        return true;
    }

    public static void validateAndThrow(Object model) {
        Class<?> modelClass = model.getClass();
        JsonSchema jsonSchema = AnnotationUtils.findAnnotation(modelClass, JsonSchema.class);
        if (jsonSchema != null) {
            JsonSchemaValidateUtils.validateAndThrow(JacksonUtils.writeValueAsString(model), jsonSchema.value());
        }
        Validator validator = obtainValidator();
        List<Field> allFields = obtainAllFields(modelClass);
        String modelClassName = modelClass.getName();
        for (Field field : allFields) {
            String fieldName = field.getName();
            Iterator<ConstraintViolation<Object>> iterator = validator.validateProperty(model, fieldName).iterator();
            if (iterator.hasNext()) {
                ConstraintViolation<Object> constraintViolation = iterator.next();
                String message = constraintViolation.getMessage();
                if (StringUtils.isBlank(message)) {
                    Locale locale = LocaleContextHolder.getLocale();
                    String annotationSimpleName = constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
                    String defaultMessage = ApplicationHandler.obtainParameterErrorMessage(fieldName);
                    message = obtainMessageSource().getMessage(modelClassName + "." + fieldName + "." + annotationSimpleName, null, defaultMessage, locale);
                }
                throw new CustomException(message, ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
            }
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new CustomException(message);
        }
    }

    public static void isTrue(boolean expression, String message, String code) {
        if (!expression) {
            throw new CustomException(message, code);
        }
    }

    public static void isTrue(boolean expression, Error error) {
        if (!expression) {
            throw new CustomException(error);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new CustomException(message);
        }
    }

    public static void notNull(Object object, String message, String code) {
        if (object == null) {
            throw new CustomException(message, code);
        }
    }

    public static void notNull(Object object, Error error) {
        if (object == null) {
            throw new CustomException(error);
        }
    }

    public static void notBlank(String string, String message) {
        if (StringUtils.isBlank(string)) {
            throw new CustomException(message);
        }
    }

    public static void notBlank(String string, String message, String code) {
        if (StringUtils.isBlank(string)) {
            throw new CustomException(message, code);
        }
    }

    public static void notBlank(String string, Error error) {
        if (StringUtils.isBlank(string)) {
            throw new CustomException(error);
        }
    }

    public static void notEmpty(Object[] array, String message) {
        if (ArrayUtils.isEmpty(array)) {
            throw new CustomException(message);
        }
    }

    public static void notEmpty(Object[] array, String message, String code) {
        if (ArrayUtils.isEmpty(array)) {
            throw new CustomException(message, code);
        }
    }

    public static void notEmpty(Object[] array, Error error) {
        if (ArrayUtils.isEmpty(array)) {
            throw new CustomException(error);
        }
    }

    public static void notEmpty(Collection collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new CustomException(message);
        }
    }

    public static void notEmpty(Collection collection, String message, String code) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new CustomException(message, code);
        }
    }

    public static void notEmpty(Collection collection, Error error) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new CustomException(error);
        }
    }

    public static void notEmpty(Map map, String message) {
        if (MapUtils.isEmpty(map)) {
            throw new CustomException(message);
        }
    }

    public static void notEmpty(Map map, String message, String code) {
        if (MapUtils.isEmpty(map)) {
            throw new CustomException(message, code);
        }
    }

    public static void notEmpty(Map map, Error error) {
        if (MapUtils.isEmpty(map)) {
            throw new CustomException(error);
        }
    }

    public static void notEmpty(String string, String message) {
        if (StringUtils.isEmpty(string)) {
            throw new CustomException(message);
        }
    }

    public static void notEmpty(String string, String message, String code) {
        if (StringUtils.isEmpty(string)) {
            throw new CustomException(message, code);
        }
    }

    public static void notEmpty(String string, Error error) {
        if (StringUtils.isEmpty(string)) {
            throw new CustomException(error);
        }
    }

    public static void inArray(Object[] array, Object value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Object[] array, Object value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Object[] array, Object value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void inArray(Long[] array, Long value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Long[] array, Long value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Long[] array, Long value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void inArray(Integer[] array, Integer value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Integer[] array, Integer value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Integer[] array, Integer value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void inArray(Short[] array, Short value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Short[] array, Short value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Short[] array, Short value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void inArray(Character[] array, Character value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Character[] array, Character value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Character[] array, Character value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void inArray(Byte[] array, Byte value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Byte[] array, Byte value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Byte[] array, Byte value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void inArray(Double[] array, Double value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Double[] array, Double value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Double[] array, Double value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void inArray(Float[] array, Float value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Float[] array, Float value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Float[] array, Float value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void inArray(Boolean[] array, Boolean value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }

    public static void inArray(Boolean[] array, Boolean value, String message, String code) {
        isTrue(ArrayUtils.contains(array, value), message, code);
    }

    public static void inArray(Boolean[] array, Boolean value, Error error) {
        isTrue(ArrayUtils.contains(array, value), error);
    }

    public static void noNullElements(Object[] array, String message) {
        notNull(array, message);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new CustomException(message);
            }
        }
    }

    public static void noNullElements(Object[] array, String message, String code) {
        notNull(array, message, code);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new CustomException(message);
            }
        }
    }

    public static void noNullElements(Object[] array, Error error) {
        notNull(array, error);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new CustomException(error);
            }
        }
    }

    public static void noNullElements(Collection collection, String message) {
        notNull(collection, message);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (it.next() == null) {
                throw new CustomException(message);
            }
        }
    }

    public static void noNullElements(Collection collection, String message, String code) {
        notNull(collection, message, code);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (it.next() == null) {
                throw new CustomException(message, code);
            }
        }
    }

    public static void noNullElements(Collection collection, Error error) {
        notNull(collection, error);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (it.next() == null) {
                throw new CustomException(error);
            }
        }
    }

    public static void allElementsOfType(Collection collection, Class clazz, String message) {
        notNull(collection, message);
        notNull(clazz, message);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (!clazz.isInstance(it.next())) {
                throw new CustomException(message);
            }
        }
    }

    public static void allElementsOfType(Collection collection, Class clazz, String message, String code) {
        notNull(collection, message, code);
        notNull(clazz, message, code);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (!clazz.isInstance(it.next())) {
                throw new CustomException(message, code);
            }
        }
    }

    public static void allElementsOfType(Collection collection, Class clazz, Error error) {
        notNull(collection, error);
        notNull(clazz, error);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (!clazz.isInstance(it.next())) {
                throw new CustomException(error);
            }
        }
    }

    public static boolean isRightJson(String jsonString, String schemaFilePath) {
        return JsonSchemaValidateUtils.validate(jsonString, schemaFilePath);
    }

    public static boolean isJson(String jsonString) {
        if (StringUtils.isBlank(jsonString)) {
            return false;
        }
        return (jsonString.startsWith("{") && jsonString.endsWith("}")) || (jsonString.startsWith("[") && jsonString.endsWith("]"));
    }
}
