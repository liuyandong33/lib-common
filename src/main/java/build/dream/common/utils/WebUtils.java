package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
    }

    public static final String TWO_HYPHENS = "--";
    public static final String BOUNDARY = UUID.randomUUID().toString();
    public static final String ENTER_NEW_LINE = "\r\n";

    public static String doGetWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, null, requestParameters);
    }

    public static String doGetWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetWithRequestParameters(requestUrl, null, requestParameters, charsetName);
    }

    public static String doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName);
    }

    public static String doGetWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String doGetWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doGetWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, charsetName);
    }

    public static String doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, String> requestParameters, String charsetName) throws IOException {
        String result = null;
        HttpURLConnection httpURLConnection = null;
        try {
            if (MapUtils.isNotEmpty(requestParameters)) {
                requestUrl = requestUrl + "?" + buildQueryString(requestParameters, charsetName);
            }
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.GET, readTimeout, connectTimeout, null);
            setRequestProperties(httpURLConnection, headers, charsetName);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                httpURLConnection.disconnect();
                return doGetWithRequestParameters(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, null, charsetName);
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(httpURLConnection.getInputStream(), obtainResponseCharset(httpURLConnection, charsetName));
                httpURLConnection.disconnect();
            } else {
                Validate.isTrue(false, Constants.NETWORK_ERROR_MESSAGE);
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return result;
    }

    public static String doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doPostWithRequestParameters(requestUrl, null, requestParameters);
    }

    public static String doPostWithRequestParameters(String requestUrl, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doPostWithRequestParameters(requestUrl, null, requestParameters, charsetName);
    }

    public static String doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters) throws IOException {
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName);
    }

    public static String doPostWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String doPostWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters, String charsetName) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, headers, requestParameters, charsetName);
    }

    public static String doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, String> requestParameters, String charsetName) throws IOException {
        String result = null;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout, null);
            setRequestProperties(httpURLConnection, headers, charsetName);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            String requestBody = buildRequestBody(requestParameters, charsetName);
            httpURLConnection.getOutputStream().write(requestBody.getBytes(charsetName));
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                httpURLConnection.disconnect();
                return doPostWithRequestParameters(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestParameters, charsetName);
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(httpURLConnection.getInputStream(), obtainResponseCharset(httpURLConnection, charsetName));
                httpURLConnection.disconnect();
            } else {
                Validate.isTrue(false, Constants.NETWORK_ERROR_MESSAGE);
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return result;
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, Map<String, Object> requestParameters) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, null, requestParameters);
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, Map<String, Object> requestParameters, String charsetName) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, null, requestParameters, charsetName);
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, int readTimeout, int connectTimeout, Map<String, Object> requestParameters) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, readTimeout, connectTimeout, null, requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, int readTimeout, int connectTimeout, Map<String, Object> requestParameters, String charsetName) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, readTimeout, connectTimeout, null, requestParameters, charsetName);
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, Map<String, String> headers, Map<String, Object> requestParameters) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, 0, 0, headers, requestParameters, Constants.CHARSET_NAME_UTF_8);
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, Map<String, String> headers, Map<String, Object> requestParameters, String charsetName) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, 0, 0, headers, requestParameters, charsetName);
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, Object> requestParameters, String charsetName) throws IOException {
        String result = null;
        HttpURLConnection httpURLConnection = null;
        httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout, null);
        try {
            if (headers == null) {
                headers = new HashMap<String, String>();
                headers.put("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
            }
            setRequestProperties(httpURLConnection, headers, charsetName);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
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
                    outputStream.write(("Content-Disposition: form-data; " + "name=\"" + key + "\";filename=\"" + fileName + "\"" + ENTER_NEW_LINE).getBytes(charsetName));
                    outputStream.write(("Content-Type:" + MimeMappingUtils.obtainMimeTypeByFileName(fileName) + ENTER_NEW_LINE + ENTER_NEW_LINE).getBytes(charsetName));
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
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                httpURLConnection.disconnect();
                return doPostWithRequestParametersAndFiles(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestParameters, charsetName);
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(httpURLConnection.getInputStream(), obtainResponseCharset(httpURLConnection, charsetName));
                httpURLConnection.disconnect();
            } else {
                Validate.isTrue(false, Constants.NETWORK_ERROR_MESSAGE);
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return result;
    }

    public static String doPostWithRequestBody(String requestUrl, String requestBody) throws IOException {
        return doPostWithRequestBody(requestUrl, null, requestBody, Constants.CHARSET_NAME_UTF_8, null);
    }

    public static String doPostWithRequestBody(String requestUrl, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    public static String doPostWithRequestBody(String requestUrl, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, null, requestBody, charsetName, sslSocketFactory);
    }

    public static String doPostWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    public static String doPostWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody, charsetName, sslSocketFactory);
    }

    public static String doPostWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, 0, 0, headers, requestBody, Constants.CHARSET_NAME_UTF_8, sslSocketFactory);
    }

    public static String doPostWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        return doPostWithRequestBody(requestUrl, 0, 0, headers, requestBody, charsetName, sslSocketFactory);
    }

    public static String doPostWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, String requestBody, String charsetName, SSLSocketFactory sslSocketFactory) throws IOException {
        String result = null;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout, sslSocketFactory);
            setRequestProperties(httpURLConnection, headers, charsetName);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(requestBody.getBytes(charsetName));
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                httpURLConnection.disconnect();
                return doPostWithRequestBody(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestBody, charsetName, null);
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(httpURLConnection.getInputStream(), obtainResponseCharset(httpURLConnection, charsetName));
                httpURLConnection.disconnect();
            } else {
                Validate.isTrue(false, Constants.NETWORK_ERROR_MESSAGE);
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return result;
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

    public static HttpURLConnection buildHttpURLConnection(String requestUrl, String requestMethod, int readTimeout, int connectTimeout, SSLSocketFactory sslSocketFactory) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection httpURLConnection = null;
        if (sslSocketFactory != null) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
            httpURLConnection = httpsURLConnection;
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setRequestMethod(requestMethod);
        httpURLConnection.setReadTimeout(readTimeout);
        httpURLConnection.setConnectTimeout(connectTimeout);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    public static String buildQueryString(Map<String, String> requestParameters, String charsetName) throws UnsupportedEncodingException {
        List<String> requestParameterPairs = new ArrayList<String>();
        Set<Map.Entry<String, String>> entries = requestParameters.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            requestParameterPairs.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), charsetName));
        }
        return StringUtils.join(requestParameterPairs, "&");
    }

    public static String buildRequestBody(Map<String, String> requestParameters, String charsetName) throws UnsupportedEncodingException {
        List<String> requestParameterPairs = new ArrayList<String>();
        Set<Map.Entry<String, String>> entries = requestParameters.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            requestParameterPairs.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), charsetName));
        }
        return StringUtils.join(requestParameterPairs, "&");
    }

    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return inputStreamToString(inputStream, Constants.CHARSET_NAME_UTF_8);
    }

    public static String inputStreamToString(InputStream inputStream, String charsetName) throws IOException {
        StringBuffer result = new StringBuffer();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charsetName);
        int length = 0;
        char[] buffer = new char[1024];
        while ((length = inputStreamReader.read(buffer, 0, 1024)) != -1) {
            result.append(buffer, 0, length);
        }
        inputStreamReader.close();
        return result.toString();
    }

    public static Map<String, String> xmlStringToMap(String xmlString) throws DocumentException {
        Document document = DocumentHelper.parseText(xmlString);
        return xmlDocumentToMap(document);
    }

    public static Map<String, String> xmlInputStreamToMap(InputStream inputStream) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        return xmlDocumentToMap(document);
    }

    private static Map<String, String> xmlDocumentToMap(Document document) {
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        Map<String, String> returnValue = new HashMap<String, String>();
        for (Element element : elements) {
            returnValue.put(element.getName(), element.getText());
        }
        return returnValue;
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
}
