package build.dream.common.models.alipay;

public class AlipayOfflineMarketApplyOrderBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOfflineMarketApplyOrderBatchQueryModel instance = new AlipayOfflineMarketApplyOrderBatchQueryModel();

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

        public AlipayOfflineMarketApplyOrderBatchQueryModel build() {
            AlipayOfflineMarketApplyOrderBatchQueryModel alipayOfflineMarketApplyOrderBatchQueryModel = new AlipayOfflineMarketApplyOrderBatchQueryModel();
            alipayOfflineMarketApplyOrderBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketApplyOrderBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOfflineMarketApplyOrderBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
