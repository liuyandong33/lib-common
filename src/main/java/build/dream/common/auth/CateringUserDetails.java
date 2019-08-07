package build.dream.common.auth;

import java.math.BigInteger;

public class CateringUserDetails extends TenantUserDetails {
    private BigInteger userId;
    private BigInteger branchId;
    private String branchCode;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
}
