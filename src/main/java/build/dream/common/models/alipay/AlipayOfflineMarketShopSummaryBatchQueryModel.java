package build.dream.common.models.alipay;

public class AlipayOfflineMarketShopSummaryBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOfflineMarketShopSummaryBatchQueryModel instance = new AlipayOfflineMarketShopSummaryBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOfflineMarketShopSummaryBatchQueryModel build() {
            AlipayOfflineMarketShopSummaryBatchQueryModel alipayOfflineMarketShopSummaryBatchQueryModel = new AlipayOfflineMarketShopSummaryBatchQueryModel();
            alipayOfflineMarketShopSummaryBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketShopSummaryBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOfflineMarketShopSummaryBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
