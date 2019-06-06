package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeDebarkApplyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicLifeDebarkApplyModel instance = new AlipayOpenPublicLifeDebarkApplyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicLifeDebarkApplyModel build() {
            AlipayOpenPublicLifeDebarkApplyModel alipayOpenPublicLifeDebarkApplyModel = new AlipayOpenPublicLifeDebarkApplyModel();
            build(alipayOpenPublicLifeDebarkApplyModel);
            return alipayOpenPublicLifeDebarkApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
