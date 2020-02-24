package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.okhttp.DoPostWithRequestBodyModel;
import build.dream.common.models.out.*;
import okhttp3.Response;
import org.apache.commons.lang.StringUtils;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Map;

public class OutUtils {
    private static Proxy proxy;

    static {
        String hostName = ConfigurationUtils.getConfiguration(Constants.PROXY_SERVER_HOST_NAME);
        String port = ConfigurationUtils.getConfiguration(Constants.PROXY_SERVER_PORT);
        if (StringUtils.isNotBlank(hostName) && StringUtils.isNotBlank(port)) {
            SocketAddress socketAddress = new InetSocketAddress(hostName, Integer.parseInt(port));
            proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
        }
    }

    /*@Deprecated
    public static WebResponse doGetWithRequestParameters(String url, Map<String, String> requestParameters) {
        return doGetWithRequestParameters(url, null, requestParameters);
    }

    @Deprecated
    public static WebResponse doGetWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters) {
        return ApplicationHandler.callMethodSuppressThrow(() -> {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            DoGetWithRequestParametersModel doGetWithRequestParametersModel = DoGetWithRequestParametersModel.builder()
                    .requestUrl(url)
                    .readTimeout(0)
                    .connectTimeout(0)
                    .headers(headers)
                    .requestParameters(requestParameters)
                    .charsetName(Constants.CHARSET_NAME_UTF_8)
                    .proxy(proxy)
                    .build();
            return WebUtils.doGetWithRequestParameters(doGetWithRequestParametersModel);
        });
    }

    @Deprecated
    public static WebResponse doPostWithRequestParameters(String url, Map<String, String> requestParameters) {
        return doPostWithRequestParameters(url, null, requestParameters);
    }

    @Deprecated
    public static WebResponse doPostWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters) {
        return doPostWithRequestParameters(url, headers, requestParameters, null);
    }

    @Deprecated
    public static WebResponse doPostWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory) {
        return ApplicationHandler.callMethodSuppressThrow(() -> {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            DoPostWithRequestParametersModel doPostWithRequestParametersModel = DoPostWithRequestParametersModel.builder()
                    .requestUrl(url)
                    .readTimeout(0)
                    .connectTimeout(0)
                    .headers(headers)
                    .requestParameters(requestParameters)
                    .charsetName(Constants.CHARSET_NAME_UTF_8)
                    .sslSocketFactory(sslSocketFactory)
                    .proxy(proxy)
                    .build();
            return WebUtils.doPostWithRequestParameters(doPostWithRequestParametersModel);
        });
    }

    @Deprecated
    public static WebResponse doPostWithRequestBody(String url, String requestBody) {
        return doPostWithRequestBody(url, null, requestBody);
    }

    @Deprecated
    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody) {
        return doPostWithRequestBody(url, headers, requestBody, Constants.CHARSET_NAME_UTF_8);
    }

    @Deprecated
    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String charsetName) {
        return doPostWithRequestBody(url, headers, requestBody, charsetName, (SSLSocketFactory) null);
    }

    @Deprecated
    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, SSLSocketFactory sslSocketFactory) {
        return doPostWithRequestBody(url, headers, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    @Deprecated
    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) {
        return ApplicationHandler.callMethodSuppressThrow(() -> {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            DoPostWithRequestBodyModel doPostWithRequestBodyModel = DoPostWithRequestBodyModel.builder()
                    .requestUrl(url)
                    .readTimeout(0)
                    .connectTimeout(0)
                    .headers(headers)
                    .requestBody(requestBody)
                    .charsetName(charsetName)
                    .sslSocketFactory(sslSocketFactory)
                    .proxy(proxy)
                    .build();
            return WebUtils.doPostWithRequestBody(doPostWithRequestBodyModel);
        });
    }

    @Deprecated
    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String certificate, String password, String certificateType, TrustManager[] trustManagers) {
        return doPostWithRequestBody(url, headers, requestBody, Constants.CHARSET_NAME_UTF_8, certificate, password, certificateType, trustManagers);
    }

    @Deprecated
    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String charsetName, String certificate, String password, String certificateType, TrustManager[] trustManagers) {
        return ApplicationHandler.callMethodSuppressThrow(() -> {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            SSLSocketFactory sslSocketFactory = null;
            if (StringUtils.isNotBlank(certificate) && StringUtils.isNotBlank(password)) {
                sslSocketFactory = WebUtils.initSSLSocketFactory(certificate, password, certificateType, trustManagers);
            }
            DoPostWithRequestBodyModel doPostWithRequestBodyModel = DoPostWithRequestBodyModel.builder()
                    .requestUrl(url)
                    .readTimeout(0)
                    .connectTimeout(0)
                    .headers(headers)
                    .requestBody(requestBody)
                    .charsetName(charsetName)
                    .sslSocketFactory(sslSocketFactory)
                    .proxy(proxy)
                    .build();
            return WebUtils.doPostWithRequestBody(doPostWithRequestBodyModel);
        });
    }

    @Deprecated
    public static WebResponse doPostWithRequestParametersAndFiles(String url, Map<String, String> headers, Map<String, Object> requestParameters) {
        return doPostWithRequestParametersAndFiles(url, headers, requestParameters, null);
    }

    @Deprecated
    public static WebResponse doPostWithRequestParametersAndFiles(String url, Map<String, String> headers, Map<String, Object> requestParameters, SSLSocketFactory sslSocketFactory) {
        return ApplicationHandler.callMethodSuppressThrow(() -> {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            DoPostWithRequestParametersAndFilesModel doPostWithRequestParametersAndFilesModel = DoPostWithRequestParametersAndFilesModel.builder()
                    .requestUrl(url)
                    .readTimeout(0)
                    .connectTimeout(0)
                    .headers(headers)
                    .requestParameters(requestParameters)
                    .charsetName(Constants.CHARSET_NAME_UTF_8)
                    .sslSocketFactory(sslSocketFactory)
                    .proxy(proxy)
                    .build();
            return WebUtils.doPostWithRequestParametersAndFiles(doPostWithRequestParametersAndFilesModel);
        });
    }

    @Deprecated
    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        return ApplicationHandler.callMethodSuppressThrow(() -> {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            DoGetOrdinaryWithRequestParametersModel doGetOrdinaryWithRequestParametersModel = DoGetOrdinaryWithRequestParametersModel.builder()
                    .requestUrl(url)
                    .headers(headers)
                    .requestParameters(requestParameters)
                    .proxy(proxy)
                    .build();
            return WebUtils.doGetOrdinaryWithRequestParameters(doGetOrdinaryWithRequestParametersModel);
        });
    }*/

