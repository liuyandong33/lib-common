package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.anubis.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnubisUtils {
    private static final String ANUBIS_SERVICE_URL = "https://open-anubis.ele.me/anubis-webapi/v2";
    private static final Map<String, String> HEADERS = new HashMap<String, String>();

    static {
        HEADERS.put("Content-Type", "application/json;charset=utf-8");
    }

    public static String generateSignature(String appId, String data, int salt, String accessToken) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("app_id=" + appId);
        stringBuilder.append("access_token=" + accessToken);
        stringBuilder.append("data=" + UrlUtils.encode(data, Constants.CHARSET_NAME_UTF_8));
        stringBuilder.append("salt=" + salt);
        return DigestUtils.md5Hex(stringBuilder.toString());
    }

    public static boolean verifySignature(String appId, String data, int salt, String accessToken, String signature) {
        return signature.equals(generateSignature(appId, data, salt, accessToken));
    }

    public static String getAccessToken(String appId, String appSecret) {
        int salt = RandomUtils.nextInt(1000, 9999);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("app_id=" + appId);
        stringBuilder.append("&salt=" + salt);
        stringBuilder.append("&secret_key=" + appSecret);
        String signature = DigestUtils.md5Hex(UrlUtils.encode(stringBuilder.toString(), Constants.CHARSET_NAME_UTF_8));
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
        CommonRedisUtils.hset(Constants.KEY_ANUBIS_TOKENS, appId, GsonUtils.toJson(tokenMap));
        return MapUtils.getString(tokenMap, "access_token");
    }

    public static String obtainAccessToken(String appId, String appSecret) {
        String tokenJson = CommonRedisUtils.hget(Constants.KEY_ANUBIS_TOKENS, appId);
        if (StringUtils.isBlank(tokenJson)) {
            return getAccessToken(appId, appSecret);
        }

        Map<String, Object> tokenMap = JacksonUtils.readValueAsMap(tokenJson, String.class, Object.class);
        long expireTime = MapUtils.getLongValue(tokenMap, "expire_time");
        if (System.currentTimeMillis() >= expireTime) {
            return getAccessToken(appId, appSecret);
        }

        return MapUtils.getString(tokenMap, "access_token");
    }

    public static Map<String, Object> callAnubisApi(AnubisBasicModel anubisBasicModel, String path) {
        anubisBasicModel.validateAndThrow();

        String appId = anubisBasicModel.getAppId();
        String appSecret = anubisBasicModel.getAppSecret();
        int salt = anubisBasicModel.getSalt();

        String accessToken = obtainAccessToken(appId, appSecret);
        String signature = generateSignature(appId, JacksonUtils.writeValueAsString(anubisBasicModel, JsonInclude.Include.NON_NULL), salt, accessToken);

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("appId", appId);
        requestBody.put("data", anubisBasicModel);
        requestBody.put("salt", salt);
        requestBody.put("signature", signature);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(ANUBIS_SERVICE_URL + path, HEADERS, JacksonUtils.writeValueAsString(requestBody, JsonInclude.Include.NON_NULL));
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        int code = MapUtils.getIntValue(resultMap, "code");
        ValidateUtils.isTrue(code == 200, MapUtils.getString(resultMap, "msg"));
        return resultMap;
    }

    /**
     * 蜂鸟配送
     *
     * @param orderModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> order(OrderModel orderModel) {
        NotifyUtils.saveAnubisOrderAsyncNotify(orderModel.getPartnerOrderCode(), orderModel.getTopic());
        return callAnubisApi(orderModel, "/order");
    }

    /**
     * 同步取消订单
     *
     * @param orderCancelModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> orderCancel(OrderCancelModel orderCancelModel) {
        return callAnubisApi(orderCancelModel, "/order/cancel");
    }

    /**
     * 订单查询
     *
     * @param orderQueryModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> orderQuery(OrderQueryModel orderQueryModel) {
        return callAnubisApi(orderQueryModel, "/order/query");
    }

    /**
     * 订单投诉
     *
     * @param orderComplaintModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> orderComplaint(OrderComplaintModel orderComplaintModel) {
        return callAnubisApi(orderComplaintModel, "/order/complaint");
    }

    /**
     * 添加门店信息
     *
     * @param chainStoreModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> chainStore(ChainStoreModel chainStoreModel) {
        return callAnubisApi(chainStoreModel, "/chain_store");
    }

    /**
     * 查询门店信息
     *
     * @param chainStoreQueryModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> chainStoreQuery(ChainStoreQueryModel chainStoreQueryModel) {
        return callAnubisApi(chainStoreQueryModel, "/chain_store/query");
    }

    /**
     * 更新门店信息
     *
     * @param chainStoreUpdateModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> chainStoreUpdate(ChainStoreUpdateModel chainStoreUpdateModel) {
        return callAnubisApi(chainStoreUpdateModel, "/chain_store/update");
    }

    /**
     * 查询配送服务
     *
     * @param chainStoreDeliveryQueryModel
     * @return
     * @throws IOException
     */
    public static Map<String, Object> chainStoreDeliveryQuery(ChainStoreDeliveryQueryModel chainStoreDeliveryQueryModel) {
        return callAnubisApi(chainStoreDeliveryQueryModel, "/chain_store/delivery/query");
    }
}