package build.dream.common.models.alipay;

public class AlipayOpenPublicMenuBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMenuBatchQueryModel instance = new AlipayOpenPublicMenuBatchQueryModel();

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

        public AlipayOpenPublicMenuBatchQueryModel build() {
            AlipayOpenPublicMenuBatchQueryModel alipayOpenPublicMenuBatchQueryModel = new AlipayOpenPublicMenuBatchQueryModel();
            alipayOpenPublicMenuBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMenuBatchQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicMenuBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicMenuBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicMenuBatchQueryModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicMenuBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
