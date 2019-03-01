package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeAgentCreateQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

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

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public static class Builder {
        private final AlipayOpenPublicLifeAgentCreateQueryModel instance = new AlipayOpenPublicLifeAgentCreateQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public AlipayOpenPublicLifeAgentCreateQueryModel build() {
            AlipayOpenPublicLifeAgentCreateQueryModel alipayOpenPublicLifeAgentCreateQueryModel = new AlipayOpenPublicLifeAgentCreateQueryModel();
            alipayOpenPublicLifeAgentCreateQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeAgentCreateQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicLifeAgentCreateQueryModel.setOutBizNo(instance.getOutBizNo());
            return alipayOpenPublicLifeAgentCreateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
