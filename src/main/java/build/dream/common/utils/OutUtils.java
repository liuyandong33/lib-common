package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.web.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.IOException;
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

    public static WebResponse doGetWithRequestParameters(String url, Map<String, String> requestParameters) {
        return doGetWithRequestParameters(url, null, requestParameters);
    }

    public static WebResponse doGetWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebResponse doPostWithRequestParameters(String url, Map<String, String> requestParameters) {
        return doPostWithRequestParameters(url, null, requestParameters);
    }

    public static WebResponse doPostWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters) {
        return doPostWithRequestParameters(url, headers, requestParameters, null);
    }

    public static WebResponse doPostWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebResponse doPostWithRequestBody(String url, String requestBody) {
        return doPostWithRequestBody(url, null, requestBody);
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody) {
        return doPostWithRequestBody(url, headers, requestBody, Constants.CHARSET_NAME_UTF_8);
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String charsetName) {
        return doPostWithRequestBody(url, headers, requestBody, charsetName, (SSLSocketFactory) null);
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, SSLSocketFactory sslSocketFactory) {
        return doPostWithRequestBody(url, headers, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String certificate, String password, String certificateType, TrustManager[] trustManagers) {
        return doPostWithRequestBody(url, headers, requestBody, Constants.CHARSET_NAME_UTF_8, certificate, password, certificateType, trustManagers);
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String charsetName, String certificate, String password, String certificateType, TrustManager[] trustManagers) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String url, Map<String, String> headers, Map<String, Object> requestParameters) {
        return doPostWithRequestParametersAndFiles(url, headers, requestParameters, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String url, Map<String, String> headers, Map<String, Object> requestParameters, SSLSocketFactory sslSocketFactory) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        ValidateUtils.notNull(proxy, "未配置代理服务器！");
        DoGetOrdinaryWithRequestParametersModel doGetOrdinaryWithRequestParametersModel = DoGetOrdinaryWithRequestParametersModel.builder()
                .requestUrl(url)
                .headers(headers)
                .requestParameters(requestParameters)
                .proxy(proxy)
                .build();
        return WebUtils.doGetOrdinaryWithRequestParameters(doGetOrdinaryWithRequestParametersModel);
    }
}