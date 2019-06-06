package build.dream.common.models.alipay;

public class AlipayMarketingCardOpenModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardOpenModel instance = new AlipayMarketingCardOpenModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardOpenModel build() {
            AlipayMarketingCardOpenModel alipayMarketingCardOpenModel = new AlipayMarketingCardOpenModel();
            build(alipayMarketingCardOpenModel);
            return alipayMarketingCardOpenModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
