package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.CateringUserDetails;
import build.dream.common.domains.saas.Tenant;
import build.dream.common.utils.TenantUtils;
import build.dream.common.utils.WebSecurityUtils;

public class CateringBasicModel extends OAuthBasicModel {
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

    @InstantiateObjectIgnore
    private String $clientType;

    @InstantiateObjectIgnore
    private Integer $vipSharedType;

    public CateringBasicModel() {
        CateringUserDetails cateringUserDetails = WebSecurityUtils.obtainCateringUserDetails();
        Long tenantId = cateringUserDetails.getTenantId();
        Tenant tenant = TenantUtils.obtainTenantInfo(tenantId);

        this.$userId = cateringUserDetails.getUserId();
        this.$tenantId = tenantId;
        this.$tenantCode = cateringUserDetails.getTenantCode();
        this.$branchId = cateringUserDetails.getBranchId();
        this.$branchCode = cateringUserDetails.getBranchCode();
        this.$publicKey = cateringUserDetails.getPublicKey();
        this.$privateKey = cateringUserDetails.getPrivateKey();
        this.$partitionCode = cateringUserDetails.getPartitionCode();
        this.$clientType = cateringUserDetails.getClientType();
        this.$vipSharedType = tenant.getVipSharedType();
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

    public String obtainClientType() {
        return this.$clientType;
    }

    public Integer obtainVipSharedType() {
        return this.$vipSharedType;
    }
}
