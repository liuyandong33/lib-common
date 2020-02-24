package build.dream.common.models.newweb;

import javax.net.ssl.SSLSocketFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.Map;

public class PostModel {
    private String requestUrl;
    private int readTimeout;
    private int connectTimeout;
    private Map<String, String> headers;
    private InputStream requestBody;
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

    public InputStream getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(InputStream requestBody) {
        this.requestBody = requestBody;
    }

    public void setRequestBody(String requestBody, Charset charset) {
        this.requestBody = new ByteArrayInputStream(requestBody.getBytes(charset));
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
        private final PostModel instance = new PostModel();

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

        public Builder requestBody(InputStream requestBody) {
            instance.setRequestBody(requestBody);
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

        public PostModel build() {
            PostModel postModel = new PostModel();
            postModel.setRequestUrl(instance.getRequestUrl());
            postModel.setReadTimeout(instance.getReadTimeout());
            postModel.setConnectTimeout(instance.getConnectTimeout());
            postModel.setHeaders(instance.getHeaders());
            postModel.setRequestBody(instance.getRequestBody());
            postModel.setSslSocketFactory(instance.getSslSocketFactory());
            postModel.setProxy(instance.getProxy());
            return postModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
