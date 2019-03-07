package build.dream.common.models.alipay;

public class AlipayMarketingToolFengDieActivityCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingToolFengDieActivityCreateModel instance = new AlipayMarketingToolFengDieActivityCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingToolFengDieActivityCreateModel build() {
            AlipayMarketingToolFengDieActivityCreateModel alipayMarketingToolFengDieActivityCreateModel = new AlipayMarketingToolFengDieActivityCreateModel();
            alipayMarketingToolFengDieActivityCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingToolFengDieActivityCreateModel.setBranchId(instance.getBranchId());
            return alipayMarketingToolFengDieActivityCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
