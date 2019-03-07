package build.dream.common.models.alipay;

public class AlipayOpenPublicDefaultExtensionCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicDefaultExtensionCreateModel instance = new AlipayOpenPublicDefaultExtensionCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicDefaultExtensionCreateModel build() {
            AlipayOpenPublicDefaultExtensionCreateModel alipayOpenPublicDefaultExtensionCreateModel = new AlipayOpenPublicDefaultExtensionCreateModel();
            alipayOpenPublicDefaultExtensionCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicDefaultExtensionCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicDefaultExtensionCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
