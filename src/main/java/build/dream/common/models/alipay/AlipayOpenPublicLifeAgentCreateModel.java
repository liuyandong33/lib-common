package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeAgentCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicLifeAgentCreateModel instance = new AlipayOpenPublicLifeAgentCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicLifeAgentCreateModel build() {
            AlipayOpenPublicLifeAgentCreateModel alipayOpenPublicLifeAgentCreateModel = new AlipayOpenPublicLifeAgentCreateModel();
            build(alipayOpenPublicLifeAgentCreateModel);
            return alipayOpenPublicLifeAgentCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
