package build.dream.common.models.alipay;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingUseRulePidQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 16)
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public static class Builder {
        private final AlipayMarketingUseRulePidQueryModel instance = new AlipayMarketingUseRulePidQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder pid(String pid) {
            instance.setPid(pid);
            return this;
        }

        public AlipayMarketingUseRulePidQueryModel build() {
            AlipayMarketingUseRulePidQueryModel alipayMarketingUseRulePidQueryModel = new AlipayMarketingUseRulePidQueryModel();
            alipayMarketingUseRulePidQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingUseRulePidQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingUseRulePidQueryModel.setPid(instance.getPid());
            return alipayMarketingUseRulePidQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
