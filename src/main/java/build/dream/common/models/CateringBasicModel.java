package build.dream.common.models;

import build.dream.common.auth.CustomUserDetails;
import build.dream.common.saas.domains.SystemUser;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.WebSecurityUtils;
import org.apache.commons.collections.MapUtils;

import java.math.BigInteger;
import java.util.Map;

public class CateringBasicModel extends BasicModel {
    private BigInteger userId;
    private BigInteger tenantId;
    private String tenantCode;
    private BigInteger branchId;
    private String branchCode;
    private String publicKey;
    private String privateKey;

    public CateringBasicModel() {
        CustomUserDetails customUserDetails = WebSecurityUtils.obtainCustomUserDetails();
        SystemUser systemUser = customUserDetails.getSystemUser();
        Tenant tenant = customUserDetails.getTenant();
        Map<String, Object> branchInfo = customUserDetails.getBranchInfo();
        String publicKey = customUserDetails.getPublicKey();
        String privateKey = customUserDetails.getPrivateKey();

        this.userId = systemUser.getId();
        this.tenantId = tenant.getId();
        this.tenantCode = tenant.getCode();
        this.branchId = BigInteger.valueOf(MapUtils.getLongValue(branchInfo, "id"));
        this.branchCode = MapUtils.getString(branchInfo, "code");
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

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
}
