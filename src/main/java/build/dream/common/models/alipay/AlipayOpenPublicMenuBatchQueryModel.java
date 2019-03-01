package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicMenuBatchQueryModel extends BasicModel {
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

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public static class Builder {
        private final AlipayOpenPublicMenuBatchQueryModel instance = new AlipayOpenPublicMenuBatchQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicMenuBatchQueryModel build() {
            AlipayOpenPublicMenuBatchQueryModel alipayOpenPublicMenuBatchQueryModel = new AlipayOpenPublicMenuBatchQueryModel();
            alipayOpenPublicMenuBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMenuBatchQueryModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMenuBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
