package build.dream.common.sms;

import build.dream.common.constants.Constants;
import build.dream.common.models.sms.SendSmsModel;
import build.dream.common.utils.AliyunSmsUtils;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.JacksonUtils;

import java.util.HashMap;
import java.util.Map;

public class AliyunSmsSender implements SmsSender {
    /**
     * 阿里云配置
     */
    private static final String VERIFICATION_CODE_TEMPLATE_CODE = ConfigurationUtils.getConfiguration(Constants.ALIYUN_SMS_API_VERIFICATION_CODE_TEMPLATE_CODE);
    private static final String AGENT_ACCOUNT_TEMPLATE_CODE = ConfigurationUtils.getConfiguration(Constants.ALIYUN_SMS_API_AGENT_ACCOUNT_TEMPLATE_CODE);
    private static final String SIGN_NAME = ConfigurationUtils.getConfiguration(Constants.ALIYUN_SMS_API_SIGN_NAME);

    @Override
    public void sendVerificationCode(String phoneNumber, String code) {
        Map<String, Object> templateParamMap = new HashMap<String, Object>();
        templateParamMap.put("code", code);
        SendSmsModel sendSmsModel = SendSmsModel.builder()
                .phoneNumbers(phoneNumber)
                .signName(SIGN_NAME)
                .templateCode(VERIFICATION_CODE_TEMPLATE_CODE)
                .templateParam(JacksonUtils.writeValueAsString(templateParamMap))
                .build();
        AliyunSmsUtils.sendSms(sendSmsModel);
    }

    @Override
    public void sendAgentAccount(String phoneNumber, String code, String password) {
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
    }
}
