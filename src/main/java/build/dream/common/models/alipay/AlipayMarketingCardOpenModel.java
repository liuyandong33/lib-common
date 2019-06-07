package build.dream.common.models.alipay;

public class AlipayMarketingCardOpenModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardOpenModel> {
        @Override
        public AlipayMarketingCardOpenModel build() {
            AlipayMarketingCardOpenModel alipayMarketingCardOpenModel = super.build();
            return alipayMarketingCardOpenModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
