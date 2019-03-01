package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCardDeleteModel extends BasicModel {
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
        private final AlipayMarketingCardDeleteModel instance = new AlipayMarketingCardDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayMarketingCardDeleteModel build() {
            AlipayMarketingCardDeleteModel alipayMarketingCardDeleteModel = new AlipayMarketingCardDeleteModel();
            alipayMarketingCardDeleteModel.setTenantId(instance.getTenantId());
            alipayMarketingCardDeleteModel.setBranchId(instance.getBranchId());
            return alipayMarketingCardDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
