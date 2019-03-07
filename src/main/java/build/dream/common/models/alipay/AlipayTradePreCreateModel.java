package build.dream.common.models.alipay;

public class AlipayTradePreCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayTradePreCreateModel instance = new AlipayTradePreCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayTradePreCreateModel build() {
            AlipayTradePreCreateModel alipayTradePreCreateModel = new AlipayTradePreCreateModel();
            alipayTradePreCreateModel.setTenantId(instance.getTenantId());
            alipayTradePreCreateModel.setBranchId(instance.getBranchId());
            return alipayTradePreCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
