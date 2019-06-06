package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardTemplateQueryModel instance = new AlipayMarketingCardTemplateQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardTemplateQueryModel build() {
            AlipayMarketingCardTemplateQueryModel alipayMarketingCardTemplateQueryModel = new AlipayMarketingCardTemplateQueryModel();
            build(alipayMarketingCardTemplateQueryModel);
            return alipayMarketingCardTemplateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
