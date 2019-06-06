package build.dream.common.models.alipay;

public class AlipayOpenAgentFaceToFaceSignModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenAgentFaceToFaceSignModel instance = new AlipayOpenAgentFaceToFaceSignModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenAgentFaceToFaceSignModel build() {
            AlipayOpenAgentFaceToFaceSignModel alipayOpenAgentFaceToFaceSignModel = new AlipayOpenAgentFaceToFaceSignModel();
            build(alipayOpenAgentFaceToFaceSignModel);
            return alipayOpenAgentFaceToFaceSignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
