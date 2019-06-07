package build.dream.common.models.alipay;

public class AlipayMarketingCashVoucherTemplateCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCashVoucherTemplateCreateModel> {
        @Override
        public AlipayMarketingCashVoucherTemplateCreateModel build() {
            AlipayMarketingCashVoucherTemplateCreateModel alipayMarketingCashVoucherTemplateCreateModel = super.build();
            return alipayMarketingCashVoucherTemplateCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
