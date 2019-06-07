package build.dream.common.models.alipay;

public class AlipayMarketingCardBenefitModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardBenefitModifyModel> {
        @Override
        public AlipayMarketingCardBenefitModifyModel build() {
            AlipayMarketingCardBenefitModifyModel alipayMarketingCardBenefitModifyModel = super.build();
            return alipayMarketingCardBenefitModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
