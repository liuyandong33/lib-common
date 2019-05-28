package build.dream.common.utils;

import build.dream.common.annotations.GeneratedValue;
import build.dream.common.annotations.GenerationType;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;
import build.dream.common.mappers.UniversalMapper;
import build.dream.common.orm.IdGenerator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.data.util.ReflectionUtils;
import scala.Tuple2;
import scala.Tuple3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;

public class UniversalDatabaseHelper {
    private static final String PRIMARY_KEY_GENERATION_STRATEGY = ConfigurationUtils.getConfiguration(Constants.PRIMARY_KEY_GENERATION_STRATEGY);

    static {
        ApplicationHandler.registerConverters();
    }

    public static long insert(UniversalMapper universalMapper, Object domain) {
        GeneratedValue generatedValue = DatabaseUtils.obtainGeneratedValue(domain);
        if (generatedValue == null) {
            return universalMapper.insertAutoIncrement(domain);
        }

        GenerationType generationType = generatedValue.strategy();
        switch (generationType) {
            case AUTO_INCREMENT:
                return universalMapper.insertAutoIncrement(domain);
            case SQL:
                return universalMapper.insertSelectKey(domain);
            case GENERATOR:
                IdGenerator idGenerator = DatabaseUtils.obtainIdGenerator(generatedValue.idGenerator());
                ReflectionUtils.setField(DatabaseUtils.obtainIdField(domain), domain, idGenerator.nextId());
                return universalMapper.insert(domain);
            case UUID:
                ReflectionUtils.setField(DatabaseUtils.obtainIdField(domain), domain, UUID.randomUUID().toString());
                return universalMapper.insert(domain);
            case MYCATSEQ_GLOBAL:
                return universalMapper.insert(domain);
        }
        throw new RuntimeException();
    }

    public static long insertAll(UniversalMapper universalMapper, List<? extends Object> domains) {
        Class<?> domainClass = domains.get(0).getClass();
        GeneratedValue generatedValue = DatabaseUtils.obtainGeneratedValue(domainClass);
        if (generatedValue == null) {
            return universalMapper.insertAllAutoIncrement(domains);
        }

        GenerationType generationType = generatedValue.strategy();
        switch (generationType) {
            case AUTO_INCREMENT:
                return universalMapper.insertAllAutoIncrement(domains);
            case SQL:
                return universalMapper.insertAllSelectKey(domains);
            case GENERATOR:
                Field idField = DatabaseUtils.obtainIdField(domainClass);
                IdGenerator idGenerator = DatabaseUtils.obtainIdGenerator(generatedValue.idGenerator());
                for (Object domain : domains) {
                    ReflectionUtils.setField(idField, domain, idGenerator.nextId());
                }
                return universalMapper.insertAll(domains);
            case UUID:
                Field field = DatabaseUtils.obtainIdField(domainClass);
                for (Object domain : domains) {
                    ReflectionUtils.setField(field, domain, UUID.randomUUID().toString());
                }
                return universalMapper.insertAll(domains);
            case MYCATSEQ_GLOBAL:
                return universalMapper.insertAll(domains);
        }
        throw new RuntimeException();
    }

    public static long delete(UniversalMapper universalMapper, Class<?> domainClass, DeleteModel deleteModel) {
        return universalMapper.delete(DatabaseUtils.obtainTableName(domainClass), deleteModel);
    }

