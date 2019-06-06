package build.dream.common.models.alipay;

public class AlipayOpenAgentMiniCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenAgentMiniCreateModel instance = new AlipayOpenAgentMiniCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenAgentMiniCreateModel build() {
            AlipayOpenAgentMiniCreateModel alipayOpenAgentMiniCreateModel = new AlipayOpenAgentMiniCreateModel();
            build(alipayOpenAgentMiniCreateModel);
            return alipayOpenAgentMiniCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
