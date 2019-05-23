package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.exceptions.ApiException;
import build.dream.common.mappers.UniversalMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BigIntegerConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import scala.Tuple2;
import scala.Tuple3;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseHelper {
    private static UniversalMapper universalMapper;
    private static ConcurrentHashMap<Class<?>, Object> mapperMap = new ConcurrentHashMap<Class<?>, Object>();

    private static Object obtainMapper(Class<?> mapperClass) {
        if (!mapperMap.contains(mapperClass)) {
            mapperMap.put(mapperClass, ApplicationHandler.getBean(mapperClass));
        }
        return mapperMap.get(mapperClass);
    }

    static {
        ConvertUtils.register(new IntegerConverter(null), Integer.class);
        ConvertUtils.register(new BigIntegerConverter(null), BigInteger.class);
        ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
        ConvertUtils.register(new DateConverter(null), Date.class);
    }

    public static UniversalMapper obtainUniversalMapper() {
        if (universalMapper == null) {
            universalMapper = ApplicationHandler.getBean(UniversalMapper.class);
        }
        return universalMapper;
    }

    public static long insert(Object domain) {
        return obtainUniversalMapper().insert(domain);
    }

    public static long insertAll(List<?> domains) {
        return obtainUniversalMapper().insertAll(domains);
    }

    public static long delete(Class<?> domainClass, DeleteModel deleteModel) {
        deleteModel.setTableName(DatabaseUtils.obtainTableName(domainClass));
        return obtainUniversalMapper().delete(deleteModel);
    }

    public static long delete(String tableName, BigInteger id) {
        DeleteModel deleteModel = new DeleteModel();
        deleteModel.addSearchCondition("id", Constants.SQL_OPERATION_SYMBOL_EQUAL, id);
        deleteModel.setTableName(tableName);
        return obtainUniversalMapper().delete(deleteModel);
    }

    public static long markedDelete(Class<?> domainClass, BigInteger id, BigInteger userId, String updatedRemark) {
        return markedDelete(DatabaseUtils.obtainTableName(domainClass), id, userId, updatedRemark);
    }

    public static long markedDelete(String tableName, BigInteger id, BigInteger userId, String updatedRemark) {
        UpdateModel updateModel = new UpdateModel(true);
        updateModel.setTableName(tableName);
        updateModel.addSearchCondition("id", Constants.SQL_OPERATION_SYMBOL_EQUAL, id);
        updateModel.addContentValue("deleted_time", new Date());
        updateModel.addContentValue("deleted", 1);
        updateModel.addContentValue("updated_user_id", userId);
        updateModel.addContentValue("updated_remark", updatedRemark);
        return obtainUniversalMapper().universalUpdate(updateModel);
    }

    public static long markedDelete(Class<?> domainClass, BigInteger userId, String updatedRemark, Tuple3<String, String, Object>... searchConditions) {
        return markedDelete(DatabaseUtils.obtainTableName(domainClass), userId, updatedRemark, searchConditions);
    }

    public static long markedDelete(String tableName, BigInteger userId, String updatedRemark, Tuple3<String, String, Object>... searchConditions) {
        UpdateModel updateModel = new UpdateModel(true);
        updateModel.setTableName(tableName);
        for (Tuple3<String, String, Object> searchCondition : searchConditions) {
            updateModel.addSearchCondition(searchCondition._1(), searchCondition._2(), searchCondition._3());
        }
        updateModel.addContentValue("deleted_time", new Date());
        updateModel.addContentValue("deleted", 1);
        updateModel.addContentValue("updated_user_id", userId);
        updateModel.addContentValue("updated_remark", updatedRemark);
        return obtainUniversalMapper().universalUpdate(updateModel);
    }

    public static long update(Object domain) {
        return obtainUniversalMapper().update(domain);
    }

    public static long universalUpdate(UpdateModel updateModel) {
        return obtainUniversalMapper().universalUpdate(updateModel);
    }

    public static long executeUpdate(Map<String, Object> parameters) {
        return obtainUniversalMapper().executeUpdate(parameters);
    }

    public static long universalCount(Map<String, Object> parameters) {
        return obtainUniversalMapper().universalCount(parameters);
    }

    public static <T> T find(Class<T> domainClass, BigInteger id) {
        SearchModel searchModel = new SearchModel(true);
        searchModel.addSearchCondition("id", Constants.SQL_OPERATION_SYMBOL_EQUAL, id);
        return find(domainClass, searchModel);
    }

    public static <T> T find(Class<T> domainClass, SearchModel searchModel) {
        return find(domainClass, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static <T> T find(Class<T> domainClass, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return find(domainClass, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static <T> T find(Class<T> domainClass, String tableName, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return find(domainClass, tableName, searchModel);
    }

    public static <T> T find(Class<T> domainClass, String tableName, SearchModel searchModel) {
        try {
            searchModel.setTableName(tableName);
            List<String> columns = searchModel.getColumns();
            if (CollectionUtils.isEmpty(columns)) {
                searchModel.setColumns(DatabaseUtils.obtainAllAlias(domainClass));
            }
            Map<String, Object> map = obtainUniversalMapper().find(searchModel);
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

    public static <T> List<T> findAll(Class<T> domainClass) {
        return findAll(domainClass, DatabaseUtils.obtainTableName(domainClass));
    }

    public static <T> List<T> findAll(Class<T> domainClass, String tableName) {
        SearchModel searchModel = new SearchModel(true);
        return findAll(domainClass, tableName, searchModel);
    }

    public static <T> List<T> findAll(Class<T> domainClass, SearchModel searchModel) {
        return findAll(domainClass, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static <T> List<T> findAll(Class<T> domainClass, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return findAll(domainClass, searchModel);
    }

    public static <T> List<T> findAll(Class<T> domainClass, String tableName, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return findAll(domainClass, tableName, searchModel);
    }

    public static <T> List<T> findAll(Class<T> domainClass, String tableName, SearchModel searchModel) {
        try {
            searchModel.setTableName(tableName);
            List<String> columns = searchModel.getColumns();
            if (CollectionUtils.isEmpty(columns)) {
                searchModel.setColumns(DatabaseUtils.obtainAllAlias(domainClass));
            }
            List<Map<String, Object>> result = obtainUniversalMapper().findAll(searchModel);
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

    public static long count(Class<?> domainClass, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return count(DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static long count(Class<?> domainClass, SearchModel searchModel) {
        return count(DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static long count(String tableName, Tuple3<String, String, Object>... searchConditions) {
        SearchModel searchModel = new SearchModel(true);
        for (Tuple3<String, String, Object> tuple3 : searchConditions) {
            searchModel.addSearchCondition(tuple3._1(), tuple3._2(), tuple3._3());
        }
        return count(tableName, searchModel);
    }

    public static long count(String tableName, SearchModel searchModel) {
        searchModel.setTableName(tableName);
        return obtainUniversalMapper().count(searchModel);
    }

    public static <T> List<T> findAllPaged(Class<T> domainClass, SearchModel searchModel) {
        return findAllPaged(domainClass, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static <T> List<T> findAllPaged(Class<T> domainClass, String tableName, SearchModel searchModel) {
        try {
            searchModel.setTableName(tableName);
            List<String> columns = searchModel.getColumns();
            if (CollectionUtils.isEmpty(columns)) {
                searchModel.setColumns(DatabaseUtils.obtainAllAlias(domainClass));
            }
            List<Map<String, Object>> result = obtainUniversalMapper().findAllPaged(searchModel);
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

    public static List<Map<String, Object>> executeQuery(Map<String, Object> parameters) {
        return obtainUniversalMapper().executeQuery(parameters);
    }

    public static Map<String, Object> executeUniqueResultQuery(Map<String, Object> parameters) {
        return obtainUniversalMapper().executeUniqueResultQuery(parameters);
    }

    public static <T> T callMapperMethod(Class<?> mapperClass, String methodName, Tuple2<Class<?>, Object>... parameterAndTypes) {
        try {
            int length = parameterAndTypes.length;
            Class<?>[] parameterTypes = new Class<?>[length];
            Object[] parameters = new Object[length];
            for (int index = 0; index < length; index++) {
                parameterTypes[index] = parameterAndTypes[index]._1();
                parameters[index] = parameterAndTypes[index]._2();
            }
            Object mapper = obtainMapper(mapperClass);
            ValidateUtils.notNull(mapper, "程序装载错误！");
            Method method = mapperClass.getMethod(methodName, parameterTypes);
            return (T) method.invoke(mapper, parameters);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static <T> T callMapperMethod(Class<?> mapperClass, String methodName, List<Tuple2<Class<?>, Object>> parameterAndTypes) {
        try {
            int size = parameterAndTypes.size();
            Class<?>[] parameterTypes = new Class<?>[size];
            Object[] parameters = new Object[size];
            for (int index = 0; index < size; index++) {
                Tuple2<Class<?>, Object> tuple2 = parameterAndTypes.get(index);
                parameterTypes[index] = tuple2._1();
                parameters[index] = tuple2._2();
            }
            Object mapper = obtainMapper(mapperClass);
            ValidateUtils.notNull(mapper, "程序装载错误！");
            Method method = mapperClass.getMethod(methodName, parameterTypes);
            return (T) method.invoke(mapper, parameters);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
