package build.dream.common.models.web;

import java.net.Proxy;
import java.util.Map;

public class DoGetOrdinaryWithRequestParametersModel {
    private String requestUrl;
    private int readTimeout;
    private int connectTimeout;
    private Map<String, String> headers;
    private Map<String, String> requestParameters;
    private String charsetName;
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
        private final DoGetOrdinaryWithRequestParametersModel instance = new DoGetOrdinaryWithRequestParametersModel();

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

        public DoGetOrdinaryWithRequestParametersModel build() {
            DoGetOrdinaryWithRequestParametersModel doGetOrdinaryWithRequestParametersModel = new DoGetOrdinaryWithRequestParametersModel();
            doGetOrdinaryWithRequestParametersModel.setRequestUrl(instance.getRequestUrl());
            doGetOrdinaryWithRequestParametersModel.setReadTimeout(instance.getReadTimeout());
            doGetOrdinaryWithRequestParametersModel.setConnectTimeout(instance.getConnectTimeout());
            doGetOrdinaryWithRequestParametersModel.setHeaders(instance.getHeaders());
            doGetOrdinaryWithRequestParametersModel.setRequestParameters(instance.getRequestParameters());
            doGetOrdinaryWithRequestParametersModel.setCharsetName(instance.getCharsetName());
            doGetOrdinaryWithRequestParametersModel.setProxy(instance.getProxy());
            return doGetOrdinaryWithRequestParametersModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
