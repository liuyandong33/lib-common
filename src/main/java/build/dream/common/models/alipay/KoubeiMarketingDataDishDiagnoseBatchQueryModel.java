package build.dream.common.models.alipay;

public class KoubeiMarketingDataDishDiagnoseBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiMarketingDataDishDiagnoseBatchQueryModel instance = new KoubeiMarketingDataDishDiagnoseBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public KoubeiMarketingDataDishDiagnoseBatchQueryModel build() {
            KoubeiMarketingDataDishDiagnoseBatchQueryModel koubeiMarketingDataDishDiagnoseBatchQueryModel = new KoubeiMarketingDataDishDiagnoseBatchQueryModel();
            build(koubeiMarketingDataDishDiagnoseBatchQueryModel);
            return koubeiMarketingDataDishDiagnoseBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
