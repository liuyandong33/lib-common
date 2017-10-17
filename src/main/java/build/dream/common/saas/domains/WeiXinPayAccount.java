package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

/**
 * Created by liuyandong on 2017/7/20.
 */
public class WeiXinPayAccount extends BasicDomain {
    private BigInteger tenantId;
    private BigInteger branchId;
    private String appId;
    private String mchId;
    private String apiSecretKey;
    private String subPublicAccountAppId;
    private String subOpenPlatformAppId;
    private String subMchId;
    private boolean acceptanceModel;
    private Integer accountType;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getApiSecretKey() {
        return apiSecretKey;
    }

    public void setApiSecretKey(String apiSecretKey) {
        this.apiSecretKey = apiSecretKey;
    }

    public String getSubPublicAccountAppId() {
        return subPublicAccountAppId;
    }

    public void setSubPublicAccountAppId(String subPublicAccountAppId) {
        this.subPublicAccountAppId = subPublicAccountAppId;
    }

    public String getSubOpenPlatformAppId() {
        return subOpenPlatformAppId;
    }

    public void setSubOpenPlatformAppId(String subOpenPlatformAppId) {
        this.subOpenPlatformAppId = subOpenPlatformAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public boolean isAcceptanceModel() {
        return acceptanceModel;
    }

    public void setAcceptanceModel(boolean acceptanceModel) {
        this.acceptanceModel = acceptanceModel;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
}
