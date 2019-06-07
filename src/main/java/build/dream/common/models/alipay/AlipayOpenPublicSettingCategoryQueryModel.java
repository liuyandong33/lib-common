package build.dream.common.models.alipay;

public class AlipayOpenPublicSettingCategoryQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicSettingCategoryQueryModel> {
        @Override
        public AlipayOpenPublicSettingCategoryQueryModel build() {
            AlipayOpenPublicSettingCategoryQueryModel alipayOpenPublicSettingCategoryQueryModel = super.build();
            return alipayOpenPublicSettingCategoryQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
