package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeLabelBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicLifeLabelBatchQueryModel instance = new AlipayOpenPublicLifeLabelBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicLifeLabelBatchQueryModel build() {
            AlipayOpenPublicLifeLabelBatchQueryModel alipayOpenPublicLifeLabelBatchQueryModel = new AlipayOpenPublicLifeLabelBatchQueryModel();
            alipayOpenPublicLifeLabelBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeLabelBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicLifeLabelBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
