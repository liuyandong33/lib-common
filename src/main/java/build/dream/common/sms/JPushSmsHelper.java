package build.dream.common.sms;

import build.dream.common.constants.Constants;
import build.dream.common.models.jpush.CodesModel;
import build.dream.common.models.jpush.ValidCodeModel;
import build.dream.common.utils.CommonRedisUtils;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.JPushUtils;
import build.dream.common.utils.SmsUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JPushSmsHelper implements SmsHelper {
    private static final String VERIFICATION_CODE_TEMPLATE_CODE = ConfigurationUtils.getConfiguration(Constants.JPUSH_SMS_API_VERIFICATION_CODE_TEMP_ID);
    private static final String AGENT_ACCOUNT_TEMPLATE_CODE = ConfigurationUtils.getConfiguration(Constants.JPUSH_SMS_API_AGENT_ACCOUNT_TEMP_ID);

    @Override
    public void sendVerificationCode(String phoneNumber) {
        CodesModel codesModel = CodesModel.builder()
                .mobile(phoneNumber)
                .signId(JPushUtils.SIGN_ID)
                .tempId(VERIFICATION_CODE_TEMPLATE_CODE)
                .build();
        Map<String, Object> result = JPushUtils.codes(codesModel);
        String msgId = MapUtils.getString(result, "msg_id");
        CommonRedisUtils.setex(phoneNumber, msgId, SmsUtils.obtainVerificationCodeTimeout(), TimeUnit.MINUTES);
    }

    @Override
    public boolean verifyVerificationCode(String phoneNumber, String code) {
        String msgId = CommonRedisUtils.get(phoneNumber);
        if (StringUtils.isBlank(msgId)) {
            return false;
        }

        ValidCodeModel validCodeModel = ValidCodeModel.builder()
                .msgId(msgId)
                .code(code)
                .build();
        Map<String, Object> result = JPushUtils.validCode(validCodeModel);
        return MapUtils.getBooleanValue(result, "is_valid");
    }

    @Override
    public void sendAgentAccount(String phoneNumber, String code, String password) {

    }
}
