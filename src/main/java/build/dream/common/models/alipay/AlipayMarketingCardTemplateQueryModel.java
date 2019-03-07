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

        public AlipayMarketingCardTemplateQueryModel build() {
            AlipayMarketingCardTemplateQueryModel alipayMarketingCardTemplateQueryModel = new AlipayMarketingCardTemplateQueryModel();
            alipayMarketingCardTemplateQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingCardTemplateQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingCardTemplateQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingCardTemplateQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingCardTemplateQueryModel.setAuthToken(instance.getAuthToken());
            return alipayMarketingCardTemplateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
