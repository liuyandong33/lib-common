package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeAboardApplyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicLifeAboardApplyModel instance = new AlipayOpenPublicLifeAboardApplyModel();

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

        public AlipayOpenPublicLifeAboardApplyModel build() {
            AlipayOpenPublicLifeAboardApplyModel alipayOpenPublicLifeAboardApplyModel = new AlipayOpenPublicLifeAboardApplyModel();
            alipayOpenPublicLifeAboardApplyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeAboardApplyModel.setBranchId(instance.getBranchId());
            alipayOpenPublicLifeAboardApplyModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicLifeAboardApplyModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicLifeAboardApplyModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicLifeAboardApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
