package build.dream.common.models.alipay;

public class AlipayOpenAgentMobilePaySignModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenAgentMobilePaySignModel instance = new AlipayOpenAgentMobilePaySignModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenAgentMobilePaySignModel build() {
            AlipayOpenAgentMobilePaySignModel alipayOpenAgentMobilePaySignModel = new AlipayOpenAgentMobilePaySignModel();
            build(alipayOpenAgentMobilePaySignModel);
            return alipayOpenAgentMobilePaySignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
