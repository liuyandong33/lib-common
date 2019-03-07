package build.dream.common.models.alipay;

public class AlipayOpenPublicTemplateMessageGetModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicTemplateMessageGetModel instance = new AlipayOpenPublicTemplateMessageGetModel();

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

        public AlipayOpenPublicTemplateMessageGetModel build() {
            AlipayOpenPublicTemplateMessageGetModel alipayOpenPublicTemplateMessageGetModel = new AlipayOpenPublicTemplateMessageGetModel();
            alipayOpenPublicTemplateMessageGetModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTemplateMessageGetModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicTemplateMessageGetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
