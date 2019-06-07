package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicAdvertBatchQueryModel> {
        @Override
        public AlipayOpenPublicAdvertBatchQueryModel build() {
            AlipayOpenPublicAdvertBatchQueryModel alipayOpenPublicAdvertBatchQueryModel = super.build();
            return alipayOpenPublicAdvertBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
