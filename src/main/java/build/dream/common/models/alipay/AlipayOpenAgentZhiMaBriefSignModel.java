package build.dream.common.models.alipay;

public class AlipayOpenAgentZhiMaBriefSignModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenAgentZhiMaBriefSignModel instance = new AlipayOpenAgentZhiMaBriefSignModel();

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

        public AlipayOpenAgentZhiMaBriefSignModel build() {
            AlipayOpenAgentZhiMaBriefSignModel alipayOpenAgentZhiMaBriefSignModel = new AlipayOpenAgentZhiMaBriefSignModel();
            alipayOpenAgentZhiMaBriefSignModel.setTenantId(instance.getTenantId());
            alipayOpenAgentZhiMaBriefSignModel.setBranchId(instance.getBranchId());
            alipayOpenAgentZhiMaBriefSignModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenAgentZhiMaBriefSignModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenAgentZhiMaBriefSignModel.setAuthToken(instance.getAuthToken());
            return alipayOpenAgentZhiMaBriefSignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
