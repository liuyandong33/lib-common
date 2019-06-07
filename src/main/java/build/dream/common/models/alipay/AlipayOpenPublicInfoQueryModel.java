package build.dream.common.models.alipay;

public class AlipayOpenPublicInfoQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicInfoQueryModel> {
        @Override
        public AlipayOpenPublicInfoQueryModel build() {
            AlipayOpenPublicInfoQueryModel alipayOpenPublicInfoQueryModel = super.build();
            return alipayOpenPublicInfoQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
