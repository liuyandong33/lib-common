package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.okhttp.DoGetWithRequestParametersModel;
import build.dream.common.models.okhttp.DoPostWithRequestParametersModel;
import okhttp3.*;
import org.apache.commons.collections.MapUtils;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OkHttpUtils {
    public static WebResponse doGetWithRequestParameters(DoGetWithRequestParametersModel doGetWithRequestParametersModel) throws IOException {
        String requestUrl = doGetWithRequestParametersModel.getRequestUrl();
        int readTimeout = doGetWithRequestParametersModel.getReadTimeout();
        int connectTimeout = doGetWithRequestParametersModel.getConnectTimeout();
        Map<String, String> requestHeaders = doGetWithRequestParametersModel.getRequestHeaders();
        Map<String, String> requestParameters = doGetWithRequestParametersModel.getRequestParameters();
        String charsetName = doGetWithRequestParametersModel.getCharsetName();
        Proxy proxy = doGetWithRequestParametersModel.getProxy();
        return doGetWithRequestParameters(requestUrl, readTimeout, connectTimeout, requestHeaders, requestParameters, charsetName, proxy);
    }

    public static WebResponse doGetWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, 0, 0, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doGetWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetWithRequestParameters(requestUrl, 0, 0, null, requestParameters, charsetName, null);
    }

    public static WebResponse doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName, null);
    }

    public static WebResponse doGetWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doGetWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, charsetName, null);
    }

    public static WebResponse doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestHeaders, Map<String, String> requestParameters, String charsetName, Proxy proxy) throws IOException {
        if (MapUtils.isNotEmpty(requestHeaders)) {
            requestUrl += WebUtils.buildQueryString(requestParameters);
        }
        Request.Builder builder = new Request.Builder().url(requestUrl);
        if (MapUtils.isEmpty(requestHeaders)) {
            requestHeaders = new HashMap<String, String>();
            requestHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=" + charsetName);
        }
        builder.headers(Headers.of(requestHeaders));
        Request request = builder.build();

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS);
        if (proxy != null) {
            okHttpClientBuilder.proxy(proxy);
        }

        OkHttpClient okHttpClient = okHttpClientBuilder.build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();

        int responseCode = response.code();
        if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
            response.close();
            return doGetWithRequestParameters(requestUrl, readTimeout, connectTimeout, requestHeaders, requestParameters, charsetName, proxy);
        } else {
            WebResponse webResponse = buildWebResponse(response);
            response.close();
            return webResponse;
        }
    }

    public static WebResponse doPostWithRequestParameters(DoPostWithRequestParametersModel doPostWithRequestParametersModel) throws IOException {
        String requestUrl = doPostWithRequestParametersModel.getRequestUrl();
        int readTimeout = doPostWithRequestParametersModel.getReadTimeout();
        int connectTimeout = doPostWithRequestParametersModel.getConnectTimeout();
        Map<String, String> requestHeaders = doPostWithRequestParametersModel.getRequestHeaders();
        Map<String, String> requestParameters = doPostWithRequestParametersModel.getRequestParameters();
        String charsetName = doPostWithRequestParametersModel.getCharsetName();
        SSLSocketFactory sslSocketFactory = doPostWithRequestParametersModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostWithRequestParametersModel.getX509TrustManager();
        Proxy proxy = doPostWithRequestParametersModel.getProxy();
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, requestHeaders, requestParameters, charsetName, sslSocketFactory, x509TrustManager, proxy);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null, null, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithRequestParameters(requestUrl, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, x509TrustManager);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithRequestParameters(requestUrl, null, requestParameters, charsetName, sslSocketFactory, x509TrustManager);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, x509TrustManager, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName, sslSocketFactory, x509TrustManager, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, x509TrustManager, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, charsetName, sslSocketFactory, x509TrustManager, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestHeaders, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        Request.Builder builder = new Request.Builder().url(requestUrl);
        if (MapUtils.isEmpty(requestHeaders)) {
            requestHeaders = new HashMap<String, String>();
            requestHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=" + charsetName);
        }
        builder.headers(Headers.of(requestHeaders));
        builder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=" + charsetName), WebUtils.buildRequestBody(requestParameters)));
        Request request = builder.build();

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS);
        if (proxy != null) {
            okHttpClientBuilder.proxy(proxy);
        }
        okHttpClientBuilder.sslSocketFactory(sslSocketFactory, x509TrustManager);
        OkHttpClient okHttpClient = okHttpClientBuilder.build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();

        int responseCode = response.code();
        if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
            response.close();
            return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, requestHeaders, requestParameters, charsetName, sslSocketFactory, x509TrustManager, proxy);
        } else {
            WebResponse webResponse = buildWebResponse(response);
            response.close();
            return webResponse;
        }
    }

    private static WebResponse buildWebResponse(Response response) throws IOException {
        String result = response.body().string();
        Headers headers = response.headers();
        Set<String> names = headers.names();
        int responseCode = response.code();
        Map<String, List<String>> headerMap = new HashMap<String, List<String>>();
        for (String name : names) {
            headerMap.put(name, headers.values(name));
        }
        return new WebResponse(result, headerMap, responseCode);
    }
}
