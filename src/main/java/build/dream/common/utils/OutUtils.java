package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.exceptions.ApiException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.net.ssl.SSLSocketFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
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
            return WebUtils.doGetWithRequestParameters(url, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, proxy);
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
            return WebUtils.doPostWithRequestParameters(url, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, proxy);
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
            return WebUtils.doPostWithRequestBody(url, 0, 0, headers, requestBody, charsetName, sslSocketFactory, proxy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String certificate, String password) {
        return doPostWithRequestBody(url, headers, requestBody, Constants.CHARSET_NAME_UTF_8, certificate, password);
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String charsetName, String certificate, String password) {
        try {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            SSLSocketFactory sslSocketFactory = null;
            if (StringUtils.isNotBlank(certificate) && StringUtils.isNotBlank(password)) {
                sslSocketFactory = WebUtils.initSSLSocketFactory(certificate, password);
            }
            return WebUtils.doPostWithRequestBody(url, 0, 0, headers, requestBody, charsetName, sslSocketFactory, proxy);
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
            return WebUtils.doPostWithRequestParametersAndFiles(url, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, proxy);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static ResponseEntity<byte[]> doGet(String url, Map<String, String> headers) throws IOException {
        ValidateUtils.notNull(proxy, "未配置代理服务器！");
        HttpURLConnection httpURLConnection = WebUtils.buildHttpURLConnection(url, WebUtils.RequestMethod.GET, 0, 0, null, proxy);
        WebUtils.setRequestProperties(httpURLConnection, headers, Constants.CHARSET_NAME_UTF_8);

        // 处理重定向
        int responseCode = httpURLConnection.getResponseCode();
        while (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
            httpURLConnection.disconnect();
            httpURLConnection = WebUtils.buildHttpURLConnection(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), WebUtils.RequestMethod.GET, 0, 0, null, proxy);
            WebUtils.setRequestProperties(httpURLConnection, headers, Constants.CHARSET_NAME_UTF_8);
            responseCode = httpURLConnection.getResponseCode();
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (Map.Entry<String, List<String>> headerField : headerFields.entrySet()) {
            String key = headerField.getKey();
            List<String> value = headerField.getValue();
            if (StringUtils.isNotBlank(key) && CollectionUtils.isNotEmpty(value)) {
                httpHeaders.addAll(headerField.getKey(), headerField.getValue());
            }
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(httpURLConnection.getInputStream(), byteArrayOutputStream);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(byteArrayOutputStream.toByteArray(), httpHeaders, HttpStatus.valueOf(responseCode));
        byteArrayOutputStream.close();
        httpURLConnection.disconnect();
        return responseEntity;
    }
}