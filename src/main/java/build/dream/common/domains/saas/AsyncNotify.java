package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;
import build.dream.common.beans.MqConfig;
import build.dream.common.constants.Constants;

public class AsyncNotify extends BasicDomain {
    public static final String TABLE_NAME = "async_notify";
    /**
     * 唯一ID
     */
    private String uuid;
    /**
     * 消息队列主题
     */
    private MqConfig mqConfig;
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
    private String weiXinPayApiKey = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 微信签名类型
     */
    private String weiXinPaySignType = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 微信支付退款api_v3秘钥
     */
    private String weiXinPayApiV3Key = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 米雅key
     */
    private String miyaKey = Constants.VARCHAR_DEFAULT_VALUE;

    /**
     * 联动支付私钥
     */
    private String umPayPrivateKey = Constants.VARCHAR_DEFAULT_VALUE;

    /**
     * 联动支付平台证书
     */
    private String umPayPlatformCertificate = Constants.VARCHAR_DEFAULT_VALUE;
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

    public MqConfig getMqConfig() {
        return mqConfig;
    }

    public void setMqConfig(MqConfig mqConfig) {
        this.mqConfig = mqConfig;
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

    public String getWeiXinPayApiKey() {
        return weiXinPayApiKey;
    }

    public void setWeiXinPayApiKey(String weiXinPayApiKey) {
        this.weiXinPayApiKey = weiXinPayApiKey;
    }

    public String getWeiXinPaySignType() {
        return weiXinPaySignType;
    }

    public void setWeiXinPaySignType(String weiXinPaySignType) {
        this.weiXinPaySignType = weiXinPaySignType;
    }

    public String getWeiXinPayApiV3Key() {
        return weiXinPayApiV3Key;
    }

    public void setWeiXinPayApiV3Key(String weiXinPayApiV3Key) {
        this.weiXinPayApiV3Key = weiXinPayApiV3Key;
    }

    public String getMiyaKey() {
        return miyaKey;
    }

    public void setMiyaKey(String miyaKey) {
        this.miyaKey = miyaKey;
    }

    public String getUmPayPrivateKey() {
        return umPayPrivateKey;
    }

    public void setUmPayPrivateKey(String umPayPrivateKey) {
        this.umPayPrivateKey = umPayPrivateKey;
    }

    public String getUmPayPlatformCertificate() {
        return umPayPlatformCertificate;
    }

    public void setUmPayPlatformCertificate(String umPayPlatformCertificate) {
        this.umPayPlatformCertificate = umPayPlatformCertificate;
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

        public Builder mqConfig(MqConfig mqConfig) {
            instance.setMqConfig(mqConfig);
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

        public Builder weiXinPayApiKey(String weiXinPayApiKey) {
            instance.setWeiXinPayApiKey(weiXinPayApiKey);
            return this;
        }

        public Builder weiXinPaySignType(String weiXinPaySignType) {
            instance.setWeiXinPaySignType(weiXinPaySignType);
            return this;
        }

        public Builder weiXinPayApiV3Key(String weiXinPayApiV3Key) {
            instance.setWeiXinPayApiV3Key(weiXinPayApiV3Key);
            return this;
        }

        public Builder miyaKey(String miyaKey) {
            instance.setMiyaKey(miyaKey);
            return this;
        }

        public Builder umPayPrivateKey(String umPayPrivateKey) {
            instance.setUmPayPrivateKey(umPayPrivateKey);
            return this;
        }

        public Builder umPayPlatformCertificate(String umPayPlatformCertificate) {
            instance.setUmPayPlatformCertificate(umPayPlatformCertificate);
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
            asyncNotify.setMqConfig(instance.getMqConfig());
            asyncNotify.setAlipayPublicKey(instance.getAlipayPublicKey());
            asyncNotify.setAlipaySignType(instance.getAlipaySignType());
            asyncNotify.setWeiXinPayApiKey(instance.getWeiXinPayApiKey());
            asyncNotify.setWeiXinPaySignType(instance.getWeiXinPaySignType());
            asyncNotify.setWeiXinPayApiV3Key(instance.getWeiXinPayApiV3Key());
            asyncNotify.setMiyaKey(instance.getMiyaKey());
            asyncNotify.setUmPayPrivateKey(instance.getUmPayPrivateKey());
            asyncNotify.setUmPayPlatformCertificate(instance.getUmPayPlatformCertificate());
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
        public static final String WEI_XIN_PAY_API_KEY = "wei_xin_pay_api_key";
        public static final String WEI_XIN_PAY_SIGN_TYPE = "wei_xin_pay_sign_type";
        public static final String WEI_XIN_PAY_API_V3_KEY = "wei_xin_pay_api_v3_key";
        public static final String MIYA_KEY = "miya_key";
        public static final String UM_PAY_PRIVATE_KEY = "um_pay_private_key";
        public static final String UM_PAY_PLATFORM_CERTIFICATE = "um_pay_platform_certificate";
        public static final String NOTIFY_RESULT = "notify_result";
        public static final String EXTERNAL_SYSTEM_NOTIFY_REQUEST_BODY = "external_system_notify_request_body";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String UUID = "uuid";
        public static final String TOPIC = "topic";
        public static final String ALIPAY_PUBLIC_KEY = "alipayPublicKey";
        public static final String ALIPAY_SIGN_TYPE = "alipaySignType";
        public static final String WEI_XIN_PAY_API_KEY = "weiXinPayApiKey";
        public static final String WEI_XIN_PAY_SIGN_TYPE = "weiXinPaySignType";
        public static final String WEI_XIN_PAY_API_V3_KEY = "weiXinPayApiV3Key";
        public static final String MIYA_KEY = "miyaKey";
        public static final String UM_PAY_PRIVATE_KEY = "umPayPrivateKey";
        public static final String UM_PAY_PLATFORM_CERTIFICATE = "umPayPlatformCertificate";
        public static final String NOTIFY_RESULT = "notifyResult";
        public static final String EXTERNAL_SYSTEM_NOTIFY_REQUEST_BODY = "externalSystemNotifyRequestBody";
    }
}
