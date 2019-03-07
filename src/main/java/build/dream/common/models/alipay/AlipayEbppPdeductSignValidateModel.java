package build.dream.common.models.alipay;

public class AlipayEbppPdeductSignValidateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayEbppPdeductSignValidateModel instance = new AlipayEbppPdeductSignValidateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayEbppPdeductSignValidateModel build() {
            AlipayEbppPdeductSignValidateModel alipayEbppPdeductSignValidateModel = new AlipayEbppPdeductSignValidateModel();
            alipayEbppPdeductSignValidateModel.setTenantId(instance.getTenantId());
            alipayEbppPdeductSignValidateModel.setBranchId(instance.getBranchId());
            return alipayEbppPdeductSignValidateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
