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

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public KoubeiTradeTicketTicketCodeUseModel build() {
            KoubeiTradeTicketTicketCodeUseModel koubeiTradeTicketTicketCodeUseModel = new KoubeiTradeTicketTicketCodeUseModel();
            koubeiTradeTicketTicketCodeUseModel.setTenantId(instance.getTenantId());
            koubeiTradeTicketTicketCodeUseModel.setBranchId(instance.getBranchId());
            koubeiTradeTicketTicketCodeUseModel.setReturnUrl(instance.getReturnUrl());
            koubeiTradeTicketTicketCodeUseModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiTradeTicketTicketCodeUseModel.setAuthToken(instance.getAuthToken());
            return koubeiTradeTicketTicketCodeUseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
