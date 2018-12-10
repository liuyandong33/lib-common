package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class NotifyRecord extends BasicDomain {
    private String uuid;
    private String notifyUrl;
    private String alipayPublicKey = Constants.VARCHAR_DEFAULT_VALUE;
    private String alipaySignType = Constants.VARCHAR_DEFAULT_VALUE;
    private String weiXinPayApiSecretKey = Constants.VARCHAR_DEFAULT_VALUE;
    private String weiXinPaySignType = Constants.VARCHAR_DEFAULT_VALUE;
    private Integer notifyResult;
    private String externalSystemNotifyRequestBody;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getAlipaySignType() {
        return alipaySignType;
    }

    public void setAlipaySignType(String alipaySignType) {
        this.alipaySignType = alipaySignType;
    }

    public String getWeiXinPayApiSecretKey() {
        return weiXinPayApiSecretKey;
    }

    public void setWeiXinPayApiSecretKey(String weiXinPayApiSecretKey) {
        this.weiXinPayApiSecretKey = weiXinPayApiSecretKey;
    }

    public String getWeiXinPaySignType() {
        return weiXinPaySignType;
    }

    public void setWeiXinPaySignType(String weiXinPaySignType) {
        this.weiXinPaySignType = weiXinPaySignType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Integer getNotifyResult() {
        return notifyResult;
    }

    public void setNotifyResult(Integer notifyResult) {
        this.notifyResult = notifyResult;
    }

    public String getExternalSystemNotifyRequestBody() {
        return externalSystemNotifyRequestBody;
    }

    public void setExternalSystemNotifyRequestBody(String externalSystemNotifyRequestBody) {
        this.externalSystemNotifyRequestBody = externalSystemNotifyRequestBody;
    }

    public static class Builder {
        private final NotifyRecord instance = new NotifyRecord();

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder alipayPublicKey(String alipayPublicKey) {
            instance.setAlipayPublicKey(alipayPublicKey);
            return this;
        }

        public Builder alipaySignType(String alipaySignType) {
            instance.setAlipaySignType(alipaySignType);
            return this;
        }

        public Builder weiXinPayApiSecretKey(String weiXinPayApiSecretKey) {
            instance.setWeiXinPayApiSecretKey(weiXinPayApiSecretKey);
            return this;
        }

        public Builder weiXinPaySignType(String weiXinPaySignType) {
            instance.setWeiXinPaySignType(weiXinPaySignType);
            return this;
        }

        public Builder notifyResult(Integer notifyResult) {
            instance.setNotifyResult(notifyResult);
            return this;
        }

        public Builder externalSystemNotifyRequestBody(String externalSystemNotifyRequestBody) {
            instance.setExternalSystemNotifyRequestBody(externalSystemNotifyRequestBody);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public NotifyRecord build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String UUID = "uuid";
        public static final String NOTIFY_URL = "notify_url";
        public static final String ALIPAY_PUBLIC_KEY = "alipay_public_key";
        public static final String ALIPAY_SIGN_TYPE = "alipay_sign_type";
        public static final String WEI_XIN_PAY_API_SECRET_KEY = "wei_xin_pay_api_secret_key";
        public static final String WEI_XIN_PAY_SIGN_TYPE = "wei_xin_pay_sign_type";
        public static final String NOTIFY_RESULT = "notify_result";
        public static final String EXTERNAL_SYSTEM_NOTIFY_REQUEST_BODY = "external_system_notify_request_body";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String UUID = "uuid";
        public static final String NOTIFY_URL = "notifyUrl";
        public static final String ALIPAY_PUBLIC_KEY = "alipayPublicKey";
        public static final String ALIPAY_SIGN_TYPE = "alipaySignType";
        public static final String WEI_XIN_PAY_API_SECRET_KEY = "weiXinPayApiSecretKey";
        public static final String WEI_XIN_PAY_SIGN_TYPE = "weiXinPaySignType";
        public static final String NOTIFY_RESULT = "notifyResult";
        public static final String EXTERNAL_SYSTEM_NOTIFY_REQUEST_BODY = "externalSystemNotifyRequestBody";
    }
}
