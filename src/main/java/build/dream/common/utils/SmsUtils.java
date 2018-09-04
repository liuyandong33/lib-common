package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class SmsUtils {
    public static ApiRest sendSms(String phoneNumbers, String signName, String templateCode, String templateParam, String smsUpExtendCode, String outId) throws IOException {
        String accessKeyId = null;
        String accessSecret = null;
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("AccessKeyId", accessKeyId);
        requestParameters.put("Timestamp", new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date()));
        requestParameters.put("Format", Constants.JSON);
        requestParameters.put("SignatureMethod", Constants.HMAC_SHA1);
        requestParameters.put("SignatureVersion", "1.0");
        requestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        requestParameters.put("Action", "SendSms");
        requestParameters.put("Version", "2017-05-25");
        requestParameters.put("RegionId", "cn-hangzhou");
        requestParameters.put("PhoneNumbers", phoneNumbers);
        requestParameters.put("SignName", signName);
        requestParameters.put("TemplateCode", templateCode);
        requestParameters.put("TemplateParam", templateParam);
        requestParameters.put("SmsUpExtendCode", smsUpExtendCode);
        requestParameters.put("OutId", outId);
        requestParameters.put("Signature", sign(requestParameters, accessSecret));

        String url = "http://dysmsapi.aliyuncs.com";
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, null, requestParameters);
        JSONObject resultJsonObject = JSONObject.fromObject(webResponse.getResult());
        String code = resultJsonObject.getString("Code");
        ValidateUtils.isTrue(Constants.OK.equals(code), resultJsonObject.getString("Message"));
        return new ApiRest(resultJsonObject, "短信发送成功！");
    }

    public static String sign(Map<String, String> requestParameters, String accessSecret) throws UnsupportedEncodingException {
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>(requestParameters);
        List<String> requestParameterPairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedRequestParameters.entrySet()) {
            requestParameterPairs.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), Constants.CHARSET_NAME_UTF_8));
        }
        return Base64.encodeBase64String(HmacUtils.hmacSha1(accessSecret, StringUtils.join(requestParameterPairs, "&")));
    }
}
