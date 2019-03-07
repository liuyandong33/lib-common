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
