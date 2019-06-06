package build.dream.common.models.alipay;

public class AlipayMarketingCardActivateUrlApplyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardActivateUrlApplyModel instance = new AlipayMarketingCardActivateUrlApplyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardActivateUrlApplyModel build() {
            AlipayMarketingCardActivateUrlApplyModel alipayMarketingCardActivateUrlApplyModel = new AlipayMarketingCardActivateUrlApplyModel();
            build(alipayMarketingCardActivateUrlApplyModel);
            return alipayMarketingCardActivateUrlApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
