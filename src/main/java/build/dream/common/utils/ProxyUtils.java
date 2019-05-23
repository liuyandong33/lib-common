package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class ProxyUtils {
    private static RestTemplate restTemplate;
    private static HttpHeaders applicationFormUrlEncodedHttpHeaders;
    private static HttpHeaders multipartHttpHeaders;
    private static HttpHeaders applicationJsonUtf8HttpHeaders;

    /**
     * 获取RestTemplate
     *
     * @return
     */
    public static RestTemplate obtainRestTemplate() {
        if (restTemplate == null) {
            restTemplate = ApplicationHandler.getBean(RestTemplate.class);
        }
        return restTemplate;
    }

    /**
     * 获取请求头Content-Type=application/x-www-form-urlencoded;charset=UTF-8
     *
     * @return
     */
    public static HttpHeaders obtainApplicationFormUrlEncodedHttpHeaders() {
        if (MapUtils.isEmpty(applicationFormUrlEncodedHttpHeaders)) {
            applicationFormUrlEncodedHttpHeaders = new HttpHeaders();
            applicationFormUrlEncodedHttpHeaders.add(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=" + Constants.CHARSET_NAME_UTF_8);
        }
        return applicationFormUrlEncodedHttpHeaders;
    }

    /**
     * 获取上传文件请求头
     *
     * @return
     */
    public static HttpHeaders obtainMultipartHttpHeaders() {
        if (MapUtils.isEmpty(multipartHttpHeaders)) {
            multipartHttpHeaders = new HttpHeaders();
            multipartHttpHeaders.add(Constants.CONTENT_TYPE, "multipart/form-data;boundary=" + WebUtils.BOUNDARY);
        }
        return multipartHttpHeaders;
    }

    /**
     * 获取请求头Content-Type=application/json;charset=UTF-8
     *
     * @return
     */
    public static HttpHeaders obtainApplicationJsonUtf8HttpHeaders() {
        if (MapUtils.isEmpty(applicationJsonUtf8HttpHeaders)) {
            applicationJsonUtf8HttpHeaders = new HttpHeaders();
            applicationJsonUtf8HttpHeaders.add(Constants.CONTENT_TYPE, "application/json;charset=" + Constants.CHARSET_NAME_UTF_8);
        }
        return applicationJsonUtf8HttpHeaders;
    }

    /**
     * 拼接url
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @return
     */
    public static String obtainUrl(String partitionCode, String serviceName, String controllerName, String actionName) {
        String deploymentEnvironment = ConfigurationUtils.getConfiguration(Constants.DEPLOYMENT_ENVIRONMENT);
        StringBuilder stringBuilder = new StringBuilder("http://");
        stringBuilder.append(deploymentEnvironment).append("-");
        if (StringUtils.isNotBlank(partitionCode)) {
            stringBuilder.append(partitionCode).append("-");
        }
        stringBuilder.append(serviceName).append("/").append(controllerName).append("/").append(actionName);
        return stringBuilder.toString();
    }

    /**
     * 拼接url
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static String obtainUrl(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        String url = obtainUrl(partitionCode, serviceName, controllerName, actionName);
        if (MapUtils.isNotEmpty(requestParameters)) {
            url = url + "?" + WebUtils.buildQueryStringOriginal(requestParameters);
        }
        return url;
    }

    /**
     * 构建请求体Content-Type=application/x-www-form-urlencoded;charset=UTF-8
     *
     * @param requestParameters
     * @return
     */
    public static HttpEntity<String> buildApplicationFormUrlEncodedHttpEntity(Map<String, String> requestParameters) {
        String requestBody = null;
        if (MapUtils.isNotEmpty(requestParameters)) {
            requestBody = WebUtils.buildRequestBody(requestParameters, Constants.CHARSET_NAME_UTF_8);
        }
        return new HttpEntity<String>(requestBody, obtainApplicationFormUrlEncodedHttpHeaders());
    }

    /**
     * 构建请求体Content-Type=application/x-www-form-urlencoded;charset=UTF-8
     *
     * @param requestBody
     * @return
     */
    public static HttpEntity<String> buildApplicationFormUrlEncodedHttpEntity(String requestBody) {
        return new HttpEntity<String>(UrlUtils.encode(requestBody, Constants.CHARSET_UTF_8), obtainApplicationFormUrlEncodedHttpHeaders());
    }

    /**
     * 构建请求体Content-Type=application/json;charset=UTF-8
     *
     * @param requestBody
     * @return
     */
    public static HttpEntity<String> buildApplicationJsonUtf8HttpEntity(String requestBody) {
        return new HttpEntity<String>(UrlUtils.encode(requestBody, Constants.CHARSET_UTF_8), obtainApplicationJsonUtf8HttpHeaders());
    }

    /**
     * 构建上传文件请求体
     *
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public static HttpEntity<byte[]> buildMultipartHttpEntity(Map<String, Object> requestParameters) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        WebUtils.writeFormData(byteArrayOutputStream, requestParameters, Constants.CHARSET_NAME_UTF_8);
        HttpEntity<byte[]> httpEntity = new HttpEntity<byte[]>(byteArrayOutputStream.toByteArray(), obtainMultipartHttpHeaders());
        byteArrayOutputStream.close();
        return httpEntity;
    }

    /**
     * GET 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static String doGetOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    /**
     * GET 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static String doGetOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForObject(obtainUrl(null, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static String doPostOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildApplicationFormUrlEncodedHttpEntity(requestParameters), String.class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static String doPostOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildApplicationFormUrlEncodedHttpEntity(requestParameters), String.class);
    }

    /**
     * POST 请求调用分区服务，可以上传文件
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public static String doPostOriginalWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildMultipartHttpEntity(requestParameters), String.class);
    }

    /**
     * POST 请求调用分区服务，可以上传文件
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public static String doPostOriginalWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildMultipartHttpEntity(requestParameters), String.class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public static String doPostOriginalWithFormRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildApplicationFormUrlEncodedHttpEntity(requestBody), String.class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public static String doPostOriginalWithFormRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildApplicationFormUrlEncodedHttpEntity(requestBody), String.class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public static String doPostOriginalWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public static String doPostOriginalWithJsonRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    /**
     * GET 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static ApiRest doGetWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doGetOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * GET 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static ApiRest doGetWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doGetOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static ApiRest doPostWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doPostOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static ApiRest doPostWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doPostOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用分区服务，可以上传文件
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public static ApiRest doPostWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(doPostOriginalWithRequestParametersAndFiles(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用公共服务，可以上传文件
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public static ApiRest doPostWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(doPostOriginalWithRequestParametersAndFiles(serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public static ApiRest doPostWithFormRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithFormRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody));
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public static ApiRest doPostWithFormRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithFormRequestBody(serviceName, serviceName, controllerName, actionName, requestBody));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public static ApiRest doPostWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody));
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public static ApiRest doPostWithJsonRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(serviceName, serviceName, controllerName, actionName, requestBody));
    }

    /**
     * GET 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForEntity(obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), byte[].class);
    }

    /**
     * GET 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForEntity(obtainUrl(null, serviceName, controllerName, actionName, requestParameters), byte[].class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static ResponseEntity<byte[]> doPostOrdinaryWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForEntity(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildApplicationFormUrlEncodedHttpEntity(requestParameters), byte[].class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public static ResponseEntity<byte[]> doPostOrdinaryWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForEntity(obtainUrl(null, serviceName, controllerName, actionName), buildApplicationFormUrlEncodedHttpEntity(requestParameters), byte[].class);
    }

    /**
     * GET 请求指定url
     *
     * @param url
     * @return
     */
    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String url) {
        return obtainRestTemplate().getForEntity(url, byte[].class);
    }
}
