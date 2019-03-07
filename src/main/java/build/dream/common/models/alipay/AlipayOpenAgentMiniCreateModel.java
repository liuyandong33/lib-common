package build.dream.common.models.alipay;

public class AlipayOpenAgentMiniCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenAgentMiniCreateModel instance = new AlipayOpenAgentMiniCreateModel();

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

        public AlipayOpenAgentMiniCreateModel build() {
            AlipayOpenAgentMiniCreateModel alipayOpenAgentMiniCreateModel = new AlipayOpenAgentMiniCreateModel();
            alipayOpenAgentMiniCreateModel.setTenantId(instance.getTenantId());
            alipayOpenAgentMiniCreateModel.setBranchId(instance.getBranchId());
            alipayOpenAgentMiniCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenAgentMiniCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenAgentMiniCreateModel.setAuthToken(instance.getAuthToken());
            return alipayOpenAgentMiniCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
