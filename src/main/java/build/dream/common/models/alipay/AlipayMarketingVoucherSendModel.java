package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayMarketingVoucherSendModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 28)
    @JsonProperty(value = "template_id")
    private String templateId;

    @Length(max = 128)
    @JsonProperty(value = "login_id")
    private String loginId;

    @Length(max = 128)
    @JsonProperty(value = "taobao_nick")
    private String taobaoNick;

    @Length(max = 16)
    @JsonProperty(value = "user_id")
    private String userId;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    @DecimalMin(value = "0.01")
    @DecimalMax(value = "9999999999")
    private BigDecimal amount;

    @Length(max = 128)
    private String memo;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getTaobaoNick() {
        return taobaoNick;
    }

    public void setTaobaoNick(String taobaoNick) {
        this.taobaoNick = taobaoNick;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public static class Builder {
        private final AlipayMarketingVoucherSendModel instance = new AlipayMarketingVoucherSendModel();

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

        public Builder templateId(String templateId) {
            instance.setTemplateId(templateId);
            return this;
        }

        public Builder loginId(String loginId) {
            instance.setLoginId(loginId);
            return this;
        }

        public Builder taobaoNick(String taobaoNick) {
            instance.setTaobaoNick(taobaoNick);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public Builder amount(BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder memo(String memo) {
            instance.setMemo(memo);
            return this;
        }

        public AlipayMarketingVoucherSendModel build() {
            AlipayMarketingVoucherSendModel alipayMarketingVoucherSendModel = new AlipayMarketingVoucherSendModel();
            alipayMarketingVoucherSendModel.setTenantId(instance.getTenantId());
            alipayMarketingVoucherSendModel.setBranchId(instance.getBranchId());
            alipayMarketingVoucherSendModel.setTemplateId(instance.getTemplateId());
            alipayMarketingVoucherSendModel.setLoginId(instance.getLoginId());
            alipayMarketingVoucherSendModel.setTaobaoNick(instance.getTaobaoNick());
            alipayMarketingVoucherSendModel.setUserId(instance.getUserId());
            alipayMarketingVoucherSendModel.setOutBizNo(instance.getOutBizNo());
            alipayMarketingVoucherSendModel.setAmount(instance.getAmount());
            alipayMarketingVoucherSendModel.setMemo(instance.getMemo());
            return alipayMarketingVoucherSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
