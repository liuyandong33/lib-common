package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicGroupCreateModel instance = new AlipayOpenPublicGroupCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicGroupCreateModel build() {
            AlipayOpenPublicGroupCreateModel alipayOpenPublicGroupCreateModel = new AlipayOpenPublicGroupCreateModel();
            build(alipayOpenPublicGroupCreateModel);
            return alipayOpenPublicGroupCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
