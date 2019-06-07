package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

public class AsyncNotify extends BasicDomain {
    public static final String TABLE_NAME = "notify_record";
    /**
     * 唯一ID
     */
    private String uuid;
    /**
     * 消息队列主题
     */
    private String topic;
    /**
     * 支付宝公钥
     */
    private String alipayPublicKey = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 支付宝签名类型
     */
    private String alipaySignType = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 微信秘钥
     */
    private String weiXinPayApiSecretKey = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 微信签名类型
     */
    private String weiXinPaySignType = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 回调结果，1-未回调 2-回调成功，3-回调失败
     */
    private Integer notifyResult;
    /**
     * 回调内容
     */
    private String externalSystemNotifyRequestBody = Constants.VARCHAR_DEFAULT_VALUE;

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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public static class Builder extends BasicDomain.Builder<Builder, AsyncNotify> {
        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder topic(String topic) {
            instance.setTopic(topic);
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

        @Override
        public AsyncNotify build() {
            AsyncNotify asyncNotify = super.build();
            asyncNotify.setUuid(instance.getUuid());
            asyncNotify.setTopic(instance.getTopic());
            asyncNotify.setAlipayPublicKey(instance.getAlipayPublicKey());
            asyncNotify.setAlipaySignType(instance.getAlipaySignType());
            asyncNotify.setWeiXinPayApiSecretKey(instance.getWeiXinPayApiSecretKey());
            asyncNotify.setWeiXinPaySignType(instance.getWeiXinPaySignType());
            asyncNotify.setNotifyResult(instance.getNotifyResult());
            asyncNotify.setExternalSystemNotifyRequestBody(instance.getExternalSystemNotifyRequestBody());
            return asyncNotify;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String UUID = "uuid";
        public static final String TOPIC = "topic";
        public static final String ALIPAY_PUBLIC_KEY = "alipay_public_key";
        public static final String ALIPAY_SIGN_TYPE = "alipay_sign_type";
        public static final String WEI_XIN_PAY_API_SECRET_KEY = "wei_xin_pay_api_secret_key";
        public static final String WEI_XIN_PAY_SIGN_TYPE = "wei_xin_pay_sign_type";
        public static final String NOTIFY_RESULT = "notify_result";
        public static final String EXTERNAL_SYSTEM_NOTIFY_REQUEST_BODY = "external_system_notify_request_body";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String UUID = "uuid";
        public static final String TOPIC = "topic";
        public static final String ALIPAY_PUBLIC_KEY = "alipayPublicKey";
        public static final String ALIPAY_SIGN_TYPE = "alipaySignType";
        public static final String WEI_XIN_PAY_API_SECRET_KEY = "weiXinPayApiSecretKey";
        public static final String WEI_XIN_PAY_SIGN_TYPE = "weiXinPaySignType";
        public static final String NOTIFY_RESULT = "notifyResult";
        public static final String EXTERNAL_SYSTEM_NOTIFY_REQUEST_BODY = "externalSystemNotifyRequestBody";
    }
}
