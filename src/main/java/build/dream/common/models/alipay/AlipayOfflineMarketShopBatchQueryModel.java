package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AlipayOfflineMarketShopBatchQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Min(1)
    @Max(9999)
    private Integer pageNo;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

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

        public Builder pageNo(Integer pageNo) {
            instance.setPageNo(pageNo);
            return this;
        }

        public AlipayOfflineMarketShopBatchQueryModel build() {
            AlipayOfflineMarketShopBatchQueryModel alipayOfflineMarketShopBatchQueryModel = new AlipayOfflineMarketShopBatchQueryModel();
            alipayOfflineMarketShopBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketShopBatchQueryModel.setBranchId(instance.getBranchId());
            alipayOfflineMarketShopBatchQueryModel.setPageNo(instance.getPageNo());
            return alipayOfflineMarketShopBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}