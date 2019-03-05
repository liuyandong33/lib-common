package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class AlipayFundAuthOrderFreezeModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

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

    public static class Builder {
        private final AlipayFundAuthOrderFreezeModel instance = new AlipayFundAuthOrderFreezeModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayFundAuthOrderFreezeModel build() {
            AlipayFundAuthOrderFreezeModel alipayFundAuthOrderFreezeModel = new AlipayFundAuthOrderFreezeModel();
            alipayFundAuthOrderFreezeModel.setTenantId(instance.getTenantId());
            alipayFundAuthOrderFreezeModel.setBranchId(instance.getBranchId());
            return alipayFundAuthOrderFreezeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
