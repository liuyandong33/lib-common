package build.dream.common.models.alipay;

public class AlipayMarketingCardUpdateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardUpdateModel> {
        @Override
        public AlipayMarketingCardUpdateModel build() {
            AlipayMarketingCardUpdateModel alipayMarketingCardUpdateModel = super.build();
            return alipayMarketingCardUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
