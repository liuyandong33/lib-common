package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitDeleteModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardBenefitDeleteModel instance = new AlipayMarketingCardBenefitDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardBenefitDeleteModel build() {
            AlipayMarketingCardBenefitDeleteModel alipayMarketingCardBenefitDeleteModel = new AlipayMarketingCardBenefitDeleteModel();
            alipayMarketingCardBenefitDeleteModel.setTenantId(instance.getTenantId());
            alipayMarketingCardBenefitDeleteModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardBenefitDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
