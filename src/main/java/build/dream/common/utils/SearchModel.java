package build.dream.common.utils;

import java.util.ArrayList;
import java.util.List;

public class SearchModel {
    public List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();

    public void addSearchCondition(String columnName, String operationSymbol, Object searchParameter) {
        searchConditions.add(new SearchCondition(columnName, operationSymbol, searchParameter));
    }
}
