package build.dream.common.models.alipay;

public class AlipayOpenPublicInfoModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicInfoModifyModel instance = new AlipayOpenPublicInfoModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicInfoModifyModel build() {
            AlipayOpenPublicInfoModifyModel alipayOpenPublicInfoModifyModel = new AlipayOpenPublicInfoModifyModel();
            build(alipayOpenPublicInfoModifyModel);
            return alipayOpenPublicInfoModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
