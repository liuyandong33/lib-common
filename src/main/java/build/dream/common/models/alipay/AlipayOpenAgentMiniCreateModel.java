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

        public AlipayOpenAgentMiniCreateModel build() {
            AlipayOpenAgentMiniCreateModel alipayOpenAgentMiniCreateModel = new AlipayOpenAgentMiniCreateModel();
            alipayOpenAgentMiniCreateModel.setTenantId(instance.getTenantId());
            alipayOpenAgentMiniCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenAgentMiniCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
