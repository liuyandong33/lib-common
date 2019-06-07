package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeLabelBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicLifeLabelBatchQueryModel> {
        @Override
        public AlipayOpenPublicLifeLabelBatchQueryModel build() {
            AlipayOpenPublicLifeLabelBatchQueryModel alipayOpenPublicLifeLabelBatchQueryModel = super.build();
            return alipayOpenPublicLifeLabelBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
