package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.sms.AliyunSmsSender;
import build.dream.common.sms.RongLianSmsSender;
import build.dream.common.sms.SmsSender;
import org.apache.commons.lang.RandomStringUtils;

import java.util.concurrent.TimeUnit;

public class SmsUtils {
    /**
     * 短信通道配置
     */
    private static final String SMS_CHANNEL = ConfigurationUtils.getConfiguration(Constants.SMS_CHANNEL);
    private static SmsSender SMS_SENDER = null;

    public static void initSmsSender() {
        if (Constants.SMS_CHANNEL_ALIYUN.equals(SMS_CHANNEL)) {
            SMS_SENDER = new AliyunSmsSender();
        } else if (Constants.SMS_CHANNEL_RONG_LIAN.equals(SMS_CHANNEL)) {
            SMS_SENDER = new RongLianSmsSender();
        }
    }

    static {
        initSmsSender();
    }

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
        SMS_SENDER.sendVerificationCode(phoneNumber, code, 5);
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
        SMS_SENDER.sendAgentAccount(phoneNumber, code, password);
    }
}
