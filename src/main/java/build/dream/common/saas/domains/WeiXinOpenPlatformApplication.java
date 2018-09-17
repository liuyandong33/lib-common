package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class WeiXinOpenPlatformApplication extends BasicDomain {
    private String appId;
    private String appSecret;
    private String encodingAesKey;
    private String token;
    private Integer type;

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

    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static class Builder {
        private final WeiXinOpenPlatformApplication instance = new WeiXinOpenPlatformApplication();

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder appSecret(String appSecret) {
            instance.setAppSecret(appSecret);
            return this;
        }

        public Builder encodingAesKey(String encodingAesKey) {
            instance.setEncodingAesKey(encodingAesKey);
            return this;
        }

        public Builder token(String token) {
            instance.setToken(token);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
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

        public WeiXinOpenPlatformApplication build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String APP_ID = "app_id";
        public static final String APP_SECRET = "app_secret";
        public static final String ENCODING_AES_KEY = "encoding_aes_key";
        public static final String TOKEN = "token";
        public static final String TYPE = "type";
    }
}
