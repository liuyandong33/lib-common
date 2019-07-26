package build.dream.common.sms;

import build.dream.common.constants.Constants;

public class SmsHelperFactory {
    public static SmsHelper buildSmsSender(String smsChannel) {
        if (Constants.SMS_CHANNEL_ALIYUN.equals(smsChannel)) {
            return new AliyunSmsHelper();
        }

        if (Constants.SMS_CHANNEL_RONG_LIAN.equals(smsChannel)) {
            return new RongLianSmsHelper();
        }

        if (Constants.SMS_CHANNEL_JPUSH.equals(smsChannel)) {
            return new JPushSmsHelper();
        }

        return null;
    }
}
