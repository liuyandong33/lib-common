package build.dream.common.models.alipay;

public class AlipayOfflineMarketShopModifyModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayOfflineMarketShopModifyModel instance = new AlipayOfflineMarketShopModifyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public AlipayOfflineMarketShopModifyModel build() {
            AlipayOfflineMarketShopModifyModel alipayOfflineMarketShopModifyModel = new AlipayOfflineMarketShopModifyModel();
            alipayOfflineMarketShopModifyModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketShopModifyModel.setBranchId(instance.getBranchId());
            alipayOfflineMarketShopModifyModel.setReturnUrl(instance.getReturnUrl());
            alipayOfflineMarketShopModifyModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOfflineMarketShopModifyModel.setAuthToken(instance.getAuthToken());
            return alipayOfflineMarketShopModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
