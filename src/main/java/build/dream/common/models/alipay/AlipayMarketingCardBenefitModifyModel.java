package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardBenefitModifyModel instance = new AlipayMarketingCardBenefitModifyModel();

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

        public AlipayMarketingCardBenefitModifyModel build() {
            AlipayMarketingCardBenefitModifyModel alipayMarketingCardBenefitModifyModel = new AlipayMarketingCardBenefitModifyModel();
            alipayMarketingCardBenefitModifyModel.setTenantId(instance.getTenantId());
            alipayMarketingCardBenefitModifyModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardBenefitModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
