package build.dream.common.models.alipay;

public class KoubeiTradeTicketTicketCodeUseModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiTradeTicketTicketCodeUseModel instance = new KoubeiTradeTicketTicketCodeUseModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public KoubeiTradeTicketTicketCodeUseModel build() {
            KoubeiTradeTicketTicketCodeUseModel koubeiTradeTicketTicketCodeUseModel = new KoubeiTradeTicketTicketCodeUseModel();
            build(koubeiTradeTicketTicketCodeUseModel);
            return koubeiTradeTicketTicketCodeUseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
