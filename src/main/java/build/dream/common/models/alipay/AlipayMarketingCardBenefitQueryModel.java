package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCardBenefitQueryModel instance = new AlipayMarketingCardBenefitQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCardBenefitQueryModel build() {
            AlipayMarketingCardBenefitQueryModel alipayMarketingCardBenefitQueryModel = new AlipayMarketingCardBenefitQueryModel();
            build(alipayMarketingCardBenefitQueryModel);
            return alipayMarketingCardBenefitQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
