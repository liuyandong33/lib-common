package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.weixinpay.*;
import build.dream.common.saas.domains.WeiXinPayAccount;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WeiXinPayUtils {
    private static final String WEI_XIN_PAY_API_URL = "https://api.mch.weixin.qq.com";

    /**
     * 获取微信支付账号
     *
     * @param tenantId
     * @param branchId
     * @return
     */
    private static WeiXinPayAccount obtainWeiXinPayAccount(String tenantId, String branchId) {
        String weiXinPayAccountJson = CacheUtils.hget(Constants.KEY_WEI_XIN_PAY_ACCOUNTS, tenantId + "_" + branchId);
        WeiXinPayAccount weiXinPayAccount = null;
        if (StringUtils.isNotBlank(weiXinPayAccountJson)) {
            weiXinPayAccount = GsonUtils.fromJson(weiXinPayAccountJson, WeiXinPayAccount.class);
        }
        return weiXinPayAccount;
    }

    /**
     * 生成签名
     *
     * @param callWeiXinSystemRequestParameters
     * @param weiXinPayKey
     * @param signType
     * @return
     */
    public static String generateSign(Map<String, String> callWeiXinSystemRequestParameters, String weiXinPayKey, String signType) {
        Map<String, String> sortedCallWeiXinSystemRequestParameters = null;
        if (callWeiXinSystemRequestParameters instanceof TreeMap) {
            sortedCallWeiXinSystemRequestParameters = callWeiXinSystemRequestParameters;
        } else {
            sortedCallWeiXinSystemRequestParameters = new TreeMap<String, String>(callWeiXinSystemRequestParameters);
        }
        Set<Map.Entry<String, String>> entries = sortedCallWeiXinSystemRequestParameters.entrySet();
        StringBuilder stringSignTemp = new StringBuilder();
        for (Map.Entry<String, String> entry : entries) {
            if (StringUtils.isNotBlank(entry.getValue())) {
                stringSignTemp.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        stringSignTemp.append("key=");
        stringSignTemp.append(weiXinPayKey);
        String sign = null;
        if (Constants.MD5.equals(signType)) {
            sign = DigestUtils.md5Hex(stringSignTemp.toString()).toUpperCase();
        } else if (Constants.HMAC_SHA256.equals(signType)) {
            sign = HmacUtils.hmacSha256Hex(weiXinPayKey, stringSignTemp.toString()).toUpperCase();
        }
        return sign;
    }

    /**
     * 验证签名
     *
     * @param weiXinSystemResult
     * @param weiXinPayKey
     * @param signType
     * @return
     */
    public static boolean checkSign(Map<String, String> weiXinSystemResult, String weiXinPayKey, String signType) {
        Map<String, String> sortedWeiXinSystemResult = new TreeMap<String, String>();
        sortedWeiXinSystemResult.putAll(weiXinSystemResult);
        String sign = sortedWeiXinSystemResult.remove("sign");
        return sign.equals(generateSign(sortedWeiXinSystemResult, weiXinPayKey, signType));
    }

    /**
     * 生成代签名字符串
     *
     * @param callWeiXinSystemRequestParameters
     * @return
     */
    public static String generateFinalData(Map<String, String> callWeiXinSystemRequestParameters) {
        StringBuffer weiXinPayFinalData = new StringBuffer();
        weiXinPayFinalData.append("<xml>");
        Set<Map.Entry<String, String>> entries = callWeiXinSystemRequestParameters.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            weiXinPayFinalData.append("<").append(key).append(">").append(String.format(Constants.CDATA_FORMAT, entry.getValue())).append("</").append(key).append(">");
        }

        weiXinPayFinalData.append("</xml>");
        return weiXinPayFinalData.toString();
    }

    /**
     * 调用维系系统
     *
     * @param url
     * @param finalData
     * @param certificate
     * @param password
     * @return
     * @throws DocumentException
     */
    public static Map<String, String> callWeiXinPaySystem(String url, String finalData, String certificate, String password) throws DocumentException {
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, null, finalData, certificate, password);
        return XmlUtils.xmlStringToMap(webResponse.getResult());
    }

    /**
     * 调用微信系统
     *
     * @param url
     * @param finalData
     * @return
     * @throws DocumentException
     */
    public static Map<String, String> callWeiXinPaySystem(String url, String finalData) throws DocumentException {
        return callWeiXinPaySystem(url, finalData, null, null);
    }

    /**
     * 保存异步通知记录
     *
     * @param uuid
     * @param notifyUrl
     * @param weiXinPayApiSecretKey
     * @param weiXinPaySignType
     * @throws IOException
     */
    private static void saveNotifyRecord(String uuid, String notifyUrl, String weiXinPayApiSecretKey, String weiXinPaySignType) throws IOException {
        Map<String, String> saveNotifyRecordRequestParameters = new HashMap<String, String>();
        saveNotifyRecordRequestParameters.put("uuid", uuid);
        saveNotifyRecordRequestParameters.put("notifyUrl", notifyUrl);
        saveNotifyRecordRequestParameters.put("weiXinPayApiSecretKey", weiXinPayApiSecretKey);
        saveNotifyRecordRequestParameters.put("weiXinPaySignType", weiXinPaySignType);

        ApiRest saveNotifyRecordResult = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "notify", "saveNotifyRecord", saveNotifyRecordRequestParameters);
        ValidateUtils.isTrue(saveNotifyRecordResult.isSuccessful(), saveNotifyRecordResult.getError());
    }

    /**
     * 刷卡支付
     *
     * @param tenantId
     * @param branchId
     * @param microPayModel
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String, String> microPay(String tenantId, String branchId, MicroPayModel microPayModel) throws DocumentException {
        microPayModel.validateAndThrow();
        WeiXinPayAccount weiXinPayAccount = obtainWeiXinPayAccount(tenantId, branchId);
        ValidateUtils.notNull(weiXinPayAccount, "未配置微信支付账号！");

        Map<String, String> microPayRequestParameters = new HashMap<String, String>();
        microPayRequestParameters.put("appid", weiXinPayAccount.getAppId());
        microPayRequestParameters.put("mch_id", weiXinPayAccount.getMchId());

        if (weiXinPayAccount.isAcceptanceModel()) {
            String subAppId = weiXinPayAccount.getSubPublicAccountAppId();
            ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "sub_appid", subAppId);
            microPayRequestParameters.put("sub_mch_id", weiXinPayAccount.getSubMchId());

        }

        microPayRequestParameters.put("mch_id", weiXinPayAccount.getMchId());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "device_info", microPayModel.getDeviceInfo());
        microPayRequestParameters.put("nonce_str", RandomStringUtils.randomAlphanumeric(32));

        String signType = microPayModel.getSignType();
        microPayRequestParameters.put("sign_type", signType);

        microPayRequestParameters.put("body", microPayModel.getBody());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "detail", microPayModel.getDetail());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "attach", microPayModel.getAttach());
        microPayRequestParameters.put("out_trade_no", microPayModel.getOutTradeNo());
        microPayRequestParameters.put("total_fee", microPayModel.getTotalFee().toString());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "fee_type", microPayModel.getFeeType());
        microPayRequestParameters.put("spbill_create_ip", microPayModel.getSpbillCreateIp());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "goods_tag", microPayModel.getGoodsTag());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "limit_pay", microPayModel.getLimitPay());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "time_start", microPayModel.getTimeStart());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "time_expire", microPayModel.getTimeExpire());
        microPayRequestParameters.put("auth_code", microPayModel.getAuthCode());
        if (microPayModel.getSceneInfoModel() != null) {
            microPayRequestParameters.put("scene_info", GsonUtils.toJson(microPayModel.getSceneInfoModel(), false));
        }

        String sign = generateSign(microPayRequestParameters, weiXinPayAccount.getApiSecretKey(), Constants.MD5);
        microPayRequestParameters.put("sign", sign);

        String microPayFinalData = generateFinalData(microPayRequestParameters);
        Map<String, String> microPayResult = callWeiXinPaySystem(WEI_XIN_PAY_API_URL + "/pay/micropay", microPayFinalData);

        String returnCode = microPayResult.get("return_code");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(returnCode), microPayResult.get("return_msg"));

        ValidateUtils.isTrue(checkSign(microPayResult, weiXinPayAccount.getApiSecretKey(), Constants.MD5), "微信系统返回结果签名校验未通过！");

        String resultCode = microPayResult.get("result_code");
        String errCode = microPayResult.get("err_code");
        ValidateUtils.isTrue((Constants.SUCCESS.equals(resultCode) || (Constants.FAIL.equals(resultCode) && "USERPAYING".equals(errCode))), microPayResult.get("err_code_des"));

        return microPayResult;
    }

    /**
     * 统一下单
     *
     * @param tenantId
     * @param branchId
     * @param unifiedOrderModel
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String, String> unifiedOrder(String tenantId, String branchId, UnifiedOrderModel unifiedOrderModel) throws IOException, DocumentException {
        unifiedOrderModel.validateAndThrow();
        WeiXinPayAccount weiXinPayAccount = obtainWeiXinPayAccount(tenantId, branchId);
        ValidateUtils.notNull(weiXinPayAccount, "未配置微信支付账号！");

        Map<String, String> unifiedOrderRequestParameters = new HashMap<String, String>();
        unifiedOrderRequestParameters.put("appid", weiXinPayAccount.getAppId());
        unifiedOrderRequestParameters.put("mch_id", weiXinPayAccount.getMchId());

        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "device_info", unifiedOrderModel.getDeviceInfo());
        unifiedOrderRequestParameters.put("nonce_str", RandomStringUtils.randomAlphanumeric(32));

        String signType = unifiedOrderModel.getSignType();
        unifiedOrderRequestParameters.put("sign_type", signType);

        unifiedOrderRequestParameters.put("body", unifiedOrderModel.getBody());
        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "detail", unifiedOrderModel.getDetail());
        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "attach", unifiedOrderModel.getAttach());

        String outTradeNo = unifiedOrderModel.getOutTradeNo();
        unifiedOrderRequestParameters.put("out_trade_no", outTradeNo);

        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "fee_type", unifiedOrderModel.getFeeType());
        unifiedOrderRequestParameters.put("total_fee", unifiedOrderModel.getTotalFee().toString());
        unifiedOrderRequestParameters.put("spbill_create_ip", unifiedOrderModel.getSpbillCreateIp());
        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "time_start", unifiedOrderModel.getTimeStart());
        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "time_expire", unifiedOrderModel.getTimeExpire());
        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "goods_tag", unifiedOrderModel.getGoodsTag());

        String notifyUrl = unifiedOrderModel.getNotifyUrl();
        unifiedOrderRequestParameters.put("notify_url", notifyUrl);

        String tradeType = unifiedOrderModel.getTradeType();
        if (Constants.WEI_XIN_PAY_TRADE_TYPE_MINI_PROGRAM.equals(tradeType)) {
            unifiedOrderRequestParameters.put("trade_type", Constants.WEI_XIN_PAY_TRADE_TYPE_JSAPI);
        } else {
            unifiedOrderRequestParameters.put("trade_type", tradeType);
        }

        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "product_id", unifiedOrderModel.getProductId());
        ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "limit_pay", unifiedOrderModel.getLimitPay());

        if (Constants.WEI_XIN_PAY_TRADE_TYPE_JSAPI.equals(tradeType)) {
            String openId = unifiedOrderModel.getOpenId();
            if (weiXinPayAccount.isAcceptanceModel()) {
                String subOpenId = unifiedOrderModel.getSubOpenId();
                ApplicationHandler.isTrue(StringUtils.isNotBlank(openId) || StringUtils.isNotBlank(subOpenId), "参数openId和subOpenId不能同时为空！");
                if (StringUtils.isNotBlank(subOpenId)) {
                    ValidateUtils.notBlank(weiXinPayAccount.getSubPublicAccountAppId(), "支付账号未配置子商户公众账号APPID！");
                }

                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "sub_appid", weiXinPayAccount.getSubPublicAccountAppId());
                unifiedOrderRequestParameters.put("sub_mch_id", weiXinPayAccount.getSubMchId());
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "openid", openId);
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "sub_openid", subOpenId);
            } else {
                ApplicationHandler.notBlank(openId, "openId");
                unifiedOrderRequestParameters.put("openid", openId);
            }
        } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_NATIVE.equals(tradeType)) {
            ApplicationHandler.notBlank(unifiedOrderModel.getProductId(), "productId");
            if (weiXinPayAccount.isAcceptanceModel()) {
                String subOpenId = unifiedOrderModel.getSubOpenId();
                if (StringUtils.isNotBlank(subOpenId)) {
                    ValidateUtils.notBlank(weiXinPayAccount.getSubPublicAccountAppId(), "支付账号未配置子商户公众账号APPID！");
                }
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "sub_appid", weiXinPayAccount.getSubPublicAccountAppId());
                unifiedOrderRequestParameters.put("sub_mch_id", weiXinPayAccount.getSubMchId());
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "openid", unifiedOrderModel.getOpenId());
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "sub_openid", subOpenId);
            } else {
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "openid", unifiedOrderModel.getOpenId());
            }
        } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_APP.equals(tradeType)) {
            if (weiXinPayAccount.isAcceptanceModel()) {
                ValidateUtils.notBlank(weiXinPayAccount.getSubOpenPlatformAppId(), "支付账号未配置微信开放平台APPID！");
                unifiedOrderRequestParameters.put("sub_appid", weiXinPayAccount.getSubOpenPlatformAppId());
                unifiedOrderRequestParameters.put("sub_mch_id", weiXinPayAccount.getSubMchId());
            }
        } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_MWEB.equals(tradeType)) {
            if (weiXinPayAccount.isAcceptanceModel()) {
                String subOpenId = unifiedOrderModel.getSubOpenId();
                if (StringUtils.isNotBlank(subOpenId)) {
                    ValidateUtils.notBlank(weiXinPayAccount.getSubPublicAccountAppId(), "支付账号未配置子商户公众账号APPID！");
                }
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "sub_appid", weiXinPayAccount.getSubPublicAccountAppId());
                unifiedOrderRequestParameters.put("sub_mch_id", weiXinPayAccount.getSubMchId());
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "openid", unifiedOrderModel.getOpenId());
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "sub_openid", subOpenId);
            } else {
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "openid", unifiedOrderModel.getOpenId());
            }
        } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_MINI_PROGRAM.equals(tradeType)) {
            String openId = unifiedOrderModel.getOpenId();
            if (weiXinPayAccount.isAcceptanceModel()) {
                ValidateUtils.notBlank(weiXinPayAccount.getSubMiniProgramAppId(), "支付账号未配置小程序APPID！");
                unifiedOrderRequestParameters.put("sub_appid", weiXinPayAccount.getSubOpenPlatformAppId());
                unifiedOrderRequestParameters.put("sub_mch_id", weiXinPayAccount.getSubMchId());

                String subOpenId = unifiedOrderModel.getSubOpenId();
                if (StringUtils.isNotBlank(subOpenId)) {
                    ValidateUtils.notBlank(weiXinPayAccount.getSubPublicAccountAppId(), "支付账号未配置子商户公众账号APPID！");
                }
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "openid", openId);
                ApplicationHandler.ifNotBlankPut(unifiedOrderRequestParameters, "sub_openid", subOpenId);
            } else {
                ApplicationHandler.notBlank(openId, "openId");
                unifiedOrderRequestParameters.put("openid", openId);
            }
        }

        UnifiedOrderModel.SceneInfoModel sceneInfoModel = unifiedOrderModel.getSceneInfoModel();
        if (sceneInfoModel != null) {
            unifiedOrderRequestParameters.put("scene_info", GsonUtils.toJson(sceneInfoModel, false));
        }

        String apiSecretKey = weiXinPayAccount.getApiSecretKey();
        String sign = generateSign(unifiedOrderRequestParameters, apiSecretKey, signType);
        unifiedOrderRequestParameters.put("sign", sign);

        String unifiedOrderFinalData = generateFinalData(unifiedOrderRequestParameters);
        Map<String, String> unifiedOrderResult = callWeiXinPaySystem(WEI_XIN_PAY_API_URL + "/pay/unifiedorder", unifiedOrderFinalData);

        String returnCode = unifiedOrderResult.get("return_code");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(returnCode), unifiedOrderResult.get("return_msg"));

        ValidateUtils.isTrue(checkSign(unifiedOrderResult, weiXinPayAccount.getApiSecretKey(), Constants.MD5), "微信系统返回结果签名校验未通过！");
        String resultCode = unifiedOrderResult.get("result_code");

        ValidateUtils.isTrue(Constants.SUCCESS.equals(resultCode), unifiedOrderResult.get("err_code_des"));

        // 保存异步通知记录
        saveNotifyRecord(outTradeNo, notifyUrl, apiSecretKey, signType);

        Map<String, String> data = new HashMap<String, String>();
        if (Constants.WEI_XIN_PAY_TRADE_TYPE_APP.equals(tradeType)) {
            if (weiXinPayAccount.isAcceptanceModel()) {
                data.put("appid", unifiedOrderResult.get("sub_appid"));
                data.put("partnerid", unifiedOrderResult.get("sub_mch_id"));
            } else {
                data.put("appid", unifiedOrderResult.get("appid"));
                data.put("partnerid", unifiedOrderResult.get("mch_id"));
            }
            data.put("prepayid", unifiedOrderResult.get("prepay_id"));
            data.put("package", "Sign=WXPay");
            data.put("noncestr", RandomStringUtils.randomAlphanumeric(32));
            data.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            data.put("sign", generateSign(data, weiXinPayAccount.getApiSecretKey(), Constants.MD5));
        } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_MWEB.equals(tradeType)) {
            data.put("mwebUrl", unifiedOrderResult.get("mweb_url"));
        } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_NATIVE.equals(tradeType)) {
            data.put("codeUrl", unifiedOrderResult.get("code_url"));
        } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_JSAPI.equals(tradeType)) {
            data.put("appId", unifiedOrderResult.get("appid"));
            data.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
            data.put("nonceStr", RandomStringUtils.randomAlphanumeric(32));
            data.put("package", "prepay_id=" + unifiedOrderResult.get("prepay_id"));
            data.put("signType", signType);
            data.put("paySign", generateSign(data, weiXinPayAccount.getApiSecretKey(), signType));
        } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_MINI_PROGRAM.equals(tradeType)) {
            if (weiXinPayAccount.isAcceptanceModel()) {
                data.put("appId", unifiedOrderResult.get("sub_appid"));
            } else {
                data.put("appId", unifiedOrderResult.get("appid"));
            }
            data.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
            data.put("nonceStr", RandomStringUtils.randomAlphanumeric(32));
            data.put("package", "prepay_id=" + unifiedOrderResult.get("prepay_id"));
            data.put("signType", signType);
            data.put("paySign", generateSign(data, weiXinPayAccount.getApiSecretKey(), signType));
        }

        return data;
    }

    /**
     * 退款
     *
     * @param tenantId
     * @param branchId
     * @param refundModel
     * @return
     * @throws DocumentException
     */
    public static Map<String, String> refund(String tenantId, String branchId, RefundModel refundModel) throws DocumentException {
        refundModel.validateAndThrow();

        WeiXinPayAccount weiXinPayAccount = obtainWeiXinPayAccount(tenantId, branchId);
        ValidateUtils.notNull(weiXinPayAccount, "未配置微信支付账号！");

        Map<String, String> refundRequestParameters = new HashMap<String, String>();
        refundRequestParameters.put("appid", weiXinPayAccount.getAppId());
        refundRequestParameters.put("mch_id", weiXinPayAccount.getMchId());

        String tradeType = refundModel.getTradeType();
        if (weiXinPayAccount.isAcceptanceModel()) {
            if (Constants.WEI_XIN_PAY_TRADE_TYPE_JSAPI.equals(tradeType) || Constants.WEI_XIN_PAY_TRADE_TYPE_NATIVE.equals(tradeType) || Constants.WEI_XIN_PAY_TRADE_TYPE_MWEB.equals(tradeType) || Constants.WEI_XIN_PAY_TRADE_TYPE_MICROPAY.equals(tradeType)) {
                ApplicationHandler.ifNotBlankPut(refundRequestParameters, "sub_appid", weiXinPayAccount.getSubPublicAccountAppId());
            } else if (Constants.WEI_XIN_PAY_TRADE_TYPE_APP.equals(tradeType)) {
                refundRequestParameters.put("sub_appid", weiXinPayAccount.getSubOpenPlatformAppId());
            }
            refundRequestParameters.put("sub_mch_id", weiXinPayAccount.getSubMchId());
        }

        refundRequestParameters.put("nonce_str", RandomStringUtils.randomAlphanumeric(32));
        ApplicationHandler.ifNotBlankPut(refundRequestParameters, "transaction_id", refundModel.getTransactionId());
        ApplicationHandler.ifNotBlankPut(refundRequestParameters, "out_trade_no", refundModel.getOutTradeNo());
        refundRequestParameters.put("out_refund_no", refundModel.getOutRefundNo());
        refundRequestParameters.put("total_fee", refundModel.getTotalFee().toString());
        refundRequestParameters.put("refund_fee", refundModel.getRefundFee().toString());
        ApplicationHandler.ifNotBlankPut(refundRequestParameters, "refund_fee_type", refundModel.getRefundFeeType());
        ApplicationHandler.ifNotBlankPut(refundRequestParameters, "refund_desc", refundModel.getRefund_desc());
        ApplicationHandler.ifNotBlankPut(refundRequestParameters, "refund_account", refundModel.getRefundAccount());

        String sign = generateSign(refundRequestParameters, weiXinPayAccount.getApiSecretKey(), Constants.MD5);
        refundRequestParameters.put("sign", sign);

        String refundFinalData = generateFinalData(refundRequestParameters);
        Map<String, String> refundResult = callWeiXinPaySystem(WEI_XIN_PAY_API_URL + "/secapi/pay/refund", refundFinalData, weiXinPayAccount.getOperationCertificate(), weiXinPayAccount.getOperationCertificatePassword());

        String returnCode = refundResult.get("return_code");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(returnCode), refundResult.get("return_msg"));

        ValidateUtils.isTrue(checkSign(refundResult, weiXinPayAccount.getApiSecretKey(), Constants.MD5), "微信系统返回结果签名校验未通过！");

        String resultCode = refundResult.get("result_code");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(resultCode), refundResult.get("err_code_des"));

        return refundResult;
    }

    /**
     * 根据支付场景获取交易类型
     *
     * @param paidScene
     * @return
     */
    public static String obtainTradeType(Integer paidScene) {
        String tradeType = null;
        if (paidScene == Constants.PAID_SCENE_WEI_XIN_MICROPAY) {
            tradeType = Constants.WEI_XIN_PAY_TRADE_TYPE_MICROPAY;
        } else if (paidScene == Constants.PAID_SCENE_WEI_XIN_JSAPI_PUBLIC_ACCOUNT) {
            tradeType = Constants.WEI_XIN_PAY_TRADE_TYPE_JSAPI;
        } else if (paidScene == Constants.PAID_SCENE_WEI_XIN_NATIVE) {
            tradeType = Constants.WEI_XIN_PAY_TRADE_TYPE_NATIVE;
        } else if (paidScene == Constants.PAID_SCENE_WEI_XIN_APP) {
            tradeType = Constants.WEI_XIN_PAY_TRADE_TYPE_APP;
        } else if (paidScene == Constants.PAID_SCENE_WEI_XIN_MWEB) {
            tradeType = Constants.WEI_XIN_PAY_TRADE_TYPE_MWEB;
        } else if (paidScene == Constants.PAID_SCENE_WEI_XIN_JSAPI_MINI_PROGRAM) {
            tradeType = Constants.WEI_XIN_PAY_TRADE_TYPE_JSAPI;
        }
        return tradeType;
    }

    /**
     * 服务商特约商户关注功能配置
     *
     * @param tenantId
     * @param branchId
     * @param addRecommendConfModel
     * @return
     * @throws DocumentException
     */
    public static Map<String, String> addRecommendConf(String tenantId, String branchId, AddRecommendConfModel addRecommendConfModel) throws DocumentException {
        addRecommendConfModel.validateAndThrow();
        WeiXinPayAccount weiXinPayAccount = obtainWeiXinPayAccount(tenantId, branchId);
        ValidateUtils.notNull(weiXinPayAccount, "未配置微信支付账号！");

        Map<String, String> addRecommendConfRequestParameters = new HashMap<String, String>();
        addRecommendConfRequestParameters.put("mch_id", addRecommendConfModel.getMchId());
        addRecommendConfRequestParameters.put("sub_mch_id", addRecommendConfModel.getSubMchId());
        addRecommendConfRequestParameters.put("sub_appid", addRecommendConfModel.getSubAppId());

        String subscribeAppId = addRecommendConfModel.getSubscribeAppId();
        if (StringUtils.isNotBlank(subscribeAppId)) {
            addRecommendConfRequestParameters.put("subscribe_appid", subscribeAppId);
        }

        String receiptAppId = addRecommendConfModel.getReceiptAppId();
        if (StringUtils.isNotBlank(receiptAppId)) {
            addRecommendConfRequestParameters.put("receipt_appid", receiptAppId);
        }

        addRecommendConfRequestParameters.put("nonce_str", RandomStringUtils.randomAlphanumeric(32));

        String signType = addRecommendConfModel.getSignType();
        addRecommendConfRequestParameters.put("sign_type", signType);
        addRecommendConfRequestParameters.put("sign", generateSign(addRecommendConfRequestParameters, weiXinPayAccount.getApiSecretKey(), signType));

        String addRecommendConfFinalData = generateFinalData(addRecommendConfRequestParameters);
        Map<String, String> addRecommendConfResult = callWeiXinPaySystem(WEI_XIN_PAY_API_URL + "/secapi/mkt/addrecommendconf", addRecommendConfFinalData, weiXinPayAccount.getOperationCertificate(), weiXinPayAccount.getOperationCertificatePassword());

        String returnCode = addRecommendConfResult.get("return_code");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(returnCode), addRecommendConfResult.get("return_msg"));

        ValidateUtils.isTrue(checkSign(addRecommendConfResult, weiXinPayAccount.getApiSecretKey(), signType), "微信系统返回结果签名校验未通过！");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(addRecommendConfResult.get("result_code")), addRecommendConfResult.get("err_code_des"));
        return addRecommendConfResult;
    }

    /**
     * 服务商子商户开发配置新增支付目录
     *
     * @param tenantId
     * @param branchId
     * @param addSubDevConfigModel
     * @return
     * @throws DocumentException
     */
    public static Map<String, String> addSubDevConfig(String tenantId, String branchId, AddSubDevConfigModel addSubDevConfigModel) throws DocumentException {
        addSubDevConfigModel.validateAndThrow();
        WeiXinPayAccount weiXinPayAccount = obtainWeiXinPayAccount(tenantId, branchId);
        ValidateUtils.notNull(weiXinPayAccount, "未配置微信支付账号！");

        Map<String, String> addSubDevConfigRequestParameters = new HashMap<String, String>();
        addSubDevConfigRequestParameters.put("appid", weiXinPayAccount.getAppId());
        addSubDevConfigRequestParameters.put("mch_id", weiXinPayAccount.getMchId());

        String jsApiPath = addSubDevConfigModel.getJsApiPath();
        if (StringUtils.isNotBlank(jsApiPath)) {
            addSubDevConfigRequestParameters.put("jsapi_path", jsApiPath);
        }

        String subAppId = addSubDevConfigModel.getSubAppId();
        if (StringUtils.isNotBlank(subAppId)) {
            addSubDevConfigRequestParameters.put("sub_appid", subAppId);
        }

        addSubDevConfigRequestParameters.put("sign", generateSign(addSubDevConfigRequestParameters, weiXinPayAccount.getApiSecretKey(), Constants.MD5));
        String addSubDevConfigFinalData = generateFinalData(addSubDevConfigRequestParameters);
        Map<String, String> addSubDevConfigResult = callWeiXinPaySystem(WEI_XIN_PAY_API_URL + "/secapi/mch/addsubdevconfig", addSubDevConfigFinalData, weiXinPayAccount.getOperationCertificate(), weiXinPayAccount.getOperationCertificatePassword());

        String returnCode = addSubDevConfigResult.get("return_code");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(returnCode), addSubDevConfigResult.get("return_msg"));

        ValidateUtils.isTrue(checkSign(addSubDevConfigResult, weiXinPayAccount.getApiSecretKey(), Constants.MD5), "微信系统返回结果签名校验未通过！");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(addSubDevConfigResult.get("result_code")), addSubDevConfigResult.get("err_code_des"));
        return addSubDevConfigResult;
    }

    /**
     * 服务商子商户开发配置查询
     *
     * @param tenantId
     * @param branchId
     * @param querySubDevConfigModel
     * @return
     * @throws DocumentException
     */
    public Map<String, String> querySubDevConfig(String tenantId, String branchId, QuerySubDevConfigModel querySubDevConfigModel) throws DocumentException {
        querySubDevConfigModel.validateAndThrow();
        WeiXinPayAccount weiXinPayAccount = obtainWeiXinPayAccount(tenantId, branchId);
        ValidateUtils.notNull(weiXinPayAccount, "未配置微信支付账号！");

        Map<String, String> querySubDevConfigRequestParameters = new HashMap<String, String>();
        querySubDevConfigRequestParameters.put("appid", querySubDevConfigModel.getAppId());
        querySubDevConfigRequestParameters.put("mch_id", querySubDevConfigModel.getMchId());
        querySubDevConfigRequestParameters.put("sub_mch_id", querySubDevConfigModel.getSubMchId());

        querySubDevConfigRequestParameters.put("sign", generateSign(querySubDevConfigRequestParameters, weiXinPayAccount.getApiSecretKey(), Constants.MD5));
        String addSubDevConfigFinalData = generateFinalData(querySubDevConfigRequestParameters);
        Map<String, String> querySubDevConfigResult = callWeiXinPaySystem(WEI_XIN_PAY_API_URL + "/secapi/mch/querysubdevconfig", addSubDevConfigFinalData, weiXinPayAccount.getOperationCertificate(), weiXinPayAccount.getOperationCertificatePassword());

        String returnCode = querySubDevConfigResult.get("return_code");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(returnCode), querySubDevConfigResult.get("return_msg"));

        ValidateUtils.isTrue(checkSign(querySubDevConfigResult, weiXinPayAccount.getApiSecretKey(), Constants.MD5), "微信系统返回结果签名校验未通过！");
        ValidateUtils.isTrue(Constants.SUCCESS.equals(querySubDevConfigResult.get("result_code")), querySubDevConfigResult.get("err_code_des"));
        return querySubDevConfigResult;
    }
}
