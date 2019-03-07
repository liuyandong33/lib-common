package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardBenefitQueryModel instance = new AlipayMarketingCardBenefitQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardBenefitQueryModel build() {
            AlipayMarketingCardBenefitQueryModel alipayMarketingCardBenefitQueryModel = new AlipayMarketingCardBenefitQueryModel();
            alipayMarketingCardBenefitQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingCardBenefitQueryModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardBenefitQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
