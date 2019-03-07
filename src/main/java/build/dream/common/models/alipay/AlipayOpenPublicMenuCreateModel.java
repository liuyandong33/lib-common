package build.dream.common.models.alipay;

public class AlipayOpenPublicMenuCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMenuCreateModel instance = new AlipayOpenPublicMenuCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicMenuCreateModel build() {
            AlipayOpenPublicMenuCreateModel alipayOpenPublicMenuCreateModel = new AlipayOpenPublicMenuCreateModel();
            alipayOpenPublicMenuCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMenuCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMenuCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
