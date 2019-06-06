package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicAdvertModifyModel instance = new AlipayOpenPublicAdvertModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicAdvertModifyModel build() {
            AlipayOpenPublicAdvertModifyModel alipayOpenPublicAdvertModifyModel = new AlipayOpenPublicAdvertModifyModel();
            build(alipayOpenPublicAdvertModifyModel);
            return alipayOpenPublicAdvertModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
