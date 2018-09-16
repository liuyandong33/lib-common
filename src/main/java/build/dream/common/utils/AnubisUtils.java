package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.anubis.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class AnubisUtils {
    private static final String ANUBIS_SERVICE_URL = "https://open-anubis.ele.me/anubis-webapi/v2";
    public static final Map<String, String> HEADERS = new HashMap<String, String>();

    static {
        HEADERS.put("Content-Type", "application/json;charset=utf-8");
    }

    public static String generateSignature(String appId, String data, int salt, String accessToken) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("app_id=" + appId);
        stringBuilder.append("access_token=" + accessToken);
        stringBuilder.append("data=" + URLEncoder.encode(data, Constants.CHARSET_NAME_UTF_8));
        stringBuilder.append("salt=" + salt);
        return DigestUtils.md5Hex(stringBuilder.toString());
    }

    public static boolean verifySignature(String appId, String data, int salt, String accessToken, String signature) throws IOException {
        return signature.equals(generateSignature(appId, data, salt, accessToken));
    }

    public static String obtainAccessToken(String appId, String appSecret) throws IOException {
        String tokenJson = CacheUtils.hget(Constants.KEY_ANUBIS_TOKENS, appId);
        boolean isRetrieveAccessToken = false;
        String accessToken = null;
        if (StringUtils.isNotBlank(tokenJson)) {
            Map<String, Object> tokenMap = JacksonUtils.readValueAsMap(tokenJson, String.class, Object.class);
            long expireTime = MapUtils.getLongValue(tokenMap, "expire_time");
            if (System.currentTimeMillis() >= expireTime) {
                isRetrieveAccessToken = true;
            } else {
                accessToken = MapUtils.getString(tokenMap, "access_token");
            }
        } else {
            isRetrieveAccessToken = true;
        }

        if (isRetrieveAccessToken) {
            int salt = RandomUtils.nextInt(1000, 9999);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("app_id=" + appId);
            stringBuilder.append("&salt=" + salt);
            stringBuilder.append("&secret_key=" + appSecret);
            String signature = DigestUtils.md5Hex(URLEncoder.encode(stringBuilder.toString(), Constants.CHARSET_NAME_UTF_8));
            Map<String, String> requestParameters = new HashMap<String, String>();
            requestParameters.put("appId", appId);
            requestParameters.put("salt", String.valueOf(salt));
            requestParameters.put("signature", signature);

            String url = ANUBIS_SERVICE_URL + "/get_access_token";
            WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, requestParameters);
            String result = webResponse.getResult();
            Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
            int code = MapUtils.getIntValue(resultMap, "code");
            ValidateUtils.isTrue(code == 200, MapUtils.getString(resultMap, "msg"));

            Map<String, Object> tokenMap = MapUtils.getMap(resultMap, "data");
            CacheUtils.hset(Constants.KEY_ANUBIS_TOKENS, appId, GsonUtils.toJson(tokenMap));
            accessToken = MapUtils.getString(tokenMap, "access_token");
        }
        return accessToken;
    }

    public static String obtainAccessToken() throws IOException {
        String appId = ConfigurationUtils.getConfiguration(Constants.ANUBIS_APP_ID);
        String appSecret = ConfigurationUtils.getConfiguration(Constants.ANUBIS_APP_SECRET);
        return obtainAccessToken(appId, appSecret);
    }

    public static Map<String, Object> callAnubisSystem(String url, String appId, String appSecret, Object data) throws IOException {
        int salt = RandomUtils.nextInt(1000, 9999);
        String accessToken = obtainAccessToken(appId, appSecret);
        String signature = generateSignature(appId, GsonUtils.toJson(data, false), salt, accessToken);

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("appId", appId);
        requestBody.put("data", data);
        requestBody.put("salt", salt);
        requestBody.put("signature", signature);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, GsonUtils.toJson(requestBody));
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        int code = MapUtils.getIntValue(resultMap, "code");
        ValidateUtils.isTrue(code == 200, MapUtils.getString(resultMap, "msg"));
        return resultMap;
    }

    public static Map<String, Object> callAnubisSystem(String url, Object data) throws IOException {
        String appId = ConfigurationUtils.getConfiguration(Constants.ANUBIS_APP_ID);
        String appSecret = ConfigurationUtils.getConfiguration(Constants.ANUBIS_APP_SECRET);
        return callAnubisSystem(url, appId, appSecret, data);
    }

    public static Map<String, Object> order(OrderModel orderModel) throws IOException {
        orderModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/order";
        return callAnubisSystem(url, orderModel);
    }

    public static Map<String, Object> cancelOrder(CancelOrderModel cancelOrderModel) throws IOException {
        cancelOrderModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/order/cancel";
        return callAnubisSystem(url, cancelOrderModel);
    }

    public static Map<String, Object> queryOrder(QueryOrderModel queryOrderModel) throws IOException {
        queryOrderModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/order/query";
        return callAnubisSystem(url, queryOrderModel);
    }

    public static Map<String, Object> complaintOrder(ComplaintOrderModel complaintOrderModel) throws IOException {
        complaintOrderModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/order/complaint";
        return callAnubisSystem(url, complaintOrderModel);
    }

    public static Map<String, Object> chainStore(ChainStoreModel chainStoreModel) throws IOException {
        chainStoreModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/chain_store";
        return callAnubisSystem(url, chainStoreModel);
    }

    public static Map<String, Object> queryChainStore(QueryChainStoreModel queryChainStoreModel) throws IOException {
        queryChainStoreModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/chain_store/query";
        return callAnubisSystem(url, queryChainStoreModel);
    }

    public static Map<String, Object> updateChainStore(UpdateChainStoreModel updateChainStoreModel) throws IOException {
        updateChainStoreModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/chain_store/update";
        return callAnubisSystem(url, updateChainStoreModel);
    }

    public static Map<String, Object> queryDelivery(QueryDeliveryModel queryDeliveryModel) throws IOException {
        queryDeliveryModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/chain_store/delivery/query";
        return callAnubisSystem(url, queryDeliveryModel);
    }
}