package build.dream.common.models.alipay;

public class AlipayMarketingCardQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardQueryModel> {
        @Override
        public AlipayMarketingCardQueryModel build() {
            AlipayMarketingCardQueryModel alipayMarketingCardQueryModel = super.build();
            return alipayMarketingCardQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
