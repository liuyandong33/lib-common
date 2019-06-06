package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupCrowdQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicGroupCrowdQueryModel instance = new AlipayOpenPublicGroupCrowdQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOpenPublicGroupCrowdQueryModel build() {
            AlipayOpenPublicGroupCrowdQueryModel alipayOpenPublicGroupCrowdQueryModel = new AlipayOpenPublicGroupCrowdQueryModel();
            build(alipayOpenPublicGroupCrowdQueryModel);
            return alipayOpenPublicGroupCrowdQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
