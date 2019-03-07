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
