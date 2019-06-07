package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicGroupCreateModel> {
        @Override
        public AlipayOpenPublicGroupCreateModel build() {
            AlipayOpenPublicGroupCreateModel alipayOpenPublicGroupCreateModel = super.build();
            return alipayOpenPublicGroupCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
