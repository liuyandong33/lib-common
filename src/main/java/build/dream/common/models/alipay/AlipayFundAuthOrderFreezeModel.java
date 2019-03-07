package build.dream.common.models.alipay;

public class AlipayFundAuthOrderFreezeModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayFundAuthOrderFreezeModel instance = new AlipayFundAuthOrderFreezeModel();

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

        public AlipayFundAuthOrderFreezeModel build() {
            AlipayFundAuthOrderFreezeModel alipayFundAuthOrderFreezeModel = new AlipayFundAuthOrderFreezeModel();
            alipayFundAuthOrderFreezeModel.setTenantId(instance.getTenantId());
            alipayFundAuthOrderFreezeModel.setBranchId(instance.getBranchId());
            return alipayFundAuthOrderFreezeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
