package build.dream.common.models.alipay;

public class AlipayMarketingCampaignCashCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCampaignCashCreateModel instance = new AlipayMarketingCampaignCashCreateModel();

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

        public AlipayMarketingCampaignCashCreateModel build() {
            AlipayMarketingCampaignCashCreateModel alipayMarketingCampaignCashCreateModel = new AlipayMarketingCampaignCashCreateModel();
            alipayMarketingCampaignCashCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingCampaignCashCreateModel.setBranchId(instance.getBranchId());
            alipayMarketingCampaignCashCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingCampaignCashCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingCampaignCashCreateModel.setAuthToken(instance.getAuthToken());
            return alipayMarketingCampaignCashCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
