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

        public AlipayOpenPublicMessageSingleSendModel build() {
            AlipayOpenPublicMessageSingleSendModel alipayOpenPublicMessageSingleSendModel = new AlipayOpenPublicMessageSingleSendModel();
            alipayOpenPublicMessageSingleSendModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageSingleSendModel.setBranchId(instance.getBranchId());
            alipayOpenPublicMessageSingleSendModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicMessageSingleSendModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicMessageSingleSendModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicMessageSingleSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}