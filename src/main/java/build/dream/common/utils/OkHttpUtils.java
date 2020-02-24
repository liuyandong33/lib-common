package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.okhttp.*;
import build.dream.common.okhttp.FormBody;
import build.dream.common.okhttp.InputStreamRequestBody;
import build.dream.common.okhttp.MultipartBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections.MapUtils;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OkHttpUtils {
    public static String doPostWithMultipartForm(DoPostWithMultipartFormModel doPostWithMultipartFormModel) throws IOException {
        String url = doPostWithMultipartFormModel.getUrl();
        Map<String, Object> parts = doPostWithMultipartFormModel.getParts();
        Map<String, String> headers = doPostWithMultipartFormModel.getHeaders();
        String charsetName = doPostWithMultipartFormModel.getCharsetName();
        int connectTimeout = doPostWithMultipartFormModel.getConnectTimeout();
        int readTimeout = doPostWithMultipartFormModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostWithMultipartFormModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostWithMultipartFormModel.getX509TrustManager();
        Proxy proxy = doPostWithMultipartFormModel.getProxy();
        return doPostWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts) throws IOException {
        return doPostWithMultipartForm(url, parts, null, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers) throws IOException {
        return doPostWithMultipartForm(url, parts, headers, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName) throws IOException {
        return doPostWithMultipartForm(url, parts, headers, charsetName, 0, 0, null, null, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout) throws IOException {
        return doPostWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, null, null, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        return obtainResult(doPostNativeWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy));
    }

    public static Response doPostNativeWithMultipartForm(DoPostNativeWithMultipartFormModel doPostNativeWithMultipartFormModel) throws IOException {
        String url = doPostNativeWithMultipartFormModel.getUrl();
        Map<String, Object> parts = doPostNativeWithMultipartFormModel.getParts();
        Map<String, String> headers = doPostNativeWithMultipartFormModel.getHeaders();
        String charsetName = doPostNativeWithMultipartFormModel.getCharsetName();
        int connectTimeout = doPostNativeWithMultipartFormModel.getConnectTimeout();
        int readTimeout = doPostNativeWithMultipartFormModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostNativeWithMultipartFormModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostNativeWithMultipartFormModel.getX509TrustManager();
        Proxy proxy = doPostNativeWithMultipartFormModel.getProxy();

        return doPostNativeWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts) throws IOException {
        return doPostNativeWithMultipartForm(url, parts, null, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers) throws IOException {
        return doPostNativeWithMultipartForm(url, parts, headers, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName) throws IOException {
        return doPostNativeWithMultipartForm(url, parts, headers, charsetName, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout) throws IOException {
        return doPostNativeWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, null, null, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostNativeWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        MultipartBody multipartBody = new MultipartBody(parts, charsetName);
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.post(multipartBody);
        requestBuilder.url(url);
        if (MapUtils.isNotEmpty(headers)) {
            requestBuilder.headers(Headers.of(headers));
        }
        return buildOkHttpClient(connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy).newCall(requestBuilder.build()).execute();
    }

    public static String doPostWithRequestBody(DoPostWithRequestBodyModel doPostWithRequestBodyModel) throws IOException {
        String url = doPostWithRequestBodyModel.getUrl();
        InputStream body = doPostWithRequestBodyModel.getBody();
        String contentType = doPostWithRequestBodyModel.getContentType();
        Map<String, String> headers = doPostWithRequestBodyModel.getHeaders();
        int connectTimeout = doPostWithRequestBodyModel.getConnectTimeout();
        int readTimeout = doPostWithRequestBodyModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostWithRequestBodyModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostWithRequestBodyModel.getX509TrustManager();
        Proxy proxy = doPostWithRequestBodyModel.getProxy();
        return doPostWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType) throws IOException {
        return doPostWithRequestBody(url, body, charsetName, contentType, null, 0, 0, null, null, null);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers) throws IOException {
        return doPostWithRequestBody(url, body, charsetName, contentType, headers, 0, 0, null, null, null);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout) throws IOException {
        return doPostWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, null, null, null);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, null);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        return obtainResult(doPostNativeWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy));
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType) throws IOException {
        return doPostWithRequestBody(url, body, contentType, null, 0, 0, null, null, null);
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers) throws IOException {
        return doPostWithRequestBody(url, body, contentType, headers, 0, 0, null, null, null);
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout) throws IOException {
        return doPostWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, null, null, null);
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, null);
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        return obtainResult(doPostNativeWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy));
    }

    public static Response doPostNativeWithRequestBody(DoPostNativeWithRequestBodyModel doPostNativeWithRequestBodyModel) throws IOException {
        String url = doPostNativeWithRequestBodyModel.getUrl();
        InputStream body = doPostNativeWithRequestBodyModel.getBody();
        String contentType = doPostNativeWithRequestBodyModel.getContentType();
        Map<String, String> headers = doPostNativeWithRequestBodyModel.getHeaders();
        int connectTimeout = doPostNativeWithRequestBodyModel.getConnectTimeout();
        int readTimeout = doPostNativeWithRequestBodyModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostNativeWithRequestBodyModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostNativeWithRequestBodyModel.getX509TrustManager();
        Proxy proxy = doPostNativeWithRequestBodyModel.getProxy();
        return doPostNativeWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType) throws IOException {
        return doPostNativeWithRequestBody(url, body, charsetName, contentType, null, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers) throws IOException {
        return doPostNativeWithRequestBody(url, body, charsetName, contentType, headers, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout) throws IOException {
        return doPostNativeWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, null, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostNativeWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, null);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(body.getBytes(charsetName));
        Response response = doPostNativeWithRequestBody(url, inputStream, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy);
        inputStream.close();
        return response;
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType) throws IOException {
        return doPostNativeWithRequestBody(url, body, contentType, null, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers) throws IOException {
        return doPostNativeWithRequestBody(url, body, contentType, headers, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout) throws IOException {
        return doPostNativeWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, null, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostNativeWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, null);
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        InputStreamRequestBody inputStreamRequestBody = new InputStreamRequestBody(body, contentType);
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.post(inputStreamRequestBody);
        requestBuilder.url(url);
        if (MapUtils.isNotEmpty(headers)) {
            requestBuilder.headers(Headers.of(headers));
        }
        return buildOkHttpClient(connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy).newCall(requestBuilder.build()).execute();
    }

    private static OkHttpClient buildOkHttpClient(int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(connectTimeout, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(readTimeout, TimeUnit.SECONDS);
        if (Objects.nonNull(sslSocketFactory)) {
            okHttpClientBuilder.sslSocketFactory(sslSocketFactory, x509TrustManager);
        }
        if (Objects.nonNull(proxy)) {
            okHttpClientBuilder.proxy(proxy);
        }
        return okHttpClientBuilder.build();
    }

    public static String doPostWithForm(DoPostWithFormModel doPostWithFormModel) throws IOException {
        String url = doPostWithFormModel.getUrl();
        Map<String, String> requestParameters = doPostWithFormModel.getRequestParameters();
        Map<String, String> headers = doPostWithFormModel.getHeaders();
        String charsetName = doPostWithFormModel.getCharsetName();
        int connectTimeout = doPostWithFormModel.getConnectTimeout();
        int readTimeout = doPostWithFormModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostWithFormModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostWithFormModel.getX509TrustManager();
        Proxy proxy = doPostWithFormModel.getProxy();
        return doPostWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters) throws IOException {
        return doPostWithForm(url, requestParameters, null, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers) throws IOException {
        return doPostWithForm(url, requestParameters, headers, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName) throws IOException {
        return doPostWithForm(url, requestParameters, headers, charsetName, 0, 0, null, null, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout) throws IOException {
        return doPostWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, null, null, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        return obtainResult(doPostNativeWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy));
    }

    public static Response doPostNativeWithForm(DoPostNativeWithFormModel doPostNativeWithFormModel) throws IOException {
        String url = doPostNativeWithFormModel.getUrl();
        Map<String, String> requestParameters = doPostNativeWithFormModel.getRequestParameters();
        Map<String, String> headers = doPostNativeWithFormModel.getHeaders();
        String charsetName = doPostNativeWithFormModel.getCharsetName();
        int connectTimeout = doPostNativeWithFormModel.getConnectTimeout();
        int readTimeout = doPostNativeWithFormModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostNativeWithFormModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostNativeWithFormModel.getX509TrustManager();
        Proxy proxy = doPostNativeWithFormModel.getProxy();
        return doPostNativeWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters) throws IOException {
        return doPostNativeWithForm(url, requestParameters, null, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers) throws IOException {
        return doPostNativeWithForm(url, requestParameters, headers, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName) throws IOException {
        return doPostNativeWithForm(url, requestParameters, headers, charsetName, 0, 0, null, null, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout) throws IOException {
        return doPostNativeWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, null, null, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) throws IOException {
        return doPostNativeWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager, Proxy proxy) throws IOException {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(connectTimeout, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(readTimeout, TimeUnit.SECONDS);
        if (Objects.nonNull(sslSocketFactory)) {
            okHttpClientBuilder.sslSocketFactory(sslSocketFactory, x509TrustManager);
        }
        if (Objects.nonNull(proxy)) {
            okHttpClientBuilder.proxy(proxy);
        }

        FormBody formBody = new FormBody(requestParameters, charsetName);
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.post(formBody);
        requestBuilder.url(url);
        if (MapUtils.isNotEmpty(headers)) {
            requestBuilder.headers(Headers.of(headers));
        }
        return okHttpClientBuilder.build().newCall(requestBuilder.build()).execute();
    }

    public static String doGet(DoGetModel doGetModel) throws IOException {
        String url = doGetModel.getUrl();
        Map<String, String> queryParams = doGetModel.getQueryParams();
        Map<String, String> headers = doGetModel.getHeaders();
        int connectTimeout = doGetModel.getConnectTimeout();
        int readTimeout = doGetModel.getReadTimeout();
        Proxy proxy = doGetModel.getProxy();
        return doGet(url, queryParams, headers, connectTimeout, readTimeout, proxy);
    }

    public static String doGet(String url) throws IOException {
        return doGet(url, null, null, 0, 0, null);
    }

    public static String doGet(String url, Map<String, String> queryParams) throws IOException {
        return doGet(url, queryParams, null, 0, 0, null);
    }

    public static String doGet(String url, Map<String, String> queryParams, Map<String, String> headers) throws IOException {
        return doGet(url, queryParams, headers, 0, 0, null);
    }

    public static String doGet(String url, Map<String, String> queryParams, Map<String, String> headers, int connectTimeout, int readTimeout) throws IOException {
        return doGet(url, queryParams, headers, connectTimeout, readTimeout, null);
    }

    public static String doGet(String url, Map<String, String> queryParams, Map<String, String> headers, int connectTimeout, int readTimeout, Proxy proxy) throws IOException {
        return obtainResult(doGetNative(url, queryParams, headers, connectTimeout, readTimeout, proxy));
    }

    public static Response doGetNative(DoGetNativeModel doGetNativeModel) throws IOException {
        String url = doGetNativeModel.getUrl();
        Map<String, String> queryParams = doGetNativeModel.getQueryParams();
        Map<String, String> headers = doGetNativeModel.getHeaders();
        int connectTimeout = doGetNativeModel.getConnectTimeout();
        int readTimeout = doGetNativeModel.getReadTimeout();
        Proxy proxy = doGetNativeModel.getProxy();
        return doGetNative(url, queryParams, headers, connectTimeout, readTimeout, proxy);
    }

    public static Response doGetNative(String url) throws IOException {
        return doGetNative(url, null, null, 0, 0, null);
    }

    public static Response doGetNative(String url, Map<String, String> queryParams) throws IOException {
        return doGetNative(url, queryParams, null, 0, 0, null);
    }

    public static Response doGetNative(String url, Map<String, String> queryParams, Map<String, String> headers) throws IOException {
        return doGetNative(url, queryParams, headers, 0, 0, null);
    }

    public static Response doGetNative(String url, Map<String, String> queryParams, Map<String, String> headers, int connectTimeout, int readTimeout) throws IOException {
        return doGetNative(url, queryParams, headers, connectTimeout, readTimeout, null);
    }

    public static Response doGetNative(String url, Map<String, String> queryParams, Map<String, String> headers, int connectTimeout, int readTimeout, Proxy proxy) throws IOException {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(connectTimeout, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(readTimeout, TimeUnit.SECONDS);
        if (Objects.nonNull(proxy)) {
            okHttpClientBuilder.proxy(proxy);
        }

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.get();
        requestBuilder.url(MapUtils.isEmpty(queryParams) ? url : url + "?" + WebUtils.buildQueryString(queryParams, Constants.CHARSET_NAME_UTF_8));
        if (MapUtils.isNotEmpty(headers)) {
            requestBuilder.headers(Headers.of(headers));
        }
        return okHttpClientBuilder.build().newCall(requestBuilder.build()).execute();
    }

    public static String obtainResult(Response response) throws IOException {
        String result = response.body().string();
        closeResponse(response);
        return result;
    }

    public static void closeResponse(Response response) {
        if (Objects.nonNull(response)) {
            response.close();
        }
    }

    public static String register(String userName, String email, String password) throws IOException {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("username", userName);
        body.put("email", email);
        body.put("password", password);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(JacksonUtils.writeValueAsString(body).getBytes(Constants.CHARSET_UTF_8));
        return doPostWithRequestBody("http://10.138.11.82:3000/api/user/reg", byteArrayInputStream, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
    }

    public static void main(String[] args) throws IOException {
        /*ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(UUID.randomUUID().toString().getBytes(Constants.CHARSET_UTF_8));

        DoPostWithRequestBodyModel doPostWithRequestBodyModel = new DoPostWithRequestBodyModel();
        doPostWithRequestBodyModel.setUrl("http://localhost:9000/jddj/test");
        doPostWithRequestBodyModel.setBody(byteArrayInputStream);
        doPostWithRequestBodyModel.setContentType(Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);

        String result = doPostWithRequestBody(doPostWithRequestBodyModel);
        System.out.println(result);*/

        Map<String, String> parts = new HashMap<String, String>();
        parts.put("loginName", "61011888");
        Response response = doPostNativeWithForm("http://www.smartpos.top/portal/tenantWebService/showTenantInfo", parts);
        System.out.println(response.body().string());
        closeResponse(response);
        System.out.println();
    }
}
