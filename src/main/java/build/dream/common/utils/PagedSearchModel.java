package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagedSearchModel {
    private List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();
    private List<String> columns = new ArrayList<String>();
    private String whereClause;
    private Map<String, Object> namedParameters = new HashMap<String, Object>();
    private String tableName;
    private String groupBy;
    private String orderBy;
    private Integer page;
    private Integer rows;
    private String databaseProvider = Constants.DATABASE_PROVIDER_MYSQL;

    public PagedSearchModel() {

    }

    public PagedSearchModel(boolean autoSetDeletedFalse) {
        if (autoSetDeletedFalse) {
            this.addSearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUAL, 0);
        }
    }

    public PagedSearchModel(List<SearchCondition> searchConditions, Integer page, Integer rows) {
        this.searchConditions = searchConditions;
        this.page = page;
        this.rows = rows;
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getDatabaseProvider() {
        return databaseProvider;
    }

    public void setDatabaseProvider(String databaseProvider) {
        this.databaseProvider = databaseProvider;
    }

    public Integer getOffset() {
        return (page - 1) * rows;
    }

    public Integer getMaxResults() {
        return rows;
    }

    /**
     * 获取开始行号，oracle数据库专用
     *
     * @return
     */
    public Integer getStartRowNumber() {
        return (page - 1) * rows;
    }

    /**
     * 获取结束行号，oracle数据库专用
     *
     * @return
     */
    public Integer getEndRowNumber() {
        return page * rows;
    }

    public static class Builder {
        private final PagedSearchModel instance = new PagedSearchModel();

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

        public Builder page(Integer page) {
            instance.setPage(page);
            return this;
        }

        public Builder rows(Integer rows) {
            instance.setRows(rows);
            return this;
        }

        public Builder databaseProvider(String databaseProvider) {
            instance.setDatabaseProvider(databaseProvider);
            return this;
        }

        public PagedSearchModel build() {
            PagedSearchModel pagedSearchModel = new PagedSearchModel();
            pagedSearchModel.setSearchConditions(instance.getSearchConditions());
            pagedSearchModel.setColumns(instance.getColumns());
            pagedSearchModel.setWhereClause(instance.getWhereClause());
            pagedSearchModel.setNamedParameters(instance.getNamedParameters());
            pagedSearchModel.setTableName(instance.getTableName());
            pagedSearchModel.setGroupBy(instance.getGroupBy());
            pagedSearchModel.setOrderBy(instance.getOrderBy());
            pagedSearchModel.setPage(instance.getPage());
            pagedSearchModel.setRows(instance.getRows());
            pagedSearchModel.setDatabaseProvider(instance.getDatabaseProvider());
            return pagedSearchModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
