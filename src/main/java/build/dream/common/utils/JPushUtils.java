package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.jpush.CodesModel;
import build.dream.common.models.jpush.PushModel;
import build.dream.common.models.jpush.ValidCodeModel;
import build.dream.common.models.jpush.VoiceCodesModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Map;

public class JPushUtils {
    private static final String APP_KEY = ConfigurationUtils.getConfiguration(Constants.JPUSH_APP_KEY);
    private static final String MASTER_SECRET = ConfigurationUtils.getConfiguration(Constants.JPUSH_MASTER_SECRET);
    private static final String JPUSH_PUSH_SERVICE_URL = ConfigurationUtils.getConfiguration(Constants.JPUSH_PUSH_SERVICE_URL);
    private static final String JPUSH_SMS_SERVICE_URL = ConfigurationUtils.getConfiguration(Constants.JPUSH_SMS_SERVICE_URL);
    public static final String SIGN_ID = ConfigurationUtils.getConfiguration(Constants.JPUSH_SMS_SIGN_ID);

    public static Map<String, String> buildHeaders(String appKey, String masterSecret) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Basic " + Base64.encodeBase64String((appKey + ":" + masterSecret).getBytes(Constants.CHARSET_UTF_8)));
        headers.put("Content-Type", Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        return headers;
    }

    /**
     * 调用jpush api
     *
     * @param appKey
     * @param masterSecret
     * @param url
     * @param requestBody
     * @return
     */
    public static Map<String, Object> callJPushApi(String appKey, String masterSecret, String url, String requestBody) {
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(appKey, masterSecret), requestBody);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        return resultMap;
    }

    /**
     * 调用jpush api
     *
     * @param appKey
     * @param masterSecret
     * @param url
     * @param requestParameters
     * @return
     */
    public static Map<String, Object> callJPushApi(String appKey, String masterSecret, String url, Map<String, String> requestParameters) {
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, buildHeaders(appKey, masterSecret), requestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        return resultMap;
    }

    /**
     * 调用jpush api
     *
     * @param url
     * @param requestBody
     * @return
     */
    public static Map<String, Object> callJPushApi(String url, String requestBody) {
        return callJPushApi(APP_KEY, MASTER_SECRET, url, requestBody);
    }

    /**
     * 调用jpush api
     *
     * @param url
     * @param requestParameters
     * @return
     */
    public static Map<String, Object> callJPushApi(String url, Map<String, String> requestParameters) {
        return callJPushApi(APP_KEY, MASTER_SECRET, url, requestParameters);
    }

    /**
     * 推送
     *
     * @param pushModel
     * @return
     */
    public static Map<String, Object> push(PushModel pushModel) {
        pushModel.validateAndThrow();
        return push(JacksonUtils.writeValueAsString(pushModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 推送
     *
     * @param message
     * @return
     */
    public static Map<String, Object> push(String message) {
        return callJPushApi(JPUSH_PUSH_SERVICE_URL + "/push", message);
    }

    /**
     * 发送文本验证码短信 API
     *
     * @return
     */
    public static Map<String, Object> codes(CodesModel codesModel) {
        codesModel.validateAndThrow();
        return callJPushApi(JPUSH_SMS_SERVICE_URL + "/codes", JacksonUtils.writeValueAsString(codesModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 发送语音验证码短信 API
     *
     * @param voiceCodesModel
     * @return
     */
    public static Map<String, Object> voiceCodes(VoiceCodesModel voiceCodesModel) {
        voiceCodesModel.validateAndThrow();
        return callJPushApi(JPUSH_SMS_SERVICE_URL + "/voice_codes", JacksonUtils.writeValueAsString(voiceCodesModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 验证码验证 API
     *
     * @param validCodeModel
     * @return
     */
    public static Map<String, Object> validCode(ValidCodeModel validCodeModel) {
        validCodeModel.validateAndThrow();

        String msgId = validCodeModel.getMsgId();
        String code = validCodeModel.getCode();

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("code", code);
        return callJPushApi(JPUSH_SMS_SERVICE_URL + "/codes/" + msgId + "/valid ", JacksonUtils.writeValueAsString(body));
    }
}
