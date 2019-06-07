package build.dream.common.models.alipay;

public class AlipayTradePreCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayTradePreCreateModel> {
        @Override
        public AlipayTradePreCreateModel build() {
            AlipayTradePreCreateModel alipayTradePreCreateModel = super.build();
            return alipayTradePreCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
