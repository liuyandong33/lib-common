package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicTopicBatchQueryModel instance = new AlipayOpenPublicTopicBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicTopicBatchQueryModel build() {
            AlipayOpenPublicTopicBatchQueryModel alipayOpenPublicTopicBatchQueryModel = new AlipayOpenPublicTopicBatchQueryModel();
            build(alipayOpenPublicTopicBatchQueryModel);
            return alipayOpenPublicTopicBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
