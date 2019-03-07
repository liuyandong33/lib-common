package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicTopicCreateModel instance = new AlipayOpenPublicTopicCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicTopicCreateModel build() {
            AlipayOpenPublicTopicCreateModel alipayOpenPublicTopicCreateModel = new AlipayOpenPublicTopicCreateModel();
            alipayOpenPublicTopicCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTopicCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicTopicCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
