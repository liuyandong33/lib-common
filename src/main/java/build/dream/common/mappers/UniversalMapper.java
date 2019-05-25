package build.dream.common.mappers;

import build.dream.common.utils.DeleteModel;
import build.dream.common.utils.PagedSearchModel;
import build.dream.common.utils.SearchModel;
import build.dream.common.utils.UpdateModel;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

public interface UniversalMapper {
    long insert(Object domain);

    long insertAll(List<?> domains);

    long delete(@Param("tableName") String tableName, @Param("deleteModel") DeleteModel deleteModel);

    long update(Object domain);

    long universalUpdate(@Param("tableName") String tableName, @Param("updateModel") UpdateModel updateModel);

    long executeUpdate(Map<String, Object> parameters);

    Map<String, Object> find(@Param("columns") String columns, @Param("tableName") String tableName, @Param("searchModel") SearchModel searchModel);

    List<Map<String, Object>> findAll(@Param("columns") String columns, @Param("tableName") String tableName, @Param("searchModel") SearchModel searchModel);

    long count(@Param("tableName") String tableName, @Param("searchModel") SearchModel searchModel);

    long universalCount(Map<String, Object> parameters);

    long pagedCount(@Param("tableName") String tableName, @Param("pagedSearchModel") PagedSearchModel pagedSearchModel);

    List<Map<String, Object>> findAllPaged(@Param("columns") String columns, @Param("tableName") String tableName, @Param("pagedSearchModel") PagedSearchModel pagedSearchModel);

    List<Map<String, Object>> executeQuery(Map<String, Object> parameters);

    Map<String, Object> executeUniqueResultQuery(Map<String, Object> parameters);
}
