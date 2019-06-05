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
        String newLandAccountJson = CommonRedisUtils.hget(Constants.KEY_NEW_LAND_ACCOUNTS, tenantId + "_" + branchId);
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

    private static Map<String, String> buildCommonRequestParameters(NewLandBasicModel newLandBasicModel, NewLandAccount newLandAccount) {
        String opSys = newLandBasicModel.getOpSys();
        String characterSet = newLandBasicModel.getCharacterSet();
        String latitude = newLandBasicModel.getLatitude();
        String longitude = newLandBasicModel.getLongitude();
        String oprId = newLandBasicModel.getOprId();
        String trmTyp = newLandBasicModel.getTrmTyp();
        String tradeNo = newLandBasicModel.getTradeNo();
        String txnTime = newLandBasicModel.getTxnTime();
        String addField = newLandBasicModel.getAddField();
        String version = newLandBasicModel.getVersion();

        String orgNo = newLandAccount.getOrgNo();
        String mchId = newLandAccount.getMchId();
        String trmNo = newLandAccount.getTrmNo();

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
        commonRequestParameters.put("mercId", mchId);
        commonRequestParameters.put("trmNo", trmNo);

        if (StringUtils.isNotBlank(oprId)) {
            commonRequestParameters.put("oprId", oprId);
        }

        if (StringUtils.isNotBlank(trmTyp)) {
            commonRequestParameters.put("trmTyp", trmTyp);
        }

        commonRequestParameters.put("tradeNo", tradeNo);
        commonRequestParameters.put("txnTime", txnTime);

        commonRequestParameters.put("signType", Constants.MD5);

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

    public static Map<String, String> callNewLandSystem(Map<String, String> requestParameters, String charsetName, String apiName, String secretKey) {
        requestParameters.put("signValue", generateSign(requestParameters, secretKey));

        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + apiName + ".json";

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, buildHeaders(charsetName), GsonUtils.toJson(requestParameters), charsetName);
        String result = UrlUtils.decode(webResponse.getResult(), Constants.CHARSET_NAME_UTF_8);

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

        String tenantId = barcodePayModel.getTenantId();
        String branchId = barcodePayModel.getBranchId();
        Integer amount = barcodePayModel.getAmount();
        Integer totalAmount = barcodePayModel.getTotalAmount();
        String authCode = barcodePayModel.getAuthCode();
        String payChannel = barcodePayModel.getPayChannel();
        String subject = barcodePayModel.getSubject();
        String selOrderNo = barcodePayModel.getSelOrderNo();
        String goodsTag = barcodePayModel.getGoodsTag();
        String attach = barcodePayModel.getAttach();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> barcodePayRequestParameters = buildCommonRequestParameters(barcodePayModel, newLandAccount);
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
        return callNewLandSystem(barcodePayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_SDK_BARCODE_PAY, obtainCharsetName(barcodePayModel.getCharacterSet()), newLandAccount.getSecretKey());
    }

    /**
     * 扫码支付-客户主扫
     *
     * @param barcodePosPayModel
     * @return
     */
    public static Map<String, String> barcodePosPay(BarcodePosPayModel barcodePosPayModel) {
        barcodePosPayModel.validateAndThrow();

        String tenantId = barcodePosPayModel.getTenantId();
        String branchId = barcodePosPayModel.getBranchId();
        Integer amount = barcodePosPayModel.getAmount();
        Integer totalAmount = barcodePosPayModel.getTotalAmount();
        String payChannel = barcodePosPayModel.getPayChannel();
        String subject = barcodePosPayModel.getSubject();
        String selOrderNo = barcodePosPayModel.getSelOrderNo();
        String goodsTag = barcodePosPayModel.getGoodsTag();
        String attach = barcodePosPayModel.getAttach();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> barcodePosPayRequestParameters = buildCommonRequestParameters(barcodePosPayModel, newLandAccount);
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
        return callNewLandSystem(barcodePosPayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_SDK_BARCODE_POS_PAY, obtainCharsetName(barcodePosPayModel.getCharacterSet()), newLandAccount.getSecretKey());
    }

    /**
     * 退款
     *
     * @param refundBarcodePayModel
     * @return
     */
    public static Map<String, String> refundBarcodePay(RefundBarcodePayModel refundBarcodePayModel) {
        refundBarcodePayModel.validateAndThrow();

        String tenantId = refundBarcodePayModel.getTenantId();
        String branchId = refundBarcodePayModel.getBranchId();
        String orderNo = refundBarcodePayModel.getOrderNo();
        Integer txnAmt = refundBarcodePayModel.getTxnAmt();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> refundBarcodePayRequestParameters = buildCommonRequestParameters(refundBarcodePayModel, newLandAccount);
        refundBarcodePayRequestParameters.put("orderNo", orderNo);
        if (txnAmt != null) {
            refundBarcodePayRequestParameters.put("txnAmt", txnAmt.toString());
        }
        return callNewLandSystem(refundBarcodePayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_SDK_REFUND_BARCODE_PAY, obtainCharsetName(refundBarcodePayModel.getCharacterSet()), newLandAccount.getSecretKey());
    }

    /**
     * 订单查询
     *
     * @param qryBarcodePayModel
     * @return
     */
    public static Map<String, String> qryBarcodePay(QryBarcodePayModel qryBarcodePayModel) {
        qryBarcodePayModel.validateAndThrow();

        String tenantId = qryBarcodePayModel.getTenantId();
        String branchId = qryBarcodePayModel.getBranchId();
        String qryNo = qryBarcodePayModel.getQryNo();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> qryBarcodePayRequestParameters = buildCommonRequestParameters(qryBarcodePayModel, newLandAccount);
        qryBarcodePayRequestParameters.put("qryNo", qryNo);
        return callNewLandSystem(qryBarcodePayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_SDK_QRY_BARCODE_PAY, obtainCharsetName(qryBarcodePayModel.getCharacterSet()), newLandAccount.getSecretKey());
    }

    /**
     * 微信公众号查询
     *
     * @param pubSigQryModel
     * @return
     */
    public static Map<String, String> pubSigQry(PubSigQryModel pubSigQryModel) {
        pubSigQryModel.validateAndThrow();

        String tenantId = pubSigQryModel.getTenantId();
        String branchId = pubSigQryModel.getBranchId();
        String txnTime = pubSigQryModel.getTxnTime();
        String attach = pubSigQryModel.getAttach();
        String version = pubSigQryModel.getVersion();

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        String orgNo = newLandAccount.getOrgNo();
        String mchId = newLandAccount.getMchId();
        String trmNo = newLandAccount.getTrmNo();

        Map<String, String> pubSigQryRequestParameters = new HashMap<String, String>();
        pubSigQryRequestParameters.put("orgNo", orgNo);
        pubSigQryRequestParameters.put("mercId", mchId);
        pubSigQryRequestParameters.put("trmNo", trmNo);
        pubSigQryRequestParameters.put("txnTime", txnTime);

        if (StringUtils.isNotBlank(attach)) {
            pubSigQryRequestParameters.put("attach", attach);
        }
        pubSigQryRequestParameters.put("version", version);

        pubSigQryRequestParameters.put("signType", Constants.MD5);
        return callNewLandSystem(pubSigQryRequestParameters, Constants.NEW_LAND_PAY_API_NAME_PUB_SIG_QRY, Constants.CHARSET_NAME_UTF_8, newLandAccount.getSecretKey());
    }

    /**
     * 微信公众号支付
     *
     * @param pubSigPayModel
     * @return
     */
    public static Map<String, String> pubSigPay(PubSigPayModel pubSigPayModel) {
        pubSigPayModel.validateAndThrow();
        String tenantId = pubSigPayModel.getTenantId();
        String branchId = pubSigPayModel.getBranchId();
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

        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        String orgNo = newLandAccount.getOrgNo();
        String mchId = newLandAccount.getMchId();
        String trmNo = newLandAccount.getTrmNo();

        Map<String, String> pubSigPayRequestParameters = new HashMap<String, String>();
        pubSigPayRequestParameters.put("orgNo", orgNo);
        pubSigPayRequestParameters.put("mercId", mchId);
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

        pubSigPayRequestParameters.put("signType", Constants.MD5);
        return callNewLandSystem(pubSigPayRequestParameters, Constants.NEW_LAND_PAY_API_NAME_PUB_SIG_PAY, Constants.CHARSET_NAME_UTF_8, newLandAccount.getSecretKey());
    }
}
