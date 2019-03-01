package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeAboardApplyModel extends BasicModel {
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
        private final AlipayOpenPublicLifeAboardApplyModel instance = new AlipayOpenPublicLifeAboardApplyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public AlipayOpenPublicLifeAboardApplyModel build() {
            AlipayOpenPublicLifeAboardApplyModel alipayOpenPublicLifeAboardApplyModel = new AlipayOpenPublicLifeAboardApplyModel();
            alipayOpenPublicLifeAboardApplyModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeAboardApplyModel.setBranchId(instance.getBranchId());
            return alipayOpenPublicLifeAboardApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
