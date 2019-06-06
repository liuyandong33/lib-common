package build.dream.common.models.alipay;

public class AlipayUserInfoShareModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayUserInfoShareModel instance = new AlipayUserInfoShareModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayUserInfoShareModel build() {
            AlipayUserInfoShareModel alipayUserInfoShareModel = new AlipayUserInfoShareModel();
            build(alipayUserInfoShareModel);
            return alipayUserInfoShareModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
