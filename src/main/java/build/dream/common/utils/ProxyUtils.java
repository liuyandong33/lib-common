package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class ProxyUtils {
    private static RestTemplate REST_TEMPLATE;
    private static HttpHeaders HTTP_HEADERS;
    private static HttpHeaders MULTIPART_HTTP_HEADERS;

    public static RestTemplate obtainRestTemplate() {
        if (REST_TEMPLATE == null) {
            REST_TEMPLATE = ApplicationHandler.getBean(RestTemplate.class);
        }
        return REST_TEMPLATE;
    }

    public static HttpHeaders obtainHttpHeaders() {
        if (MapUtils.isEmpty(HTTP_HEADERS)) {
            HTTP_HEADERS = new HttpHeaders();
            HTTP_HEADERS.add(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + Constants.CHARSET_NAME_UTF_8);
        }
        return HTTP_HEADERS;
    }

    public static HttpHeaders obtainMultipartHttpHeaders() {
        if (MapUtils.isEmpty(MULTIPART_HTTP_HEADERS)) {
            MULTIPART_HTTP_HEADERS = new HttpHeaders();
            MULTIPART_HTTP_HEADERS.add(Constants.CONTENT_TYPE, "multipart/form-data;boundary=" + WebUtils.BOUNDARY);
        }
        return MULTIPART_HTTP_HEADERS;
    }

    public static String obtainUrl(String partitionCode, String serviceName, String controllerName, String actionName) throws IOException {
        String deploymentEnvironment = ConfigurationUtils.getConfiguration(Constants.DEPLOYMENT_ENVIRONMENT);
        StringBuilder stringBuilder = new StringBuilder("http://");
        stringBuilder.append(deploymentEnvironment).append("-");
        if (StringUtils.isNotBlank(partitionCode)) {
            stringBuilder.append(partitionCode).append("-");
        }
        stringBuilder.append(serviceName).append("/").append(controllerName).append("/").append(actionName);
        return stringBuilder.toString();
    }

    public static String obtainUrl(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        String url = obtainUrl(partitionCode, serviceName, controllerName, actionName);
        if (MapUtils.isNotEmpty(requestParameters)) {
            url = url + "?" + WebUtils.buildQueryString(requestParameters, Constants.CHARSET_NAME_UTF_8);
        }
        return url;
    }

    public static HttpEntity<String> buildHttpEntity(Map<String, String> requestParameters) throws UnsupportedEncodingException {
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

    public static String doGetOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return obtainRestTemplate().getForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    public static String doGetOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return obtainRestTemplate().getForObject(obtainUrl(null, serviceName, controllerName, actionName, requestParameters), String.class, requestParameters);
    }

    public static String doPostOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildHttpEntity(requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildHttpEntity(requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildMultipartHttpEntity(requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildMultipartHttpEntity(requestParameters), String.class);
    }

    public static String doPostOriginalWithRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), requestBody, String.class);
    }

    public static String doPostOriginalWithRequestBody(String serviceName, String controllerName, String actionName, String requestBody) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), requestBody, String.class);
    }

    public static ApiRest doGetWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return obtainRestTemplate().getForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), ApiRest.class, requestParameters);
    }

    public static ApiRest doGetWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return obtainRestTemplate().getForObject(obtainUrl(null, serviceName, controllerName, actionName, requestParameters), ApiRest.class, requestParameters);
    }

    public static ApiRest doPostWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildHttpEntity(requestParameters), ApiRest.class);
    }

    public static ApiRest doPostWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildHttpEntity(requestParameters), ApiRest.class);
    }

    public static ApiRest doPostWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), buildMultipartHttpEntity(requestParameters), ApiRest.class);
    }

    public static ApiRest doPostWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), buildMultipartHttpEntity(requestParameters), ApiRest.class);
    }

    public static ApiRest doPostWithRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(partitionCode, serviceName, controllerName, actionName), requestBody, ApiRest.class);
    }

    public static ApiRest doPostWithRequestBody(String serviceName, String controllerName, String actionName, String requestBody) throws IOException {
        return obtainRestTemplate().postForObject(obtainUrl(null, serviceName, controllerName, actionName), requestBody, ApiRest.class);
    }
}
