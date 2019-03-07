package build.dream.common.models.alipay;

public class AlipayOpenPublicMenuModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMenuModifyModel instance = new AlipayOpenPublicMenuModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public AlipayOpenPublicMenuModifyModel build() {
            AlipayOpenPublicMenuModifyModel alipayOpenPublicMenuModifyModel = new AlipayOpenPublicMenuModifyModel();
            alipayOpenPublicMenuModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMenuModifyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMenuModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
