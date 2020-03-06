package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class RsaKeyPair extends BasicDomain {
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 客户端ID
     */
    private String clientId;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 平台公钥
     */
    private String platformPublicKey;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPlatformPublicKey() {
        return platformPublicKey;
    }

    public void setPlatformPublicKey(String platformPublicKey) {
        this.platformPublicKey = platformPublicKey;
    }

    public static class Builder extends BasicDomain.Builder<Builder, RsaKeyPair> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder clientId(String clientId) {
            instance.setClientId(clientId);
            return this;
        }

        public Builder publicKey(String publicKey) {
            instance.setPublicKey(publicKey);
            return this;
        }

        public Builder privateKey(String privateKey) {
            instance.setPrivateKey(privateKey);
            return this;
        }

        public Builder platformPublicKey(String platformPublicKey) {
            instance.setPlatformPublicKey(platformPublicKey);
            return this;
        }

        @Override
        public RsaKeyPair build() {
            RsaKeyPair rsaKeyPair = super.build();
            rsaKeyPair.setTenantId(instance.getTenantId());
            rsaKeyPair.setClientId(instance.getClientId());
            rsaKeyPair.setPublicKey(instance.getPublicKey());
            rsaKeyPair.setPrivateKey(instance.getPrivateKey());
            rsaKeyPair.setPlatformPublicKey(instance.getPlatformPublicKey());
            return rsaKeyPair;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String CLIENT_ID = "client_id";
        public static final String PUBLIC_KEY = "public_key";
        public static final String PRIVATE_KEY = "private_key";
        public static final String PLATFORM_PUBLIC_KEY = "platform_public_key";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String CLIENT_ID = "clientId";
        public static final String PUBLIC_KEY = "publicKey";
        public static final String PRIVATE_KEY = "privateKey";
        public static final String PLATFORM_PUBLIC_KEY = "platformPublicKey";
    }
}
