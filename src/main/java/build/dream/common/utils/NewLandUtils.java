package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.newland.*;
import build.dream.common.saas.domains.NewLandAccount;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NewLandUtils {
    private static NewLandAccount obtainNewLandAccount(String tenantId, String branchId) {
        String newLandAccountJson = RedisUtils.hget(Constants.KEY_NEW_LAND_ACCOUNTS, tenantId + "_" + branchId);
        NewLandAccount newLandAccount = null;
        if (StringUtils.isNotBlank(newLandAccountJson)) {
            newLandAccount = GsonUtils.fromJson(newLandAccountJson, NewLandAccount.class);
        }
        return newLandAccount;
    }

    private static Map<String, String> buildHeaders(String charsetName) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=" + charsetName);
        return headers;
    }

    private static String generateSign(Map<String, String> requestParameters, String secretKey) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.putAll(requestParameters);

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append(secretKey);
        return DigestUtils.md5Hex(stringBuilder.toString());
    }

    private static Map<String, String> buildCommonRequestParameters(CommonModel commonModel, NewLandAccount newLandAccount) {
        Map<String, String> commonRequestParameters = new HashMap<String, String>();
        commonRequestParameters.put("opSys", commonModel.getOpSys());
        commonRequestParameters.put("characterSet", commonModel.getCharacterSet());

        String latitude = commonModel.getLatitude();
        if (StringUtils.isNotBlank(latitude)) {
            commonRequestParameters.put("latitude", latitude);
        }

        String longitude = commonModel.getLongitude();
        if (StringUtils.isNotBlank(longitude)) {
            commonRequestParameters.put("longitude", longitude);
        }

        commonRequestParameters.put("orgNo", newLandAccount.getOrgNo());
        commonRequestParameters.put("mercId", newLandAccount.getMchId());
        commonRequestParameters.put("trmNo", newLandAccount.getTrmNo());

        String oprId = commonModel.getOprId();
        if (StringUtils.isNotBlank(oprId)) {
            commonRequestParameters.put("oprId", oprId);
        }

        String trmTyp = commonModel.getTrmTyp();
        if (StringUtils.isNotBlank(trmTyp)) {
            commonRequestParameters.put("trmTyp", trmTyp);
        }

        commonRequestParameters.put("tradeNo", commonModel.getTradeNo());
        commonRequestParameters.put("txnTime", commonModel.getTxnTime());

        commonRequestParameters.put("signType", Constants.MD5);

        String addField = commonModel.getAddField();
        if (StringUtils.isNotBlank(addField)) {
            commonRequestParameters.put("addField", addField);
        }

        commonRequestParameters.put("version", commonModel.getVersion());
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

    public static Map<String, String> barcodePay(String tenantId, String branchId, BarcodePayModel barcodePayModel) {
        barcodePayModel.validateAndThrow();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> barcodePayRequestParameters = buildCommonRequestParameters(barcodePayModel, newLandAccount);
        barcodePayRequestParameters.put("amount", barcodePayModel.getAmount().toString());
        barcodePayRequestParameters.put("total_amount", barcodePayModel.getTotalAmount().toString());
        barcodePayRequestParameters.put("authCode", barcodePayModel.getAuthCode());
        barcodePayRequestParameters.put("payChannel", barcodePayModel.getPayChannel());

        String subject = barcodePayModel.getSubject();
        if (StringUtils.isNotBlank(subject)) {
            barcodePayRequestParameters.put("subject", subject);
        }

        String selOrderNo = barcodePayModel.getSelOrderNo();
        if (StringUtils.isNotBlank(selOrderNo)) {
            barcodePayRequestParameters.put("selOrderNo", selOrderNo);
        }

        String goodsTag = barcodePayModel.getGoodsTag();
        if (StringUtils.isNotBlank(goodsTag)) {
            barcodePayRequestParameters.put("goodsTag", goodsTag);
        }

        String attach = barcodePayModel.getAttach();
        if (StringUtils.isNotBlank(attach)) {
            barcodePayRequestParameters.put("attach", attach);
        }

        barcodePayRequestParameters.put("signValue", generateSign(barcodePayRequestParameters, newLandAccount.getSecretKey()));

        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + Constants.SDK_BARCODE_PAY + ".json";

        String charsetName = obtainCharsetName(barcodePayModel.getCharacterSet());
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(charsetName), GsonUtils.toJson(barcodePayRequestParameters), charsetName);
        String result = UrlUtils.decode(webResponse.getResult(), Constants.CHARSET_NAME_UTF_8);

        Map<String, String> resultMap = JacksonUtils.readValueAsMap(result, String.class, String.class);

        String message = resultMap.get("message");
        ValidateUtils.isTrue("000000".equals(resultMap.get("returnCode")), message);

        return resultMap;
    }

    public static Map<String, String> barcodePosPay(String tenantId, String branchId, BarcodePosPayModel barcodePosPayModel) {
        barcodePosPayModel.validateAndThrow();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> barcodePosPayRequestParameters = buildCommonRequestParameters(barcodePosPayModel, newLandAccount);
        barcodePosPayRequestParameters.put("amount", barcodePosPayModel.getAmount().toString());
        barcodePosPayRequestParameters.put("total_amount", barcodePosPayModel.getTotalAmount().toString());
        barcodePosPayRequestParameters.put("payChannel", barcodePosPayModel.getPayChannel());

        String subject = barcodePosPayModel.getSubject();
        if (StringUtils.isNotBlank(subject)) {
            barcodePosPayRequestParameters.put("subject", subject);
        }

        String selOrderNo = barcodePosPayModel.getSelOrderNo();
        if (StringUtils.isNotBlank(selOrderNo)) {
            barcodePosPayRequestParameters.put("selOrderNo", selOrderNo);
        }

        String goodsTag = barcodePosPayModel.getGoodsTag();
        if (StringUtils.isNotBlank(goodsTag)) {
            barcodePosPayRequestParameters.put("goodsTag", goodsTag);
        }

        String attach = barcodePosPayModel.getAttach();
        if (StringUtils.isNotBlank(attach)) {
            barcodePosPayRequestParameters.put("attach", attach);
        }

        barcodePosPayRequestParameters.put("signValue", generateSign(barcodePosPayRequestParameters, newLandAccount.getSecretKey()));

        String charsetName = obtainCharsetName(barcodePosPayModel.getCharacterSet());

        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + Constants.SDK_BARCODE_POS_PAY + ".json";
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(charsetName), GsonUtils.toJson(barcodePosPayRequestParameters), charsetName);
        String result = UrlUtils.decode(webResponse.getResult(), Constants.CHARSET_NAME_UTF_8);

        Map<String, String> resultMap = JacksonUtils.readValueAsMap(result, String.class, String.class);

        String message = resultMap.get("message");
        ValidateUtils.isTrue("000000".equals(resultMap.get("returnCode")), message);

        return resultMap;
    }

    public static Map<String, String> refundBarcodePay(String tenantId, String branchId, RefundBarcodePayModel refundBarcodePayModel) {
        refundBarcodePayModel.validateAndThrow();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> refundBarcodePayRequestParameters = buildCommonRequestParameters(refundBarcodePayModel, newLandAccount);
        refundBarcodePayRequestParameters.put("orderNo", refundBarcodePayModel.getOrderNo());
        Integer txnAmt = refundBarcodePayModel.getTxnAmt();
        if (txnAmt != null) {
            refundBarcodePayRequestParameters.put("txnAmt", txnAmt.toString());
        }

        refundBarcodePayRequestParameters.put("signValue", generateSign(refundBarcodePayRequestParameters, newLandAccount.getSecretKey()));

        String charsetName = obtainCharsetName(refundBarcodePayModel.getCharacterSet());

        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + Constants.SDK_REFUND_BARCODE_PAY + ".json";
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(charsetName), GsonUtils.toJson(refundBarcodePayRequestParameters), charsetName);
        String result = UrlUtils.decode(webResponse.getResult(), Constants.CHARSET_NAME_UTF_8);

        Map<String, String> resultMap = JacksonUtils.readValueAsMap(result, String.class, String.class);

        String message = resultMap.get("message");
        ValidateUtils.isTrue("000000".equals(resultMap.get("returnCode")), message);

        return resultMap;
    }

    public static Map<String, String> qryBarcodePay(String tenantId, String branchId, QryBarcodePayModel qryBarcodePayModel) {
        qryBarcodePayModel.validateAndThrow();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> qryBarcodePayRequestParameters = buildCommonRequestParameters(qryBarcodePayModel, newLandAccount);
        qryBarcodePayRequestParameters.put("qryNo", qryBarcodePayModel.getQryNo());
        qryBarcodePayRequestParameters.put("signValue", generateSign(qryBarcodePayRequestParameters, newLandAccount.getSecretKey()));

        String charsetName = obtainCharsetName(qryBarcodePayModel.getCharacterSet());
        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + Constants.SDK_QRY_BARCODE_PAY + ".json";
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(charsetName), GsonUtils.toJson(qryBarcodePayRequestParameters), charsetName);
        String result = UrlUtils.decode(webResponse.getResult(), Constants.CHARSET_NAME_UTF_8);

        Map<String, String> resultMap = JacksonUtils.readValueAsMap(result, String.class, String.class);

        String message = resultMap.get("message");
        ValidateUtils.isTrue("000000".equals(resultMap.get("returnCode")), message);

        return resultMap;
    }

    public static Map<String, String> pubSigQry(String tenantId, String branchId, PubSigQryModel pubSigQryModel) {
        pubSigQryModel.validateAndThrow();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> pubSigQryRequestParameters = new HashMap<String, String>();
        pubSigQryRequestParameters.put("orgNo", newLandAccount.getOrgNo());
        pubSigQryRequestParameters.put("mercId", newLandAccount.getMchId());
        pubSigQryRequestParameters.put("trmNo", newLandAccount.getTrmNo());
        pubSigQryRequestParameters.put("txnTime", pubSigQryModel.getTxnTime());

        String attach = pubSigQryModel.getAttach();
        if (StringUtils.isNotBlank(attach)) {
            pubSigQryRequestParameters.put("attach", attach);
        }
        pubSigQryRequestParameters.put("version", pubSigQryModel.getVersion());

        pubSigQryRequestParameters.put("signType", Constants.MD5);
        pubSigQryRequestParameters.put("signValue", generateSign(pubSigQryRequestParameters, newLandAccount.getSecretKey()));

        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + Constants.PUB_SIG_QRY + ".json";
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(Constants.CHARSET_NAME_UTF_8), GsonUtils.toJson(pubSigQryRequestParameters), Constants.CHARSET_NAME_UTF_8);
        String result = UrlUtils.decode(webResponse.getResult(), Constants.CHARSET_NAME_UTF_8);

        Map<String, String> resultMap = JacksonUtils.readValueAsMap(result, String.class, String.class);

        String message = resultMap.get("message");
        ValidateUtils.isTrue("000000".equals(resultMap.get("returnCode")), message);

        return resultMap;
    }

    public static Map<String, String> pubSigPay(String tenantId, String branchId, PubSigPayModel pubSigPayModel) {
        pubSigPayModel.validateAndThrow();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> pubSigPayRequestParameters = new HashMap<String, String>();
        pubSigPayRequestParameters.put("orgNo", newLandAccount.getOrgNo());
        pubSigPayRequestParameters.put("mercId", newLandAccount.getMchId());
        pubSigPayRequestParameters.put("trmNo", newLandAccount.getTrmNo());
        pubSigPayRequestParameters.put("txnTime", pubSigPayModel.getTxnTime());
        pubSigPayRequestParameters.put("version", pubSigPayModel.getVersion());

        String code = pubSigPayModel.getCode();
        if (StringUtils.isNotBlank(code)) {
            pubSigPayRequestParameters.put("code", code);
        }

        String openid = pubSigPayModel.getOpenid();
        if (StringUtils.isNotBlank(openid)) {
            pubSigPayRequestParameters.put("openid", openid);
        }

        pubSigPayRequestParameters.put("amount", pubSigPayModel.getAmount().toString());
        pubSigPayRequestParameters.put("total_amount", pubSigPayModel.getTotalAmount().toString());

        String subject = pubSigPayModel.getSubject();
        if (StringUtils.isNotBlank(subject)) {
            pubSigPayRequestParameters.put("subject", subject);
        }

        String selOrderNo = pubSigPayModel.getSelOrderNo();
        if (StringUtils.isNotBlank(selOrderNo)) {
            pubSigPayRequestParameters.put("selOrderNo", selOrderNo);
        }

        String goodsTag = pubSigPayModel.getGoodsTag();
        if (StringUtils.isNotBlank(goodsTag)) {
            pubSigPayRequestParameters.put("goodsTag", goodsTag);
        }

        String attach = pubSigPayModel.getAttach();
        if (StringUtils.isNotBlank(attach)) {
            pubSigPayRequestParameters.put("attach", attach);
        }

        pubSigPayRequestParameters.put("signType", Constants.MD5);
        pubSigPayRequestParameters.put("signValue", generateSign(pubSigPayRequestParameters, newLandAccount.getSecretKey()));

        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + Constants.PUB_SIG_PAY + ".json";
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(Constants.CHARSET_NAME_UTF_8), GsonUtils.toJson(pubSigPayRequestParameters), Constants.CHARSET_NAME_UTF_8);
        String result = UrlUtils.decode(webResponse.getResult(), Constants.CHARSET_NAME_UTF_8);

        Map<String, String> resultMap = JacksonUtils.readValueAsMap(result, String.class, String.class);

        String message = resultMap.get("message");
        ValidateUtils.isTrue("000000".equals(resultMap.get("returnCode")), message);

        return resultMap;
    }
}
