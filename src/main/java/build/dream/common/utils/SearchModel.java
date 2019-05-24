package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchModel {
    private List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();
    private List<String> columns = new ArrayList<String>();
    private String whereClause;
    private Map<String, Object> namedParameters = new HashMap<String, Object>();
    private String tableName;
    private String groupBy;
    private String orderBy;
    private boolean forUpdate;

    public SearchModel() {

    }

    public SearchModel(boolean autoSetDeletedFalse) {
        if (autoSetDeletedFalse) {
            this.addSearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUAL, 0);
        }
    }

    public SearchModel(List<SearchCondition> searchConditions) {
        this.searchConditions = searchConditions;
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

    public void addColumns(String... columns) {
        CollectionUtils.addAll(this.columns, columns);
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void addSearchCondition(String columnName, String operationSymbol, Object searchParameter) {
        searchConditions.add(new SearchCondition(columnName, operationSymbol, searchParameter));
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isForUpdate() {
        return forUpdate;
    }

    public void setForUpdate(boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public static class Builder {
        private final SearchModel instance = new SearchModel();

        public Builder autoSetDeletedFalse() {
            instance.addSearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUAL, 0);
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

        public Builder columns(List<String> columns) {
            instance.setColumns(columns);
            return this;
        }

        public Builder addColumns(String... columns) {
            CollectionUtils.addAll(instance.columns, columns);
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

        public Builder tableName(String tableName) {
            instance.setTableName(tableName);
            return this;
        }

        public Builder groupBy(String groupBy) {
            instance.setGroupBy(groupBy);
            return this;
        }

        public Builder orderBy(String orderBy) {
            instance.setOrderBy(orderBy);
            return this;
        }

        public Builder forUpdate(boolean forUpdate) {
            instance.setForUpdate(forUpdate);
            return this;
        }

        public SearchModel build() {
            SearchModel searchModel = new SearchModel();
            searchModel.setSearchConditions(instance.getSearchConditions());
            searchModel.setColumns(instance.getColumns());
            searchModel.setWhereClause(instance.getWhereClause());
            searchModel.setNamedParameters(instance.getNamedParameters());
            searchModel.setTableName(instance.getTableName());
            searchModel.setGroupBy(instance.getGroupBy());
            searchModel.setOrderBy(instance.getOrderBy());
            searchModel.setForUpdate(instance.isForUpdate());
            return searchModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
