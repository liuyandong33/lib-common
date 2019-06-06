package build.dream.common.models.alipay;

public class AlipayOfflineMarketShopModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder>{
        private final AlipayOfflineMarketShopModifyModel instance = new AlipayOfflineMarketShopModifyModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public AlipayOfflineMarketShopModifyModel build() {
            AlipayOfflineMarketShopModifyModel alipayOfflineMarketShopModifyModel = new AlipayOfflineMarketShopModifyModel();
            build(alipayOfflineMarketShopModifyModel);
            return alipayOfflineMarketShopModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
