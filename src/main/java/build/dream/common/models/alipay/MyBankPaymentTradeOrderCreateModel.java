package build.dream.common.models.alipay;

public class MyBankPaymentTradeOrderCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final MyBankPaymentTradeOrderCreateModel instance = new MyBankPaymentTradeOrderCreateModel();

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

        public MyBankPaymentTradeOrderCreateModel build() {
            MyBankPaymentTradeOrderCreateModel myBankPaymentTradeOrderCreateModel = new MyBankPaymentTradeOrderCreateModel();
            myBankPaymentTradeOrderCreateModel.setTenantId(instance.getTenantId());
            myBankPaymentTradeOrderCreateModel.setBranchId(instance.getBranchId());
            return myBankPaymentTradeOrderCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
