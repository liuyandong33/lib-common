package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertBatchQueryModel extends AlipayBasicModel {
    public static class Builder  extends AlipayBasicModel.Builder<Builder>{
        private final AlipayOpenPublicAdvertBatchQueryModel instance = new AlipayOpenPublicAdvertBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicAdvertBatchQueryModel build() {
            AlipayOpenPublicAdvertBatchQueryModel alipayOpenPublicAdvertBatchQueryModel = new AlipayOpenPublicAdvertBatchQueryModel();
            build(alipayOpenPublicAdvertBatchQueryModel);
            return alipayOpenPublicAdvertBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
