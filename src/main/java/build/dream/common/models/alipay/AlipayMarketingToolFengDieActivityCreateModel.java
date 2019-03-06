package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class AlipayMarketingToolFengDieActivityCreateModel extends BasicModel {
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
        private final AlipayMarketingToolFengDieActivityCreateModel instance = new AlipayMarketingToolFengDieActivityCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingToolFengDieActivityCreateModel build() {
            AlipayMarketingToolFengDieActivityCreateModel alipayMarketingToolFengDieActivityCreateModel = new AlipayMarketingToolFengDieActivityCreateModel();
            alipayMarketingToolFengDieActivityCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingToolFengDieActivityCreateModel.setBranchId(instance.getBranchId());
            return alipayMarketingToolFengDieActivityCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
