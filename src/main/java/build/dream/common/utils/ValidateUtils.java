package build.dream.common.utils;

import build.dream.common.exceptions.ApiException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

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
        String modelClassName = model.getClass().getName();
        Locale locale = LocaleContextHolder.getLocale();
        for (Field field : allFields) {
            String fieldName = field.getName();
            Iterator<ConstraintViolation<Object>> iterator = validator.validateProperty(model, field.getName()).iterator();
            if (iterator.hasNext()) {
                ConstraintViolation<Object> constraintViolation = iterator.next();
                String annotationSimpleName = constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
                String defaultMessage = ApplicationHandler.obtainParameterErrorMessage(fieldName);
                String message = obtainMessageSource().getMessage(modelClassName + "." + field.getName() + "." + annotationSimpleName, null, defaultMessage, locale);
                throw new ApiException(message);
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

    public static void noNullElements(Object[] array, String message) {
        notNull(array, message);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new ApiException(message);
            }
        }
    }

    public static void noNullElements(Collection collection, String message) {
        notNull(collection, message);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (it.next() == null) {
                throw new ApiException(message);
            }
        }
    }

    public static void allElementsOfType(Collection collection, Class clazz, String message) {
        notNull(collection, message);
        notNull(clazz, message);
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            if (!clazz.isInstance(it.next())) {
                throw new ApiException(message);
            }
        }
    }
}
