package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddSubDevConfigModel extends BasicModel {
    @NotNull
    @Length(max = 32)
    private String appId;

    @NotNull
    @Length(max = 32)
    private String mchId;

    @Length(max = 32)
    private String subMchId;

    @Length(max = 256)
    private String jsApiPath;

    @Length(max = 32)
    private String subAppId;
    /**
     * api 秘钥
     */
    @NotNull
    private String apiKey;

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

    public String getJsApiPath() {
        return jsApiPath;
    }

    public void setJsApiPath(String jsApiPath) {
        this.jsApiPath = jsApiPath;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
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

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(jsApiPath) || StringUtils.isNotBlank(subAppId));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(jsApiPath) || StringUtils.isNotBlank(subAppId), "jsApiPath和subAppId不能同时为空！");
    }

    public static class Builder {
        private final AddSubDevConfigModel instance = new AddSubDevConfigModel();

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

        public Builder jsApiPath(String jsApiPath) {
            instance.setJsApiPath(jsApiPath);
            return this;
        }

        public Builder subAppId(String subAppId) {
            instance.setSubAppId(subAppId);
            return this;
        }

        public Builder apiKey(String apiKey) {
            instance.setApiKey(apiKey);
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

        public AddSubDevConfigModel build() {
            AddSubDevConfigModel addSubDevConfigModel = new AddSubDevConfigModel();
            addSubDevConfigModel.setAppId(instance.getAppId());
            addSubDevConfigModel.setMchId(instance.getMchId());
            addSubDevConfigModel.setSubMchId(instance.getSubMchId());
            addSubDevConfigModel.setJsApiPath(instance.getJsApiPath());
            addSubDevConfigModel.setSubAppId(instance.getSubAppId());
            addSubDevConfigModel.setApiKey(instance.getApiKey());
            addSubDevConfigModel.setOperationCertificate(instance.getOperationCertificate());
            addSubDevConfigModel.setOperationCertificatePassword(instance.getOperationCertificatePassword());
            return addSubDevConfigModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
