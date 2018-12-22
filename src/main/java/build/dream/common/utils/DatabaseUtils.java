package build.dream.common.utils;

import build.dream.common.annotations.Column;
import build.dream.common.annotations.ShardingColumn;
import build.dream.common.annotations.Table;
import build.dream.common.annotations.Transient;
import build.dream.common.constants.Constants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseUtils {
    private static final Map<String, String> DOMAIN_CLASS_NAME_INSERT_SQL_MAP = new ConcurrentHashMap<String, String>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_INSERT_SQL_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<String, String[]> DOMAIN_CLASS_NAME_INSERT_ALL_SQL_MAP = new ConcurrentHashMap<String, String[]>();
    private static final Map<Class<?>, String[]> DOMAIN_CLASS_INSERT_ALL_SQL_MAP = new ConcurrentHashMap<Class<?>, String[]>();
    private static final Map<String, String> DOMAIN_CLASS_NAME_UPDATE_SQL_MAP = new ConcurrentHashMap<String, String>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_UPDATE_SQL_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<String, String> DOMAIN_CLASS_NAME_SELECT_SQL_MAP = new ConcurrentHashMap<String, String>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_SELECT_SQL_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, List<String>> DOMAIN_CLASS_ALIAS_MAP = new ConcurrentHashMap<Class<?>, List<String>>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_TABLE_NAME_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final String DATABASE_PROVIDER = ConfigurationUtils.getConfiguration(Constants.DATABASE_PROVIDER);
    private static final String NEXT_VALUE_FOR_MYCATSEQ_GLOBAL = "NEXT VALUE FOR MYCATSEQ_GLOBAL";

    public static String generateInsertSql(String domainClassName) {
        return generateInsertSql(domainClassName, null);
    }

    public static String generateInsertSql(String domainClassName, String tableName) {
        String insertSql = DOMAIN_CLASS_NAME_INSERT_SQL_MAP.get(domainClassName);
        if (StringUtils.isBlank(insertSql)) {
            Class<?> domainClass = null;
            try {
                domainClass = Class.forName(domainClassName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            insertSql = doGenerateInsertSql(domainClass, tableName);
            DOMAIN_CLASS_NAME_INSERT_SQL_MAP.put(domainClassName, insertSql);
        }
        return insertSql;
    }

    public static String generateInsertSql(Class<?> domainClass) {
        return generateInsertSql(domainClass, null);
    }

    public static String generateInsertSql(Class<?> domainClass, String tableName) {
        String insertSql = DOMAIN_CLASS_INSERT_SQL_MAP.get(domainClass);
        if (StringUtils.isBlank(insertSql)) {
            insertSql = doGenerateInsertSql(domainClass, tableName);
            DOMAIN_CLASS_INSERT_SQL_MAP.put(domainClass, insertSql);
        }
        return insertSql;
    }

    private static String doGenerateInsertSql(Class<?> domainClass, String tableName) {
        StringBuilder insertSql = new StringBuilder("INSERT INTO ");
        insertSql.append(obtainTableName(tableName, domainClass));
        insertSql.append("(");
        StringBuilder valuesSql = new StringBuilder(" VALUES (");

        Class<?> clazz = domainClass;
        while (clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }

                if (field.getAnnotation(Transient.class) != null) {
                    continue;
                }

                String fieldName = field.getName();
                if ("createdTime".equals(fieldName) || "updatedTime".equals(fieldName) || "deletedTime".equals(fieldName) || "deleted".equals(fieldName)) {
                    continue;
                }

                if ("id".equals(fieldName)) {
                    if (DATABASE_PROVIDER.equals(Constants.DATABASE_PROVIDER_MYSQL)) {
                        continue;
                    } else if (DATABASE_PROVIDER.equals(Constants.DATABASE_PROVIDER_ORACLE)) {

                    } else if (DATABASE_PROVIDER.equals(Constants.DATABASE_PROVIDER_MYCAT)) {
                        insertSql.append("id");
                        insertSql.append(", ");
                        valuesSql.append(NEXT_VALUE_FOR_MYCATSEQ_GLOBAL).append(", ");
                    }
                } else {
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

    public static String[] generateInsertAllSql(String domainClassName) {
        return generateInsertAllSql(domainClassName, null);
    }

    public static String[] generateInsertAllSql(String domainClassName, String tableName) {
        String[] insertAllSql = DOMAIN_CLASS_NAME_INSERT_ALL_SQL_MAP.get(domainClassName);
        if (ArrayUtils.isEmpty(insertAllSql)) {
            Class<?> domainClass = null;
            try {
                domainClass = Class.forName(domainClassName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            insertAllSql = doGenerateInsertAllSql(domainClass, tableName);
            DOMAIN_CLASS_NAME_INSERT_ALL_SQL_MAP.put(domainClassName, insertAllSql);
        }
        return insertAllSql;
    }

    public static String[] generateInsertAllSql(List<?> domains) {
        return generateInsertAllSql(domains.get(0).getClass(), null);
    }

    public static String[] generateInsertAllSql(Class<?> domainClass) {
        return generateInsertAllSql(domainClass, null);
    }

    public static String[] generateInsertAllSql(List<?> domains, String tableName) {
        return generateInsertAllSql(domains.get(0).getClass(), tableName);
    }

    public static String[] generateInsertAllSql(Class<?> domainClass, String tableName) {
        String[] insertAllSql = DOMAIN_CLASS_INSERT_ALL_SQL_MAP.get(domainClass);
        if (ArrayUtils.isEmpty(insertAllSql)) {
            insertAllSql = doGenerateInsertAllSql(domainClass, tableName);
            DOMAIN_CLASS_INSERT_ALL_SQL_MAP.put(domainClass, insertAllSql);
        }
        return insertAllSql;
    }

    private static String[] doGenerateInsertAllSql(Class<?> domainClass, String tableName) {
        StringBuilder insertSql = new StringBuilder("INSERT INTO ");
        insertSql.append(obtainTableName(tableName, domainClass));
        insertSql.append("(");
        StringBuilder valuesSql = new StringBuilder("(");

        Class<?> clazz = domainClass;
        while (clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }

                if (field.getAnnotation(Transient.class) != null) {
                    continue;
                }

                String fieldName = field.getName();
                if ("createdTime".equals(fieldName) || "updatedTime".equals(fieldName) || "deletedTime".equals(fieldName) || "deleted".equals(fieldName)) {
                    continue;
                }

                if ("id".equals(fieldName)) {
                    if (DATABASE_PROVIDER.equals(Constants.DATABASE_PROVIDER_MYSQL)) {

                    } else if (DATABASE_PROVIDER.equals(Constants.DATABASE_PROVIDER_ORACLE)) {

                    } else if (DATABASE_PROVIDER.equals(Constants.DATABASE_PROVIDER_MYCAT)) {
                        insertSql.append("id");
                        insertSql.append(", ");
                        valuesSql.append(NEXT_VALUE_FOR_MYCATSEQ_GLOBAL).append(", ");
                    }
                } else {
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

    public static String generateUpdateSql(String domainClassName) {
        return generateUpdateSql(domainClassName, null);
    }

    public static String generateUpdateSql(String domainClassName, String tableName) {
        String updateSql = DOMAIN_CLASS_NAME_UPDATE_SQL_MAP.get(domainClassName);
        if (StringUtils.isBlank(updateSql)) {
            Class<?> domainClass = null;
            try {
                domainClass = Class.forName(domainClassName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            updateSql = doGenerateUpdateSql(domainClass, tableName);
            DOMAIN_CLASS_NAME_UPDATE_SQL_MAP.put(domainClassName, updateSql);
        }
        return updateSql;
    }

    public static String generateUpdateSql(Class<?> domainClass) {
        return generateUpdateSql(domainClass, null);
    }

    public static String generateUpdateSql(Class<?> domainClass, String tableName) {
        String updateSql = DOMAIN_CLASS_UPDATE_SQL_MAP.get(domainClass);
        if (StringUtils.isBlank(updateSql)) {
            updateSql = doGenerateUpdateSql(domainClass, tableName);
            DOMAIN_CLASS_UPDATE_SQL_MAP.put(domainClass, updateSql);
        }
        return updateSql;
    }

    private static String doGenerateUpdateSql(Class<?> domainClass, String tableName) {
        StringBuilder updateSql = new StringBuilder("UPDATE ");
        updateSql.append(obtainTableName(tableName, domainClass));
        updateSql.append(" SET ");

        Class<?> clazz = domainClass;
        while (clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }

                if (field.getAnnotation(Transient.class) != null) {
                    continue;
                }

                String fieldName = field.getName();
                if ("id".equals(fieldName) || "createdTime".equals(fieldName) || "updatedTime".equals(fieldName)) {
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

        ShardingColumn shardingColumn = AnnotationUtils.findAnnotation(domainClass, ShardingColumn.class);
        if (shardingColumn != null) {
            updateSql.append(" AND ").append(shardingColumn.columnName()).append(" = ").append("#{").append(shardingColumn.fieldName()).append("}");
        }
        return updateSql.toString();
    }

    public static String generateSelectSql(String domainClassName) {
        return generateSelectSql(domainClassName, null);
    }

    public static String generateSelectSql(String domainClassName, String tableName) {
        String selectSql = DOMAIN_CLASS_NAME_SELECT_SQL_MAP.get(domainClassName);
        if (StringUtils.isBlank(selectSql)) {
            Class<?> domainClass = null;
            try {
                domainClass = Class.forName(domainClassName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            selectSql = doGenerateSelectSql(domainClass, tableName);
            DOMAIN_CLASS_NAME_SELECT_SQL_MAP.put(domainClassName, selectSql);
        }
        return selectSql;
    }

    public static String generateSelectSql(Class<?> domainClass) {
        return generateSelectSql(domainClass, null);
    }

    public static String generateSelectSql(Class<?> domainClass, String tableName) {
        String selectSql = DOMAIN_CLASS_SELECT_SQL_MAP.get(domainClass);
        if (StringUtils.isBlank(selectSql)) {
            selectSql = doGenerateSelectSql(domainClass, tableName);
            DOMAIN_CLASS_SELECT_SQL_MAP.put(domainClass, selectSql);
        }
        return selectSql;
    }

    private static String doGenerateSelectSql(Class<?> domainClass, String tableName) {
        List<String> alias = obtainAllAlias(domainClass);

        StringBuilder selectSql = new StringBuilder("SELECT ");
        selectSql.append(StringUtils.join(alias, ", "));
        selectSql.append(" FROM ");
        selectSql.append(obtainTableName(tableName, domainClass));
        return selectSql.toString();
    }

    public static List<String> obtainAllAlias(Class<?> domainClass) {
        List<String> alias = DOMAIN_CLASS_ALIAS_MAP.get(domainClass);
        if (CollectionUtils.isEmpty(alias)) {
            alias = doObtainAllAlias(domainClass);
            DOMAIN_CLASS_ALIAS_MAP.put(domainClass, alias);
        }
        return alias;
    }

    private static List<String> doObtainAllAlias(Class<?> domainClass) {
        List<String> alias = new ArrayList<String>();
        while (domainClass != Object.class) {
            Field[] fields = domainClass.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }

                if (field.getAnnotation(Transient.class) != null) {
                    continue;
                }

                String fieldName = field.getName();

                String underscoreName = NamingStrategyUtils.camelCaseToUnderscore(fieldName);
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    alias.add(column.name() + " AS " + underscoreName);
                } else {
                    alias.add(underscoreName);
                }
            }
            domainClass = domainClass.getSuperclass();
        }
        return alias;
    }

    public static String obtainTableName(String tableName, Class<?> domainClass) {
        if (StringUtils.isNotBlank(tableName)) {
            return tableName;
        }
        return obtainTableName(domainClass);
    }

    public static String obtainTableName(Class<?> domainClass) {
        String tableName = DOMAIN_CLASS_TABLE_NAME_MAP.get(domainClass);
        if (StringUtils.isBlank(tableName)) {
            Table table = AnnotationUtils.findAnnotation(domainClass, Table.class);
            if (table != null) {
                tableName = table.name();
            } else {
                String simpleName = domainClass.getSimpleName();
                tableName = NamingStrategyUtils.camelCaseToUnderscore(simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1));
            }
            DOMAIN_CLASS_TABLE_NAME_MAP.put(domainClass, tableName);
        }
        return tableName;
    }

    public static String obtainWhereClause(String sqlFragment) {
        return sqlFragment.replaceAll("#\\{", "#{namedParameters.");
    }
}
