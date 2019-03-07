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

        public AlipayMarketingCampaignCashCreateModel build() {
            AlipayMarketingCampaignCashCreateModel alipayMarketingCampaignCashCreateModel = new AlipayMarketingCampaignCashCreateModel();
            alipayMarketingCampaignCashCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingCampaignCashCreateModel.setBranchId(instance.getBranchId());
            return alipayMarketingCampaignCashCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}