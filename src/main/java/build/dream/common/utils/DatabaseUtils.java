package build.dream.common.utils;

import build.dream.common.annotations.Column;
import build.dream.common.annotations.Transient;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class DatabaseUtils {
    public static String generateInsertSql(String className) {
        return generateInsertSql(className, null);
    }

    public static String generateInsertSql(String className, String tableName) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder insertSql = new StringBuilder("INSERT INTO ");
        if (StringUtils.isNotBlank(tableName)) {
            insertSql.append(tableName);
        } else {
            String classSimpleName = clazz.getSimpleName();
            insertSql.append(NamingStrategyUtils.camelCaseToUnderscore(classSimpleName.substring(0, 1).toLowerCase() + classSimpleName.substring(1)));
        }
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

                String columnName = null;
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    columnName = column.name();
                } else {
                    columnName = NamingStrategyUtils.camelCaseToUnderscore(fieldName);
                }
                insertSql.append(columnName);
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
        return generateInsertAllSql(className, null);
    }

    public static String[] generateInsertAllSql(String className, String tableName) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder insertSql = new StringBuilder("INSERT INTO ");
        if (StringUtils.isNotBlank(tableName)) {
            insertSql.append(tableName);
        } else {
            String classSimpleName = clazz.getSimpleName();
            insertSql.append(NamingStrategyUtils.camelCaseToUnderscore(classSimpleName.substring(0, 1).toLowerCase() + classSimpleName.substring(1)));
        }
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

                String columnName = null;
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    columnName = column.name();
                } else {
                    columnName = NamingStrategyUtils.camelCaseToUnderscore(fieldName);
                }
                insertSql.append(columnName);

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
        return generateUpdateSql(className, null);
    }

    public static String generateUpdateSql(String className, String tableName) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder updateSql = new StringBuilder("UPDATE ");
        if (StringUtils.isNotBlank(tableName)) {
            updateSql.append(tableName);
        } else {
            String classSimpleName = clazz.getSimpleName();
            updateSql.append(NamingStrategyUtils.camelCaseToUnderscore(classSimpleName.substring(0, 1).toLowerCase() + classSimpleName.substring(1)));
        }
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

                String columnName = null;
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    columnName = column.name();
                } else {
                    columnName = NamingStrategyUtils.camelCaseToUnderscore(fieldName);
                }
                updateSql.append(columnName);

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
