package build.dream.common.models.alipay;

public class AlipayOpenAgentMobilePaySignModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAgentMobilePaySignModel> {
        @Override
        public AlipayOpenAgentMobilePaySignModel build() {
            AlipayOpenAgentMobilePaySignModel alipayOpenAgentMobilePaySignModel = super.build();
            return alipayOpenAgentMobilePaySignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
