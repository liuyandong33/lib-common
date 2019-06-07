package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardBenefitCreateModel> {
        @Override
        public AlipayMarketingCardBenefitCreateModel build() {
            AlipayMarketingCardBenefitCreateModel alipayMarketingCardBenefitCreateModel = super.build();
            return alipayMarketingCardBenefitCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
