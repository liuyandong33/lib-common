package build.dream.common.models.alipay;

public class AlipayTradeCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayTradeCreateModel> {
        @Override
        public AlipayTradeCreateModel build() {
            AlipayTradeCreateModel alipayTradeCreateModel = super.build();
            return alipayTradeCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
