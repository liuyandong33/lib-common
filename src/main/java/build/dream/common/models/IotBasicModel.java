package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.IotUserDetails;
import build.dream.common.utils.WebSecurityUtils;

import java.math.BigInteger;

public class IotBasicModel extends BasicModel {
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

    public IotBasicModel() {
        IotUserDetails iotUserDetails = WebSecurityUtils.obtainIotUserDetails();
        this._userId = iotUserDetails.getUserId();
        this._tenantId = iotUserDetails.getTenantId();
        this._tenantCode = iotUserDetails.getTenantCode();
        this._branchId = iotUserDetails.getBranchId();
        this._branchCode = iotUserDetails.getBranchCode();
        this._publicKey = iotUserDetails.getPublicKey();
        this._privateKey = iotUserDetails.getPrivateKey();
        this._partitionCode = iotUserDetails.getPartitionCode();
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
}
