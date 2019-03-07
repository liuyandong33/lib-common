package build.dream.common.models.alipay;

public class AlipayOfflineMarketShopModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOfflineMarketShopModifyModel instance = new AlipayOfflineMarketShopModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOfflineMarketShopModifyModel build() {
            AlipayOfflineMarketShopModifyModel alipayOfflineMarketShopModifyModel = new AlipayOfflineMarketShopModifyModel();
            alipayOfflineMarketShopModifyModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketShopModifyModel.setBranchId(instance.getBranchId());
            return alipayOfflineMarketShopModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
