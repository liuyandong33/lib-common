package build.dream.common.models.alipay;

public class KoubeiMarketingCampaignActivityModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiMarketingCampaignActivityModifyModel> {
        @Override
        public KoubeiMarketingCampaignActivityModifyModel build() {
            KoubeiMarketingCampaignActivityModifyModel koubeiMarketingCampaignActivityModifyModel = super.build();
            return koubeiMarketingCampaignActivityModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
