package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCardActivateFormQueryModel extends AlipayBasicModel {
    @NotNull
    @InList(value = {"MEMBER_CARD"})
    @JsonProperty(value = "biz_type")
    private String bizType;

    @NotNull
    @Length(max = 1024)
    @JsonProperty(value = "template_id")
    private String templateId;

    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "request_id")
    private String requestId;

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public static class Builder {
        private final AlipayMarketingCardActivateFormQueryModel instance = new AlipayMarketingCardActivateFormQueryModel();

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

        public Builder bizType(String bizType) {
            instance.setBizType(bizType);
            return this;
        }

        public Builder templateId(String templateId) {
            instance.setTemplateId(templateId);
            return this;
        }

        public Builder requestId(String requestId) {
            instance.setRequestId(requestId);
            return this;
        }

        public AlipayMarketingCardActivateFormQueryModel build() {
            AlipayMarketingCardActivateFormQueryModel alipayMarketingCardActivateFormQueryModel = new AlipayMarketingCardActivateFormQueryModel();
            alipayMarketingCardActivateFormQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingCardActivateFormQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingCardActivateFormQueryModel.setBizType(instance.getBizType());
            alipayMarketingCardActivateFormQueryModel.setTemplateId(instance.getTemplateId());
            alipayMarketingCardActivateFormQueryModel.setRequestId(instance.getRequestId());
            return alipayMarketingCardActivateFormQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
