package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardBenefitCreateModel instance = new AlipayMarketingCardBenefitCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardBenefitCreateModel build() {
            AlipayMarketingCardBenefitCreateModel alipayMarketingCardBenefitCreateModel = new AlipayMarketingCardBenefitCreateModel();
            alipayMarketingCardBenefitCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingCardBenefitCreateModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardBenefitCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
