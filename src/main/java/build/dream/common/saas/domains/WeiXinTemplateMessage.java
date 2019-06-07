package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class WeiXinTemplateMessage extends BasicDomain {
    public static final String TABLE_NAME = "wei_xin_template_message";
    /**
     * app id
     */
    private String appId;
    /**
     * app secret
     */
    private String appSecret;
    /**
     * 原始ID
     */
    private String originalId;
    /**
     * 模板消息ID
     */
    private String templateMessageId;
    /**
     * 模板消息编码
     */
    private String weiXinTemplateMessageCode;
    /**
     * 模板消息keys
     */
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

    public static class Builder extends BasicDomain.Builder<Builder, WeiXinTemplateMessage> {
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

        @Override
        public WeiXinTemplateMessage build() {
            WeiXinTemplateMessage weiXinTemplateMessage = super.build();
            weiXinTemplateMessage.setAppId(instance.getAppId());
            weiXinTemplateMessage.setAppSecret(instance.getAppSecret());
            weiXinTemplateMessage.setOriginalId(instance.getOriginalId());
            weiXinTemplateMessage.setTemplateMessageId(instance.getTemplateMessageId());
            weiXinTemplateMessage.setWeiXinTemplateMessageCode(instance.getWeiXinTemplateMessageCode());
            weiXinTemplateMessage.setWeiXinTemplateMessageKeys(instance.getWeiXinTemplateMessageKeys());
            return weiXinTemplateMessage;
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
