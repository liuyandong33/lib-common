package build.dream.common.utils;

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

public class AlibabaCloudMobilePushUtils {
    private static final String CLOUD_PUSH_SERVICE_URL = "http://cloudpush.aliyuncs.com";

    public static JSONObject pushMessageToAndroid(String accessKeyId, String accessKeySecret, String appKey, String target, String targetValue, String title, String body) throws IOException {
        return pushMessage(Constants.DEVICE_TYPE_ANDROID, accessKeyId, accessKeySecret, appKey, target, targetValue, title, body);
    }

    public static JSONObject pushMessageToIos(String accessKeyId, String accessKeySecret, String appKey, String target, String targetValue, String title, String body) throws IOException {
        return pushMessage(Constants.DEVICE_TYPE_IOS, accessKeyId, accessKeySecret, appKey, target, targetValue, title, body);
    }

    public static JSONObject pushMessage(int deviceType, String accessKeyId, String accessKeySecret, String appKey, String target, String targetValue, String title, String body) throws IOException {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("Format", Constants.JSON);
        requestParameters.put("RegionId", "cn-hangzhou");
        requestParameters.put("Version", "2016-08-01");
        requestParameters.put("AccessKeyId", accessKeyId);
        requestParameters.put("SignatureMethod", "HMAC-SHA1");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.ISO8601_DATE_PATTERN);
        requestParameters.put("Timestamp", simpleDateFormat.format(new Date()));

        requestParameters.put("SignatureVersion", "1.0");
        requestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        if (deviceType == Constants.DEVICE_TYPE_ANDROID) {
            requestParameters.put("Action", "PushMessageToAndroid");
        } else if (deviceType == Constants.DEVICE_TYPE_IOS) {
            requestParameters.put("Action", "PushMessageToiOS");
        }
        requestParameters.put("AppKey", appKey);
        requestParameters.put("Target", target);
        requestParameters.put("TargetValue", targetValue);
        requestParameters.put("Title", title);
        requestParameters.put("Body", body);
        requestParameters.put("Signature", calculateSignature(accessKeySecret, requestParameters));

        WebResponse webResponse = OutUtils.doGetWithRequestParameters(CLOUD_PUSH_SERVICE_URL, requestParameters);

        JSONObject resultJsonObject = JSONObject.fromObject(webResponse.getResult());
        return resultJsonObject;
    }

    public static String calculateSignature(String accessKeySecret, Map<String, String> requestParameters) throws UnsupportedEncodingException {
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>(requestParameters);
        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedRequestParameters.entrySet()) {
            pairs.add(URLEncoder.encode(entry.getKey(), Constants.CHARSET_NAME_UTF_8) + "=" + URLEncoder.encode(entry.getValue(), Constants.CHARSET_NAME_UTF_8));
        }
        String signature = Base64.encodeBase64String(HmacUtils.hmacSha1(accessKeySecret.getBytes(Constants.CHARSET_NAME_UTF_8), StringUtils.join(pairs, "&").getBytes(Constants.CHARSET_NAME_UTF_8)));
        return signature;
    }
}
