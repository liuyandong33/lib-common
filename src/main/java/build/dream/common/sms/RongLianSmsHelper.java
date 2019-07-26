package build.dream.common.sms;

import build.dream.common.constants.Constants;
import build.dream.common.models.ronglian.SendSmsModel;
import build.dream.common.utils.CommonRedisUtils;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.RongLianUtils;
import build.dream.common.utils.SmsUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RongLianSmsHelper implements SmsHelper {
    private static final String VERIFICATION_CODE_TEMPLATE_ID = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_VERIFICATION_CODE_TEMPLATE_ID);
    private static final String AGENT_ACCOUNT_TEMPLATE_ID = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_AGENT_ACCOUNT_TEMPLATE_ID);

    @Override
    public void sendVerificationCode(String phoneNumber) {
        String code = RandomStringUtils.randomNumeric(6);
        int timeout = SmsUtils.obtainVerificationCodeTimeout();

        List<String> datas = new ArrayList<String>();
        datas.add(code);
        datas.add(String.valueOf(timeout));
        SendSmsModel sendSmsModel = SendSmsModel.builder()
                .accountSid(RongLianUtils.ACCOUNT_SID)
                .authToken(RongLianUtils.AUTH_TOKEN)
                .appId(RongLianUtils.APP_ID)
                .to(phoneNumber)
                .templateId(VERIFICATION_CODE_TEMPLATE_ID)
                .datas(datas)
                .build();
        RongLianUtils.sendSms(sendSmsModel);
        CommonRedisUtils.setex(phoneNumber, code, SmsUtils.obtainVerificationCodeTimeout(), TimeUnit.MINUTES);
    }

    @Override
    public boolean verifyVerificationCode(String phoneNumber, String code) {
        return code.equals(CommonRedisUtils.get(phoneNumber));
    }

    @Override
    public void sendAgentAccount(String phoneNumber, String code, String password) {
        List<String> datas = new ArrayList<String>();
        datas.add(code);
        datas.add(password);
        SendSmsModel sendSmsModel = SendSmsModel.builder()
                .accountSid(RongLianUtils.ACCOUNT_SID)
                .authToken(RongLianUtils.AUTH_TOKEN)
                .appId(RongLianUtils.APP_ID)
                .to(phoneNumber)
                .templateId(AGENT_ACCOUNT_TEMPLATE_ID)
                .datas(datas)
                .build();
        RongLianUtils.sendSms(sendSmsModel);
    }
}
