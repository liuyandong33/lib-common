package build.dream.common.models.alipay;

public class AlipayOpenPublicInfoQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicInfoQueryModel instance = new AlipayOpenPublicInfoQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicInfoQueryModel build() {
            AlipayOpenPublicInfoQueryModel alipayOpenPublicInfoQueryModel = new AlipayOpenPublicInfoQueryModel();
            build(alipayOpenPublicInfoQueryModel);
            return alipayOpenPublicInfoQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
