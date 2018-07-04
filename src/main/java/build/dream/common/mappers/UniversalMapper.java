package build.dream.common.mappers;

import build.dream.common.utils.DeleteModel;
import build.dream.common.utils.SearchModel;
import build.dream.common.utils.UpdateModel;

import java.util.List;
import java.util.Map;

public interface UniversalMapper {
    long insert(Object domain);

    long insertAll(List<?> domains);

    long delete(DeleteModel deleteModel);

    long update(Object domain);

    long universalUpdate(UpdateModel updateModel);

    long executeUpdate(Map<String, Object> parameters);

    Map<String, Object> find(SearchModel searchModel);

    List<Map<String, Object>> findAll(SearchModel searchModel);

    long count(SearchModel searchModel);

    long universalCount(Map<String, Object> parameters);

    List<Map<String, Object>> findAllPaged(SearchModel searchModel);

    List<Map<String, Object>> executeQuery(Map<String, Object> parameters);

    Map<String, Object> executeUniqueResultQuery(Map<String, Object> parameters);
}
