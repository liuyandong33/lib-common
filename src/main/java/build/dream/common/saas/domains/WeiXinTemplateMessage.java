package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

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
}
