package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CloopenUtils {
    private static final String BASE_URL = "https://app.cloopen.com:8883";

    public static Map<String, Object> sendSms(String accountSid, String authToken, String appId, String to, String templateId, List<String> datas) {
        Date now = new Date();

        String timestamp = CustomDateUtils.format(now, "yyyyMMddHHmmss");
        String sig = DigestUtils.md2Hex(accountSid + authToken + timestamp).toUpperCase();
        String url = BASE_URL + "/" + CustomDateUtils.format(now, "yyyy-MM-dd") + "/Accounts/" + accountSid + "/SMS/TemplateSMS?sig=" + sig;

        String authorization = Base64.encodeBase64String(StringUtils.getBytesUtf8(accountSid + "," + timestamp));

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json;charset=utf-8");
        headers.put("Authorization", authorization);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("to", to);
        body.put("appId", appId);
        body.put("templateId", templateId);
        body.put("datas", datas);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, headers, GsonUtils.toJson(body));
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        String statusCode = MapUtils.getString(resultMap, "statusCode");
        ValidateUtils.isTrue("000000".equals(statusCode), "短信发送失败！");
        return resultMap;
    }

    /**
     * 发送短信验证码
     *
     * @param phoneNumber
     * @return
     */
    public static String sendAuthCode(String phoneNumber, long timeout) {
        String accountSid = "";
        String authToken = "";
        String appId = "";
        String to = "";
        String templateId = "";
        List<String> datas = new ArrayList<String>();

        String authCode = RandomStringUtils.randomNumeric(6);
        datas.add(authCode);
        datas.add(String.valueOf(timeout));

        CommonRedisUtils.setex(phoneNumber, authCode, timeout, TimeUnit.MINUTES);

        sendSms(accountSid, authToken, appId, to, templateId, datas);
        return authCode;
    }

    /**
     * 发送短信验证码
     *
     * @param phoneNumber
     * @return
     */
    public static String sendAuthCode(String phoneNumber) {
        return sendAuthCode(phoneNumber, 15);
    }

    /**
     * 验证验证码
     *
     * @param phoneNumber
     * @param authCode
     * @return
     */
    public static boolean verifyAuthCode(String phoneNumber, String authCode) {
        String cachedAuthCode = CommonRedisUtils.get(phoneNumber);
        return authCode.equals(cachedAuthCode);
    }
}
