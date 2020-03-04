package build.dream.common.sms;

import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.constants.Constants;
import build.dream.common.models.aliyunsms.SendSmsModel;
import build.dream.common.utils.*;
import org.apache.commons.lang.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AliyunSmsHelper implements SmsHelper {
    /**
     * 阿里云短信服务配置
     */
    private static final String VERIFICATION_CODE_TEMPLATE_CODE = ConfigurationUtils.getConfiguration(ConfigurationKeys.ALIYUN_SMS_API_VERIFICATION_CODE_TEMPLATE_CODE);
    private static final String AGENT_ACCOUNT_TEMPLATE_CODE = ConfigurationUtils.getConfiguration(ConfigurationKeys.ALIYUN_SMS_API_AGENT_ACCOUNT_TEMPLATE_CODE);

    @Override
    public void sendVerificationCode(String phoneNumber) {
        String code = RandomStringUtils.randomNumeric(6);

        Map<String, Object> templateParamMap = new HashMap<String, Object>();
        templateParamMap.put("code", code);
        SendSmsModel sendSmsModel = SendSmsModel.builder()
                .phoneNumbers(phoneNumber)
                .signName(AliyunSmsUtils.SIGN_NAME)
                .templateCode(VERIFICATION_CODE_TEMPLATE_CODE)
                .templateParam(JacksonUtils.writeValueAsString(templateParamMap))
                .build();
        AliyunSmsUtils.sendSms(sendSmsModel);
        CommonRedisUtils.setex(phoneNumber, code, SmsUtils.obtainVerificationCodeTimeout(), TimeUnit.MINUTES);
    }

    @Override
    public boolean verifyVerificationCode(String phoneNumber, String code) {
        return code.equals(CommonRedisUtils.get(phoneNumber));
    }

    @Override
    public void sendAgentAccount(String phoneNumber, String code, String password) {
        Map<String, Object> templateParamMap = new HashMap<String, Object>();
        templateParamMap.put("code", code);
        templateParamMap.put("password", password);
        SendSmsModel sendSmsModel = SendSmsModel.builder()
                .phoneNumbers(phoneNumber)
                .signName(AliyunSmsUtils.SIGN_NAME)
                .templateCode(AGENT_ACCOUNT_TEMPLATE_CODE)
                .templateParam(JacksonUtils.writeValueAsString(templateParamMap))
                .build();
        AliyunSmsUtils.sendSms(sendSmsModel);
    }
}
