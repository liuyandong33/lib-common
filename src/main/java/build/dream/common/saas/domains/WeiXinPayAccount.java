package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by liuyandong on 2017/7/20.
 */
public class WeiXinPayAccount extends BasicDomain {
    private BigInteger tenantId;
    private BigInteger branchId;
    /**
     * 微信公众平台app id
     */
    private String appId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 微信支付商户号
     */
    private String mchId;
    /**
     * api 秘钥
     */
    private String apiSecretKey;
    /**
     * 子商户的公众号app id
     */
    private String subPublicAccountAppId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 子商户的开放平台app id
     */
    private String subOpenPlatformAppId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 子商户的小程序app id
     */
    private String subMiniProgramAppId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 子商户商户号
     */
    private String subMchId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 操作证书
     */
    private String operationCertificate = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 操作证书密码
     */
    private String operationCertificatePassword = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * rsa 公钥
     */
    private String rsaPublicKey = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 是否为受理关系
     */
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

    public String getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(String rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public boolean isAcceptanceModel() {
        return acceptanceModel;
    }

    public void setAcceptanceModel(boolean acceptanceModel) {
        this.acceptanceModel = acceptanceModel;
    }

    public static class Builder {
        private final WeiXinPayAccount instance = new WeiXinPayAccount();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder mchId(String mchId) {
            instance.setMchId(mchId);
            return this;
        }

        public Builder apiSecretKey(String apiSecretKey) {
            instance.setApiSecretKey(apiSecretKey);
            return this;
        }

        public Builder subPublicAccountAppId(String subPublicAccountAppId) {
            instance.setSubPublicAccountAppId(subPublicAccountAppId);
            return this;
        }

        public Builder subOpenPlatformAppId(String subOpenPlatformAppId) {
            instance.setSubOpenPlatformAppId(subOpenPlatformAppId);
            return this;
        }

        public Builder subMiniProgramAppId(String subMiniProgramAppId) {
            instance.setSubMiniProgramAppId(subMiniProgramAppId);
            return this;
        }

        public Builder subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
            return this;
        }

        public Builder operationCertificate(String operationCertificate) {
            instance.setOperationCertificate(operationCertificate);
            return this;
        }

        public Builder operationCertificatePassword(String operationCertificatePassword) {
            instance.setOperationCertificatePassword(operationCertificatePassword);
            return this;
        }

        public Builder rsaPublicKey(String rsaPublicKey) {
            instance.setRsaPublicKey(rsaPublicKey);
            return this;
        }

        public Builder acceptanceModel(boolean acceptanceModel) {
            instance.setAcceptanceModel(acceptanceModel);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public WeiXinPayAccount build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
