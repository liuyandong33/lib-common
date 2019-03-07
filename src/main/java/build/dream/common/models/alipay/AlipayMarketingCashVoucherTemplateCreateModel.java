package build.dream.common.models.alipay;

public class AlipayMarketingCashVoucherTemplateCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCashVoucherTemplateCreateModel instance = new AlipayMarketingCashVoucherTemplateCreateModel();

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

        public AlipayMarketingCashVoucherTemplateCreateModel build() {
            AlipayMarketingCashVoucherTemplateCreateModel alipayMarketingCashVoucherTemplateCreateModel = new AlipayMarketingCashVoucherTemplateCreateModel();
            alipayMarketingCashVoucherTemplateCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingCashVoucherTemplateCreateModel.setBranchId(instance.getBranchId());
            alipayMarketingCashVoucherTemplateCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingCashVoucherTemplateCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingCashVoucherTemplateCreateModel.setAuthToken(instance.getAuthToken());
            return alipayMarketingCashVoucherTemplateCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
