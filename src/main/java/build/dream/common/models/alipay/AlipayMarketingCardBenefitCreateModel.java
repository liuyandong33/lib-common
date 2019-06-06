package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardBenefitCreateModel instance = new AlipayMarketingCardBenefitCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardBenefitCreateModel build() {
            AlipayMarketingCardBenefitCreateModel alipayMarketingCardBenefitCreateModel = new AlipayMarketingCardBenefitCreateModel();
            build(alipayMarketingCardBenefitCreateModel);
            return alipayMarketingCardBenefitCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
