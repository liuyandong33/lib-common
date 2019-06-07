package build.dream.common.models.alipay;

public class KoubeiMarketingDataDishDiagnoseBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiMarketingDataDishDiagnoseBatchQueryModel> {
        @Override
        public KoubeiMarketingDataDishDiagnoseBatchQueryModel build() {
            KoubeiMarketingDataDishDiagnoseBatchQueryModel koubeiMarketingDataDishDiagnoseBatchQueryModel = super.build();
            return koubeiMarketingDataDishDiagnoseBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
