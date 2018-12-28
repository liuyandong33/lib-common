package build.dream.common.models.okhttp;

import build.dream.common.constants.Constants;

import java.net.Proxy;
import java.util.Map;

public class DoGetWithRequestParametersModel {
    private String requestUrl;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    private Map<String, String> requestHeaders;
    private Map<String, String> requestParameters;
    private String charsetName = Constants.CHARSET_NAME_UTF_8;
    private Proxy proxy;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public Map<String, String> getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(Map<String, String> requestParameters) {
        this.requestParameters = requestParameters;
    }

    public String getCharsetName() {
        return charsetName;
    }

    public void setCharsetName(String charsetName) {
        this.charsetName = charsetName;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public static class Builder {
        private final DoGetWithRequestParametersModel instance = new DoGetWithRequestParametersModel();

        public Builder requestUrl(String requestUrl) {
            instance.setRequestUrl(requestUrl);
            return this;
        }

        public Builder readTimeout(int readTimeout) {
            instance.setReadTimeout(readTimeout);
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {
            instance.setConnectTimeout(connectTimeout);
            return this;
        }

        public Builder requestHeaders(Map<String, String> requestHeaders) {
            instance.setRequestHeaders(requestHeaders);
            return this;
        }

        public Builder requestParameters(Map<String, String> requestParameters) {
            instance.setRequestParameters(requestParameters);
            return this;
        }

        public Builder charsetName(String charsetName) {
            instance.setCharsetName(charsetName);
            return this;
        }

        public Builder proxy(Proxy proxy) {
            instance.setProxy(proxy);
            return this;
        }

        public DoGetWithRequestParametersModel build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
