package build.dream.common.models.alipay;

public class KoubeiMarketingCampaignActivityCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiMarketingCampaignActivityCreateModel instance = new KoubeiMarketingCampaignActivityCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public KoubeiMarketingCampaignActivityCreateModel build() {
            KoubeiMarketingCampaignActivityCreateModel koubeiMarketingCampaignActivityCreateModel = new KoubeiMarketingCampaignActivityCreateModel();
            build(koubeiMarketingCampaignActivityCreateModel);
            return koubeiMarketingCampaignActivityCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
