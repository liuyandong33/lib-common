package build.dream.common.fallbacks;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.ErrorConstants;
import build.dream.common.exceptions.Error;
import build.dream.common.utils.ProxyUtils;

import java.io.IOException;
import java.util.Map;

public class MicroServiceCallerFallback {
    public String doGetOriginalWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(partitionCode, serviceName) + ")异常！";
    }

    public String doGetOriginalWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(partitionCode, serviceName) + ")异常！";
    }

    public String doPostOriginalWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithRequestParametersAndFilesFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithRequestParametersAndFilesFallback(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithFormRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithFormRequestBodyFallback(String serviceName, String controllerName, String actionName, String requestBody) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithJsonRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithJsonRequestBodyFallback(String serviceName, String controllerName, String actionName, String requestBody) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithJsonRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithJsonRequestBodyFallback(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public ApiRest doGetWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public static ApiRest doGetWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithRequestParametersAndFilesFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithRequestParametersAndFilesFallback(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithFormRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithFormRequestBodyFallback(String serviceName, String controllerName, String actionName, String requestBody) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithJsonRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithJsonRequestBodyFallback(String serviceName, String controllerName, String actionName, String requestBody) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithJsonRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }

    public ApiRest doPostWithJsonRequestBodyFallback(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        Error error = new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！");
        return ApiRest.builder().error(error).build();
    }
}
