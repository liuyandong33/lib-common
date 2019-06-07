package build.dream.common.models.alipay;

public class KoubeiMarketingCampaignActivityCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiMarketingCampaignActivityCreateModel> {
        @Override
        public KoubeiMarketingCampaignActivityCreateModel build() {
            KoubeiMarketingCampaignActivityCreateModel koubeiMarketingCampaignActivityCreateModel = super.build();
            return koubeiMarketingCampaignActivityCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
