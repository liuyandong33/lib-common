package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.cloopen.SendSmsModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CloopenUtils {
    private static final String ACCOUNT_SID = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_ACCOUNT_SID);
    private static final String AUTH_TOKEN = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_AUTH_TOKEN);
    private static final String APP_ID = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_APP_ID);
    private static final String VERIFICATION_CODE_TEMPLATE_ID = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_VERIFICATION_CODE_TEMPLATE_ID);
    private static final String AGENT_ACCOUNT_TEMPLATE_ID = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_AGENT_ACCOUNT_TEMPLATE_ID);
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
        headers.put("Content-Type", "application/json;charset=utf-8");
        headers.put("Authorization", authorization);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("to", to);
        body.put("appId", appId);
        body.put("templateId", templateId);
        body.put("datas", datas);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, headers, JacksonUtils.writeValueAsString(body));
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        String statusCode = MapUtils.getString(resultMap, "statusCode");
        ValidateUtils.isTrue("000000".equals(statusCode), "短信发送失败！");
        return resultMap;
    }

    /**
     * 发送验证码
     *
     * @param phoneNumber
     */
    public static void sendVerificationCode(String phoneNumber) {
        String code = RandomStringUtils.randomNumeric(6);
        List<String> datas = new ArrayList<String>();
        datas.add(code);
        SendSmsModel sendSmsModel = SendSmsModel.builder()
                .accountSid(ACCOUNT_SID)
                .authToken(AUTH_TOKEN)
                .appId(APP_ID)
                .to(phoneNumber)
                .templateId(VERIFICATION_CODE_TEMPLATE_ID)
                .datas(datas)
                .build();
        sendSms(sendSmsModel);
        CommonRedisUtils.setex(phoneNumber, code, 5, TimeUnit.MINUTES);
    }

    /**
     * 验证验证码
     *
     * @param phoneNumber
     * @param code
     * @return
     */
    public static boolean verifyVerificationCode(String phoneNumber, String code) {
        return code.equals(CommonRedisUtils.get(phoneNumber));
    }

    /**
     * 发送代理商账号
     *
     * @param phoneNumber
     * @param code
     * @param password
     */
    public static void sendAgentAccount(String phoneNumber, String code, String password) {
        List<String> datas = new ArrayList<String>();
        datas.add(code);
        datas.add(password);
        SendSmsModel sendSmsModel = SendSmsModel.builder()
                .accountSid(ACCOUNT_SID)
                .authToken(AUTH_TOKEN)
                .appId(APP_ID)
                .to(phoneNumber)
                .templateId(AGENT_ACCOUNT_TEMPLATE_ID)
                .datas(datas)
                .build();
        sendSms(sendSmsModel);
    }
}
