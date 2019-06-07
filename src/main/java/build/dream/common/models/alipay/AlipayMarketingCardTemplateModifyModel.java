package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardTemplateModifyModel> {
        @Override
        public AlipayMarketingCardTemplateModifyModel build() {
            AlipayMarketingCardTemplateModifyModel alipayMarketingCardTemplateModifyModel = super.build();
            return alipayMarketingCardTemplateModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
