package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class TenantGoods extends BasicDomain {
    public static final String TABLE_NAME = "tenant_goods";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 商品ID
     */
    private BigInteger goodsId;
    /**
     * 过期时间
     */
    private Date expireTime;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public static class Builder {
        private final TenantGoods instance = new TenantGoods();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder expireTime(Date expireTime) {
            instance.setExpireTime(expireTime);
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

        public TenantGoods build() {
            TenantGoods tenantGoods = new TenantGoods();
            tenantGoods.setTenantId(instance.getTenantId());
            tenantGoods.setBranchId(instance.getBranchId());
            tenantGoods.setGoodsId(instance.getGoodsId());
            tenantGoods.setExpireTime(instance.getExpireTime());
            tenantGoods.setId(instance.getId());
            tenantGoods.setCreatedTime(instance.getCreatedTime());
            tenantGoods.setCreatedUserId(instance.getCreatedUserId());
            tenantGoods.setUpdatedTime(instance.getUpdatedTime());
            tenantGoods.setUpdatedUserId(instance.getUpdatedUserId());
            tenantGoods.setUpdatedRemark(instance.getUpdatedRemark());
            tenantGoods.setDeletedTime(instance.getDeletedTime());
            tenantGoods.setDeleted(instance.isDeleted());
            return tenantGoods;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String GOODS_ID = "goods_id";
        public static final String EXPIRE_TIME = "expire_time";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String GOODS_ID = "goodsId";
        public static final String EXPIRE_TIME = "expireTime";
    }
}
