package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class WeiXinOpenPlatformApplication extends BasicDomain {
    public static final String TABLE_NAME = "wei_xin_open_platform_application";
    /**
     * app id
     */
    private String appId;
    /**
     * app secret
     */
    private String appSecret;
    /**
     * encoding aes key
     */
    private String encodingAesKey;
    /**
     * token
     */
    private String token;
    /**
     * 类型，1-移动应用，2-网站应用，3-公众号，4-小程序，5-第三方平台
     */
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

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
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

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String APP_ID = "appId";
        public static final String APP_SECRET = "appSecret";
        public static final String ENCODING_AES_KEY = "encodingAesKey";
        public static final String TOKEN = "token";
        public static final String TYPE = "type";
    }
}
