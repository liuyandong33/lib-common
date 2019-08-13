package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class WeiXinPublicAccount extends BasicDomain {
    public static final String TABLE_NAME = "wei_xin_public_account";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 公众号名称
     */
    private String name;
    /**
     * 公众号app id
     */
    private String appId;
    /**
     * 公众号 app secret
     */
    private String appSecret;
    /**
     * 公众号原始ID
     */
    private String originalId;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public static class Builder extends BasicDomain.Builder<Builder, WeiXinPublicAccount> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

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

        @Override
        public WeiXinPublicAccount build() {
            WeiXinPublicAccount weiXinPublicAccount = super.build();
            weiXinPublicAccount.setTenantId(instance.getTenantId());
            weiXinPublicAccount.setName(instance.getName());
            weiXinPublicAccount.setAppId(instance.getAppId());
            weiXinPublicAccount.setAppSecret(instance.getAppSecret());
            weiXinPublicAccount.setOriginalId(instance.getOriginalId());
            return weiXinPublicAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String NAME = "name";
        public static final String APP_ID = "app_id";
        public static final String APP_SECRET = "app_secret";
        public static final String ORIGINAL_ID = "original_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String NAME = "name";
        public static final String APP_ID = "appId";
        public static final String APP_SECRET = "appSecret";
        public static final String ORIGINAL_ID = "originalId";
    }
}
