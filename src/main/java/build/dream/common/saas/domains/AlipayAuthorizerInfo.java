package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class AlipayAuthorizerInfo extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;

    /**
     * app id
     */
    private String appId;

    /**
     * 商户授权令牌
     */
    private String appAuthToken;

    /**
     * 授权商户的ID
     */
    private String userId;

    /**
     * 授权商户的AppId
     */
    private String authAppId;

    /**
     * 令牌有效期
     */
    private Integer expiresIn;

    /**
     * 刷新令牌有效期
     */
    private Integer reExpiresIn;

    /**
     * 刷新令牌时使用
     */
    private String appRefreshToken;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

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

    public static class Builder {
        private final AlipayAuthorizerInfo instance = new AlipayAuthorizerInfo();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

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

        public AlipayAuthorizerInfo build() {
            return instance;
        }
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String APP_ID = "app_id";
        public static final String APP_AUTH_TOKEN = "app_auth_token";
        public static final String USER_ID = "user_id";
        public static final String AUTH_APP_ID = "auth_app_id";
        public static final String EXPIRES_IN = "expires_in";
        public static final String RE_EXPIRES_IN = "re_expires_in";
        public static final String APP_REFRESH_TOKEN = "app_refresh_token";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String APP_ID = "appId";
        public static final String APP_AUTH_TOKEN = "appAuthToken";
        public static final String USER_ID = "userId";
        public static final String AUTH_APP_ID = "authAppId";
        public static final String EXPIRES_IN = "expiresIn";
        public static final String RE_EXPIRES_IN = "reExpiresIn";
        public static final String APP_REFRESH_TOKEN = "appRefreshToken";
    }
}
