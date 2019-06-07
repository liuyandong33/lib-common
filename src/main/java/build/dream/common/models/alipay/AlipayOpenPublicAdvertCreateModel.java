package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicAdvertCreateModel> {
        @Override
        public AlipayOpenPublicAdvertCreateModel build() {
            AlipayOpenPublicAdvertCreateModel alipayOpenPublicAdvertCreateModel = super.build();
            return alipayOpenPublicAdvertCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
