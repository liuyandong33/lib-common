package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.alipay.*;
import build.dream.common.models.notify.SaveNotifyRecordModel;
import build.dream.common.saas.domains.AlipayAccount;
import build.dream.common.saas.domains.AlipayAuthorizerInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.text.SimpleDateFormat;
import java.util.*;

public class AlipayUtils {
    private static final String ALIPAY_GATEWAY_URL = "https://openapi.alipay.com/gateway.do";
    private static final String ALIPAY_APP_TO_APP_AUTHORIZE_URL = "https://openauth.alipay.com/oauth2/appToAppAuth.htm";

    public static boolean verifySign(String originalString, String signType, String sign, String charset, String alipayPublicKey) {
        String signatureType = null;
        if (Constants.RSA.equals(signType)) {
            signatureType = SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA;
        } else if (Constants.RSA2.equals(signType)) {
            signatureType = SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA;
        }

        byte[] data = org.apache.commons.codec.binary.StringUtils.getBytesUnchecked(originalString, charset);
        return SignatureUtils.verifySign(data, Base64.decodeBase64(alipayPublicKey), Base64.decodeBase64(sign), signatureType);
    }

    public static AlipayAccount obtainAlipayAccount(String appId) {
        String alipayAccountJson = CacheUtils.hget(Constants.KEY_ALIPAY_ACCOUNTS, appId);
        AlipayAccount alipayAccount = null;
        if (StringUtils.isNotBlank(alipayAccountJson)) {
            alipayAccount = GsonUtils.fromJson(alipayAccountJson, AlipayAccount.class);
        }
        return alipayAccount;
    }

    public static String callAlipayApi(String requestBody) {
        WebResponse webResponse = OutUtils.doPostWithRequestBody(ALIPAY_GATEWAY_URL, null, requestBody);
        return webResponse.getResult();
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String format, String returnUrl, String charset, String notifyUrl, String bizContent) {
        String signType = alipayAccount.getSignType();
        BuildRequestBodyModel buildRequestBodyModel = BuildRequestBodyModel.builder()
                .appId(alipayAccount.getAppId())
                .method(method)
                .format(format)
                .returnUrl(returnUrl)
                .charset(charset)
                .signType(signType)
                .notifyUrl(notifyUrl)
                .bizContent(bizContent)
                .privateKey(alipayAccount.getApplicationPrivateKey())
                .build();
        String requestBody = buildRequestBody(buildRequestBodyModel);

        String result = callAlipayApi(requestBody);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        Map<String, Object> responseMap = MapUtils.getMap(resultMap, method.replaceAll("\\.", "_") + "_response");

        ValidateUtils.isTrue(verifySign(GsonUtils.toJson(responseMap), signType, MapUtils.getString(resultMap, "sign"), charset, alipayAccount.getAlipayPublicKey()), "支付宝返回结果签名验证未通过！");

        String code = MapUtils.getString(responseMap, "code");
        String msg = MapUtils.getString(responseMap, "msg");
        ValidateUtils.isTrue("10000".equals(code), msg);

        if (responseMap.containsKey("sub_code")) {
            ValidateUtils.isTrue(false, MapUtils.getString(responseMap, "sub_msg"));
        }
        return responseMap;
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String returnUrl, String notifyUrl, String bizContent) {
        return callAlipayApi(alipayAccount, method, Constants.JSON, returnUrl, Constants.UTF_8, notifyUrl, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String notifyUrl, String bizContent) {
        return callAlipayApi(alipayAccount, method, Constants.JSON, null, Constants.UTF_8, notifyUrl, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String bizContent) {
        return callAlipayApi(alipayAccount, method, Constants.JSON, null, Constants.UTF_8, null, bizContent);
    }

    public static Map<String, String> buildRequestParameters(String appId, String method, String format, String returnUrl, String charset, String signType, String notifyUrl, String authToken, String appAuthToken, String bizContent, String privateKey) {
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>();
        sortedRequestParameters.put("app_id", appId);
        sortedRequestParameters.put("method", method);
        sortedRequestParameters.put("format", format);
        sortedRequestParameters.put("charset", charset);
        if (StringUtils.isNotBlank(returnUrl)) {
            sortedRequestParameters.put("return_url", returnUrl);
        }
        sortedRequestParameters.put("sign_type", signType);
        sortedRequestParameters.put("timestamp", new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date()));
        sortedRequestParameters.put("version", "1.0");
        if (StringUtils.isNotBlank(notifyUrl)) {
            sortedRequestParameters.put("notify_url", notifyUrl);
        }

        if (StringUtils.isNotBlank(authToken)) {
            sortedRequestParameters.put("auth_token", authToken);
        }

        sortedRequestParameters.put("app_auth_token", appAuthToken);
        sortedRequestParameters.put("biz_content", bizContent);

        String signatureType = null;
        if (Constants.RSA.equals(signType)) {
            signatureType = SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA;
        } else if (Constants.RSA2.equals(signType)) {
            signatureType = SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA;
        }

        byte[] data = org.apache.commons.codec.binary.StringUtils.getBytesUnchecked(WebUtils.concat(sortedRequestParameters), charset);
        String sign = Base64.encodeBase64String(SignatureUtils.sign(data, Base64.decodeBase64(privateKey), signatureType));
        sortedRequestParameters.put("sign", sign);
        return sortedRequestParameters;
    }

    public static String buildRequestBody(String appId, String method, String format, String returnUrl, String charset, String signType, String notifyUrl, String authToken, String appAuthToken, String bizContent, String privateKey) {
        Map<String, String> requestParameters = buildRequestParameters(appId, method, format, returnUrl, charset, signType, notifyUrl, authToken, appAuthToken, bizContent, privateKey);
        return WebUtils.buildRequestBody(requestParameters, charset);
    }

    public static String buildRequestBody(BuildRequestBodyModel buildRequestBodyModel) {
        String appId = buildRequestBodyModel.getAppId();
        String method = buildRequestBodyModel.getMethod();
        String format = buildRequestBodyModel.getFormat();
        String returnUrl = buildRequestBodyModel.getReturnUrl();
        String charset = buildRequestBodyModel.getCharset();
        String signType = buildRequestBodyModel.getSignType();
        String notifyUrl = buildRequestBodyModel.getNotifyUrl();
        String authToken = buildRequestBodyModel.getAuthToken();
        String appAuthToken = buildRequestBodyModel.getAppAuthToken();
        String bizContent = buildRequestBodyModel.getBizContent();
        String privateKey = buildRequestBodyModel.getPrivateKey();
        return buildRequestBody(appId, method, format, returnUrl, charset, signType, notifyUrl, authToken, appAuthToken, bizContent, privateKey);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String format, String returnUrl, String charset, String notifyUrl, String authToken, String bizContent) {
        AlipayAccount alipayAccount = obtainAlipayAccount(alipayAuthorizerInfo.getAppId());
        String signType = alipayAccount.getSignType();

        BuildRequestBodyModel buildRequestBodyModel = BuildRequestBodyModel.builder()
                .appId(alipayAuthorizerInfo.getAppId())
                .method(method)
                .format(format)
                .returnUrl(returnUrl)
                .charset(charset)
                .signType(signType)
                .notifyUrl(notifyUrl)
                .authToken(authToken)
                .appAuthToken(alipayAuthorizerInfo.getAppAuthToken())
                .bizContent(bizContent)
                .privateKey(alipayAccount.getApplicationPrivateKey())
                .build();

        String requestBody = buildRequestBody(buildRequestBodyModel);
        String result = callAlipayApi(requestBody);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        Map<String, Object> responseMap = MapUtils.getMap(resultMap, method.replaceAll("\\.", "_") + "_response");

        String alipayPublicKey = alipayAccount.getAlipayPublicKey();
        ValidateUtils.isTrue(verifySign(GsonUtils.toJson(responseMap), signType, MapUtils.getString(resultMap, "sign"), charset, alipayPublicKey), "支付宝返回结果签名验证未通过！");

        String code = MapUtils.getString(responseMap, "code");
        String msg = MapUtils.getString(responseMap, "msg");
        ValidateUtils.isTrue("10000".equals(code), msg);

        if (responseMap.containsKey("sub_code")) {
            ValidateUtils.isTrue(false, MapUtils.getString(responseMap, "sub_msg"));
        }
        return responseMap;
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String returnUrl, String notifyUrl, String authToken, String bizContent) {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, returnUrl, Constants.CHARSET_NAME_UTF_8, notifyUrl, authToken, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String returnUrl, String notifyUrl, String bizContent) {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, returnUrl, Constants.CHARSET_NAME_UTF_8, notifyUrl, null, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String notifyUrl, String bizContent) {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, null, Constants.CHARSET_NAME_UTF_8, notifyUrl, null, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String bizContent) {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, null, Constants.CHARSET_NAME_UTF_8, null, null, bizContent);
    }


