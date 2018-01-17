package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class UpdateModel {
    private String tableName;
    private List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();
    private List<ContentValue> contentValues = new ArrayList<ContentValue>();

    public UpdateModel() {

    }

    public UpdateModel(boolean autoSetDeletedFalse) {
        if (autoSetDeletedFalse) {
            this.addSearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUALS, 0);
        }
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<SearchCondition> getSearchConditions() {
        return searchConditions;
    }

    public void setSearchConditions(List<SearchCondition> searchConditions) {
        this.searchConditions = searchConditions;
    }

    public List<ContentValue> getContentValues() {
        return contentValues;
    }

    public void setContentValues(List<ContentValue> contentValues) {
        this.contentValues = contentValues;
    }

    public void addSearchCondition(String columnName, String operationSymbol, Object searchParameter) {
        searchConditions.add(new SearchCondition(columnName, operationSymbol, searchParameter));
    }

    public void addContentValue(String columnName, Object value) {
        contentValues.add(new ContentValue(columnName, value));
    }
}
