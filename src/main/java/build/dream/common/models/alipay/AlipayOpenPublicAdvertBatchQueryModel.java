package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicAdvertBatchQueryModel instance = new AlipayOpenPublicAdvertBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicAdvertBatchQueryModel build() {
            AlipayOpenPublicAdvertBatchQueryModel alipayOpenPublicAdvertBatchQueryModel = new AlipayOpenPublicAdvertBatchQueryModel();
            alipayOpenPublicAdvertBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicAdvertBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicAdvertBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
