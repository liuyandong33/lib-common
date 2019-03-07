package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAgentCancelModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 25)
    @JsonProperty(value = "batch_no")
    private String batchNo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public static class Builder {
        private final AlipayOpenAgentCancelModel instance = new AlipayOpenAgentCancelModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder batchNo(String batchNo) {
            instance.setBatchNo(batchNo);
            return this;
        }

        public AlipayOpenAgentCancelModel build() {
            AlipayOpenAgentCancelModel alipayOpenAgentCancelModel = new AlipayOpenAgentCancelModel();
            alipayOpenAgentCancelModel.setTenantId(instance.getTenantId());
            alipayOpenAgentCancelModel.setBranchId(instance.getBranchId());
            alipayOpenAgentCancelModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenAgentCancelModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenAgentCancelModel.setAuthToken(instance.getAuthToken());
            alipayOpenAgentCancelModel.setBatchNo(instance.getBatchNo());
            return alipayOpenAgentCancelModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
