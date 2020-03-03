package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class TenantGoods extends BasicDomain {
    public static final String TABLE_NAME = "tenant_goods";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 过期时间
     */
    private Date expireTime;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public static class Builder extends BasicDomain.Builder<Builder, TenantGoods> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder goodsId(Long goodsId) {
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
