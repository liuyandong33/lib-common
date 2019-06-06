package build.dream.common.models.alipay;

public class AlipayOfflineMarketShopSummaryBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOfflineMarketShopSummaryBatchQueryModel instance = new AlipayOfflineMarketShopSummaryBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOfflineMarketShopSummaryBatchQueryModel build() {
            AlipayOfflineMarketShopSummaryBatchQueryModel alipayOfflineMarketShopSummaryBatchQueryModel = new AlipayOfflineMarketShopSummaryBatchQueryModel();
            build(alipayOfflineMarketShopSummaryBatchQueryModel);
            return alipayOfflineMarketShopSummaryBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
