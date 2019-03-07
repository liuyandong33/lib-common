package build.dream.common.models.alipay;

public class KoubeiMarketingCampaignActivityModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiMarketingCampaignActivityModifyModel instance = new KoubeiMarketingCampaignActivityModifyModel();

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

        public KoubeiMarketingCampaignActivityModifyModel build() {
            KoubeiMarketingCampaignActivityModifyModel koubeiMarketingCampaignActivityModifyModel = new KoubeiMarketingCampaignActivityModifyModel();
            koubeiMarketingCampaignActivityModifyModel.setTenantId(instance.getTenantId());
            koubeiMarketingCampaignActivityModifyModel.setBranchId(instance.getBranchId());
            koubeiMarketingCampaignActivityModifyModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingCampaignActivityModifyModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingCampaignActivityModifyModel.setAuthToken(instance.getAuthToken());
            return koubeiMarketingCampaignActivityModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
