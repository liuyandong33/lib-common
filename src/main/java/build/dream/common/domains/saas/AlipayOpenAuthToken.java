package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class AlipayOpenAuthToken extends BasicDomain {
    public static final String TABLE_NAME = "alipay_open_auth_token";
    /**
     * 支付宝app id
     */
    private String appId;
    /**
     * 授权令牌
     */
    private String appAuthToken;
    /**
     * 支付宝用户id
     */
    private String userId;
    /**
     * 授权app id
     */
    private String authAppId;
    /**
     * token 有效时间
     */
    private Integer expiresIn;
    /**
     * 刷新token有效时间
     */
    private Integer reExpiresIn;
    /**
     * 刷新token
     */
    private String appRefreshToken;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthAppId() {
        return authAppId;
    }

    public void setAuthAppId(String authAppId) {
        this.authAppId = authAppId;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getReExpiresIn() {
        return reExpiresIn;
    }

    public void setReExpiresIn(Integer reExpiresIn) {
        this.reExpiresIn = reExpiresIn;
    }

    public String getAppRefreshToken() {
        return appRefreshToken;
    }

    public void setAppRefreshToken(String appRefreshToken) {
        this.appRefreshToken = appRefreshToken;
    }

    public static class Builder extends BasicDomain.Builder<Builder, AlipayOpenAuthToken> {
        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder appAuthToken(String appAuthToken) {
            instance.setAppAuthToken(appAuthToken);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder authAppId(String authAppId) {
            instance.setAuthAppId(authAppId);
            return this;
        }

        public Builder expiresIn(Integer expiresIn) {
            instance.setExpiresIn(expiresIn);
            return this;
        }

        public Builder reExpiresIn(Integer reExpiresIn) {
            instance.setReExpiresIn(reExpiresIn);
            return this;
        }

        public Builder appRefreshToken(String appRefreshToken) {
            instance.setAppRefreshToken(appRefreshToken);
            return this;
        }

        @Override
        public AlipayOpenAuthToken build() {
            AlipayOpenAuthToken alipayOpenAuthToken = super.build();
            alipayOpenAuthToken.setAppId(instance.getAppId());
            alipayOpenAuthToken.setAppAuthToken(instance.getAppAuthToken());
            alipayOpenAuthToken.setUserId(instance.getUserId());
            alipayOpenAuthToken.setAuthAppId(instance.getAuthAppId());
            alipayOpenAuthToken.setExpiresIn(instance.getExpiresIn());
            alipayOpenAuthToken.setReExpiresIn(instance.getReExpiresIn());
            alipayOpenAuthToken.setAppRefreshToken(instance.getAppRefreshToken());
            return alipayOpenAuthToken;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String APP_ID = "app_id";
        public static final String APP_AUTH_TOKEN = "app_auth_token";
        public static final String USER_ID = "user_id";
        public static final String AUTH_APP_ID = "auth_app_id";
        public static final String EXPIRES_IN = "expires_in";
        public static final String RE_EXPIRES_IN = "re_expires_in";
        public static final String APP_REFRESH_TOKEN = "app_refresh_token";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String APP_ID = "appId";
        public static final String APP_AUTH_TOKEN = "appAuthToken";
        public static final String USER_ID = "userId";
        public static final String AUTH_APP_ID = "authAppId";
        public static final String EXPIRES_IN = "expiresIn";
        public static final String RE_EXPIRES_IN = "reExpiresIn";
        public static final String APP_REFRESH_TOKEN = "appRefreshToken";
    }
}
