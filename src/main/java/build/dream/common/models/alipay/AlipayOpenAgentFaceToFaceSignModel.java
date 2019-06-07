package build.dream.common.models.alipay;

public class AlipayOpenAgentFaceToFaceSignModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAgentFaceToFaceSignModel> {
        @Override
        public AlipayOpenAgentFaceToFaceSignModel build() {
            AlipayOpenAgentFaceToFaceSignModel alipayOpenAgentFaceToFaceSignModel = super.build();
            return alipayOpenAgentFaceToFaceSignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
