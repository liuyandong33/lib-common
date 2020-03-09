package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.fallbacks.MicroServiceCallerFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class MicroServiceCaller {
    private static RestTemplate restTemplate;
    private MicroServiceCallerFallback microServiceCallerFallback;

    public MicroServiceCallerFallback getMicroServiceCallerFallback() {
        return microServiceCallerFallback;
    }

    public void setMicroServiceCallerFallback(MicroServiceCallerFallback microServiceCallerFallback) {
        this.microServiceCallerFallback = microServiceCallerFallback;
    }

    private RestTemplate obtainRestTemplate() {
        if (Objects.isNull(restTemplate)) {
            restTemplate = ApplicationHandler.getBean(RestTemplate.class);
        }
        return restTemplate;
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
    @HystrixCommand(fallbackMethod = "doGetOriginalWithRequestParametersFallback")
    public String doGetOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    public String doGetOriginalWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return microServiceCallerFallback.doGetOriginalWithRequestParametersFallback(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doGetOriginalWithRequestParametersFallback")
    public String doGetOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    public String doGetOriginalWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return microServiceCallerFallback.doGetOriginalWithRequestParametersFallback(serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithRequestParametersFallback")
    public String doPostOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestParameters), String.class);
    }

    public String doPostOriginalWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return microServiceCallerFallback.doPostOriginalWithRequestParametersFallback(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithRequestParametersFallback")
    public String doPostOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestParameters), String.class);
    }

    public String doPostOriginalWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return microServiceCallerFallback.doPostOriginalWithRequestParametersFallback(serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithRequestParametersAndFilesFallback")
    public String doPostOriginalWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildMultipartHttpEntity(requestParameters), String.class);
    }

    public String doPostOriginalWithRequestParametersAndFilesFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return microServiceCallerFallback.doPostOriginalWithRequestParametersAndFilesFallback(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithRequestParametersAndFilesFallback")
    public String doPostOriginalWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildMultipartHttpEntity(requestParameters), String.class);
    }

    public String doPostOriginalWithRequestParametersAndFilesFallback(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return microServiceCallerFallback.doPostOriginalWithRequestParametersAndFilesFallback(serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithFormRequestBodyFallback")
    public String doPostOriginalWithFormRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestBody), String.class);
    }

    public String doPostOriginalWithFormRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return microServiceCallerFallback.doPostOriginalWithFormRequestBodyFallback(partitionCode, serviceName, controllerName, actionName, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithFormRequestBodyFallback")
    public String doPostOriginalWithFormRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestBody), String.class);
    }

    public String doPostOriginalWithFormRequestBodyFallback(String serviceName, String controllerName, String actionName, String requestBody) {
        return microServiceCallerFallback.doPostOriginalWithFormRequestBodyFallback(serviceName, controllerName, actionName, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithJsonRequestBodyFallback")
    public String doPostOriginalWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    public String doPostOriginalWithJsonRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return microServiceCallerFallback.doPostOriginalWithJsonRequestBodyFallback(partitionCode, serviceName, controllerName, actionName, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithJsonRequestBodyFallback")
    public String doPostOriginalWithJsonRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    public String doPostOriginalWithJsonRequestBodyFallback(String serviceName, String controllerName, String actionName, String requestBody) {
        return microServiceCallerFallback.doPostOriginalWithJsonRequestBodyFallback(serviceName, controllerName, actionName, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithJsonRequestBodyFallback")
    public String doPostOriginalWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName, queryParams), ProxyUtils.buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    public String doPostOriginalWithJsonRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return microServiceCallerFallback.doPostOriginalWithJsonRequestBodyFallback(partitionCode, serviceName, controllerName, actionName, queryParams, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostOriginalWithJsonRequestBodyFallback")
    public String doPostOriginalWithJsonRequestBody(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName, queryParams), ProxyUtils.buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    public String doPostOriginalWithJsonRequestBodyFallback(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return microServiceCallerFallback.doPostOriginalWithJsonRequestBodyFallback(serviceName, controllerName, actionName, queryParams, requestBody);
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
    @HystrixCommand(fallbackMethod = "doGetWithRequestParametersFallback")
    public ApiRest doGetWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doGetOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    public ApiRest doGetWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return microServiceCallerFallback.doGetWithRequestParametersFallback(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doGetWithRequestParametersFallback")
    public ApiRest doGetWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doGetOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters));
    }

    public ApiRest doGetWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return microServiceCallerFallback.doGetWithRequestParametersFallback(serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostWithRequestParametersFallback")
    public ApiRest doPostWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doPostOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    public ApiRest doPostWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return microServiceCallerFallback.doPostWithRequestParametersFallback(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostWithRequestParametersFallback")
    public ApiRest doPostWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doPostOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters));
    }

    public ApiRest doPostWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return microServiceCallerFallback.doPostWithRequestParametersFallback(serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostWithRequestParametersAndFilesFallback")
    public ApiRest doPostWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(doPostOriginalWithRequestParametersAndFiles(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    public ApiRest doPostWithRequestParametersAndFilesFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return microServiceCallerFallback.doPostWithRequestParametersAndFilesFallback(partitionCode, serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostWithRequestParametersAndFilesFallback")
    public ApiRest doPostWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(doPostOriginalWithRequestParametersAndFiles(serviceName, controllerName, actionName, requestParameters));
    }

    public ApiRest doPostWithRequestParametersAndFilesFallback(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return microServiceCallerFallback.doPostWithRequestParametersAndFilesFallback(serviceName, controllerName, actionName, requestParameters);
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
    @HystrixCommand(fallbackMethod = "doPostWithFormRequestBodyFallback")
    public ApiRest doPostWithFormRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithFormRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody));
    }

    public ApiRest doPostWithFormRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return microServiceCallerFallback.doPostWithFormRequestBodyFallback(partitionCode, serviceName, controllerName, actionName, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostWithFormRequestBodyFallback")
    public ApiRest doPostWithFormRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithFormRequestBody(serviceName, controllerName, actionName, requestBody));
    }

    public ApiRest doPostWithFormRequestBodyFallback(String serviceName, String controllerName, String actionName, String requestBody) {
        return microServiceCallerFallback.doPostWithFormRequestBodyFallback(serviceName, controllerName, actionName, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostWithJsonRequestBodyFallback")
    public ApiRest doPostWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody));
    }

    public ApiRest doPostWithJsonRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return microServiceCallerFallback.doPostWithJsonRequestBodyFallback(partitionCode, serviceName, controllerName, actionName, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostWithJsonRequestBodyFallback")
    public ApiRest doPostWithJsonRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(serviceName, controllerName, actionName, requestBody));
    }

    public ApiRest doPostWithJsonRequestBodyFallback(String serviceName, String controllerName, String actionName, String requestBody) {
        return microServiceCallerFallback.doPostWithJsonRequestBodyFallback(serviceName, controllerName, actionName, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostWithJsonRequestBodyFallback")
    public ApiRest doPostWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, queryParams, requestBody));
    }

    public ApiRest doPostWithJsonRequestBodyFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return microServiceCallerFallback.doPostWithJsonRequestBodyFallback(partitionCode, serviceName, controllerName, actionName, queryParams, requestBody);
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
    @HystrixCommand(fallbackMethod = "doPostWithJsonRequestBodyFallback")
    public ApiRest doPostWithJsonRequestBody(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(serviceName, controllerName, actionName, queryParams, requestBody));
    }

    public ApiRest doPostWithJsonRequestBodyFallback(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return microServiceCallerFallback.doPostWithJsonRequestBodyFallback(serviceName, controllerName, actionName, queryParams, requestBody);
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
    public ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForEntity(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), byte[].class);
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
    public ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForEntity(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName, requestParameters), byte[].class);
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
    public ResponseEntity<byte[]> doPostOrdinaryWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForEntity(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestParameters), byte[].class);
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
    public ResponseEntity<byte[]> doPostOrdinaryWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForEntity(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestParameters), byte[].class);
    }
}
