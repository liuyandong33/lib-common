package build.dream.common.models.alipay;

public class AlipayMarketingCashVoucherTemplateCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCashVoucherTemplateCreateModel instance = new AlipayMarketingCashVoucherTemplateCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayMarketingCashVoucherTemplateCreateModel build() {
            AlipayMarketingCashVoucherTemplateCreateModel alipayMarketingCashVoucherTemplateCreateModel = new AlipayMarketingCashVoucherTemplateCreateModel();
            build(alipayMarketingCashVoucherTemplateCreateModel);
            return alipayMarketingCashVoucherTemplateCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
