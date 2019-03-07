package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageSingleSendModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMessageSingleSendModel instance = new AlipayOpenPublicMessageSingleSendModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicMessageSingleSendModel build() {
            AlipayOpenPublicMessageSingleSendModel copy = new AlipayOpenPublicMessageSingleSendModel();
            copy.setTenantId(instance.getTenantId());
            copy.setBranchId(instance.getBranchId());
            return copy;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}