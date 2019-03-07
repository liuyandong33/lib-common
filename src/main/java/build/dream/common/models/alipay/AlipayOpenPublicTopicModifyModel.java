package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicTopicModifyModel instance = new AlipayOpenPublicTopicModifyModel();

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

        public AlipayOpenPublicTopicModifyModel build() {
            AlipayOpenPublicTopicModifyModel alipayOpenPublicTopicModifyModel = new AlipayOpenPublicTopicModifyModel();
            alipayOpenPublicTopicModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTopicModifyModel.setBranchId(instance.getBranchId());
            alipayOpenPublicTopicModifyModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicTopicModifyModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicTopicModifyModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicTopicModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
