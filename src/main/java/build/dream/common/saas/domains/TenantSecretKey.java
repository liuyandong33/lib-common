package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class TenantSecretKey extends BasicDomain {
    public static final String TABLE_NAME = "tenant_secret_key";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
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

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
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

    public static class Builder {
        private final TenantSecretKey instance = new TenantSecretKey();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
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

        public TenantSecretKey build() {
            TenantSecretKey tenantSecretKey = new TenantSecretKey();
            tenantSecretKey.setTenantId(instance.getTenantId());
            tenantSecretKey.setTenantCode(instance.getTenantCode());
            tenantSecretKey.setPublicKey(instance.getPublicKey());
            tenantSecretKey.setPrivateKey(instance.getPrivateKey());
            tenantSecretKey.setPlatformPublicKey(instance.getPlatformPublicKey());
            tenantSecretKey.setId(instance.getId());
            tenantSecretKey.setCreatedTime(instance.getCreatedTime());
            tenantSecretKey.setCreatedUserId(instance.getCreatedUserId());
            tenantSecretKey.setUpdatedTime(instance.getUpdatedTime());
            tenantSecretKey.setUpdatedUserId(instance.getUpdatedUserId());
            tenantSecretKey.setUpdatedRemark(instance.getUpdatedRemark());
            tenantSecretKey.setDeletedTime(instance.getDeletedTime());
            tenantSecretKey.setDeleted(instance.isDeleted());
            return tenantSecretKey;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String PUBLIC_KEY = "public_key";
        public static final String PRIVATE_KEY = "private_key";
        public static final String PLATFORM_PUBLIC_KEY = "platform_public_key";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String PUBLIC_KEY = "publicKey";
        public static final String PRIVATE_KEY = "privateKey";
        public static final String PLATFORM_PUBLIC_KEY = "platformPublicKey";
    }
}
