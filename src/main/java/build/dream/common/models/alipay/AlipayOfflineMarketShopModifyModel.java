package build.dream.common.models.alipay;

public class AlipayOfflineMarketShopModifyModel extends AlipayBasicModel {
    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOfflineMarketShopModifyModel> {
        @Override
        public AlipayOfflineMarketShopModifyModel build() {
            AlipayOfflineMarketShopModifyModel alipayOfflineMarketShopModifyModel = super.build();
            return alipayOfflineMarketShopModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
