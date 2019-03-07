package build.dream.common.models.alipay;

public class AlipayOpenPublicQrCodeCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicQrCodeCreateModel instance = new AlipayOpenPublicQrCodeCreateModel();

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

        public AlipayOpenPublicQrCodeCreateModel build() {
            AlipayOpenPublicQrCodeCreateModel copy = new AlipayOpenPublicQrCodeCreateModel();
            copy.setTenantId(instance.getTenantId());
            copy.setBranchId(instance.getBranchId());
            return copy;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}