package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardTemplateModifyModel instance = new AlipayMarketingCardTemplateModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardTemplateModifyModel build() {
            AlipayMarketingCardTemplateModifyModel alipayMarketingCardTemplateModifyModel = new AlipayMarketingCardTemplateModifyModel();
            alipayMarketingCardTemplateModifyModel.setTenantId(instance.getTenantId());
            alipayMarketingCardTemplateModifyModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardTemplateModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
