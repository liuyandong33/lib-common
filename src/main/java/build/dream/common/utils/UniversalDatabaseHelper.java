package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.mappers.UniversalMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import scala.Tuple2;
import scala.Tuple3;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UniversalDatabaseHelper {
    static {
        ApplicationHandler.registerConverters();
    }

    public static long insert(UniversalMapper universalMapper, Object domain) {
        return universalMapper.insert(domain);
    }

    public static long insertAll(UniversalMapper universalMapper, List<?> domains) {
        return universalMapper.insertAll(domains);
    }

    public static long delete(UniversalMapper universalMapper, Class<?> domainClass, DeleteModel deleteModel) {
        deleteModel.setTableName(DatabaseUtils.obtainTableName(domainClass));
        return universalMapper.delete(deleteModel);
    }

    public static long delete(UniversalMapper universalMapper, String tableName, BigInteger id) {
        DeleteModel deleteModel = new DeleteModel();
        deleteModel.addSearchCondition("id", Constants.SQL_OPERATION_SYMBOL_EQUAL, id);
        deleteModel.setTableName(tableName);
        return universalMapper.delete(deleteModel);
    }

    public static long markedDelete(UniversalMapper universalMapper, Class<?> domainClass, BigInteger id, BigInteger userId, String updatedRemark) {
        return markedDelete(universalMapper, DatabaseUtils.obtainTableName(domainClass), id, userId, updatedRemark);
    }

    public static long markedDelete(UniversalMapper universalMapper, String tableName, BigInteger id, BigInteger userId, String updatedRemark) {
        UpdateModel updateModel = new UpdateModel(true);
        updateModel.setTableName(tableName);
        updateModel.addSearchCondition("id", Constants.SQL_OPERATION_SYMBOL_EQUAL, id);
        updateModel.addContentValue("deleted_time", new Date());
        updateModel.addContentValue("deleted", 1);
        updateModel.addContentValue("updated_user_id", userId);
        updateModel.addContentValue("updated_remark", updatedRemark);
        return universalMapper.universalUpdate(updateModel);
    }

    public static long markedDelete(UniversalMapper universalMapper, Class<?> domainClass, BigInteger userId, String updatedRemark, Tuple3<String, String, Object>... searchConditions) {
        return markedDelete(universalMapper, DatabaseUtils.obtainTableName(domainClass), userId, updatedRemark, searchConditions);
    }

    public static long markedDelete(UniversalMapper universalMapper, String tableName, BigInteger userId, String updatedRemark, Tuple3<String, String, Object>... searchConditions) {
        UpdateModel updateModel = new UpdateModel(true);
        updateModel.setTableName(tableName);
        for (Tuple3<String, String, Object> searchCondition : searchConditions) {
            updateModel.addSearchCondition(searchCondition._1(), searchCondition._2(), searchCondition._3());
        }
        updateModel.addContentValue("deleted_time", new Date());
        updateModel.addContentValue("deleted", 1);
        updateModel.addContentValue("updated_user_id", userId);
        updateModel.addContentValue("updated_remark", updatedRemark);
        return universalMapper.universalUpdate(updateModel);
    }

    public static long update(UniversalMapper universalMapper, Object domain) {
        return universalMapper.update(domain);
    }

    public static long universalUpdate(UniversalMapper universalMapper, UpdateModel updateModel) {
        return universalMapper.universalUpdate(updateModel);
    }

    public static long executeUpdate(UniversalMapper universalMapper, Map<String, Object> parameters) {
        return universalMapper.executeUpdate(parameters);
    }

    public static long universalCount(UniversalMapper universalMapper, Map<String, Object> parameters) {
        return universalMapper.universalCount(parameters);
    }

    public static <T> T find(UniversalMapper universalMapper, Class<T> domainClass, BigInteger id) {
        SearchModel searchModel = new SearchModel(true);
        searchModel.addSearchCondition("id", Constants.SQL_OPERATION_SYMBOL_EQUAL, id);
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
