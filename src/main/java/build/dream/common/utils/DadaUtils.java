package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.data.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DadaUtils {
    /**
     * 生成签名
     *
     * @param callDadaApiRequestParameters
     * @param appSecret
     * @return
     */
    public static String generateSignature(Map<String, String> callDadaApiRequestParameters, String appSecret) {
        Map<String, String> sortedMap = new TreeMap<String, String>(callDadaApiRequestParameters);
        StringBuilder stringBuilder = new StringBuilder(appSecret);
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue());
        }
        stringBuilder.append(appSecret);
        return DigestUtils.md5Hex(stringBuilder.toString()).toUpperCase();
    }

    /**
     * 调用达达api
     *
     * @param appKey
     * @param timestamp
     * @param format
     * @param v
     * @param sourceId
     * @param body
     * @param appSecret
     * @param path
     * @return
     */
    public static Map<String, Object> callDadaApi(String appKey, String timestamp, String format, String v, String sourceId, String body, String appSecret, String path) {
        Map<String, String> callDadaApiRequestParameters = new HashMap<String, String>();
        callDadaApiRequestParameters.put("app_key", appKey);
        callDadaApiRequestParameters.put("timestamp", timestamp);
        callDadaApiRequestParameters.put("format", format);
        callDadaApiRequestParameters.put("v", v);
        callDadaApiRequestParameters.put("source_id", sourceId);
        callDadaApiRequestParameters.put("body", body);
        String signature = generateSignature(callDadaApiRequestParameters, appSecret);
        callDadaApiRequestParameters.put("signature", signature);

        String url = ConfigurationUtils.getConfiguration(Constants.DADA_API_DOMAIN) + path;
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(callDadaApiRequestParameters), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int code = MapUtils.getIntValue(resultMap, "code");
        ValidateUtils.isTrue(code == 0, MapUtils.getString(resultMap, "msg"));
        return resultMap;
    }

    /**
     * 调用达达api
     *
     * @param dadaBasicModel
     * @param path
     * @return
     */
    public static Map<String, Object> callDadaApi(DadaBasicModel dadaBasicModel, String path) {
        dadaBasicModel.validateAndThrow();

        String appKey = dadaBasicModel.getAppKey();
        String timestamp = dadaBasicModel.getTimestamp();
        String format = dadaBasicModel.getFormat();
        String v = dadaBasicModel.getV();
        String sourceId = dadaBasicModel.getSourceId();
        String appSecret = dadaBasicModel.getAppSecret();
        String body = JacksonUtils.writeValueAsString(dadaBasicModel, JsonInclude.Include.NON_NULL);
        if ("{}".equals(body)) {
            body = "";
        }
        return callDadaApi(appKey, timestamp, format, v, sourceId, body, appSecret, path);
    }

    /**
     * 调用达达api
     *
     * @param dadaCommonParamsModel
     * @param body
     * @param path
     * @return
     */
    public static Map<String, Object> callDadaApi(DadaCommonParamsModel dadaCommonParamsModel, String body, String path) {
        dadaCommonParamsModel.validateAndThrow();

        String appKey = dadaCommonParamsModel.getAppKey();
        String timestamp = dadaCommonParamsModel.getTimestamp();
        String format = dadaCommonParamsModel.getFormat();
        String v = dadaCommonParamsModel.getV();
        String sourceId = dadaCommonParamsModel.getSourceId();
        String appSecret = dadaCommonParamsModel.getAppSecret();
        if ("{}".equals(body)) {
            body = "";
        }
        return callDadaApi(appKey, timestamp, format, v, sourceId, body, appSecret, path);
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
     * @param dadaCommonParamsModel
     * @param addShopModels
     * @return
     */
    public static Map<String, Object> addShop(DadaCommonParamsModel dadaCommonParamsModel, List<AddShopModel> addShopModels) {
        for (AddShopModel addShopModel : addShopModels) {
            addShopModel.validateAndThrow();
        }
        return callDadaApi(dadaCommonParamsModel, JacksonUtils.writeValueAsString(addShopModels), "/api/shop/add");
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
        NotifyUtils.saveDadaOrderAsyncNotify(addOrderModel.getOriginId(), addOrderModel.getMqConfig());
        return callDadaApi(addOrderModel, "/api/order/addOrder");
    }

    /**
     * 重新发布订单
     *
     * @param reAddOrderModel
     * @return
     */
    public static Map<String, Object> reAddOrder(ReAddOrderModel reAddOrderModel) {
        NotifyUtils.saveDadaOrderAsyncNotify(reAddOrderModel.getOriginId(), reAddOrderModel.getMqConfig());
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
