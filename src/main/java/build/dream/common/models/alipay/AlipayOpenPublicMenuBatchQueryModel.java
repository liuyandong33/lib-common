package build.dream.common.models.alipay;

public class AlipayOpenPublicMenuBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMenuBatchQueryModel instance = new AlipayOpenPublicMenuBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicMenuBatchQueryModel build() {
            AlipayOpenPublicMenuBatchQueryModel alipayOpenPublicMenuBatchQueryModel = new AlipayOpenPublicMenuBatchQueryModel();
            alipayOpenPublicMenuBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMenuBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMenuBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
