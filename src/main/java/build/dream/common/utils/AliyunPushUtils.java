package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.aliyunpush.PushMessageToAndroidModel;
import build.dream.common.models.aliyunpush.PushMessageToIosModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class AliyunPushUtils {
    public static final String DEVICE = "DEVICE";
    public static final String ACCOUNT = "ACCOUNT";
    public static final String ALIAS = "ALIAS";
    public static final String TAG = "TAG";
    public static final String ALL = "ALL";

    private static final String CLOUD_PUSH_SERVICE_URL = "http://cloudpush.aliyuncs.com";

    private static String calculateSignature(String accessKeySecret, Map<String, String> requestParameters) {
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>(requestParameters);
        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedRequestParameters.entrySet()) {
            pairs.add(UrlUtils.encode(entry.getKey(), Constants.CHARSET_NAME_UTF_8) + "=" + UrlUtils.encode(entry.getValue(), Constants.CHARSET_NAME_UTF_8));
        }
        String signature = Base64.encodeBase64String(HmacUtils.hmacSha1(accessKeySecret.getBytes(Constants.CHARSET_UTF_8), StringUtils.join(pairs, "&").getBytes(Constants.CHARSET_UTF_8)));
        return signature;
    }

    private static Map<String, String> buildCommonRequestParameters() {
        Map<String, String> commonRequestParameters = new HashMap<String, String>();
        commonRequestParameters.put("Format", Constants.JSON);
        commonRequestParameters.put("RegionId", "cn-hangzhou");
        commonRequestParameters.put("Version", "2018-03-24");
        commonRequestParameters.put("SignatureMethod", "HMAC-SHA1");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.ISO8601_DATE_PATTERN);
        commonRequestParameters.put("Timestamp", simpleDateFormat.format(new Date()));

        commonRequestParameters.put("SignatureVersion", "1.0");
        commonRequestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        return commonRequestParameters;
    }

    private static Map<String, Object> pushMessage(int deviceType, String accessKeyId, String accessKeySecret, String appKey, String target, String targetValue, String title, String body) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.putAll(buildCommonRequestParameters());
        requestParameters.put("AccessKeyId", accessKeyId);
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

        WebResponse webResponse = OutUtils.doPostWithRequestParameters(CLOUD_PUSH_SERVICE_URL, requestParameters);
        String result = webResponse.getResult();

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }

    public static Map<String, Object> pushMessageToAndroid(PushMessageToAndroidModel pushMessageToAndroidModel) {
        pushMessageToAndroidModel.validateAndThrow();
        String accessKeyId = null;
        String accessKeySecret = null;
        return pushMessage(Constants.DEVICE_TYPE_ANDROID, accessKeyId, accessKeySecret, pushMessageToAndroidModel.getAppKey(), pushMessageToAndroidModel.getTarget(), pushMessageToAndroidModel.getTargetValue(), pushMessageToAndroidModel.getTitle(), pushMessageToAndroidModel.getBody());
    }

    public static Map<String, Object> pushMessageToIos(PushMessageToIosModel pushMessageToIosModel) {
        pushMessageToIosModel.validateAndThrow();
        String accessKeyId = null;
        String accessKeySecret = null;
        return pushMessage(Constants.DEVICE_TYPE_IOS, accessKeyId, accessKeySecret, pushMessageToIosModel.getAppKey(), pushMessageToIosModel.getTarget(), pushMessageToIosModel.getTargetValue(), pushMessageToIosModel.getTitle(), pushMessageToIosModel.getBody());
    }

    public static Map<String, Object> listSummaryApps(String accessKeyId, String accessKeySecret) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.putAll(buildCommonRequestParameters());
        requestParameters.put("AccessKeyId", accessKeyId);
        requestParameters.put("Action", "SummaryAppInfos");
        requestParameters.put("Signature", calculateSignature(accessKeySecret, requestParameters));

        WebResponse webResponse = OutUtils.doPostWithRequestParameters(CLOUD_PUSH_SERVICE_URL, requestParameters);
        String result = webResponse.getResult();

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }

    public static Map<String, Object> queryDevicesByAccount(String accessKeyId, String accessKeySecret, String account) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.putAll(buildCommonRequestParameters());
        requestParameters.put("AccessKeyId", accessKeyId);
        requestParameters.put("Action", "QueryDevicesByAccount");
        requestParameters.put("Account", account);
        requestParameters.put("Signature", calculateSignature(accessKeySecret, requestParameters));

        WebResponse webResponse = OutUtils.doPostWithRequestParameters(CLOUD_PUSH_SERVICE_URL, requestParameters);
        String result = webResponse.getResult();

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }

    public static Map<String, Object> bindAlias(String accessKeyId, String accessKeySecret, String deviceId, String aliasName) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.putAll(buildCommonRequestParameters());
        requestParameters.put("AccessKeyId", accessKeyId);
        requestParameters.put("Action", "BindAlias");
        requestParameters.put("DeviceId", deviceId);
        requestParameters.put("AliasName", aliasName);
        requestParameters.put("Signature", calculateSignature(accessKeySecret, requestParameters));
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(CLOUD_PUSH_SERVICE_URL, requestParameters);
        String result = webResponse.getResult();

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }

    public static Map<String, Object> queryAliases(String accessKeyId, String accessKeySecret, String deviceId) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.putAll(buildCommonRequestParameters());
        requestParameters.put("AccessKeyId", accessKeyId);
        requestParameters.put("Action", "QueryAliases");
        requestParameters.put("DeviceId", deviceId);
        requestParameters.put("Signature", calculateSignature(accessKeySecret, requestParameters));
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(CLOUD_PUSH_SERVICE_URL, requestParameters);
        String result = webResponse.getResult();

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }

    public static Map<String, Object> queryDevicesByAlias(String accessKeyId, String accessKeySecret, String alias) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.putAll(buildCommonRequestParameters());
        requestParameters.put("AccessKeyId", accessKeyId);
        requestParameters.put("Action", "QueryDevicesByAlias");
        requestParameters.put("Alias", alias);
        requestParameters.put("Signature", calculateSignature(accessKeySecret, requestParameters));
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(CLOUD_PUSH_SERVICE_URL, requestParameters);
        String result = webResponse.getResult();

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }

    public static Map<String, Object> unbindAlias(String accessKeyId, String accessKeySecret, String deviceId, boolean unbindAll, String aliasName) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.putAll(buildCommonRequestParameters());
        requestParameters.put("AccessKeyId", accessKeyId);
        requestParameters.put("Action", "UnbindAlias");
        requestParameters.put("DeviceId", deviceId);
        requestParameters.put("UnbindAll", String.valueOf(unbindAll));
        if (!unbindAll) {
            requestParameters.put("AliasName", aliasName);
        }
        requestParameters.put("Signature", calculateSignature(accessKeySecret, requestParameters));
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(CLOUD_PUSH_SERVICE_URL, requestParameters);
        String result = webResponse.getResult();

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }
}
