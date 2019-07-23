package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.sms.SmsSender;
import build.dream.common.sms.SmsSenderFactory;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SmsUtils {
    /**
     * 短信通道配置
     */
    private static final String SMS_CHANNEL = ConfigurationUtils.getConfiguration(Constants.SMS_CHANNEL);
    private static final SmsSender SMS_SENDER = SmsSenderFactory.buildSmsSender(SMS_CHANNEL);

    /**
     * 验证短信通道配置
     */
    private static void validateSmsChannelConfig() {
        ValidateUtils.isTrue(Constants.SMS_CHANNEL_ALIYUN.equals(SMS_CHANNEL) || Constants.SMS_CHANNEL_RONG_LIAN.equals(SMS_CHANNEL), "未配置短信通道");
    }

    private static void validateSendTimes(String phoneNumber) {
        String today = CustomDateUtils.format(new Date(), "yyyyMMdd");
        String key = "_sms_count_" + today + "_" + phoneNumber;
        long count = CommonRedisUtils.incrby(key, 1);
        if (count == 1) {
            Date date = DateUtils.addDays(CustomDateUtils.parse(today + "000000", "yyyyMMddHHmmss"), 1);
            CommonRedisUtils.expireAt(key, date);
        }

        ValidateUtils.isTrue(count <= 50, "手机号【" + phoneNumber + "】今日发送短信已经超过50条！");
    }

    /**
     * 发送验证码
     *
     * @param phoneNumber
     */
    public static void sendVerificationCode(String phoneNumber) {
        validateSmsChannelConfig();
        validateSendTimes(phoneNumber);
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
        validateSendTimes(phoneNumber);
        SMS_SENDER.sendAgentAccount(phoneNumber, code, password);
    }
}
