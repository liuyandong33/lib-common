package build.dream.common.utils;

import build.dream.common.exceptions.ApiException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class ValidateUtils {
    private static Validator validator;

    private static Validator obtainValidator() {
        if (validator == null) {
            validator = ApplicationHandler.obtainValidator();
        }
        return validator;
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
        Validator validator = obtainValidator();
        List<Field> allFields = obtainAllFields(model.getClass());
        for (Field field : allFields) {
            Iterator<ConstraintViolation<Object>> iterator = validator.validateProperty(model, field.getName()).iterator();
            if (iterator.hasNext()) {
                throw new ApiException(ApplicationHandler.obtainParameterErrorMessage(field.getName()));
            }
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new ApiException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new ApiException(message);
        }
    }

    public static void notBlank(String string, String message) {
        if (StringUtils.isBlank(string)) {
            throw new ApiException(message);
        }
    }

    public static void notEmpty(Object[] array, String message) {
        if (ArrayUtils.isEmpty(array)) {
            throw new ApiException(message);
        }
    }

    public static void notEmpty(Collection collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ApiException(message);
        }
    }

    public static void notEmpty(Map map, String message) {
        if (MapUtils.isEmpty(map)) {
            throw new ApiException(message);
        }
    }

    public static void notEmpty(String string, String message) {
        if (StringUtils.isEmpty(string)) {
            throw new ApiException(message);
        }
    }

    public static void inArray(Object[] array, Object value, String message) {
        isTrue(ArrayUtils.contains(array, value), message);
    }
}
