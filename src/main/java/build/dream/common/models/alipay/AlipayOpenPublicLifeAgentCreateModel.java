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
