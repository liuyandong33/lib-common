package build.dream.common.orm;

import build.dream.common.constants.Constants;
import build.dream.common.utils.SearchCondition;

import java.util.ArrayList;
import java.util.List;

public class QueryWrapper<T> {
    private Class<T> domainClass;
    public List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();

    public QueryWrapper() {

    }

    public QueryWrapper(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    public QueryWrapper<T> in(String columnName, Object... values) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_IN, values));
        return this;
    }

    public QueryWrapper<T> notIn(String columnName, Object... values) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_NOT_IN, values));
        return this;
    }

    public QueryWrapper<T> like(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_LIKE, value));
        return this;
    }

    public QueryWrapper<T> notLike(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_NOT_LIKE, value));
        return this;
    }

    public QueryWrapper<T> equal(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_EQUAL, value));
        return this;
    }

    public QueryWrapper<T> notEqual(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_NOT_EQUAL, value));
        return this;
    }

    public QueryWrapper<T> lessThan(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_LESS_THAN, value));
        return this;
    }

    public QueryWrapper<T> lessThanEqual(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_LESS_THAN_EQUAL, value));
        return this;
    }

    public QueryWrapper<T> greaterThan(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_GREATER_THAN, value));
        return this;
    }

    public QueryWrapper<T> greaterThanEqual(String columnName, Object value) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_GREATER_THAN_EQUAL, value));
        return this;
    }

    public QueryWrapper<T> isNull(String columnName) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_IS_NULL, null));
        return this;
    }

    public QueryWrapper<T> isNotNull(String columnName) {
        searchConditions.add(new SearchCondition(columnName, Constants.SQL_OPERATION_SYMBOL_IS_NOT_NULL, null));
        return this;
    }
}
