package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicMessageGroupSendModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "group_id")
    private String groupId;

    @NotNull
    @InList(value = {"text", "image-text"})
    @JsonProperty(value = "msg_type")
    private String msgType;

    private Text text;

    private Image image;

    private List<Article> articles;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public static class Builder {
        private final AlipayOpenPublicMessageGroupSendModel instance = new AlipayOpenPublicMessageGroupSendModel();

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

        public Builder groupId(String groupId) {
            instance.setGroupId(groupId);
            return this;
        }

        public Builder msgType(String msgType) {
            instance.setMsgType(msgType);
            return this;
        }

        public Builder text(Text text) {
            instance.setText(text);
            return this;
        }

        public Builder image(Image image) {
            instance.setImage(image);
            return this;
        }

        public Builder articles(List<Article> articles) {
            instance.setArticles(articles);
            return this;
        }

        public AlipayOpenPublicMessageGroupSendModel build() {
            AlipayOpenPublicMessageGroupSendModel alipayOpenPublicMessageGroupSendModel = new AlipayOpenPublicMessageGroupSendModel();
            alipayOpenPublicMessageGroupSendModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageGroupSendModel.setBranchId(instance.getBranchId());
            alipayOpenPublicMessageGroupSendModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicMessageGroupSendModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicMessageGroupSendModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicMessageGroupSendModel.setGroupId(instance.getGroupId());
            alipayOpenPublicMessageGroupSendModel.setMsgType(instance.getMsgType());
            alipayOpenPublicMessageGroupSendModel.setText(instance.getText());
            alipayOpenPublicMessageGroupSendModel.setImage(instance.getImage());
            alipayOpenPublicMessageGroupSendModel.setArticles(instance.getArticles());
            return alipayOpenPublicMessageGroupSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Text extends BasicModel {
        @NotNull
        @Length(max = 100)
        private String title;

        @NotNull
        @Length(max = 256)
        private String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class Image extends BasicModel {
        @NotNull
        @Length(max = 100)
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
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

        @NotNull
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
}
