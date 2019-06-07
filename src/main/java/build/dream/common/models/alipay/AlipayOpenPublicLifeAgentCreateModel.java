package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeAgentCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicLifeAgentCreateModel> {
        @Override
        public AlipayOpenPublicLifeAgentCreateModel build() {
            AlipayOpenPublicLifeAgentCreateModel alipayOpenPublicLifeAgentCreateModel = super.build();
            return alipayOpenPublicLifeAgentCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
