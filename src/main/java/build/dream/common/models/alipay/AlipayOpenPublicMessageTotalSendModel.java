package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicMessageTotalSendModel extends AlipayBasicModel {
    @InList(value = {"image-text", "text"})
    @JsonProperty(value = "msg_type")
    private String msgType;

    private List<Article> articles;

    private Text text;

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

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if ("image-text".equals(msgType)) {
            ApplicationHandler.notEmpty(articles, "articles");
            for (Article article : articles) {
                ApplicationHandler.isTrue(article.validate(), "articles");
            }
        }

        if ("text".equals(msgType)) {
            ApplicationHandler.isTrue(text.validate(), "text");
        }
    }

    public static class Builder {
        private final AlipayOpenPublicMessageTotalSendModel instance = new AlipayOpenPublicMessageTotalSendModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
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

        public AlipayOpenPublicMessageTotalSendModel build() {
            AlipayOpenPublicMessageTotalSendModel alipayOpenPublicMessageTotalSendModel = new AlipayOpenPublicMessageTotalSendModel();
            alipayOpenPublicMessageTotalSendModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageTotalSendModel.setBranchId(instance.getBranchId());
            alipayOpenPublicMessageTotalSendModel.setMsgType(instance.getMsgType());
            alipayOpenPublicMessageTotalSendModel.setArticles(instance.getArticles());
            alipayOpenPublicMessageTotalSendModel.setText(instance.getText());
            return alipayOpenPublicMessageTotalSendModel;
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
}
