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

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public AlipayOfflineMarketShopSummaryBatchQueryModel build() {
            AlipayOfflineMarketShopSummaryBatchQueryModel alipayOfflineMarketShopSummaryBatchQueryModel = new AlipayOfflineMarketShopSummaryBatchQueryModel();
            alipayOfflineMarketShopSummaryBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketShopSummaryBatchQueryModel.setBranchId(instance.getBranchId());
            alipayOfflineMarketShopSummaryBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOfflineMarketShopSummaryBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOfflineMarketShopSummaryBatchQueryModel.setAuthToken(instance.getAuthToken());
            return alipayOfflineMarketShopSummaryBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
