package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicMessageSingleSendModel extends AlipayBasicModel {
    @Length(max = 32)
    @JsonProperty(value = "to_user_id")
    private String toUserId;

    private Template template;

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicMessageSingleSendModel instance = new AlipayOpenPublicMessageSingleSendModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder toUserId(String toUserId) {
            instance.setToUserId(toUserId);
            return this;
        }

        public Builder template(Template template) {
            instance.setTemplate(template);
            return this;
        }

        public AlipayOpenPublicMessageSingleSendModel build() {
            AlipayOpenPublicMessageSingleSendModel alipayOpenPublicMessageSingleSendModel = new AlipayOpenPublicMessageSingleSendModel();
            build(alipayOpenPublicMessageSingleSendModel);
            alipayOpenPublicMessageSingleSendModel.setToUserId(instance.getToUserId());
            alipayOpenPublicMessageSingleSendModel.setTemplate(instance.getTemplate());
            return alipayOpenPublicMessageSingleSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Keyword extends BasicModel {
        @NotNull
        @Length(max = 10)
        private String color;

        @NotNull
        @Length(max = 128)
        private String value;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class Context extends BasicModel {
        @NotNull
        @Length(max = 10)
        @JsonProperty(value = "head_color")
        private String headColor;

        @NotNull
        @Length(max = 256)
        private String url;

        @NotNull
        @Length(max = 32)
        @JsonProperty(value = "action_name")
        private String actionName;

        private Keyword keyword1;

        private Keyword keyword2;

        private Keyword first;

        private Keyword remark;

        public String getHeadColor() {
            return headColor;
        }

        public void setHeadColor(String headColor) {
            this.headColor = headColor;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public Keyword getKeyword1() {
            return keyword1;
        }

        public void setKeyword1(Keyword keyword1) {
            this.keyword1 = keyword1;
        }

        public Keyword getKeyword2() {
            return keyword2;
        }

        public void setKeyword2(Keyword keyword2) {
            this.keyword2 = keyword2;
        }

        public Keyword getFirst() {
            return first;
        }

        public void setFirst(Keyword first) {
            this.first = first;
        }

        public Keyword getRemark() {
            return remark;
        }

        public void setRemark(Keyword remark) {
            this.remark = remark;
        }
    }

    public static class Template extends BasicModel {
        @NotNull
        @Length(max = 128)
        @JsonProperty(value = "template_id")
        private String templateId;

        @NotNull
        private Context context;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }
    }
}