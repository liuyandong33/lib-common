package build.dream.common.models.alipay;

public class BuildRequestBodyModel {
    private String appId;
    private String method;
    private String format;
    private String returnUrl;
    private String charset;
    private String signType;
    private String notifyUrl;
    private String appAuthToken;
    private String bizContent;
    private String privateKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public static class Builder {
        private final BuildRequestBodyModel instance = new BuildRequestBodyModel();

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder method(String method) {
            instance.setMethod(method);
            return this;
        }

        public Builder format(String format) {
            instance.setFormat(format);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder charset(String charset) {
            instance.setCharset(charset);
            return this;
        }

        public Builder signType(String signType) {
            instance.setSignType(signType);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder appAuthToken(String appAuthToken) {
            instance.setAppAuthToken(appAuthToken);
            return this;
        }

        public Builder bizContent(String bizContent) {
            instance.setBizContent(bizContent);
            return this;
        }

        public Builder privateKey(String privateKey) {
            instance.setPrivateKey(privateKey);
            return this;
        }

        public BuildRequestBodyModel build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
