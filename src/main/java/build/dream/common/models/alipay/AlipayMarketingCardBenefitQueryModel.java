package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardBenefitQueryModel> {
        @Override
        public AlipayMarketingCardBenefitQueryModel build() {
            AlipayMarketingCardBenefitQueryModel alipayMarketingCardBenefitQueryModel = super.build();
            return alipayMarketingCardBenefitQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
