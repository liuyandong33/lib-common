package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        Map<String, String> requestParameters = new LinkedHashMap<>();
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        for (Map.Entry<String, String[]> parameterEntry : parameterMap.entrySet()) {
            requestParameters.put(parameterEntry.getKey(), StringUtils.trimToNull(StringUtils.join(parameterEntry.getValue(), ",")));
        }
        return requestParameters;
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

    public static <T> T instantiateDomain(Class<T> domainClass, Map<String, String> arguments) throws IllegalAccessException, InstantiationException, NoSuchFieldException, ParseException {
        T domain = domainClass.newInstance();
        Set<Map.Entry<String, String>> entries = arguments.entrySet();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN);
        for (Map.Entry<String, String> entry : entries) {
            String fieldName = entry.getKey();
            Field field = null;
            try {
                field = domainClass.getDeclaredField(fieldName);
            } catch (Exception e) {

            }
            if (field == null) {
                continue;
            }
            String fieldValue = entry.getValue();
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            if (fieldClass == Byte.class || fieldClass == byte.class) {
                field.set(domain, Byte.valueOf(fieldValue));
            } else if (fieldClass == Short.class || fieldClass == short.class) {
                field.set(domain, Short.valueOf(fieldValue));
            } else if (fieldClass == Integer.class || fieldClass == int.class) {
                field.set(domain, Integer.valueOf(fieldValue));
            } else if (fieldClass == Long.class || fieldClass == long.class) {
                field.set(domain, Long.valueOf(fieldValue));
            } else if (fieldClass == Float.class || fieldClass == float.class) {
                field.set(domain, Float.valueOf(fieldValue));
            } else if (fieldClass == Double.class || fieldClass == double.class) {
                field.set(domain, Double.valueOf(fieldValue));
            } else if (fieldClass == Character.class || fieldClass == char.class) {
                field.set(domain, fieldValue.charAt(0));
            } else if (fieldClass == String.class) {
                field.set(domain, fieldValue);
            } else if (fieldClass == Boolean.class || fieldClass == boolean.class) {
                field.set(domain, Boolean.valueOf(fieldValue));
            } else if (fieldClass == Date.class) {
                field.set(domain, simpleDateFormat.parse(fieldValue));
            } else if (fieldClass == BigInteger.class) {
                field.set(domain, BigInteger.valueOf(Long.valueOf(fieldValue)));
            } else if (fieldClass == BigDecimal.class) {
                field.set(domain, BigDecimal.valueOf(Double.valueOf(fieldValue)));
            }
        }
        return domain;
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

    public static <T> T getFromMap(Map<String, Object> map, String key, Class<T> clazz) {
        Object value = map.get(key);
        if (value != null) {
            return (T) value;
        }
        return null;
    }
}