package build.dream.common.models.alipay;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AlipayOfflineMarketShopBatchQueryModel extends AlipayBasicModel {
    @NotNull
    @Min(1)
    @Max(9999)
    private Integer pageNo;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public static class Builder {
        private final AlipayOfflineMarketShopBatchQueryModel instance = new AlipayOfflineMarketShopBatchQueryModel();

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

        public Builder pageNo(Integer pageNo) {
            instance.setPageNo(pageNo);
            return this;
        }

        public AlipayOfflineMarketShopBatchQueryModel build() {
            AlipayOfflineMarketShopBatchQueryModel alipayOfflineMarketShopBatchQueryModel = new AlipayOfflineMarketShopBatchQueryModel();
            alipayOfflineMarketShopBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketShopBatchQueryModel.setBranchId(instance.getBranchId());
            alipayOfflineMarketShopBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOfflineMarketShopBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOfflineMarketShopBatchQueryModel.setAuthToken(instance.getAuthToken());
            alipayOfflineMarketShopBatchQueryModel.setPageNo(instance.getPageNo());
            return alipayOfflineMarketShopBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
