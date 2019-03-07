package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicMessageCustomSendModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "to_user_id")
    private String toUserId;

    @NotNull
    @InList(value = {"text", "image-text"})
    @JsonProperty(value = "msg_type")
    private String msgType;

    private List<Article> articles;

    private Text text;

    @NotNull
    @InList(value = {"0", "1"})
    private String chat;

    @InList(value = {"follow", "click", "enter_ppchat"})
    @JsonProperty(value = "event_type")
    private String eventType;

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public static class Builder {
        private final AlipayOpenPublicMessageCustomSendModel instance = new AlipayOpenPublicMessageCustomSendModel();

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

        public Builder toUserId(String toUserId) {
            instance.setToUserId(toUserId);
            return this;
        }

        public Builder msgType(String msgType) {
            instance.setMsgType(msgType);
            return this;
        }

        public Builder articles(List<Article> articles) {
            instance.setArticles(articles);
            return this;
        }

        public Builder text(Text text) {
            instance.setText(text);
            return this;
        }

        public Builder chat(String chat) {
            instance.setChat(chat);
            return this;
        }

        public Builder eventType(String eventType) {
            instance.setEventType(eventType);
            return this;
        }

        public AlipayOpenPublicMessageCustomSendModel build() {
            AlipayOpenPublicMessageCustomSendModel alipayOpenPublicMessageCustomSendModel = new AlipayOpenPublicMessageCustomSendModel();
            alipayOpenPublicMessageCustomSendModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageCustomSendModel.setBranchId(instance.getBranchId());
            alipayOpenPublicMessageCustomSendModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicMessageCustomSendModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicMessageCustomSendModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicMessageCustomSendModel.setToUserId(instance.getToUserId());
            alipayOpenPublicMessageCustomSendModel.setMsgType(instance.getMsgType());
            alipayOpenPublicMessageCustomSendModel.setArticles(instance.getArticles());
            alipayOpenPublicMessageCustomSendModel.setText(instance.getText());
            alipayOpenPublicMessageCustomSendModel.setChat(instance.getChat());
            alipayOpenPublicMessageCustomSendModel.setEventType(instance.getEventType());
            return alipayOpenPublicMessageCustomSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Article extends BasicModel {
        @Length(max = 100)
        private String title;

        @NotNull
        @Length(max = 512)
        private String desc;

        @Length(max = 100)
        @JsonProperty(value = "image_url")
        private String imageUrl;

        @Length(max = 100)
        private String url;

        @Length(max = 64)
        @JsonProperty(value = "action_name")
        private String actionName;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
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
    }

    public static class Text extends BasicModel {
        @NotNull
        @Length(max = 256)
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
