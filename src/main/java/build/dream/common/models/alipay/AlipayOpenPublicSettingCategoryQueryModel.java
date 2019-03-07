package build.dream.common.models.alipay;

public class AlipayOpenPublicSettingCategoryQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOpenPublicSettingCategoryQueryModel instance = new AlipayOpenPublicSettingCategoryQueryModel();

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

        public AlipayOpenPublicSettingCategoryQueryModel build() {
            AlipayOpenPublicSettingCategoryQueryModel alipayOpenPublicSettingCategoryQueryModel = new AlipayOpenPublicSettingCategoryQueryModel();
            alipayOpenPublicSettingCategoryQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicSettingCategoryQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicSettingCategoryQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicSettingCategoryQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicSettingCategoryQueryModel.setAuthToken(instance.getAuthToken());
            return alipayOpenPublicSettingCategoryQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
