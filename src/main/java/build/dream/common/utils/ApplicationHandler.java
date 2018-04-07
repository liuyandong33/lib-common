package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.constants.SessionConstants;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validator;
import java.io.IOException;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuyandong on 2017/3/24.
 */
public class ApplicationHandler {
    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getHttpServletRequest() {
        return getServletRequestAttributes().getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        return getServletRequestAttributes().getResponse();
    }

    public static Map<String, String> getRequestParameters() {
        return getRequestParameters(getHttpServletRequest());
    }

    public static Map<String, String> getRequestParameters(HttpServletRequest httpServletRequest) {
        Map<String, String> requestParameters = new LinkedHashMap<String, String>();
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        for (Map.Entry<String, String[]> parameterEntry : parameterMap.entrySet()) {
            requestParameters.put(parameterEntry.getKey(), StringUtils.trimToEmpty(StringUtils.join(parameterEntry.getValue(), ",")));
        }
        return requestParameters;
    }

    public static String getRequestBody(String charsetName) throws IOException {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        return WebUtils.inputStreamToString(httpServletRequest.getInputStream(), charsetName);
    }

    public static String getRequestBody() throws IOException {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        return WebUtils.inputStreamToString(httpServletRequest.getInputStream());
    }

    public static String getRequestParameter(String requestParameterName) {
        return StringUtils.trimToNull(StringUtils.join(getHttpServletRequest().getParameterValues(requestParameterName), ","));
    }

    public static String getSessionId() {
        return getServletRequestAttributes().getSessionId();
    }

    public static ServletContext getServletContext() {
        return getHttpServletRequest().getServletContext();
    }

    public static String getRemoteAddress() {
        return getHttpServletRequest().getRemoteAddr();
    }

    public static HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    public static String getRequestUrl() {
        return getHttpServletRequest().getRequestURL().toString();
    }

    public static <T> T instantiateObject(Class<T> objectClass, Map<String, String> parameters) throws NoSuchFieldException, InstantiationException, ParseException, IllegalAccessException {
        return instantiateObject(objectClass, parameters, Constants.DEFAULT_DATE_PATTERN, "");
    }

    public static <T> T instantiateObject(Class<T> objectClass, Map<String, String> parameters, String prefix) throws NoSuchFieldException, InstantiationException, ParseException, IllegalAccessException {
        return instantiateObject(objectClass, parameters, Constants.DEFAULT_DATE_PATTERN, prefix);
    }

