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
        String tokenJson = RedisUtils.hget(Constants.KEY_ANUBIS_TOKENS, appId);
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
            RedisUtils.hset(Constants.KEY_ANUBIS_TOKENS, appId, GsonUtils.toJson(tokenMap));
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

    /**
     * 蜂鸟配送
     *
     * @param orderModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> order(OrderModel orderModel) throws IOException {
        orderModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/order";
        return callAnubisSystem(url, orderModel);
    }

    /**
     * 同步取消订单
     *
     * @param orderCancelModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> orderCancel(OrderCancelModel orderCancelModel) throws IOException {
        orderCancelModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/order/cancel";
        return callAnubisSystem(url, orderCancelModel);
    }

    /**
     * 订单查询
     *
     * @param orderQueryModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> orderQuery(OrderQueryModel orderQueryModel) throws IOException {
        orderQueryModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/order/query";
        return callAnubisSystem(url, orderQueryModel);
    }

    /**
     * 订单投诉
     *
     * @param orderComplaintModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> orderComplaint(OrderComplaintModel orderComplaintModel) throws IOException {
        orderComplaintModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/order/complaint";
        return callAnubisSystem(url, orderComplaintModel);
    }

    /**
     * 添加门店信息
     *
     * @param chainStoreModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> chainStore(ChainStoreModel chainStoreModel) throws IOException {
        chainStoreModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/chain_store";
        return callAnubisSystem(url, chainStoreModel);
    }

    /**
     * 查询门店信息
     *
     * @param chainStoreQueryModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> chainStoreQuery(ChainStoreQueryModel chainStoreQueryModel) throws IOException {
        chainStoreQueryModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/chain_store/query";
        return callAnubisSystem(url, chainStoreQueryModel);
    }

    /**
     * 更新门店信息
     *
     * @param chainStoreUpdateModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> chainStoreUpdate(ChainStoreUpdateModel chainStoreUpdateModel) throws IOException {
        chainStoreUpdateModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/chain_store/update";
        return callAnubisSystem(url, chainStoreUpdateModel);
    }

    /**
     * 查询配送服务
     *
     * @param chainStoreDeliveryQueryModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> chainStoreDeliveryQuery(ChainStoreDeliveryQueryModel chainStoreDeliveryQueryModel) throws IOException {
        chainStoreDeliveryQueryModel.validateAndThrow();
        String url = ANUBIS_SERVICE_URL + "/chain_store/delivery/query";
        return callAnubisSystem(url, chainStoreDeliveryQueryModel);
    }
}