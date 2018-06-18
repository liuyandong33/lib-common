package build.dream.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class Builder {
    private Map<String, Object> fieldMap = new HashMap<String, Object>();

    public Builder addField(String fieldName, Object fieldValue) {
        fieldMap.put(fieldName, fieldValue);
        return this;
    }

    public <T> T build(Class<T> beanClass) throws IllegalAccessException, InstantiationException {
        T t = beanClass.newInstance();
        Field[] fields = beanClass.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                continue;
            }
            field.setAccessible(true);
            field.set(t, fieldMap.get(field.getName()));
        }
        return t;
    }
}
