package build.dream.common.models.alipay;

public class AlipayTradePreCreateModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayTradePreCreateModel instance = new AlipayTradePreCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayTradePreCreateModel build() {
            AlipayTradePreCreateModel alipayTradePreCreateModel = new AlipayTradePreCreateModel();
            build(alipayTradePreCreateModel);
            return alipayTradePreCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
