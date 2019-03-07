package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicTopicBatchQueryModel instance = new AlipayOpenPublicTopicBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicTopicBatchQueryModel build() {
            AlipayOpenPublicTopicBatchQueryModel alipayOpenPublicTopicBatchQueryModel = new AlipayOpenPublicTopicBatchQueryModel();
            alipayOpenPublicTopicBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTopicBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicTopicBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
