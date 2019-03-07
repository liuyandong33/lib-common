package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCardDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "out_serial_no")
    private String outSerialNo;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "target_card_no")
    private String targetCardNo;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "target_card_no_type")
    private String targetCardNoType;

    @NotNull
    @InList(value = {"USER_UNBUND", "CANCEL", "PRESENT"})
    @JsonProperty(value = "reason_code")
    private String reasonCode;

    @Length(max = 1024)
    @JsonProperty(value = "ext_info")
    private String extInfo;

    public String getOutSerialNo() {
        return outSerialNo;
    }

    public void setOutSerialNo(String outSerialNo) {
        this.outSerialNo = outSerialNo;
    }

    public String getTargetCardNo() {
        return targetCardNo;
    }

    public void setTargetCardNo(String targetCardNo) {
        this.targetCardNo = targetCardNo;
    }

    public String getTargetCardNoType() {
        return targetCardNoType;
    }

    public void setTargetCardNoType(String targetCardNoType) {
        this.targetCardNoType = targetCardNoType;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public static class Builder {
        private final AlipayMarketingCardDeleteModel instance = new AlipayMarketingCardDeleteModel();

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

        public Builder outSerialNo(String outSerialNo) {
            instance.setOutSerialNo(outSerialNo);
            return this;
        }

        public Builder targetCardNo(String targetCardNo) {
            instance.setTargetCardNo(targetCardNo);
            return this;
        }

        public Builder targetCardNoType(String targetCardNoType) {
            instance.setTargetCardNoType(targetCardNoType);
            return this;
        }

        public Builder reasonCode(String reasonCode) {
            instance.setReasonCode(reasonCode);
            return this;
        }

        public Builder extInfo(String extInfo) {
            instance.setExtInfo(extInfo);
            return this;
        }

        public AlipayMarketingCardDeleteModel build() {
            AlipayMarketingCardDeleteModel alipayMarketingCardDeleteModel = new AlipayMarketingCardDeleteModel();
            alipayMarketingCardDeleteModel.setTenantId(instance.getTenantId());
            alipayMarketingCardDeleteModel.setBranchId(instance.getBranchId());
            alipayMarketingCardDeleteModel.setOutSerialNo(instance.getOutSerialNo());
            alipayMarketingCardDeleteModel.setTargetCardNo(instance.getTargetCardNo());
            alipayMarketingCardDeleteModel.setTargetCardNoType(instance.getTargetCardNoType());
            alipayMarketingCardDeleteModel.setReasonCode(instance.getReasonCode());
            alipayMarketingCardDeleteModel.setExtInfo(instance.getExtInfo());
            return alipayMarketingCardDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
