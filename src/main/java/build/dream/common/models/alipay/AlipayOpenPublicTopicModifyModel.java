package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicTopicModifyModel instance = new AlipayOpenPublicTopicModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicTopicModifyModel build() {
            AlipayOpenPublicTopicModifyModel alipayOpenPublicTopicModifyModel = new AlipayOpenPublicTopicModifyModel();
            build(alipayOpenPublicTopicModifyModel);
            return alipayOpenPublicTopicModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
