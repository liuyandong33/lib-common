package build.dream.common.models.alipay;

public class AlipayOpenPublicLifeDebarkApplyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicLifeDebarkApplyModel> {
        @Override
        public AlipayOpenPublicLifeDebarkApplyModel build() {
            AlipayOpenPublicLifeDebarkApplyModel alipayOpenPublicLifeDebarkApplyModel = super.build();
            return alipayOpenPublicLifeDebarkApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
