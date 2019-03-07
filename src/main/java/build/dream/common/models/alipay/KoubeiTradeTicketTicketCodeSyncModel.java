package build.dream.common.models.alipay;

public class KoubeiTradeTicketTicketCodeSyncModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiTradeTicketTicketCodeSyncModel instance = new KoubeiTradeTicketTicketCodeSyncModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public KoubeiTradeTicketTicketCodeSyncModel build() {
            KoubeiTradeTicketTicketCodeSyncModel koubeiTradeTicketTicketCodeSyncModel = new KoubeiTradeTicketTicketCodeSyncModel();
            koubeiTradeTicketTicketCodeSyncModel.setTenantId(instance.getTenantId());
            koubeiTradeTicketTicketCodeSyncModel.setBranchId(instance.getBranchId());
            return koubeiTradeTicketTicketCodeSyncModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
