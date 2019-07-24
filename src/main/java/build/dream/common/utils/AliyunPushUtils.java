package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.aliyunpush.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class AliyunPushUtils {
    public static final String TARGET_DEVICE = "DEVICE";
    public static final String TARGET_ACCOUNT = "ACCOUNT";
    public static final String TARGET_ALIAS = "ALIAS";
    public static final String TARGET_TAG = "TAG";
    public static final String TARGET_ALL = "ALL";


    /**
     * 生成签名
     *
     * @param accessKeySecret
     * @param requestParameters
     * @return
     */
    private static String generateSignature(String accessKeySecret, Map<String, String> requestParameters) {
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>(requestParameters);
        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedRequestParameters.entrySet()) {
            pairs.add(UrlUtils.encode(entry.getKey(), Constants.CHARSET_NAME_UTF_8) + "=" + UrlUtils.encode(entry.getValue(), Constants.CHARSET_NAME_UTF_8));
        }
        return Base64.encodeBase64String(HmacUtils.hmacSha1(accessKeySecret, StringUtils.join(pairs, "&")));
    }

    /**
     * 调用阿里云推送api
     *
     * @param requestParameters
     * @return
     */
    public static Map<String, Object> callAliyunPushApi(Map<String, String> requestParameters) {
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(AliyunUtils.CLOUD_PUSH_API_URL, requestParameters);
        String result = webResponse.getResult();

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }

    /**
     * 构建公共参数
     *
     * @return
     */
    private static Map<String, String> buildCommonRequestParameters() {
        Map<String, String> commonRequestParameters = new HashMap<String, String>();
        commonRequestParameters.put("Format", Constants.UPPER_CASE_JSON);
        commonRequestParameters.put("RegionId", "cn-hangzhou");
        commonRequestParameters.put("Version", "2018-03-24");
        commonRequestParameters.put("SignatureMethod", "HMAC-SHA1");

        commonRequestParameters.put("Timestamp", CustomDateUtils.buildISO8601SimpleDateFormat().format(new Date()));

        commonRequestParameters.put("SignatureVersion", "1.0");
        commonRequestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        return commonRequestParameters;
    }

    /**
     * 推送消息
     *
     * @param deviceType
     * @param appKey
     * @param target
     * @param targetValue
     * @param title
     * @param body
     * @return
     */
    private static Map<String, Object> pushMessage(int deviceType, String appKey, String target, String targetValue, String title, String body) {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.putAll(buildCommonRequestParameters());
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
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
        requestParameters.put("Signature", generateSignature(AliyunUtils.ACCESS_KEY_SECRET, requestParameters));

        return callAliyunPushApi(requestParameters);
    }

    /**
     * 推消息给Android设备
     *
     * @param pushMessageModel
     * @return
     */
    public static Map<String, Object> pushMessageToAndroid(PushMessageModel pushMessageModel) {
        pushMessageModel.validateAndThrow();
        return pushMessage(Constants.DEVICE_TYPE_ANDROID, pushMessageModel.getAppKey(), pushMessageModel.getTarget(), pushMessageModel.getTargetValue(), pushMessageModel.getTitle(), pushMessageModel.getBody());
    }

    /**
     * 推消息给iOS设备
     *
     * @param pushMessageModel
     * @return
     */
    public static Map<String, Object> pushMessageToIos(PushMessageModel pushMessageModel) {
        pushMessageModel.validateAndThrow();
        return pushMessage(Constants.DEVICE_TYPE_IOS, pushMessageModel.getAppKey(), pushMessageModel.getTarget(), pushMessageModel.getTargetValue(), pushMessageModel.getTitle(), pushMessageModel.getBody());
    }

    /**
     * APP概览列表
     *
     * @param listSummaryAppsModel
     * @return
     */
    public static Map<String, Object> listSummaryApps(ListSummaryAppsModel listSummaryAppsModel) {
        listSummaryAppsModel.validateAndThrow();

        Map<String, String> requestParameters = buildCommonRequestParameters();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "ListSummaryApps");
        requestParameters.put("Signature", generateSignature(AliyunUtils.ACCESS_KEY_SECRET, requestParameters));
        return callAliyunPushApi(requestParameters);
    }

    /**
     * 通过账户查询设备列表
     *
     * @param queryDevicesByAccountModel
     * @return
     */
    public static Map<String, Object> queryDevicesByAccount(QueryDevicesByAccountModel queryDevicesByAccountModel) {
        queryDevicesByAccountModel.validateAndThrow();

        String account = queryDevicesByAccountModel.getAccount();

        Map<String, String> requestParameters = buildCommonRequestParameters();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "QueryDevicesByAccount");
        requestParameters.put("Account", account);
        requestParameters.put("Signature", generateSignature(AliyunUtils.ACCESS_KEY_SECRET, requestParameters));

        return callAliyunPushApi(requestParameters);
    }

    /**
     * 绑定别名
     *
     * @param bindAliasModel
     * @return
     */
    public static Map<String, Object> bindAlias(BindAliasModel bindAliasModel) {
        bindAliasModel.validateAndThrow();

        String deviceId = bindAliasModel.getDeviceId();
        String aliasName = bindAliasModel.getAliasName();

        Map<String, String> requestParameters = buildCommonRequestParameters();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "BindAlias");
        requestParameters.put("DeviceId", deviceId);
        requestParameters.put("AliasName", aliasName);
        requestParameters.put("Signature", generateSignature(AliyunUtils.ACCESS_KEY_SECRET, requestParameters));
        return callAliyunPushApi(requestParameters);
    }

    /**
     * 查询别名
     *
     * @param queryAliasesModel
     * @return
     */
    public static Map<String, Object> queryAliases(QueryAliasesModel queryAliasesModel) {
        queryAliasesModel.validateAndThrow();

        String deviceId = queryAliasesModel.getDeviceId();

        Map<String, String> requestParameters = buildCommonRequestParameters();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "QueryAliases");
        requestParameters.put("DeviceId", deviceId);
        requestParameters.put("Signature", generateSignature(AliyunUtils.ACCESS_KEY_SECRET, requestParameters));
        return callAliyunPushApi(requestParameters);
    }

    /**
     * 通过别名查询设备列表
     *
     * @param queryDevicesByAliasModel
     * @return
     */
    public static Map<String, Object> queryDevicesByAlias(QueryDevicesByAliasModel queryDevicesByAliasModel) {
        queryDevicesByAliasModel.validateAndThrow();

        String alias = queryDevicesByAliasModel.getAlias();

        Map<String, String> requestParameters = buildCommonRequestParameters();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "QueryDevicesByAlias");
        requestParameters.put("Alias", alias);
        requestParameters.put("Signature", generateSignature(AliyunUtils.ACCESS_KEY_SECRET, requestParameters));
        return callAliyunPushApi(requestParameters);
    }

    /**
     * 解绑别名
     *
     * @param unbindAliasModel
     * @return
     */
    public static Map<String, Object> unbindAlias(UnbindAliasModel unbindAliasModel) {
        unbindAliasModel.validateAndThrow();

        String deviceId = unbindAliasModel.getDeviceId();
        boolean unbindAll = unbindAliasModel.isUnbindAll();
        String aliasName = unbindAliasModel.getAliasName();

        Map<String, String> requestParameters = buildCommonRequestParameters();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "UnbindAlias");
        requestParameters.put("DeviceId", deviceId);
        requestParameters.put("UnbindAll", String.valueOf(unbindAll));
        if (!unbindAll) {
            requestParameters.put("AliasName", aliasName);
        }
        requestParameters.put("Signature", generateSignature(AliyunUtils.ACCESS_KEY_SECRET, requestParameters));
        return callAliyunPushApi(requestParameters);
    }
}
