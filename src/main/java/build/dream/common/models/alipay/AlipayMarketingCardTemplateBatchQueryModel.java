package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardTemplateBatchQueryModel instance = new AlipayMarketingCardTemplateBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardTemplateBatchQueryModel build() {
            AlipayMarketingCardTemplateBatchQueryModel alipayMarketingCardTemplateBatchQueryModel = new AlipayMarketingCardTemplateBatchQueryModel();
            alipayMarketingCardTemplateBatchQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingCardTemplateBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardTemplateBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
