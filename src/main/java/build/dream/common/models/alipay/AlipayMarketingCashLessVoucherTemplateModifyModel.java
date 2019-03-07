package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCashLessVoucherTemplateModifyModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 28)
    @JsonProperty(value = "template_id")
    private String templateId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "publish_end_time")
    private String publishEndTime;

    @Length(max = 1024)
    @JsonProperty(value = "rule_conf")
    private String ruleConf;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getPublishEndTime() {
        return publishEndTime;
    }

    public void setPublishEndTime(String publishEndTime) {
        this.publishEndTime = publishEndTime;
    }

    public String getRuleConf() {
        return ruleConf;
    }

    public void setRuleConf(String ruleConf) {
        this.ruleConf = ruleConf;
    }

    public static class Builder {
        private final AlipayMarketingCashLessVoucherTemplateModifyModel instance = new AlipayMarketingCashLessVoucherTemplateModifyModel();

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

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public Builder publishEndTime(String publishEndTime) {
            instance.setPublishEndTime(publishEndTime);
            return this;
        }

        public Builder ruleConf(String ruleConf) {
            instance.setRuleConf(ruleConf);
            return this;
        }

        public AlipayMarketingCashLessVoucherTemplateModifyModel build() {
            AlipayMarketingCashLessVoucherTemplateModifyModel alipayMarketingCashLessVoucherTemplateModifyModel = new AlipayMarketingCashLessVoucherTemplateModifyModel();
            alipayMarketingCashLessVoucherTemplateModifyModel.setTenantId(instance.getTenantId());
            alipayMarketingCashLessVoucherTemplateModifyModel.setBranchId(instance.getBranchId());
            alipayMarketingCashLessVoucherTemplateModifyModel.setTemplateId(instance.getTemplateId());
            alipayMarketingCashLessVoucherTemplateModifyModel.setOutBizNo(instance.getOutBizNo());
            alipayMarketingCashLessVoucherTemplateModifyModel.setPublishEndTime(instance.getPublishEndTime());
            alipayMarketingCashLessVoucherTemplateModifyModel.setRuleConf(instance.getRuleConf());
            return alipayMarketingCashLessVoucherTemplateModifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
