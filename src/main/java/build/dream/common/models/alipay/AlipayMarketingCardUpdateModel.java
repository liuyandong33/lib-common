package build.dream.common.models.alipay;

public class AlipayMarketingCardUpdateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardUpdateModel instance = new AlipayMarketingCardUpdateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardUpdateModel build() {
            AlipayMarketingCardUpdateModel alipayMarketingCardUpdateModel = new AlipayMarketingCardUpdateModel();
            build(alipayMarketingCardUpdateModel);
            return alipayMarketingCardUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