    public static String doGet(DoGetModel doGetModel) {
        String url = doGetModel.getUrl();
        Map<String, String> queryParams = doGetModel.getQueryParams();
        Map<String, String> headers = doGetModel.getHeaders();
        int connectTimeout = doGetModel.getConnectTimeout();
        int readTimeout = doGetModel.getReadTimeout();
        return doGet(url, queryParams, headers, connectTimeout, readTimeout);
    }

    public static String doGet(String url) {
        return doGet(url, null, null, 0, 0);
    }

    public static String doGet(String url, Map<String, String> queryParams) {
        return doGet(url, queryParams, null, 0, 0);
    }

    public static String doGet(String url, Map<String, String> queryParams, Map<String, String> headers) {
        return doGet(url, queryParams, headers, 0, 0);
    }

    public static String doGet(String url, Map<String, String> queryParams, Map<String, String> headers, int connectTimeout, int readTimeout) {
        Response response = doGetNative(url, queryParams, headers, connectTimeout, readTimeout);
        String result = ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.obtainResult(response));
        OkHttpUtils.closeResponse(response);
        return result;
    }

    public static Response doGetNative(DoGetNativeModel doGetNativeModel) {
        String url = doGetNativeModel.getUrl();
        Map<String, String> queryParams = doGetNativeModel.getQueryParams();
        Map<String, String> headers = doGetNativeModel.getHeaders();
        int connectTimeout = doGetNativeModel.getConnectTimeout();
        int readTimeout = doGetNativeModel.getReadTimeout();
        return doGetNative(url, queryParams, headers, connectTimeout, readTimeout);
    }

    public static Response doGetNative(String url) {
        return doGetNative(url, null, null, 0, 0);
    }

    public static Response doGetNative(String url, Map<String, String> queryParams) {
        return doGetNative(url, queryParams, null, 0, 0);
    }

    public static Response doGetNative(String url, Map<String, String> queryParams, Map<String, String> headers) {
        return doGetNative(url, queryParams, headers, 0, 0);
    }

    public static Response doGetNative(String url, Map<String, String> queryParams, Map<String, String> headers, int connectTimeout, int readTimeout) {
        ValidateUtils.notNull(proxy, "未配置代理服务器！");
        return ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.doGetNative(url, queryParams, headers, connectTimeout, readTimeout, proxy));
    }

    public static String doPostWithForm(DoPostWithFormModel doPostWithFormModel) {
        String url = doPostWithFormModel.getUrl();
        Map<String, String> requestParameters = doPostWithFormModel.getRequestParameters();
        Map<String, String> headers = doPostWithFormModel.getHeaders();
        String charsetName = doPostWithFormModel.getCharsetName();
        int connectTimeout = doPostWithFormModel.getConnectTimeout();
        int readTimeout = doPostWithFormModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostWithFormModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostWithFormModel.getX509TrustManager();
        return doPostWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters) {
        return doPostWithForm(url, requestParameters, null, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers) {
        return doPostWithForm(url, requestParameters, headers, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName) {
        return doPostWithForm(url, requestParameters, headers, charsetName, 0, 0, null, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout) {
        return doPostWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, null, null);
    }

    public static String doPostWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        Response response = doPostNativeWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
        String result = ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.obtainResult(response));
        OkHttpUtils.closeResponse(response);
        return result;
    }

    public static Response doPostNativeWithForm(DoPostNativeWithFormModel doPostNativeWithFormModel) {
        String url = doPostNativeWithFormModel.getUrl();
        Map<String, String> requestParameters = doPostNativeWithFormModel.getRequestParameters();
        Map<String, String> headers = doPostNativeWithFormModel.getHeaders();
        String charsetName = doPostNativeWithFormModel.getCharsetName();
        int connectTimeout = doPostNativeWithFormModel.getConnectTimeout();
        int readTimeout = doPostNativeWithFormModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostNativeWithFormModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostNativeWithFormModel.getX509TrustManager();
        return doPostNativeWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters) {
        return doPostNativeWithForm(url, requestParameters, null, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers) {
        return doPostNativeWithForm(url, requestParameters, headers, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName) {
        return doPostNativeWithForm(url, requestParameters, headers, charsetName, 0, 0, null, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout) {
        return doPostNativeWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, null, null);
    }

    public static Response doPostNativeWithForm(String url, Map<String, String> requestParameters, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        ValidateUtils.notNull(proxy, "未配置代理服务器！");
        return ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.doPostNativeWithForm(url, requestParameters, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy));
    }

    public static String doPostWithRequestBody(DoPostWithRequestBodyModel doPostWithRequestBodyModel) {
        String url = doPostWithRequestBodyModel.getUrl();
        InputStream body = doPostWithRequestBodyModel.getBody();
        String contentType = doPostWithRequestBodyModel.getContentType();
        Map<String, String> headers = doPostWithRequestBodyModel.getHeaders();
        int connectTimeout = doPostWithRequestBodyModel.getConnectTimeout();
        int readTimeout = doPostWithRequestBodyModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostWithRequestBodyModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostWithRequestBodyModel.getX509TrustManager();
        return doPostWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType) {
        return doPostWithRequestBody(url, body, charsetName, contentType, null, 0, 0, null, null);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers) {
        return doPostWithRequestBody(url, body, charsetName, contentType, headers, 0, 0, null, null);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout) {
        return doPostWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, null, null);
    }

    public static String doPostWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        Response response = doPostNativeWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
        String result = ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.obtainResult(response));
        OkHttpUtils.closeResponse(response);
        return result;
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType) {
        return doPostWithRequestBody(url, body, contentType, null, 0, 0, null, null);
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers) {
        return doPostWithRequestBody(url, body, contentType, headers, 0, 0, null, null);
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout) {
        return doPostWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, null, null);
    }

    public static String doPostWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        Response response = doPostNativeWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
        String result = ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.obtainResult(response));
        OkHttpUtils.closeResponse(response);
        return result;
    }

    public static Response doPostNativeWithRequestBody(DoPostNativeWithRequestBodyModel doPostNativeWithRequestBodyModel) {
        String url = doPostNativeWithRequestBodyModel.getUrl();
        InputStream body = doPostNativeWithRequestBodyModel.getBody();
        String contentType = doPostNativeWithRequestBodyModel.getContentType();
        Map<String, String> headers = doPostNativeWithRequestBodyModel.getHeaders();
        int connectTimeout = doPostNativeWithRequestBodyModel.getConnectTimeout();
        int readTimeout = doPostNativeWithRequestBodyModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostNativeWithRequestBodyModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostNativeWithRequestBodyModel.getX509TrustManager();
        return doPostNativeWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType) {
        return doPostNativeWithRequestBody(url, body, charsetName, contentType, null, 0, 0, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers) {
        return doPostNativeWithRequestBody(url, body, charsetName, contentType, headers, 0, 0, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout) {
        return doPostNativeWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, String body, String charsetName, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        ValidateUtils.notNull(proxy, "未配置代理服务器！");
        return ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.doPostNativeWithRequestBody(url, body, charsetName, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy));
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType) {
        return doPostNativeWithRequestBody(url, body, contentType, null, 0, 0, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers) {
        return doPostNativeWithRequestBody(url, body, contentType, headers, 0, 0, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout) {
        return doPostNativeWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, null, null);
    }

    public static Response doPostNativeWithRequestBody(String url, InputStream body, String contentType, Map<String, String> headers, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        ValidateUtils.notNull(proxy, "未配置代理服务器！");
        return ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.doPostNativeWithRequestBody(url, body, contentType, headers, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy));
    }

    public static String doPostWithMultipartForm(DoPostWithMultipartFormModel doPostWithMultipartFormModel) {
        String url = doPostWithMultipartFormModel.getUrl();
        Map<String, Object> parts = doPostWithMultipartFormModel.getParts();
        Map<String, String> headers = doPostWithMultipartFormModel.getHeaders();
        String charsetName = doPostWithMultipartFormModel.getCharsetName();
        int connectTimeout = doPostWithMultipartFormModel.getConnectTimeout();
        int readTimeout = doPostWithMultipartFormModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostWithMultipartFormModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostWithMultipartFormModel.getX509TrustManager();
        return doPostWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts) {
        return doPostWithMultipartForm(url, parts, null, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers) {
        return doPostWithMultipartForm(url, parts, headers, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName) {
        return doPostWithMultipartForm(url, parts, headers, charsetName, 0, 0, null, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout) {
        return doPostWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, null, null);
    }

    public static String doPostWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        Response response = doPostNativeWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
        String result = ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.obtainResult(response));
        OkHttpUtils.closeResponse(response);
        return result;
    }

    public static Response doPostNativeWithMultipartForm(DoPostNativeWithMultipartFormModel doPostNativeWithMultipartFormModel) {
        String url = doPostNativeWithMultipartFormModel.getUrl();
        Map<String, Object> parts = doPostNativeWithMultipartFormModel.getParts();
        Map<String, String> headers = doPostNativeWithMultipartFormModel.getHeaders();
        String charsetName = doPostNativeWithMultipartFormModel.getCharsetName();
        int connectTimeout = doPostNativeWithMultipartFormModel.getConnectTimeout();
        int readTimeout = doPostNativeWithMultipartFormModel.getReadTimeout();
        SSLSocketFactory sslSocketFactory = doPostNativeWithMultipartFormModel.getSslSocketFactory();
        X509TrustManager x509TrustManager = doPostNativeWithMultipartFormModel.getX509TrustManager();
        return doPostNativeWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts) {
        return doPostNativeWithMultipartForm(url, parts, null, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers) {
        return doPostNativeWithMultipartForm(url, parts, headers, Constants.CHARSET_NAME_UTF_8, 0, 0, null, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName) {
        return doPostNativeWithMultipartForm(url, parts, headers, charsetName, 0, 0, null, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout) {
        return doPostNativeWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, null, null);
    }

    public static Response doPostNativeWithMultipartForm(String url, Map<String, Object> parts, Map<String, String> headers, String charsetName, int connectTimeout, int readTimeout, SSLSocketFactory sslSocketFactory, X509TrustManager x509TrustManager) {
        ValidateUtils.notNull(proxy, "未配置代理服务器！");
        return ApplicationHandler.callMethodSuppressThrow(() -> OkHttpUtils.doPostNativeWithMultipartForm(url, parts, headers, charsetName, connectTimeout, readTimeout, sslSocketFactory, x509TrustManager, proxy));
    }
}