package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class ProxyUtils {
    private static RestTemplate REST_TEMPLATE;

    public static RestTemplate obtainRestTemplate() {
        if (REST_TEMPLATE == null) {
            REST_TEMPLATE = ApplicationHandler.getBean(RestTemplate.class);
        }
        return REST_TEMPLATE;
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

    public static String doGetOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return WebUtils.doGetWithRequestParameters(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters);
    }

    public static String doGetOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return WebUtils.doGetWithRequestParameters(SystemPartitionUtils.getUrl(serviceName, controllerName, actionName), requestParameters);
    }

    public static String doPostOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return WebUtils.doPostWithRequestParameters(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters);
    }

    public static String doPostOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return WebUtils.doPostWithRequestParameters(SystemPartitionUtils.getUrl(serviceName, controllerName, actionName), requestParameters);
    }

    public static String doPostOriginalWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return WebUtils.doPostWithRequestParametersAndFiles(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters);
    }

    public static String doPostOriginalWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return WebUtils.doPostWithRequestParametersAndFiles(SystemPartitionUtils.getUrl(serviceName, controllerName, actionName), requestParameters);
    }

    public static String doPostOriginalWithRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) throws IOException {
        return WebUtils.doPostWithRequestBody(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestBody);
    }

    public static String doPostOriginalWithRequestBody(String serviceName, String controllerName, String actionName, String requestBody) throws IOException {
        return WebUtils.doPostWithRequestBody(SystemPartitionUtils.getUrl(serviceName, controllerName, actionName), requestBody);
    }

    public static ApiRest doGetWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return ApiRest.fromJson(WebUtils.doGetWithRequestParameters(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters));
    }

    public static ApiRest doGetWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return ApiRest.fromJson(WebUtils.doGetWithRequestParameters(SystemPartitionUtils.getUrl(serviceName, controllerName, actionName), requestParameters));
    }

    public static ApiRest doPostWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return ApiRest.fromJson(WebUtils.doPostWithRequestParameters(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters));
    }

    public static ApiRest doPostWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return ApiRest.fromJson(WebUtils.doPostWithRequestParameters(SystemPartitionUtils.getUrl(serviceName, controllerName, actionName), requestParameters));
    }

    public static ApiRest doPostWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(WebUtils.doPostWithRequestParametersAndFiles(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters));
    }

    public static ApiRest doPostWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(WebUtils.doPostWithRequestParametersAndFiles(SystemPartitionUtils.getUrl(serviceName, controllerName, actionName), requestParameters));
    }

    public static ApiRest doPostWithRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) throws IOException {
        return ApiRest.fromJson(WebUtils.doPostWithRequestBody(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestBody));
    }

    public static ApiRest doPostWithRequestBody(String serviceName, String controllerName, String actionName, String requestBody) throws IOException {
        return ApiRest.fromJson(WebUtils.doPostWithRequestBody(SystemPartitionUtils.getUrl(serviceName, controllerName, actionName), requestBody));
    }
}
