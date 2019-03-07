package build.dream.common.models.alipay;

public class AlipayUserInfoShareModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayUserInfoShareModel instance = new AlipayUserInfoShareModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayUserInfoShareModel build() {
            AlipayUserInfoShareModel alipayUserInfoShareModel = new AlipayUserInfoShareModel();
            alipayUserInfoShareModel.setTenantId(instance.getTenantId());
            alipayUserInfoShareModel.setBranchId(instance.getBranchId());
            return alipayUserInfoShareModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
