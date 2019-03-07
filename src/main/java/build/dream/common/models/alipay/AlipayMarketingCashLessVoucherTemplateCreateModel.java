package build.dream.common.models.alipay;

public class AlipayMarketingCashLessVoucherTemplateCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCashLessVoucherTemplateCreateModel instance = new AlipayMarketingCashLessVoucherTemplateCreateModel();

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

        public AlipayMarketingCashLessVoucherTemplateCreateModel build() {
            AlipayMarketingCashLessVoucherTemplateCreateModel alipayMarketingCashLessVoucherTemplateCreateModel = new AlipayMarketingCashLessVoucherTemplateCreateModel();
            alipayMarketingCashLessVoucherTemplateCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingCashLessVoucherTemplateCreateModel.setBranchId(instance.getBranchId());
            return alipayMarketingCashLessVoucherTemplateCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