    public static <T> T instantiateObject(Class<T> objectClass, Map<String, String> parameters, String datePattern, String prefix) throws IllegalAccessException, InstantiationException, NoSuchFieldException, ParseException {
        T object = objectClass.newInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                continue;
            }
            String fieldName = field.getName();
            String fieldValue = parameters.get(prefix + fieldName);
            if (StringUtils.isBlank(fieldValue)) {
                continue;
            }
            ReflectionUtils.makeAccessible(field);
            Class<?> fieldClass = field.getType();
            if (fieldClass == Byte.class || fieldClass == byte.class) {
                field.set(object, Byte.valueOf(fieldValue));
            } else if (fieldClass == Short.class || fieldClass == short.class) {
                field.set(object, Short.valueOf(fieldValue));
            } else if (fieldClass == Integer.class || fieldClass == int.class) {
                field.set(object, Integer.valueOf(fieldValue));
            } else if (fieldClass == Long.class || fieldClass == long.class) {
                field.set(object, Long.valueOf(fieldValue));
            } else if (fieldClass == Float.class || fieldClass == float.class) {
                field.set(object, Float.valueOf(fieldValue));
            } else if (fieldClass == Double.class || fieldClass == double.class) {
                field.set(object, Double.valueOf(fieldValue));
            } else if (fieldClass == Character.class || fieldClass == char.class) {
                field.set(object, fieldValue.charAt(0));
            } else if (fieldClass == String.class) {
                field.set(object, fieldValue);
            } else if (fieldClass == Boolean.class || fieldClass == boolean.class) {
                field.set(object, Boolean.valueOf(fieldValue));
            } else if (fieldClass == Date.class) {
                field.set(object, simpleDateFormat.parse(fieldValue));
            } else if (fieldClass == BigInteger.class) {
                field.set(object, BigInteger.valueOf(Long.valueOf(fieldValue)));
            } else if (fieldClass == BigDecimal.class) {
                field.set(object, BigDecimal.valueOf(Double.valueOf(fieldValue)));
            } else if (fieldClass == List.class) {
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    field.set(object, buildArrayList(((ParameterizedType) type).getActualTypeArguments()[0], fieldValue, ","));
                }
            } else if (fieldClass == Map.class) {
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type[] types = parameterizedType.getActualTypeArguments();
                    Class keyClass = (Class) types[0];
                    Class valueClass = (Class) types[1];
                    field.set(object, GsonUtils.jsonToMap(fieldValue, keyClass, valueClass));
                }
            }
        }
        return object;
    }

    public static List<Byte> buildByteArrayList(String fieldValue, String separator) {
        List<Byte> list = new ArrayList<Byte>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Byte.valueOf(str));
        }
        return list;
    }

    public static List<Short> buildShortArrayList(String fieldValue, String separator) {
        List<Short> list = new ArrayList<Short>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Short.valueOf(str));
        }
        return list;
    }

    public static List<Integer> buildIntegerArrayList(String fieldValue, String separator) {
        List<Integer> list = new ArrayList<Integer>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Integer.valueOf(str));
        }
        return list;
    }

    public static List<Long> buildLongArrayList(String fieldValue, String separator) {
        List<Long> list = new ArrayList<Long>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Long.valueOf(str));
        }
        return list;
    }

    public static List<Float> buildFloatArrayList(String fieldValue, String separator) {
        List<Float> list = new ArrayList<Float>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Float.valueOf(str));
        }
        return list;
    }

    public static List<Double> buildDoubleArrayList(String fieldValue, String separator) {
        List<Double> list = new ArrayList<Double>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Double.valueOf(str));
        }
        return list;
    }

    public static List<Character> buildCharacterArrayList(String fieldValue, String separator) {
        List<Character> list = new ArrayList<Character>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(str.charAt(0));
        }
        return list;
    }

    public static List<Boolean> buildBooleanArrayList(String fieldValue, String separator) {
        List<Boolean> list = new ArrayList<Boolean>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Boolean.valueOf(str));
        }
        return list;
    }

    public static List<BigInteger> buildBigIntegerArrayList(String fieldValue, String separator) {
        List<BigInteger> list = new ArrayList<BigInteger>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(BigInteger.valueOf(Long.valueOf(str)));
        }
        return list;
    }

    public static List<BigDecimal> buildBigDecimalArrayList(String fieldValue, String separator) {
        List<BigDecimal> list = new ArrayList<BigDecimal>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(BigDecimal.valueOf(Double.valueOf(str)));
        }
        return list;
    }

    public static List<Date> buildDateArrayList(String fieldValue, String separator, String datePattern) {
        List<Date> list = new ArrayList<Date>();
        String[] array = fieldValue.split(separator);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        try {
            for (String str : array) {
                list.add(simpleDateFormat.parse(str));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<String> buildStringArrayList(String fieldValue, String separator) {
        List<String> list = new ArrayList<String>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(str);
        }
        return list;
    }

    private static Object buildArrayList(Type type, String fieldValue, String separator) {
        List<? extends Object> list = null;
        if (type == Byte.class) {
            list = buildByteArrayList(fieldValue, separator);
        } else if (type == Short.class) {
            list = buildShortArrayList(fieldValue, separator);
        } else if (type == Integer.class) {
            list = buildIntegerArrayList(fieldValue, separator);
        } else if (type == Long.class) {
            list = buildLongArrayList(fieldValue, separator);
        } else if (type == Float.class) {
            list = buildFloatArrayList(fieldValue, separator);
        } else if (type == Double.class) {
            list = buildFloatArrayList(fieldValue, separator);
        } else if (type == Character.class) {
            list = buildCharacterArrayList(fieldValue, separator);
        } else if (type == Boolean.class) {
            list = buildBooleanArrayList(fieldValue, separator);
        } else if (type == BigInteger.class) {
            list = buildBigIntegerArrayList(fieldValue, separator);
        } else if (type == BigDecimal.class) {
            list = buildBigDecimalArrayList(fieldValue, separator);
        } else if (type == Date.class) {
            list = buildDateArrayList(fieldValue, separator, Constants.DEFAULT_DATE_PATTERN);
        } else if (type == String.class) {
            list = buildStringArrayList(fieldValue, separator);
        }
        return list;
    }

    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationHandler.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    private static Validator validator = null;

    public static Validator obtainValidator() {
        if (validator == null) {
            validator = (Validator) applicationContext.getBean("validator");
        }
        return validator;
    }

    public static void notNullAndPut(Map<String, Object> targetMap, String key, Object value, String message) {
        Validate.notNull(value, message);
        targetMap.put(key, value);
    }

    public static void notBlankAndPut(Map<String, String> targetMap, String key, String value, String message) {
        Validate.isTrue(StringUtils.isNotBlank(value), message);
        targetMap.put(key, value);
    }

    public static void ifNotNullPut(Map<String, Object> targetMap, String key, Object value) {
        if (value != null) {
            targetMap.put(key, value);
        }
    }

    public static void ifNotBlankPut(Map<String, String> targetMap, String key, String value) {
        if (StringUtils.isNotBlank(value)) {
            targetMap.put(key, value);
        }
    }

    public static void ifNotBlankPut(Map<String, String> sourceMap, Map<String, String> targetMap, String... keys) {
        for (String key : keys) {
            String value = sourceMap.get(key);
            if (StringUtils.isNotBlank(key)) {
                targetMap.put(key, value);
            }
        }
    }

    public static void ifNotBlankPut(Map<String, String> sourceMap, Map<String, String> targetMap, Map<String, String> keyMapping) {
        Set<Map.Entry<String, String>> entries = keyMapping.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String value = sourceMap.get(entry.getKey());
            if (StringUtils.isNotBlank(value)) {
                targetMap.put(entry.getValue(), value);
            }
        }
    }

    public static String obtainParameterErrorMessage(String parameterName) {
        return String.format(Constants.PARAMETER_ERROR_MESSAGE_PATTERN, parameterName);
    }

    public static String obtainRequestMethod() {
        return getHttpServletRequest().getMethod();
    }

    public static BigInteger obtainUserId(String sessionId) {
        String userId = CacheUtils.obtainAttributeFromSession(sessionId, SessionConstants.KEY_USER_ID);
        if (StringUtils.isNotBlank(userId)) {
            return NumberUtils.createBigInteger(userId);
        }
        return null;
    }

    public static BigInteger obtainTenantId(String sessionId) {
        String tenantId = CacheUtils.obtainAttributeFromSession(sessionId, SessionConstants.KEY_TENANT_ID);
        if (StringUtils.isNotBlank(tenantId)) {
            return NumberUtils.createBigInteger(tenantId);
        }
        return null;
    }

    public static void forward(String controllerName, String actionName, Map<String, Object> attributes) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        if (MapUtils.isNotEmpty(attributes)) {
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                httpServletRequest.setAttribute(entry.getKey(), entry.getValue());
            }
        }
        HttpServletResponse httpServletResponse = getHttpServletResponse();
        httpServletRequest.getRequestDispatcher("/" + controllerName + "/" + actionName).forward(httpServletRequest, httpServletResponse);
    }

    public static void forward(String path) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        HttpServletResponse httpServletResponse = getHttpServletResponse();
        httpServletRequest.getRequestDispatcher(path).forward(httpServletRequest, httpServletResponse);
    }

    public static String obtainHttpHeader(String name) {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        return httpServletRequest.getHeader(name);
    }

    public static String obtainBrowserType() {
        String userAgent = obtainHttpHeader(HttpHeaders.USER_AGENT);
        String browserType = null;
        if (StringUtils.isBlank(userAgent)) {
            browserType = Constants.BROWSER_TYPE_OTHER;
        } else {
            userAgent = userAgent.toLowerCase();
            if (userAgent.contains("alipay")) {
                browserType = Constants.BROWSER_TYPE_ALIPAY;
            } else if (userAgent.contains("micromessenger")) {
                browserType = Constants.BROWSER_TYPE_WEI_XIN;
            } else {
                browserType = Constants.BROWSER_TYPE_OTHER;
            }
        }
        return browserType;
    }

    public static String obtainBrowserPlatform() {
        String userAgent = obtainHttpHeader(HttpHeaders.USER_AGENT);
        String browserPlatform = null;
        if (StringUtils.isBlank(userAgent)) {
            browserPlatform = Constants.BROWSER_PLATFORM_OTHER;
        } else {
            userAgent = userAgent.toLowerCase();
            if (userAgent.contains("iphone") || userAgent.contains("android")) {
                browserPlatform = Constants.BROWSER_PLATFORM_PHONE;
            } else {
                browserPlatform = Constants.BROWSER_PLATFORM_PC;
            }
        }
        return browserPlatform;
    }

    public static void redirect(String url) throws IOException {
        ApplicationHandler.getHttpServletResponse().sendRedirect(url);
    }

    public static void notNull(Object object, String parameterName) {
        if (object == null) {
            throw new IllegalArgumentException(obtainParameterErrorMessage(parameterName));
        }
    }

    public static void isTrue(boolean expression, String parameterName) {
        if (expression == false) {
            throw new IllegalArgumentException(obtainParameterErrorMessage(parameterName));
        }
    }

    public static void notEmpty(Object[] array, String parameterName) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(obtainParameterErrorMessage(parameterName));
        }
    }

    public static void notEmpty(Collection collection, String parameterName) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException(obtainParameterErrorMessage(parameterName));
        }
    }

    public static void notEmpty(Map map, String parameterName) {
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException(obtainParameterErrorMessage(parameterName));
        }
    }

    public static void notEmpty(String string, String parameterName) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException(obtainParameterErrorMessage(parameterName));
        }
    }

    public static void notEmpty(String[]... valueAndNames) {
        for (String[] valueAndName : valueAndNames) {
            notEmpty(valueAndName[0], valueAndName[1]);
        }
    }

    public static void inArray(Object[] array, Object value, String name) {
        Validate.isTrue(ArrayUtils.contains(array, value), "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！");
    }

    public static void validateJson(String jsonString, String schemaFilePath, String parameterName) {
        isJson(jsonString, parameterName);
        isTrue(isRightJson(jsonString, schemaFilePath), parameterName);
    }

    public static boolean isRightJson(String jsonString, String schemaFilePath) {
        return JsonSchemaValidateUtils.validate(jsonString, schemaFilePath);
    }

    public static void isJson(String jsonString, String parameterName) {
        notBlank(jsonString, parameterName);
        boolean isValidate = (jsonString.startsWith("{") && jsonString.endsWith("}")) || (jsonString.startsWith("[") && jsonString.endsWith("]"));
        isTrue(isValidate, parameterName);
    }

    public static boolean isJson(String jsonString) {
        if (StringUtils.isBlank(jsonString)) {
            return false;
        }
        return (jsonString.startsWith("{") && jsonString.endsWith("}")) || (jsonString.startsWith("[") && jsonString.endsWith("]"));
    }

    public static void notBlank(String string, String parameterName) {
        if (StringUtils.isBlank(string)) {
            throw new IllegalArgumentException(obtainParameterErrorMessage(parameterName));
        }
    }

    public static Object invokeMethod(Class<?> clazz, String methodName, Class<?>[] argumentTypes, Object[] arguments, Object target) throws NoSuchMethodException {
        Method method = clazz.getMethod(methodName, argumentTypes);
        return ReflectionUtils.invokeMethod(method, target, arguments);
    }

    public static void invalidateHttpSession() {
        getHttpSession().invalidate();
    }

    public static String getHeader(String name) {
        return getHttpServletRequest().getHeader(name);
    }

    public static String today() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
}