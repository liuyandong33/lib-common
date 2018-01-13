package build.dream.common.utils;

import build.dream.common.annotations.Transient;
import build.dream.common.annotations.XmlSerializedName;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BeanUtils {
    public static Map<String, Object> beanToMap(Object object) {
        return beanToMap(object, false);
    }
    public static Map<String, Object> beanToMap(Object object, boolean isXml) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }
                String fieldName = null;
                if (isXml) {
                    XmlSerializedName xmlSerializedName = field.getAnnotation(XmlSerializedName.class);
                    if (xmlSerializedName != null) {
                        fieldName = xmlSerializedName.value();
                    } else {
                        fieldName = field.getName();
                    }
                } else {
                    fieldName = field.getName();
                }
                ReflectionUtils.makeAccessible(field);
                map.put(fieldName, ReflectionUtils.getField(field, object));
            }
        }
        return map;
    }

    public static Map<String, String> beanToMap(Object object, boolean includeNull, boolean isXml) {
        Map<String, Object> map = beanToMap(object, isXml);
        Map<String, String> returnMap = new HashMap<String, String>();
        if (includeNull) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    returnMap.put(key, value.toString());
                } else {
                    returnMap.put(key, null);
                }
            }
        } else {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    returnMap.put(entry.getKey(), value.toString());
                }
            }
        }
        return returnMap;
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

    public static String generateInsertSql(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder insertSql = new StringBuilder("INSERT INTO ");
        String classSimpleName = clazz.getSimpleName();
        insertSql.append(NamingStrategyUtils.camelCaseToUnderscore(classSimpleName.substring(0, 1).toLowerCase() + classSimpleName.substring(1)));
        insertSql.append("(");
        StringBuilder valuesSql = new StringBuilder(" VALUES (");
        while (clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers) || field.getAnnotation(Transient.class) != null) {
                    continue;
                }
                String fieldName = field.getName();
                if ("id".equals(fieldName) || "createTime".equals(fieldName) || "lastUpdateTime".equals(fieldName) || "deleted".equals(fieldName)) {
                    continue;
                }
                insertSql.append(NamingStrategyUtils.camelCaseToUnderscore(fieldName));
                insertSql.append(", ");
                valuesSql.append("#{").append(fieldName);
                valuesSql.append("}, ");
            }
            clazz = clazz.getSuperclass();
        }
        insertSql.deleteCharAt(insertSql.length() - 1);
        insertSql.deleteCharAt(insertSql.length() - 1);
        insertSql.append(")");
        valuesSql.deleteCharAt(valuesSql.length() - 1);
        valuesSql.deleteCharAt(valuesSql.length() - 1);
        valuesSql.append(")");
        insertSql.append(valuesSql);
        return insertSql.toString();
    }

    public static String[] generateInsertAllSql(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder insertSql = new StringBuilder("INSERT INTO ");
        String classSimpleName = clazz.getSimpleName();
        insertSql.append(NamingStrategyUtils.camelCaseToUnderscore(classSimpleName.substring(0, 1).toLowerCase() + classSimpleName.substring(1)));
        insertSql.append("(");
        StringBuilder valuesSql = new StringBuilder("(");
        while (clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers) || field.getAnnotation(Transient.class) != null) {
                    continue;
                }
                String fieldName = field.getName();
                if ("id".equals(fieldName) || "createTime".equals(fieldName) || "lastUpdateTime".equals(fieldName) || "deleted".equals(fieldName)) {
                    continue;
                }
                insertSql.append(NamingStrategyUtils.camelCaseToUnderscore(fieldName));
                insertSql.append(", ");
                valuesSql.append("#{item.").append(fieldName);
                valuesSql.append("}, ");
            }
            clazz = clazz.getSuperclass();
        }
        insertSql.deleteCharAt(insertSql.length() - 1);
        insertSql.deleteCharAt(insertSql.length() - 1);
        insertSql.append(") VALUES ");
        valuesSql.deleteCharAt(valuesSql.length() - 1);
        valuesSql.deleteCharAt(valuesSql.length() - 1);
        valuesSql.append(")");
        return new String[]{insertSql.toString(), valuesSql.toString()};
    }

    public static String generateUpdateSql(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder updateSql = new StringBuilder("UPDATE ");
        String classSimpleName = clazz.getSimpleName();
        updateSql.append(NamingStrategyUtils.camelCaseToUnderscore(classSimpleName.substring(0, 1).toLowerCase() + classSimpleName.substring(1)));
        updateSql.append(" SET ");
        while (clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers) || field.getAnnotation(Transient.class) != null) {
                    continue;
                }
                String fieldName = field.getName();
                if ("createTime".equals(fieldName) || "lastUpdateTime".equals(fieldName)) {
                    continue;
                }
                updateSql.append(NamingStrategyUtils.camelCaseToUnderscore(fieldName));
                updateSql.append(" = ");
                updateSql.append("#{");
                updateSql.append(fieldName);
                updateSql.append("}, ");
            }
            clazz = clazz.getSuperclass();
        }
        updateSql.deleteCharAt(updateSql.length() - 1);
        updateSql.deleteCharAt(updateSql.length() - 1);
        updateSql.append(" WHERE id = #{id}");
        return updateSql.toString();
    }
}
