package build.dream.common.utils;

import build.dream.common.annotations.*;
import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import build.dream.common.constants.ErrorConstants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.exceptions.Error;
import build.dream.common.models.BasicModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class AspectUtils {
    private static ConcurrentHashMap<Class<?>, Object> serviceMap = new ConcurrentHashMap<Class<?>, Object>();
    private static final String PLATFORM_PRIVATE_KEY = ConfigurationUtils.getConfiguration(Constants.PLATFORM_PRIVATE_KEY);

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

        ApiRest apiRest = null;
        Throwable throwable = null;
        try {
            String contentType = httpServletRequest.getContentType();
            Method targetMethod = obtainTargetMethod(proceedingJoinPoint);
            OnlyAllowedApplicationJsonUtf8 onlyAllowedApplicationJsonUtf8 = AnnotationUtils.findAnnotation(targetMethod, OnlyAllowedApplicationJsonUtf8.class);
            if (Objects.nonNull(onlyAllowedApplicationJsonUtf8)) {
                ValidateUtils.isTrue(Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8.equals(contentType), ErrorConstants.INVALID_CONTENT_TYPE_ERROR);
            }

            OnlyAllowedApplicationFormUrlencodedUtf8 onlyAllowedApplicationFormUrlencodedUtf8 = AnnotationUtils.findAnnotation(targetMethod, OnlyAllowedApplicationFormUrlencodedUtf8.class);
            if (Objects.nonNull(onlyAllowedApplicationFormUrlencodedUtf8)) {
                ValidateUtils.isTrue(Constants.CONTENT_TYPE_APPLICATION_FORM_URLENCODED_UTF8.equals(contentType), ErrorConstants.INVALID_CONTENT_TYPE_ERROR);
            }

            String method = httpServletRequest.getMethod();
            OnlyAllowedRequestMethodGet onlyAllowedRequestMethodGet = AnnotationUtils.findAnnotation(targetMethod, OnlyAllowedRequestMethodGet.class);
            if (Objects.nonNull(onlyAllowedRequestMethodGet)) {
                ValidateUtils.isTrue(Constants.REQUEST_METHOD_GET.equals(method), ErrorConstants.INVALID_REQUEST_METHOD_ERROR);
            }

            OnlyAllowedRequestMethodPost onlyAllowedRequestMethodPost = AnnotationUtils.findAnnotation(targetMethod, OnlyAllowedRequestMethodPost.class);
            if (Objects.nonNull(onlyAllowedRequestMethodPost)) {
                ValidateUtils.isTrue(Constants.REQUEST_METHOD_POST.equals(method), ErrorConstants.INVALID_REQUEST_METHOD_ERROR);
            }

            if (Constants.REQUEST_METHOD_GET.equals(method)) {
                apiRest = callApiRestAction(httpServletRequest, proceedingJoinPoint, apiRestAction);
            } else if (Constants.REQUEST_METHOD_POST.equals(method)) {
                apiRest = callApiRestAction(httpServletRequest, proceedingJoinPoint, apiRestAction, targetMethod, contentType);
            } else {
                throw new CustomException(ErrorConstants.INVALID_REQUEST);
            }
        } catch (InvocationTargetException e) {
            throwable = e.getTargetException();
        } catch (Throwable t) {
            throwable = t;
        }

        if (Objects.nonNull(throwable)) {
            LogUtils.error(apiRestAction.error(), proceedingJoinPoint.getTarget().getClass().getName(), proceedingJoinPoint.getSignature().getName(), throwable);
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
        model.validateAndThrow();
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

    private static ApiRest callApiRestAction(HttpServletRequest httpServletRequest, ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction, Method targetMethod, String contentType) throws Throwable {
        if (Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8.equals(contentType)) {
            return callApiRestAction(httpServletRequest, proceedingJoinPoint, apiRestAction, targetMethod);
        } else if (Constants.CONTENT_TYPE_APPLICATION_FORM_URLENCODED_UTF8.equals(contentType)) {
            return callApiRestAction(httpServletRequest, proceedingJoinPoint, apiRestAction);
        } else {
            throw new CustomException(ErrorConstants.INVALID_CONTENT_TYPE_ERROR);
        }
    }

    private static ApiRest callApiRestAction(HttpServletRequest httpServletRequest, ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction) throws Throwable {
        Class<? extends BasicModel> modelClass = apiRestAction.modelClass();
        Class<?> serviceClass = apiRestAction.serviceClass();
        String serviceMethodName = apiRestAction.serviceMethodName();
        String datePattern = apiRestAction.datePattern();

        if (modelClass != BasicModel.class && serviceClass != Object.class && StringUtils.isNotBlank(serviceMethodName)) {
            return callApiRestAction(ApplicationHandler.getRequestParameters(httpServletRequest), modelClass, serviceClass, serviceMethodName, datePattern);
        }
        return callApiRestAction(proceedingJoinPoint);
    }

    private static ApiRest callApiRestAction(HttpServletRequest httpServletRequest, ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction, Method targetMethod) throws Throwable {
        Class<? extends BasicModel> modelClass = apiRestAction.modelClass();
        Class<?> serviceClass = apiRestAction.serviceClass();
        String serviceMethodName = apiRestAction.serviceMethodName();
        String datePattern = apiRestAction.datePattern();

        if (modelClass != BasicModel.class && serviceClass != Object.class && StringUtils.isNotBlank(serviceMethodName)) {
            String requestBody = ApplicationHandler.getRequestBody(httpServletRequest, Constants.CHARSET_NAME_UTF_8);
            ApplicationJsonUtf8Encrypted applicationJsonUtf8Encrypted = AnnotationUtils.findAnnotation(targetMethod, ApplicationJsonUtf8Encrypted.class);
            if (Objects.nonNull(applicationJsonUtf8Encrypted)) {
                byte[] publicKey = Base64.decodeBase64(TenantUtils.obtainPublicKey());
                requestBody = new String(RSAUtils.decryptByPublicKey(Base64.decodeBase64(requestBody), Base64.decodeBase64(publicKey), RSAUtils.PADDING_MODE_RSA_ECB_PKCS1PADDING), Constants.CHARSET_NAME_UTF_8);
            }
            return callApiRestAction(requestBody, modelClass, serviceClass, serviceMethodName, datePattern);
        }
        return callApiRestAction(proceedingJoinPoint);
    }
}
