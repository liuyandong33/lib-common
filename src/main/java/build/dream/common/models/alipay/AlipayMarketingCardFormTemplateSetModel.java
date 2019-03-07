package build.dream.common.models.alipay;

public class AlipayMarketingCardFormTemplateSetModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardFormTemplateSetModel instance = new AlipayMarketingCardFormTemplateSetModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardFormTemplateSetModel build() {
            AlipayMarketingCardFormTemplateSetModel alipayMarketingCardFormTemplateSetModel = new AlipayMarketingCardFormTemplateSetModel();
            alipayMarketingCardFormTemplateSetModel.setTenantId(instance.getTenantId());
            alipayMarketingCardFormTemplateSetModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardFormTemplateSetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
