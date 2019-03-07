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

        public KoubeiMarketingDataMallShopItemsQueryModel build() {
            KoubeiMarketingDataMallShopItemsQueryModel koubeiMarketingDataMallShopItemsQueryModel = new KoubeiMarketingDataMallShopItemsQueryModel();
            koubeiMarketingDataMallShopItemsQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingDataMallShopItemsQueryModel.setBranchId(instance.getBranchId());
            return koubeiMarketingDataMallShopItemsQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
