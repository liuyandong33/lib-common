package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeAboardApplyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicLifeAboardApplyModel> {
        @Override
        public AlipayOpenPublicLifeAboardApplyModel build() {
            AlipayOpenPublicLifeAboardApplyModel alipayOpenPublicLifeAboardApplyModel = super.build();
            return alipayOpenPublicLifeAboardApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
