package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupCrowdQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicGroupCrowdQueryModel instance = new AlipayOpenPublicGroupCrowdQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicGroupCrowdQueryModel build() {
            AlipayOpenPublicGroupCrowdQueryModel alipayOpenPublicGroupCrowdQueryModel = new AlipayOpenPublicGroupCrowdQueryModel();
            alipayOpenPublicGroupCrowdQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicGroupCrowdQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicGroupCrowdQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
