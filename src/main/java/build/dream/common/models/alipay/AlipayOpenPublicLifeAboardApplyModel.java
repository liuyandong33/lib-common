package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeAboardApplyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicLifeAboardApplyModel instance = new AlipayOpenPublicLifeAboardApplyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicLifeAboardApplyModel build() {
            AlipayOpenPublicLifeAboardApplyModel alipayOpenPublicLifeAboardApplyModel = new AlipayOpenPublicLifeAboardApplyModel();
            build(alipayOpenPublicLifeAboardApplyModel);
            return alipayOpenPublicLifeAboardApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
