package build.dream.common.models.alipay;

public class AlipayUserInfoShareModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayUserInfoShareModel instance = new AlipayUserInfoShareModel();

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

        public AlipayUserInfoShareModel build() {
            AlipayUserInfoShareModel alipayUserInfoShareModel = new AlipayUserInfoShareModel();
            alipayUserInfoShareModel.setTenantId(instance.getTenantId());
            alipayUserInfoShareModel.setBranchId(instance.getBranchId());
            return alipayUserInfoShareModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
