package build.dream.common.models.alipay;

public class KoubeiTradeOrderConsultModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiTradeOrderConsultModel instance = new KoubeiTradeOrderConsultModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public KoubeiTradeOrderConsultModel build() {
            KoubeiTradeOrderConsultModel koubeiTradeOrderConsultModel = new KoubeiTradeOrderConsultModel();
            build(koubeiTradeOrderConsultModel);
            return koubeiTradeOrderConsultModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
