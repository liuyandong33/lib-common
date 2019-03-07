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

        public AlipayMarketingCardFormTemplateSetModel build() {
            AlipayMarketingCardFormTemplateSetModel alipayMarketingCardFormTemplateSetModel = new AlipayMarketingCardFormTemplateSetModel();
            alipayMarketingCardFormTemplateSetModel.setTenantId(instance.getTenantId());
            alipayMarketingCardFormTemplateSetModel.setBranchId(instance.getBranchId());
            alipayMarketingCardFormTemplateSetModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingCardFormTemplateSetModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingCardFormTemplateSetModel.setAuthToken(instance.getAuthToken());
            return alipayMarketingCardFormTemplateSetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
