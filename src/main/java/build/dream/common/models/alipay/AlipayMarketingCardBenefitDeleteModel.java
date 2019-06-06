package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitDeleteModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardBenefitDeleteModel instance = new AlipayMarketingCardBenefitDeleteModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardBenefitDeleteModel build() {
            AlipayMarketingCardBenefitDeleteModel alipayMarketingCardBenefitDeleteModel = new AlipayMarketingCardBenefitDeleteModel();
            build(alipayMarketingCardBenefitDeleteModel);
            return alipayMarketingCardBenefitDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
