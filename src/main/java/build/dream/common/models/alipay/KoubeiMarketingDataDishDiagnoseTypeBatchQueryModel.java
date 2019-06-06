package build.dream.common.models.alipay;

public class KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel instance = new KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel build() {
            KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel koubeiMarketingDataDishDiagnoseTypeBatchQueryModel = new KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel();
            build(koubeiMarketingDataDishDiagnoseTypeBatchQueryModel);
            return koubeiMarketingDataDishDiagnoseTypeBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
