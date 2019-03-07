package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageContentCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMessageContentCreateModel instance = new AlipayOpenPublicMessageContentCreateModel();

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

        public AlipayOpenPublicMessageContentCreateModel build() {
            AlipayOpenPublicMessageContentCreateModel alipayOpenPublicMessageContentCreateModel = new AlipayOpenPublicMessageContentCreateModel();
            alipayOpenPublicMessageContentCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageContentCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMessageContentCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
