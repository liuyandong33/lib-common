package build.dream.common.models.alipay;

public class AlipayMarketingCardUpdateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardUpdateModel instance = new AlipayMarketingCardUpdateModel();

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

        public AlipayMarketingCardUpdateModel build() {
            AlipayMarketingCardUpdateModel alipayMarketingCardUpdateModel = new AlipayMarketingCardUpdateModel();
            alipayMarketingCardUpdateModel.setTenantId(instance.getTenantId());
            alipayMarketingCardUpdateModel.setBranchId(instance.getBranchId());
            alipayMarketingCardUpdateModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingCardUpdateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingCardUpdateModel.setAuthToken(instance.getAuthToken());
            return alipayMarketingCardUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
