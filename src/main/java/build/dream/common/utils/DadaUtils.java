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
        NotifyUtils.saveDadaOrderAsyncNotify(addOrderModel.getOriginId(), addOrderModel.getTopic());
        return callDadaApi(addOrderModel, "/api/order/addOrder");
    }

    /**
     * 重新发布订单
     *
     * @param reAddOrderModel
     * @return
     */
    public static Map<String, Object> reAddOrder(ReAddOrderModel reAddOrderModel) {
        NotifyUtils.saveDadaOrderAsyncNotify(reAddOrderModel.getOriginId(), reAddOrderModel.getTopic());
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

    /**
     * 取消订单
     *
     * @param orderCancelModel
     * @return
     */
    public static Map<String, Object> orderCancel(OrderCancelModel orderCancelModel) {
        return callDadaApi(orderCancelModel, "/api/order/formalCancel");
    }

    /**
     * 获取取消原因
     *
     * @param cancelReasonsModel
     * @return
     */
    public static Map<String, Object> cancelReasons(CancelReasonsModel cancelReasonsModel) {
        return callDadaApi(cancelReasonsModel, "/api/order/cancel/reasons");
    }

    /**
     * 追加订单
     * 商户调用该接口将已发布的订单追加给指定的配送员
     *
     * @param orderAppointModel
     * @return
     */
    public static Map<String, Object> orderAppoint(OrderAppointModel orderAppointModel) {
        return callDadaApi(orderAppointModel, "/api/order/appoint/exist");
    }

    /**
     * 取消追加订单
     * 商户调用该接口取消已发布的追加订单
     * 被取消的追加订单，状态变为待接单，其他配送员可见
     *
     * @param orderAppointCancelModel
     * @return
     */
    public static Map<String, Object> orderAppointCancel(OrderAppointCancelModel orderAppointCancelModel) {
        return callDadaApi(orderAppointCancelModel, "/api/order/appoint/cancel");
    }

    /**
     * 查询追加配送员
     * 商户调用该接口查询可追加订单的配送员列表
     * 可追加的配送员需符合以下条件:
     * 1. 配送员在1小时内接过此商户的订单,且订单未完成
     * 2. 配送员在当前商户接单数小于系统限定的指定商户接单总数
     * 3. 配送员在达达平台的接单数量未达上限
     *
     * @param listTransportersModel
     * @return
     */
    public static Map<String, Object> listTransporters(ListTransportersModel listTransportersModel) {
        return callDadaApi(listTransportersModel, "/api/order/appoint/list/transporter");
    }

    /**
     * 商家投诉达达
     * 达达配送员接单后，商家如果对达达服务不满意，均可以使用该接口对达达进行投诉。
     *
     * @param complaintDadaModel
     * @return
     */
    public static Map<String, Object> complaintDada(ComplaintDadaModel complaintDadaModel) {
        return callDadaApi(complaintDadaModel, "/api/complaint/dada");
    }

    /**
     * 获取商家投诉达达原因
     * 商家投诉达达，需要传递投诉原因ID，通过此接口获取投诉原因列表
     *
     * @param complaintReasonsModel
     * @return
     */
    public static Map<String, Object> complaintReasons(ComplaintReasonsModel complaintReasonsModel) {
        return callDadaApi(complaintReasonsModel, "/api/complaint/reasons");
    }

    /**
     * 妥投异常之物品返回完成
     * 订单妥投异常后，订单状态变为9，骑士将物品进行返还，如果商家确认收到物品后，可以使用该 接口进行确认，订单状态变成10，同时订单终结。
     *
     * @param confirmGoodsModel
     * @return
     */
    public static Map<String, Object> confirmGoods(ConfirmGoodsModel confirmGoodsModel) {
        return callDadaApi(confirmGoodsModel, "/api/order/confirm/goods");
    }
}
