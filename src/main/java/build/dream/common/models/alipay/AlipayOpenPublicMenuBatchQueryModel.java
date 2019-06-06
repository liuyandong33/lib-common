package build.dream.common.models.alipay;

public class AlipayOpenPublicMenuBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicMenuBatchQueryModel instance = new AlipayOpenPublicMenuBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicMenuBatchQueryModel build() {
            AlipayOpenPublicMenuBatchQueryModel alipayOpenPublicMenuBatchQueryModel = new AlipayOpenPublicMenuBatchQueryModel();
            build(alipayOpenPublicMenuBatchQueryModel);
            return alipayOpenPublicMenuBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
