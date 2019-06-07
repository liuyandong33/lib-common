package build.dream.common.models.alipay;

public class AlipayOfflineMarketShopSummaryBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOfflineMarketShopSummaryBatchQueryModel> {
        @Override
        public AlipayOfflineMarketShopSummaryBatchQueryModel build() {
            AlipayOfflineMarketShopSummaryBatchQueryModel alipayOfflineMarketShopSummaryBatchQueryModel = super.build();
            return alipayOfflineMarketShopSummaryBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
