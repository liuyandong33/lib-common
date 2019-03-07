package build.dream.common.models.alipay;

public class KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel instance = new KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel();

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

        public KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel build() {
            KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel koubeiMarketingDataDishDiagnoseTypeBatchQueryModel = new KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel();
            koubeiMarketingDataDishDiagnoseTypeBatchQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingDataDishDiagnoseTypeBatchQueryModel.setBranchId(instance.getBranchId());
            koubeiMarketingDataDishDiagnoseTypeBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingDataDishDiagnoseTypeBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingDataDishDiagnoseTypeBatchQueryModel.setAuthToken(instance.getAuthToken());
            return koubeiMarketingDataDishDiagnoseTypeBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
