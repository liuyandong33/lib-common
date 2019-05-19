package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.TenantUserDetails;
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
        TenantUserDetails tenantUserDetails = WebSecurityUtils.obtainTenantUserDetails();
        BigInteger tenantId = tenantUserDetails.getTenantId();
        Tenant tenant = TenantUtils.obtainTenantInfo(tenantId);

        this._userId = tenantUserDetails.getUserId();
        this._tenantId = tenantId;
        this._tenantCode = tenantUserDetails.getTenantCode();
        this._branchId = tenantUserDetails.getBranchId();
        this._branchCode = tenantUserDetails.getBranchCode();
        this._publicKey = tenantUserDetails.getPublicKey();
        this._privateKey = tenantUserDetails.getPrivateKey();
        this._partitionCode = tenantUserDetails.getPartitionCode();
        this._clientType = tenantUserDetails.getClientType();
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
