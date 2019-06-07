package build.dream.common.models.alipay;

public class AlipayOpenPublicDefaultExtensionCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicDefaultExtensionCreateModel> {
        @Override
        public AlipayOpenPublicDefaultExtensionCreateModel build() {
            AlipayOpenPublicDefaultExtensionCreateModel alipayOpenPublicDefaultExtensionCreateModel = super.build();
            return alipayOpenPublicDefaultExtensionCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
