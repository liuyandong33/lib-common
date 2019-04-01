package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.CustomUserDetails;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.TenantUtils;
import build.dream.common.utils.WebSecurityUtils;

import java.math.BigInteger;

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
        BigInteger tenantId = customUserDetails.getTenantId();
        Tenant tenant = TenantUtils.obtainTenantInfo(tenantId);

        this._userId = customUserDetails.getUserId();
        this._tenantId = tenantId;
        this._tenantCode = customUserDetails.getTenantCode();
        this._branchId = customUserDetails.getBranchId();
        this._branchCode = customUserDetails.getBranchCode();
        this._publicKey = customUserDetails.getPublicKey();
        this._privateKey = customUserDetails.getPrivateKey();
        this._partitionCode = customUserDetails.getPartitionCode();
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
