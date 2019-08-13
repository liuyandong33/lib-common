package build.dream.common.domains.saas;

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

    public static class Builder extends BasicDomain.Builder<Builder, TenantGoods> {
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

        @Override
        public TenantGoods build() {
            TenantGoods tenantGoods = super.build();
            tenantGoods.setTenantId(instance.getTenantId());
            tenantGoods.setBranchId(instance.getBranchId());
            tenantGoods.setGoodsId(instance.getGoodsId());
            tenantGoods.setExpireTime(instance.getExpireTime());
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
