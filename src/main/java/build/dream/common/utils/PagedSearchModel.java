package build.dream.common.utils;

import java.util.ArrayList;
import java.util.List;

public class PagedSearchModel {
    private Integer offset;
    private Integer maxResults;
    private List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();

    public void addSearchCondition(String columnName, String operationSymbol, Object searchParameter) {
        searchConditions.add(new SearchCondition(columnName, operationSymbol, searchParameter));
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setOffsetAndMaxResults(Integer page, Integer rows) {
        this.offset = (page - 1) * rows;
        this.maxResults = rows;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public List<SearchCondition> getSearchConditions() {
        return searchConditions;
    }

    public void setSearchConditions(List<SearchCondition> searchConditions) {
        this.searchConditions = searchConditions;
    }
}
