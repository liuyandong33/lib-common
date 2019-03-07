package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeAboardApplyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicLifeAboardApplyModel instance = new AlipayOpenPublicLifeAboardApplyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicLifeAboardApplyModel build() {
            AlipayOpenPublicLifeAboardApplyModel alipayOpenPublicLifeAboardApplyModel = new AlipayOpenPublicLifeAboardApplyModel();
            alipayOpenPublicLifeAboardApplyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeAboardApplyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicLifeAboardApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
