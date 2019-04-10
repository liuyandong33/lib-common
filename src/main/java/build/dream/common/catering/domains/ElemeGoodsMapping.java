package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class ElemeGoodsMapping extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;

    /**
     * 商户编号
     */
    private String tenantCode;

    /**
     * 门店ID
     */
    private BigInteger branchId;

    /**
     * 饿了么商品ID
     */
    private BigInteger elemeGoodsId;

    /**
     * 饿了么规格ID
     */
    private BigInteger elemeSpecId;

    /**
     * 商品ID
     */
    private BigInteger goodsId;

    /**
     * 商品规格ID
     */
    private BigInteger goodsSpecificationId;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public BigInteger getElemeGoodsId() {
        return elemeGoodsId;
    }

    public void setElemeGoodsId(BigInteger elemeGoodsId) {
        this.elemeGoodsId = elemeGoodsId;
    }

    public BigInteger getElemeSpecId() {
        return elemeSpecId;
    }

    public void setElemeSpecId(BigInteger elemeSpecId) {
        this.elemeSpecId = elemeSpecId;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public BigInteger getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(BigInteger goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public static class Builder {
        private final ElemeGoodsMapping instance = new ElemeGoodsMapping();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder elemeGoodsId(BigInteger elemeGoodsId) {
            instance.setElemeGoodsId(elemeGoodsId);
            return this;
        }

        public Builder elemeSpecId(BigInteger elemeSpecId) {
            instance.setElemeSpecId(elemeSpecId);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsSpecificationId(BigInteger goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public ElemeGoodsMapping build() {
            ElemeGoodsMapping elemeGoodsMapping = new ElemeGoodsMapping();
            elemeGoodsMapping.setTenantId(instance.getTenantId());
            elemeGoodsMapping.setTenantCode(instance.getTenantCode());
            elemeGoodsMapping.setBranchId(instance.getBranchId());
            elemeGoodsMapping.setElemeGoodsId(instance.getElemeGoodsId());
            elemeGoodsMapping.setElemeSpecId(instance.getElemeSpecId());
            elemeGoodsMapping.setGoodsId(instance.getGoodsId());
            elemeGoodsMapping.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            elemeGoodsMapping.setId(instance.getId());
            elemeGoodsMapping.setCreatedTime(instance.getCreatedTime());
            elemeGoodsMapping.setCreatedUserId(instance.getCreatedUserId());
            elemeGoodsMapping.setUpdatedTime(instance.getUpdatedTime());
            elemeGoodsMapping.setUpdatedUserId(instance.getUpdatedUserId());
            elemeGoodsMapping.setUpdatedRemark(instance.getUpdatedRemark());
            elemeGoodsMapping.setDeletedTime(instance.getDeletedTime());
            elemeGoodsMapping.setDeleted(instance.isDeleted());
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