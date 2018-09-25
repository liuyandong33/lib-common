package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.sms.SendSmsModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class SmsUtils {
    private static final String ACCESS_KEY_ID = ConfigurationUtils.getConfiguration(Constants.ALIYUN_ACCESS_KEY_ID);
    private static final String ACCESS_SECRET = ConfigurationUtils.getConfiguration(Constants.ALIYUN_ACCESS_KEY_SECRET);
    private static final String DY_SMS_API_URL = "http://dysmsapi.aliyuncs.com";

    public static Map<String, Object> sendSms(SendSmsModel sendSmsModel) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("AccessKeyId", ACCESS_KEY_ID);
        requestParameters.put("Timestamp", new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date()));
        requestParameters.put("Format", Constants.JSON);
        requestParameters.put("SignatureMethod", Constants.HMAC_SHA1);
        requestParameters.put("SignatureVersion", "1.0");
        requestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        requestParameters.put("Action", "SendSms");
        requestParameters.put("Version", "2017-05-25");
        requestParameters.put("RegionId", "cn-hangzhou");
        requestParameters.put("PhoneNumbers", sendSmsModel.getPhoneNumbers());
        requestParameters.put("SignName", sendSmsModel.getSignName());
        requestParameters.put("TemplateCode", sendSmsModel.getTemplateCode());
        requestParameters.put("TemplateParam", sendSmsModel.getTemplateParam());
        requestParameters.put("OutId", sendSmsModel.getOutId());
        requestParameters.put("Signature", generateSignature(requestParameters, ACCESS_SECRET));

        WebResponse webResponse = OutUtils.doPostWithRequestParameters(DY_SMS_API_URL, requestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        String code = MapUtils.getString(resultMap, "Code");
        ValidateUtils.isTrue(Constants.OK.equals(code), MapUtils.getString(resultMap, "Message"));
        return resultMap;
    }

    public static String generateSignature(Map<String, String> requestParameters, String accessSecret) {
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>(requestParameters);
        List<String> requestParameterPairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedRequestParameters.entrySet()) {
            requestParameterPairs.add(entry.getKey() + "=" + UrlUtils.encode(entry.getValue(), Constants.CHARSET_NAME_UTF_8));
        }
        return Base64.encodeBase64String(HmacUtils.hmacSha1(accessSecret, StringUtils.join(requestParameterPairs, "&")));
    }
}
