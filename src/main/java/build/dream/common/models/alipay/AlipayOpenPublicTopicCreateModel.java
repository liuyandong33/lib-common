package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicTopicCreateModel> {
        @Override
        public AlipayOpenPublicTopicCreateModel build() {
            AlipayOpenPublicTopicCreateModel alipayOpenPublicTopicCreateModel = super.build();
            return alipayOpenPublicTopicCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
