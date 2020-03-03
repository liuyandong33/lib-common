package build.dream.common.utils;

import build.dream.common.beans.NewLandOrgInfo;
import build.dream.common.constants.Constants;
import build.dream.common.constants.RedisKeys;
import build.dream.common.domains.saas.NewLandAccount;
import build.dream.common.models.newland.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class NewLandUtils {
    public static NewLandAccount obtainNewLandAccount(String tenantId, String branchId) {
        String newLandAccountJson = CommonRedisUtils.hget(RedisKeys.KEY_NEW_LAND_ACCOUNTS, tenantId + "_" + branchId);
        if (StringUtils.isBlank(newLandAccountJson)) {
            return null;
        }
        return JacksonUtils.readValue(newLandAccountJson, NewLandAccount.class);
    }

    public static NewLandAccount obtainNewLandAccount(Long tenantId, Long branchId) {
        return obtainNewLandAccount(tenantId.toString(), branchId.toString());
    }

    public static NewLandOrgInfo obtainNewLandOrgInfo(String orgNo) {
        String newLandOrgInfoJson = CommonRedisUtils.hget(RedisKeys.KEY_NEW_LAND_ORG_INFOS, orgNo);
        if (StringUtils.isBlank(newLandOrgInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(newLandOrgInfoJson, NewLandOrgInfo.class);
    }

    private static String buildContentType(String charsetName) {
        return "application/json;charset=" + charsetName;
    }

    private static String generateSign(Map<String, String> requestParameters, String secretKey, String signType) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.putAll(requestParameters);

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append(secretKey);
        if (Constants.MD5.equals(signType)) {
            return DigestUtils.md5Hex(stringBuilder.toString());
        }
        return null;
    }

    private static Map<String, String> buildCommonRequestParameters(NewLandBasicModel newLandBasicModel) {
        String opSys = newLandBasicModel.getOpSys();
        String characterSet = newLandBasicModel.getCharacterSet();
        String latitude = newLandBasicModel.getLatitude();
        String longitude = newLandBasicModel.getLongitude();
        String orgNo = newLandBasicModel.getOrgNo();
        String mercId = newLandBasicModel.getMercId();
        String trmNo = newLandBasicModel.getTrmNo();
        String oprId = newLandBasicModel.getOprId();
        String trmTyp = newLandBasicModel.getTrmTyp();
        String tradeNo = newLandBasicModel.getTradeNo();
        String txnTime = newLandBasicModel.getTxnTime();
        String signType = newLandBasicModel.getSignType();
        String addField = newLandBasicModel.getAddField();
        String version = newLandBasicModel.getVersion();

        Map<String, String> commonRequestParameters = new HashMap<String, String>();
        commonRequestParameters.put("opSys", opSys);
        commonRequestParameters.put("characterSet", characterSet);

        if (StringUtils.isNotBlank(latitude)) {
            commonRequestParameters.put("latitude", latitude);
        }

        if (StringUtils.isNotBlank(longitude)) {
            commonRequestParameters.put("longitude", longitude);
        }

        commonRequestParameters.put("orgNo", orgNo);
        commonRequestParameters.put("mercId", mercId);
        commonRequestParameters.put("trmNo", trmNo);

        if (StringUtils.isNotBlank(oprId)) {
            commonRequestParameters.put("oprId", oprId);
        }

        if (StringUtils.isNotBlank(trmTyp)) {
            commonRequestParameters.put("trmTyp", trmTyp);
        }

        commonRequestParameters.put("tradeNo", tradeNo);
        commonRequestParameters.put("txnTime", txnTime);

        commonRequestParameters.put("signType", signType);

        if (StringUtils.isNotBlank(addField)) {
            commonRequestParameters.put("addField", addField);
        }

        commonRequestParameters.put("version", version);
        return commonRequestParameters;
    }

    private static String obtainCharsetName(String characterSet) {
        String charsetName = null;
        if ("00".equals(characterSet)) {
            charsetName = Constants.CHARSET_NAME_GBK;
        } else if ("01".equals(characterSet)) {
            charsetName = Constants.CHARSET_NAME_UTF_8;
        }
        return charsetName;
    }

    public static Map<String, String> callNewLandSystem(Map<String, String> requestParameters, String charsetName, String apiName) {
        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + apiName + ".json";

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestParameters), charsetName, "");
        result = UrlUtils.decode(result, Constants.CHARSET_NAME_UTF_8);

        Map<String, String> resultMap = JacksonUtils.readValueAsMap(result, String.class, String.class);

        String message = resultMap.get("message");
        ValidateUtils.isTrue("000000".equals(resultMap.get("returnCode")), message);

        return resultMap;
    }

    /**
     * 扫码支付-商户主扫
     *
     * @param barcodePayModel
     * @return
     */
    public static Map<String, String> barcodePay(BarcodePayModel barcodePayModel) {
        barcodePayModel.validateAndThrow();

        String signType = barcodePayModel.getSignType();
        String secretKey = barcodePayModel.getSecretKey();
        Integer amount = barcodePayModel.getAmount();
        Integer totalAmount = barcodePayModel.getTotalAmount();
        String authCode = barcodePayModel.getAuthCode();
        String payChannel = barcodePayModel.getPayChannel();
        String subject = barcodePayModel.getSubject();
        String selOrderNo = barcodePayModel.getSelOrderNo();
        String goodsTag = barcodePayModel.getGoodsTag();
        String attach = barcodePayModel.getAttach();

        Map<String, String> barcodePayRequestParameters = buildCommonRequestParameters(barcodePayModel);
        barcodePayRequestParameters.put("amount", amount.toString());
        barcodePayRequestParameters.put("total_amount", totalAmount.toString());
        barcodePayRequestParameters.put("authCode", authCode);
        barcodePayRequestParameters.put("payChannel", payChannel);

        if (StringUtils.isNotBlank(subject)) {
            barcodePayRequestParameters.put("subject", subject);
        }

        if (StringUtils.isNotBlank(selOrderNo)) {
            barcodePayRequestParameters.put("selOrderNo", selOrderNo);
        }

        if (StringUtils.isNotBlank(goodsTag)) {
            barcodePayRequestParameters.put("goodsTag", goodsTag);
        }

        if (StringUtils.isNotBlank(attach)) {
            barcodePayRequestParameters.put("attach", attach);
        }

        barcodePayRequestParameters.put("signValue", generateSign(barcodePayRequestParameters, secretKey, signType));
        return callNewLandSystem(barcodePayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_SDK_BARCODE_PAY, obtainCharsetName(barcodePayModel.getCharacterSet()));
    }

    /**
     * 扫码支付-客户主扫
     *
     * @param barcodePosPayModel
     * @return
     */
    public static Map<String, String> barcodePosPay(BarcodePosPayModel barcodePosPayModel) {
        barcodePosPayModel.validateAndThrow();

        String signType = barcodePosPayModel.getSignType();
        String secretKey = barcodePosPayModel.getSecretKey();
        Integer amount = barcodePosPayModel.getAmount();
        Integer totalAmount = barcodePosPayModel.getTotalAmount();
        String payChannel = barcodePosPayModel.getPayChannel();
        String subject = barcodePosPayModel.getSubject();
        String selOrderNo = barcodePosPayModel.getSelOrderNo();
        String goodsTag = barcodePosPayModel.getGoodsTag();
        String attach = barcodePosPayModel.getAttach();

        Map<String, String> barcodePosPayRequestParameters = buildCommonRequestParameters(barcodePosPayModel);
        barcodePosPayRequestParameters.put("amount", amount.toString());
        barcodePosPayRequestParameters.put("total_amount", totalAmount.toString());
        barcodePosPayRequestParameters.put("payChannel", payChannel);

        if (StringUtils.isNotBlank(subject)) {
            barcodePosPayRequestParameters.put("subject", subject);
        }

        if (StringUtils.isNotBlank(selOrderNo)) {
            barcodePosPayRequestParameters.put("selOrderNo", selOrderNo);
        }

        if (StringUtils.isNotBlank(goodsTag)) {
            barcodePosPayRequestParameters.put("goodsTag", goodsTag);
        }

        if (StringUtils.isNotBlank(attach)) {
            barcodePosPayRequestParameters.put("attach", attach);
        }
        barcodePosPayRequestParameters.put("signValue", generateSign(barcodePosPayRequestParameters, secretKey, signType));
        return callNewLandSystem(barcodePosPayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_SDK_BARCODE_POS_PAY, obtainCharsetName(barcodePosPayModel.getCharacterSet()));
    }

    /**
     * 退款
     *
     * @param refundBarcodePayModel
     * @return
     */
    public static Map<String, String> refundBarcodePay(RefundBarcodePayModel refundBarcodePayModel) {
        refundBarcodePayModel.validateAndThrow();

        String signType = refundBarcodePayModel.getSignType();
        String secretKey = refundBarcodePayModel.getSecretKey();
        String orderNo = refundBarcodePayModel.getOrderNo();
        Integer txnAmt = refundBarcodePayModel.getTxnAmt();

        Map<String, String> refundBarcodePayRequestParameters = buildCommonRequestParameters(refundBarcodePayModel);
        refundBarcodePayRequestParameters.put("orderNo", orderNo);
        if (Objects.nonNull(txnAmt)) {
            refundBarcodePayRequestParameters.put("txnAmt", txnAmt.toString());
        }
        refundBarcodePayRequestParameters.put("signValue", generateSign(refundBarcodePayRequestParameters, secretKey, signType));
        return callNewLandSystem(refundBarcodePayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_SDK_REFUND_BARCODE_PAY, obtainCharsetName(refundBarcodePayModel.getCharacterSet()));
    }

    /**
     * 订单查询
     *
     * @param qryBarcodePayModel
     * @return
     */
    public static Map<String, String> qryBarcodePay(QryBarcodePayModel qryBarcodePayModel) {
        qryBarcodePayModel.validateAndThrow();

        String signType = qryBarcodePayModel.getSignType();
        String secretKey = qryBarcodePayModel.getSecretKey();
        String qryNo = qryBarcodePayModel.getQryNo();

        Map<String, String> qryBarcodePayRequestParameters = buildCommonRequestParameters(qryBarcodePayModel);
        qryBarcodePayRequestParameters.put("qryNo", qryNo);
        qryBarcodePayRequestParameters.put("signValue", generateSign(qryBarcodePayRequestParameters, secretKey, signType));
        return callNewLandSystem(qryBarcodePayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_SDK_QRY_BARCODE_PAY, obtainCharsetName(qryBarcodePayModel.getCharacterSet()));
    }

    /**
     * 微信公众号查询
     *
     * @param pubSigQryModel
     * @return
     */
    public static Map<String, String> pubSigQry(PubSigQryModel pubSigQryModel) {
        pubSigQryModel.validateAndThrow();

        String orgNo = pubSigQryModel.getOrgNo();
        String mercId = pubSigQryModel.getMercId();
        String trmNo = pubSigQryModel.getTrmNo();
        String txnTime = pubSigQryModel.getTxnTime();
        String signType = pubSigQryModel.getSignType();
        String attach = pubSigQryModel.getAttach();
        String version = pubSigQryModel.getVersion();
        String secretKey = pubSigQryModel.getSecretKey();

        Map<String, String> pubSigQryRequestParameters = new HashMap<String, String>();
        pubSigQryRequestParameters.put("orgNo", orgNo);
        pubSigQryRequestParameters.put("mercId", mercId);
        pubSigQryRequestParameters.put("trmNo", trmNo);
        pubSigQryRequestParameters.put("txnTime", txnTime);
        pubSigQryRequestParameters.put("signType", signType);

        if (StringUtils.isNotBlank(attach)) {
            pubSigQryRequestParameters.put("attach", attach);
        }
        pubSigQryRequestParameters.put("version", version);

        pubSigQryRequestParameters.put("signValue", generateSign(pubSigQryRequestParameters, secretKey, signType));
        return callNewLandSystem(pubSigQryRequestParameters, Constants.NEW_LAND_PAY_API_NAME_PUB_SIG_QRY, Constants.CHARSET_NAME_UTF_8);
    }

    /**
     * 微信公众号支付
     *
     * @param pubSigPayModel
     * @return
     */
    public static Map<String, String> pubSigPay(PubSigPayModel pubSigPayModel) {
        pubSigPayModel.validateAndThrow();

        String orgNo = pubSigPayModel.getOrgNo();
        String mercId = pubSigPayModel.getMercId();
        String trmNo = pubSigPayModel.getTrmNo();
        String txnTime = pubSigPayModel.getTxnTime();
        String version = pubSigPayModel.getVersion();
        String code = pubSigPayModel.getCode();
        String openid = pubSigPayModel.getOpenid();
        Integer amount = pubSigPayModel.getAmount();
        Integer totalAmount = pubSigPayModel.getTotalAmount();
        String subject = pubSigPayModel.getSubject();
        String selOrderNo = pubSigPayModel.getSelOrderNo();
        String goodsTag = pubSigPayModel.getGoodsTag();
        String attach = pubSigPayModel.getAttach();
        String secretKey = pubSigPayModel.getSecretKey();

        Map<String, String> pubSigPayRequestParameters = new HashMap<String, String>();
        pubSigPayRequestParameters.put("orgNo", orgNo);
        pubSigPayRequestParameters.put("mercId", mercId);
        pubSigPayRequestParameters.put("trmNo", trmNo);
        pubSigPayRequestParameters.put("txnTime", txnTime);
        pubSigPayRequestParameters.put("version", version);

        if (StringUtils.isNotBlank(code)) {
            pubSigPayRequestParameters.put("code", code);
        }

        if (StringUtils.isNotBlank(openid)) {
            pubSigPayRequestParameters.put("openid", openid);
        }

        pubSigPayRequestParameters.put("amount", amount.toString());
        pubSigPayRequestParameters.put("total_amount", totalAmount.toString());

        if (StringUtils.isNotBlank(subject)) {
            pubSigPayRequestParameters.put("subject", subject);
        }

        if (StringUtils.isNotBlank(selOrderNo)) {
            pubSigPayRequestParameters.put("selOrderNo", selOrderNo);
        }

        if (StringUtils.isNotBlank(goodsTag)) {
            pubSigPayRequestParameters.put("goodsTag", goodsTag);
        }

        if (StringUtils.isNotBlank(attach)) {
            pubSigPayRequestParameters.put("attach", attach);
        }
        pubSigPayRequestParameters.put("signValue", generateSign(pubSigPayRequestParameters, secretKey, Constants.MD5));
        return callNewLandSystem(pubSigPayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_PUB_SIG_PAY, Constants.CHARSET_NAME_UTF_8);
    }
}
