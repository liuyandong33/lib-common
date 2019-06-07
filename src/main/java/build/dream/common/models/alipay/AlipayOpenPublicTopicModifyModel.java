package build.dream.common.models.alipay;

public class AlipayOpenPublicTopicModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicTopicModifyModel> {
        @Override
        public AlipayOpenPublicTopicModifyModel build() {
            AlipayOpenPublicTopicModifyModel alipayOpenPublicTopicModifyModel = super.build();
            return alipayOpenPublicTopicModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
