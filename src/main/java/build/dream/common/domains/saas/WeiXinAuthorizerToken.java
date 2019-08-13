package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class WeiXinAuthorizerToken extends BasicDomain {
    public static final String TABLE_NAME = "wei_xin_authorizer_token";
    /**
     * 开放平台ID
     */
    private String componentAppId;
    /**
     * 授权方app id
     */
    private String authorizerAppId;
    /**
     * 访问令牌
     */
    private String authorizerAccessToken;
    /**
     * 过期时间
     */
    private Integer expiresIn;
    /**
     * 刷新令牌
     */
    private String authorizerRefreshToken;
    /**
     * 获取时间
     */
    private Date fetchTime;

    public String getComponentAppId() {
        return componentAppId;
    }

    public void setComponentAppId(String componentAppId) {
        this.componentAppId = componentAppId;
    }

    public String getAuthorizerAppId() {
        return authorizerAppId;
    }

    public void setAuthorizerAppId(String authorizerAppId) {
        this.authorizerAppId = authorizerAppId;
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }

    public static class Builder extends BasicDomain.Builder<Builder, WeiXinAuthorizerToken> {
        public Builder componentAppId(String componentAppId) {
            instance.setComponentAppId(componentAppId);
            return this;
        }

        public Builder authorizerAppId(String authorizerAppId) {
            instance.setAuthorizerAppId(authorizerAppId);
            return this;
        }

        public Builder authorizerAccessToken(String authorizerAccessToken) {
            instance.setAuthorizerAccessToken(authorizerAccessToken);
            return this;
        }

        public Builder expiresIn(Integer expiresIn) {
            instance.setExpiresIn(expiresIn);
            return this;
        }

        public Builder authorizerRefreshToken(String authorizerRefreshToken) {
            instance.setAuthorizerRefreshToken(authorizerRefreshToken);
            return this;
        }

        public Builder fetchTime(Date fetchTime) {
            instance.setFetchTime(fetchTime);
            return this;
        }

        @Override
        public WeiXinAuthorizerToken build() {
            WeiXinAuthorizerToken weiXinAuthorizerToken = super.build();
            weiXinAuthorizerToken.setComponentAppId(instance.getComponentAppId());
            weiXinAuthorizerToken.setAuthorizerAppId(instance.getAuthorizerAppId());
            weiXinAuthorizerToken.setAuthorizerAccessToken(instance.getAuthorizerAccessToken());
            weiXinAuthorizerToken.setExpiresIn(instance.getExpiresIn());
            weiXinAuthorizerToken.setAuthorizerAccessToken(instance.getAuthorizerAccessToken());
            weiXinAuthorizerToken.setFetchTime(instance.getFetchTime());
            return weiXinAuthorizerToken;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String COMPONENT_APP_ID = "component_app_id";
        public static final String AUTHORIZER_APP_ID = "authorizer_app_id";
        public static final String AUTHORIZER_ACCESS_TOKEN = "authorizer_access_token";
        public static final String EXPIRES_IN = "expires_in";
        public static final String AUTHORIZER_REFRESH_TOKEN = "authorizer_refresh_token";
        public static final String FETCH_TIME = "fetch_time";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String COMPONENT_APP_ID = "componentAppId";
        public static final String AUTHORIZER_APP_ID = "authorizerAppId";
        public static final String AUTHORIZER_ACCESS_TOKEN = "authorizerAccessToken";
        public static final String EXPIRES_IN = "expiresIn";
        public static final String AUTHORIZER_REFRESH_TOKEN = "authorizerRefreshToken";
        public static final String FETCH_TIME = "fetchTime";
    }
}
