package build.dream.common.models.alipay;

public class AlipayOpenPublicMenuCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMenuCreateModel instance = new AlipayOpenPublicMenuCreateModel();

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

        public AlipayOpenPublicMenuCreateModel build() {
            AlipayOpenPublicMenuCreateModel alipayOpenPublicMenuCreateModel = new AlipayOpenPublicMenuCreateModel();
            alipayOpenPublicMenuCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMenuCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMenuCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
