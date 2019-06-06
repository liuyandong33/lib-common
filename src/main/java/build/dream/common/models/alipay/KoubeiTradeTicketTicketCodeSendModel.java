package build.dream.common.models.alipay;

public class KoubeiTradeTicketTicketCodeSendModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiTradeTicketTicketCodeSendModel instance = new KoubeiTradeTicketTicketCodeSendModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public KoubeiTradeTicketTicketCodeSendModel build() {
            KoubeiTradeTicketTicketCodeSendModel koubeiTradeTicketTicketCodeSendModel = new KoubeiTradeTicketTicketCodeSendModel();
            build(koubeiTradeTicketTicketCodeSendModel);
            return koubeiTradeTicketTicketCodeSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
