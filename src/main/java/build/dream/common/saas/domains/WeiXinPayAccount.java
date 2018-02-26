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
    private String subMiniProgramAppId;
    private String rsaPublicKey;
    private String subMchId;
    private String operationCertificate;
    private String operationCertificatePassword;
    private boolean acceptanceModel;

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

    public String getSubMiniProgramAppId() {
        return subMiniProgramAppId;
    }

    public void setSubMiniProgramAppId(String subMiniProgramAppId) {
        this.subMiniProgramAppId = subMiniProgramAppId;
    }

    public String getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(String rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getOperationCertificate() {
        return operationCertificate;
    }

    public void setOperationCertificate(String operationCertificate) {
        this.operationCertificate = operationCertificate;
    }

    public String getOperationCertificatePassword() {
        return operationCertificatePassword;
    }

    public void setOperationCertificatePassword(String operationCertificatePassword) {
        this.operationCertificatePassword = operationCertificatePassword;
    }

    public boolean isAcceptanceModel() {
        return acceptanceModel;
    }

    public void setAcceptanceModel(boolean acceptanceModel) {
        this.acceptanceModel = acceptanceModel;
    }
}
