package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicCreateModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicTopicCreateModel instance = new AlipayOpenPublicTopicCreateModel();

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

        public AlipayOpenPublicTopicCreateModel build() {
            AlipayOpenPublicTopicCreateModel alipayOpenPublicTopicCreateModel = new AlipayOpenPublicTopicCreateModel();
            alipayOpenPublicTopicCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTopicCreateModel.setBranchId(instance.getBranchId());
            alipayOpenPublicTopicCreateModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicTopicCreateModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicTopicCreateModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicTopicCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
