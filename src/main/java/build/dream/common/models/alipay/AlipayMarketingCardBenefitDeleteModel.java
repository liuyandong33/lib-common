package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitDeleteModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardBenefitDeleteModel> {
        @Override
        public AlipayMarketingCardBenefitDeleteModel build() {
            AlipayMarketingCardBenefitDeleteModel alipayMarketingCardBenefitDeleteModel = super.build();
            return alipayMarketingCardBenefitDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
