package build.dream.common.models.alipay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.CustomDateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AlipayBasicModel extends BasicModel {
    /**
     * 支付宝分配给开发者的应用ID
     */
    @NotNull
    @JsonIgnore
    private String appId;

    @NotNull
    @InList(value = {Constants.JSON})
    @JsonIgnore
    private String format = Constants.JSON;

    @Length(max = 256)
    @JsonIgnore
    private String returnUrl;

    /**
     * 请求使用的编码格式
     */
    @NotNull
    @InList(value = {Constants.UTF_8})
    @JsonIgnore
    private String charset = Constants.UTF_8;

    /**
     * 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
     */
    @NotNull
    @InList(value = {Constants.RSA, Constants.RSA2})
    @JsonIgnore
    private String signType = Constants.RSA2;

    /**
     * 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
     */
    @NotNull
    @Length(min = 19, max = 19)
    @JsonIgnore
    private String timestamp = CustomDateUtils.format(new Date(), Constants.DEFAULT_DATE_PATTERN);

    /**
     * 调用的接口版本
     */
    @NotNull
    @Length(max = 3)
    @JsonIgnore
    private String version = Constants.ALIPAY_API_VERSION_1_0;

    @JsonIgnore
    private String topic;

    @Length(max = 40)
    @JsonIgnore
    private String appAuthToken;

    @JsonIgnore
    @Length(max = 40)
    private String authToken;

    @NotNull
    private String appPrivateKey;

    @NotNull
    private String alipayPublicKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public static class Builder<T extends Builder<T>> {
        private AlipayBasicModel instance;

        protected void setAlipayBasicModel(AlipayBasicModel alipayBasicModel) {
            this.instance = alipayBasicModel;
        }

        public T appId(String appId) {
            instance.setAppId(appId);
            return (T) this;
        }

        public T format(String format) {
            instance.setFormat(format);
            return (T) this;
        }

        public T returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return (T) this;
        }

        public T charset(String charset) {
            instance.setCharset(charset);
            return (T) this;
        }

        public T signType(String signType) {
            instance.setSignType(signType);
            return (T) this;
        }

        public T timestamp(String timestamp) {
            instance.setTimestamp(timestamp);
            return (T) this;
        }

        public T version(String version) {
            instance.setVersion(version);
            return (T) this;
        }

        public T topic(String topic) {
            instance.setTopic(topic);
            return (T) this;
        }

        public T appAuthToken(String appAuthToken) {
            instance.setAppAuthToken(appAuthToken);
            return (T) this;
        }

        public T authToken(String authToken) {
            instance.setAuthToken(authToken);
            return (T) this;
        }

        public T appPrivateKey(String appPrivateKey) {
            instance.setAppPrivateKey(appPrivateKey);
            return (T) this;
        }

        public T alipayPublicKey(String alipayPublicKey) {
            instance.setAlipayPublicKey(alipayPublicKey);
            return (T) this;
        }

        protected void build(AlipayBasicModel alipayBasicModel) {
            alipayBasicModel.setAppId(instance.getAppId());
            alipayBasicModel.setFormat(instance.getFormat());
            alipayBasicModel.setReturnUrl(instance.getReturnUrl());
            alipayBasicModel.setCharset(instance.getCharset());
            alipayBasicModel.setSignType(instance.getSignType());
            alipayBasicModel.setTimestamp(instance.getTimestamp());
            alipayBasicModel.setVersion(instance.getVersion());
            alipayBasicModel.setTopic(instance.getTopic());
            alipayBasicModel.setAppAuthToken(instance.getAppAuthToken());
            alipayBasicModel.setAuthToken(instance.getAuthToken());
            alipayBasicModel.setAppPrivateKey(instance.getAppPrivateKey());
            alipayBasicModel.setAlipayPublicKey(instance.getAlipayPublicKey());
        }
    }
}
