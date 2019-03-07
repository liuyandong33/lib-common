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
