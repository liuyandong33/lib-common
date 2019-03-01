package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicPersonalizedExtensionCreateModel extends BasicModel {
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
        private final AlipayOpenPublicPersonalizedExtensionCreateModel instance = new AlipayOpenPublicPersonalizedExtensionCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicPersonalizedExtensionCreateModel build() {
            AlipayOpenPublicPersonalizedExtensionCreateModel alipayOpenPublicPersonalizedExtensionCreateModel = new AlipayOpenPublicPersonalizedExtensionCreateModel();
            alipayOpenPublicPersonalizedExtensionCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPersonalizedExtensionCreateModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicPersonalizedExtensionCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
