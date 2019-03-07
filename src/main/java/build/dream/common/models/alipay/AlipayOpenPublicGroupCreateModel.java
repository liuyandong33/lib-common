package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicGroupCreateModel instance = new AlipayOpenPublicGroupCreateModel();

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

        public AlipayOpenPublicGroupCreateModel build() {
            AlipayOpenPublicGroupCreateModel alipayOpenPublicGroupCreateModel = new AlipayOpenPublicGroupCreateModel();
            alipayOpenPublicGroupCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicGroupCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicGroupCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
