package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.CustomUserDetails;
import build.dream.common.saas.domains.SystemUser;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.WebSecurityUtils;
import org.apache.commons.collections.MapUtils;

import java.math.BigInteger;
import java.util.Map;

public class CateringBasicModel extends BasicModel {
    @InstantiateObjectIgnore
    private BigInteger _userId;

    @InstantiateObjectIgnore
    private BigInteger _tenantId;

    @InstantiateObjectIgnore
    private String _tenantCode;

    @InstantiateObjectIgnore
    private BigInteger _branchId;

    @InstantiateObjectIgnore
    private String _branchCode;

    @InstantiateObjectIgnore
    private String _publicKey;

    @InstantiateObjectIgnore
    private String _privateKey;

    @InstantiateObjectIgnore
    private String _partitionCode;

    @InstantiateObjectIgnore
    private String _clientType;

    @InstantiateObjectIgnore
    private Integer _vipSharedType;

    public CateringBasicModel() {
        CustomUserDetails customUserDetails = WebSecurityUtils.obtainCustomUserDetails();
        SystemUser systemUser = customUserDetails.getSystemUser();
        Tenant tenant = customUserDetails.getTenant();
        Map<String, Object> branchInfo = customUserDetails.getBranchInfo();
        String publicKey = customUserDetails.getPublicKey();
        String privateKey = customUserDetails.getPrivateKey();

        this._userId = systemUser.getId();
        this._tenantId = tenant.getId();
        this._tenantCode = tenant.getCode();
        this._branchId = BigInteger.valueOf(MapUtils.getLongValue(branchInfo, "id"));
        this._branchCode = MapUtils.getString(branchInfo, "code");
        this._publicKey = publicKey;
        this._privateKey = privateKey;
        this._partitionCode = tenant.getPartitionCode();
        this._clientType = customUserDetails.getClientType();
        this._vipSharedType = tenant.getVipSharedType();
    }

    public BigInteger obtainUserId() {
        return _userId;
    }

    public BigInteger obtainTenantId() {
        return _tenantId;
    }

    public String obtainTenantCode() {
        return _tenantCode;
    }

    public BigInteger obtainBranchId() {
        return _branchId;
    }

    public String obtainBranchCode() {
        return _branchCode;
    }

    public String obtainPublicKey() {
        return _publicKey;
    }

    public String obtainPrivateKey() {
        return _privateKey;
    }

    public String obtainPartitionCode() {
        return _partitionCode;
    }

    public String obtainClientType() {
        return this._clientType;
    }

    public Integer obtainVipSharedType() {
        return this._vipSharedType;
    }
}
