package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardTemplateBatchQueryModel> {
        @Override
        public AlipayMarketingCardTemplateBatchQueryModel build() {
            AlipayMarketingCardTemplateBatchQueryModel alipayMarketingCardTemplateBatchQueryModel = super.build();
            return alipayMarketingCardTemplateBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
