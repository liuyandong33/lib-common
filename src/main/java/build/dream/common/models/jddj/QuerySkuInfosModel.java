package build.dream.common.models.jddj;

import javax.validation.constraints.Min;

public class QuerySkuInfosModel extends JDDJBasicModel {
    /**
     * 商品名称(支持模糊查询)
     */
    private String skuName;

    /**
     * 商品UPC编码
     */
    private String upcCode;

    /**
     * 到家商品编码
     */
    private Long skuId;

    /**
     * 当前页
     */
    @Min(value = 1)
    private Integer pageNo;

    /**
     * 分页大小
     */
    @Min(value = 1)
    private Integer pageSize;

    /**
     * 是否查询出已删除的上传商品(0代表不查已删除商品,不填则查出全部商品)
     */
    private String isFilterDel;

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getIsFilterDel() {
        return isFilterDel;
    }

    public void setIsFilterDel(String isFilterDel) {
        this.isFilterDel = isFilterDel;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, QuerySkuInfosModel> {
        public Builder skuName(String skuName) {
            instance.setSkuName(skuName);
            return this;
        }

        public Builder upcCode(String upcCode) {
            instance.setUpcCode(upcCode);
            return this;
        }

        public Builder skuId(Long skuId) {
            instance.setSkuId(skuId);
            return this;
        }

        public Builder pageNo(Integer pageNo) {
            instance.setPageNo(pageNo);
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public Builder isFilterDel(String isFilterDel) {
            instance.setIsFilterDel(isFilterDel);
            return this;
        }

        @Override
        public QuerySkuInfosModel build() {
            QuerySkuInfosModel querySkuInfosModel = super.build();
            querySkuInfosModel.setSkuName(instance.getSkuName());
            querySkuInfosModel.setUpcCode(instance.getUpcCode());
            querySkuInfosModel.setSkuId(instance.getSkuId());
            querySkuInfosModel.setPageNo(instance.getPageNo());
            querySkuInfosModel.setPageSize(instance.getPageSize());
            querySkuInfosModel.setIsFilterDel(instance.getIsFilterDel());
            return querySkuInfosModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
