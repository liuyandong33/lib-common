package build.dream.common.models.alipay;

public class AlipayOpenAgentMiniCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAgentMiniCreateModel> {
        @Override
        public AlipayOpenAgentMiniCreateModel build() {
            AlipayOpenAgentMiniCreateModel alipayOpenAgentMiniCreateModel = super.build();
            return alipayOpenAgentMiniCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
