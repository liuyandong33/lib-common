package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class ElemeBranchMapping extends BasicDomain {
    public static final String TABLE_NAME = "eleme_branch_mapping";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 饿了么门店ID
     */
    private Long shopId;

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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, ElemeBranchMapping> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder shopId(Long shopId) {
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
