package build.dream.common.models.alipay;

public class AlipayFundAuthOrderFreezeModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayFundAuthOrderFreezeModel instance = new AlipayFundAuthOrderFreezeModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayFundAuthOrderFreezeModel build() {
            AlipayFundAuthOrderFreezeModel alipayFundAuthOrderFreezeModel = new AlipayFundAuthOrderFreezeModel();
            alipayFundAuthOrderFreezeModel.setTenantId(instance.getTenantId());
            alipayFundAuthOrderFreezeModel.setBranchId(instance.getBranchId());
            return alipayFundAuthOrderFreezeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
