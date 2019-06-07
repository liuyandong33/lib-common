package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenAppMiniTemplateMessageSendModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "to_user_id")
    private String toUserId;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "form_id")
    private String formId;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "user_template_id")
    private String userTemplateId;

    @NotNull
    @Length(max = 128)
    private String page;

    @NotNull
    @Length(max = 2048)
    private String data;

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getUserTemplateId() {
        return userTemplateId;
    }

    public void setUserTemplateId(String userTemplateId) {
        this.userTemplateId = userTemplateId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAppMiniTemplateMessageSendModel> {
        public Builder toUserId(String toUserId) {
            instance.setToUserId(toUserId);
            return this;
        }

        public Builder formId(String formId) {
            instance.setFormId(formId);
            return this;
        }

        public Builder userTemplateId(String userTemplateId) {
            instance.setUserTemplateId(userTemplateId);
            return this;
        }

        public Builder page(String page) {
            instance.setPage(page);
            return this;
        }

        public Builder data(String data) {
            instance.setData(data);
            return this;
        }

        @Override
        public AlipayOpenAppMiniTemplateMessageSendModel build() {
            AlipayOpenAppMiniTemplateMessageSendModel alipayOpenAppMiniTemplateMessageSendModel = super.build();
            alipayOpenAppMiniTemplateMessageSendModel.setToUserId(instance.getToUserId());
            alipayOpenAppMiniTemplateMessageSendModel.setFormId(instance.getFormId());
            alipayOpenAppMiniTemplateMessageSendModel.setUserTemplateId(instance.getUserTemplateId());
            alipayOpenAppMiniTemplateMessageSendModel.setPage(instance.getPage());
            alipayOpenAppMiniTemplateMessageSendModel.setData(instance.getData());
            return alipayOpenAppMiniTemplateMessageSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
