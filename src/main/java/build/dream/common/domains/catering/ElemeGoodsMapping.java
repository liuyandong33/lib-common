package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

public class ElemeGoodsMapping extends BasicDomain {
    /**
     * 商户ID
     */
    private Long tenantId;

    /**
     * 商户编号
     */
    private String tenantCode;

    /**
     * 门店ID
     */
    private Long branchId;

    /**
     * 饿了么商品ID
     */
    private Long elemeGoodsId;

    /**
     * 饿了么规格ID
     */
    private Long elemeSpecId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品规格ID
     */
    private Long goodsSpecificationId;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getElemeGoodsId() {
        return elemeGoodsId;
    }

    public void setElemeGoodsId(Long elemeGoodsId) {
        this.elemeGoodsId = elemeGoodsId;
    }

    public Long getElemeSpecId() {
        return elemeSpecId;
    }

    public void setElemeSpecId(Long elemeSpecId) {
        this.elemeSpecId = elemeSpecId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(Long goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, ElemeGoodsMapping> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder elemeGoodsId(Long elemeGoodsId) {
            instance.setElemeGoodsId(elemeGoodsId);
            return this;
        }

        public Builder elemeSpecId(Long elemeSpecId) {
            instance.setElemeSpecId(elemeSpecId);
            return this;
        }

        public Builder goodsId(Long goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsSpecificationId(Long goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        @Override
        public ElemeGoodsMapping build() {
            ElemeGoodsMapping elemeGoodsMapping = super.build();
            elemeGoodsMapping.setTenantId(instance.getTenantId());
            elemeGoodsMapping.setTenantCode(instance.getTenantCode());
            elemeGoodsMapping.setBranchId(instance.getBranchId());
            elemeGoodsMapping.setElemeGoodsId(instance.getElemeGoodsId());
            elemeGoodsMapping.setElemeSpecId(instance.getElemeSpecId());
            elemeGoodsMapping.setGoodsId(instance.getGoodsId());
            elemeGoodsMapping.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            return elemeGoodsMapping;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String ELEME_GOODS_ID = "eleme_goods_id";
        public static final String ELEME_SPEC_ID = "eleme_spec_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String ELEME_GOODS_ID = "elemeGoodsId";
        public static final String ELEME_SPEC_ID = "elemeSpecId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
    }
}