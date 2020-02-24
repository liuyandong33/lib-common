package build.dream.common.models.okhttp;

import java.net.Proxy;
import java.util.Map;

public class DoGetModel {
    /**
     * 请求地址
     */
    private String url;

    /**
     * 请求参数
     */
    private Map<String, String> queryParams;

    /**
     * 请求头
     */
    private Map<String, String> headers;

    /**
     * 建立连接超时时间
     */
    private int connectTimeout;

    /**
     * 读取超时时间
     */
    private int readTimeout;

    /**
     * 代理
     */
    private Proxy proxy;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public static class Builder {
        private final DoGetModel instance = new DoGetModel();

        public Builder url(String url) {
            instance.setUrl(url);
            return this;
        }

        public Builder queryParams(Map<String, String> queryParams) {
            instance.setQueryParams(queryParams);
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            instance.setHeaders(headers);
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {
            instance.setConnectTimeout(connectTimeout);
            return this;
        }

        public Builder readTimeout(int readTimeout) {
            instance.setReadTimeout(readTimeout);
            return this;
        }

        public Builder proxy(Proxy proxy) {
            instance.setProxy(proxy);
            return this;
        }

        public DoGetModel build() {
            DoGetModel doGetModel = new DoGetModel();
            doGetModel.setUrl(instance.getUrl());
            doGetModel.setQueryParams(instance.getQueryParams());
            doGetModel.setHeaders(instance.getHeaders());
            doGetModel.setConnectTimeout(instance.getConnectTimeout());
            doGetModel.setReadTimeout(instance.getReadTimeout());
            doGetModel.setProxy(instance.getProxy());
            return doGetModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
