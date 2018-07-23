package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.exceptions.ApiException;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.ResponseEntity;

import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OutUtils {
    public static WebResponse doGetWithRequestParameters(String url, Map<String, String> headers, Map<String, String> requestParameters) {
        try {
            String _url = new String(url);
            if (MapUtils.isNotEmpty(requestParameters)) {
                _url = _url + "?" + WebUtils.buildQueryString(requestParameters);
            }
            Map<String, String> doGetRequestParameters = new HashMap<String, String>();
            doGetRequestParameters.put("_url", _url);

            WebResponse webResponse = WebUtils.doGetWithRequestParameters("http://192.168.0.77", headers, requestParameters);
            return webResponse;
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static WebResponse doPostWithRequestBody(String url, Map<String, String> headers, String requestBody, String certificate, String password) {
        try {
            SSLSocketFactory sslSocketFactory = null;
            if (StringUtils.isNotBlank(certificate) && StringUtils.isNotBlank(password)) {
                sslSocketFactory = WebUtils.initSSLSocketFactory(certificate, password);
            }
            String requestUrl = "http://192.168.0.77?_url=" + Base64.encodeBase64String(url.getBytes(Constants.CHARSET_NAME_UTF_8));
            return WebUtils.doPostWithRequestBody(requestUrl, headers, requestBody, sslSocketFactory);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static WebResponse doPostWithRequestBody(String url, String requestBody, Map<String, String> headers) {
        return doPostWithRequestBody(url, headers, requestBody, null, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String url, Map<String, String> headers, Map<String, Object> requestParameters) {
        try {
            String requestUrl = "http://192.168.0.77?_url=" + Base64.encodeBase64String(url.getBytes(Constants.CHARSET_NAME_UTF_8));
            return WebUtils.doPostWithRequestParametersAndFiles(requestUrl, headers, requestParameters);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static ResponseEntity<byte[]> doGetOriginal(String url, Map<String, String> headers) throws IOException {
        Map<String, String> doGetOriginalRequestParameters = new HashMap<String, String>();
        doGetOriginalRequestParameters.put("url", url);
        if (MapUtils.isNotEmpty(headers)) {
            doGetOriginalRequestParameters.put("headers", GsonUtils.toJson(headers));
        }
        return ProxyUtils.obtainRestTemplate().getForEntity(ProxyUtils.obtainUrl(null, Constants.SERVICE_NAME_OUT, "proxy", "doGetOriginal", doGetOriginalRequestParameters), byte[].class);
    }
}