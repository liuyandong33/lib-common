package build.dream.common.models.alipay;

public class AlipayMarketingCardTemplateModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardTemplateModifyModel instance = new AlipayMarketingCardTemplateModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardTemplateModifyModel build() {
            AlipayMarketingCardTemplateModifyModel alipayMarketingCardTemplateModifyModel = new AlipayMarketingCardTemplateModifyModel();
            build(alipayMarketingCardTemplateModifyModel);
            return alipayMarketingCardTemplateModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
