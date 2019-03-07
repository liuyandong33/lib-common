package build.dream.common.models.alipay;

public class AlipayOpenPublicDefaultExtensionCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicDefaultExtensionCreateModel instance = new AlipayOpenPublicDefaultExtensionCreateModel();

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

        public AlipayOpenPublicDefaultExtensionCreateModel build() {
            AlipayOpenPublicDefaultExtensionCreateModel alipayOpenPublicDefaultExtensionCreateModel = new AlipayOpenPublicDefaultExtensionCreateModel();
            alipayOpenPublicDefaultExtensionCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicDefaultExtensionCreateModel.setBranchId(instance.getBranchId());
            alipayOpenPublicDefaultExtensionCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicDefaultExtensionCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicDefaultExtensionCreateModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicDefaultExtensionCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
