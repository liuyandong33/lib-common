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
