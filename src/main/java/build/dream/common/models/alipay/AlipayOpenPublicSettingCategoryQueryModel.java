package build.dream.common.models.alipay;

public class AlipayOpenPublicSettingCategoryQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicSettingCategoryQueryModel instance = new AlipayOpenPublicSettingCategoryQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicSettingCategoryQueryModel build() {
            AlipayOpenPublicSettingCategoryQueryModel alipayOpenPublicSettingCategoryQueryModel = new AlipayOpenPublicSettingCategoryQueryModel();
            build(alipayOpenPublicSettingCategoryQueryModel);
            return alipayOpenPublicSettingCategoryQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
