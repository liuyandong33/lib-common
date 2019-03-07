package build.dream.common.models.alipay;

public class AlipayMarketingCardQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardQueryModel instance = new AlipayMarketingCardQueryModel();

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

        public AlipayMarketingCardQueryModel build() {
            AlipayMarketingCardQueryModel alipayMarketingCardQueryModel = new AlipayMarketingCardQueryModel();
            alipayMarketingCardQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingCardQueryModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
