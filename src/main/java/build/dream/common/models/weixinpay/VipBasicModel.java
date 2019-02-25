package build.dream.common.models.weixinpay;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.VipUserDetails;
import build.dream.common.catering.domains.Vip;
import build.dream.common.models.BasicModel;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.WebSecurityUtils;

import java.math.BigInteger;

public class VipBasicModel extends BasicModel {
    @InstantiateObjectIgnore
    private BigInteger _tenantId;

    @InstantiateObjectIgnore
    private String _tenantCode;

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

    @InstantiateObjectIgnore
    private BigInteger _vipId;

    public VipBasicModel() {
        VipUserDetails vipUserDetails = WebSecurityUtils.obtainVipUserDetails();
        Tenant tenant = vipUserDetails.getTenant();
        Vip vip = vipUserDetails.getVip();

        this._tenantId = tenant.getId();
        this._tenantCode = tenant.getCode();
        this._publicKey = vipUserDetails.getPublicKey();
        this._privateKey = vipUserDetails.getPrivateKey();
        this._partitionCode = tenant.getPartitionCode();
        this._clientType = vipUserDetails.getClientType();
        this._vipSharedType = tenant.getVipSharedType();
        this._vipId = vip.getId();
    }

    public BigInteger obtainTenantId() {
        return _tenantId;
    }

    public String obtainTenantCode() {
        return _tenantCode;
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

    public BigInteger obtainVipId() {
        return this._vipId;
    }
}
