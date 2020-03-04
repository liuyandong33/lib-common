package build.dream.common.utils;

import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.constants.Constants;
import build.dream.common.sms.SmsHelper;
import build.dream.common.sms.SmsHelperFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

public class SmsUtils {
    /**
     * 短信通道配置
     */
    private static final String SMS_CHANNEL = ConfigurationUtils.getConfiguration(ConfigurationKeys.SMS_CHANNEL);
    private static final SmsHelper SMS_HELPER = SmsHelperFactory.buildSmsSender(SMS_CHANNEL);
    private static final String VERIFICATION_CODE_TIMEOUT = ConfigurationUtils.getConfiguration(ConfigurationKeys.VERIFICATION_CODE_TIMEOUT);

    /**
     * 验证短信通道配置
     */
    private static void validateSmsChannelConfig() {
        ValidateUtils.isTrue(Constants.SMS_CHANNEL_ALIYUN.equals(SMS_CHANNEL) || Constants.SMS_CHANNEL_RONG_LIAN.equals(SMS_CHANNEL), "未配置短信通道");
    }

    /**
     * 验证短信发送次数
     *
     * @param phoneNumber
     */
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
     * 获取验证码有效期
     *
     * @return
     */
    public static int obtainVerificationCodeTimeout() {
        if (StringUtils.isNotBlank(VERIFICATION_CODE_TIMEOUT)) {
            return Integer.parseInt(VERIFICATION_CODE_TIMEOUT);
        }
        return 5;
    }

    /**
     * 发送验证码
     *
     * @param phoneNumber
     */
    public static void sendVerificationCode(String phoneNumber) {
        validateSmsChannelConfig();
        validateSendTimes(phoneNumber);
        SMS_HELPER.sendVerificationCode(phoneNumber);
    }

    /**
     * 验证验证码
     *
     * @param phoneNumber
     * @param code
     * @return
     */
    public static boolean verifyVerificationCode(String phoneNumber, String code) {
        return SMS_HELPER.verifyVerificationCode(phoneNumber, code);
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
        SMS_HELPER.sendAgentAccount(phoneNumber, code, password);
    }
}
