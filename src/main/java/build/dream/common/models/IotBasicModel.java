package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.IotUserDetails;
import build.dream.common.utils.WebSecurityUtils;

public class IotBasicModel extends OAuthBasicModel {
    @InstantiateObjectIgnore
    private Long $userId;

    @InstantiateObjectIgnore
    private Long $tenantId;

    @InstantiateObjectIgnore
    private String $tenantCode;

    @InstantiateObjectIgnore
    private Long $branchId;

    @InstantiateObjectIgnore
    private String $branchCode;

    @InstantiateObjectIgnore
    private String $publicKey;

    @InstantiateObjectIgnore
    private String $privateKey;

    @InstantiateObjectIgnore
    private String $partitionCode;

    public IotBasicModel() {
        IotUserDetails iotUserDetails = WebSecurityUtils.obtainIotUserDetails();
        this.$userId = iotUserDetails.getUserId();
        this.$tenantId = iotUserDetails.getTenantId();
        this.$tenantCode = iotUserDetails.getTenantCode();
        this.$branchId = iotUserDetails.getBranchId();
        this.$branchCode = iotUserDetails.getBranchCode();
        this.$publicKey = iotUserDetails.getPublicKey();
        this.$privateKey = iotUserDetails.getPrivateKey();
        this.$partitionCode = iotUserDetails.getPartitionCode();
    }

    public Long obtainUserId() {
        return $userId;
    }

    public Long obtainTenantId() {
        return $tenantId;
    }

    public String obtainTenantCode() {
        return $tenantCode;
    }

    public Long obtainBranchId() {
        return $branchId;
    }

    public String obtainBranchCode() {
        return $branchCode;
    }

    public String obtainPublicKey() {
        return $publicKey;
    }

    public String obtainPrivateKey() {
        return $privateKey;
    }

    public String obtainPartitionCode() {
        return $partitionCode;
    }
}
