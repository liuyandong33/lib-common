package build.dream.common.models.alipay;

public class KoubeiMarketingDataNearMallQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final KoubeiMarketingDataNearMallQueryModel instance = new KoubeiMarketingDataNearMallQueryModel();

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

        public KoubeiMarketingDataNearMallQueryModel build() {
            KoubeiMarketingDataNearMallQueryModel koubeiMarketingDataNearMallQueryModel = new KoubeiMarketingDataNearMallQueryModel();
            koubeiMarketingDataNearMallQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingDataNearMallQueryModel.setBranchId(instance.getBranchId());
            koubeiMarketingDataNearMallQueryModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingDataNearMallQueryModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingDataNearMallQueryModel.setAuthToken(instance.getAuthToken());
            return koubeiMarketingDataNearMallQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
