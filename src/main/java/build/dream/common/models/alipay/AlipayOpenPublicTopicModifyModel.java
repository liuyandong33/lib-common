package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicTopicModifyModel instance = new AlipayOpenPublicTopicModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicTopicModifyModel build() {
            AlipayOpenPublicTopicModifyModel alipayOpenPublicTopicModifyModel = new AlipayOpenPublicTopicModifyModel();
            alipayOpenPublicTopicModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTopicModifyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicTopicModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
