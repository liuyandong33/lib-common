package build.dream.common.models.alipay;

public class AlipayOpenPublicMenuBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicMenuBatchQueryModel> {
        @Override
        public AlipayOpenPublicMenuBatchQueryModel build() {
            AlipayOpenPublicMenuBatchQueryModel alipayOpenPublicMenuBatchQueryModel = super.build();
            return alipayOpenPublicMenuBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
