package build.dream.common.models.alipay;

public class KoubeiTradeItemOrderRefundModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiTradeItemOrderRefundModel instance = new KoubeiTradeItemOrderRefundModel();

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

        public KoubeiTradeItemOrderRefundModel build() {
            KoubeiTradeItemOrderRefundModel koubeiTradeItemOrderRefundModel = new KoubeiTradeItemOrderRefundModel();
            koubeiTradeItemOrderRefundModel.setTenantId(instance.getTenantId());
            koubeiTradeItemOrderRefundModel.setBranchId(instance.getBranchId());
            return koubeiTradeItemOrderRefundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
