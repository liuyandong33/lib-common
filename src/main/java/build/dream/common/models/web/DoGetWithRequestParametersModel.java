package build.dream.common.models.web;

import build.dream.common.constants.Constants;

import java.net.Proxy;
import java.util.Map;

public class DoGetWithRequestParametersModel {
    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 读取超时时间
     */
    private int readTimeout;

    /**
     * 建立连接超时时间
     */
    private int connectTimeout;

    /**
     * 请求头
     */
    private Map<String, String> headers;

    /**
     * 请求参数
     */
    private Map<String, String> requestParameters;

    /**
     * 字符集
     */
    private String charsetName = Constants.CHARSET_NAME_UTF_8;

    /**
     * 代理
     */
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

        public DoGetWithRequestParametersModel build() {
            DoGetWithRequestParametersModel doGetWithRequestParametersModel = new DoGetWithRequestParametersModel();
            doGetWithRequestParametersModel.setRequestUrl(instance.getRequestUrl());
            doGetWithRequestParametersModel.setReadTimeout(instance.getReadTimeout());
            doGetWithRequestParametersModel.setConnectTimeout(instance.getConnectTimeout());
            doGetWithRequestParametersModel.setHeaders(instance.getHeaders());
            doGetWithRequestParametersModel.setRequestParameters(instance.getRequestParameters());
            doGetWithRequestParametersModel.setCharsetName(instance.getCharsetName());
            doGetWithRequestParametersModel.setProxy(instance.getProxy());
            return doGetWithRequestParametersModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
