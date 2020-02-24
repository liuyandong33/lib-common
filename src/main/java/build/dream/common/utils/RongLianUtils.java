package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.ronglian.SendSmsModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RongLianUtils {
    public static final String ACCOUNT_SID = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_ACCOUNT_SID);
    public static final String AUTH_TOKEN = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_AUTH_TOKEN);
    public static final String APP_ID = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_APP_ID);
    private static final String BASE_URL = "https://app.cloopen.com:8883";

    public static Map<String, Object> sendSms(SendSmsModel sendSmsModel) {
        sendSmsModel.validateAndThrow();

        String accountSid = sendSmsModel.getAccountSid();
        String authToken = sendSmsModel.getAuthToken();
        String appId = sendSmsModel.getAppId();
        String to = sendSmsModel.getTo();
        String templateId = sendSmsModel.getTemplateId();
        List<String> datas = sendSmsModel.getDatas();

        String timestamp = CustomDateUtils.format(new Date(), "yyyyMMddHHmmss");
        String sig = DigestUtils.md5Hex(accountSid + authToken + timestamp).toUpperCase();
        String url = BASE_URL + "/2013-12-26/Accounts/" + accountSid + "/SMS/TemplateSMS?sig=" + sig;

        String authorization = Base64.encodeBase64String((accountSid + ":" + timestamp).getBytes(Constants.CHARSET_UTF_8));

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Authorization", authorization);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("to", to);
        body.put("appId", appId);
        body.put("templateId", templateId);
        body.put("datas", datas);

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(body), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8, headers);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        String statusCode = MapUtils.getString(resultMap, "statusCode");
        ValidateUtils.isTrue("000000".equals(statusCode), "短信发送失败！");
        return resultMap;
    }
}
