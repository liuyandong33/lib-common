package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class ElemeBranchMapping extends BasicDomain {
    public static final String TABLE_NAME = "eleme_branch_mapping";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 饿了么门店ID
     */
    private BigInteger shopId;

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

    public BigInteger getShopId() {
        return shopId;
    }

    public void setShopId(BigInteger shopId) {
        this.shopId = shopId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, ElemeBranchMapping> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder shopId(BigInteger shopId) {
            instance.setShopId(shopId);
            return this;
        }

        @Override
        public ElemeBranchMapping build() {
            ElemeBranchMapping elemeBranchMapping = super.build();
            elemeBranchMapping.setTenantId(instance.getTenantId());
            elemeBranchMapping.setBranchId(instance.getBranchId());
            elemeBranchMapping.setShopId(instance.getShopId());
            return elemeBranchMapping;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String SHOP_ID = "shop_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String SHOP_ID = "shopId";
    }
}
