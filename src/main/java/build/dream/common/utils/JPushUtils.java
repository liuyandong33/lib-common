package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.jpush.PushModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JPushUtils {
    public static String callJPushSystem(String appKey, String masterSecret, String url, String requestBody) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Basic " + Base64.encodeBase64String((appKey + ":" + masterSecret).getBytes(Constants.CHARSET_NAME_UTF_8)));
        headers.put("Content-Type", "application/json");
        WebResponse webResponse = WebUtils.doPostWithRequestBody(url, headers, requestBody, Constants.CHARSET_NAME_UTF_8, null);
        return webResponse.getResult();
    }

    public static String callJPushSystem(String appKey, String masterSecret, String url, Map<String, String> requestParameters) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Basic " + Base64.encodeBase64String((appKey + ":" + masterSecret).getBytes(Constants.CHARSET_NAME_UTF_8)));
        headers.put("Content-Type", "application/json");

        String queryString = WebUtils.buildQueryString(requestParameters);
        WebResponse webResponse = OutUtils.doGet(StringUtils.isNotBlank(queryString) ? url + "?" + queryString : url, headers);
        return webResponse.getResult();
    }

    public static String callJPushSystem(String url, String requestBody) throws IOException {
        String appKey = ConfigurationUtils.getConfiguration(Constants.JPUSH_APP_KEY);
        String masterSecret = ConfigurationUtils.getConfiguration(Constants.JPUSH_MASTER_SECRET);
        return callJPushSystem(appKey, masterSecret, url, requestBody);
    }

    public static String callJPushSystem(String url, Map<String, String> requestParameters) throws IOException {
        String appKey = ConfigurationUtils.getConfiguration(Constants.JPUSH_APP_KEY);
        String masterSecret = ConfigurationUtils.getConfiguration(Constants.JPUSH_MASTER_SECRET);
        return callJPushSystem(appKey, masterSecret, url, requestParameters);
    }

    public static Map<String, Object> push(PushModel pushModel) throws IOException {
        String url = ConfigurationUtils.getConfiguration(Constants.JPUSH_API_SERVICE_URL) + Constants.JPUSH_PUSH_URI;
        String result = callJPushSystem(url, GsonUtils.toJson(pushModel, false));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }
}
