package build.dream.common.beans;

import java.math.BigInteger;

public class JDDJVenderInfo {
    private BigInteger tenantId;
    private String tenantCode;
    private String partitionCode;
    private String venderId;
    private String appKey;
    private String appSecret;

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

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public static class Builder {
        private final JDDJVenderInfo instance = new JDDJVenderInfo();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder partitionCode(String partitionCode) {
            instance.setPartitionCode(partitionCode);
            return this;
        }

        public Builder venderId(String venderId) {
            instance.setVenderId(venderId);
            return this;
        }

        public Builder appKey(String appKey) {
            instance.setAppKey(appKey);
            return this;
        }

        public Builder appSecret(String appSecret) {
            instance.setAppSecret(appSecret);
            return this;
        }

        public JDDJVenderInfo build() {
            JDDJVenderInfo jddjVenderInfo = new JDDJVenderInfo();
            jddjVenderInfo.setTenantId(instance.getTenantId());
            jddjVenderInfo.setTenantCode(instance.getTenantCode());
            jddjVenderInfo.setPartitionCode(instance.getPartitionCode());
            jddjVenderInfo.setVenderId(instance.getVenderId());
            jddjVenderInfo.setAppKey(instance.getAppKey());
            jddjVenderInfo.setAppSecret(instance.getAppSecret());
            return jddjVenderInfo;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
