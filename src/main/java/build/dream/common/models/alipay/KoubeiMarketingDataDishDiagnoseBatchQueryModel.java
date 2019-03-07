package build.dream.common.models.alipay;

public class KoubeiMarketingDataDishDiagnoseBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiMarketingDataDishDiagnoseBatchQueryModel instance = new KoubeiMarketingDataDishDiagnoseBatchQueryModel();

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

        public KoubeiMarketingDataDishDiagnoseBatchQueryModel build() {
            KoubeiMarketingDataDishDiagnoseBatchQueryModel koubeiMarketingDataDishDiagnoseBatchQueryModel = new KoubeiMarketingDataDishDiagnoseBatchQueryModel();
            koubeiMarketingDataDishDiagnoseBatchQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingDataDishDiagnoseBatchQueryModel.setBranchId(instance.getBranchId());
            return koubeiMarketingDataDishDiagnoseBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
