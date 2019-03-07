package build.dream.common.models.alipay;

public class AlipayTradeCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayTradeCreateModel instance = new AlipayTradeCreateModel();

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

        public AlipayTradeCreateModel build() {
            AlipayTradeCreateModel alipayTradeCreateModel = new AlipayTradeCreateModel();
            alipayTradeCreateModel.setTenantId(instance.getTenantId());
            alipayTradeCreateModel.setBranchId(instance.getBranchId());
            alipayTradeCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayTradeCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayTradeCreateModel.setAuthToken(instance.getAuthToken());
            return alipayTradeCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
