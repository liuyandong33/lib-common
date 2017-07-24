package build.dream.common.utils;

import build.dream.common.constants.Constants;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by liuyandong on 2017/7/7.
 */
public class LogUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogUtils.class);

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void error(String errorMessage, String controllerSimpleName, String actionMethodName, String exceptionSimpleName, String exceptionMessage, Map<String, String> requestParameters) {
        LOGGER.error(Constants.LOGGER_ERROR_FORMAT, errorMessage, controllerSimpleName, actionMethodName, exceptionSimpleName, exceptionMessage, requestParameters != null ? requestParameters.toString() : null);
    }

    public static void error(String errorMessage, String controllerSimpleName, String actionMethodName, String exceptionSimpleName, String exceptionMessage) {
        LOGGER.error(Constants.LOGGER_ERROR_FORMAT, errorMessage, controllerSimpleName, actionMethodName, exceptionSimpleName, exceptionMessage, null);
    }

    public static void error(String errorMessage, String controllerSimpleName, String actionMethodName, String exceptionSimpleName, String exceptionMessage, JsonObject jsonObject) {
        LOGGER.error(Constants.LOGGER_ERROR_FORMAT, errorMessage, controllerSimpleName, actionMethodName, exceptionSimpleName, exceptionMessage, jsonObject != null ? jsonObject.toString() : null);
    }

    public static void error(String errorMessage) {
        LOGGER.error(errorMessage);
    }
}
