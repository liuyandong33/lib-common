package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardTemplateQueryModel instance = new AlipayMarketingCardTemplateQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardTemplateQueryModel build() {
            AlipayMarketingCardTemplateQueryModel alipayMarketingCardTemplateQueryModel = new AlipayMarketingCardTemplateQueryModel();
            alipayMarketingCardTemplateQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingCardTemplateQueryModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardTemplateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
