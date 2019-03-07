package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayFundStudentLoanRepayQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 60)
    @JsonProperty(value = "logon_id")
    private String logonId;

    @NotNull
    @Length(max = 18)
    @JsonProperty(value = "cert_no")
    private String certNo;

    public String getLogonId() {
        return logonId;
    }

    public void setLogonId(String logonId) {
        this.logonId = logonId;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public static class Builder {
        private final AlipayFundStudentLoanRepayQueryModel instance = new AlipayFundStudentLoanRepayQueryModel();

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

        public Builder logonId(String logonId) {
            instance.setLogonId(logonId);
            return this;
        }

        public Builder certNo(String certNo) {
            instance.setCertNo(certNo);
            return this;
        }

        public AlipayFundStudentLoanRepayQueryModel build() {
            AlipayFundStudentLoanRepayQueryModel alipayFundStudentLoanRepayQueryModel = new AlipayFundStudentLoanRepayQueryModel();
            alipayFundStudentLoanRepayQueryModel.setTenantId(instance.getTenantId());
            alipayFundStudentLoanRepayQueryModel.setBranchId(instance.getBranchId());
            alipayFundStudentLoanRepayQueryModel.setLogonId(instance.getLogonId());
            alipayFundStudentLoanRepayQueryModel.setCertNo(instance.getCertNo());
            return alipayFundStudentLoanRepayQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
