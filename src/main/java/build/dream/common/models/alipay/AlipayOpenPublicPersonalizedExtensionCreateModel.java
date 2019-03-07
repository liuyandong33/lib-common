package build.dream.common.models.alipay;

public class AlipayOpenPublicPersonalizedExtensionCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicPersonalizedExtensionCreateModel instance = new AlipayOpenPublicPersonalizedExtensionCreateModel();

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

        public AlipayOpenPublicPersonalizedExtensionCreateModel build() {
            AlipayOpenPublicPersonalizedExtensionCreateModel alipayOpenPublicPersonalizedExtensionCreateModel = new AlipayOpenPublicPersonalizedExtensionCreateModel();
            alipayOpenPublicPersonalizedExtensionCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPersonalizedExtensionCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicPersonalizedExtensionCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
