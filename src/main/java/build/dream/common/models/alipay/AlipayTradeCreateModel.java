package build.dream.common.models.alipay;

public class AlipayTradeCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayTradeCreateModel instance = new AlipayTradeCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayTradeCreateModel build() {
            AlipayTradeCreateModel alipayTradeCreateModel = new AlipayTradeCreateModel();
            build(alipayTradeCreateModel);
            return alipayTradeCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
