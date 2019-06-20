package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.data.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DadaUtils {
    private static final Map<String, String> HEADERS = new HashMap<String, String>();

    static {
        HEADERS.put("Content-Type", "application/json;charset=UTF-8");
    }

    public static Map<String, Object> callDadaApi(DadaBasicModel dadaBasicModel, String path) {
        dadaBasicModel.validateAndThrow();

        String appKey = dadaBasicModel.getAppKey();
        String timestamp = dadaBasicModel.getTimestamp();
        String format = dadaBasicModel.getFormat();
        String v = dadaBasicModel.getV();
        String sourceId = dadaBasicModel.getSourceId();

        Map<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.put("app_key", appKey);
        sortedMap.put("timestamp", timestamp);
        sortedMap.put("format", format);
        sortedMap.put("v", v);
        sortedMap.put("source_id", sourceId);

        String body = JacksonUtils.writeValueAsString(dadaBasicModel, JsonInclude.Include.NON_NULL);
        if ("{}".equals(body)) {
            body = "";
        }
        sortedMap.put("body", body);

        String appSecret = ConfigurationUtils.getConfiguration(Constants.DADA_APP_SECRET);
        StringBuilder stringBuilder = new StringBuilder(appSecret);
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue());
        }
        stringBuilder.append(appSecret);

        String signature = DigestUtils.md5Hex(stringBuilder.toString()).toUpperCase();
        sortedMap.put("signature", signature);

        String url = ConfigurationUtils.getConfiguration(Constants.DADA_DOMAIN) + path;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, JacksonUtils.writeValueAsString(sortedMap));

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int code = MapUtils.getIntValue(resultMap, "code");
        ValidateUtils.isTrue(code == 0, MapUtils.getString(resultMap, "msg"));
        return resultMap;
    }

    /**
     * 获取城市信息
     *
     * @param listCitiesModel
     * @return
     */
    public static Map<String, Object> listCities(ListCitiesModel listCitiesModel) {
        return callDadaApi(listCitiesModel, "/api/cityCode/list");
    }

    /**
     * 注册商户
     *
     * @param addMerchantModel
     * @return
     */
    public static Map<String, Object> addMerchant(AddMerchantModel addMerchantModel) {
        return callDadaApi(addMerchantModel, "/merchantApi/merchant/add");
    }

    /**
     * 新增门店
     *
     * @param addShopModel
     * @return
     */
    public static Map<String, Object> addShop(AddShopModel addShopModel) {
        return callDadaApi(addShopModel, "/api/shop/add");
    }

    /**
     * 编辑门店
     *
     * @param updateShopModel
     * @return
     */
    public static Map<String, Object> updateShop(UpdateShopModel updateShopModel) {
        return callDadaApi(updateShopModel, "/api/shop/update");
    }

    /**
     * 门店详情
     *
     * @param updateShopModel
     * @return
     */
    public static Map<String, Object> shopDetail(UpdateShopModel updateShopModel) {
        return callDadaApi(updateShopModel, "/api/shop/detail");
    }

    /**
     * 新增订单
     *
     * @param addOrderModel
     * @return
     */
    public static Map<String, Object> addOrder(AddOrderModel addOrderModel) {
        return callDadaApi(addOrderModel, "/api/order/addOrder");
    }

    /**
     * 重新发布订单
     *
     * @param reAddOrderModel
     * @return
     */
    public static Map<String, Object> reAddOrder(ReAddOrderModel reAddOrderModel) {
        return callDadaApi(reAddOrderModel, "/api/order/reAddOrder");
    }

    /**
     * 增加小费
     *
     * @param addTipModel
     * @return
     */
    public static Map<String, Object> addTip(AddTipModel addTipModel) {
        return callDadaApi(addTipModel, "/api/order/addTip");
    }

    /**
     * 订单详情查询
     *
     * @param orderQueryModel
     * @return
     */
    public static Map<String, Object> orderQuery(OrderQueryModel orderQueryModel) {
        return callDadaApi(orderQueryModel, "/api/order/status/query");
    }
}
