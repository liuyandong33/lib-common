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

        public KoubeiMarketingCampaignActivityModifyModel build() {
            KoubeiMarketingCampaignActivityModifyModel koubeiMarketingCampaignActivityModifyModel = new KoubeiMarketingCampaignActivityModifyModel();
            koubeiMarketingCampaignActivityModifyModel.setTenantId(instance.getTenantId());
            koubeiMarketingCampaignActivityModifyModel.setBranchId(instance.getBranchId());
            return koubeiMarketingCampaignActivityModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
