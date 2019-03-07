package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAgentConfirmModel extends AlipayBasicModel {
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
        private final AlipayOpenAgentConfirmModel instance = new AlipayOpenAgentConfirmModel();

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

        public AlipayOpenAgentConfirmModel build() {
            AlipayOpenAgentConfirmModel alipayOpenAgentConfirmModel = new AlipayOpenAgentConfirmModel();
            alipayOpenAgentConfirmModel.setTenantId(instance.getTenantId());
            alipayOpenAgentConfirmModel.setBranchId(instance.getBranchId());
            alipayOpenAgentConfirmModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenAgentConfirmModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenAgentConfirmModel.setAuthToken(instance.getAuthToken());
            alipayOpenAgentConfirmModel.setBatchNo(instance.getBatchNo());
            return alipayOpenAgentConfirmModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
