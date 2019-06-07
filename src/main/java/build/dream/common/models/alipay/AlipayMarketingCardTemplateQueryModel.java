package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardTemplateQueryModel> {
        @Override
        public AlipayMarketingCardTemplateQueryModel build() {
            AlipayMarketingCardTemplateQueryModel alipayMarketingCardTemplateQueryModel = super.build();
            return alipayMarketingCardTemplateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
