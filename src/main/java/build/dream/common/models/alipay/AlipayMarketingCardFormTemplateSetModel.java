package build.dream.common.models.alipay;

public class AlipayMarketingCardFormTemplateSetModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardFormTemplateSetModel> {
        @Override
        public AlipayMarketingCardFormTemplateSetModel build() {
            AlipayMarketingCardFormTemplateSetModel alipayMarketingCardFormTemplateSetModel = super.build();
            return alipayMarketingCardFormTemplateSetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
