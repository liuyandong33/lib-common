package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCashVoucherTemplateModifyModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "template_id")
    private String templateId;

    @Length(max = 6)
    private String slogan;

    @Length(min = 19, max = 19)
    @JsonProperty(value = "publish_start_time")
    private String publishStartTime;

    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "publish_end_time")
    private String publishEndTime;

    @Length(max = 128)
    @JsonProperty(value = "voucher_valid_period")
    private String voucherValidPeriod;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getPublishStartTime() {
        return publishStartTime;
    }

    public void setPublishStartTime(String publishStartTime) {
        this.publishStartTime = publishStartTime;
    }

    public String getPublishEndTime() {
        return publishEndTime;
    }

    public void setPublishEndTime(String publishEndTime) {
        this.publishEndTime = publishEndTime;
    }

    public String getVoucherValidPeriod() {
        return voucherValidPeriod;
    }

    public void setVoucherValidPeriod(String voucherValidPeriod) {
        this.voucherValidPeriod = voucherValidPeriod;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public static class Builder {
        private final AlipayMarketingCashVoucherTemplateModifyModel instance = new AlipayMarketingCashVoucherTemplateModifyModel();

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

        public Builder slogan(String slogan) {
            instance.setSlogan(slogan);
            return this;
        }

        public Builder publishStartTime(String publishStartTime) {
            instance.setPublishStartTime(publishStartTime);
            return this;
        }

        public Builder publishEndTime(String publishEndTime) {
            instance.setPublishEndTime(publishEndTime);
            return this;
        }

        public Builder voucherValidPeriod(String voucherValidPeriod) {
            instance.setVoucherValidPeriod(voucherValidPeriod);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public AlipayMarketingCashVoucherTemplateModifyModel build() {
            AlipayMarketingCashVoucherTemplateModifyModel alipayMarketingCashVoucherTemplateModifyModel = new AlipayMarketingCashVoucherTemplateModifyModel();
            alipayMarketingCashVoucherTemplateModifyModel.setTenantId(instance.getTenantId());
            alipayMarketingCashVoucherTemplateModifyModel.setBranchId(instance.getBranchId());
            alipayMarketingCashVoucherTemplateModifyModel.setTemplateId(instance.getTemplateId());
            alipayMarketingCashVoucherTemplateModifyModel.setSlogan(instance.getSlogan());
            alipayMarketingCashVoucherTemplateModifyModel.setPublishStartTime(instance.getPublishStartTime());
            alipayMarketingCashVoucherTemplateModifyModel.setPublishEndTime(instance.getPublishEndTime());
            alipayMarketingCashVoucherTemplateModifyModel.setVoucherValidPeriod(instance.getVoucherValidPeriod());
            alipayMarketingCashVoucherTemplateModifyModel.setOutBizNo(instance.getOutBizNo());
            return alipayMarketingCashVoucherTemplateModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
