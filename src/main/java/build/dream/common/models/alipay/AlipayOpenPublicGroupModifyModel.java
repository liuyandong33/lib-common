package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicGroupModifyModel instance = new AlipayOpenPublicGroupModifyModel();

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

        public AlipayOpenPublicGroupModifyModel build() {
            AlipayOpenPublicGroupModifyModel alipayOpenPublicGroupModifyModel = new AlipayOpenPublicGroupModifyModel();
            alipayOpenPublicGroupModifyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicGroupModifyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicGroupModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
