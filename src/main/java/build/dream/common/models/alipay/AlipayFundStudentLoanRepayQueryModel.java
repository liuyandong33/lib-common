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

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayFundStudentLoanRepayQueryModel> {
        public Builder logonId(String logonId) {
            instance.setLogonId(logonId);
            return this;
        }

        public Builder certNo(String certNo) {
            instance.setCertNo(certNo);
            return this;
        }

        @Override
        public AlipayFundStudentLoanRepayQueryModel build() {
            AlipayFundStudentLoanRepayQueryModel alipayFundStudentLoanRepayQueryModel = super.build();
            alipayFundStudentLoanRepayQueryModel.setLogonId(instance.getLogonId());
            alipayFundStudentLoanRepayQueryModel.setCertNo(instance.getCertNo());
            return alipayFundStudentLoanRepayQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
