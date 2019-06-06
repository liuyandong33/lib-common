package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageContentCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicMessageContentCreateModel instance = new AlipayOpenPublicMessageContentCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicMessageContentCreateModel build() {
            AlipayOpenPublicMessageContentCreateModel alipayOpenPublicMessageContentCreateModel = new AlipayOpenPublicMessageContentCreateModel();
            build(alipayOpenPublicMessageContentCreateModel);
            return alipayOpenPublicMessageContentCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
