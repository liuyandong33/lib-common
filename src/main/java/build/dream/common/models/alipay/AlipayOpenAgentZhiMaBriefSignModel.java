package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAgentZhiMaBriefSignModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 25)
    @JsonProperty(value = "batch_no")
    private String batchNo;

    @NotNull
    @Length(max = 16)
    @JsonProperty(value = "mcc_code")
    private String mccCode;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getMccCode() {
        return mccCode;
    }

    public void setMccCode(String mccCode) {
        this.mccCode = mccCode;
    }

    public static class Builder {
        private final AlipayOpenAgentZhiMaBriefSignModel instance = new AlipayOpenAgentZhiMaBriefSignModel();

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

        public Builder mccCode(String mccCode) {
            instance.setMccCode(mccCode);
            return this;
        }

        public AlipayOpenAgentZhiMaBriefSignModel build() {
            AlipayOpenAgentZhiMaBriefSignModel alipayOpenAgentZhiMaBriefSignModel = new AlipayOpenAgentZhiMaBriefSignModel();
            alipayOpenAgentZhiMaBriefSignModel.setTenantId(instance.getTenantId());
            alipayOpenAgentZhiMaBriefSignModel.setBranchId(instance.getBranchId());
            alipayOpenAgentZhiMaBriefSignModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenAgentZhiMaBriefSignModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenAgentZhiMaBriefSignModel.setAuthToken(instance.getAuthToken());
            alipayOpenAgentZhiMaBriefSignModel.setBatchNo(instance.getBatchNo());
            alipayOpenAgentZhiMaBriefSignModel.setMccCode(instance.getMccCode());
            return alipayOpenAgentZhiMaBriefSignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
