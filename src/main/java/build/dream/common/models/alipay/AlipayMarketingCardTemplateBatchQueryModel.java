package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardTemplateBatchQueryModel instance = new AlipayMarketingCardTemplateBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardTemplateBatchQueryModel build() {
            AlipayMarketingCardTemplateBatchQueryModel alipayMarketingCardTemplateBatchQueryModel = new AlipayMarketingCardTemplateBatchQueryModel();
            build(alipayMarketingCardTemplateBatchQueryModel);
            return alipayMarketingCardTemplateBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
