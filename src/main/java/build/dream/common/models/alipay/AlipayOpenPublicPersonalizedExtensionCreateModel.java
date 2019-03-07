package build.dream.common.models.alipay;

public class AlipayOpenPublicPersonalizedExtensionCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicPersonalizedExtensionCreateModel instance = new AlipayOpenPublicPersonalizedExtensionCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicPersonalizedExtensionCreateModel build() {
            AlipayOpenPublicPersonalizedExtensionCreateModel alipayOpenPublicPersonalizedExtensionCreateModel = new AlipayOpenPublicPersonalizedExtensionCreateModel();
            alipayOpenPublicPersonalizedExtensionCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPersonalizedExtensionCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicPersonalizedExtensionCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
