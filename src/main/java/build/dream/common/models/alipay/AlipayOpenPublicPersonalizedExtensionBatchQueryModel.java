package build.dream.common.models.alipay;

public class AlipayOpenPublicPersonalizedExtensionBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicPersonalizedExtensionBatchQueryModel instance = new AlipayOpenPublicPersonalizedExtensionBatchQueryModel();

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

        public AlipayOpenPublicPersonalizedExtensionBatchQueryModel build() {
            AlipayOpenPublicPersonalizedExtensionBatchQueryModel alipayOpenPublicPersonalizedExtensionBatchQueryModel = new AlipayOpenPublicPersonalizedExtensionBatchQueryModel();
            alipayOpenPublicPersonalizedExtensionBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPersonalizedExtensionBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicPersonalizedExtensionBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
