package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicTopicBatchQueryModel instance = new AlipayOpenPublicTopicBatchQueryModel();

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

        public AlipayOpenPublicTopicBatchQueryModel build() {
            AlipayOpenPublicTopicBatchQueryModel alipayOpenPublicTopicBatchQueryModel = new AlipayOpenPublicTopicBatchQueryModel();
            alipayOpenPublicTopicBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicTopicBatchQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicTopicBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicTopicBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicTopicBatchQueryModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicTopicBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
