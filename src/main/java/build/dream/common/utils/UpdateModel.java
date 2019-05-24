package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateModel {
    private String tableName;
    private List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();
    private String whereClause;
    private Map<String, Object> namedParameters = new HashMap<String, Object>();
    private List<ContentValue> contentValues = new ArrayList<ContentValue>();

    public UpdateModel() {

    }

    public UpdateModel(boolean autoSetDeletedFalse) {
        if (autoSetDeletedFalse) {
            this.addSearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUAL, 0);
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

    public String getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(String whereClause) {
        this.whereClause = whereClause;
    }

    public Map<String, Object> getNamedParameters() {
        return namedParameters;
    }

    public void setNamedParameters(Map<String, Object> namedParameters) {
        this.namedParameters = namedParameters;
    }

    public void addNamedParameter(String name, Object value) {
        this.namedParameters.put(name, value);
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

    public String getGroupBy() {
        return null;
    }

    public String getOrderBy() {
        return null;
    }

    public boolean isForUpdate() {
        return false;
    }

    public static class Builder {
        private final UpdateModel instance = new UpdateModel();

        public Builder autoSetDeletedFalse(boolean autoSetDeletedFalse) {
            instance.addSearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUAL, 0);
            return this;
        }

        public Builder tableName(String tableName) {
            instance.setTableName(tableName);
            return this;
        }

        public Builder searchConditions(List<SearchCondition> searchConditions) {
            instance.setSearchConditions(searchConditions);
            return this;
        }

        public Builder addSearchCondition(String columnName, String operationSymbol, Object searchParameter) {
            instance.searchConditions.add(new SearchCondition(columnName, operationSymbol, searchParameter));
            return this;
        }

        public Builder whereClause(String whereClause) {
            instance.setWhereClause(whereClause);
            return this;
        }

        public Builder namedParameters(Map<String, Object> namedParameters) {
            instance.setNamedParameters(namedParameters);
            return this;
        }

        public Builder addNamedParameter(String name, Object value) {
            instance.namedParameters.put(name, value);
            return this;
        }

        public Builder contentValues(List<ContentValue> contentValues) {
            instance.setContentValues(contentValues);
            return this;
        }

        public Builder addContentValue(String columnName, Object value) {
            instance.contentValues.add(new ContentValue(columnName, value));
            return this;
        }

        public UpdateModel build() {
            UpdateModel updateModel = new UpdateModel();
            updateModel.setTableName(instance.getTableName());
            updateModel.setSearchConditions(instance.getSearchConditions());
            updateModel.setWhereClause(instance.getWhereClause());
            updateModel.setNamedParameters(instance.getNamedParameters());
            updateModel.setContentValues(instance.getContentValues());
            return updateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
