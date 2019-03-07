package build.dream.common.models.alipay;

public class AlipayOfflineMarketApplyOrderBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOfflineMarketApplyOrderBatchQueryModel instance = new AlipayOfflineMarketApplyOrderBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOfflineMarketApplyOrderBatchQueryModel build() {
            AlipayOfflineMarketApplyOrderBatchQueryModel alipayOfflineMarketApplyOrderBatchQueryModel = new AlipayOfflineMarketApplyOrderBatchQueryModel();
            alipayOfflineMarketApplyOrderBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketApplyOrderBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOfflineMarketApplyOrderBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
