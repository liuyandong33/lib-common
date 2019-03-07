package build.dream.common.models.alipay;

public class KoubeiTradeTicketTicketCodeUseModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiTradeTicketTicketCodeUseModel instance = new KoubeiTradeTicketTicketCodeUseModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public KoubeiTradeTicketTicketCodeUseModel build() {
            KoubeiTradeTicketTicketCodeUseModel koubeiTradeTicketTicketCodeUseModel = new KoubeiTradeTicketTicketCodeUseModel();
            koubeiTradeTicketTicketCodeUseModel.setTenantId(instance.getTenantId());
            koubeiTradeTicketTicketCodeUseModel.setBranchId(instance.getBranchId());
            return koubeiTradeTicketTicketCodeUseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
