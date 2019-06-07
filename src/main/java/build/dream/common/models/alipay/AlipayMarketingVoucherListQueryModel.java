package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingVoucherListQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "template_id")
    private String templateId;

    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "user_id")
    private String userId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingVoucherListQueryModel> {
        public Builder templateId(String templateId) {
            instance.setTemplateId(templateId);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        @Override
        public AlipayMarketingVoucherListQueryModel build() {
            AlipayMarketingVoucherListQueryModel alipayMarketingVoucherListQueryModel = super.build();
            alipayMarketingVoucherListQueryModel.setTemplateId(instance.getTemplateId());
            alipayMarketingVoucherListQueryModel.setUserId(instance.getUserId());
            return alipayMarketingVoucherListQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
