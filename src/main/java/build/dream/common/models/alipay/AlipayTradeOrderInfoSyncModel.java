package build.dream.common.models.alipay;

public class AlipayTradeOrderInfoSyncModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayTradeOrderInfoSyncModel instance = new AlipayTradeOrderInfoSyncModel();

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

        public AlipayTradeOrderInfoSyncModel build() {
            AlipayTradeOrderInfoSyncModel alipayTradeOrderInfoSyncModel = new AlipayTradeOrderInfoSyncModel();
            alipayTradeOrderInfoSyncModel.setTenantId(instance.getTenantId());
            alipayTradeOrderInfoSyncModel.setBranchId(instance.getBranchId());
            alipayTradeOrderInfoSyncModel.setReturnUrl(instance.getReturnUrl());
            alipayTradeOrderInfoSyncModel.setNotifyUrl(instance.getNotifyUrl());
            alipayTradeOrderInfoSyncModel.setAuthToken(instance.getAuthToken());
            return alipayTradeOrderInfoSyncModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
