package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardBenefitModifyModel instance = new AlipayMarketingCardBenefitModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardBenefitModifyModel build() {
            AlipayMarketingCardBenefitModifyModel alipayMarketingCardBenefitModifyModel = new AlipayMarketingCardBenefitModifyModel();
            build(alipayMarketingCardBenefitModifyModel);
            return alipayMarketingCardBenefitModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
