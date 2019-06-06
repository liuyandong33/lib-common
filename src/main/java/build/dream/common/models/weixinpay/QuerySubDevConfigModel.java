package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class QuerySubDevConfigModel extends BasicModel {
    @NotNull
    @Length(max = 32)
    private String appId;

    @NotNull
    @Length(max = 32)
    private String mchId;

    @NotNull
    @Length(max = 32)
    private String subMchId;

    /**
     * api 秘钥
     */
    @NotNull
    private String apiSecretKey;

    @NotNull
    private String operationCertificate;
    /**
     * 操作证书密码
     */
    @NotNull
    private String operationCertificatePassword;

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

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getApiSecretKey() {
        return apiSecretKey;
    }

    public void setApiSecretKey(String apiSecretKey) {
        this.apiSecretKey = apiSecretKey;
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

    public static class Builder {
        private final QuerySubDevConfigModel instance = new QuerySubDevConfigModel();

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder mchId(String mchId) {
            instance.setMchId(mchId);
            return this;
        }

        public Builder subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
            return this;
        }

        public Builder apiSecretKey(String apiSecretKey) {
            instance.setApiSecretKey(apiSecretKey);
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

        public QuerySubDevConfigModel build() {
            QuerySubDevConfigModel querySubDevConfigModel = new QuerySubDevConfigModel();
            querySubDevConfigModel.setAppId(instance.getAppId());
            querySubDevConfigModel.setMchId(instance.getMchId());
            querySubDevConfigModel.setSubMchId(instance.getSubMchId());
            querySubDevConfigModel.setApiSecretKey(instance.getApiSecretKey());
            querySubDevConfigModel.setOperationCertificate(instance.getOperationCertificate());
            querySubDevConfigModel.setOperationCertificatePassword(instance.getOperationCertificatePassword());
            return querySubDevConfigModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
