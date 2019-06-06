package build.dream.common.models.alipay;

public class AlipayOpenPublicPersonalizedExtensionBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicPersonalizedExtensionBatchQueryModel instance = new AlipayOpenPublicPersonalizedExtensionBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicPersonalizedExtensionBatchQueryModel build() {
            AlipayOpenPublicPersonalizedExtensionBatchQueryModel alipayOpenPublicPersonalizedExtensionBatchQueryModel = new AlipayOpenPublicPersonalizedExtensionBatchQueryModel();
            build(alipayOpenPublicPersonalizedExtensionBatchQueryModel);
            return alipayOpenPublicPersonalizedExtensionBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
