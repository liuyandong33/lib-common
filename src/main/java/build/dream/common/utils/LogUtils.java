package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/7.
 */
public class LogUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogUtils.class);
    private static final boolean LOG_STACK_INFO = Boolean.parseBoolean(ConfigurationUtils.getConfiguration(Constants.LOG_STACK_INFO));

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void error(String errorMessage, String className, String methodName, Throwable throwable, Map<String, String> parameters) {
        if (LOG_STACK_INFO) {
            LOGGER.error(String.format("%s:%s.%s-%s-%s-%s-%s", errorMessage, className, methodName, obtainStackInfos(throwable), throwable.getClass().getName(), throwable.getMessage(), parameters));
        } else {
            LOGGER.error(String.format("%s:%s.%s-%s-%s-%s", errorMessage, className, methodName, throwable.getClass().getName(), throwable.getMessage(), parameters));
        }
    }

    public static void error(String errorMessage, String className, String methodName, Throwable throwable) {
        if (LOG_STACK_INFO) {
            LOGGER.error(String.format("%s:%s.%s-%s-%s-%s", errorMessage, className, methodName, obtainStackInfos(throwable), throwable.getClass().getName(), throwable.getMessage()));
        } else {
            LOGGER.error(String.format("%s:%s.%s-%s-%s", errorMessage, className, methodName, throwable.getClass().getName(), throwable.getMessage()));
        }
    }

    public static void error(String errorMessage) {
        LOGGER.error(errorMessage);
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
        return GsonUtils.toJson(stackInfos);
    }
}
