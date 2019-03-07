package build.dream.common.models.alipay;

public class AlipayTradeCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayTradeCreateModel instance = new AlipayTradeCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayTradeCreateModel build() {
            AlipayTradeCreateModel alipayTradeCreateModel = new AlipayTradeCreateModel();
            alipayTradeCreateModel.setTenantId(instance.getTenantId());
            alipayTradeCreateModel.setBranchId(instance.getBranchId());
            return alipayTradeCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
