package build.dream.common.models.alipay;

public class AlipayMarketingToolFengDieActivityCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingToolFengDieActivityCreateModel instance = new AlipayMarketingToolFengDieActivityCreateModel();

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

        public AlipayMarketingToolFengDieActivityCreateModel build() {
            AlipayMarketingToolFengDieActivityCreateModel alipayMarketingToolFengDieActivityCreateModel = new AlipayMarketingToolFengDieActivityCreateModel();
            alipayMarketingToolFengDieActivityCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingToolFengDieActivityCreateModel.setBranchId(instance.getBranchId());
            alipayMarketingToolFengDieActivityCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingToolFengDieActivityCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingToolFengDieActivityCreateModel.setAuthToken(instance.getAuthToken());
            return alipayMarketingToolFengDieActivityCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
