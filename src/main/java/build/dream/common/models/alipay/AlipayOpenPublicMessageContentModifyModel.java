package build.dream.common.models.alipay;

public class AlipayOpenPublicMessageContentModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicMessageContentModifyModel> {
        @Override
        public AlipayOpenPublicMessageContentModifyModel build() {
            AlipayOpenPublicMessageContentModifyModel alipayOpenPublicMessageContentModifyModel = super.build();
            return alipayOpenPublicMessageContentModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
