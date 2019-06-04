package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.beeleme.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class BeElemeUtils {
    private static String BE_ELE_ME_SERVICE_URL = "https://api-be.ele.me/";

    public static String generateSignature(Map<String, String> requestParameters) {
        Map<String, String> sortedMap = new TreeMap<String, String>(requestParameters);

        List<String> requestParameterPairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            requestParameterPairs.add(entry.getKey() + "=" + UrlUtils.encode(entry.getValue(), Constants.CHARSET_NAME_UTF_8));
        }

        return DigestUtils.md5Hex(StringUtils.join(requestParameterPairs, "&")).toUpperCase();
    }

    public static Map<String, Object> callBeElemeSystem(String cmd, String source, String body, String encrypt, String fields) {
        long timestamp = System.currentTimeMillis();
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("cmd", cmd);
        requestParameters.put("timestamp", String.valueOf(timestamp));
        requestParameters.put("version", "3");
        requestParameters.put("ticket", UUID.randomUUID().toString());
        requestParameters.put("source", source);
        requestParameters.put("body", body);
        if (StringUtils.isNotBlank(encrypt)) {
            requestParameters.put("encrypt", encrypt);
        }

        if (StringUtils.isNotBlank(fields)) {
            requestParameters.put("fields", fields);
        }

        requestParameters.put("sign", generateSignature(requestParameters));
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(BE_ELE_ME_SERVICE_URL, requestParameters);
        String result = webResponse.getResult();
        return JacksonUtils.readValueAsMap(result, String.class, Object.class);
    }

    public static Map<String, Object> callBeElemeSystem(String cmd, BeElemeBasicModel beElemeBasicModel) {
        beElemeBasicModel.validateAndThrow();
        return callBeElemeSystem(cmd, beElemeBasicModel.getSource(), JacksonUtils.writeValueAsString(beElemeBasicModel, JsonInclude.Include.NON_NULL), beElemeBasicModel.getEncrypt(), beElemeBasicModel.getFields());
    }

    /**
     * 获取商户公告
     *
     * @param shopAnnouncementGetModel
     * @return
     */
    public static Map<String, Object> shopAnnouncementGet(ShopAnnouncementGetModel shopAnnouncementGetModel) {
        return callBeElemeSystem("shop.announcement.get", shopAnnouncementGetModel);
    }

    /**
     * 设置商户公告
     *
     * @param shopAnnouncementSetModel
     * @return
     */
    public static Map<String, Object> shopAnnouncementSet(ShopAnnouncementSetModel shopAnnouncementSetModel) {
        return callBeElemeSystem("shop.announcement.set", shopAnnouncementSetModel);
    }

    /**
     * 获取商户资质
     *
     * @param shopAptitudeGetModel
     * @return
     */
    public static Map<String, Object> shopAptitudeGet(ShopAptitudeGetModel shopAptitudeGetModel) {
        return callBeElemeSystem("shop.aptitude.get", shopAptitudeGetModel);
    }

    /**
     * 获取全部资质类型
     *
     * @param shopAptitudeGetTypesModel
     * @return
     */
    public static Map<String, Object> shopAptitudeGetTypes(ShopAptitudeGetTypesModel shopAptitudeGetTypesModel) {
        return callBeElemeSystem("shop.aptitude.gettypes", shopAptitudeGetTypesModel);
    }

    /**
     * 上传资质
     *
     * @param shopAptitudeUploadModel
     * @return
     */
    public static Map<String, Object> shopAptitudeUpload(ShopAptitudeUploadModel shopAptitudeUploadModel) {
        return callBeElemeSystem("shop.aptitude.upload", shopAptitudeUploadModel);
    }

    /**
     * 查看商户的营业状态
     *
     * @param shopBusStatusGetModel
     * @return
     */
    public static Map<String, Object> shopBusStatusGet(ShopBusStatusGetModel shopBusStatusGetModel) {
        return callBeElemeSystem("shop.busstatus.get", shopBusStatusGetModel);
    }

    /**
     * 商户歇业
     *
     * @param shopCloseModel
     * @return
     */
    public static Map<String, Object> shopClose(ShopCloseModel shopCloseModel) {
        return callBeElemeSystem("shop.close", shopCloseModel);
    }

    /**
     * 创建商户
     *
     * @param shopCreateModel
     * @return
     */
    public static Map<String, Object> shopCreate(ShopCreateModel shopCreateModel) {
        return callBeElemeSystem("shop.create", shopCreateModel);
    }

    /**
     * 查看商户
     *
     * @param shopGetModel
     * @return
     */
    public static Map<String, Object> shopGet(ShopGetModel shopGetModel) {
        return callBeElemeSystem("shop.get", shopGetModel);
    }

    /**
     * 商户三方门店ID映射
     *
     * @param shopIdBatchUpdateModel
     * @return
     */
    public static Map<String, Object> shopIdBatchUpdate(ShopIdBatchUpdateModel shopIdBatchUpdateModel) {
        return callBeElemeSystem("shop.id.batchupdate", shopIdBatchUpdateModel);
    }

    /**
     * 商户列表
     *
     * @param shopListModel
     * @return
     */
    public static Map<String, Object> shopList(ShopListModel shopListModel) {
        return callBeElemeSystem("shop.list", shopListModel);
    }

    /**
     * 下线商户
     *
     * @param shopOfflineModel
     * @return
     */
    public static Map<String, Object> shopOffline(ShopOfflineModel shopOfflineModel) {
        return callBeElemeSystem("shop.offline", shopOfflineModel);
    }

    /**
     * 商户开业
     *
     * @param shopOpenModel
     * @return
     */
    public static Map<String, Object> shopOpen(ShopOpenModel shopOpenModel) {
        return callBeElemeSystem("shop.open", shopOpenModel);
    }

    /**
     * 查看商户状态
     *
     * @param shopStatusGetModel
     * @return
     */
    public static Map<String, Object> shopStatusGet(ShopStatusGetModel shopStatusGetModel) {
        return callBeElemeSystem("shop.status.get", shopStatusGetModel);
    }

    /**
     * 修改商户
     *
     * @param shopUpdateModel
     * @return
     */
    public static Map<String, Object> shopUpdate(ShopUpdateModel shopUpdateModel) {
        return callBeElemeSystem("shop.update", shopUpdateModel);
    }

    /**
     * 确认订单
     *
     * @param orderConfirmModel
     * @return
     */
    public static Map<String, Object> orderConfirm(OrderConfirmModel orderConfirmModel) {
        return callBeElemeSystem("order.confirm", orderConfirmModel);
    }

    /**
     * 订单送达
     *
     * @param orderCompleteModel
     * @return
     */
    public static Map<String, Object> orderComplete(OrderCompleteModel orderCompleteModel) {
        return callBeElemeSystem("order.complete", orderCompleteModel);
    }

    /**
     * 订单送出
     *
     * @param orderSendOutModel
     * @return
     */
    public static Map<String, Object> orderSendOut(OrderSendOutModel orderSendOutModel) {
        return callBeElemeSystem("order.sendout", orderSendOutModel);
    }

    /**
     * 取消订单
     *
     * @param orderCancelModel
     * @return
     */
    public static Map<String, Object> orderCancel(OrderCancelModel orderCancelModel) {
        return callBeElemeSystem("order.cancel", orderCancelModel);
    }

    /**
     * 查看订单详情
     *
     * @param orderGetModel
     * @return
     */
    public static Map<String, Object> orderGet(OrderGetModel orderGetModel) {
        return callBeElemeSystem("order.get", orderGetModel);
    }

    /**
     * 查看订单列表
     *
     * @param orderListModel
     * @return
     */
    public static Map<String, Object> orderList(OrderListModel orderListModel) {
        return callBeElemeSystem("order.list", orderListModel);
    }

    /**
     * 查看订单状态
     *
     * @param orderStatusGetModel
     * @return
     */
    public static Map<String, Object> orderStatusGet(OrderStatusGetModel orderStatusGetModel) {
        return callBeElemeSystem("order.status.get", orderStatusGetModel);
    }

    /**
     * 同意用户取消单/退单
     *
     * @param orderAgreeRefundModel
     * @return
     */
    public static Map<String, Object> orderAgreeRefund(OrderAgreeRefundModel orderAgreeRefundModel) {
        return callBeElemeSystem("order.agreerefund", orderAgreeRefundModel);
    }

    /**
     * 拒绝用户取消单/退单
     *
     * @param orderDisAgreeRefundModel
     * @return
     */
    public static Map<String, Object> orderDisAgreeRefund(OrderDisAgreeRefundModel orderDisAgreeRefundModel) {
        return callBeElemeSystem("order.disagreerefund", orderDisAgreeRefundModel);
    }

    /**
     * 获取订单隐私信息
     *
     * @param orderPrivateInfoModel
     * @return
     */
    public static Map<String, Object> orderPrivateInfo(OrderPrivateInfoModel orderPrivateInfoModel) {
        return callBeElemeSystem("order.privateinfo", orderPrivateInfoModel);
    }

    /**
     * 商户发起部分退款申请
     *
     * @param orderPartRefundModel
     * @return
     */
    public static Map<String, Object> orderPartRefund(OrderPartRefundModel orderPartRefundModel) {
        return callBeElemeSystem("order.partrefund", orderPartRefundModel);
    }

    /**
     * 查看部分退款订单详情
     *
     * @param orderPartRefundGetModel
     * @return
     */
    public static Map<String, Object> orderPartRefundGet(OrderPartRefundGetModel orderPartRefundGetModel) {
        return callBeElemeSystem("order.partrefund.get", orderPartRefundGetModel);
    }

    /**
     * 获取未处理部分退单
     *
     * @param orderPartRefundUnTreListModel
     * @return
     */
    public static Map<String, Object> orderPartRefundUnTreList(OrderPartRefundUnTreListModel orderPartRefundUnTreListModel) {
        return callBeElemeSystem("order.partrefund.untrelist", orderPartRefundUnTreListModel);
    }
}
