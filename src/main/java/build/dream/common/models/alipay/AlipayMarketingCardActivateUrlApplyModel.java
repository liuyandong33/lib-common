package build.dream.common.models.alipay;

public class AlipayMarketingCardActivateUrlApplyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardActivateUrlApplyModel> {
        @Override
        public AlipayMarketingCardActivateUrlApplyModel build() {
            AlipayMarketingCardActivateUrlApplyModel alipayMarketingCardActivateUrlApplyModel = super.build();
            return alipayMarketingCardActivateUrlApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
