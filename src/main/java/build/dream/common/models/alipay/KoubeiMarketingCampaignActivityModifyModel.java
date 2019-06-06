package build.dream.common.models.alipay;

public class KoubeiMarketingCampaignActivityModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiMarketingCampaignActivityModifyModel instance = new KoubeiMarketingCampaignActivityModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public KoubeiMarketingCampaignActivityModifyModel build() {
            KoubeiMarketingCampaignActivityModifyModel koubeiMarketingCampaignActivityModifyModel = new KoubeiMarketingCampaignActivityModifyModel();
            build(koubeiMarketingCampaignActivityModifyModel);
            return koubeiMarketingCampaignActivityModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
