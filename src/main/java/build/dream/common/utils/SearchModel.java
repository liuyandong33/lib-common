package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchModel {
    private List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();
    private List<String> columns = new ArrayList<String>();

    public SearchModel() {

    }

    public SearchModel(boolean autoSetDeletedFalse) {
        if (autoSetDeletedFalse) {
            this.addSearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUALS, 0);
        }
    }

    public List<SearchCondition> getSearchConditions() {
        return searchConditions;
    }

    public void setSearchConditions(List<SearchCondition> searchConditions) {
        this.searchConditions = searchConditions;
    }

    public String getSelectColumns() {
        String selectColumns = null;
        if (CollectionUtils.isEmpty(columns)) {
            selectColumns = "*";
        } else {
            selectColumns = StringUtils.join(columns, ", ");
        }
        return selectColumns;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public void addColumns(String... elements) {
        CollectionUtils.addAll(this.columns, elements);
    }

    public void addSearchCondition(String columnName, String operationSymbol, Object searchParameter) {
        searchConditions.add(new SearchCondition(columnName, operationSymbol, searchParameter));
    }
}
