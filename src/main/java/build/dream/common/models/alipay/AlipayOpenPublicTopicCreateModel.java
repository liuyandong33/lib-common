package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicTopicCreateModel instance = new AlipayOpenPublicTopicCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicTopicCreateModel build() {
            AlipayOpenPublicTopicCreateModel alipayOpenPublicTopicCreateModel = new AlipayOpenPublicTopicCreateModel();
            build(alipayOpenPublicTopicCreateModel);
            return alipayOpenPublicTopicCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
