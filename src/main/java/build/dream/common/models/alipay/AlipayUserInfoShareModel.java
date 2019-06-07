package build.dream.common.models.alipay;

public class AlipayUserInfoShareModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayUserInfoShareModel> {
        @Override
        public AlipayUserInfoShareModel build() {
            AlipayUserInfoShareModel alipayUserInfoShareModel = super.build();
            return alipayUserInfoShareModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
