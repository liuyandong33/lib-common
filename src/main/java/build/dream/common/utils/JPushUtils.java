package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.jpush.PushModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Map;

public class JPushUtils {
    public static Map<String, String> buildHeaders(String appKey, String masterSecret) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Basic " + Base64.encodeBase64String((appKey + ":" + masterSecret).getBytes(Constants.CHARSET_UTF_8)));
        headers.put("Content-Type", Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        return headers;
    }

    public static String callJPushSystem(String appKey, String masterSecret, String url, String requestBody) {
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(appKey, masterSecret), requestBody);
        return webResponse.getResult();
    }

    public static String callJPushSystem(String appKey, String masterSecret, String url, Map<String, String> requestParameters) {
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, buildHeaders(appKey, masterSecret), requestParameters);
        return webResponse.getResult();
    }

    public static String callJPushSystem(String url, String requestBody) {
        String appKey = ConfigurationUtils.getConfiguration(Constants.JPUSH_APP_KEY);
        String masterSecret = ConfigurationUtils.getConfiguration(Constants.JPUSH_MASTER_SECRET);
        return callJPushSystem(appKey, masterSecret, url, requestBody);
    }

    public static String callJPushSystem(String url, Map<String, String> requestParameters) {
        String appKey = ConfigurationUtils.getConfiguration(Constants.JPUSH_APP_KEY);
        String masterSecret = ConfigurationUtils.getConfiguration(Constants.JPUSH_MASTER_SECRET);
        return callJPushSystem(appKey, masterSecret, url, requestParameters);
    }

    public static Map<String, Object> push(PushModel pushModel) {
        pushModel.validateAndThrow();
        return push(JacksonUtils.writeValueAsString(pushModel, JsonInclude.Include.NON_NULL));
    }

    public static Map<String, Object> push(String message) {
        String url = ConfigurationUtils.getConfiguration(Constants.JPUSH_PUSH_SERVICE_URL) + "/push";
        String result = callJPushSystem(url, message);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }
}
