package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.VipUserDetails;
import build.dream.common.domains.saas.Tenant;
import build.dream.common.utils.TenantUtils;
import build.dream.common.utils.WebSecurityUtils;

public class VipBasicModel extends OAuthBasicModel {
    @InstantiateObjectIgnore
    private Long $tenantId;

    @InstantiateObjectIgnore
    private String $tenantCode;

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

    @InstantiateObjectIgnore
    private Long $vipId;

    public VipBasicModel() {
        VipUserDetails vipUserDetails = WebSecurityUtils.obtainVipUserDetails();
        Long tenantId = vipUserDetails.getTenantId();
        Tenant tenant = TenantUtils.obtainTenantInfo(tenantId);

        this.$tenantId = tenantId;
        this.$tenantCode = vipUserDetails.getTenantCode();
        this.$publicKey = vipUserDetails.getPublicKey();
        this.$privateKey = vipUserDetails.getPrivateKey();
        this.$partitionCode = vipUserDetails.getPartitionCode();
        this.$clientType = vipUserDetails.getClientType();
        this.$vipSharedType = tenant.getVipSharedType();
        this.$vipId = vipUserDetails.getVipId();
    }

    public Long obtainTenantId() {
        return $tenantId;
    }

    public String obtainTenantCode() {
        return $tenantCode;
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

    public Long obtainVipId() {
        return this.$vipId;
    }
}
