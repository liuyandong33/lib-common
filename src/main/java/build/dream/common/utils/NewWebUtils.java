package build.dream.common.utils;

import build.dream.common.beans.WebResult;
import build.dream.common.constants.Constants;
import build.dream.common.models.newweb.PostModel;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.*;

/**
 * Created by liuyandong on 2017/7/15.
 */
public class NewWebUtils {
    public static WebResult doPost(PostModel postModel) throws IOException {
        String requestUrl = postModel.getRequestUrl();
        int readTimeout = postModel.getReadTimeout();
        int connectTimeout = postModel.getConnectTimeout();
        Map<String, String> headers = postModel.getHeaders();
        InputStream requestBody = postModel.getRequestBody();
        SSLSocketFactory sslSocketFactory = postModel.getSslSocketFactory();
        Proxy proxy = postModel.getProxy();
        InputStream inputStream = null;
        Map<String, List<String>> headerFields = null;
        HttpURLConnection httpURLConnection = null;
        int responseCode;
        try {
            httpURLConnection = buildHttpURLConnection(requestUrl, Constants.REQUEST_METHOD_POST, readTimeout, connectTimeout, sslSocketFactory, proxy);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            Set<Map.Entry<String, String>> entries = headers.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            if (Objects.nonNull(requestBody)) {
                byte[] buffer = new byte[1024];
                int length = 0;
                OutputStream outputStream = httpURLConnection.getOutputStream();
                while ((length = requestBody.read(buffer, 0, 1024)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
            }

            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                httpURLConnection.disconnect();
                return doPost(postModel);
            } else if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_ACCEPTED) {
                headerFields = httpURLConnection.getHeaderFields();
                inputStream = httpURLConnection.getInputStream();
                httpURLConnection.disconnect();
            } else {
                inputStream = httpURLConnection.getErrorStream();
                headerFields = httpURLConnection.getHeaderFields();
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            if (Objects.nonNull(httpURLConnection)) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
        return new WebResult(inputStream, headerFields, responseCode);
    }

    public static HttpURLConnection buildHttpURLConnection(String requestUrl, String requestMethod, int readTimeout, int connectTimeout, SSLSocketFactory sslSocketFactory, Proxy proxy) throws IOException {
        HttpURLConnection httpURLConnection = null;
        if (Objects.nonNull(sslSocketFactory)) {
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
        if (Objects.nonNull(proxy)) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        return httpURLConnection;
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        PostModel postModel = PostModel.builder()
                .requestUrl("http://www.smartpos.top/portal/tenantWebService/showTenantInfo")
                .headers(headers)
                .build();
        WebResult webResult = doPost(postModel);
        System.out.println(webResult.stringResult());
        System.out.println();
    }
}
