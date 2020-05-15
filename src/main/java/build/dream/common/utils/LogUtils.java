package build.dream.common.utils;

import build.dream.common.constants.ConfigurationKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuyandong on 2017/7/7.
 */
public class LogUtils {
    private static final Map<String, Logger> LOGGER_MAP = new ConcurrentHashMap<String, Logger>();
    private static final boolean LOG_STACK_INFO = Boolean.parseBoolean(ConfigurationUtils.getConfiguration(ConfigurationKeys.LOG_STACK_INFO));
    private static final String HOST_NAME;
    private static final String HOST_ADDRESS;

    static {
        InetAddress inetAddress = ApplicationHandler.callMethodSuppressThrow(() -> InetAddress.getLocalHost());
        HOST_NAME = inetAddress.getHostName();
        HOST_ADDRESS = inetAddress.getHostAddress();
    }

    private static Logger obtainLogger(String name) {
        Logger logger = LOGGER_MAP.get(name);
        if (Objects.isNull(logger)) {
            logger = LoggerFactory.getLogger(name);
            LOGGER_MAP.put(name, logger);
        }
        return logger;
    }

    public static void info(String message) {
        obtainLogger(new Exception().getStackTrace()[1].getClassName()).info(String.format("%s-%s-%s", HOST_NAME, HOST_ADDRESS, message));
    }

    public static void warn(String message) {
        obtainLogger(new Exception().getStackTrace()[1].getClassName()).info(String.format("%s-%s-%s", HOST_NAME, HOST_ADDRESS, message));
    }

    /**
     * 打印错误日志
     *
     * @param errorMessage：错误描述
     * @param className：出错类
     * @param methodName：出错方法
     * @param throwable：异常类
     * @param parameters：请求参数
     * @param body：请求体
     */
    public static void error(String errorMessage, String className, String methodName, Throwable throwable, Map<String, String> parameters, String body) {
        if (LOG_STACK_INFO) {
            obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s:%s.%s-%s-%s-%s-%s-%s",
                    HOST_NAME,
                    HOST_ADDRESS,
                    errorMessage,
                    className,
                    methodName,
                    obtainStackInfos(throwable),
                    throwable.getClass().getName(),
                    throwable.getMessage(),
                    parameters,
                    body));
            return;
        }
        obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s:%s.%s-%s-%s-%s-%s",
                HOST_NAME,
                HOST_ADDRESS,
                errorMessage,
                className,
                methodName,
                throwable.getClass().getName(),
                throwable.getMessage(),
                parameters,
                body));
    }

    /**
     * 打印错误日志
     *
     * @param errorMessage：错误描述
     * @param className：出错类
     * @param methodName：出错方法
     * @param throwable：异常类
     * @param parameters：请求参数
     */
    public static void error(String errorMessage, String className, String methodName, Throwable throwable, Map<String, String> parameters) {
        if (LOG_STACK_INFO) {
            obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s:%s.%s-%s-%s-%s-%s", HOST_NAME, HOST_ADDRESS, errorMessage, className, methodName, obtainStackInfos(throwable), throwable.getClass().getName(), throwable.getMessage(), parameters));
        } else {
            obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s:%s.%s-%s-%s-%s", HOST_NAME, HOST_ADDRESS, errorMessage, className, methodName, throwable.getClass().getName(), throwable.getMessage(), parameters));
        }
    }

    /**
     * 打印错误日志
     *
     * @param errorMessage：错误描述
     * @param className：出错类
     * @param methodName：出错方法
     * @param throwable：异常类
     * @param body：请求体
     */
    public static void error(String errorMessage, String className, String methodName, Throwable throwable, String body) {
        if (LOG_STACK_INFO) {
            obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s:%s.%s-%s-%s-%s-%s",
                    HOST_NAME,
                    HOST_ADDRESS,
                    errorMessage,
                    className,
                    methodName,
                    obtainStackInfos(throwable),
                    throwable.getClass().getName(),
                    throwable.getMessage(),
                    body));
            return;
        }
        obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s:%s.%s-%s-%s-%s",
                HOST_NAME,
                HOST_ADDRESS,
                errorMessage,
                className,
                methodName,
                throwable.getClass().getName(),
                throwable.getMessage(),
                body));
    }

    /**
     * 打印错误日志
     *
     * @param errorMessage：错误描述
     * @param className：出错类
     * @param methodName：出错方法
     * @param throwable：异常类
     */
    public static void error(String errorMessage, String className, String methodName, Throwable throwable) {
        if (LOG_STACK_INFO) {
            obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s:%s.%s-%s-%s-%s",
                    errorMessage,
                    className,
                    methodName,
                    obtainStackInfos(throwable),
                    throwable.getClass().getName(),
                    throwable.getMessage()));
            return;
        }
        obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s:%s.%s-%s-%s",
                errorMessage,
                className,
                methodName,
                throwable.getClass().getName(),
                throwable.getMessage()));
    }

    /**
     * 打印错误日志
     *
     * @param message：错误信息
     */
    public static void error(String message) {
        obtainLogger(new Exception().getStackTrace()[1].getClassName()).error(String.format("%s-%s-%s", HOST_NAME, HOST_ADDRESS, message));
    }

    public static String obtainStackInfos(Throwable throwable) {
        List<Map<String, Object>> stackInfos = new ArrayList<Map<String, Object>>();
        StackTraceElement[] stackTraceElements = throwable.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            Map<String, Object> stackInfo = new HashMap<String, Object>();
            stackInfo.put("className", stackTraceElement.getClassName());
            stackInfo.put("fileName", stackTraceElement.getFileName());
            stackInfo.put("methodName", stackTraceElement.getMethodName());
            stackInfo.put("lineNumber", stackTraceElement.getLineNumber());
            stackInfos.add(stackInfo);
        }
        return JacksonUtils.writeValueAsString(stackInfos);
    }
}
