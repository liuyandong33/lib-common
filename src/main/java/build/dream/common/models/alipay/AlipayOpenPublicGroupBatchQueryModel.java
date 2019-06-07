package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicGroupBatchQueryModel> {
        @Override
        public AlipayOpenPublicGroupBatchQueryModel build() {
            AlipayOpenPublicGroupBatchQueryModel alipayOpenPublicGroupBatchQueryModel = super.build();
            return alipayOpenPublicGroupBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
