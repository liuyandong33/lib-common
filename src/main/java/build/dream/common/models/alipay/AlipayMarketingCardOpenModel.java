package build.dream.common.models.alipay;

public class AlipayMarketingCardOpenModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardOpenModel instance = new AlipayMarketingCardOpenModel();

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

        public AlipayMarketingCardOpenModel build() {
            AlipayMarketingCardOpenModel alipayMarketingCardOpenModel = new AlipayMarketingCardOpenModel();
            alipayMarketingCardOpenModel.setTenantId(instance.getTenantId());
            alipayMarketingCardOpenModel.setBranchId(instance.getBranchId());
            alipayMarketingCardOpenModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingCardOpenModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingCardOpenModel.setAuthToken(instance.getAuthToken());
            alipayMarketingCardOpenModel.setAuthToken(instance.getAuthToken());
            return alipayMarketingCardOpenModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
