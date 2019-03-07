package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageContentCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMessageContentCreateModel instance = new AlipayOpenPublicMessageContentCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicMessageContentCreateModel build() {
            AlipayOpenPublicMessageContentCreateModel alipayOpenPublicMessageContentCreateModel = new AlipayOpenPublicMessageContentCreateModel();
            alipayOpenPublicMessageContentCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageContentCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMessageContentCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
