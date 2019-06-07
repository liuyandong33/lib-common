package build.dream.common.models.alipay;

public class KoubeiTradeTicketTicketCodeSendModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiTradeTicketTicketCodeSendModel> {
        @Override
        public KoubeiTradeTicketTicketCodeSendModel build() {
            KoubeiTradeTicketTicketCodeSendModel koubeiTradeTicketTicketCodeSendModel = super.build();
            return koubeiTradeTicketTicketCodeSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
