package build.dream.common.models.alipay;

public class AlipayMarketingCardQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardQueryModel instance = new AlipayMarketingCardQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardQueryModel build() {
            AlipayMarketingCardQueryModel alipayMarketingCardQueryModel = new AlipayMarketingCardQueryModel();
            build(alipayMarketingCardQueryModel);
            return alipayMarketingCardQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
