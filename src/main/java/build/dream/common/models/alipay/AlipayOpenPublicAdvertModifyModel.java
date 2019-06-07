package build.dream.common.models.alipay;

public class AlipayOpenPublicAdvertModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicAdvertModifyModel> {
        @Override
        public AlipayOpenPublicAdvertModifyModel build() {
            AlipayOpenPublicAdvertModifyModel alipayOpenPublicAdvertModifyModel = super.build();
            return alipayOpenPublicAdvertModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
