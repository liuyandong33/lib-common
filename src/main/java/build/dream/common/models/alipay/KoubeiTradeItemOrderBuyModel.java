package build.dream.common.models.alipay;

public class KoubeiTradeItemOrderBuyModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiTradeItemOrderBuyModel instance = new KoubeiTradeItemOrderBuyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public KoubeiTradeItemOrderBuyModel build() {
            KoubeiTradeItemOrderBuyModel koubeiTradeItemOrderBuyModel = new KoubeiTradeItemOrderBuyModel();
            koubeiTradeItemOrderBuyModel.setTenantId(instance.getTenantId());
            koubeiTradeItemOrderBuyModel.setBranchId(instance.getBranchId());
            return koubeiTradeItemOrderBuyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
