package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicTopicBatchQueryModel> {
        @Override
        public AlipayOpenPublicTopicBatchQueryModel build() {
            AlipayOpenPublicTopicBatchQueryModel alipayOpenPublicTopicBatchQueryModel = super.build();
            return alipayOpenPublicTopicBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
