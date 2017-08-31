package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by liuyandong on 2017/7/15.
 */
public class WebUtils {
    public static final class RequestMethod {
        public static final String GET = "GET";
        public static final String POST = "POST";
    }

    public static final String twoHyphens = "--";
    public static final String boundary = UUID.randomUUID().toString();
    public static final String enterNewline = "\r\n";

    public static String doGetWithRequestParameters(String requestUrl, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, null, requestParameters);
    }

    public static String doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters);
    }

    public static String doGetWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        return doGetWithRequestParameters(requestUrl, 0, 0, headers, requestParameters);
    }

    public static String doGetWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        String result = null;
        HttpURLConnection httpURLConnection = null;
        try {
            if (MapUtils.isNotEmpty(requestParameters)) {
                requestUrl = requestUrl + "?" + buildQueryString(requestParameters);
            }
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.GET, readTimeout, connectTimeout);
            setRequestProperties(httpURLConnection, headers);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                httpURLConnection.disconnect();
                return doGetWithRequestParameters(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestParameters);
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
            } else {
                Validate.isTrue(false, "访问链接(" + requestUrl + ")出错，响应状态码：" + responseCode);
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

    public static String doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> requestParameters) throws IOException {
        return doPostWithRequestParameters(requestUrl, readTimeout, connectTimeout, null, requestParameters);
    }

    public static String doPostWithRequestParameters(String requestUrl, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        return doPostWithRequestParameters(requestUrl, 0, 0, headers, requestParameters);
    }

    public static String doPostWithRequestParameters(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, String> requestParameters) throws IOException {
        String result = null;
        HttpURLConnection httpURLConnection =  null;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout);
            setRequestProperties(httpURLConnection, headers);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            String requestBody = buildQueryString(requestParameters);
            httpURLConnection.getOutputStream().write(requestBody.getBytes(Constants.CHARSET_UTF_8));
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                httpURLConnection.disconnect();
                return doPostWithRequestParameters(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestParameters);
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
            } else {
                Validate.isTrue(false, "访问链接(" + requestUrl + ")出错，响应状态码：" + responseCode);
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

    public static String doPostWithRequestParametersAndFiles(String requestUrl, int readTimeout, int connectTimeout, Map<String, Object> requestParameters) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, readTimeout, connectTimeout, null, requestParameters);
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, Map<String, String> headers, Map<String, Object> requestParameters) throws IOException {
        return doPostWithRequestParametersAndFiles(requestUrl, 0, 0, headers, requestParameters);
    }

    public static String doPostWithRequestParametersAndFiles(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, Map<String, Object> requestParameters) throws IOException {
        String result = null;
        HttpURLConnection httpURLConnection = null;
        httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout);
        try {
            if (headers == null) {
                headers = new HashMap<String, String>();
                headers.put("Content-Type", "multipart/form-data;boundary=" + boundary);
            }
            setRequestProperties(httpURLConnection, headers);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            Set<Map.Entry<String, Object>> entries = requestParameters.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                outputStream.write((twoHyphens + boundary + enterNewline).getBytes(Constants.CHARSET_UTF_8));
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    outputStream.write(("Content-Disposition: form-data; name=\"" + key + "\"" + enterNewline + enterNewline).getBytes(Constants.CHARSET_UTF_8));
                    outputStream.write((value.toString()).getBytes(Constants.CHARSET_UTF_8));
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
                    outputStream.write(("Content-Disposition: form-data; " + "name=\"" + key + "\";filename=\"" + fileName + "\"" + enterNewline).getBytes(Constants.CHARSET_UTF_8));
                    outputStream.write(("Content-Type:application/octet-stream" + enterNewline + enterNewline).getBytes(Constants.CHARSET_UTF_8));
                    int length = 0;
                    byte[] buffer = new byte[1024];
                    while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
                        outputStream.write(buffer, 0, length);
                    }
                    inputStream.close();
                }
                outputStream.write(enterNewline.getBytes(Constants.CHARSET_UTF_8));
            }
            outputStream.write((twoHyphens + boundary + twoHyphens).getBytes(Constants.CHARSET_UTF_8));
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                httpURLConnection.disconnect();
                return doPostWithRequestParametersAndFiles(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestParameters);
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
            } else {
                Validate.isTrue(false, "访问链接(" + requestUrl + ")出错，响应状态码：" + responseCode);
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
        return doPostWithRequestBody(requestUrl, null, requestBody);
    }

    public static String doPostWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, String requestBody) throws IOException {
        return doPostWithRequestBody(requestUrl, readTimeout, connectTimeout, null, requestBody);
    }

    public static String doPostWithRequestBody(String requestUrl, Map<String, String> headers, String requestBody) throws IOException {
        return doPostWithRequestBody(requestUrl, 0, 0, headers, requestBody);
    }

    public static String doPostWithRequestBody(String requestUrl, int readTimeout, int connectTimeout, Map<String, String> headers, String requestBody) throws IOException {
        String result = null;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, RequestMethod.POST, readTimeout, connectTimeout);
            setRequestProperties(httpURLConnection, headers);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(requestBody.getBytes(Constants.CHARSET_UTF_8));
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                httpURLConnection.disconnect();
                return doPostWithRequestBody(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), readTimeout, connectTimeout, headers, requestBody);
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
            } else {
                Validate.isTrue(false, "访问链接(" + requestUrl + ")出错，响应状态码：" + responseCode);
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return result;
    }

    public static void setRequestProperties(HttpURLConnection httpURLConnection, Map<String, String> headers) {
        if (MapUtils.isNotEmpty(headers)) {
            Set<Map.Entry<String, String>> entries = headers.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        } else {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        }
    }

    public static HttpURLConnection buildHttpURLConnection(String requestUrl, String requestMethod, int readTimeout, int connectTimeout) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(requestMethod);
        httpURLConnection.setReadTimeout(readTimeout);
        httpURLConnection.setConnectTimeout(connectTimeout);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    public static String buildQueryString(Map<String, String> requestParameters) {
        List<String> requestParameterPairs = new ArrayList<String>();
        Set<Map.Entry<String, String>> entries = requestParameters.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            requestParameterPairs.add(entry.getKey() + "=" + entry.getValue());
        }
        return StringUtils.join(requestParameterPairs, "&");
    }

    public static String inputStreamToString(InputStream inputStream) throws IOException {
        int length = 0;
        byte[] buffer = new byte[1024];
        StringBuffer result = new StringBuffer();
        while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
            result.append(new String(buffer, 0, length, Constants.CHARSET_UTF_8));
        }
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
}
