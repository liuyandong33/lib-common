package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class WeiXinOpenPlatformApplication extends BasicDomain {
    private String appId;
    private String appSecret;

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
}
