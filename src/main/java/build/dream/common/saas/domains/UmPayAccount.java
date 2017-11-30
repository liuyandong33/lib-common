package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class UmPayAccount extends BasicDomain {
    private BigInteger tenantId;
    private BigInteger branchId;
    private String umPayId;
    private String merchantPrivateKeyPath;
    private String platformPublicKeyPath;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getUmPayId() {
        return umPayId;
    }

    public void setUmPayId(String umPayId) {
        this.umPayId = umPayId;
    }

    public String getMerchantPrivateKeyPath() {
        return merchantPrivateKeyPath;
    }

    public void setMerchantPrivateKeyPath(String merchantPrivateKeyPath) {
        this.merchantPrivateKeyPath = merchantPrivateKeyPath;
    }

    public String getPlatformPublicKeyPath() {
        return platformPublicKeyPath;
    }

    public void setPlatformPublicKeyPath(String platformPublicKeyPath) {
        this.platformPublicKeyPath = platformPublicKeyPath;
    }
}
