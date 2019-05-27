package build.dream.common.utils;

import build.dream.common.annotations.*;
import build.dream.common.constants.Constants;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseUtils {
    private static final Map<Class<?>, String> DOMAIN_CLASS_INSERT_SQL_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, String[]> DOMAIN_CLASS_INSERT_ALL_SQL_MAP = new ConcurrentHashMap<Class<?>, String[]>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_UPDATE_SQL_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_TABLE_NAME_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_COLUMNS_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, GeneratedValue> DOMAIN_CLASS_GENERATED_VALUE_MAP = new ConcurrentHashMap<Class<?>, GeneratedValue>();
    private static final Map<Class<?>, Field> DOMAIN_CLASS_ID_FIELD_MAP = new ConcurrentHashMap<Class<?>, Field>();
    //    private static final String PRIMARY_KEY_GENERATION_STRATEGY = ConfigurationUtils.getConfiguration(Constants.PRIMARY_KEY_GENERATION_STRATEGY);
    private static final String NEXT_VALUE_FOR_MYCATSEQ_GLOBAL = "NEXT VALUE FOR MYCATSEQ_GLOBAL";

    public static String generateInsertSql(Class<?> domainClass) {
        String insertSql = DOMAIN_CLASS_INSERT_SQL_MAP.get(domainClass);
        if (StringUtils.isBlank(insertSql)) {
            insertSql = doGenerateInsertSql(domainClass);
            DOMAIN_CLASS_INSERT_SQL_MAP.put(domainClass, insertSql);
        }
        return insertSql;
    }

    private static String doGenerateInsertSql(Class<?> domainClass) {
        StringBuilder insertSql = new StringBuilder("INSERT INTO ");
        insertSql.append(obtainTableName(domainClass));
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

                if (field.getAnnotation(InsertIgnore.class) != null) {
                    continue;
                }

                String fieldName = field.getName();
                Id id = field.getAnnotation(Id.class);
                if (id != null) {
                    GeneratedValue generatedValue = field.getAnnotation(GeneratedValue.class);
                    if (generatedValue != null) {
                        DOMAIN_CLASS_GENERATED_VALUE_MAP.put(domainClass, generatedValue);
                    }

                    GenerationType generationType = generatedValue.strategy();
                    switch (generationType) {
                        case AUTO_INCREMENT:
                            break;
                        case SQL:
                            insertSql.append(obtainColumnName(field));
                            insertSql.append(", ");
                            valuesSql.append("#{").append(fieldName);
                            valuesSql.append("}, ");
                            break;
                        case GENERATOR:
                            insertSql.append(obtainColumnName(field));
                            insertSql.append(", ");
                            valuesSql.append("#{").append(fieldName);
                            valuesSql.append("}, ");
                            break;
                        case UUID:
                            insertSql.append(obtainColumnName(field));
                            insertSql.append(", ");
                            valuesSql.append("#{").append(fieldName);
                            valuesSql.append("}, ");
                            break;
                        case MYCATSEQ_GLOBAL:
                            insertSql.append(obtainColumnName(field));
                            insertSql.append(", ");
                            valuesSql.append(NEXT_VALUE_FOR_MYCATSEQ_GLOBAL).append(", ");
                            break;
                    }
                    continue;
                }
                insertSql.append(obtainColumnName(field));
                insertSql.append(", ");
                valuesSql.append("#{item.").append(fieldName);
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

    public static String[] generateInsertAllSql(List<?> domains) {
        return generateInsertAllSql(domains.get(0).getClass());
    }

    public static String[] generateInsertAllSql(Class<?> domainClass) {
        String[] insertAllSql = DOMAIN_CLASS_INSERT_ALL_SQL_MAP.get(domainClass);
        if (ArrayUtils.isEmpty(insertAllSql)) {
            insertAllSql = doGenerateInsertAllSql(domainClass);
            DOMAIN_CLASS_INSERT_ALL_SQL_MAP.put(domainClass, insertAllSql);
        }
        return insertAllSql;
    }

    private static String[] doGenerateInsertAllSql(Class<?> domainClass) {
        StringBuilder insertSql = new StringBuilder("INSERT INTO ");
        insertSql.append(obtainTableName(domainClass));
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

                if (field.getAnnotation(InsertIgnore.class) != null) {
                    continue;
                }

                String fieldName = field.getName();
                Id id = field.getAnnotation(Id.class);
                if (id != null) {
                    GeneratedValue generatedValue = field.getAnnotation(GeneratedValue.class);
                    if (generatedValue != null) {
                        DOMAIN_CLASS_GENERATED_VALUE_MAP.put(domainClass, generatedValue);
                        DOMAIN_CLASS_ID_FIELD_MAP.put(domainClass, field);
                    }

                    GenerationType generationType = generatedValue.strategy();
                    switch (generationType) {
                        case AUTO_INCREMENT:
                            break;
                        case SQL:
                            insertSql.append(obtainColumnName(field));
                            insertSql.append(", ");
                            valuesSql.append("#{item.").append(fieldName);
                            valuesSql.append("}, ");
                            break;
                        case GENERATOR:
                            insertSql.append(obtainColumnName(field));
                            insertSql.append(", ");
                            valuesSql.append("#{item.").append(fieldName);
                            valuesSql.append("}, ");
                            break;
                        case UUID:
                            insertSql.append(obtainColumnName(field));
                            insertSql.append(", ");
                            valuesSql.append("#{item.").append(fieldName);
                            valuesSql.append("}, ");
                            break;
                        case MYCATSEQ_GLOBAL:
                            insertSql.append(obtainColumnName(field));
                            insertSql.append(", ");
                            valuesSql.append(NEXT_VALUE_FOR_MYCATSEQ_GLOBAL).append(", ");
                            break;

                    }
                    continue;
                }
                insertSql.append(obtainColumnName(field));
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

    public static String obtainColumnName(Field field) {
        Column column = field.getAnnotation(Column.class);
        if (column != null) {
            return column.name();
        }
        return NamingStrategyUtils.camelCaseToUnderscore(field.getName());
    }

    public static String generateUpdateSql(Class<?> domainClass) {
        String updateSql = DOMAIN_CLASS_UPDATE_SQL_MAP.get(domainClass);
        if (StringUtils.isBlank(updateSql)) {
            updateSql = doGenerateUpdateSql(domainClass);
            DOMAIN_CLASS_UPDATE_SQL_MAP.put(domainClass, updateSql);
        }
        return updateSql;
    }

    private static String doGenerateUpdateSql(Class<?> domainClass) {
        StringBuilder updateSql = new StringBuilder("UPDATE ");
        updateSql.append(obtainTableName(domainClass));
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

                if (field.getAnnotation(UpdateIgnore.class) != null) {
                    continue;
                }

                Id id = field.getAnnotation(Id.class);
                if (id != null) {
                    DOMAIN_CLASS_ID_FIELD_MAP.put(domainClass, field);
                    continue;
                }

                updateSql.append(obtainColumnName(field));
                updateSql.append(" = ");
                updateSql.append("#{");
                updateSql.append(field.getName());
                updateSql.append("}, ");
            }
            clazz = clazz.getSuperclass();
        }
        updateSql.deleteCharAt(updateSql.length() - 1);
        updateSql.deleteCharAt(updateSql.length() - 1);

        Field idField = DOMAIN_CLASS_ID_FIELD_MAP.get(domainClass);
        updateSql.append(" WHERE ");
        updateSql.append(obtainColumnName(idField));
        updateSql.append(" = #{");
        updateSql.append(idField.getName());
        updateSql.append("}");

        ShardingColumn shardingColumn = AnnotationUtils.findAnnotation(domainClass, ShardingColumn.class);
        if (shardingColumn != null) {
            updateSql.append(" AND ");
            updateSql.append(shardingColumn.columnName());
            updateSql.append(" = ");
            updateSql.append("#{");
            updateSql.append(shardingColumn.fieldName());
            updateSql.append("}");
        }
        return updateSql.toString();
    }

    private static List<String> obtainAllAlias(Class<?> domainClass) {
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

    public static String obtainColumns(Class<?> domainClass) {
        String columns = DOMAIN_CLASS_COLUMNS_MAP.get(domainClass);
        if (StringUtils.isBlank(columns)) {
            columns = StringUtils.join(obtainAllAlias(domainClass), ", ");
            DOMAIN_CLASS_COLUMNS_MAP.put(domainClass, columns);
        }
        return columns;
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

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
            }
        }
    }

    public static String obtainDatabaseId(Connection connection, boolean closeConnection) {
        String databaseId = null;
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            String databaseProductName = databaseMetaData.getDatabaseProductName();
            switch (databaseProductName) {
                case Constants.DATABASE_PRODUCT_NAME_MYSQL:
                    databaseId = Constants.DATABASE_ID_MYSQL;
                    break;
                case Constants.DATABASE_PRODUCT_NAME_ORACLE:
                    databaseId = Constants.DATABASE_ID_ORACLE;
                    break;
                case Constants.DATABASE_PRODUCT_NAME_MICROSOFT_SQL_SERVER:
                    databaseId = Constants.DATABASE_ID_SQL_SERVER;
                    break;
            }
        } catch (Exception e) {

        } finally {
            if (closeConnection) {
                closeConnection(connection);
            }
        }
        return databaseId;
    }

    public static Field obtainIdField(Class<?> domainClass) {
        Field idField = DOMAIN_CLASS_ID_FIELD_MAP.get(domainClass);
        if (idField == null) {
            idField = ReflectionUtils.findField(domainClass, field -> field.getAnnotation(Id.class) != null);
            if (idField != null) {
                DOMAIN_CLASS_ID_FIELD_MAP.put(domainClass, idField);
            }
        }
        return idField;
    }

    public static Field obtainIdField(Object object) {
        return obtainIdField(object.getClass());
    }

    public static GeneratedValue obtainGeneratedValue(Object object) {
        Class<?> domainClass = object.getClass();
        GeneratedValue generatedValue = DOMAIN_CLASS_GENERATED_VALUE_MAP.get(domainClass);
        if (generatedValue == null) {
            Field idField = obtainIdField(domainClass);
            generatedValue = idField.getAnnotation(GeneratedValue.class);
            if (generatedValue != null) {
                DOMAIN_CLASS_GENERATED_VALUE_MAP.put(domainClass, generatedValue);
                return generatedValue;
            }
        }
        return null;
    }
}
