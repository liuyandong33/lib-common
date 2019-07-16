package build.dream.common.sms;

import build.dream.common.constants.Constants;
import build.dream.common.models.cloopen.SendSmsModel;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.RongLianUtils;

import java.util.ArrayList;
import java.util.List;

public class RongLianSmsSender implements SmsSender {
    private static final String ACCOUNT_SID = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_ACCOUNT_SID);
    private static final String AUTH_TOKEN = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_AUTH_TOKEN);
    private static final String APP_ID = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_APP_ID);
    private static final String VERIFICATION_CODE_TEMPLATE_ID = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_VERIFICATION_CODE_TEMPLATE_ID);
    private static final String AGENT_ACCOUNT_TEMPLATE_ID = ConfigurationUtils.getConfiguration(Constants.RONG_LIAN_AGENT_ACCOUNT_TEMPLATE_ID);

    @Override
    public void sendVerificationCode(String phoneNumber, String code, int timeout) {
        List<String> datas = new ArrayList<String>();
        datas.add(code);
        datas.add(String.valueOf(timeout));
        SendSmsModel sendSmsModel = SendSmsModel.builder()
                .accountSid(ACCOUNT_SID)
                .authToken(AUTH_TOKEN)
                .appId(APP_ID)
                .to(phoneNumber)
                .templateId(VERIFICATION_CODE_TEMPLATE_ID)
                .datas(datas)
                .build();
        RongLianUtils.sendSms(sendSmsModel);
    }

    @Override
    public void sendAgentAccount(String phoneNumber, String code, String password) {
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
