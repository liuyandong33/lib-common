package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicMatchUserLabelDeleteModel extends BasicModel {
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
        private final AlipayOpenPublicMatchUserLabelDeleteModel instance = new AlipayOpenPublicMatchUserLabelDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicMatchUserLabelDeleteModel build() {
            AlipayOpenPublicMatchUserLabelDeleteModel alipayOpenPublicMatchUserLabelDeleteModel = new AlipayOpenPublicMatchUserLabelDeleteModel();
            alipayOpenPublicMatchUserLabelDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMatchUserLabelDeleteModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicMatchUserLabelDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
