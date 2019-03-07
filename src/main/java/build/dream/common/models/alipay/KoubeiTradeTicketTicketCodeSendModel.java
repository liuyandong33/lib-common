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

        public KoubeiTradeTicketTicketCodeSendModel build() {
            KoubeiTradeTicketTicketCodeSendModel koubeiTradeTicketTicketCodeSendModel = new KoubeiTradeTicketTicketCodeSendModel();
            koubeiTradeTicketTicketCodeSendModel.setTenantId(instance.getTenantId());
            koubeiTradeTicketTicketCodeSendModel.setBranchId(instance.getBranchId());
            koubeiTradeTicketTicketCodeSendModel.setReturnUrl(instance.getReturnUrl());
            koubeiTradeTicketTicketCodeSendModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiTradeTicketTicketCodeSendModel.setAuthToken(instance.getAuthToken());
            return koubeiTradeTicketTicketCodeSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
