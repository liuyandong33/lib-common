package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateModel {
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

    public void addContentValue(String columnName, Object value, int symbolType) {
        contentValues.add(new ContentValue(columnName, value, symbolType));
    }

    public void in(String columnName, Object... values) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_IN, values));
    }

    public void notIn(String columnName, Object... values) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_NOT_IN, values));
    }

    public void like(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_LIKE, value));
    }

    public void notLike(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_NOT_LIKE, value));
    }

    public void equal(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_EQUAL, value));
    }

    public void notEqual(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_NOT_EQUAL, value));
    }

    public void lessThan(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_LESS_THAN, value));
    }

    public void lessThanEqual(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_LESS_THAN_EQUAL, value));
    }

    public void greaterThan(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_GREATER_THAN, value));
    }

    public void greaterThanEqual(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_GREATER_THAN_EQUAL, value));
    }

    public void isNull(String columnName) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_IS_NULL, null));
    }

    public void isNotNull(String columnName) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_IS_NOT_NULL, null));
    }

    public static class Builder {
        private final UpdateModel instance = new UpdateModel();

        public Builder autoSetDeletedFalse() {
            instance.addSearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUAL, 0);
            return this;
        }

        public Builder searchConditions(List<SearchCondition> searchConditions) {
            instance.setSearchConditions(searchConditions);
            return this;
        }

        public Builder addSearchCondition(String columnName, String operationSymbol, Object searchParameter) {
            instance.addSearchCondition(columnName, operationSymbol, searchParameter);
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
            instance.addNamedParameter(name, value);
            return this;
        }

        public Builder contentValues(List<ContentValue> contentValues) {
            instance.setContentValues(contentValues);
            return this;
        }

        public Builder addContentValue(String columnName, Object value, int symbolType) {
            instance.addContentValue(columnName, value, symbolType);
            return this;
        }

        public Builder in(String columnName, Object... values) {
            instance.in(columnName, values);
            return this;
        }

        public Builder notIn(String columnName, Object... values) {
            instance.notIn(columnName, values);
            return this;
        }

        public Builder like(String columnName, Object value) {
            instance.like(columnName, value);
            return this;
        }

        public Builder notLike(String columnName, Object value) {
            instance.notLike(columnName, value);
            return this;
        }

        public Builder equal(String columnName, Object value) {
            instance.equal(columnName, value);
            return this;
        }

        public Builder notEqual(String columnName, Object value) {
            instance.notEqual(columnName, value);
            return this;
        }

        public Builder lessThan(String columnName, Object value) {
            instance.lessThan(columnName, value);
            return this;
        }

        public Builder lessThanEqual(String columnName, Object value) {
            instance.lessThanEqual(columnName, value);
            return this;
        }

        public Builder greaterThan(String columnName, Object value) {
            instance.greaterThan(columnName, value);
            return this;
        }

        public Builder greaterThanEqual(String columnName, Object value) {
            instance.greaterThanEqual(columnName, value);
            return this;
        }

        public Builder isNull(String columnName) {
            instance.isNull(columnName);
            return this;
        }

        public Builder isNotNull(String columnName) {
            instance.isNotNull(columnName);
            return this;
        }

        public UpdateModel build() {
            UpdateModel updateModel = new UpdateModel();
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
