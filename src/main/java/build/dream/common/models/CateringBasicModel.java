package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.CustomUserDetails;
import build.dream.common.beans.AlipayUserInfo;
import build.dream.common.saas.domains.SystemUser;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.WebSecurityUtils;
import org.apache.commons.collections.MapUtils;

import java.math.BigInteger;
import java.util.Map;

public class CateringBasicModel extends BasicModel {
    @InstantiateObjectIgnore
    private BigInteger userId;

    @InstantiateObjectIgnore
    private BigInteger tenantId;

    @InstantiateObjectIgnore
    private String tenantCode;

    @InstantiateObjectIgnore
    private BigInteger branchId;

    @InstantiateObjectIgnore
    private String branchCode;

    @InstantiateObjectIgnore
    private String publicKey;

    @InstantiateObjectIgnore
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

    public BigInteger obtainUserId() {
        return userId;
    }

    public BigInteger obtainTenantId() {
        return tenantId;
    }

    public String obtainTenantCode() {
        return tenantCode;
    }

    public BigInteger obtainBranchId() {
        return branchId;
    }

    public String obtainBranchCode() {
        return branchCode;
    }

    public String obtainPublicKey() {
        return publicKey;
    }

    public String obtainPrivateKey() {
        return privateKey;
    }

    public static void main(String[] args) throws Exception {
        ApplicationHandler.instantiateObject(AlipayUserInfo.class, null);
    }
}
