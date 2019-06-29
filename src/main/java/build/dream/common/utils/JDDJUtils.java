package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.jddj.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JDDJUtils {
    public static String obtainToken(String tenantId, String branchId) {
        return null;
    }

    private static String generateSign(Map<String, String> requestParameters, String appSecret) {
        Map<String, String> sortedMap = new TreeMap<String, String>(requestParameters);
        StringBuilder stringBuilder = new StringBuilder(appSecret);
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue());
        }
        stringBuilder.append(appSecret);
        return DigestUtils.md5Hex(stringBuilder.toString()).toUpperCase();
    }

    public static Map<String, Object> callJDDJApi(JDDJBasicModel jddjBasicModel, String path) {
        String tenantId = jddjBasicModel.getTenantId();
        String branchId = jddjBasicModel.getBranchId();
        String appKey = jddjBasicModel.getAppKey();
        String appSecret = jddjBasicModel.getAppSecret();
        String timestamp = jddjBasicModel.getTimestamp();
        String format = jddjBasicModel.getFormat();
        String v = jddjBasicModel.getV();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("token", obtainToken(tenantId, branchId));
        requestParameters.put("app_key", appKey);
        requestParameters.put("timestamp", timestamp);
        requestParameters.put("format", format);
        requestParameters.put("v", v);
        requestParameters.put("jd_param_json", JacksonUtils.writeValueAsString(jddjBasicModel));
        requestParameters.put("sign", generateSign(requestParameters, appSecret));

        String url = ConfigurationUtils.getConfiguration(Constants.JDDJ_API_DOMAIN) + path;
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, requestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);

        int code = MapUtils.getIntValue(resultMap, "code");
        ValidateUtils.isTrue(code == 0, MapUtils.getString(resultMap, "msg"));
        return resultMap;
    }

    /**
     * 订单列表查询接口
     *
     * @param orderQueryModel
     * @return
     */
    public static Map<String, Object> orderQuery(OrderQueryModel orderQueryModel) {
        return callJDDJApi(orderQueryModel, "/djapi/order/es/query");
    }

    /**
     * 订单取消且退款接口
     *
     * @param cancelAndRefundModel
     * @return
     */
    public static Map<String, Object> cancelAndRefund(CancelAndRefundModel cancelAndRefundModel) {
        return callJDDJApi(cancelAndRefundModel, "/djapi/orderStatus/cancelAndRefund");
    }

    /**
     * 商家确认接单接口
     *
     * @param orderAcceptOperateModel
     * @return
     */
    public static Map<String, Object> orderAcceptOperate(OrderAcceptOperateModel orderAcceptOperateModel) {
        return callJDDJApi(orderAcceptOperateModel, "/djapi/ocs/orderAcceptOperate");
    }

    /**
     * 订单已打印接口
     *
     * @param printOrderModel
     * @return
     */
    public static Map<String, Object> printOrder(PrintOrderModel printOrderModel) {
        return callJDDJApi(printOrderModel, "/djapi/bm/open/api/order/printOrder");
    }

    /**
     * 商家审核用户取消申请接口
     *
     * @param orderCancelOperateModel
     * @return
     */
    public static Map<String, Object> orderCancelOperate(OrderCancelOperateModel orderCancelOperateModel) {
        return callJDDJApi(orderCancelOperateModel, "/djapi/bm/open/api/order/printOrder");
    }

    /**
     * 订单调整接口
     *
     * @param adjustOrderModel
     * @return
     */
    public static Map<String, Object> adjustOrder(AdjustOrderModel adjustOrderModel) {
        return callJDDJApi(adjustOrderModel, "/djapi/orderAdjust/adjustOrder");
    }

    /**
     * 拣货完成且众包配送接口
     *
     * @param orderJDZBDeliveryModel
     * @return
     */
    public static Map<String, Object> orderJDZBDelivery(OrderJDZBDeliveryModel orderJDZBDeliveryModel) {
        return callJDDJApi(orderJDZBDeliveryModel, "/djapi/bm/open/api/order/OrderJDZBDelivery");
    }

    /**
     * 拣货完成且达达同城配送接口
     *
     * @param orderDDTCDeliveryModel
     * @return
     */
    public static Map<String, Object> orderDDTCDelivery(OrderDDTCDeliveryModel orderDDTCDeliveryModel) {
        return callJDDJApi(orderDDTCDeliveryModel, "/djapi/bm/open/api/order/OrderDDTCDelivery");
    }

    /**
     * 拣货完成且商家自送接口
     *
     * @param orderSerllerDeliveryModel
     * @return
     */
    public static Map<String, Object> orderSerllerDelivery(OrderSerllerDeliveryModel orderSerllerDeliveryModel) {
        return callJDDJApi(orderSerllerDeliveryModel, "/djapi/bm/open/api/order/OrderSerllerDelivery");
    }

    /**
     * 订单达达配送转商家自送接口
     *
     * @param modifySellerDeliveryModel
     * @return
     */
    public static Map<String, Object> modifySellerDelivery(ModifySellerDeliveryModel modifySellerDeliveryModel) {
        return callJDDJApi(modifySellerDeliveryModel, "/djapi/order/modifySellerDelivery");
    }

    /**
     * 商家审核配送员取货失败接口
     *
     * @param receiveFailedAuditModel
     * @return
     */
    public static Map<String, Object> receiveFailedAudit(ReceiveFailedAuditModel receiveFailedAuditModel) {
        return callJDDJApi(receiveFailedAuditModel, "/djapi/order/receiveFailedAudit");
    }

    /**
     * 订单妥投接口
     *
     * @param deliveryEndOrderModel
     * @return
     */
    public static Map<String, Object> deliveryEndOrder(DeliveryEndOrderModel deliveryEndOrderModel) {
        return callJDDJApi(deliveryEndOrderModel, "/djapi/ocs/deliveryEndOrder");
    }

    /**
     * 根据订单号查询订单跟踪接口
     *
     * @param getByOrderNoForOaosModel
     * @return
     */
    public static Map<String, Object> getByOrderNoForOaos(GetByOrderNoForOaosModel getByOrderNoForOaosModel) {
        return callJDDJApi(getByOrderNoForOaosModel, "/djapi/orderTrace/getByOrderNoForOaos");
    }

    /**
     * 新版根据订单号查询订单跟踪接口
     *
     * @param getByOrderNoForOaosNewModel
     * @return
     */
    public static Map<String, Object> getByOrderNoForOaosNew(GetByOrderNoForOaosNewModel getByOrderNoForOaosNewModel) {
        return callJDDJApi(getByOrderNoForOaosNewModel, "/djapi/orderTrace/getByOrderNoForOaosNew");
    }

    /**
     * 商家确认收到拒收退回（或取消）的商品接口
     *
     * @param confirmReceiveGoodsModel
     * @return
     */
    public static Map<String, Object> confirmReceiveGoods(ConfirmReceiveGoodsModel confirmReceiveGoodsModel) {
        return callJDDJApi(confirmReceiveGoodsModel, "/djapi/order/confirmReceiveGoods");
    }

    /**
     * 取货失败后催配送员抢单接口
     *
     * @param urgeDispatchingModel
     * @return
     */
    public static Map<String, Object> urgeDispatching(UrgeDispatchingModel urgeDispatchingModel) {
        return callJDDJApi(urgeDispatchingModel, "/djapi/bm/urgeDispatching");
    }

    /**
     * 订单商家加小费接口
     *
     * @param addTipsModel
     * @return
     */
    public static Map<String, Object> addTips(AddTipsModel addTipsModel) {
        return callJDDJApi(addTipsModel, "/djapi/order/addTips");
    }

    /**
     * 应结金额接口
     *
     * @param orderShoudSettlementServiceModel
     * @return
     */
    public static Map<String, Object> orderShoudSettlementService(OrderShoudSettlementServiceModel orderShoudSettlementServiceModel) {
        return callJDDJApi(orderShoudSettlementServiceModel, "/djapi/bill/orderShoudSettlementService");
    }

    /**
     * 订单自提码核验接口
     *
     * @param checkSelfPickCodeModel
     * @return
     */
    public static Map<String, Object> checkSelfPickCode(CheckSelfPickCodeModel checkSelfPickCodeModel) {
        return callJDDJApi(checkSelfPickCodeModel, "/djapi/ocs/checkSelfPickCode");
    }
}
