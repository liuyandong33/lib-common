package build.dream.common.models.alipay;

public class AlipayMarketingCardUpdateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayMarketingCardUpdateModel instance = new AlipayMarketingCardUpdateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardUpdateModel build() {
            AlipayMarketingCardUpdateModel alipayMarketingCardUpdateModel = new AlipayMarketingCardUpdateModel();
            alipayMarketingCardUpdateModel.setTenantId(instance.getTenantId());
            alipayMarketingCardUpdateModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
