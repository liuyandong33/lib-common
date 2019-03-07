package build.dream.common.models.alipay;

public class KoubeiTradeOrderConsultModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiTradeOrderConsultModel instance = new KoubeiTradeOrderConsultModel();

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

        public KoubeiTradeOrderConsultModel build() {
            KoubeiTradeOrderConsultModel koubeiTradeOrderConsultModel = new KoubeiTradeOrderConsultModel();
            koubeiTradeOrderConsultModel.setTenantId(instance.getTenantId());
            koubeiTradeOrderConsultModel.setBranchId(instance.getBranchId());
            return koubeiTradeOrderConsultModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
