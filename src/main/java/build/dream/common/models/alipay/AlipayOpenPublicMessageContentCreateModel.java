package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageContentCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicMessageContentCreateModel> {
        @Override
        public AlipayOpenPublicMessageContentCreateModel build() {
            AlipayOpenPublicMessageContentCreateModel alipayOpenPublicMessageContentCreateModel = super.build();
            return alipayOpenPublicMessageContentCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
