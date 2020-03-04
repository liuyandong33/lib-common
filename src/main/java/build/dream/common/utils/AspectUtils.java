package build.dream.common.utils;

import build.dream.common.annotations.ApiRestAction;
import build.dream.common.api.ApiRest;
import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.constants.Constants;
import build.dream.common.constants.ErrorConstants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.exceptions.Error;
import build.dream.common.models.BasicModel;
import build.dream.common.models.OAuthBasicModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class AspectUtils {
    private static Map<Class<?>, Object> serviceMap = new ConcurrentHashMap<Class<?>, Object>();
    private static final String PLATFORM_PRIVATE_KEY = ConfigurationUtils.getConfiguration(ConfigurationKeys.PLATFORM_PRIVATE_KEY);

    private static Object obtainService(Class<?> serviceClass) {
        Object service = serviceMap.get(serviceClass);
        if (Objects.nonNull(service)) {
            return service;
        }

        service = ApplicationHandler.getBean(serviceClass);
        serviceMap.put(serviceClass, ApplicationHandler.getBean(serviceClass));
        return service;
    }

    private static Method obtainTargetMethod(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        return methodSignature.getMethod();
    }

    public static String callApiRestAction(ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction) {
        HttpServletRequest httpServletRequest = ApplicationHandler.getHttpServletRequest();
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        String requestBody = null;
        ApiRest apiRest = null;
        Throwable throwable = null;
        try {
            String method = httpServletRequest.getMethod();
            if (Constants.REQUEST_METHOD_GET.equals(method)) {
                apiRest = callApiRestAction(requestParameters, proceedingJoinPoint, apiRestAction);
            } else if (Constants.REQUEST_METHOD_POST.equals(method)) {
                String contentType = httpServletRequest.getContentType();
                if (Constants.CONTENT_TYPE_APPLICATION_FORM_URLENCODED_UTF8.equals(contentType)) {
                    apiRest = callApiRestAction(requestParameters, proceedingJoinPoint, apiRestAction);
                } else if (Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8.equals(contentType)) {
                    requestBody = ApplicationHandler.getRequestBody(httpServletRequest, Constants.CHARSET_NAME_UTF_8);
                    apiRest = callApiRestAction(requestParameters, requestBody, proceedingJoinPoint, apiRestAction, obtainTargetMethod(proceedingJoinPoint));
                }
            } else {
                throw new CustomException(ErrorConstants.INVALID_REQUEST);
            }
        } catch (InvocationTargetException e) {
            throwable = e.getTargetException();
        } catch (Throwable t) {
            throwable = t;
        }

        if (Objects.nonNull(throwable)) {
            LogUtils.error(apiRestAction.error(), proceedingJoinPoint.getTarget().getClass().getName(), proceedingJoinPoint.getSignature().getName(), throwable, requestParameters, requestBody);
            if (throwable instanceof CustomException) {
                CustomException customException = (CustomException) throwable;
                apiRest = ApiRest.builder().error(new Error(customException.getCode(), customException.getMessage())).build();
            } else {
                apiRest = ApiRest.builder().error(new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, apiRestAction.error())).build();
            }
        }

        String datePattern = apiRestAction.datePattern();
        // 处理压缩
        if (apiRestAction.zipped()) {
            apiRest.zipData(datePattern);
        }

        // 处理加密
        if (apiRestAction.encrypted()) {
            apiRest.encryptData(Base64.decodeBase64(TenantUtils.obtainPublicKey()), datePattern);
        }

        // 处理签名
        if (apiRestAction.signed()) {
            apiRest.sign(PLATFORM_PRIVATE_KEY, datePattern);
        }
        return JacksonUtils.writeValueAsString(apiRest, datePattern);
    }

    /**
     * 构建 Model 对象 Content-Type=application/x-www-form-urlencoded;charset=UTF-8
     *
     * @param modelClass
     * @param requestParameters
     * @param datePattern
     * @return
     * @throws Exception
     */
    private static BasicModel buildModel(Class<? extends BasicModel> modelClass, Map<String, String> requestParameters, String datePattern) throws Exception {
        return ApplicationHandler.instantiateObject(modelClass, requestParameters, datePattern);
    }

    /**
     * 构建 Model 对象，Content-Type=application/json;charset=UTF-8
     *
     * @param modelClass
     * @param requestBody
     * @param datePattern
     * @return
     * @throws Exception
     */
    private static BasicModel buildModel(Class<? extends BasicModel> modelClass, String requestBody, String datePattern) {
        return ApplicationHandler.instantiateObject(modelClass, requestBody, datePattern);
    }

    public static ApiRest callApiRestAction(Map<String, String> requestParameters, ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction) throws Throwable {
        Class<? extends BasicModel> modelClass = apiRestAction.modelClass();
        Class<?> serviceClass = apiRestAction.serviceClass();
        String serviceMethodName = apiRestAction.serviceMethodName();
        String datePattern = apiRestAction.datePattern();
        if (Objects.nonNull(modelClass) && Objects.nonNull(serviceClass) && StringUtils.isNotBlank(serviceMethodName)) {
            BasicModel model = buildModel(modelClass, requestParameters, datePattern);
            if (model instanceof OAuthBasicModel) {
                OAuthBasicModel oAuthBasicModel = (OAuthBasicModel) model;
                oAuthBasicModel.set$id(requestParameters.get("id"));
                oAuthBasicModel.set$timestamp(requestParameters.get("timestamp"));
                oAuthBasicModel.set$accessToken(requestParameters.get("access_token"));
            }
            model.validateAndThrow();
            return callApiRestAction(modelClass, serviceClass, serviceMethodName, model);
        }
        return callApiRestAction(proceedingJoinPoint);
    }

    public static ApiRest callApiRestAction(Map<String, String> requestParameters, String requestBody, ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction, Method targetMethod) throws Throwable {
        Class<? extends BasicModel> modelClass = apiRestAction.modelClass();
        Class<?> serviceClass = apiRestAction.serviceClass();
        String serviceMethodName = apiRestAction.serviceMethodName();
        String datePattern = apiRestAction.datePattern();
        if (Objects.nonNull(modelClass) && Objects.nonNull(serviceClass) && StringUtils.isNotBlank(serviceMethodName)) {
            BasicModel model = buildModel(modelClass, requestBody, datePattern);
            if (model instanceof OAuthBasicModel) {
                OAuthBasicModel oAuthBasicModel = (OAuthBasicModel) model;
                oAuthBasicModel.set$id(requestParameters.get("id"));
                oAuthBasicModel.set$timestamp(requestParameters.get("timestamp"));
                oAuthBasicModel.set$accessToken(requestParameters.get("access_token"));
            }
            model.validateAndThrow();
            return callApiRestAction(modelClass, serviceClass, serviceMethodName, model);
        }
        return callApiRestAction(proceedingJoinPoint);
    }

    private static ApiRest callApiRestAction(Class<? extends BasicModel> modelClass, Class<?> serviceClass, String serviceMethodName, BasicModel model) throws Throwable {
        Method method = serviceClass.getDeclaredMethod(serviceMethodName, modelClass);
        method.setAccessible(true);

        Object result = method.invoke(obtainService(serviceClass), model);
        return transformResult(result);
    }

    private static ApiRest transformResult(Object result) {
        if (result instanceof String) {
            return ApiRest.fromJson(result.toString());
        } else {
            return (ApiRest) result;
        }
    }

    private static ApiRest callApiRestAction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return transformResult(proceedingJoinPoint.proceed());
    }
}
