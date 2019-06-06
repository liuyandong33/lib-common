package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicAdvertCreateModel instance = new AlipayOpenPublicAdvertCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicAdvertCreateModel build() {
            AlipayOpenPublicAdvertCreateModel alipayOpenPublicAdvertCreateModel = new AlipayOpenPublicAdvertCreateModel();
            build(alipayOpenPublicAdvertCreateModel);
            return alipayOpenPublicAdvertCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
