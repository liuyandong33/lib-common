package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicAdvertBatchQueryModel instance = new AlipayOpenPublicAdvertBatchQueryModel();

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

        public AlipayOpenPublicAdvertBatchQueryModel build() {
            AlipayOpenPublicAdvertBatchQueryModel alipayOpenPublicAdvertBatchQueryModel = new AlipayOpenPublicAdvertBatchQueryModel();
            alipayOpenPublicAdvertBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicAdvertBatchQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicAdvertBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicAdvertBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicAdvertBatchQueryModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicAdvertBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
