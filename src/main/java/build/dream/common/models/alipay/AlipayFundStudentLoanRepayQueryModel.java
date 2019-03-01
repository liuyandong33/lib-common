package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayFundStudentLoanRepayQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 60)
    @JsonProperty(value = "logon_id")
    private String logonId;

    @NotNull
    @Length(max = 18)
    @JsonProperty(value = "cert_no")
    private String certNo;

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