    public static long delete(UniversalMapper universalMapper, String tableName, BigInteger id) {
        DeleteModel deleteModel = DeleteModel.builder()
                .addSearchCondition(BasicDomain.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .build();
        return universalMapper.delete(tableName, deleteModel);
    }

    public static long markedDelete(UniversalMapper universalMapper, Class<?> domainClass, BigInteger id, BigInteger userId, String updatedRemark) {
        return markedDelete(universalMapper, DatabaseUtils.obtainTableName(domainClass), id, userId, updatedRemark);
    }

    public static long markedDelete(UniversalMapper universalMapper, String tableName, BigInteger id, BigInteger userId, String updatedRemark) {
        UpdateModel updateModel = UpdateModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(BasicDomain.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .addContentValue(BasicDomain.ColumnName.DELETED_TIME, new Date(), 1)
                .addContentValue(BasicDomain.ColumnName.DELETED, 1, 1)
                .addContentValue(BasicDomain.ColumnName.UPDATED_USER_ID, userId, 1)
                .addContentValue(BasicDomain.ColumnName.UPDATED_REMARK, updatedRemark, 1)
                .build();
        return universalMapper.universalUpdate(tableName, updateModel);
    }

    public static long markedDelete(UniversalMapper universalMapper, Class<?> domainClass, BigInteger userId, String updatedRemark, Tuple3<String, String, Object>... searchConditions) {
        return markedDelete(universalMapper, DatabaseUtils.obtainTableName(domainClass), userId, updatedRemark, searchConditions);
    }

    public static long markedDelete(UniversalMapper universalMapper, String tableName, BigInteger userId, String updatedRemark, Tuple3<String, String, Object>... searchConditions) {
        UpdateModel updateModel = new UpdateModel(true);
        for (Tuple3<String, String, Object> searchCondition : searchConditions) {
            updateModel.addSearchCondition(searchCondition._1(), searchCondition._2(), searchCondition._3());
        }
        updateModel.addContentValue(BasicDomain.ColumnName.DELETED_TIME, new Date(), 1);
        updateModel.addContentValue(BasicDomain.ColumnName.DELETED, 1, 1);
        updateModel.addContentValue(BasicDomain.ColumnName.UPDATED_USER_ID, userId, 1);
        updateModel.addContentValue(BasicDomain.ColumnName.UPDATED_REMARK, updatedRemark, 1);
        return universalMapper.universalUpdate(tableName, updateModel);
    }

    public static long update(UniversalMapper universalMapper, Object domain) {
        return universalMapper.update(domain);
    }

    public static long universalUpdate(UniversalMapper universalMapper, String tableName, UpdateModel updateModel) {
        return universalMapper.universalUpdate(tableName, updateModel);
    }

    public static long executeUpdate(UniversalMapper universalMapper, Map<String, Object> parameters) {
        return universalMapper.executeUpdate(parameters);
    }

    public static long universalCount(UniversalMapper universalMapper, Map<String, Object> parameters) {
        return universalMapper.universalCount(parameters);
    }

    public static <T> T find(UniversalMapper universalMapper, Class<T> domainClass, BigInteger id) {
        SearchModel searchModel = new SearchModel(true);
        searchModel.addSearchCondition(BasicDomain.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id);
        return find(universalMapper, domainClass, searchModel);
    }

    public static <T> T find(UniversalMapper universalMapper, Class<T> domainClass, SearchModel searchModel) {
        return find(universalMapper, domainClass, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static <T> T find(UniversalMapper universalMapper, Class<T> domainClass, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return find(universalMapper, domainClass, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static <T> T find(UniversalMapper universalMapper, Class<T> domainClass, String tableName, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return find(universalMapper, domainClass, tableName, searchModel);
    }

    public static <T> T find(UniversalMapper universalMapper, Class<T> domainClass, String tableName, SearchModel searchModel) {
        try {
            Map<String, Object> map = universalMapper.find(DatabaseUtils.obtainColumns(domainClass), tableName, searchModel);
            T t = null;
            if (MapUtils.isNotEmpty(map)) {
                t = domainClass.newInstance();
                BeanUtils.populate(t, map);
            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> findAll(UniversalMapper universalMapper, Class<T> domainClass) {
        return findAll(universalMapper, domainClass, DatabaseUtils.obtainTableName(domainClass));
    }

    public static <T> List<T> findAll(UniversalMapper universalMapper, Class<T> domainClass, String tableName) {
        SearchModel searchModel = new SearchModel(true);
        return findAll(universalMapper, domainClass, tableName, searchModel);
    }

    public static <T> List<T> findAll(UniversalMapper universalMapper, Class<T> domainClass, SearchModel searchModel) {
        return findAll(universalMapper, domainClass, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static <T> List<T> findAll(UniversalMapper universalMapper, Class<T> domainClass, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return findAll(universalMapper, domainClass, searchModel);
    }

    public static <T> List<T> findAll(UniversalMapper universalMapper, Class<T> domainClass, String tableName, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return findAll(universalMapper, domainClass, tableName, searchModel);
    }

    public static <T> List<T> findAll(UniversalMapper universalMapper, Class<T> domainClass, String tableName, SearchModel searchModel) {
        try {
            List<Map<String, Object>> result = universalMapper.findAll(DatabaseUtils.obtainColumns(domainClass), tableName, searchModel);
            List<T> list = new ArrayList<T>();
            for (Map<String, Object> map : result) {
                T t = domainClass.newInstance();
                BeanUtils.populate(t, map);
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static long count(UniversalMapper universalMapper, Class<?> domainClass, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return count(universalMapper, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static long count(UniversalMapper universalMapper, Class<?> domainClass, SearchModel searchModel) {
        return count(universalMapper, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static long count(UniversalMapper universalMapper, String tableName, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return count(universalMapper, tableName, searchModel);
    }

    public static long count(UniversalMapper universalMapper, String tableName, SearchModel searchModel) {
        return universalMapper.count(tableName, searchModel);
    }

    public static long pagedCount(UniversalMapper universalMapper, Class<?> domainClass, PagedSearchModel pagedSearchModel) {
        return universalMapper.pagedCount(DatabaseUtils.obtainTableName(domainClass), pagedSearchModel);
    }

    public static long pagedCount(UniversalMapper universalMapper, String tableName, PagedSearchModel pagedSearchModel) {
        return universalMapper.pagedCount(tableName, pagedSearchModel);
    }

    public static <T> List<T> findAllPaged(UniversalMapper universalMapper, Class<T> domainClass, PagedSearchModel pagedSearchModel) {
        return findAllPaged(universalMapper, domainClass, DatabaseUtils.obtainTableName(domainClass), pagedSearchModel);
    }

    public static <T> List<T> findAllPaged(UniversalMapper universalMapper, Class<T> domainClass, String tableName, PagedSearchModel pagedSearchModel) {
        try {
            List<Map<String, Object>> result = universalMapper.findAllPaged(DatabaseUtils.obtainColumns(domainClass), tableName, pagedSearchModel);
            List<T> list = new ArrayList<T>();
            for (Map<String, Object> map : result) {
                T t = domainClass.newInstance();
                BeanUtils.populate(t, map);
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map<String, Object>> executeQuery(UniversalMapper universalMapper, Map<String, Object> parameters) {
        return universalMapper.executeQuery(parameters);
    }

    public static Map<String, Object> executeUniqueResultQuery(UniversalMapper universalMapper, Map<String, Object> parameters) {
        return universalMapper.executeUniqueResultQuery(parameters);
    }

    public static <T> T callMapperMethod(Class<?> mapperClass, Object mapper, String methodName, Tuple2<Class<?>, Object>... parameterAndTypes) {
        try {
            int length = parameterAndTypes.length;
            Class<?>[] parameterTypes = new Class<?>[length];
            Object[] parameters = new Object[length];
            for (int index = 0; index < length; index++) {
                parameterTypes[index] = parameterAndTypes[index]._1();
                parameters[index] = parameterAndTypes[index]._2();
            }
            ValidateUtils.notNull(mapper, "程序装载错误！");
            Method method = mapperClass.getMethod(methodName, parameterTypes);
            return (T) method.invoke(mapper, parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T callMapperMethod(Class<?> mapperClass, Object mapper, String methodName, List<Tuple2<Class<?>, Object>> parameterAndTypes) {
        try {
            int size = parameterAndTypes.size();
            Class<?>[] parameterTypes = new Class<?>[size];
            Object[] parameters = new Object[size];
            for (int index = 0; index < size; index++) {
                Tuple2<Class<?>, Object> tuple2 = parameterAndTypes.get(index);
                parameterTypes[index] = tuple2._1();
                parameters[index] = tuple2._2();
            }
            ValidateUtils.notNull(mapper, "程序装载错误！");
            Method method = mapperClass.getMethod(methodName, parameterTypes);
            return (T) method.invoke(mapper, parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
