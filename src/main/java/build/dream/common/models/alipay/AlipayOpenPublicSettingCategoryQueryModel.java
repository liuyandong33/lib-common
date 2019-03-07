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

        public AlipayOpenPublicSettingCategoryQueryModel build() {
            AlipayOpenPublicSettingCategoryQueryModel alipayOpenPublicSettingCategoryQueryModel = new AlipayOpenPublicSettingCategoryQueryModel();
            alipayOpenPublicSettingCategoryQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicSettingCategoryQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicSettingCategoryQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
