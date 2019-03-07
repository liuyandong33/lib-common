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

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
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
