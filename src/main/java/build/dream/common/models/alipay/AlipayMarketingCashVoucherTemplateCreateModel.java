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

        public AlipayMarketingCashVoucherTemplateCreateModel build() {
            AlipayMarketingCashVoucherTemplateCreateModel alipayMarketingCashVoucherTemplateCreateModel = new AlipayMarketingCashVoucherTemplateCreateModel();
            alipayMarketingCashVoucherTemplateCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingCashVoucherTemplateCreateModel.setBranchId(instance.getBranchId());
            return alipayMarketingCashVoucherTemplateCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
