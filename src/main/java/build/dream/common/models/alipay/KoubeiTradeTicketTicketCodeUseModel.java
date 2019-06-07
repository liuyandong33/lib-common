package build.dream.common.models.alipay;

public class KoubeiTradeTicketTicketCodeUseModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiTradeTicketTicketCodeUseModel> {
        @Override
        public KoubeiTradeTicketTicketCodeUseModel build() {
            KoubeiTradeTicketTicketCodeUseModel koubeiTradeTicketTicketCodeUseModel = super.build();
            return koubeiTradeTicketTicketCodeUseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
