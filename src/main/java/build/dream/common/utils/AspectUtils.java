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

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AspectUtils {
    private static ConcurrentHashMap<Class<?>, Object> serviceMap = new ConcurrentHashMap<Class<?>, Object>();
    private static final String APPLICATION_FORM_URLENCODED_UTF8_VALUE = "application/x-www-form-urlencoded;charset=UTF-8";
    private static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
    private static final String PLATFORM_PRIVATE_KEY = ConfigurationUtils.getConfiguration(Constants.PLATFORM_PRIVATE_KEY);

    private static Object obtainService(Class<?> serviceClass) {
        if (!serviceMap.contains(serviceClass)) {
            serviceMap.put(serviceClass, ApplicationHandler.getBean(serviceClass));
        }
        return serviceMap.get(serviceClass);
    }

    public static String callApiRestAction(ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction) {
        HttpServletRequest httpServletRequest = ApplicationHandler.getHttpServletRequest();

        ApiRest apiRest = null;
        Throwable throwable = null;
        String datePattern = apiRestAction.datePattern();
        try {
            String contentType = httpServletRequest.getContentType();

            Class<? extends BasicModel> modelClass = apiRestAction.modelClass();
            Class<?> serviceClass = apiRestAction.serviceClass();
            String serviceMethodName = apiRestAction.serviceMethodName();

            if (APPLICATION_JSON_UTF8_VALUE.equals(contentType)) {
                if (modelClass != BasicModel.class && serviceClass != Object.class && StringUtils.isNotBlank(serviceMethodName)) {
                    apiRest = callApiRestAction(ApplicationHandler.getRequestBody(httpServletRequest, Constants.CHARSET_NAME_UTF_8), modelClass, serviceClass, serviceMethodName, datePattern);
                } else {
                    apiRest = callApiRestAction(proceedingJoinPoint);
                }
            } else if (APPLICATION_FORM_URLENCODED_UTF8_VALUE.equals(contentType)) {
                if (modelClass != BasicModel.class && serviceClass != Object.class && StringUtils.isNotBlank(serviceMethodName)) {
                    apiRest = callApiRestAction(ApplicationHandler.getRequestParameters(httpServletRequest), modelClass, serviceClass, serviceMethodName, datePattern);
                } else {
                    apiRest = callApiRestAction(proceedingJoinPoint);
                }
            } else {
                throw new CustomException(ErrorConstants.INVALID_CONTENT_TYPE_ERROR);
            }
        } catch (InvocationTargetException e) {
            throwable = e.getTargetException();
        } catch (Throwable t) {
            throwable = t;
        }

        if (throwable != null) {
            LogUtils.error(apiRestAction.error(), proceedingJoinPoint.getTarget().getClass().getName(), proceedingJoinPoint.getSignature().getName(), throwable);
            if (throwable instanceof CustomException) {
                CustomException customException = (CustomException) throwable;
                apiRest = ApiRest.builder().error(new Error(customException.getCode(), customException.getMessage())).build();
            } else {
                apiRest = ApiRest.builder().error(new Error(ErrorConstants.ERROR_CODE_UNKNOWN_ERROR, apiRestAction.error())).build();
            }
        }

        // 处理压缩
        if (apiRestAction.zipped()) {
            apiRest.zipData(datePattern);
        }

        // 处理加密
        if (apiRestAction.encrypted()) {
            String publicKey = ApplicationHandler.obtainPublicKey();
            apiRest.encryptData(publicKey, datePattern);
        }

        // 处理签名
        if (apiRestAction.signed()) {
            apiRest.sign(PLATFORM_PRIVATE_KEY, datePattern);
        }
        return GsonUtils.toJson(apiRest, datePattern);
    }

    /**
     * 处理 Content-Type=application/x-www-form-urlencoded;charset=UTF-8 的请求
     *
     * @param requestParameters
     * @param modelClass
     * @param serviceClass
     * @param serviceMethodName
     * @param datePattern
     * @return
     * @throws Throwable
     */
    private static ApiRest callApiRestAction(Map<String, String> requestParameters, Class<? extends BasicModel> modelClass, Class<?> serviceClass, String serviceMethodName, String datePattern) throws Throwable {
        BasicModel model = buildModel(modelClass, requestParameters, datePattern);
        return callApiRestAction(modelClass, serviceClass, serviceMethodName, model);
    }

    /**
     * 处理 Content-Type=application/json;charset=UTF-8 的请求
     *
     * @param requestBody
     * @param modelClass
     * @param serviceClass
     * @param serviceMethodName
     * @param datePattern
     * @return
     * @throws Throwable
     */
    private static ApiRest callApiRestAction(String requestBody, Class<? extends BasicModel> modelClass, Class<?> serviceClass, String serviceMethodName, String datePattern) throws Throwable {
        BasicModel model = buildModel(modelClass, requestBody, datePattern);
        model.validateAndThrow();
        return callApiRestAction(modelClass, serviceClass, serviceMethodName, model);
    }

    /**
     * 调用 Service 的方法
     *
     * @param modelClass
     * @param serviceClass
     * @param serviceMethodName
     * @param model
     * @return
     * @throws Throwable
     */
    private static ApiRest callApiRestAction(Class<? extends BasicModel> modelClass, Class<?> serviceClass, String serviceMethodName, BasicModel model) throws Throwable {
        Method method = serviceClass.getDeclaredMethod(serviceMethodName, modelClass);
        method.setAccessible(true);

        Object result = method.invoke(obtainService(serviceClass), model);
        return transformResult(result);
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

    /**
     * 调用 Controller 方法
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    private static ApiRest callApiRestAction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return transformResult(proceedingJoinPoint.proceed());
    }

    /**
     * 转换返回结果
     *
     * @param result
     * @return
     */
    private static ApiRest transformResult(Object result) {
        if (result instanceof String) {
            return ApiRest.fromJson(result.toString());
        } else {
            return (ApiRest) result;
        }
    }
}
