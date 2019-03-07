package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeDebarkApplyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicLifeDebarkApplyModel instance = new AlipayOpenPublicLifeDebarkApplyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicLifeDebarkApplyModel build() {
            AlipayOpenPublicLifeDebarkApplyModel alipayOpenPublicLifeDebarkApplyModel = new AlipayOpenPublicLifeDebarkApplyModel();
            alipayOpenPublicLifeDebarkApplyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeDebarkApplyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicLifeDebarkApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
