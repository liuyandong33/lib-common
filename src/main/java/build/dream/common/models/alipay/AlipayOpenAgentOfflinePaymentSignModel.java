package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class AlipayOpenAgentOfflinePaymentSignModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 25)
    @JsonProperty(value = "batch_no")
    private String batchNo;

    @NotNull
    @Length(max = 15)
    @JsonProperty(value = "mcc_code")
    private String mccCode;

    @NotNull
    @DecimalMin(value = "0.38")
    @DecimalMax(value = "3")
    private Double rate;

    @Length(max = 32)
    @JsonProperty(value = "business_license_no")
    private String businessLicenseNo;

    @JsonProperty(value = "long_term")
    private Boolean longTerm;

    @Length(min = 10, max = 10)
    @JsonProperty(value = "date_limitation")
    private String dateLimitation;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }

    public Boolean getLongTerm() {
        return longTerm;
    }

    public void setLongTerm(Boolean longTerm) {
        this.longTerm = longTerm;
    }

    public String getDateLimitation() {
        return dateLimitation;
    }

    public void setDateLimitation(String dateLimitation) {
        this.dateLimitation = dateLimitation;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAgentOfflinePaymentSignModel> {
        public Builder batchNo(String batchNo) {
            instance.setBatchNo(batchNo);
            return this;
        }

        public Builder rate(Double rate) {
            instance.setRate(rate);
            return this;
        }

        public Builder businessLicenseNo(String businessLicenseNo) {
            instance.setBusinessLicenseNo(businessLicenseNo);
            return this;
        }

        public Builder longTerm(Boolean longTerm) {
            instance.setLongTerm(longTerm);
            return this;
        }

        public Builder dateLimitation(String dateLimitation) {
            instance.setDateLimitation(dateLimitation);
            return this;
        }

        @Override
        public AlipayOpenAgentOfflinePaymentSignModel build() {
            AlipayOpenAgentOfflinePaymentSignModel alipayOpenAgentOfflinePaymentSignModel = super.build();
            alipayOpenAgentOfflinePaymentSignModel.setBatchNo(instance.getBatchNo());
            alipayOpenAgentOfflinePaymentSignModel.setRate(instance.getRate());
            alipayOpenAgentOfflinePaymentSignModel.setBusinessLicenseNo(instance.getBusinessLicenseNo());
            alipayOpenAgentOfflinePaymentSignModel.setLongTerm(instance.getLongTerm());
            alipayOpenAgentOfflinePaymentSignModel.setDateLimitation(instance.getDateLimitation());
            return alipayOpenAgentOfflinePaymentSignModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
