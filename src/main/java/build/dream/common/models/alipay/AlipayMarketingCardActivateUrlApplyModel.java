package build.dream.common.models.alipay;

public class AlipayMarketingCardActivateUrlApplyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardActivateUrlApplyModel instance = new AlipayMarketingCardActivateUrlApplyModel();

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

        public AlipayMarketingCardActivateUrlApplyModel build() {
            AlipayMarketingCardActivateUrlApplyModel alipayMarketingCardActivateUrlApplyModel = new AlipayMarketingCardActivateUrlApplyModel();
            alipayMarketingCardActivateUrlApplyModel.setTenantId(instance.getTenantId());
            alipayMarketingCardActivateUrlApplyModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardActivateUrlApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
