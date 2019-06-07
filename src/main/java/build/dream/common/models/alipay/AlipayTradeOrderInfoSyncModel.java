package build.dream.common.models.alipay;

public class AlipayTradeOrderInfoSyncModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayTradeOrderInfoSyncModel> {
        @Override
        public AlipayTradeOrderInfoSyncModel build() {
            AlipayTradeOrderInfoSyncModel alipayTradeOrderInfoSyncModel = super.build();
            return alipayTradeOrderInfoSyncModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
