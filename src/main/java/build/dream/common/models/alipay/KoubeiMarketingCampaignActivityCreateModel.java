package build.dream.common.models.alipay;

public class KoubeiMarketingCampaignActivityCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiMarketingCampaignActivityCreateModel instance = new KoubeiMarketingCampaignActivityCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public KoubeiMarketingCampaignActivityCreateModel build() {
            KoubeiMarketingCampaignActivityCreateModel koubeiMarketingCampaignActivityCreateModel = new KoubeiMarketingCampaignActivityCreateModel();
            koubeiMarketingCampaignActivityCreateModel.setTenantId(instance.getTenantId());
            koubeiMarketingCampaignActivityCreateModel.setBranchId(instance.getBranchId());
            return koubeiMarketingCampaignActivityCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
