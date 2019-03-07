package build.dream.common.models.alipay;

public class AlipayOpenPublicPersonalizedMenuCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicPersonalizedMenuCreateModel instance = new AlipayOpenPublicPersonalizedMenuCreateModel();

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

        public AlipayOpenPublicPersonalizedMenuCreateModel build() {
            AlipayOpenPublicPersonalizedMenuCreateModel alipayOpenPublicPersonalizedMenuCreateModel = new AlipayOpenPublicPersonalizedMenuCreateModel();
            alipayOpenPublicPersonalizedMenuCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPersonalizedMenuCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicPersonalizedMenuCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
