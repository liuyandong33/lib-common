package build.dream.common.models.alipay;

public class AlipayTradeOrderInfoSyncModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayTradeOrderInfoSyncModel instance = new AlipayTradeOrderInfoSyncModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayTradeOrderInfoSyncModel build() {
            AlipayTradeOrderInfoSyncModel alipayTradeOrderInfoSyncModel = new AlipayTradeOrderInfoSyncModel();
            alipayTradeOrderInfoSyncModel.setTenantId(instance.getTenantId());
            alipayTradeOrderInfoSyncModel.setBranchId(instance.getBranchId());
            return alipayTradeOrderInfoSyncModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
