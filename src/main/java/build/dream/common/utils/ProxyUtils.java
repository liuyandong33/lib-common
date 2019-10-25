package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class ProxyUtils {
    private static MicroServiceCaller microServiceCaller;
    private static HttpHeaders applicationFormUrlEncodedHttpHeaders;
    private static HttpHeaders multipartHttpHeaders;
    private static HttpHeaders applicationJsonUtf8HttpHeaders;

    public static MicroServiceCaller obtainMicroServiceCaller() {
        if (Objects.isNull(microServiceCaller)) {
            microServiceCaller = ApplicationHandler.getBean(MicroServiceCaller.class);
        }
        return microServiceCaller;
    }

    /**
     * 获取请求头Content-Type=application/x-www-form-urlencoded;charset=UTF-8
     *
     * @return
     */
    public static HttpHeaders obtainApplicationFormUrlEncodedHttpHeaders() {
        if (MapUtils.isEmpty(applicationFormUrlEncodedHttpHeaders)) {
            applicationFormUrlEncodedHttpHeaders = new HttpHeaders();
            applicationFormUrlEncodedHttpHeaders.add(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_APPLICATION_FORM_URLENCODED_UTF8);
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
            applicationJsonUtf8HttpHeaders.add(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        }
        return applicationJsonUtf8HttpHeaders;
    }

    public static String obtainApplicationName(String partitionCode, String serviceName) {
        String deploymentEnvironment = ConfigurationUtils.getConfiguration(Constants.DEPLOYMENT_ENVIRONMENT);
        if (StringUtils.isBlank(partitionCode)) {
            return deploymentEnvironment + "-" + serviceName;
        }
        return deploymentEnvironment + "-" + partitionCode + "-" + serviceName;
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
        return "http://" + obtainApplicationName(partitionCode, serviceName) + "/" + controllerName + "/" + actionName;
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
        return new HttpEntity<String>(requestBody, obtainApplicationFormUrlEncodedHttpHeaders());
    }

    /**
     * 构建请求体Content-Type=application/json;charset=UTF-8
     *
     * @param requestBody
     * @return
     */
    public static HttpEntity<String> buildApplicationJsonUtf8HttpEntity(String requestBody) {
        return new HttpEntity<String>(requestBody, obtainApplicationJsonUtf8HttpHeaders());
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
        return obtainMicroServiceCaller().doGetOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doGetOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostOriginalWithRequestParametersAndFiles(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostOriginalWithRequestParametersAndFiles(serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostOriginalWithFormRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody);
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
        return obtainMicroServiceCaller().doPostOriginalWithFormRequestBody(serviceName, controllerName, actionName, requestBody);
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
        return obtainMicroServiceCaller().doPostOriginalWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody);
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
        return obtainMicroServiceCaller().doPostOriginalWithJsonRequestBody(serviceName, controllerName, actionName, requestBody);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param queryParams
     * @param requestBody
     * @return
     */
    public static String doPostOriginalWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return obtainMicroServiceCaller().doPostOriginalWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, queryParams, requestBody);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param queryParams
     * @param requestBody
     * @return
     */
    public static String doPostOriginalWithJsonRequestBody(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return obtainMicroServiceCaller().doPostOriginalWithJsonRequestBody(serviceName, controllerName, actionName, queryParams, requestBody);
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
        return obtainMicroServiceCaller().doGetWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doGetWithRequestParameters(serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostWithRequestParameters(serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostWithRequestParametersAndFiles(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostWithRequestParametersAndFiles(serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostWithFormRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody);
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
        return obtainMicroServiceCaller().doPostWithFormRequestBody(serviceName, controllerName, actionName, requestBody);
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
        return obtainMicroServiceCaller().doPostWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody);
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
        return obtainMicroServiceCaller().doPostWithJsonRequestBody(serviceName, controllerName, actionName, requestBody);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param queryParams
     * @param requestBody
     * @return
     */
    public static ApiRest doPostWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return obtainMicroServiceCaller().doPostWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param queryParams
     * @param requestBody
     * @return
     */
    public static ApiRest doPostWithJsonRequestBody(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return obtainMicroServiceCaller().doPostWithJsonRequestBody(serviceName, controllerName, actionName, queryParams, requestBody);
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
        return obtainMicroServiceCaller().doGetOrdinaryWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doGetOrdinaryWithRequestParameters(serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostOrdinaryWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
        return obtainMicroServiceCaller().doPostOrdinaryWithRequestParameters(serviceName, controllerName, actionName, requestParameters);
    }
}
