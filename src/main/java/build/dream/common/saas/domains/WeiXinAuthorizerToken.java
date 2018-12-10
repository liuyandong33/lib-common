package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class WeiXinAuthorizerToken extends BasicDomain {
    private String componentAppId;
    private String authorizerAppId;
    private String authorizerAccessToken;
    private Integer expiresIn;
    private String authorizerRefreshToken;
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

    public static class Builder {
        private final WeiXinAuthorizerToken instance = new WeiXinAuthorizerToken();

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

        public WeiXinAuthorizerToken build() {
            return instance;
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
