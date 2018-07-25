package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.exceptions.ApiException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;

import javax.net.ssl.SSLSocketFactory;
import javax.servlet.http.HttpServletResponse;
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
        String hostName = ConfigurationUtils.getConfigurationSafe(Constants.PROXY_SERVER_HOST_NAME);
        String port = ConfigurationUtils.getConfigurationSafe(Constants.PROXY_SERVER_PORT);
        if (StringUtils.isNotBlank(hostName) && StringUtils.isNotBlank(port)) {
            SocketAddress socketAddress = new InetSocketAddress(hostName, Integer.parseInt(port));
            proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
        }
    }

    public static WebResponse doGetWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters) {
        try {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            return WebUtils.doGetWithRequestParameters(url, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, proxy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebResponse doPostWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory) {
        try {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            return WebUtils.doPostWithRequestParameters(url, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, proxy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, SSLSocketFactory sslSocketFactory) {
        try {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            return WebUtils.doPostWithRequestBody(url, 0, 0, headers, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, proxy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String url, Map<String, String> headers, Map<String, Object> requestParameters, SSLSocketFactory sslSocketFactory) {
        try {
            ValidateUtils.notNull(proxy, "未配置代理服务器！");
            return WebUtils.doPostWithRequestParametersAndFiles(url, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, proxy);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static void doGetWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters, HttpServletResponse httpServletResponse) throws IOException {
        ValidateUtils.notNull(proxy, "未配置代理服务器！");
        HttpURLConnection httpURLConnection = WebUtils.buildHttpURLConnection(url, WebUtils.RequestMethod.GET, 0, 0, null, proxy);
        WebUtils.setRequestProperties(httpURLConnection, headers, Constants.CHARSET_NAME_UTF_8);

        // 处理重定向
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
            httpURLConnection.disconnect();
            httpURLConnection = WebUtils.buildHttpURLConnection(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), WebUtils.RequestMethod.GET, 0, 0, null, proxy);
            WebUtils.setRequestProperties(httpURLConnection, headers, Constants.CHARSET_NAME_UTF_8);
        }

        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (Map.Entry<String, List<String>> headerField : headerFields.entrySet()) {
            String name = headerField.getKey();
            List<String> values = headerField.getValue();
            for (String value : values) {
                httpServletResponse.addHeader(name, value);
            }
        }

        IOUtils.copy(httpURLConnection.getInputStream(), httpServletResponse.getOutputStream());
        httpURLConnection.disconnect();
    }
}