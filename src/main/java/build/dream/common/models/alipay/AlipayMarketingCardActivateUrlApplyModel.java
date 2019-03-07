package build.dream.common.models.alipay;

public class AlipayMarketingCardActivateUrlApplyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardActivateUrlApplyModel instance = new AlipayMarketingCardActivateUrlApplyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardActivateUrlApplyModel build() {
            AlipayMarketingCardActivateUrlApplyModel alipayMarketingCardActivateUrlApplyModel = new AlipayMarketingCardActivateUrlApplyModel();
            alipayMarketingCardActivateUrlApplyModel.setTenantId(instance.getTenantId());
            alipayMarketingCardActivateUrlApplyModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardActivateUrlApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
