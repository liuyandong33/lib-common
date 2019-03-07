package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageContentModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicMessageContentModifyModel instance = new AlipayOpenPublicMessageContentModifyModel();

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

        public AlipayOpenPublicMessageContentModifyModel build() {
            AlipayOpenPublicMessageContentModifyModel alipayOpenPublicMessageContentModifyModel = new AlipayOpenPublicMessageContentModifyModel();
            alipayOpenPublicMessageContentModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageContentModifyModel.setBranchId(instance.getBranchId());
            alipayOpenPublicMessageContentModifyModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicMessageContentModifyModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicMessageContentModifyModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicMessageContentModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
