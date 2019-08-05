package build.dream.common.utils;

import build.dream.common.annotations.*;
import build.dream.common.constants.Constants;
import build.dream.common.orm.GenerationStrategy;
import build.dream.common.orm.IdGenerator;
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
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseUtils {
    private static final Map<Class<?>, String> DOMAIN_CLASS_INSERT_SQL_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, String[]> DOMAIN_CLASS_INSERT_ALL_SQL_MAP = new ConcurrentHashMap<Class<?>, String[]>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_UPDATE_SQL_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_TABLE_NAME_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, String> DOMAIN_CLASS_COLUMNS_MAP = new ConcurrentHashMap<Class<?>, String>();
    private static final Map<Class<?>, Id> DOMAIN_CLASS_ID_ANNOTATION_MAP = new ConcurrentHashMap<Class<?>, Id>();
    private static final Map<Class<?>, Field> DOMAIN_CLASS_ID_FIELD_MAP = new ConcurrentHashMap<Class<?>, Field>();
    private static final Map<Class<?>, IdGenerator> ID_GENERATOR_CLASS_ID_GENERATOR_MAP = new ConcurrentHashMap<Class<?>, IdGenerator>();
    private static final String NEXT_VALUE_FOR_MYCATSEQ_GLOBAL = "NEXT VALUE FOR MYCATSEQ_GLOBAL";
    public static final ReentrantLock INSTANTIATE_ID_GENERATOR_REENTRANT_LOCK = new ReentrantLock();

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

                if (Objects.nonNull(field.getAnnotation(Transient.class))) {
                    continue;
                }

                if (Objects.nonNull(field.getAnnotation(InsertIgnore.class))) {
                    continue;
                }

                String fieldName = field.getName();
                Id id = field.getAnnotation(Id.class);
                if (Objects.nonNull(id)) {
                    DOMAIN_CLASS_ID_FIELD_MAP.put(domainClass, field);
                    DOMAIN_CLASS_ID_ANNOTATION_MAP.put(domainClass, id);
                    GenerationStrategy generationStrategy = id.strategy();
                    switch (generationStrategy) {
                        case AUTO_INCREMENT:
                            break;
                        case GENERATOR:
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
                valuesSql.append("#{");
                valuesSql.append(fieldName);
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

                if (Objects.nonNull(field.getAnnotation(Transient.class))) {
                    continue;
                }

                if (Objects.nonNull(field.getAnnotation(InsertIgnore.class))) {
                    continue;
                }

                String fieldName = field.getName();
                Id id = field.getAnnotation(Id.class);
                if (Objects.nonNull(id)) {
                    if (!DOMAIN_CLASS_ID_FIELD_MAP.containsKey(domainClass)) {
                        DOMAIN_CLASS_ID_FIELD_MAP.put(domainClass, field);
                    }

                    if (!DOMAIN_CLASS_ID_ANNOTATION_MAP.containsKey(domainClass)) {
                        DOMAIN_CLASS_ID_ANNOTATION_MAP.put(domainClass, id);
                    }
                    GenerationStrategy generationStrategy = id.strategy();
                    switch (generationStrategy) {
                        case AUTO_INCREMENT:
                            break;
                        case GENERATOR:
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
        if (Objects.nonNull(column)) {
            return column.name();
        }
        return NamingStrategyUtils.lowerCamelCaseToUnderscore(field.getName());
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

                if (Objects.nonNull(field.getAnnotation(Transient.class))) {
                    continue;
                }

                Id id = field.getAnnotation(Id.class);
                if (Objects.nonNull(id)) {
                    DOMAIN_CLASS_ID_FIELD_MAP.put(domainClass, field);
                    DOMAIN_CLASS_ID_ANNOTATION_MAP.put(domainClass, id);
                    continue;
                }

                if (Objects.nonNull(field.getAnnotation(UpdateIgnore.class))) {
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
        if (Objects.nonNull(shardingColumn)) {
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

                if (Objects.nonNull(field.getAnnotation(Transient.class))) {
                    continue;
                }

                String fieldName = field.getName();

                String underscoreName = NamingStrategyUtils.lowerCamelCaseToUnderscore(fieldName);
                Column column = field.getAnnotation(Column.class);
                if (Objects.nonNull(column)) {
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
            if (Objects.nonNull(table)) {
                tableName = table.name();
            } else {
                tableName = NamingStrategyUtils.upperCamelCaseToUnderscore(domainClass.getSimpleName());
            }
            DOMAIN_CLASS_TABLE_NAME_MAP.put(domainClass, tableName);
        }
        return tableName;
    }

    public static String obtainWhereClause(String sqlFragment) {
        return sqlFragment.replaceAll("#\\{", "#{namedParameters.");
    }

    public static void closeConnection(Connection connection) {
        if (Objects.nonNull(connection)) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (Objects.nonNull(statement)) {
            try {
                statement.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (Objects.nonNull(resultSet)) {
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
        if (Objects.nonNull(idField)) {
            return idField;
        }
        idField = ReflectionUtils.findField(domainClass, field -> Objects.nonNull(field.getAnnotation(Id.class)));
        if (Objects.nonNull(idField)) {
            DOMAIN_CLASS_ID_FIELD_MAP.put(domainClass, idField);
        }
        return idField;
    }

    public static Field obtainIdField(Object domain) {
        return obtainIdField(domain.getClass());
    }

    public static Id obtainIdAnnotation(Class<?> domainClass) {
        Id idAnnotation = DOMAIN_CLASS_ID_ANNOTATION_MAP.get(domainClass);
        if (Objects.nonNull(idAnnotation)) {
            return idAnnotation;
        }
        Field idField = obtainIdField(domainClass);
        if (Objects.isNull(idField)) {
            return null;
        }
        idAnnotation = idField.getAnnotation(Id.class);
        DOMAIN_CLASS_ID_ANNOTATION_MAP.put(domainClass, idAnnotation);
        return idAnnotation;
    }

    public static Id obtainIdAnnotation(Object domain) {
        return obtainIdAnnotation(domain.getClass());
    }

    public static IdGenerator obtainIdGenerator(Class<? extends IdGenerator> idGeneratorClass) {
        IdGenerator idGenerator = ID_GENERATOR_CLASS_ID_GENERATOR_MAP.get(idGeneratorClass);
        if (Objects.nonNull(idGenerator)) {
            return idGenerator;
        }
        INSTANTIATE_ID_GENERATOR_REENTRANT_LOCK.lock();
        try {
            idGenerator = ID_GENERATOR_CLASS_ID_GENERATOR_MAP.get(idGeneratorClass);
            if (Objects.isNull(idGenerator)) {
                idGenerator = idGeneratorClass.newInstance();
                ID_GENERATOR_CLASS_ID_GENERATOR_MAP.put(idGeneratorClass, idGenerator);
            }
            return idGenerator;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            INSTANTIATE_ID_GENERATOR_REENTRANT_LOCK.unlock();
        }
    }

    public static String obtainIdColumnName(Class<?> domainClass) {
        Field idField = obtainIdField(domainClass);
        return obtainColumnName(idField);
    }
}
