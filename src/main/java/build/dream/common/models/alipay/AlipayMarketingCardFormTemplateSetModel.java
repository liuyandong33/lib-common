package build.dream.common.models.alipay;

public class AlipayMarketingCardFormTemplateSetModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardFormTemplateSetModel instance = new AlipayMarketingCardFormTemplateSetModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardFormTemplateSetModel build() {
            AlipayMarketingCardFormTemplateSetModel alipayMarketingCardFormTemplateSetModel = new AlipayMarketingCardFormTemplateSetModel();
            build(alipayMarketingCardFormTemplateSetModel);
            return alipayMarketingCardFormTemplateSetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
