package build.dream.common.models.alipay;

public class KoubeiMarketingDataMallShopItemsQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiMarketingDataMallShopItemsQueryModel instance = new KoubeiMarketingDataMallShopItemsQueryModel();

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

        public KoubeiMarketingDataMallShopItemsQueryModel build() {
            KoubeiMarketingDataMallShopItemsQueryModel koubeiMarketingDataMallShopItemsQueryModel = new KoubeiMarketingDataMallShopItemsQueryModel();
            koubeiMarketingDataMallShopItemsQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingDataMallShopItemsQueryModel.setBranchId(instance.getBranchId());
            koubeiMarketingDataMallShopItemsQueryModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingDataMallShopItemsQueryModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingDataMallShopItemsQueryModel.setAuthToken(instance.getAuthToken());
            return koubeiMarketingDataMallShopItemsQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
