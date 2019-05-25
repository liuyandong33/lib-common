package build.dream.common.utils;

import build.dream.common.mappers.UniversalMapper;
import scala.Tuple2;
import scala.Tuple3;

import java.math.BigInteger;
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

    public static UniversalMapper obtainUniversalMapper() {
        if (universalMapper == null) {
            universalMapper = ApplicationHandler.getBean(UniversalMapper.class);
        }
        return universalMapper;
    }

    public static long insert(Object domain) {
        return UniversalDatabaseHelper.insert(obtainUniversalMapper(), domain);
    }

    public static long insertAll(List<?> domains) {
        return UniversalDatabaseHelper.insertAll(obtainUniversalMapper(), domains);
    }

    public static long delete(Class<?> domainClass, DeleteModel deleteModel) {
        return UniversalDatabaseHelper.delete(obtainUniversalMapper(), domainClass, deleteModel);
    }

    public static long delete(String tableName, BigInteger id) {
        return UniversalDatabaseHelper.delete(obtainUniversalMapper(), tableName, id);
    }

    public static long markedDelete(Class<?> domainClass, BigInteger id, BigInteger userId, String updatedRemark) {
        return UniversalDatabaseHelper.markedDelete(obtainUniversalMapper(), domainClass, id, userId, updatedRemark);
    }

    public static long markedDelete(String tableName, BigInteger id, BigInteger userId, String updatedRemark) {
        return UniversalDatabaseHelper.markedDelete(obtainUniversalMapper(), tableName, id, userId, updatedRemark);
    }

    public static long markedDelete(Class<?> domainClass, BigInteger userId, String updatedRemark, Tuple3<String, String, Object>... searchConditions) {
        return UniversalDatabaseHelper.markedDelete(obtainUniversalMapper(), domainClass, userId, updatedRemark, searchConditions);
    }

    public static long markedDelete(String tableName, BigInteger userId, String updatedRemark, Tuple3<String, String, Object>... searchConditions) {
        return UniversalDatabaseHelper.markedDelete(obtainUniversalMapper(), tableName, userId, updatedRemark, searchConditions);
    }

    public static long update(Object domain) {
        return UniversalDatabaseHelper.update(obtainUniversalMapper(), domain);
    }

    public static long universalUpdate(UpdateModel updateModel, String tableName) {
        return UniversalDatabaseHelper.universalUpdate(obtainUniversalMapper(), tableName, updateModel);
    }

    public static long executeUpdate(Map<String, Object> parameters) {
        return UniversalDatabaseHelper.executeUpdate(obtainUniversalMapper(), parameters);
    }

    public static long universalCount(Map<String, Object> parameters) {
        return UniversalDatabaseHelper.universalCount(obtainUniversalMapper(), parameters);
    }

    public static <T> T find(Class<T> domainClass, BigInteger id) {
        return UniversalDatabaseHelper.find(obtainUniversalMapper(), domainClass, id);
    }

    public static <T> T find(Class<T> domainClass, SearchModel searchModel) {
        return find(domainClass, DatabaseUtils.obtainTableName(domainClass), searchModel);
    }

    public static <T> T find(Class<T> domainClass, Tuple3<String, String, Object>... searchConditions) {
        return UniversalDatabaseHelper.find(obtainUniversalMapper(), domainClass, searchConditions);
    }

    public static <T> T find(Class<T> domainClass, String tableName, Tuple3<String, String, Object>... searchConditions) {
        return UniversalDatabaseHelper.find(obtainUniversalMapper(), domainClass, tableName, searchConditions);
    }

    public static <T> T find(Class<T> domainClass, String tableName, SearchModel searchModel) {
        return UniversalDatabaseHelper.find(obtainUniversalMapper(), domainClass, tableName, searchModel);
    }

    public static <T> List<T> findAll(Class<T> domainClass) {
        return UniversalDatabaseHelper.findAll(obtainUniversalMapper(), domainClass);
    }

    public static <T> List<T> findAll(Class<T> domainClass, String tableName) {
        return UniversalDatabaseHelper.findAll(obtainUniversalMapper(), domainClass, tableName);
    }

    public static <T> List<T> findAll(Class<T> domainClass, SearchModel searchModel) {
        return UniversalDatabaseHelper.findAll(obtainUniversalMapper(), domainClass, searchModel);
    }

    public static <T> List<T> findAll(Class<T> domainClass, Tuple3<String, String, Object>... searchConditions) {
        return UniversalDatabaseHelper.findAll(obtainUniversalMapper(), domainClass, searchConditions);
    }

    public static <T> List<T> findAll(Class<T> domainClass, String tableName, Tuple3<String, String, Object>... searchConditions) {
        return UniversalDatabaseHelper.findAll(obtainUniversalMapper(), domainClass, tableName, searchConditions);
    }

    public static <T> List<T> findAll(Class<T> domainClass, String tableName, SearchModel searchModel) {
        return UniversalDatabaseHelper.findAll(obtainUniversalMapper(), domainClass, tableName, searchModel);
    }

    public static long count(Class<?> domainClass, Tuple3<String, String, Object>... searchConditions) {
        return UniversalDatabaseHelper.count(obtainUniversalMapper(), domainClass, searchConditions);
    }

    public static long count(Class<?> domainClass, SearchModel searchModel) {
        return UniversalDatabaseHelper.count(obtainUniversalMapper(), domainClass, searchModel);
    }

    public static long count(String tableName, Tuple3<String, String, Object>... searchConditions) {
        return UniversalDatabaseHelper.count(obtainUniversalMapper(), tableName, searchConditions);
    }

    public static long count(String tableName, SearchModel searchModel) {
        return UniversalDatabaseHelper.count(obtainUniversalMapper(), tableName, searchModel);
    }

    public static long pagedCount(Class<?> domainClass, PagedSearchModel pagedSearchModel) {
        return UniversalDatabaseHelper.pagedCount(obtainUniversalMapper(), domainClass, pagedSearchModel);
    }

    public static long pagedCount(String tableName, PagedSearchModel pagedSearchModel) {
        return UniversalDatabaseHelper.pagedCount(obtainUniversalMapper(), tableName, pagedSearchModel);
    }

    public static <T> List<T> findAllPaged(Class<T> domainClass, PagedSearchModel pagedSearchModel) {
        return UniversalDatabaseHelper.findAllPaged(obtainUniversalMapper(), domainClass, pagedSearchModel);
    }

    public static <T> List<T> findAllPaged(Class<T> domainClass, String tableName, PagedSearchModel pagedSearchModel) {
        return UniversalDatabaseHelper.findAllPaged(obtainUniversalMapper(), domainClass, tableName, pagedSearchModel);
    }

    public static List<Map<String, Object>> executeQuery(Map<String, Object> parameters) {
        return UniversalDatabaseHelper.executeQuery(obtainUniversalMapper(), parameters);
    }

    public static Map<String, Object> executeUniqueResultQuery(Map<String, Object> parameters) {
        return UniversalDatabaseHelper.executeUniqueResultQuery(obtainUniversalMapper(), parameters);
    }

    public static <T> T callMapperMethod(Class<?> mapperClass, String methodName, Tuple2<Class<?>, Object>... parameterAndTypes) {
        return UniversalDatabaseHelper.callMapperMethod(mapperClass, obtainMapper(mapperClass), methodName, parameterAndTypes);
    }

    public static <T> T callMapperMethod(Class<?> mapperClass, String methodName, List<Tuple2<Class<?>, Object>> parameterAndTypes) {
        return UniversalDatabaseHelper.callMapperMethod(mapperClass, obtainMapper(mapperClass), methodName, parameterAndTypes);
    }
}
