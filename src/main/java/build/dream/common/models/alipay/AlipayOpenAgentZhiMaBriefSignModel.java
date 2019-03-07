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

        public AlipayOpenAgentZhiMaBriefSignModel build() {
            AlipayOpenAgentZhiMaBriefSignModel alipayOpenAgentZhiMaBriefSignModel = new AlipayOpenAgentZhiMaBriefSignModel();
            alipayOpenAgentZhiMaBriefSignModel.setTenantId(instance.getTenantId());
            alipayOpenAgentZhiMaBriefSignModel.setBranchId(instance.getBranchId());
            return alipayOpenAgentZhiMaBriefSignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
