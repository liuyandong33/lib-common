package build.dream.common.models.alipay;

public class AlipayOpenAgentFaceToFaceSignModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenAgentFaceToFaceSignModel instance = new AlipayOpenAgentFaceToFaceSignModel();

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

        public AlipayOpenAgentFaceToFaceSignModel build() {
            AlipayOpenAgentFaceToFaceSignModel alipayOpenAgentFaceToFaceSignModel = new AlipayOpenAgentFaceToFaceSignModel();
            alipayOpenAgentFaceToFaceSignModel.setTenantId(instance.getTenantId());
            alipayOpenAgentFaceToFaceSignModel.setBranchId(instance.getBranchId());
            return alipayOpenAgentFaceToFaceSignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
