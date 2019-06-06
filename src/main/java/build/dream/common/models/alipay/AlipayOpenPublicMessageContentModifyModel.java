package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageContentModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicMessageContentModifyModel instance = new AlipayOpenPublicMessageContentModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicMessageContentModifyModel build() {
            AlipayOpenPublicMessageContentModifyModel alipayOpenPublicMessageContentModifyModel = new AlipayOpenPublicMessageContentModifyModel();
            build(alipayOpenPublicMessageContentModifyModel);
            return alipayOpenPublicMessageContentModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
