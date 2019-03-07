package build.dream.common.models.alipay;

public class AlipayUserCertifyOpenInitializeModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayUserCertifyOpenInitializeModel instance = new AlipayUserCertifyOpenInitializeModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayUserCertifyOpenInitializeModel build() {
            AlipayUserCertifyOpenInitializeModel alipayUserCertifyOpenInitializeModel = new AlipayUserCertifyOpenInitializeModel();
            alipayUserCertifyOpenInitializeModel.setTenantId(instance.getTenantId());
            alipayUserCertifyOpenInitializeModel.setBranchId(instance.getBranchId());
            return alipayUserCertifyOpenInitializeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
