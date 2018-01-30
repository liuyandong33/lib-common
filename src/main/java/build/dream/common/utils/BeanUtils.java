package build.dream.common.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class BeanUtils {
    public static Map<String, Object> beanToMap(Object object) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }
                ReflectionUtils.makeAccessible(field);
                map.put(field.getName(), ReflectionUtils.getField(field, object));
            }
        }
        return map;
    }

    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) throws IllegalAccessException, InstantiationException {
        T t = beanClass.newInstance();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                continue;
            }
            ReflectionUtils.makeAccessible(field);
            String fieldName = field.getName();
            Object fieldValue = map.get(fieldName);
            if (fieldValue != null) {
                field.set(t, map.get(field.getName()));
            }
        }
        return t;
    }
}
