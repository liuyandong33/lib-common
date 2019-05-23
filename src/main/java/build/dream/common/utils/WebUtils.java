package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.web.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.*;

/**
 * Created by liuyandong on 2017/7/15.
 */
public class WebUtils {
    public static final String TWO_HYPHENS = "--";
    public static final String BOUNDARY = UUID.randomUUID().toString();
    public static final String ENTER_NEW_LINE = "\r\n";

    public static WebResponse doGetWithRequestParameters(DoGetWithRequestParametersModel doGetWithRequestParametersModel) throws IOException {
        String requestUrl = doGetWithRequestParametersModel.getRequestUrl();
        int readTimeout = doGetWithRequestParametersModel.getReadTimeout();
        int connectTimeout = doGetWithRequestParametersModel.getConnectTimeout();
        Map<String, String> headers = doGetWithRequestParametersModel.getHeaders();
        Map<String, String> requestParameters = doGetWithRequestParametersModel.getRequestParameters();
        String charsetName = doGetWithRequestParametersModel.getCharsetName();
        Proxy proxy = doGetWithRequestParametersModel.getProxy();
        return doGetWithRequestParameters(requestUrl, readTimeout, connectTimeout, headers, requestParameters, charsetName, proxy);
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

    public static WebResponse doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, String> requestParameters, String charsetName, Proxy proxy) throws IOException {
        String result = null;
        Map<String, List<String>> headerFields = null;
        HttpURLConnection httpURLConnection = null;
        int responseCode;
        try {
            if (MapUtils.isNotEmpty(requestParameters)) {
                requestUrl = requestUrl + "?" + buildQueryString(requestParameters, charsetName);
            }
            httpURLConnection = buildHttpURLConnection(requestUrl, Constants.REQUEST_METHOD_GET, readTimeout, connectTimeout, null, proxy);
            setRequestProperties(httpURLConnection, headers, charsetName);
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doGetWithRequestParameters(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, null, charsetName, proxy);
            } else {
                result = obtainResult(httpURLConnection, responseCode, charsetName);
                headerFields = httpURLConnection.getHeaderFields();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return new WebResponse(result, headerFields, responseCode);
    }

    public static WebResponse doPostWithRequestParameters(DoPostWithRequestParametersModel doPostWithRequestParametersModel) throws IOException {
        String requestUrl = doPostWithRequestParametersModel.getRequestUrl();
        int readTimeout = doPostWithRequestParametersModel.getReadTimeout();
        int connectTimeout = doPostWithRequestParametersModel.getConnectTimeout();
        Map<String, String> headers = doPostWithRequestParametersModel.getHeaders();
        Map<String, String> requestParameters = doPostWithRequestParametersModel.getRequestParameters();
        String charsetName = doPostWithRequestParametersModel.getCharsetName();
        SSLSocketFactory sslSocketFactory = doPostWithRequestParametersModel.getSslSocketFactory();
        Proxy proxy = doPostWithRequestParametersModel.getProxy();
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, headers, requestParameters, charsetName, sslSocketFactory, proxy);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, null, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, null, requestParameters, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory, Proxy proxy) throws IOException {
        String result = null;
        Map<String, List<String>> headerFields = null;
        HttpURLConnection httpURLConnection = null;
        int responseCode;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, Constants.REQUEST_METHOD_POST, readTimeout, connectTimeout, sslSocketFactory, proxy);
            setRequestProperties(httpURLConnection, headers, charsetName);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            if (MapUtils.isNotEmpty(requestParameters)) {
                String requestBody = buildRequestBody(requestParameters, charsetName);
                httpURLConnection.getOutputStream().write(requestBody.getBytes(charsetName));
            }
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doPostWithRequestParameters(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestParameters, charsetName, sslSocketFactory, proxy);
            } else {
                result = obtainResult(httpURLConnection, responseCode, charsetName);
                headerFields = httpURLConnection.getHeaderFields();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return new WebResponse(result, headerFields, responseCode);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(DoPostWithRequestParametersAndFilesModel doPostWithRequestParametersAndFilesModel) throws IOException {
        String requestUrl = doPostWithRequestParametersAndFilesModel.getRequestUrl();
        int readTimeout = doPostWithRequestParametersAndFilesModel.getReadTimeout();
        int connectTimeout = doPostWithRequestParametersAndFilesModel.getConnectTimeout();
        Map<String, String> headers = doPostWithRequestParametersAndFilesModel.getHeaders();
        Map<String, Object> requestParameters = doPostWithRequestParametersAndFilesModel.getRequestParameters();
        String charsetName = doPostWithRequestParametersAndFilesModel.getCharsetName();
        SSLSocketFactory sslSocketFactory = doPostWithRequestParametersAndFilesModel.getSslSocketFactory();
        Proxy proxy = doPostWithRequestParametersAndFilesModel.getProxy();
        return doPostWithRequestParametersAndFiles(requestUrl, readTimeout, connectTimeout, headers, requestParameters, charsetName, sslSocketFactory, proxy);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, Map<String, Object> requestParameters) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, 0, 0, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, Map<String, Object> requestParameters, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, 0, 0, null, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, Map<String, Object> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, 0, 0, null, requestParameters, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, int readTimeout, int connectTimeout, Map<String, Object> requestParameters, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, int readTimeout, int connectTimeout, Map<String, Object> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, Map<String, String> headers, Map<String, Object> requestParameters, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, Map<String, String> headers, Map<String, Object> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, 0, 0, headers, requestParameters, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, Object> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory, Proxy proxy) throws IOException {
        String result = null;
        Map<String, List<String>> headerFields = null;
        int responseCode;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, Constants.REQUEST_METHOD_POST, readTimeout, connectTimeout, sslSocketFactory, proxy);
            if (headers == null) {
                headers = new HashMap<String, String>();
            }
            headers.put(HttpHeaders.CONTENT_TYPE, "multipart/form-data;boundary=" + BOUNDARY);
            setRequestProperties(httpURLConnection, headers, charsetName);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            writeFormData(outputStream, requestParameters, charsetName);
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doPostWithRequestParametersAndFiles(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestParameters, charsetName, sslSocketFactory, proxy);
            } else {
                result = obtainResult(httpURLConnection, responseCode, charsetName);
                headerFields = httpURLConnection.getHeaderFields();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return new WebResponse(result, headerFields, responseCode);
    }

    public static WebResponse doPostWithRequestBody(DoPostWithRequestBodyModel doPostWithRequestBodyModel) throws IOException {
        String requestUrl = doPostWithRequestBodyModel.getRequestUrl();
        int readTimeout = doPostWithRequestBodyModel.getReadTimeout();
        int connectTimeout = doPostWithRequestBodyModel.getConnectTimeout();
        Map<String, String> headers = doPostWithRequestBodyModel.getHeaders();
        String requestBody = doPostWithRequestBodyModel.getRequestBody();
        String charsetName = doPostWithRequestBodyModel.getCharsetName();
        SSLSocketFactory sslSocketFactory = doPostWithRequestBodyModel.getSslSocketFactory();
        Proxy proxy = doPostWithRequestBodyModel.getProxy();
        return doPostWithRequestBody(requestUrl, readTimeout, connectTimeout, headers, requestBody, charsetName, sslSocketFactory, proxy);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, String requestBody) throws IOException {
        return doPostWithRequestBody(requestUrl, 0, 0, null, requestBody, Constants.CHARSET_NAME_UTF_8, null, null);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, 0, 0, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, 0, 0, null, requestBody, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, 0, 0, headers, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, 0, 0, headers, requestBody, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory, Proxy proxy) throws IOException {
        String result = null;
        Map<String, List<String>> headerFields = null;
        HttpURLConnection httpURLConnection = null;
        int responseCode;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, Constants.REQUEST_METHOD_POST, readTimeout, connectTimeout, sslSocketFactory, proxy);
            setRequestProperties(httpURLConnection, headers, charsetName);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            if (StringUtils.isNotBlank(requestBody)) {
                httpURLConnection.getOutputStream().write(requestBody.getBytes(charsetName));
            }
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doPostWithRequestBody(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestBody, charsetName, sslSocketFactory, proxy);
            } else {
                result = obtainResult(httpURLConnection, responseCode, charsetName);
                headerFields = httpURLConnection.getHeaderFields();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return new WebResponse(result, headerFields, responseCode);
    }

    public static WebResponse doPutWithRequestBody(DoPutWithRequestBodyModel doPutWithRequestBodyModel) throws IOException {
        String requestUrl = doPutWithRequestBodyModel.getRequestUrl();
        int readTimeout = doPutWithRequestBodyModel.getReadTimeout();
        int connectTimeout = doPutWithRequestBodyModel.getConnectTimeout();
        Map<String, String> headers = doPutWithRequestBodyModel.getHeaders();
        String requestBody = doPutWithRequestBodyModel.getRequestBody();
        String charsetName = doPutWithRequestBodyModel.getCharsetName();
        SSLSocketFactory sslSocketFactory = doPutWithRequestBodyModel.getSslSocketFactory();
        Proxy proxy = doPutWithRequestBodyModel.getProxy();
        return doPutWithRequestBody(requestUrl, readTimeout, connectTimeout, headers, requestBody, charsetName, sslSocketFactory, proxy);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, String requestBody) throws IOException {
        return doPutWithRequestBody(requestUrl, 0, 0, null, requestBody, Constants.CHARSET_NAME_UTF_8, null, null);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPutWithRequestBody(requestUrl, 0, 0, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPutWithRequestBody(requestUrl, 0, 0, null, requestBody, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPutWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPutWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPutWithRequestBody(requestUrl, 0, 0, headers, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPutWithRequestBody(requestUrl, 0, 0, headers, requestBody, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory, Proxy proxy) throws IOException {
        String result = null;
        Map<String, List<String>> headerFields = null;
        HttpURLConnection httpURLConnection = null;
        int responseCode;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, Constants.REQUEST_METHOD_PUT, readTimeout, connectTimeout, sslSocketFactory, proxy);
            setRequestProperties(httpURLConnection, headers, charsetName);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            if (StringUtils.isNotBlank(requestBody)) {
                httpURLConnection.getOutputStream().write(requestBody.getBytes(charsetName));
            }
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doPutWithRequestBody(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestBody, charsetName, sslSocketFactory, proxy);
            } else {
                result = obtainResult(httpURLConnection, responseCode, charsetName);
                headerFields = httpURLConnection.getHeaderFields();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return new WebResponse(result, headerFields, responseCode);
    }

    public static WebResponse doDeleteWithRequestParameters(DoDeleteWithRequestParametersModel doDeleteWithRequestParametersModel) throws IOException {
        String requestUrl = doDeleteWithRequestParametersModel.getRequestUrl();
        int readTimeout = doDeleteWithRequestParametersModel.getReadTimeout();
        int connectTimeout = doDeleteWithRequestParametersModel.getConnectTimeout();
        Map<String, String> headers = doDeleteWithRequestParametersModel.getHeaders();
        Map<String, String> requestParameters = doDeleteWithRequestParametersModel.getRequestParameters();
        String charsetName = doDeleteWithRequestParametersModel.getCharsetName();
        Proxy proxy = doDeleteWithRequestParametersModel.getProxy();
        return doDeleteWithRequestParameters(requestUrl, readTimeout, connectTimeout, headers, requestParameters, charsetName, proxy);
    }

    public static WebResponse doDeleteWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doDeleteWithRequestParameters(requestUrl, 0, 0, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doDeleteWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doDeleteWithRequestParameters(requestUrl, 0, 0, null, requestParameters, charsetName, null);
    }

    public static WebResponse doDeleteWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters) throws IOException {
        return doDeleteWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doDeleteWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doDeleteWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName, null);
    }

    public static WebResponse doDeleteWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        return doDeleteWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doDeleteWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doDeleteWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, charsetName, null);
    }

    public static WebResponse doDeleteWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, String> requestParameters, String charsetName, Proxy proxy) throws IOException {
        String result = null;
        Map<String, List<String>> headerFields = null;
        HttpURLConnection httpURLConnection = null;
        int responseCode;
        try {
            if (MapUtils.isNotEmpty(requestParameters)) {
                requestUrl = requestUrl + "?" + buildQueryString(requestParameters, charsetName);
            }
            httpURLConnection = buildHttpURLConnection(requestUrl, Constants.REQUEST_METHOD_DELETE, readTimeout, connectTimeout, null, proxy);
            setRequestProperties(httpURLConnection, headers, charsetName);
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doDeleteWithRequestParameters(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, null, charsetName, proxy);
            } else {
                result = obtainResult(httpURLConnection, responseCode, charsetName);
                headerFields = httpURLConnection.getHeaderFields();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return new WebResponse(result, headerFields, responseCode);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(DoGetOrdinaryWithRequestParametersModel doGetOrdinaryWithRequestParametersModel) throws IOException {
        String requestUrl = doGetOrdinaryWithRequestParametersModel.getRequestUrl();
        int readTimeout = doGetOrdinaryWithRequestParametersModel.getReadTimeout();
        int connectTimeout = doGetOrdinaryWithRequestParametersModel.getConnectTimeout();
        Map<String, String> headers = doGetOrdinaryWithRequestParametersModel.getHeaders();
        Map<String, String> requestParameters = doGetOrdinaryWithRequestParametersModel.getRequestParameters();
        String charsetName = doGetOrdinaryWithRequestParametersModel.getCharsetName();
        Proxy proxy = doGetOrdinaryWithRequestParametersModel.getProxy();
        return doGetOrdinaryWithRequestParameters(requestUrl, readTimeout, connectTimeout, headers, requestParameters, charsetName, proxy);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doGetOrdinaryWithRequestParameters(requestUrl, 0, 0, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetOrdinaryWithRequestParameters(requestUrl, 0, 0, null, requestParameters, charsetName, null);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters) throws IOException {
        return doGetOrdinaryWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetOrdinaryWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName, null);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        return doGetOrdinaryWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetOrdinaryWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, charsetName, null);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, String> requestParameters, String charsetName, Proxy proxy) throws IOException {
        ResponseEntity<byte[]> responseEntity = null;
        HttpURLConnection httpURLConnection = null;
        int responseCode;
        try {
            if (MapUtils.isNotEmpty(requestParameters)) {
                requestUrl = requestUrl + "?" + buildQueryString(requestParameters, charsetName);
            }
            httpURLConnection = buildHttpURLConnection(requestUrl, Constants.REQUEST_METHOD_GET, readTimeout, connectTimeout, null, proxy);
            setRequestProperties(httpURLConnection, headers, charsetName);
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doGetOrdinaryWithRequestParameters(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, null, charsetName, proxy);
            } else {
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
                responseEntity = new ResponseEntity<byte[]>(byteArrayOutputStream.toByteArray(), httpHeaders, HttpStatus.valueOf(responseCode));
                byteArrayOutputStream.close();
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return responseEntity;
    }

    public static void setRequestProperties(HttpURLConnection httpURLConnection, Map<String, String> headers, String charsetName) {
        if (MapUtils.isEmpty(headers)) {
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=" + charsetName);
        } else {
            Set<Map.Entry<String, String>> entries = headers.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if (!headers.containsKey(HttpHeaders.CONTENT_TYPE)) {
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=" + charsetName);
            }
        }
    }

    public static HttpURLConnection buildHttpURLConnection(String requestUrl, String requestMethod, int readTimeout, int connectTimeout, SSLSocketFactory sslSocketFactory, Proxy proxy) throws IOException {
        HttpURLConnection httpURLConnection = null;
        if (sslSocketFactory != null) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) buildHttpURLConnection(requestUrl, proxy);
            httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
            httpURLConnection = httpsURLConnection;
        } else {
            httpURLConnection = buildHttpURLConnection(requestUrl, proxy);
        }
        httpURLConnection.setRequestMethod(requestMethod);
        httpURLConnection.setReadTimeout(readTimeout);
        httpURLConnection.setConnectTimeout(connectTimeout);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    public static HttpURLConnection buildHttpURLConnection(String requestUrl, Proxy proxy) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection httpURLConnection = null;
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        return httpURLConnection;
    }

    public static String buildQueryString(Map<String, String> requestParameters) {
        return buildQueryString(requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String buildQueryString(Map<String, String> requestParameters, String charsetName) {
        return concat(requestParameters, charsetName);
    }

    public static String buildQueryStringOriginal(Map<String, String> requestParameters) {
        return concat(requestParameters);
    }

    public static String buildRequestBody(Map<String, String> requestParameters) {
        return concat(requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String buildRequestBody(Map<String, String> requestParameters, String charsetName) {
        return concat(requestParameters, charsetName);
    }

    public static String concat(Map<String, String> requestParameters, String charsetName) {
        List<String> requestParameterPairs = new ArrayList<String>();
        Set<Map.Entry<String, String>> entries = requestParameters.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isBlank(value)) {
                requestParameterPairs.add(UrlUtils.encode(key, charsetName) + "=");
            } else {
                requestParameterPairs.add(UrlUtils.encode(key, charsetName) + "=" + UrlUtils.encode(value, charsetName));
            }
        }
        return StringUtils.join(requestParameterPairs, "&");
    }

    public static String concat(Map<String, String> requestParameters) {
        List<String> requestParameterPairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : requestParameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isBlank(value)) {
                requestParameterPairs.add(key + "=");
            } else {
                requestParameterPairs.add(key + "=" + value);
            }
        }
        return StringUtils.join(requestParameterPairs, "&");
    }

    public static SSLSocketFactory initSSLSocketFactory(InputStream inputStream, String password, String certificateType, TrustManager[] trustManagers) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance(Constants.TLS);
        KeyStore keyStore = KeyStore.getInstance(certificateType);
        keyStore.load(inputStream, password.toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password.toCharArray());
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagers, new SecureRandom());
        return sslContext.getSocketFactory();
    }

    public static SSLSocketFactory initSSLSocketFactory(String certificate, String password, String certificateType, TrustManager[] trustManagers) throws IOException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decodeBase64(certificate));
        return initSSLSocketFactory(byteArrayInputStream, password, certificateType, trustManagers);
    }

    public static String obtainResponseCharset(HttpURLConnection httpURLConnection, String defaultCharset) {
        String contentType = httpURLConnection.getContentType();
        if (StringUtils.isBlank(contentType)) {
            return defaultCharset;
        }

        contentType = contentType.toUpperCase();
        String[] array = contentType.split(";");
        for (int index = 0; index < array.length; index++) {
            String str = array[index].trim();
            if (str.startsWith("CHARSET")) {
                String[] pair = str.split("=");
                return pair[1].trim();
            }
        }
        return defaultCharset;
    }

    public static void writeFormData(OutputStream outputStream, Map<String, Object> requestParameters, String charsetName) throws IOException {
        Set<Map.Entry<String, Object>> entries = requestParameters.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            outputStream.write((TWO_HYPHENS + BOUNDARY + ENTER_NEW_LINE).getBytes(charsetName));
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                outputStream.write(("Content-Disposition: form-data; name=\"" + key + "\"" + ENTER_NEW_LINE + ENTER_NEW_LINE).getBytes(charsetName));
                outputStream.write((value.toString()).getBytes(charsetName));
            } else if (value instanceof MultipartFile || value instanceof File) {
                InputStream inputStream = null;
                String fileName = null;
                if (value instanceof MultipartFile) {
                    MultipartFile multipartFile = (MultipartFile) value;
                    inputStream = multipartFile.getInputStream();
                    fileName = multipartFile.getOriginalFilename();
                } else if (value instanceof File) {
                    File file = (File) value;
                    inputStream = new FileInputStream(file);
                    fileName = file.getName();
                }
                outputStream.write(("Content-Disposition: form-data; " + "name=\"" + key + "\";filename=\"" + fileName + "\"" + ENTER_NEW_LINE).getBytes(Constants.CHARSET_NAME_UTF_8));
                outputStream.write(("Content-Type:" + MimeMappingUtils.obtainMimeTypeByFileName(fileName) + ENTER_NEW_LINE + ENTER_NEW_LINE).getBytes(Constants.CHARSET_NAME_UTF_8));
                IOUtils.copy(inputStream, outputStream);
                inputStream.close();
            }
            outputStream.write(ENTER_NEW_LINE.getBytes(charsetName));
        }
        outputStream.write((TWO_HYPHENS + BOUNDARY + TWO_HYPHENS + ENTER_NEW_LINE).getBytes(charsetName));
    }

    public static String obtainResult(HttpURLConnection httpURLConnection, int responseCode, String charsetName) throws IOException {
        String result = null;
        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_ACCEPTED) {
            result = IOUtils.toString(httpURLConnection.getInputStream(), obtainResponseCharset(httpURLConnection, charsetName));
            httpURLConnection.disconnect();
        } else {
            result = IOUtils.toString(httpURLConnection.getErrorStream(), obtainResponseCharset(httpURLConnection, charsetName));
            httpURLConnection.disconnect();
        }
        return result;
    }
}
