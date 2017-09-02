package build.dream.common.utils;

public class PagedSearchModel extends SearchModel {
    private Integer offset;
    private Integer maxResults;

    public PagedSearchModel() {

    }

    public PagedSearchModel(boolean setDeletedSearchCondition) {
        super(setDeletedSearchCondition);
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public void setOffsetAndMaxResults(Integer page, Integer rows) {
        this.offset = (page - 1) * rows;
        this.maxResults = rows;
    }
}
