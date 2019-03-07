package build.dream.common.models.alipay;

public class KoubeiTradeTicketTicketCodeSendModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiTradeTicketTicketCodeSendModel instance = new KoubeiTradeTicketTicketCodeSendModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public KoubeiTradeTicketTicketCodeSendModel build() {
            KoubeiTradeTicketTicketCodeSendModel koubeiTradeTicketTicketCodeSendModel = new KoubeiTradeTicketTicketCodeSendModel();
            koubeiTradeTicketTicketCodeSendModel.setTenantId(instance.getTenantId());
            koubeiTradeTicketTicketCodeSendModel.setBranchId(instance.getBranchId());
            return koubeiTradeTicketTicketCodeSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
