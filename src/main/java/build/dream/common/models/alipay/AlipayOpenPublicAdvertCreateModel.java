package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicAdvertCreateModel instance = new AlipayOpenPublicAdvertCreateModel();

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

        public AlipayOpenPublicAdvertCreateModel build() {
            AlipayOpenPublicAdvertCreateModel alipayOpenPublicAdvertCreateModel = new AlipayOpenPublicAdvertCreateModel();
            alipayOpenPublicAdvertCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicAdvertCreateModel.setBranchId(instance.getBranchId());
            alipayOpenPublicAdvertCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicAdvertCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicAdvertCreateModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicAdvertCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
