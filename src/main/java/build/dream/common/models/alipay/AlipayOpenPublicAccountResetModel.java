package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicAccountResetModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "bind_account_no")
    private String bindAccountNo;

    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "display_name")
    private String displayName;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "agreement_id")
    private String agreementId;

    @Length(max = 10)
    @JsonProperty(value = "real_name")
    private String realName;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "from_user_id")
    private String fromUserId;

    @Length(max = 200)
    private String remark;

    public String getBindAccountNo() {
        return bindAccountNo;
    }

    public void setBindAccountNo(String bindAccountNo) {
        this.bindAccountNo = bindAccountNo;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicAccountResetModel> {
        public Builder bindAccountNo(String bindAccountNo) {
            instance.setBindAccountNo(bindAccountNo);
            return this;
        }

        public Builder displayName(String displayName) {
            instance.setDisplayName(displayName);
            return this;
        }

        public Builder agreementId(String agreementId) {
            instance.setAgreementId(agreementId);
            return this;
        }

        public Builder realName(String realName) {
            instance.setRealName(realName);
            return this;
        }

        public Builder fromUserId(String fromUserId) {
            instance.setFromUserId(fromUserId);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        @Override
        public AlipayOpenPublicAccountResetModel build() {
            AlipayOpenPublicAccountResetModel alipayOpenPublicAccountResetModel = super.build();
            alipayOpenPublicAccountResetModel.setBindAccountNo(instance.getBindAccountNo());
            alipayOpenPublicAccountResetModel.setDisplayName(instance.getDisplayName());
            alipayOpenPublicAccountResetModel.setAgreementId(instance.getAgreementId());
            alipayOpenPublicAccountResetModel.setRealName(instance.getRealName());
            alipayOpenPublicAccountResetModel.setFromUserId(instance.getFromUserId());
            alipayOpenPublicAccountResetModel.setRemark(instance.getRemark());
            return alipayOpenPublicAccountResetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}