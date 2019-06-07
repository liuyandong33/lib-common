package build.dream.common.models.alipay;

public class AlipayOpenPublicGroupCrowdQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicGroupCrowdQueryModel> {
        @Override
        public AlipayOpenPublicGroupCrowdQueryModel build() {
            AlipayOpenPublicGroupCrowdQueryModel alipayOpenPublicGroupCrowdQueryModel = super.build();
            return alipayOpenPublicGroupCrowdQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
