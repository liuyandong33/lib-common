package build.dream.common.models.alipay;

public class AlipayUserCertifyOpenInitializeModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayUserCertifyOpenInitializeModel instance = new AlipayUserCertifyOpenInitializeModel();

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

        public AlipayUserCertifyOpenInitializeModel build() {
            AlipayUserCertifyOpenInitializeModel alipayUserCertifyOpenInitializeModel = new AlipayUserCertifyOpenInitializeModel();
            alipayUserCertifyOpenInitializeModel.setTenantId(instance.getTenantId());
            alipayUserCertifyOpenInitializeModel.setBranchId(instance.getBranchId());
            return alipayUserCertifyOpenInitializeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
