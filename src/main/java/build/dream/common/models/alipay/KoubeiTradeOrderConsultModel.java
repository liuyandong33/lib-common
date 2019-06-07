package build.dream.common.models.alipay;

public class KoubeiTradeOrderConsultModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiTradeOrderConsultModel> {
        @Override
        public KoubeiTradeOrderConsultModel build() {
            KoubeiTradeOrderConsultModel koubeiTradeOrderConsultModel = super.build();
            return koubeiTradeOrderConsultModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
