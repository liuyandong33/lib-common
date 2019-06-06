package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddRecommendConfModel extends BasicModel {
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

    @NotNull
    @Length(max = 32)
    private String mchId;

    @NotNull
    @Length(max = 32)
    private String subMchId;

    @NotNull
    @Length(max = 32)
    private String subAppId;

    @Length(max = 32)
    private String subscribeAppId;

    @Length(max = 32)
    private String receiptAppId;

    @NotNull
    @InList(value = {Constants.MD5, Constants.HMAC_SHA256})
    private String signType = Constants.MD5;

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

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubscribeAppId() {
        return subscribeAppId;
    }

    public void setSubscribeAppId(String subscribeAppId) {
        this.subscribeAppId = subscribeAppId;
    }

    public String getReceiptAppId() {
        return receiptAppId;
    }

    public void setReceiptAppId(String receiptAppId) {
        this.receiptAppId = receiptAppId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(subscribeAppId) || StringUtils.isNotBlank(receiptAppId));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(subscribeAppId) || StringUtils.isNotBlank(receiptAppId), "参数subscribeAppId和subscribeAppId不能同时为空！");
    }

    public static class Builder {
        private final AddRecommendConfModel instance = new AddRecommendConfModel();

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

        public Builder mchId(String mchId) {
            instance.setMchId(mchId);
            return this;
        }

        public Builder subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
            return this;
        }

        public Builder subAppId(String subAppId) {
            instance.setSubAppId(subAppId);
            return this;
        }

        public Builder subscribeAppId(String subscribeAppId) {
            instance.setSubscribeAppId(subscribeAppId);
            return this;
        }

        public Builder receiptAppId(String receiptAppId) {
            instance.setReceiptAppId(receiptAppId);
            return this;
        }

        public Builder signType(String signType) {
            instance.setSignType(signType);
            return this;
        }

        public AddRecommendConfModel build() {
            AddRecommendConfModel addRecommendConfModel = new AddRecommendConfModel();
            addRecommendConfModel.setApiSecretKey(instance.getApiSecretKey());
            addRecommendConfModel.setOperationCertificate(instance.getOperationCertificate());
            addRecommendConfModel.setOperationCertificatePassword(instance.getOperationCertificatePassword());
            addRecommendConfModel.setMchId(instance.getMchId());
            addRecommendConfModel.setSubMchId(instance.getSubMchId());
            addRecommendConfModel.setSubAppId(instance.getSubAppId());
            addRecommendConfModel.setSubscribeAppId(instance.getSubscribeAppId());
            addRecommendConfModel.setReceiptAppId(instance.getReceiptAppId());
            addRecommendConfModel.setSignType(instance.getSignType());
            return addRecommendConfModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}