package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicAdvertModifyModel instance = new AlipayOpenPublicAdvertModifyModel();

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

        public AlipayOpenPublicAdvertModifyModel build() {
            AlipayOpenPublicAdvertModifyModel alipayOpenPublicAdvertModifyModel = new AlipayOpenPublicAdvertModifyModel();
            alipayOpenPublicAdvertModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicAdvertModifyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicAdvertModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
