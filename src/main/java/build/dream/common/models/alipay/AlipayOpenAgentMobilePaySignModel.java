package build.dream.common.models.alipay;

public class AlipayOpenAgentMobilePaySignModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenAgentMobilePaySignModel instance = new AlipayOpenAgentMobilePaySignModel();

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

        public AlipayOpenAgentMobilePaySignModel build() {
            AlipayOpenAgentMobilePaySignModel alipayOpenAgentMobilePaySignModel = new AlipayOpenAgentMobilePaySignModel();
            alipayOpenAgentMobilePaySignModel.setTenantId(instance.getTenantId());
            alipayOpenAgentMobilePaySignModel.setBranchId(instance.getBranchId());
            return alipayOpenAgentMobilePaySignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
