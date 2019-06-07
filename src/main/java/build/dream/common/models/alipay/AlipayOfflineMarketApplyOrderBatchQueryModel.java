package build.dream.common.models.alipay;

public class AlipayOfflineMarketApplyOrderBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOfflineMarketApplyOrderBatchQueryModel> {
        @Override
        public AlipayOfflineMarketApplyOrderBatchQueryModel build() {
            AlipayOfflineMarketApplyOrderBatchQueryModel alipayOfflineMarketApplyOrderBatchQueryModel = super.build();
            return alipayOfflineMarketApplyOrderBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
