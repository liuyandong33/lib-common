package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.util.List;

public class PagedSearchModel extends SearchModel {
    private Integer page;
    private Integer rows;
    private String databaseProvider = Constants.DATABASE_PROVIDER_MYSQL;

    public PagedSearchModel() {

    }

    public PagedSearchModel(boolean setDeletedSearchCondition) {
        super(setDeletedSearchCondition);
    }

    public PagedSearchModel(List<SearchCondition> searchConditions, Integer page, Integer rows) {
        super(searchConditions);
        this.page = page;
        this.rows = rows;
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
}
