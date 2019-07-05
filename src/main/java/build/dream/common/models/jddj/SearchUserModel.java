package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class SearchUserModel extends JDDJBasicModel {
    /**
     * 当前页数
     */
    @NotNull
    private String pageNo;

    /**
     * 每页条数
     */
    @NotNull
    private String pageSize;

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, SearchUserModel> {
        public Builder pageNo(String pageNo) {
            instance.setPageNo(pageNo);
            return this;
        }

        public Builder pageSize(String pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        @Override
        public SearchUserModel build() {
            SearchUserModel searchUserModel = super.build();
            searchUserModel.setPageNo(instance.getPageNo());
            searchUserModel.setPageSize(instance.getPageSize());
            return searchUserModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
