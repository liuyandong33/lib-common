package build.dream.common.models.alipay;

public class KoubeiTradeOrderConsultModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiTradeOrderConsultModel instance = new KoubeiTradeOrderConsultModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public KoubeiTradeOrderConsultModel build() {
            KoubeiTradeOrderConsultModel koubeiTradeOrderConsultModel = new KoubeiTradeOrderConsultModel();
            koubeiTradeOrderConsultModel.setTenantId(instance.getTenantId());
            koubeiTradeOrderConsultModel.setBranchId(instance.getBranchId());
            return koubeiTradeOrderConsultModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
