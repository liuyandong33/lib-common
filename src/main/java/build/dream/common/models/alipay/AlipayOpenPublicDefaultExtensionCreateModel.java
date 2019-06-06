package build.dream.common.models.alipay;

public class AlipayOpenPublicDefaultExtensionCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicDefaultExtensionCreateModel instance = new AlipayOpenPublicDefaultExtensionCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicDefaultExtensionCreateModel build() {
            AlipayOpenPublicDefaultExtensionCreateModel alipayOpenPublicDefaultExtensionCreateModel = new AlipayOpenPublicDefaultExtensionCreateModel();
            build(alipayOpenPublicDefaultExtensionCreateModel);
            return alipayOpenPublicDefaultExtensionCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
