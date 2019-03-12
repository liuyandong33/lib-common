package build.dream.common.models.web;

import build.dream.common.constants.Constants;

import javax.net.ssl.SSLSocketFactory;
import java.net.Proxy;
import java.util.Map;

public class DoPostWithRequestBodyModel {
    private String requestUrl;
    private int readTimeout;
    private int connectTimeout;
    private Map<String, String> headers;
    private String requestBody;
    private String charsetName = Constants.CHARSET_NAME_UTF_8;
    private SSLSocketFactory sslSocketFactory;
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

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getCharsetName() {
        return charsetName;
    }

    public void setCharsetName(String charsetName) {
        this.charsetName = charsetName;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return sslSocketFactory;
    }

    public void setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public static class Builder {
        private final DoPostWithRequestBodyModel instance = new DoPostWithRequestBodyModel();

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

        public Builder headers(Map<String, String> headers) {
            instance.setHeaders(headers);
            return this;
        }

        public Builder requestBody(String requestBody) {
            instance.setRequestBody(requestBody);
            return this;
        }

        public Builder charsetName(String charsetName) {
            instance.setCharsetName(charsetName);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sslSocketFactory) {
            instance.setSslSocketFactory(sslSocketFactory);
            return this;
        }

        public Builder proxy(Proxy proxy) {
            instance.setProxy(proxy);
            return this;
        }

        public DoPostWithRequestBodyModel build() {
            DoPostWithRequestBodyModel doPostWithRequestBodyModel = new DoPostWithRequestBodyModel();
            doPostWithRequestBodyModel.setRequestUrl(instance.getRequestUrl());
            doPostWithRequestBodyModel.setReadTimeout(instance.getReadTimeout());
            doPostWithRequestBodyModel.setConnectTimeout(instance.getConnectTimeout());
            doPostWithRequestBodyModel.setHeaders(instance.getHeaders());
            doPostWithRequestBodyModel.setRequestBody(instance.getRequestBody());
            doPostWithRequestBodyModel.setCharsetName(instance.getCharsetName());
            doPostWithRequestBodyModel.setSslSocketFactory(instance.getSslSocketFactory());
            doPostWithRequestBodyModel.setProxy(instance.getProxy());
            return doPostWithRequestBodyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
