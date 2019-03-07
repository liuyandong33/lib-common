package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageGroupSendModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMessageGroupSendModel instance = new AlipayOpenPublicMessageGroupSendModel();

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

        public AlipayOpenPublicMessageGroupSendModel build() {
            AlipayOpenPublicMessageGroupSendModel alipayOpenPublicMessageGroupSendModel = new AlipayOpenPublicMessageGroupSendModel();
            alipayOpenPublicMessageGroupSendModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageGroupSendModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMessageGroupSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
