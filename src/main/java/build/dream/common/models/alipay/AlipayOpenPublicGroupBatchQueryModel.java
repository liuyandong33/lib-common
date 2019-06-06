package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicGroupBatchQueryModel instance = new AlipayOpenPublicGroupBatchQueryModel();

        public AlipayOpenPublicGroupBatchQueryModel build() {
            AlipayOpenPublicGroupBatchQueryModel alipayOpenPublicGroupBatchQueryModel = new AlipayOpenPublicGroupBatchQueryModel();
            build(alipayOpenPublicGroupBatchQueryModel);
            return alipayOpenPublicGroupBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
