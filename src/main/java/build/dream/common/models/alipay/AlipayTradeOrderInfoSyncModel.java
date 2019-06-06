package build.dream.common.models.alipay;

public class AlipayTradeOrderInfoSyncModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayTradeOrderInfoSyncModel instance = new AlipayTradeOrderInfoSyncModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayTradeOrderInfoSyncModel build() {
            AlipayTradeOrderInfoSyncModel alipayTradeOrderInfoSyncModel = new AlipayTradeOrderInfoSyncModel();
            build(alipayTradeOrderInfoSyncModel);
            return alipayTradeOrderInfoSyncModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
