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
    private static HttpHeaders httpHeaders;
    private static HttpHeaders multipartHttpHeaders;

    public static RestTemplate obtainRestTemplate() {
        if (restTemplate == null) {
            restTemplate = ApplicationHandler.getBean(RestTemplate.class);
        }
        return restTemplate;
    }

    public static HttpHeaders obtainHttpHeaders() {
        if (MapUtils.isEmpty(httpHeaders)) {
            httpHeaders = new HttpHeaders();
            httpHeaders.add(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + Constants.CHARSET_NAME_UTF_8);
        }
        return httpHeaders;
    }

    public static HttpHeaders obtainMultipartHttpHeaders() {
        if (MapUtils.isEmpty(multipartHttpHeaders)) {
            multipartHttpHeaders = new HttpHeaders();
            multipartHttpHeaders.add(Constants.CONTENT_TYPE, "multipart/form-data;boundary=" + WebUtils.BOUNDARY);
        }
        return multipartHttpHeaders;
    }

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

    public static String obtainUrl(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        String url = obtainUrl(partitionCode, serviceName, controllerName, actionName);
        if (MapUtils.isNotEmpty(requestParameters)) {
            url = url + "?" + WebUtils.buildQueryStringOriginal(requestParameters);
        }
        return url;
    }

    public static HttpEntity<String> buildHttpEntity(Map<String, String> requestParameters) {
        String requestBody = null;
        if (MapUtils.isNotEmpty(requestParameters)) {
            requestBody = WebUtils.buildRequestBody(requestParameters, Constants.CHARSET_NAME_UTF_8);
        }
        return new HttpEntity<String>(requestBody, obtainHttpHeaders());
    }

    public static HttpEntity<byte[]> buildMultipartHttpEntity(Map<String, Object> requestParameters) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        WebUtils.writeFormData(byteArrayOutputStream, requestParameters, Constants.CHARSET_NAME_UTF_8);
        HttpEntity<byte[]> httpEntity = new HttpEntity<byte[]>(byteArrayOutputStream.toByteArray(), obtainMultipartHttpHeaders());
        byteArrayOutputStream.close();
        return httpEntity;
    }

    public static String doGetOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    public static String doGetOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForObject(obtainUrl(null, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildHttpEntity(requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildHttpEntity(requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildMultipartHttpEntity(requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildMultipartHttpEntity(requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), requestBody, String.class);
    }

    public static String doPostOriginalWithRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), requestBody, String.class);
    }

    public static ApiRest doGetWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doGetOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    public static ApiRest doGetWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doGetOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters));
    }

    public static ApiRest doPostWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doPostOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    public static ApiRest doPostWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doPostOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters));
    }

    public static ApiRest doPostWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(doPostOriginalWithRequestParametersAndFiles(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    public static ApiRest doPostWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(doPostOriginalWithRequestParametersAndFiles(serviceName, controllerName, actionName, requestParameters));
    }

    public static ApiRest doPostWithRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody));
    }

    public static ApiRest doPostWithRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithRequestBody(serviceName, serviceName, controllerName, actionName, requestBody));
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForEntity(obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), byte[].class);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForEntity(obtainUrl(null, serviceName, controllerName, actionName, requestParameters), byte[].class);
    }

    public static ResponseEntity<byte[]> doPostOrdinaryWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForEntity(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildHttpEntity(requestParameters), byte[].class);
    }

    public static ResponseEntity<byte[]> doPostOrdinaryWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForEntity(obtainUrl(null, serviceName, controllerName, actionName), buildHttpEntity(requestParameters), byte[].class);
    }

    public static ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String url) {
        return obtainRestTemplate().getForEntity(url, byte[].class);
    }
}
