package build.dream.common.models.alipay;

public class AlipayOfflineMarketApplyOrderBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOfflineMarketApplyOrderBatchQueryModel instance = new AlipayOfflineMarketApplyOrderBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOfflineMarketApplyOrderBatchQueryModel build() {
            AlipayOfflineMarketApplyOrderBatchQueryModel alipayOfflineMarketApplyOrderBatchQueryModel = new AlipayOfflineMarketApplyOrderBatchQueryModel();
            build(alipayOfflineMarketApplyOrderBatchQueryModel);
            return alipayOfflineMarketApplyOrderBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
