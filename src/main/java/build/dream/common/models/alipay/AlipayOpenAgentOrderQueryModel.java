package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAgentOrderQueryModel extends AlipayBasicModel {
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
        private final AlipayOpenAgentOrderQueryModel instance = new AlipayOpenAgentOrderQueryModel();

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

        public AlipayOpenAgentOrderQueryModel build() {
            AlipayOpenAgentOrderQueryModel alipayOpenAgentOrderQueryModel = new AlipayOpenAgentOrderQueryModel();
            alipayOpenAgentOrderQueryModel.setTenantId(instance.getTenantId());
            alipayOpenAgentOrderQueryModel.setBranchId(instance.getBranchId());
            alipayOpenAgentOrderQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenAgentOrderQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenAgentOrderQueryModel.setAuthToken(instance.getAuthToken());
            alipayOpenAgentOrderQueryModel.setBatchNo(instance.getBatchNo());
            return alipayOpenAgentOrderQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
