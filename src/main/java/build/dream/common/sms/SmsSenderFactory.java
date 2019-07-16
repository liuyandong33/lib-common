package build.dream.common.sms;

import build.dream.common.constants.Constants;

public class SmsSenderFactory {
    public static SmsSender buildSmsSender(String smsChannel) {
        if (Constants.SMS_CHANNEL_ALIYUN.equals(smsChannel)) {
            return new AliyunSmsSender();
        }

        if (Constants.SMS_CHANNEL_RONG_LIAN.equals(smsChannel)) {
            return new RongLianSmsSender();
        }

        return null;
    }
}
