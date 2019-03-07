package build.dream.common.models.alipay;

public class AlipayOpenPublicInfoModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicInfoModifyModel instance = new AlipayOpenPublicInfoModifyModel();

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

        public AlipayOpenPublicInfoModifyModel build() {
            AlipayOpenPublicInfoModifyModel alipayOpenPublicInfoModifyModel = new AlipayOpenPublicInfoModifyModel();
            alipayOpenPublicInfoModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicInfoModifyModel.setBranchId(instance.getBranchId());
            alipayOpenPublicInfoModifyModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicInfoModifyModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicInfoModifyModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicInfoModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
