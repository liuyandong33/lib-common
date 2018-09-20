package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * Created by liuyandong on 2017/7/15.
 */
public class WebUtils {
    public static final class RequestMethod {
        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }

    public static final String TWO_HYPHENS = "--";
    public static final String BOUNDARY = UUID.randomUUID().toString();
    public static final String ENTER_NEW_LINE = "\r\n";

    public static WebResponse doGetWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, null, requestParameters);
    }

    public static WebResponse doGetWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetWithRequestParameters(requestUrl, null, requestParameters, charsetName);
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
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.GET, readTimeout, connectTimeout, null, proxy);
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

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doPostWithRequestParameters(requestUrl, requestParameters, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParameters(requestUrl, requestParameters, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    public static WebResponse doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParameters(requestUrl, null, requestParameters, charsetName, sslSocketFactory);
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
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout, sslSocketFactory, proxy);
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

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, Map<String, Object> requestParameters) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, requestParameters, null);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, Map<String, Object> requestParameters, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, null, requestParameters, sslSocketFactory);
    }

    public static WebResponse doPostWithRequestParametersAndFiles(String requestUrl, Map<String, Object> requestParameters, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, null, requestParameters, charsetName, sslSocketFactory);
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
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout, sslSocketFactory, proxy);
            if (headers == null) {
                headers = new HashMap<String, String>();
                headers.put("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
            }
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

    public static WebResponse doPostWithRequestBody(String requestUrl, String requestBody) throws IOException {
        return doPostWithRequestBody(requestUrl, null, requestBody, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    public static WebResponse doPostWithRequestBody(String requestUrl, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, null, requestBody, charsetName, sslSocketFactory);
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
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout, sslSocketFactory, proxy);
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

    public static WebResponse doPutWithRequestBody(String requestUrl, String requestBody) throws IOException {
        return doPutWithRequestBody(requestUrl, null, requestBody, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPutWithRequestBody(requestUrl, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    public static WebResponse doPutWithRequestBody(String requestUrl, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPutWithRequestBody(requestUrl, null, requestBody, charsetName, sslSocketFactory);
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
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.PUT, readTimeout, connectTimeout, sslSocketFactory, proxy);
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

    public static WebResponse doDeleteWithRequestBody(String requestUrl, String requestBody) throws IOException {
        return doDeleteWithRequestBody(requestUrl, null, requestBody, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static WebResponse doDeleteWithRequestBody(String requestUrl, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doDeleteWithRequestBody(requestUrl, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    public static WebResponse doDeleteWithRequestBody(String requestUrl, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doDeleteWithRequestBody(requestUrl, null, requestBody, charsetName, sslSocketFactory);
    }

    public static WebResponse doDeleteWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doDeleteWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doDeleteWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doDeleteWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doDeleteWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doDeleteWithRequestBody(requestUrl, 0, 0, headers, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory, null);
    }

    public static WebResponse doDeleteWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doDeleteWithRequestBody(requestUrl, 0, 0, headers, requestBody, charsetName, sslSocketFactory, null);
    }

    public static WebResponse doDeleteWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory, Proxy proxy) throws IOException {
        String result = null;
        Map<String, List<String>> headerFields = null;
        HttpURLConnection httpURLConnection = null;
        int responseCode;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.DELETE, readTimeout, connectTimeout, sslSocketFactory, proxy);
            setRequestProperties(httpURLConnection, headers, charsetName);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            if (StringUtils.isNotBlank(requestBody)) {
                httpURLConnection.getOutputStream().write(requestBody.getBytes(charsetName));
            }
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doDeleteWithRequestBody(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestBody, charsetName, sslSocketFactory, proxy);
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

    public static void setRequestProperties(HttpURLConnection httpURLConnection, Map<String, String> headers, String charsetName) {
        if (MapUtils.isNotEmpty(headers)) {
            Set<Map.Entry<String, String>> entries = headers.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        } else {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charsetName);
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

    public static String buildQueryString(Map<String, String> requestParameters) throws UnsupportedEncodingException {
        return buildQueryString(requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String buildQueryStringOriginal(Map<String, String> requestParameters) {
        List<String> requestParameterPairs = new ArrayList<String>();
        Set<Map.Entry<String, String>> entries = requestParameters.entrySet();
        for (Map.Entry<String, String> entry : entries) {
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

    public static String buildQueryString(Map<String, String> requestParameters, String charsetName) {
        return concat(requestParameters, charsetName);
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
                requestParameterPairs.add(key + "=");
            } else {
                requestParameterPairs.add(key + "=" + UrlUtils.encode(value, charsetName));
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

    public static SSLSocketFactory initSSLSocketFactory(InputStream inputStream, String password) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(inputStream, password.toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password.toCharArray());
        sslContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }

                    @Override
                    public void checkClientTrusted(final X509Certificate[] arg0, final String arg1) {

                    }

                    @Override
                    public void checkServerTrusted(final X509Certificate[] arg0, final String arg1) {

                    }
                }
        }, new SecureRandom());
        return sslContext.getSocketFactory();
    }

    public static SSLSocketFactory initSSLSocketFactory(String certificate, String password) throws IOException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decodeBase64(certificate));
        return initSSLSocketFactory(byteArrayInputStream, password);
    }

    public static String obtainResponseCharset(HttpURLConnection httpURLConnection, String defaultCharset) {
        String charset = null;
        String contentType = httpURLConnection.getContentType();
        if (StringUtils.isNotBlank(contentType)) {
            contentType = contentType.toUpperCase();
            String[] array = contentType.split(";");
            int length = array.length;
            for (int index = 0; index < length; index++) {
                String str = array[index].trim();
                if (str.startsWith("CHARSET")) {
                    String[] pair = str.split("=");
                    charset = pair[1].trim();
                    break;
                }
            }
        }
        if (StringUtils.isBlank(charset)) {
            charset = defaultCharset;
        }
        return charset;
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
                int length = 0;
                byte[] buffer = new byte[1024];
                while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
                inputStream.close();
            }
            outputStream.write(ENTER_NEW_LINE.getBytes(charsetName));
        }
        outputStream.write((TWO_HYPHENS + BOUNDARY + TWO_HYPHENS + ENTER_NEW_LINE).getBytes(charsetName));
    }

    public static String obtainResult(HttpURLConnection httpURLConnection, int responseCode, String charsetName) throws IOException {
        String result = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            result = IOUtils.toString(httpURLConnection.getInputStream(), obtainResponseCharset(httpURLConnection, charsetName));
            httpURLConnection.disconnect();
        } else {
            result = IOUtils.toString(httpURLConnection.getErrorStream(), obtainResponseCharset(httpURLConnection, charsetName));
            httpURLConnection.disconnect();
        }
        return result;
    }
}
