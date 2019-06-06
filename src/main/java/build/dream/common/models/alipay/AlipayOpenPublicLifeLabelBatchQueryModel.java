package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeLabelBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicLifeLabelBatchQueryModel instance = new AlipayOpenPublicLifeLabelBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicLifeLabelBatchQueryModel build() {
            AlipayOpenPublicLifeLabelBatchQueryModel alipayOpenPublicLifeLabelBatchQueryModel = new AlipayOpenPublicLifeLabelBatchQueryModel();
            build(alipayOpenPublicLifeLabelBatchQueryModel);
            return alipayOpenPublicLifeLabelBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
