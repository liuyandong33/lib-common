package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.aliyunsms.SendSmsModel;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AliyunSmsUtils {
    public static final String SIGN_NAME = ConfigurationUtils.getConfiguration(Constants.ALIYUN_SMS_API_SIGN_NAME);

    /**
     * 发送短信
     *
     * @param sendSmsModel
     * @return
     */
    public static Map<String, Object> sendSms(SendSmsModel sendSmsModel) {
        sendSmsModel.validateAndThrow();

        String phoneNumbers = sendSmsModel.getPhoneNumbers();
        String signName = sendSmsModel.getSignName();
        String templateCode = sendSmsModel.getTemplateCode();
        String templateParam = sendSmsModel.getTemplateParam();
        String outId = sendSmsModel.getOutId();
        String smsUpExtendCode = sendSmsModel.getSmsUpExtendCode();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "SendSms");
        requestParameters.put("Format", Constants.LOWER_CASE_JSON);
        requestParameters.put("RegionId", "cn-hangzhou");
        requestParameters.put("SignatureMethod", Constants.HMAC_SHA1);
        requestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        requestParameters.put("SignatureVersion", "1.0");
        requestParameters.put("Timestamp", CustomDateUtils.buildISO8601SimpleDateFormat().format(new Date()));
        requestParameters.put("Version", "2017-05-25");
        requestParameters.put("PhoneNumbers", phoneNumbers);
        requestParameters.put("SignName", signName);
        requestParameters.put("TemplateCode", templateCode);
        requestParameters.put("TemplateParam", templateParam);
        if (StringUtils.isNotBlank(outId)) {
            requestParameters.put("OutId", outId);
        }
        if (StringUtils.isNotBlank(smsUpExtendCode)) {
            requestParameters.put("SmsUpExtendCode", smsUpExtendCode);
        }
        requestParameters.put("Signature", AliyunUtils.generateSignature(requestParameters, AliyunUtils.ACCESS_KEY_SECRET));

        String result = OutUtils.doPostWithForm(AliyunUtils.DY_SMS_API_URL, requestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        String code = MapUtils.getString(resultMap, "Code");
        ValidateUtils.isTrue(Constants.OK.equals(code), MapUtils.getString(resultMap, "Message"));
        return resultMap;
    }
}
