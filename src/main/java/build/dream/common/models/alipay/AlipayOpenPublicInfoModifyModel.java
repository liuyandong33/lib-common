package build.dream.common.models.alipay;

public class AlipayOpenPublicInfoModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicInfoModifyModel instance = new AlipayOpenPublicInfoModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicInfoModifyModel build() {
            AlipayOpenPublicInfoModifyModel alipayOpenPublicInfoModifyModel = new AlipayOpenPublicInfoModifyModel();
            alipayOpenPublicInfoModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicInfoModifyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicInfoModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
