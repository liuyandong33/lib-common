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

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCardActivateFormQueryModel> {
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

        @Override
        public AlipayMarketingCardActivateFormQueryModel build() {
            AlipayMarketingCardActivateFormQueryModel alipayMarketingCardActivateFormQueryModel = super.build();
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
