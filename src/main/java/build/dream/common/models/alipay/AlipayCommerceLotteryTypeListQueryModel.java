package build.dream.common.models.alipay;

public class AlipayCommerceLotteryTypeListQueryModel extends AlipayBasicModel {
    public static class Builder {
        private final AlipayCommerceLotteryTypeListQueryModel instance = new AlipayCommerceLotteryTypeListQueryModel();

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

        public AlipayCommerceLotteryTypeListQueryModel build() {
            AlipayCommerceLotteryTypeListQueryModel alipayCommerceLotteryTypeListQueryModel = new AlipayCommerceLotteryTypeListQueryModel();
            alipayCommerceLotteryTypeListQueryModel.setTenantId(instance.getTenantId());
            alipayCommerceLotteryTypeListQueryModel.setBranchId(instance.getBranchId());
            alipayCommerceLotteryTypeListQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayCommerceLotteryTypeListQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayCommerceLotteryTypeListQueryModel.setAuthToken(instance.getAuthToken());
            return alipayCommerceLotteryTypeListQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
