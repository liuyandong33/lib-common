package build.dream.common.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class BeanUtils {
    public static Map<String, Object> beanToMap(Object object) {
        Class<?> beanClass = object.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (Field field : fields) {
            ReflectionUtils.makeAccessible(field);
            map.put(field.getName(), ReflectionUtils.getField(field, object));
        }
        return map;
    }

    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) throws IllegalAccessException, InstantiationException {
        T t = beanClass.newInstance();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
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
