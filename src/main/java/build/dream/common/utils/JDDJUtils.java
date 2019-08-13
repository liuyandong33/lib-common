package build.dream.common.utils;

import build.dream.common.beans.JDDJVenderInfo;
import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.domains.saas.JDDJToken;
import build.dream.common.models.jddj.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JDDJUtils {
    public static String obtainToken(String venderId) {
        String token = CommonRedisUtils.hget(Constants.KEY_JDDJ_TOKENS, venderId);
        if (StringUtils.isBlank(token)) {
            return null;
        }

        JDDJToken jddjToken = JacksonUtils.readValue(token, JDDJToken.class);
        return jddjToken.getToken();
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

    public static boolean verifySign(Map<String, String> parameters, String appSecret) {
        Map<String, String> params = new HashMap<String, String>(parameters);
        String sign = params.remove("sign");
        return sign.equals(generateSign(params, appSecret));
    }

    /**
     * 获取京东到家商家信息
     *
     * @param appKey
     * @return
     */
    public static JDDJVenderInfo obtainJDDJVenderInfo(String appKey) {
        String venderInfoJson = CommonRedisUtils.hget(Constants.KEY_JDDJ_VENDER_INFOS, appKey);
        if (StringUtils.isBlank(venderInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(venderInfoJson, JDDJVenderInfo.class);
    }

    public static Map<String, Object> callJDDJApi(JDDJBasicModel jddjBasicModel, String path) {
        String venderId = jddjBasicModel.getVenderId();
        String appKey = jddjBasicModel.getAppKey();
        String appSecret = jddjBasicModel.getAppSecret();
        String timestamp = jddjBasicModel.getTimestamp();
        String format = jddjBasicModel.getFormat();
        String v = jddjBasicModel.getV();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("token", obtainToken(venderId));
        requestParameters.put("app_key", appKey);
        requestParameters.put("timestamp", timestamp);
        requestParameters.put("format", format);
        requestParameters.put("v", v);
        requestParameters.put("jd_param_json", JacksonUtils.writeValueAsString(jddjBasicModel, JsonInclude.Include.NON_NULL));
        requestParameters.put("sign", generateSign(requestParameters, appSecret));

        String url = ConfigurationUtils.getConfiguration(Constants.JDDJ_API_DOMAIN) + path;
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, requestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);

        int code = MapUtils.getIntValue(resultMap, "code");
        ValidateUtils.isTrue(code == 0, MapUtils.getString(resultMap, "msg"));
        return resultMap;
    }

    public static String buildResult(String code, String msg, String data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return JacksonUtils.writeValueAsString(result);
    }

    public static String buildSuccessResult() {
        return buildResult("0", "success", "");
    }

    public static String buildSuccessResult(String msg) {
        return buildResult("0", msg, "");
    }

    public static String buildSuccessResult(String msg, String data) {
        return buildResult("0", msg, data);
    }

    public static String buildFailureResult() {
        return buildResult("-1", "failure", "");
    }

    public static String buildFailureResult(String msg) {
        return buildResult("-1", msg, "");
    }

    public static String buildFailureResult(String msg, String data) {
        return buildResult("-1", msg, data);
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

    /**
     * 新版新增商品信息接口
     *
     * @param addSkuModel
     * @return
     */
    public static Map<String, Object> addSku(AddSkuModel addSkuModel) {
        return callJDDJApi(addSkuModel, "/djapi/pms/addSku");
    }

    /**
     * 根据商品UPC码批量新增商品接口
     *
     * @param batchAddSkuModel
     * @return
     */
    public static Map<String, Object> batchAddSku(BatchAddSkuModel batchAddSkuModel) {
        return callJDDJApi(batchAddSkuModel, "/djapi/pms/batchAddSku");
    }

    /**
     * 新版根据商家商品编码修改商品信息接口
     *
     * @param updateSkuModel
     * @return
     */
    public static Map<String, Object> updateSku(UpdateSkuModel updateSkuModel) {
        return callJDDJApi(updateSkuModel, "/djapi/pms/updateSku");
    }

    /**
     * 新版查询商品创建状态接口
     *
     * @param getSkuStatusModel
     * @return
     */
    public static Map<String, Object> getSkuStatus(GetSkuStatusModel getSkuStatusModel) {
        return callJDDJApi(getSkuStatusModel, "/djapi/pms/getSkuStatus");
    }

    /**
     * 根据到家商品编码批量更新商家商品编码接口
     *
     * @param batchUpdateOutSkuIdModel
     * @return
     */
    public static Map<String, Object> batchUpdateOutSkuId(BatchUpdateOutSkuIdModel batchUpdateOutSkuIdModel) {
        return callJDDJApi(batchUpdateOutSkuIdModel, "/djapi/pms/sku/batchUpdateOutSkuId");
    }

    /**
     * 查询商家已上传商品信息列表接口
     *
     * @param querySkuInfosModel
     * @return
     */
    public static Map<String, Object> querySkuInfos(QuerySkuInfosModel querySkuInfosModel) {
        return callJDDJApi(querySkuInfosModel, "/djapi/pms/querySkuInfos");
    }

    /**************************************门店类接口开始**************************************/
    /**
     * 获取到家门店编码列表接口
     *
     * @param getStationsByVenderIdModel
     * @return
     */
    public static Map<String, Object> getStationsByVenderId(GetStationsByVenderIdModel getStationsByVenderIdModel) {
        return callJDDJApi(getStationsByVenderIdModel, "/djapi/store/getStationsByVenderId");
    }

    /**
     * 新增不带资质的门店信息接口
     *
     * @param createStoreModel
     * @return
     */
    public static Map<String, Object> createStore(CreateStoreModel createStoreModel) {
        return callJDDJApi(createStoreModel, "/djapi/store/createStore");
    }

    /**
     * 修改门店基础信息接口
     *
     * @param updateStoreInfo4OpenModel
     * @return
     */
    public static Map<String, Object> updateStoreInfo4Open(UpdateStoreInfo4OpenModel updateStoreInfo4OpenModel) {
        return callJDDJApi(updateStoreInfo4OpenModel, "/djapi/store/updateStoreInfo4Open");
    }

    /**
     * 根据到家门店编码查询门店基本信息接口
     *
     * @param getStoreInfoByStationNoModel
     * @return
     */
    public static Map<String, Object> getStoreInfoByStationNo(GetStoreInfoByStationNoModel getStoreInfoByStationNoModel) {
        return callJDDJApi(getStoreInfoByStationNoModel, "/djapi/storeapi/getStoreInfoByStationNo");
    }

    /**
     * 根据订单号查询商家门店评价信息接口
     *
     * @param getCommentByOrderIdModel
     * @return
     */
    public static Map<String, Object> getCommentByOrderId(GetCommentByOrderIdModel getCommentByOrderIdModel) {
        return callJDDJApi(getCommentByOrderIdModel, "/djapi/commentOutApi/getCommentByOrderId");
    }

    /**
     * 商家门店评价信息回复接口
     *
     * @param orgReplyCommentModel
     * @return
     */
    public static Map<String, Object> orgReplyComment(OrgReplyCommentModel orgReplyCommentModel) {
        return callJDDJApi(orgReplyCommentModel, "/djapi/commentOutApi/orgReplyComment");
    }

    /**
     * 获取到家所有城市信息列表接口
     *
     * @param allCitiesModel
     * @return
     */
    public static Map<String, Object> allCities(AllCitiesModel allCitiesModel) {
        return callJDDJApi(allCitiesModel, "/djapi/address/allcities");
    }

    /**
     * 获取商家服务城市列表
     *
     * @param queryVenderServiceAreaModel
     * @return
     */
    public static Map<String, Object> queryVenderServiceArea(QueryVenderServiceAreaModel queryVenderServiceAreaModel) {
        return callJDDJApi(queryVenderServiceAreaModel, "/djapi/venderApiService/queryVenderServiceArea");
    }

    /**
     * 根据城市编码查询区域信息列表接口
     *
     * @param getNextLevelByTypeModel
     * @return
     */
    public static Map<String, Object> getNextLevelByType(GetNextLevelByTypeModel getNextLevelByTypeModel) {
        return callJDDJApi(getNextLevelByTypeModel, "/djapi/address/getNextLevelByType");
    }

    /**
     * 根据门店编码修改运费起送价、满免以及商家自送运费接口
     *
     * @param updateStoreFreightConfigModel
     * @return
     */
    public static Map<String, Object> updateStoreFreightConfig(UpdateStoreFreightConfigModel updateStoreFreightConfigModel) {
        return callJDDJApi(updateStoreFreightConfigModel, "/djapi/freight/updateStoreFreightConfig");
    }

    /**
     * 修改门店运费起送价及满免接口
     * TODO model未实现
     *
     * @param updateStoreFreightConfigNewModel
     * @return
     */
    public static Map<String, Object> updateStoreFreightConfigNew(UpdateStoreFreightConfigNewModel updateStoreFreightConfigNewModel) {
        return callJDDJApi(updateStoreFreightConfigNewModel, "/djapi/freight/updateStoreFreightConfigNew");
    }

    /**
     * 获取门店配送范围接口
     *
     * @param getDeliveryRangeByStationNoModel
     * @return
     */
    public static Map<String, Object> getDeliveryRangeByStationNo(GetDeliveryRangeByStationNoModel getDeliveryRangeByStationNoModel) {
        return callJDDJApi(getDeliveryRangeByStationNoModel, "/djapi/store/getDeliveryRangeByStationNo");
    }

    /**
     * 根据到家门店编码修改商家自动接单接口
     *
     * @param updateStoreConfig4OpenModel
     * @return
     */
    public static Map<String, Object> updateStoreConfig4Open(UpdateStoreConfig4OpenModel updateStoreConfig4OpenModel) {
        return callJDDJApi(updateStoreConfig4OpenModel, "/djapi/store/updateStoreConfig4Open");
    }

    /**
     * 查询商家中心账号信息接口
     *
     * @param searchUserModel
     * @return
     */
    public static Map<String, Object> searchUser(SearchUserModel searchUserModel) {
        return callJDDJApi(searchUserModel, "/djapi/privilege/searchUser");
    }

    /**
     * 修改商家中心账号状态接口
     *
     * @param updateUserModel
     * @return
     */
    public static Map<String, Object> updateUser(UpdateUserModel updateUserModel) {
        return callJDDJApi(updateUserModel, "/djapi/privilege/updateUser");
    }
}