    /***************************************************************支付API开始***************************************************************/
    /**
     * 统一收单交易退款查询
     *
     * @param alipayTradeFastPayRefundQueryModel
     * @return
     */
    public static Map<String, Object> alipayTradeFastPayRefundQuery(AlipayTradeFastPayRefundQueryModel alipayTradeFastPayRefundQueryModel) {
        alipayTradeFastPayRefundQueryModel.validateAndThrow();

        String tenantId = alipayTradeFastPayRefundQueryModel.getTenantId();
        String branchId = alipayTradeFastPayRefundQueryModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.fastpay.refund.query", JacksonUtils.writeValueAsString(alipayTradeFastPayRefundQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单交易结算接口
     *
     * @param alipayTradeOrderSettleModel
     * @return
     */
    public static Map<String, Object> alipayTradeOrderSettle(AlipayTradeOrderSettleModel alipayTradeOrderSettleModel) {
        alipayTradeOrderSettleModel.validateAndThrow();

        String tenantId = alipayTradeOrderSettleModel.getTenantId();
        String branchId = alipayTradeOrderSettleModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.order.settle", JacksonUtils.writeValueAsString(alipayTradeOrderSettleModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单交易关闭接口
     *
     * @param alipayTradeCloseModel
     * @return
     */
    public static Map<String, Object> alipayTradeClose(AlipayTradeCloseModel alipayTradeCloseModel) {
        alipayTradeCloseModel.validateAndThrow();

        String tenantId = alipayTradeCloseModel.getTenantId();
        String branchId = alipayTradeCloseModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.close", JacksonUtils.writeValueAsString(alipayTradeCloseModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单交易撤销接口
     *
     * @param alipayTradeCancelModel
     * @return
     */
    public static Map<String, Object> alipayTradeCancel(AlipayTradeCancelModel alipayTradeCancelModel) {
        alipayTradeCancelModel.validateAndThrow();

        String tenantId = alipayTradeCancelModel.getTenantId();
        String branchId = alipayTradeCancelModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.cancel", JacksonUtils.writeValueAsString(alipayTradeCancelModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单交易退款接口
     * TODO: model 未实现
     *
     * @param alipayTradeRefundModel
     * @return
     */
    public static Map<String, Object> alipayTradeRefund(AlipayTradeRefundModel alipayTradeRefundModel) {
        alipayTradeRefundModel.validateAndThrow();

        String tenantId = alipayTradeRefundModel.getTenantId();
        String branchId = alipayTradeRefundModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.refund", JacksonUtils.writeValueAsString(alipayTradeRefundModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单线下交易预创建
     *
     * @param alipayTradePreCreateModel
     * @return
     */
    public static Map<String, Object> alipayTradePreCreate(AlipayTradePreCreateModel alipayTradePreCreateModel) {
        alipayTradePreCreateModel.validateAndThrow();

        String tenantId = alipayTradePreCreateModel.getTenantId();
        String branchId = alipayTradePreCreateModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.precreate", JacksonUtils.writeValueAsString(alipayTradePreCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单交易创建接口
     *
     * @param alipayTradeCreateModel
     * @return
     */
    public static Map<String, Object> alipayTradeCreate(AlipayTradeCreateModel alipayTradeCreateModel) {
        alipayTradeCreateModel.validateAndThrow();

        String tenantId = alipayTradeCreateModel.getTenantId();
        String branchId = alipayTradeCreateModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.create", JacksonUtils.writeValueAsString(alipayTradeCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单交易支付接口
     *
     * @param alipayTradePayModel
     * @return
     */
    public static Map<String, Object> alipayTradePay(AlipayTradePayModel alipayTradePayModel) {
        alipayTradePayModel.validateAndThrow();

        String tenantId = alipayTradePayModel.getTenantId();
        String branchId = alipayTradePayModel.getBranchId();
        String notifyUrl = alipayTradePayModel.getNotifyUrl();

        AlipayAuthorizerInfo alipayAuthorizerInfo = null;
        if (StringUtils.isNotBlank(notifyUrl)) {
            alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayTradePayModel.getOutTradeNo(), notifyUrl);
        } else {
            alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
            ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");
        }
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.pay", NotifyUtils.obtainAlipayNotifyUrl(), JacksonUtils.writeValueAsString(alipayTradePayModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单线下交易查询
     *
     * @param alipayTradeQueryModel
     * @return
     */
    public static Map<String, Object> alipayTradeQuery(AlipayTradeQueryModel alipayTradeQueryModel) {
        alipayTradeQueryModel.validateAndThrow();

        String tenantId = alipayTradeQueryModel.getTenantId();
        String branchId = alipayTradeQueryModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.query", JacksonUtils.writeValueAsString(alipayTradeQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 口碑商品交易查询接口
     *
     * @param koubeiTradeItemOrderQueryModel
     * @return
     */
    public static Map<String, Object> koubeiTradeItemOrderQuery(KoubeiTradeItemOrderQueryModel koubeiTradeItemOrderQueryModel) {
        koubeiTradeItemOrderQueryModel.validateAndThrow();

        String tenantId = koubeiTradeItemOrderQueryModel.getTenantId();
        String branchId = koubeiTradeItemOrderQueryModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.trade.itemorder.query", JacksonUtils.writeValueAsString(koubeiTradeItemOrderQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 口碑商品交易购买接口
     * TODO: model 未实现
     *
     * @param koubeiTradeItemOrderBuyModel
     * @return
     */
    public static Map<String, Object> koubeiTradeItemOrderBuy(KoubeiTradeItemOrderBuyModel koubeiTradeItemOrderBuyModel) {
        koubeiTradeItemOrderBuyModel.validateAndThrow();

        String tenantId = koubeiTradeItemOrderBuyModel.getTenantId();
        String branchId = koubeiTradeItemOrderBuyModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.trade.itemorder.buy", JacksonUtils.writeValueAsString(koubeiTradeItemOrderBuyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 口碑商品交易退货接口
     * TODO: model 未实现
     *
     * @param koubeiTradeItemOrderRefundModel
     * @return
     */
    public static Map<String, Object> koubeiTradeItemOrderRefund(KoubeiTradeItemOrderRefundModel koubeiTradeItemOrderRefundModel) {
        koubeiTradeItemOrderRefundModel.validateAndThrow();

        String tenantId = koubeiTradeItemOrderRefundModel.getTenantId();
        String branchId = koubeiTradeItemOrderRefundModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.trade.itemorder.refund", JacksonUtils.writeValueAsString(koubeiTradeItemOrderRefundModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 资金授权冻结接口
     * TODO: model 未实现
     *
     * @param alipayFundAuthOrderFreezeModel
     * @return
     */
    public static Map<String, Object> alipayFundAuthOrderFreeze(AlipayFundAuthOrderFreezeModel alipayFundAuthOrderFreezeModel) {
        alipayFundAuthOrderFreezeModel.validateAndThrow();

        String tenantId = alipayFundAuthOrderFreezeModel.getTenantId();
        String branchId = alipayFundAuthOrderFreezeModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.fund.auth.order.freeze", JacksonUtils.writeValueAsString(alipayFundAuthOrderFreezeModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * app支付接口2.0
     *
     * @param alipayTradeAppPayModel
     * @return
     */
    public static String alipayTradeAppPay(AlipayTradeAppPayModel alipayTradeAppPayModel) {
        String tenantId = alipayTradeAppPayModel.getTenantId();
        String branchId = alipayTradeAppPayModel.getBranchId();
        String notifyUrl = alipayTradeAppPayModel.getNotifyUrl();

        AlipayAuthorizerInfo alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayTradeAppPayModel.getOutTradeNo(), notifyUrl);
        AlipayAccount alipayAccount = obtainAlipayAccount(alipayAuthorizerInfo.getAppId());

        BuildRequestBodyModel buildRequestBodyModel = BuildRequestBodyModel.builder()
                .appId(alipayAuthorizerInfo.getAppId())
                .method("alipay.trade.app.pay")
                .format(Constants.JSON)
                .returnUrl(null)
                .charset(Constants.CHARSET_NAME_UTF_8)
                .signType(alipayAccount.getSignType())
                .notifyUrl(notifyUrl)
                .appAuthToken(alipayAuthorizerInfo.getAppAuthToken())
                .bizContent(JacksonUtils.writeValueAsString(alipayTradeAppPayModel, JsonInclude.Include.NON_NULL))
                .privateKey(alipayAccount.getApplicationPrivateKey())
                .build();

        return buildRequestBody(buildRequestBodyModel);
    }

    /**
     * 手机网站支付接口2.0
     *
     * @param alipayTradeWapPayModel
     * @return
     */
    public static String alipayTradeWapPay(AlipayTradeWapPayModel alipayTradeWapPayModel) {
        alipayTradeWapPayModel.validateAndThrow();

        String tenantId = alipayTradeWapPayModel.getTenantId();
        String branchId = alipayTradeWapPayModel.getBranchId();
        String returnUrl = alipayTradeWapPayModel.getReturnUrl();
        String notifyUrl = alipayTradeWapPayModel.getNotifyUrl();

        AlipayAuthorizerInfo alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayTradeWapPayModel.getOutTradeNo(), notifyUrl);
        AlipayAccount alipayAccount = obtainAlipayAccount(alipayAuthorizerInfo.getAppId());

        BuildRequestBodyModel buildRequestBodyModel = BuildRequestBodyModel.builder()
                .appId(alipayAuthorizerInfo.getAppId())
                .method("alipay.trade.wap.pay")
                .format(Constants.JSON)
                .returnUrl(returnUrl)
                .charset(Constants.CHARSET_NAME_UTF_8)
                .signType(alipayAccount.getSignType())
                .notifyUrl(notifyUrl)
                .appAuthToken(alipayAuthorizerInfo.getAppAuthToken())
                .bizContent(JacksonUtils.writeValueAsString(alipayTradeWapPayModel, JsonInclude.Include.NON_NULL))
                .privateKey(alipayAccount.getApplicationPrivateKey())
                .build();

        return ALIPAY_GATEWAY_URL + "?" + buildRequestBody(buildRequestBodyModel);
    }

    /**
     * 码商发码成功回调接口
     *
     * @param koubeiTradeTicketTicketCodeSendModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeSend(KoubeiTradeTicketTicketCodeSendModel koubeiTradeTicketTicketCodeSendModel) {
        koubeiTradeTicketTicketCodeSendModel.validateAndThrow();

        String tenantId = koubeiTradeTicketTicketCodeSendModel.getTenantId();
        String branchId = koubeiTradeTicketTicketCodeSendModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.trade.ticket.ticketcode.send", JacksonUtils.writeValueAsString(koubeiTradeTicketTicketCodeSendModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 口碑凭证延期接口
     *
     * @param koubeiTradeTicketTicketCodeDelayModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeDelay(KoubeiTradeTicketTicketCodeDelayModel koubeiTradeTicketTicketCodeDelayModel) {
        koubeiTradeTicketTicketCodeDelayModel.validateAndThrow();

        String tenantId = koubeiTradeTicketTicketCodeDelayModel.getTenantId();
        String branchId = koubeiTradeTicketTicketCodeDelayModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.trade.ticket.ticketcode.delay", JacksonUtils.writeValueAsString(koubeiTradeTicketTicketCodeDelayModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 口碑凭证码撤销核销
     *
     * @param koubeiTradeTicketTicketCodeCancelModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeCancel(KoubeiTradeTicketTicketCodeCancelModel koubeiTradeTicketTicketCodeCancelModel) {
        koubeiTradeTicketTicketCodeCancelModel.validateAndThrow();

        String tenantId = koubeiTradeTicketTicketCodeCancelModel.getTenantId();
        String branchId = koubeiTradeTicketTicketCodeCancelModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.trade.ticket.ticketcode.cancel", JacksonUtils.writeValueAsString(koubeiTradeTicketTicketCodeCancelModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 口碑凭证码查询
     *
     * @param koubeiTradeTicketTicketCodeQueryModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeQuery(KoubeiTradeTicketTicketCodeQueryModel koubeiTradeTicketTicketCodeQueryModel) {
        koubeiTradeTicketTicketCodeQueryModel.validateAndThrow();

        String tenantId = koubeiTradeTicketTicketCodeQueryModel.getTenantId();
        String branchId = koubeiTradeTicketTicketCodeQueryModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.trade.ticket.ticketcode.query", JacksonUtils.writeValueAsString(koubeiTradeTicketTicketCodeQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 支付宝订单信息同步接口
     *
     * @param alipayTradeOrderInfoSyncModel
     * @return
     */
    public static Map<String, Object> alipayTradeOrderInfoSync(AlipayTradeOrderInfoSyncModel alipayTradeOrderInfoSyncModel) {
        alipayTradeOrderInfoSyncModel.validateAndThrow();

        String tenantId = alipayTradeOrderInfoSyncModel.getTenantId();
        String branchId = alipayTradeOrderInfoSyncModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.orderinfo.sync", JacksonUtils.writeValueAsString(alipayTradeOrderInfoSyncModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 统一收单下单并支付页面接口
     *
     * @param alipayTradePagePayModel
     * @return
     */
    public static String alipayTradePagePay(AlipayTradePagePayModel alipayTradePagePayModel) {
        alipayTradePagePayModel.validateAndThrow();

        String tenantId = alipayTradePagePayModel.getTenantId();
        String branchId = alipayTradePagePayModel.getBranchId();
        String returnUrl = alipayTradePagePayModel.getReturnUrl();
        String notifyUrl = alipayTradePagePayModel.getNotifyUrl();

        AlipayAuthorizerInfo alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayTradePagePayModel.getOutTradeNo(), notifyUrl);
        AlipayAccount alipayAccount = obtainAlipayAccount(alipayAuthorizerInfo.getAppId());
        BuildRequestBodyModel buildRequestBodyModel = BuildRequestBodyModel.builder()
                .appId(alipayAuthorizerInfo.getAppId())
                .method("alipay.trade.page.pay")
                .format(Constants.JSON)
                .returnUrl(returnUrl)
                .charset(Constants.CHARSET_NAME_UTF_8)
                .signType(alipayAccount.getSignType())
                .notifyUrl(notifyUrl)
                .appAuthToken(alipayAuthorizerInfo.getAppAuthToken())
                .bizContent(JacksonUtils.writeValueAsString(alipayTradePagePayModel, JsonInclude.Include.NON_NULL))
                .privateKey(alipayAccount.getApplicationPrivateKey())
                .build();

        return ALIPAY_GATEWAY_URL + "?" + buildRequestBody(buildRequestBodyModel);
    }

    /**
     * 口碑订单预下单
     *
     * @param koubeiTradeOrderPreCreateModel
     * @return
     */
    public static Map<String, Object> koubeiTradeOrderPreCreate(KoubeiTradeOrderPreCreateModel koubeiTradeOrderPreCreateModel) {
        koubeiTradeOrderPreCreateModel.validateAndThrow();

        String tenantId = koubeiTradeOrderPreCreateModel.getTenantId();
        String branchId = koubeiTradeOrderPreCreateModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.trade.order.precreate", JacksonUtils.writeValueAsString(koubeiTradeOrderPreCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 网商银行全渠道收单业务订单创建
     * TODO: model 未实现
     *
     * @param myBankPaymentTradeOrderCreateModel
     * @return
     */
    public static Map<String, Object> myBankPaymentTradeOrderCreate(MyBankPaymentTradeOrderCreateModel myBankPaymentTradeOrderCreateModel) {
        myBankPaymentTradeOrderCreateModel.validateAndThrow();

        String tenantId = myBankPaymentTradeOrderCreateModel.getTenantId();
        String branchId = myBankPaymentTradeOrderCreateModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "mybank.payment.trade.order.create", JacksonUtils.writeValueAsString(myBankPaymentTradeOrderCreateModel, JsonInclude.Include.NON_NULL));
    }

    /***************************************************************支付API结束***************************************************************/

    private static AlipayAuthorizerInfo saveNotifyRecord(String tenantId, String branchId, String uuid, String notifyUrl) {
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        ValidateUtils.notNull(alipayAuthorizerInfo, "未检索到支付宝授权信息");
        String appId = alipayAuthorizerInfo.getAppId();
        String alipayPublicKey = ConfigurationUtils.getConfiguration(appId + "." + Constants.ALIPAY_PUBLIC_KEY);
        String signType = ConfigurationUtils.getConfiguration(appId + "." + Constants.ALIPAY_SIGN_TYPE);

        String serviceName = ConfigurationUtils.getConfiguration(Constants.SERVICE_NAME);
        if (Constants.SERVICE_NAME_PLATFORM.equals(serviceName)) {
            SaveNotifyRecordModel saveNotifyRecordModel = SaveNotifyRecordModel.builder()
                    .uuid(uuid)
                    .notifyUrl(notifyUrl)
                    .alipayPublicKey(alipayPublicKey)
                    .alipaySignType(signType)
                    .build();
            DataSourceTransactionManager dataSourceTransactionManager = ApplicationHandler.getBean(DataSourceTransactionManager.class);
            DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
            defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
            TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
            try {
                NotifyUtils.saveNotifyRecord(saveNotifyRecordModel);
                dataSourceTransactionManager.commit(transactionStatus);
            } catch (Exception e) {
                dataSourceTransactionManager.rollback(transactionStatus);
                throw e;
            }
        } else {
            Map<String, String> saveNotifyRecordRequestParameters = new HashMap<String, String>();
            saveNotifyRecordRequestParameters.put("uuid", uuid);
            saveNotifyRecordRequestParameters.put("notifyUrl", notifyUrl);
            saveNotifyRecordRequestParameters.put("alipayPublicKey", alipayPublicKey);
            saveNotifyRecordRequestParameters.put("alipaySignType", signType);

            ApiRest saveNotifyRecordResult = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "notify", "saveNotifyRecord", saveNotifyRecordRequestParameters);
            ValidateUtils.isTrue(saveNotifyRecordResult.isSuccessful(), saveNotifyRecordResult.getError());
        }

        return alipayAuthorizerInfo;
    }

    public static String generateAppToAppAuthorizeUrl(String appId, String redirectUri) {
        return ALIPAY_APP_TO_APP_AUTHORIZE_URL + "?app_id=" + appId + "&redirect_uri=" + UrlUtils.encode(redirectUri, Constants.CHARSET_NAME_UTF_8);
    }

    public static String generatePublicAppAuthorizeUrl(String appId, String scope, String redirectUri, String state) {
        StringBuilder publicAppAuthorizeUrl = new StringBuilder();
        publicAppAuthorizeUrl.append(ConfigurationUtils.getConfiguration(Constants.ALIPAY_PUBLIC_APP_AUTHORIZE_URL));
        publicAppAuthorizeUrl.append("?app_id=").append(appId);
        publicAppAuthorizeUrl.append("&scope=").append(scope);
        publicAppAuthorizeUrl.append("&redirect_uri=").append(UrlUtils.encode(redirectUri, Constants.CHARSET_NAME_UTF_8));
        if (StringUtils.isNotBlank(state)) {
            publicAppAuthorizeUrl.append("&state=").append(state);
        }
        return publicAppAuthorizeUrl.toString();
    }

    public static Map<String, Object> aftAiFinFireEyeOcrImageQuery(AftAiFinFireEyeOcrImageQueryModel aftAiFinFireEyeOcrImageQueryModel) {
        String tenantId = aftAiFinFireEyeOcrImageQueryModel.getTenantId();
        String branchId = aftAiFinFireEyeOcrImageQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");
        return callAlipayApi(alipayAuthorizerInfo, "aft.aifin.fireeye.ocr.image.query", JacksonUtils.writeValueAsString(aftAiFinFireEyeOcrImageQueryModel));
    }

    /**
     * 换取应用授权令牌
     *
     * @param alipayOpenAuthTokenAppModel
     * @return
     */
    public static AlipayAuthorizerInfo alipayOpenAuthTokenApp(AlipayOpenAuthTokenAppModel alipayOpenAuthTokenAppModel) {
        String appId = alipayOpenAuthTokenAppModel.getAppId();
        AlipayAccount alipayAccount = obtainAlipayAccount(appId);
        ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
        Map<String, Object> resultMap = callAlipayApi(alipayAccount, "alipay.open.auth.token.app", JacksonUtils.writeValueAsString(alipayOpenAuthTokenAppModel, JsonInclude.Include.NON_NULL));

        AlipayAuthorizerInfo alipayAuthorizerInfo = new AlipayAuthorizerInfo();
        alipayAuthorizerInfo.setAppId(appId);
        alipayAuthorizerInfo.setAppAuthToken(MapUtils.getString(resultMap, "app_auth_token"));
        alipayAuthorizerInfo.setUserId(MapUtils.getString(resultMap, "user_id"));
        alipayAuthorizerInfo.setAuthAppId(MapUtils.getString(resultMap, "auth_app_id"));
        alipayAuthorizerInfo.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
        alipayAuthorizerInfo.setReExpiresIn(MapUtils.getIntValue(resultMap, "re_expires_in"));
        alipayAuthorizerInfo.setAppRefreshToken(MapUtils.getString(resultMap, "app_refresh_token"));
        return alipayAuthorizerInfo;
    }

    /**
     * 获取支付宝授权信息
     *
     * @param tenantId
     * @param branchId
     * @return
     */
    public static AlipayAuthorizerInfo obtainAlipayAuthorizerInfo(String tenantId, String branchId) {
        String alipayAuthorizerInfoJson = CacheUtils.hget(Constants.KEY_ALIPAY_AUTHORIZER_INFOS, tenantId + "_" + branchId);
        if (StringUtils.isNotBlank(alipayAuthorizerInfoJson)) {
            return JacksonUtils.readValue(alipayAuthorizerInfoJson, AlipayAuthorizerInfo.class);
        }
        return null;
    }

    /**
     * 重新设置绑定商家会员号
     *
     * @param alipayOpenPublicAccountResetModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAccountReset(AlipayOpenPublicAccountResetModel alipayOpenPublicAccountResetModel) {
        String tenantId = alipayOpenPublicAccountResetModel.getTenantId();
        String branchId = alipayOpenPublicAccountResetModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.account.reset", JacksonUtils.writeValueAsString(alipayOpenPublicAccountResetModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 获取关注者列表
     *
     * @param alipayOpenPublicFollowBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicFollowBatchQuery(AlipayOpenPublicFollowBatchQueryModel alipayOpenPublicFollowBatchQueryModel) {
        String tenantId = alipayOpenPublicFollowBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicFollowBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.follow.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicFollowBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 消息模板领取接口
     *
     * @param alipayOpenPublicTemplateMessageGetModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTemplateMessageGet(AlipayOpenPublicTemplateMessageGetModel alipayOpenPublicTemplateMessageGetModel) {
        String tenantId = alipayOpenPublicTemplateMessageGetModel.getTenantId();
        String branchId = alipayOpenPublicTemplateMessageGetModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.template.message.get", JacksonUtils.writeValueAsString(alipayOpenPublicTemplateMessageGetModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 单发模板消息
     * TODO: model未实现
     *
     * @param alipayOpenPublicMessageSingleSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageSingleSend(AlipayOpenPublicMessageSingleSendModel alipayOpenPublicMessageSingleSendModel) {
        String tenantId = alipayOpenPublicMessageSingleSendModel.getTenantId();
        String branchId = alipayOpenPublicMessageSingleSendModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.message.single.send", JacksonUtils.writeValueAsString(alipayOpenPublicMessageSingleSendModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 带参推广二维码接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicQrCodeCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicQrCodeCreate(AlipayOpenPublicQrCodeCreateModel alipayOpenPublicQrCodeCreateModel) {
        String tenantId = alipayOpenPublicQrCodeCreateModel.getTenantId();
        String branchId = alipayOpenPublicQrCodeCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.qrcode.create", JacksonUtils.writeValueAsString(alipayOpenPublicQrCodeCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 查询绑定商户会员号
     *
     * @param alipayOpenPublicAccountQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAccountQuery(AlipayOpenPublicAccountQueryModel alipayOpenPublicAccountQueryModel) {
        String tenantId = alipayOpenPublicAccountQueryModel.getTenantId();
        String branchId = alipayOpenPublicAccountQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.account.query", JacksonUtils.writeValueAsString(alipayOpenPublicAccountQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 解除绑定商户会员号O
     *
     * @param alipayOpenPublicAccountDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAccountDelete(AlipayOpenPublicAccountDeleteModel alipayOpenPublicAccountDeleteModel) {
        String tenantId = alipayOpenPublicAccountDeleteModel.getTenantId();
        String branchId = alipayOpenPublicAccountDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.account.delete", JacksonUtils.writeValueAsString(alipayOpenPublicAccountDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 标签修改接口
     *
     * @param alipayOpenPublicLifeLabelModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeLabelModify(AlipayOpenPublicLifeLabelModifyModel alipayOpenPublicLifeLabelModifyModel) {
        String tenantId = alipayOpenPublicLifeLabelModifyModel.getTenantId();
        String branchId = alipayOpenPublicLifeLabelModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.label.modify", JacksonUtils.writeValueAsString(alipayOpenPublicLifeLabelModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 标签批量查询接口
     *
     * @param alipayOpenPublicLifeLabelBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeLabelBatchQuery(AlipayOpenPublicLifeLabelBatchQueryModel alipayOpenPublicLifeLabelBatchQueryModel) {
        String tenantId = alipayOpenPublicLifeLabelBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicLifeLabelBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.label.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicLifeLabelBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 用户取消标签接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMatchUserLabelDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMatchUserLabelDelete(AlipayOpenPublicMatchUserLabelDeleteModel alipayOpenPublicMatchUserLabelDeleteModel) {
        String tenantId = alipayOpenPublicMatchUserLabelDeleteModel.getTenantId();
        String branchId = alipayOpenPublicMatchUserLabelDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.matchuser.label.delete", JacksonUtils.writeValueAsString(alipayOpenPublicMatchUserLabelDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 菜单列表查询接口
     *
     * @param alipayOpenPublicMenuBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMenuBatchQuery(AlipayOpenPublicMenuBatchQueryModel alipayOpenPublicMenuBatchQueryModel) {
        String tenantId = alipayOpenPublicMenuBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicMenuBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.menu.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicMenuBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 个性化菜单删除
     *
     * @param alipayOpenPublicPersonalizedMenuDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedMenuDelete(AlipayOpenPublicPersonalizedMenuDeleteModel alipayOpenPublicPersonalizedMenuDeleteModel) {
        String tenantId = alipayOpenPublicPersonalizedMenuDeleteModel.getTenantId();
        String branchId = alipayOpenPublicPersonalizedMenuDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.personalized.menu.delete", JacksonUtils.writeValueAsString(alipayOpenPublicPersonalizedMenuDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 扩展区删除接口
     *
     * @param alipayOpenPublicPersonalizedExtensionDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedExtensionDelete(AlipayOpenPublicPersonalizedExtensionDeleteModel alipayOpenPublicPersonalizedExtensionDeleteModel) {
        String tenantId = alipayOpenPublicPersonalizedExtensionDeleteModel.getTenantId();
        String branchId = alipayOpenPublicPersonalizedExtensionDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.personalized.extension.delete", JacksonUtils.writeValueAsString(alipayOpenPublicPersonalizedExtensionDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 创建标签接口
     *
     * @param alipayOpenPublicLifeLabelCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeLabelCreate(AlipayOpenPublicLifeLabelCreateModel alipayOpenPublicLifeLabelCreateModel) {
        String tenantId = alipayOpenPublicLifeLabelCreateModel.getTenantId();
        String branchId = alipayOpenPublicLifeLabelCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.label.create", JacksonUtils.writeValueAsString(alipayOpenPublicLifeLabelCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 添加绑定商户会员号
     *
     * @param alipayOpenPublicAccountCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAccountCreate(AlipayOpenPublicAccountCreateModel alipayOpenPublicAccountCreateModel) {
        String tenantId = alipayOpenPublicAccountCreateModel.getTenantId();
        String branchId = alipayOpenPublicAccountCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.account.create", JacksonUtils.writeValueAsString(alipayOpenPublicAccountCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 服务窗短链自主生成接口
     *
     * @param alipayOpenPublicShortLinkCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicShortLinkCreate(AlipayOpenPublicShortLinkCreateModel alipayOpenPublicShortLinkCreateModel) {
        String tenantId = alipayOpenPublicShortLinkCreateModel.getTenantId();
        String branchId = alipayOpenPublicShortLinkCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.shortlink.create", JacksonUtils.writeValueAsString(alipayOpenPublicShortLinkCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 用户打标接口
     *
     * @param alipayOpenPublicMatchUserLabelCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMatchUserLabelCreate(AlipayOpenPublicMatchUserLabelCreateModel alipayOpenPublicMatchUserLabelCreateModel) {
        String tenantId = alipayOpenPublicMatchUserLabelCreateModel.getTenantId();
        String branchId = alipayOpenPublicMatchUserLabelCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.matchuser.label.create", JacksonUtils.writeValueAsString(alipayOpenPublicMatchUserLabelCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 群发消息
     *
     * @param alipayOpenPublicMessageTotalSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageTotalSend(AlipayOpenPublicMessageTotalSendModel alipayOpenPublicMessageTotalSendModel) {
        String tenantId = alipayOpenPublicMessageTotalSendModel.getTenantId();
        String branchId = alipayOpenPublicMessageTotalSendModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.message.total.send", JacksonUtils.writeValueAsString(alipayOpenPublicMessageTotalSendModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 异步单发消息
     *
     * @param alipayOpenPublicMessageCustomSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageCustomSend(AlipayOpenPublicMessageCustomSendModel alipayOpenPublicMessageCustomSendModel) {
        String tenantId = alipayOpenPublicMessageCustomSendModel.getTenantId();
        String branchId = alipayOpenPublicMessageCustomSendModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.message.custom.send", JacksonUtils.writeValueAsString(alipayOpenPublicMessageCustomSendModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 默认菜单更新接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMenuModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMenuModify(AlipayOpenPublicMenuModifyModel alipayOpenPublicMenuModifyModel) {
        String tenantId = alipayOpenPublicMenuModifyModel.getTenantId();
        String branchId = alipayOpenPublicMenuModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.message.custom.send", JacksonUtils.writeValueAsString(alipayOpenPublicMenuModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 个性化菜单创建
     * TODO: model 未实现
     *
     * @param alipayOpenPublicPersonalizedMenuCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedMenuCreate(AlipayOpenPublicPersonalizedMenuCreateModel alipayOpenPublicPersonalizedMenuCreateModel) {
        String tenantId = alipayOpenPublicPersonalizedMenuCreateModel.getTenantId();
        String branchId = alipayOpenPublicPersonalizedMenuCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.personalized.menu.create", JacksonUtils.writeValueAsString(alipayOpenPublicPersonalizedMenuCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 默认菜单创建接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMenuCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMenuCreate(AlipayOpenPublicMenuCreateModel alipayOpenPublicMenuCreateModel) {
        String tenantId = alipayOpenPublicMenuCreateModel.getTenantId();
        String branchId = alipayOpenPublicMenuCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.menu.create", JacksonUtils.writeValueAsString(alipayOpenPublicMenuCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 个性化扩展区创建接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicPersonalizedExtensionCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedExtensionCreate(AlipayOpenPublicPersonalizedExtensionCreateModel alipayOpenPublicPersonalizedExtensionCreateModel) {
        String tenantId = alipayOpenPublicPersonalizedExtensionCreateModel.getTenantId();
        String branchId = alipayOpenPublicPersonalizedExtensionCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.personalized.extension.create", JacksonUtils.writeValueAsString(alipayOpenPublicPersonalizedExtensionCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 查询用户分组列表
     *
     * @param alipayOpenPublicGroupBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupBatchQuery(AlipayOpenPublicGroupBatchQueryModel alipayOpenPublicGroupBatchQueryModel) {
        String tenantId = alipayOpenPublicGroupBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicGroupBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.group.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicGroupBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 用户分组修改接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicGroupModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupModify(AlipayOpenPublicGroupModifyModel alipayOpenPublicGroupModifyModel) {
        String tenantId = alipayOpenPublicGroupModifyModel.getTenantId();
        String branchId = alipayOpenPublicGroupModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.group.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicGroupModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 用户分组删除接口
     *
     * @param alipayOpenPublicGroupDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupDelete(AlipayOpenPublicGroupDeleteModel alipayOpenPublicGroupDeleteModel) {
        String tenantId = alipayOpenPublicGroupDeleteModel.getTenantId();
        String branchId = alipayOpenPublicGroupDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.group.delete", JacksonUtils.writeValueAsString(alipayOpenPublicGroupDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 分组消息发送接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMessageGroupSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageGroupSend(AlipayOpenPublicMessageGroupSendModel alipayOpenPublicMessageGroupSendModel) {
        String tenantId = alipayOpenPublicMessageGroupSendModel.getTenantId();
        String branchId = alipayOpenPublicMessageGroupSendModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.message.group.send", JacksonUtils.writeValueAsString(alipayOpenPublicMessageGroupSendModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 用户分组创建接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicGroupCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupCreate(AlipayOpenPublicGroupCreateModel alipayOpenPublicGroupCreateModel) {
        String tenantId = alipayOpenPublicGroupCreateModel.getTenantId();
        String branchId = alipayOpenPublicGroupCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.group.create", JacksonUtils.writeValueAsString(alipayOpenPublicGroupCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 人群数量查询
     * TODO: model 未实现
     *
     * @param alipayOpenPublicGroupCrowdQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupCrowdQuery(AlipayOpenPublicGroupCrowdQueryModel alipayOpenPublicGroupCrowdQueryModel) {
        String tenantId = alipayOpenPublicGroupCrowdQueryModel.getTenantId();
        String branchId = alipayOpenPublicGroupCrowdQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.group.crowd.query", JacksonUtils.writeValueAsString(alipayOpenPublicGroupCrowdQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 扩展区批量查询接口
     *
     * @param alipayOpenPublicPersonalizedExtensionBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedExtensionBatchQuery(AlipayOpenPublicPersonalizedExtensionBatchQueryModel alipayOpenPublicPersonalizedExtensionBatchQueryModel) {
        String tenantId = alipayOpenPublicPersonalizedExtensionBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicPersonalizedExtensionBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.personalized.extension.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicPersonalizedExtensionBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 默认扩展区创建接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicDefaultExtensionCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicDefaultExtensionCreate(AlipayOpenPublicDefaultExtensionCreateModel alipayOpenPublicDefaultExtensionCreateModel) {
        String tenantId = alipayOpenPublicDefaultExtensionCreateModel.getTenantId();
        String branchId = alipayOpenPublicDefaultExtensionCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.default.extension.create", JacksonUtils.writeValueAsString(alipayOpenPublicDefaultExtensionCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 标签删除接口
     *
     * @param alipayOpenPublicLifeLabelDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeLabelDelete(AlipayOpenPublicLifeLabelDeleteModel alipayOpenPublicLifeLabelDeleteModel) {
        String tenantId = alipayOpenPublicLifeLabelDeleteModel.getTenantId();
        String branchId = alipayOpenPublicLifeLabelDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.label.delete", JacksonUtils.writeValueAsString(alipayOpenPublicLifeLabelDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * isv代创建生活号申请状态查询接口
     *
     * @param alipayOpenPublicLifeAgentCreateQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeAgentCreateQuery(AlipayOpenPublicLifeAgentCreateQueryModel alipayOpenPublicLifeAgentCreateQueryModel) {
        String tenantId = alipayOpenPublicLifeAgentCreateQueryModel.getTenantId();
        String branchId = alipayOpenPublicLifeAgentCreateQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.agentcreate.query", JacksonUtils.writeValueAsString(alipayOpenPublicLifeAgentCreateQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 下架生活号
     *
     * @param alipayOpenPublicLifeDebarkApplyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeDebarkApply(AlipayOpenPublicLifeDebarkApplyModel alipayOpenPublicLifeDebarkApplyModel) {
        String tenantId = alipayOpenPublicLifeDebarkApplyModel.getTenantId();
        String branchId = alipayOpenPublicLifeDebarkApplyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.debark.apply", JacksonUtils.writeValueAsString(alipayOpenPublicLifeDebarkApplyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 上架生活号
     *
     * @param alipayOpenPublicLifeAboardApplyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeAboardApply(AlipayOpenPublicLifeAboardApplyModel alipayOpenPublicLifeAboardApplyModel) {
        String tenantId = alipayOpenPublicLifeAboardApplyModel.getTenantId();
        String branchId = alipayOpenPublicLifeAboardApplyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.aboard.apply", JacksonUtils.writeValueAsString(alipayOpenPublicLifeAboardApplyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号查询行业设置接口
     *
     * @param alipayOpenPublicSettingCategoryQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicSettingCategoryQuery(AlipayOpenPublicSettingCategoryQueryModel alipayOpenPublicSettingCategoryQueryModel) {
        String tenantId = alipayOpenPublicSettingCategoryQueryModel.getTenantId();
        String branchId = alipayOpenPublicSettingCategoryQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.setting.category.query", JacksonUtils.writeValueAsString(alipayOpenPublicSettingCategoryQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号查询已发送消息接口
     *
     * @param alipayOpenPublicMessageQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageQuery(AlipayOpenPublicMessageQueryModel alipayOpenPublicMessageQueryModel) {
        String tenantId = alipayOpenPublicMessageQueryModel.getTenantId();
        String branchId = alipayOpenPublicMessageQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.message.query", JacksonUtils.writeValueAsString(alipayOpenPublicMessageQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号消息撤回接口
     *
     * @param alipayOpenPublicLifeMsgRecallModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeMsgRecall(AlipayOpenPublicLifeMsgRecallModel alipayOpenPublicLifeMsgRecallModel) {
        String tenantId = alipayOpenPublicLifeMsgRecallModel.getTenantId();
        String branchId = alipayOpenPublicLifeMsgRecallModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.msg.recall", JacksonUtils.writeValueAsString(alipayOpenPublicLifeMsgRecallModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号基础信息查询接口
     *
     * @param tenantId
     * @param branchId
     * @return
     */
    public static Map<String, Object> alipayOpenPublicInfoQuery(String tenantId, String branchId) {
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.info.query", "{}");
    }

    /**
     * isv代创建生活号接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicLifeAgentCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeAgentCreate(AlipayOpenPublicLifeAgentCreateModel alipayOpenPublicLifeAgentCreateModel) {
        String tenantId = alipayOpenPublicLifeAgentCreateModel.getTenantId();
        String branchId = alipayOpenPublicLifeAgentCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.life.agent.create", JacksonUtils.writeValueAsString(alipayOpenPublicLifeAgentCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 模板消息行业设置修改接口
     *
     * @param alipayOpenPublicTemplateMessageIndustryModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTemplateMessageIndustryModify(AlipayOpenPublicTemplateMessageIndustryModifyModel alipayOpenPublicTemplateMessageIndustryModifyModel) {
        String tenantId = alipayOpenPublicTemplateMessageIndustryModifyModel.getTenantId();
        String branchId = alipayOpenPublicTemplateMessageIndustryModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.template.message.industry.modify", JacksonUtils.writeValueAsString(alipayOpenPublicTemplateMessageIndustryModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号关注用户查询接口
     *
     * @param alipayOpenPublicUserFollowQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicUserFollowQuery(AlipayOpenPublicUserFollowQueryModel alipayOpenPublicUserFollowQueryModel) {
        String tenantId = alipayOpenPublicUserFollowQueryModel.getTenantId();
        String branchId = alipayOpenPublicUserFollowQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.user.follow.query", JacksonUtils.writeValueAsString(alipayOpenPublicUserFollowQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号广告位修改接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicAdvertModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAdvertModify(AlipayOpenPublicAdvertModifyModel alipayOpenPublicAdvertModifyModel) {
        String tenantId = alipayOpenPublicAdvertModifyModel.getTenantId();
        String branchId = alipayOpenPublicAdvertModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.advert.modify", JacksonUtils.writeValueAsString(alipayOpenPublicAdvertModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号广告位添加接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicAdvertCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAdvertCreate(AlipayOpenPublicAdvertCreateModel alipayOpenPublicAdvertCreateModel) {
        String tenantId = alipayOpenPublicAdvertCreateModel.getTenantId();
        String branchId = alipayOpenPublicAdvertCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.advert.create", JacksonUtils.writeValueAsString(alipayOpenPublicAdvertCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号广告位查询接口
     *
     * @param alipayOpenPublicAdvertBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAdvertBatchQuery(AlipayOpenPublicAdvertBatchQueryModel alipayOpenPublicAdvertBatchQueryModel) {
        String tenantId = alipayOpenPublicAdvertBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicAdvertBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.advert.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicAdvertBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号广告位删除接口
     *
     * @param alipayOpenPublicAdvertDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAdvertDelete(AlipayOpenPublicAdvertDeleteModel alipayOpenPublicAdvertDeleteModel) {
        String tenantId = alipayOpenPublicAdvertDeleteModel.getTenantId();
        String branchId = alipayOpenPublicAdvertDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.advert.delete", JacksonUtils.writeValueAsString(alipayOpenPublicAdvertDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 国开行助学贷款还款计划查询接口
     *
     * @param alipayFundStudentLoanRepayQueryModel
     * @return
     */
    public static Map<String, Object> alipayFundStudentLoanRepayQuery(AlipayFundStudentLoanRepayQueryModel alipayFundStudentLoanRepayQueryModel) {
        String tenantId = alipayFundStudentLoanRepayQueryModel.getTenantId();
        String branchId = alipayFundStudentLoanRepayQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.fund.studentloan.repay.query", JacksonUtils.writeValueAsString(alipayFundStudentLoanRepayQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 营销位添加接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicTopicCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTopicCreate(AlipayOpenPublicTopicCreateModel alipayOpenPublicTopicCreateModel) {
        String tenantId = alipayOpenPublicTopicCreateModel.getTenantId();
        String branchId = alipayOpenPublicTopicCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.topic.create", JacksonUtils.writeValueAsString(alipayOpenPublicTopicCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 营销位修改接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicTopicModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTopicModify(AlipayOpenPublicTopicModifyModel alipayOpenPublicTopicModifyModel) {
        String tenantId = alipayOpenPublicTopicModifyModel.getTenantId();
        String branchId = alipayOpenPublicTopicModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.topic.modify", JacksonUtils.writeValueAsString(alipayOpenPublicTopicModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 营销位删除接口
     *
     * @param alipayOpenPublicTopicDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTopicDelete(AlipayOpenPublicTopicDeleteModel alipayOpenPublicTopicDeleteModel) {
        String tenantId = alipayOpenPublicTopicDeleteModel.getTenantId();
        String branchId = alipayOpenPublicTopicDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.topic.delete", JacksonUtils.writeValueAsString(alipayOpenPublicTopicDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 营销位查询接口
     *
     * @param alipayOpenPublicTopicBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTopicBatchQuery(AlipayOpenPublicTopicBatchQueryModel alipayOpenPublicTopicBatchQueryModel) {
        String tenantId = alipayOpenPublicTopicBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicTopicBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.topic.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicTopicBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 图文分析-按文章查询数据接口
     *
     * @param alipayOpenPublicSingleArticleDataBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicSingleArticleDataBatchQuery(AlipayOpenPublicSingleArticleDataBatchQueryModel alipayOpenPublicSingleArticleDataBatchQueryModel) {
        String tenantId = alipayOpenPublicSingleArticleDataBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicSingleArticleDataBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.singlearticle.data.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicSingleArticleDataBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 用户分析数据查询接口
     *
     * @param alipayOpenPublicUserDataBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicUserDataBatchQuery(AlipayOpenPublicUserDataBatchQueryModel alipayOpenPublicUserDataBatchQueryModel) {
        String tenantId = alipayOpenPublicUserDataBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicUserDataBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.user.data.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicUserDataBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 图文分析-按时间查询数据接口
     *
     * @param alipayOpenPublicArticleSummaryDataBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicArticleSummaryDataBatchQuery(AlipayOpenPublicArticleSummaryDataBatchQueryModel alipayOpenPublicArticleSummaryDataBatchQueryModel) {
        String tenantId = alipayOpenPublicArticleSummaryDataBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicArticleSummaryDataBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.articlesummary.data.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicArticleSummaryDataBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 菜单分析数据查询接口
     *
     * @param alipayOpenPublicMenuDataBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMenuDataBatchQuery(AlipayOpenPublicMenuDataBatchQueryModel alipayOpenPublicMenuDataBatchQueryModel) {
        String tenantId = alipayOpenPublicMenuDataBatchQueryModel.getTenantId();
        String branchId = alipayOpenPublicMenuDataBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.menu.data.batchquery", JacksonUtils.writeValueAsString(alipayOpenPublicMenuDataBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 生活号基础信息修改接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicInfoModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicInfoModify(AlipayOpenPublicInfoModifyModel alipayOpenPublicInfoModifyModel) {
        String tenantId = alipayOpenPublicInfoModifyModel.getTenantId();
        String branchId = alipayOpenPublicInfoModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.info.modify", JacksonUtils.writeValueAsString(alipayOpenPublicInfoModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 添加收款账号接口
     * 允许开发者调用该接口将收款账号与当前生活号绑定，从而支持支付成功页引导推荐关注生活号
     *
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPayeeBindCreate(AlipayOpenPublicPayeeBindCreateModel alipayOpenPublicPayeeBindCreateModel) {
        String tenantId = alipayOpenPublicPayeeBindCreateModel.getTenantId();
        String branchId = alipayOpenPublicPayeeBindCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);

        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.payee.bind.create", JacksonUtils.writeValueAsString(alipayOpenPublicPayeeBindCreateModel));
    }

    /**
     * 解绑收款账号接口
     *
     * @param alipayOpenPublicPayeeBindDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPayeeBindDelete(AlipayOpenPublicPayeeBindDeleteModel alipayOpenPublicPayeeBindDeleteModel) {
        String tenantId = alipayOpenPublicPayeeBindDeleteModel.getTenantId();
        String branchId = alipayOpenPublicPayeeBindDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.payee.bind.delete", JacksonUtils.writeValueAsString(alipayOpenPublicPayeeBindDeleteModel));
    }


    /**
     * 创建图文消息内容接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMessageContentCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageContentCreate(AlipayOpenPublicMessageContentCreateModel alipayOpenPublicMessageContentCreateModel) {
        String tenantId = alipayOpenPublicMessageContentCreateModel.getTenantId();
        String branchId = alipayOpenPublicMessageContentCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.message.content.create", JacksonUtils.writeValueAsString(alipayOpenPublicMessageContentCreateModel));
    }

    /**
     * 更新图文消息内容接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMessageContentModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageContentModify(AlipayOpenPublicMessageContentModifyModel alipayOpenPublicMessageContentModifyModel) {
        String tenantId = alipayOpenPublicMessageContentModifyModel.getTenantId();
        String branchId = alipayOpenPublicMessageContentModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.message.content.modify", JacksonUtils.writeValueAsString(alipayOpenPublicMessageContentModifyModel));
    }

    /**
     * 缴费直连代扣签约前置校验
     * TODO: model 未实现
     *
     * @param alipayEbppPdeductSignValidateModel
     * @return
     */
    public static Map<String, Object> alipayEbppPdeductSignValidate(AlipayEbppPdeductSignValidateModel alipayEbppPdeductSignValidateModel) {
        String tenantId = alipayEbppPdeductSignValidateModel.getTenantId();
        String branchId = alipayEbppPdeductSignValidateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.ebpp.pdeduct.sign.validate", JacksonUtils.writeValueAsString(alipayEbppPdeductSignValidateModel, JsonInclude.Include.NON_NULL));
    }

    /***************************************************************会员API开始***************************************************************/

    /**
     * 支付宝会员授权信息查询接口
     *
     * @param alipayUserInfoShareModel
     * @return
     */
    public static Map<String, Object> alipayUserInfoShare(AlipayUserInfoShareModel alipayUserInfoShareModel) {
        String tenantId = alipayUserInfoShareModel.getTenantId();
        String branchId = alipayUserInfoShareModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.user.info.share", JacksonUtils.writeValueAsString(alipayUserInfoShareModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 芝麻企业征信基于身份的协议授权
     *
     * @param alipayUserAuthZhiMaOrgIdentityApplyModel
     * @return
     */
    public static Map<String, Object> alipayUserAuthZhiMaOrgIdentityApply(AlipayUserAuthZhiMaOrgIdentityApplyModel alipayUserAuthZhiMaOrgIdentityApplyModel) {
        String tenantId = alipayUserAuthZhiMaOrgIdentityApplyModel.getTenantId();
        String branchId = alipayUserAuthZhiMaOrgIdentityApplyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.user.auth.zhimaorg.identity.apply", JacksonUtils.writeValueAsString(alipayUserAuthZhiMaOrgIdentityApplyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 查询是否在支付宝公益捐赠的接口
     *
     * @param alipayUserCharityRecordExistQueryModel
     * @return
     */
    public static Map<String, Object> alipayUserCharityRecordExistQuery(AlipayUserCharityRecordExistQueryModel alipayUserCharityRecordExistQueryModel) {
        String tenantId = alipayUserCharityRecordExistQueryModel.getTenantId();
        String branchId = alipayUserCharityRecordExistQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.user.charity.recordexist.query", JacksonUtils.writeValueAsString(alipayUserCharityRecordExistQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 身份认证记录查询
     *
     * @param alipayUserCertifyOpenQueryModel
     * @return
     */
    public static Map<String, Object> alipayUserCertifyOpenQuery(AlipayUserCertifyOpenQueryModel alipayUserCertifyOpenQueryModel) {
        String tenantId = alipayUserCertifyOpenQueryModel.getTenantId();
        String branchId = alipayUserCertifyOpenQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.user.certify.open.query", JacksonUtils.writeValueAsString(alipayUserCertifyOpenQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 身份认证初始化服务
     * TODO: model 未实现
     *
     * @param alipayUserCertifyOpenInitializeModel
     * @return
     */
    public static Map<String, Object> alipayUserCertifyOpenInitialize(AlipayUserCertifyOpenInitializeModel alipayUserCertifyOpenInitializeModel) {
        String tenantId = alipayUserCertifyOpenInitializeModel.getTenantId();
        String branchId = alipayUserCertifyOpenInitializeModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.user.certify.open.initialize", JacksonUtils.writeValueAsString(alipayUserCertifyOpenInitializeModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 身份认证开始认证
     *
     * @param alipayUserCertifyOpenCertifyModel
     * @return
     */
    public static Map<String, Object> alipayUserCertifyOpenCertify(AlipayUserCertifyOpenCertifyModel alipayUserCertifyOpenCertifyModel) {
        String tenantId = alipayUserCertifyOpenCertifyModel.getTenantId();
        String branchId = alipayUserCertifyOpenCertifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.user.certify.open.certify", JacksonUtils.writeValueAsString(alipayUserCertifyOpenCertifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 通用当面付二阶段接口
     *
     * @param alipayUserTwoStageCommonUseModel
     * @return
     */
    public static Map<String, Object> alipayUserTwoStageCommonUse(AlipayUserTwoStageCommonUseModel alipayUserTwoStageCommonUseModel) {
        alipayUserTwoStageCommonUseModel.validateAndThrow();

        String tenantId = alipayUserTwoStageCommonUseModel.getTenantId();
        String branchId = alipayUserTwoStageCommonUseModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.user.twostage.common.use", JacksonUtils.writeValueAsString(alipayUserTwoStageCommonUseModel, JsonInclude.Include.NON_NULL));
    }
    /***************************************************************会员API结束***************************************************************/

    /***************************************************************商户会员卡API开始***************************************************************/
    /**
     * 上传门店照片和视频接口
     *
     * @param alipayOfflineMaterialImageUploadModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMaterialImageUpload(AlipayOfflineMaterialImageUploadModel alipayOfflineMaterialImageUploadModel) {
        alipayOfflineMaterialImageUploadModel.validateAndThrow();
        String tenantId = alipayOfflineMaterialImageUploadModel.getTenantId();
        String branchId = alipayOfflineMaterialImageUploadModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.material.image.upload", JacksonUtils.writeValueAsString(alipayOfflineMaterialImageUploadModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡模板创建
     *
     * @param alipayMarketingCardTemplateCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardTemplateCreate(AlipayMarketingCardTemplateCreateModel alipayMarketingCardTemplateCreateModel) {
        alipayMarketingCardTemplateCreateModel.validateAndThrow();
        String tenantId = alipayMarketingCardTemplateCreateModel.getTenantId();
        String branchId = alipayMarketingCardTemplateCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.template.create", JacksonUtils.writeValueAsString(alipayMarketingCardTemplateCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡模板修改
     * TODO: model 未实现
     *
     * @param alipayMarketingCardTemplateModifyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardTemplateModify(AlipayMarketingCardTemplateModifyModel alipayMarketingCardTemplateModifyModel) {
        alipayMarketingCardTemplateModifyModel.validateAndThrow();
        String tenantId = alipayMarketingCardTemplateModifyModel.getTenantId();
        String branchId = alipayMarketingCardTemplateModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.template.modify", JacksonUtils.writeValueAsString(alipayMarketingCardTemplateModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡模板查询接口
     * TODO: model 未实现
     *
     * @param alipayMarketingCardTemplateQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardTemplateQuery(AlipayMarketingCardTemplateQueryModel alipayMarketingCardTemplateQueryModel) {
        alipayMarketingCardTemplateQueryModel.validateAndThrow();
        String tenantId = alipayMarketingCardTemplateQueryModel.getTenantId();
        String branchId = alipayMarketingCardTemplateQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.template.query", JacksonUtils.writeValueAsString(alipayMarketingCardTemplateQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡开卡表单模板配置
     * TODO: model 未实现
     *
     * @param alipayMarketingCardFormTemplateSetModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardFormTemplateSet(AlipayMarketingCardFormTemplateSetModel alipayMarketingCardFormTemplateSetModel) {
        alipayMarketingCardFormTemplateSetModel.validateAndThrow();
        String tenantId = alipayMarketingCardFormTemplateSetModel.getTenantId();
        String branchId = alipayMarketingCardFormTemplateSetModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.formtemplate.set", JacksonUtils.writeValueAsString(alipayMarketingCardFormTemplateSetModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 获取会员卡领卡投放链接
     * TODO: model 未实现
     *
     * @param alipayMarketingCardActivateUrlApplyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardActivateUrlApply(AlipayMarketingCardActivateUrlApplyModel alipayMarketingCardActivateUrlApplyModel) {
        alipayMarketingCardActivateUrlApplyModel.validateAndThrow();
        String tenantId = alipayMarketingCardActivateUrlApplyModel.getTenantId();
        String branchId = alipayMarketingCardActivateUrlApplyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.activateurl.apply", JacksonUtils.writeValueAsString(alipayMarketingCardActivateUrlApplyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 查询用户提交的会员卡表单信息
     * TODO: model 未实现
     *
     * @param alipayMarketingCardActivateFormQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardActivateFormQuery(AlipayMarketingCardActivateFormQueryModel alipayMarketingCardActivateFormQueryModel) {
        alipayMarketingCardActivateFormQueryModel.validateAndThrow();
        String tenantId = alipayMarketingCardActivateFormQueryModel.getTenantId();
        String branchId = alipayMarketingCardActivateFormQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.activateform.query", JacksonUtils.writeValueAsString(alipayMarketingCardActivateFormQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡开卡
     * TODO: model 未实现
     *
     * @param alipayMarketingCardOpenModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardOpen(AlipayMarketingCardOpenModel alipayMarketingCardOpenModel) {
        alipayMarketingCardOpenModel.validateAndThrow();
        String tenantId = alipayMarketingCardOpenModel.getTenantId();
        String branchId = alipayMarketingCardOpenModel.getBranchId();
        String authToken = alipayMarketingCardOpenModel.getAuthToken();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.open", null, null, authToken, JacksonUtils.writeValueAsString(alipayMarketingCardOpenModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡更新
     * TODO: model 未实现
     *
     * @param alipayMarketingCardUpdateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardUpdate(AlipayMarketingCardUpdateModel alipayMarketingCardUpdateModel) {
        alipayMarketingCardUpdateModel.validateAndThrow();
        String tenantId = alipayMarketingCardUpdateModel.getTenantId();
        String branchId = alipayMarketingCardUpdateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.update", JacksonUtils.writeValueAsString(alipayMarketingCardUpdateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡删卡
     *
     * @param alipayMarketingCardDeleteModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardDelete(AlipayMarketingCardDeleteModel alipayMarketingCardDeleteModel) {
        alipayMarketingCardDeleteModel.validateAndThrow();
        String tenantId = alipayMarketingCardDeleteModel.getTenantId();
        String branchId = alipayMarketingCardDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.delete", JacksonUtils.writeValueAsString(alipayMarketingCardDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡查询
     * TODO: model 未实现
     *
     * @param alipayMarketingCardQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardQuery(AlipayMarketingCardQueryModel alipayMarketingCardQueryModel) {
        alipayMarketingCardQueryModel.validateAndThrow();
        String tenantId = alipayMarketingCardQueryModel.getTenantId();
        String branchId = alipayMarketingCardQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.query", JacksonUtils.writeValueAsString(alipayMarketingCardQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡模板外部权益修改
     * TODO: model 未实现
     *
     * @param alipayMarketingCardBenefitModifyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardBenefitModify(AlipayMarketingCardBenefitModifyModel alipayMarketingCardBenefitModifyModel) {
        alipayMarketingCardBenefitModifyModel.validateAndThrow();
        String tenantId = alipayMarketingCardBenefitModifyModel.getTenantId();
        String branchId = alipayMarketingCardBenefitModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.benefit.modify", JacksonUtils.writeValueAsString(alipayMarketingCardBenefitModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡模板外部权益删除
     * TODO: model 未实现
     *
     * @param alipayMarketingCardBenefitDeleteModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardBenefitDelete(AlipayMarketingCardBenefitDeleteModel alipayMarketingCardBenefitDeleteModel) {
        alipayMarketingCardBenefitDeleteModel.validateAndThrow();
        String tenantId = alipayMarketingCardBenefitDeleteModel.getTenantId();
        String branchId = alipayMarketingCardBenefitDeleteModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.benefit.delete", JacksonUtils.writeValueAsString(alipayMarketingCardBenefitDeleteModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡模板外部权益创建
     * TODO: model 未实现
     *
     * @param alipayMarketingCardBenefitCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardBenefitCreate(AlipayMarketingCardBenefitCreateModel alipayMarketingCardBenefitCreateModel) {
        alipayMarketingCardBenefitCreateModel.validateAndThrow();
        String tenantId = alipayMarketingCardBenefitCreateModel.getTenantId();
        String branchId = alipayMarketingCardBenefitCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.benefit.create", JacksonUtils.writeValueAsString(alipayMarketingCardBenefitCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡模板外部权益查询
     * TODO: model 未实现
     *
     * @param alipayMarketingCardBenefitQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardBenefitQuery(AlipayMarketingCardBenefitQueryModel alipayMarketingCardBenefitQueryModel) {
        alipayMarketingCardBenefitQueryModel.validateAndThrow();
        String tenantId = alipayMarketingCardBenefitQueryModel.getTenantId();
        String branchId = alipayMarketingCardBenefitQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.benefit.query", JacksonUtils.writeValueAsString(alipayMarketingCardBenefitQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 会员卡模板批量查询
     * TODO: model 未实现
     *
     * @param alipayMarketingCardTemplateBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardTemplateBatchQuery(AlipayMarketingCardTemplateBatchQueryModel alipayMarketingCardTemplateBatchQueryModel) {
        alipayMarketingCardTemplateBatchQueryModel.validateAndThrow();
        String tenantId = alipayMarketingCardTemplateBatchQueryModel.getTenantId();
        String branchId = alipayMarketingCardTemplateBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.marketing.card.template.batchquery", JacksonUtils.writeValueAsString(alipayMarketingCardTemplateBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 活动创建接口
     * TODO: model 未实现
     *
     * @param koubeiMarketingCampaignActivityCreateModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignActivityCreate(KoubeiMarketingCampaignActivityCreateModel koubeiMarketingCampaignActivityCreateModel) {
        koubeiMarketingCampaignActivityCreateModel.validateAndThrow();
        String tenantId = koubeiMarketingCampaignActivityCreateModel.getTenantId();
        String branchId = koubeiMarketingCampaignActivityCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.marketing.campaign.activity.create", JacksonUtils.writeValueAsString(koubeiMarketingCampaignActivityCreateModel, JsonInclude.Include.NON_NULL));
    }
    /***************************************************************商户会员卡API结束***************************************************************/

    /***************************************************************店铺API开始***************************************************************/
    /**
     * 创建门店信息
     * TODO: 未实现Builder模式
     *
     * @param alipayOfflineMarketShopCreateModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopCreate(AlipayOfflineMarketShopCreateModel alipayOfflineMarketShopCreateModel) {
        alipayOfflineMarketShopCreateModel.validateAndThrow();
        String tenantId = alipayOfflineMarketShopCreateModel.getTenantId();
        String branchId = alipayOfflineMarketShopCreateModel.getBranchId();
        String notifyUrl = alipayOfflineMarketShopCreateModel.getNotifyUrl();

        AlipayAuthorizerInfo alipayAuthorizerInfo = null;
        if (StringUtils.isNotBlank(notifyUrl)) {
            alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayOfflineMarketShopCreateModel.getStoreId(), notifyUrl);
        } else {
            alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        }
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.shop.create", NotifyUtils.obtainAlipayNotifyUrl(), JacksonUtils.writeValueAsString(alipayOfflineMarketShopCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 门店类目配置查询接口
     *
     * @param alipayOfflineMarketShopCategoryQueryModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopCategoryQuery(AlipayOfflineMarketShopCategoryQueryModel alipayOfflineMarketShopCategoryQueryModel) {
        alipayOfflineMarketShopCategoryQueryModel.validateAndThrow();
        String tenantId = alipayOfflineMarketShopCategoryQueryModel.getTenantId();
        String branchId = alipayOfflineMarketShopCategoryQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.shop.category.query", JacksonUtils.writeValueAsString(alipayOfflineMarketShopCategoryQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 修改门店信息
     * TODO: model 未实现
     *
     * @param alipayOfflineMarketShopModifyModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopModify(AlipayOfflineMarketShopModifyModel alipayOfflineMarketShopModifyModel) {
        alipayOfflineMarketShopModifyModel.validateAndThrow();
        String tenantId = alipayOfflineMarketShopModifyModel.getTenantId();
        String branchId = alipayOfflineMarketShopModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.shop.modify", JacksonUtils.writeValueAsString(alipayOfflineMarketShopModifyModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 查询单个门店信息接口
     *
     * @param alipayOfflineMarketShopQueryDetailModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopQueryDetail(AlipayOfflineMarketShopQueryDetailModel alipayOfflineMarketShopQueryDetailModel) {
        alipayOfflineMarketShopQueryDetailModel.validateAndThrow();
        String tenantId = alipayOfflineMarketShopQueryDetailModel.getTenantId();
        String branchId = alipayOfflineMarketShopQueryDetailModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.shop.querydetail", JacksonUtils.writeValueAsString(alipayOfflineMarketShopQueryDetailModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 查询商户的门店编号列表
     *
     * @param alipayOfflineMarketShopBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopBatchQuery(AlipayOfflineMarketShopBatchQueryModel alipayOfflineMarketShopBatchQueryModel) {
        alipayOfflineMarketShopBatchQueryModel.validateAndThrow();
        String tenantId = alipayOfflineMarketShopBatchQueryModel.getTenantId();
        String branchId = alipayOfflineMarketShopBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.shop.batchquery", JacksonUtils.writeValueAsString(alipayOfflineMarketShopBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 门店摘要信息批量查询接口
     * TODO: model 未实现
     *
     * @param alipayOfflineMarketShopSummaryBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopSummaryBatchQuery(AlipayOfflineMarketShopSummaryBatchQueryModel alipayOfflineMarketShopSummaryBatchQueryModel) {
        alipayOfflineMarketShopSummaryBatchQueryModel.validateAndThrow();
        String tenantId = alipayOfflineMarketShopSummaryBatchQueryModel.getTenantId();
        String branchId = alipayOfflineMarketShopSummaryBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.shop.summary.batchquery", JacksonUtils.writeValueAsString(alipayOfflineMarketShopSummaryBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 业务流水批量查询接口
     * TODO: model 未实现
     *
     * @param alipayOfflineMarketApplyOrderBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketApplyOrderBatchQuery(AlipayOfflineMarketApplyOrderBatchQueryModel alipayOfflineMarketApplyOrderBatchQueryModel) {
        alipayOfflineMarketApplyOrderBatchQueryModel.validateAndThrow();
        String tenantId = alipayOfflineMarketApplyOrderBatchQueryModel.getTenantId();
        String branchId = alipayOfflineMarketApplyOrderBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.applyorder.batchquery", JacksonUtils.writeValueAsString(alipayOfflineMarketApplyOrderBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /***************************************************************店铺API结束***************************************************************/

    /***************************************************************第三方API开始***************************************************************/
    /**
     * 代商家创建小程序应用
     * TODO: model 未实现
     *
     * @param alipayOpenAgentMiniCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentMiniCreate(AlipayOpenAgentMiniCreateModel alipayOpenAgentMiniCreateModel) {
        alipayOpenAgentMiniCreateModel.validateAndThrow();
        String tenantId = alipayOpenAgentMiniCreateModel.getTenantId();
        String branchId = alipayOpenAgentMiniCreateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.mini.create", JacksonUtils.writeValueAsString(alipayOpenAgentMiniCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 代签约APP支付产品
     * TODO: model 未实现
     *
     * @param alipayOpenAgentMobilePaySignModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentMobilePaySign(AlipayOpenAgentMobilePaySignModel alipayOpenAgentMobilePaySignModel) {
        alipayOpenAgentMobilePaySignModel.validateAndThrow();
        String tenantId = alipayOpenAgentMobilePaySignModel.getTenantId();
        String branchId = alipayOpenAgentMobilePaySignModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.mobilepay.sign", JacksonUtils.writeValueAsString(alipayOpenAgentMobilePaySignModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 代签约当面付产品
     * TODO: model 未实现
     *
     * @param alipayOpenAgentFaceToFaceSignModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentFaceToFaceSign(AlipayOpenAgentFaceToFaceSignModel alipayOpenAgentFaceToFaceSignModel) {
        alipayOpenAgentFaceToFaceSignModel.validateAndThrow();
        String tenantId = alipayOpenAgentFaceToFaceSignModel.getTenantId();
        String branchId = alipayOpenAgentFaceToFaceSignModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.facetoface.sign", JacksonUtils.writeValueAsString(alipayOpenAgentFaceToFaceSignModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 代签约芝麻信用（普惠版）产品
     * TODO: model 未实现
     *
     * @param alipayOpenAgentZhiMaBriefSignModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentZhiMaBriefSign(AlipayOpenAgentZhiMaBriefSignModel alipayOpenAgentZhiMaBriefSignModel) {
        alipayOpenAgentZhiMaBriefSignModel.validateAndThrow();
        String tenantId = alipayOpenAgentZhiMaBriefSignModel.getTenantId();
        String branchId = alipayOpenAgentZhiMaBriefSignModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.zhimabrief.sign", JacksonUtils.writeValueAsString(alipayOpenAgentZhiMaBriefSignModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 开启代商户签约、创建应用事务
     *
     * @param alipayOpenAgentCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentCreate(AlipayOpenAgentCreateModel alipayOpenAgentCreateModel) {
        alipayOpenAgentCreateModel.validateAndThrow();
        String tenantId = alipayOpenAgentCreateModel.getTenantId();
        String branchId = alipayOpenAgentCreateModel.getBranchId();
        AlipayOpenAgentCreateModel.ContactInfo contactInfo = alipayOpenAgentCreateModel.getContactInfo();
        String orderTicket = alipayOpenAgentCreateModel.getOrderTicket();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);

        AlipayAccount alipayAccount = obtainAlipayAccount(alipayAuthorizerInfo.getAppId());
        Map<String, Object> bizContentMap = new HashMap<String, Object>();
        bizContentMap.put("account", alipayAccount.getAccount());
        bizContentMap.put("contact_info", contactInfo);
        if (StringUtils.isNotBlank(orderTicket)) {
            bizContentMap.put("order_ticket", orderTicket);
        }

        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.create", JacksonUtils.writeValueAsString(alipayOpenAgentCreateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 提交代商户签约、创建应用事务
     *
     * @param alipayOpenAgentConfirmModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentConfirm(AlipayOpenAgentConfirmModel alipayOpenAgentConfirmModel) {
        alipayOpenAgentConfirmModel.validateAndThrow();
        String tenantId = alipayOpenAgentConfirmModel.getTenantId();
        String branchId = alipayOpenAgentConfirmModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.confirm", JacksonUtils.writeValueAsString(alipayOpenAgentConfirmModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 取消代商户签约、创建应用事务
     *
     * @param alipayOpenAgentCancelModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentCancel(AlipayOpenAgentCancelModel alipayOpenAgentCancelModel) {
        alipayOpenAgentCancelModel.validateAndThrow();
        String tenantId = alipayOpenAgentCancelModel.getTenantId();
        String branchId = alipayOpenAgentCancelModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.cancel", JacksonUtils.writeValueAsString(alipayOpenAgentCancelModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 查询申请单状态
     *
     * @param alipayOpenAgentOrderQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentOrderQuery(AlipayOpenAgentOrderQueryModel alipayOpenAgentOrderQueryModel) {
        alipayOpenAgentOrderQueryModel.validateAndThrow();
        String tenantId = alipayOpenAgentOrderQueryModel.getTenantId();
        String branchId = alipayOpenAgentOrderQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.order.query", JacksonUtils.writeValueAsString(alipayOpenAgentOrderQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 查询商户某个产品的签约状态
     *
     * @param alipayOpenAgentSignStatusQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentSignStatusQuery(AlipayOpenAgentSignStatusQueryModel alipayOpenAgentSignStatusQueryModel) {
        alipayOpenAgentSignStatusQueryModel.validateAndThrow();
        String tenantId = alipayOpenAgentSignStatusQueryModel.getTenantId();
        String branchId = alipayOpenAgentSignStatusQueryModel.getBranchId();
        List<String> productCodes = alipayOpenAgentSignStatusQueryModel.getProductCodes();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);

        Map<String, Object> bizContentMap = new HashMap<String, Object>();
        bizContentMap.put("pid", alipayAuthorizerInfo.getUserId());
        bizContentMap.put("product_codes", productCodes);

        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.signstatus.query", JacksonUtils.writeValueAsString(bizContentMap));
    }

    /**
     * 代签约线下收钱产品
     * TODO: model 未实现完
     *
     * @param alipayOpenAgentOfflinePaymentSignModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentOfflinePaymentSign(AlipayOpenAgentOfflinePaymentSignModel alipayOpenAgentOfflinePaymentSignModel) {
        alipayOpenAgentOfflinePaymentSignModel.validateAndThrow();
        String tenantId = alipayOpenAgentOfflinePaymentSignModel.getTenantId();
        String branchId = alipayOpenAgentOfflinePaymentSignModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.agent.offlinepayment.sign", JacksonUtils.writeValueAsString(alipayOpenAgentOfflinePaymentSignModel, JsonInclude.Include.NON_NULL));
    }
    /***************************************************************第三方API结束***************************************************************/

    /***************************************************************卡劵API开始***************************************************************/
    /**
     * 支付宝pass更新卡券实例接口
     *
     * @param alipayPassInstanceUpdateModel
     * @return
     */
    public static Map<String, Object> alipayPassInstanceUpdate(AlipayPassInstanceUpdateModel alipayPassInstanceUpdateModel) {
        alipayPassInstanceUpdateModel.validateAndThrow();
        String tenantId = alipayPassInstanceUpdateModel.getTenantId();
        String branchId = alipayPassInstanceUpdateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.pass.instance.update", JacksonUtils.writeValueAsString(alipayPassInstanceUpdateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 更新卡集点
     *
     * @param koubeiMarketingToolPointsUpdateModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingToolPointsUpdate(KoubeiMarketingToolPointsUpdateModel koubeiMarketingToolPointsUpdateModel) {
        koubeiMarketingToolPointsUpdateModel.validateAndThrow();
        String tenantId = koubeiMarketingToolPointsUpdateModel.getTenantId();
        String branchId = koubeiMarketingToolPointsUpdateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.marketing.tool.points.update", JacksonUtils.writeValueAsString(koubeiMarketingToolPointsUpdateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 卡券模板创建
     *
     * @param alipayPassTemplateAddModel
     * @return
     */
    public static Map<String, Object> alipayPassTemplateAdd(AlipayPassTemplateAddModel alipayPassTemplateAddModel) {
        alipayPassTemplateAddModel.validateAndThrow();
        String tenantId = alipayPassTemplateAddModel.getTenantId();
        String branchId = alipayPassTemplateAddModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.pass.template.add", JacksonUtils.writeValueAsString(alipayPassTemplateAddModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 支付宝pass更新模版接口
     *
     * @param alipayPassTemplateUpdateModel
     * @return
     */
    public static Map<String, Object> alipayPassTemplateUpdate(AlipayPassTemplateUpdateModel alipayPassTemplateUpdateModel) {
        alipayPassTemplateUpdateModel.validateAndThrow();
        String tenantId = alipayPassTemplateUpdateModel.getTenantId();
        String branchId = alipayPassTemplateUpdateModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.pass.template.update", JacksonUtils.writeValueAsString(alipayPassTemplateUpdateModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 支付宝pass新建卡券实例接口
     *
     * @param alipayPassInstanceAddModel
     * @return
     */
    public static Map<String, Object> alipayPassInstanceAdd(AlipayPassInstanceAddModel alipayPassInstanceAddModel) {
        alipayPassInstanceAddModel.validateAndThrow();
        String tenantId = alipayPassInstanceAddModel.getTenantId();
        String branchId = alipayPassInstanceAddModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.pass.instance.add", JacksonUtils.writeValueAsString(alipayPassInstanceAddModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 发券授权
     *
     * @param koubeiMarketingToolPrizeSendAuthModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingToolPrizeSendAuth(KoubeiMarketingToolPrizeSendAuthModel koubeiMarketingToolPrizeSendAuthModel) {
        koubeiMarketingToolPrizeSendAuthModel.validateAndThrow();
        String tenantId = koubeiMarketingToolPrizeSendAuthModel.getTenantId();
        String branchId = koubeiMarketingToolPrizeSendAuthModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.marketing.tool.prizesend.auth", JacksonUtils.writeValueAsString(koubeiMarketingToolPrizeSendAuthModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 集点查询
     *
     * @param koubeiMarketingToolPointsQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingToolPointsQuery(KoubeiMarketingToolPointsQueryModel koubeiMarketingToolPointsQueryModel) {
        koubeiMarketingToolPointsQueryModel.validateAndThrow();
        String tenantId = koubeiMarketingToolPointsQueryModel.getTenantId();
        String branchId = koubeiMarketingToolPointsQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.marketing.tool.points.query", JacksonUtils.writeValueAsString(koubeiMarketingToolPointsQueryModel, JsonInclude.Include.NON_NULL));
    }
    /***************************************************************卡劵API结束***************************************************************/

    /***************************************************************营销API结束***************************************************************/
    /**
     * 招商门店分页查询接口
     *
     * @param koubeiMarketingCampaignRecruitShopQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignRecruitShopQuery(KoubeiMarketingCampaignRecruitShopQueryModel koubeiMarketingCampaignRecruitShopQueryModel) {
        koubeiMarketingCampaignRecruitShopQueryModel.validateAndThrow();
        String tenantId = koubeiMarketingCampaignRecruitShopQueryModel.getTenantId();
        String branchId = koubeiMarketingCampaignRecruitShopQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.marketing.campaign.recruit.shop.query", JacksonUtils.writeValueAsString(koubeiMarketingCampaignRecruitShopQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 口碑营销活动列表查询
     *
     * @param koubeiMarketingCampaignActivityBatchQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignActivityBatchQuery(KoubeiMarketingCampaignActivityBatchQueryModel koubeiMarketingCampaignActivityBatchQueryModel) {
        koubeiMarketingCampaignActivityBatchQueryModel.validateAndThrow();
        String tenantId = koubeiMarketingCampaignActivityBatchQueryModel.getTenantId();
        String branchId = koubeiMarketingCampaignActivityBatchQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.marketing.campaign.activity.batchquery", JacksonUtils.writeValueAsString(koubeiMarketingCampaignActivityBatchQueryModel, JsonInclude.Include.NON_NULL));
    }

    /**
     * 活动修改接口
     *
     * @param koubeiMarketingCampaignActivityModifyModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignActivityModify(KoubeiMarketingCampaignActivityModifyModel koubeiMarketingCampaignActivityModifyModel) {
        koubeiMarketingCampaignActivityModifyModel.validateAndThrow();
        String tenantId = koubeiMarketingCampaignActivityModifyModel.getTenantId();
        String branchId = koubeiMarketingCampaignActivityModifyModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "koubei.marketing.campaign.activity.modify", JacksonUtils.writeValueAsString(koubeiMarketingCampaignActivityModifyModel, JsonInclude.Include.NON_NULL));
    }
}
