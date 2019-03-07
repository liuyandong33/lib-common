package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicGroupBatchQueryModel instance = new AlipayOpenPublicGroupBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicGroupBatchQueryModel build() {
            AlipayOpenPublicGroupBatchQueryModel alipayOpenPublicGroupBatchQueryModel = new AlipayOpenPublicGroupBatchQueryModel();
            alipayOpenPublicGroupBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicGroupBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicGroupBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
