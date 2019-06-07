package build.dream.common.models.alipay;

public class AlipayOpenPublicInfoModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicInfoModifyModel> {
        @Override
        public AlipayOpenPublicInfoModifyModel build() {
            AlipayOpenPublicInfoModifyModel alipayOpenPublicInfoModifyModel = super.build();
            return alipayOpenPublicInfoModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
