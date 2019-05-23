package build.dream.common.utils;

import build.dream.common.annotations.ApiRestAction;
import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import build.dream.common.constants.ErrorConstants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.exceptions.Error;
import build.dream.common.models.BasicModel;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AspectUtils {
    private static ConcurrentHashMap<Class<?>, Object> serviceMap = new ConcurrentHashMap<Class<?>, Object>();
    private static final String APPLICATION_FORM_URLENCODED_UTF8_VALUE = "application/x-www-form-urlencoded;charset=UTF-8";
    private final static String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";

    private static Object obtainService(Class<?> serviceClass) {
        if (!serviceMap.contains(serviceClass)) {
            serviceMap.put(serviceClass, ApplicationHandler.getBean(serviceClass));
        }
        return serviceMap.get(serviceClass);
    }

    public static String callApiRestAction(ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction) {
        HttpServletRequest httpServletRequest = ApplicationHandler.getHttpServletRequest();

        Map<String, String> requestParameters = null;
        String requestBody = null;
        ApiRest apiRest = null;
        Throwable throwable = null;
        try {
            String contentType = httpServletRequest.getContentType();
            MediaType mediaType = MediaType.valueOf(contentType);
            if (APPLICATION_JSON_UTF8_VALUE.equals(contentType)) {
                requestBody = ApplicationHandler.getRequestBody(httpServletRequest, Constants.CHARSET_NAME_UTF_8);
            } else if (APPLICATION_FORM_URLENCODED_UTF8_VALUE.equals(mediaType)) {
                requestParameters = ApplicationHandler.getRequestParameters(httpServletRequest);
            } else {
                throw new CustomException(ErrorConstants.INVALID_CONTENT_TYPE_ERROR);
            }
            apiRest = callApiRestAction(proceedingJoinPoint, requestParameters, requestBody, apiRestAction);
        } catch (InvocationTargetException e) {
            throwable = e.getTargetException();
        } catch (Throwable t) {
            throwable = t;
        }

        if (throwable != null) {
            String body = requestBody != null ? requestBody : String.valueOf(requestParameters);
            LogUtils.error(apiRestAction.error(), proceedingJoinPoint.getTarget().getClass().getName(), proceedingJoinPoint.getSignature().getName(), throwable, body);
            if (throwable instanceof CustomException) {
                CustomException customException = (CustomException) throwable;
                apiRest = ApiRest.builder().error(new Error(customException.getCode(), customException.getMessage())).build();
            } else {
                apiRest = ApiRest.builder().error(new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, apiRestAction.error())).build();
            }
        }

        String datePattern = apiRestAction.datePattern();

        if (apiRestAction.zipped()) {
            apiRest.zipData(datePattern);
        }

        if (apiRestAction.encrypted()) {
            String publicKey = requestParameters.get(Constants.PUBLIC_KEY);
            apiRest.encryptData(publicKey, datePattern);
        }

        if (apiRestAction.signed()) {
            String platformPrivateKey = ConfigurationUtils.getConfiguration(Constants.PLATFORM_PRIVATE_KEY);
            apiRest.sign(platformPrivateKey, datePattern);
        }
        return GsonUtils.toJson(apiRest, datePattern);
    }

    private static BasicModel buildModel(Class<? extends BasicModel> modelClass, Map<String, String> requestParameters, String requestBody, String datePattern) throws Exception {
        if (requestBody != null) {
            return ApplicationHandler.instantiateObject(modelClass, requestBody, datePattern);
        } else {
            return ApplicationHandler.instantiateObject(modelClass, requestParameters, datePattern);
        }
    }

    private static ApiRest callApiRestAction(ProceedingJoinPoint proceedingJoinPoint, Map<String, String> requestParameters, String requestBody, ApiRestAction apiRestAction) throws Throwable {
        Class<? extends BasicModel> modelClass = apiRestAction.modelClass();
        Class<?> serviceClass = apiRestAction.serviceClass();
        String serviceMethodName = apiRestAction.serviceMethodName();

        Object result = null;
        if (modelClass != BasicModel.class && serviceClass != Object.class && StringUtils.isNotBlank(serviceMethodName)) {
            BasicModel model = buildModel(modelClass, requestParameters, requestBody, apiRestAction.datePattern());
            model.validateAndThrow();

            Method method = serviceClass.getDeclaredMethod(serviceMethodName, modelClass);
            method.setAccessible(true);

            result = method.invoke(obtainService(serviceClass), model);
        } else {
            result = proceedingJoinPoint.proceed();
        }
        if (result instanceof String) {
            return ApiRest.fromJson(result.toString());
        } else {
            return (ApiRest) result;
        }
    }
}
