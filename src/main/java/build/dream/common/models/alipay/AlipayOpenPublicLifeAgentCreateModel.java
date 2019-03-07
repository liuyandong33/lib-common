package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeAgentCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicLifeAgentCreateModel instance = new AlipayOpenPublicLifeAgentCreateModel();

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

        public AlipayOpenPublicLifeAgentCreateModel build() {
            AlipayOpenPublicLifeAgentCreateModel alipayOpenPublicLifeAgentCreateModel = new AlipayOpenPublicLifeAgentCreateModel();
            alipayOpenPublicLifeAgentCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeAgentCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicLifeAgentCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
