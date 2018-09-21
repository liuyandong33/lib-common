package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class WeiXinTemplateMessage extends BasicDomain {
    private String appId;
    private String appSecret;
    private String originalId;
    private String templateMessageId;
    private String weiXinTemplateMessageCode;
    private String weiXinTemplateMessageKeys;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public String getTemplateMessageId() {
        return templateMessageId;
    }

    public void setTemplateMessageId(String templateMessageId) {
        this.templateMessageId = templateMessageId;
    }

    public String getWeiXinTemplateMessageCode() {
        return weiXinTemplateMessageCode;
    }

    public void setWeiXinTemplateMessageCode(String weiXinTemplateMessageCode) {
        this.weiXinTemplateMessageCode = weiXinTemplateMessageCode;
    }

    public String getWeiXinTemplateMessageKeys() {
        return weiXinTemplateMessageKeys;
    }

    public void setWeiXinTemplateMessageKeys(String weiXinTemplateMessageKeys) {
        this.weiXinTemplateMessageKeys = weiXinTemplateMessageKeys;
    }

    public static class Builder {
        private final WeiXinTemplateMessage instance = new WeiXinTemplateMessage();

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder appSecret(String appSecret) {
            instance.setAppSecret(appSecret);
            return this;
        }

        public Builder originalId(String originalId) {
            instance.setOriginalId(originalId);
            return this;
        }

        public Builder templateMessageId(String templateMessageId) {
            instance.setTemplateMessageId(templateMessageId);
            return this;
        }

        public Builder weiXinTemplateMessageCode(String weiXinTemplateMessageCode) {
            instance.setWeiXinTemplateMessageCode(weiXinTemplateMessageCode);
            return this;
        }

        public Builder weiXinTemplateMessageKeys(String weiXinTemplateMessageKeys) {
            instance.setWeiXinTemplateMessageKeys(weiXinTemplateMessageKeys);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public WeiXinTemplateMessage build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String APP_ID = "app_id";
        public static final String APP_SECRET = "app_secret";
        public static final String ORIGINAL_ID = "original_id";
        public static final String TEMPLATE_MESSAGE_ID = "template_message_id";
        public static final String WEI_XIN_TEMPLATE_MESSAGE_CODE = "wei_xin_template_message_code";
        public static final String WEI_XIN_TEMPLATE_MESSAGE_KEYS = "wei_xin_template_message_keys";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String APP_ID = "appId";
        public static final String APP_SECRET = "appSecret";
        public static final String ORIGINAL_ID = "originalId";
        public static final String TEMPLATE_MESSAGE_ID = "templateMessageId";
        public static final String WEI_XIN_TEMPLATE_MESSAGE_CODE = "weiXinTemplateMessageCode";
        public static final String WEI_XIN_TEMPLATE_MESSAGE_KEYS = "weiXinTemplateMessageKeys";
    }
}
