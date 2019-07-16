package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.sms.SendSmsModel;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SmsUtils {
    /**
     * 阿里云配置
     */
    private static final String ACCESS_KEY_ID = ConfigurationUtils.getConfiguration(Constants.ALIYUN_ACCESS_KEY_ID);
    private static final String ACCESS_KEY_SECRET = ConfigurationUtils.getConfiguration(Constants.ALIYUN_ACCESS_KEY_SECRET);
    private static final String VERIFICATION_CODE_TEMPLATE_CODE = ConfigurationUtils.getConfiguration(Constants.ALIYUN_SMS_API_VERIFICATION_CODE_TEMPLATE_CODE);
    private static final String AGENT_ACCOUNT_TEMPLATE_CODE = ConfigurationUtils.getConfiguration(Constants.ALIYUN_SMS_API_AGENT_ACCOUNT_TEMPLATE_CODE);
    private static final String SIGN_NAME = ConfigurationUtils.getConfiguration(Constants.ALIYUN_SMS_API_SIGN_NAME);
    private static final String DY_SMS_API_URL = "https://dysmsapi.aliyuncs.com";

    /**
     * 荣联配置
     */
    private static final String ACCOUNT_SID = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_ACCOUNT_SID);
    private static final String AUTH_TOKEN = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_AUTH_TOKEN);
    private static final String APP_ID = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_APP_ID);
    private static final String VERIFICATION_CODE_TEMPLATE_ID = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_VERIFICATION_CODE_TEMPLATE_ID);
    private static final String AGENT_ACCOUNT_TEMPLATE_ID = ConfigurationUtils.getConfiguration(Constants.CLOOPEN_AGENT_ACCOUNT_TEMPLATE_ID);

    /**
     * 短信通道配置
     */
    private static final String SMS_CHANNEL = ConfigurationUtils.getConfiguration(Constants.SMS_CHANNEL);

    /**
     * 验证短信通道配置
     */
    private static void validateSmsChannelConfig() {
        ValidateUtils.isTrue(Constants.SMS_CHANNEL_ALIYUN.equals(SMS_CHANNEL) || Constants.SMS_CHANNEL_RONG_LIAN.equals(SMS_CHANNEL), "未配置短信通道");
    }

    /**
     * 发送验证码
     *
     * @param phoneNumber
     */
    public static void sendVerificationCode(String phoneNumber) {
        validateSmsChannelConfig();
        String code = RandomStringUtils.randomNumeric(6);
        if (Constants.SMS_CHANNEL_ALIYUN.equals(SMS_CHANNEL)) {
            Map<String, Object> templateParamMap = new HashMap<String, Object>();
            templateParamMap.put("code", code);
            SendSmsModel sendSmsModel = SendSmsModel.builder()
                    .phoneNumbers(phoneNumber)
                    .signName(SIGN_NAME)
                    .templateCode(VERIFICATION_CODE_TEMPLATE_CODE)
                    .templateParam(JacksonUtils.writeValueAsString(templateParamMap))
                    .build();
            AliyunSmsUtils.sendSms(sendSmsModel);
        } else if (Constants.SMS_CHANNEL_RONG_LIAN.equals(SMS_CHANNEL)) {
            List<String> datas = new ArrayList<String>();
            datas.add(code);
            build.dream.common.models.cloopen.SendSmsModel sendSmsModel = build.dream.common.models.cloopen.SendSmsModel.builder()
                    .accountSid(ACCOUNT_SID)
                    .authToken(AUTH_TOKEN)
                    .appId(APP_ID)
                    .to(phoneNumber)
                    .templateId(VERIFICATION_CODE_TEMPLATE_ID)
                    .datas(datas)
                    .build();
            RongLianUtils.sendSms(sendSmsModel);
        }
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
        validateSmsChannelConfig();
        if (Constants.SMS_CHANNEL_ALIYUN.equals(SMS_CHANNEL)) {
            Map<String, Object> templateParamMap = new HashMap<String, Object>();
            templateParamMap.put("code", code);
            templateParamMap.put("password", password);
            SendSmsModel sendSmsModel = SendSmsModel.builder()
                    .phoneNumbers(phoneNumber)
                    .signName(SIGN_NAME)
                    .templateCode(AGENT_ACCOUNT_TEMPLATE_CODE)
                    .templateParam(JacksonUtils.writeValueAsString(templateParamMap))
                    .build();
            AliyunSmsUtils.sendSms(sendSmsModel);
        } else if (Constants.SMS_CHANNEL_RONG_LIAN.equals(SMS_CHANNEL)) {
            List<String> datas = new ArrayList<String>();
            datas.add(code);
            datas.add(password);
            build.dream.common.models.cloopen.SendSmsModel sendSmsModel = build.dream.common.models.cloopen.SendSmsModel.builder()
                    .accountSid(ACCOUNT_SID)
                    .authToken(AUTH_TOKEN)
                    .appId(APP_ID)
                    .to(phoneNumber)
                    .templateId(AGENT_ACCOUNT_TEMPLATE_ID)
                    .datas(datas)
                    .build();
            RongLianUtils.sendSms(sendSmsModel);
        }
    }
}
