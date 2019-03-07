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
