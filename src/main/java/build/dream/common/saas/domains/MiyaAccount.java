package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class MiyaAccount extends BasicDomain {
    private BigInteger tenantId;
    private BigInteger branchId;
    private String miyaMerchantCode;
    private String miyaKey;
    private String miyaBranchCode;

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

    public String getMiyaMerchantCode() {
        return miyaMerchantCode;
    }

    public void setMiyaMerchantCode(String miyaMerchantCode) {
        this.miyaMerchantCode = miyaMerchantCode;
    }

    public String getMiyaKey() {
        return miyaKey;
    }

    public void setMiyaKey(String miyaKey) {
        this.miyaKey = miyaKey;
    }

    public String getMiyaBranchCode() {
        return miyaBranchCode;
    }

    public void setMiyaBranchCode(String miyaBranchCode) {
        this.miyaBranchCode = miyaBranchCode;
    }
}
