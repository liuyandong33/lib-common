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

    public static Map<String, Object> callAlipayApi(AlipayBasicModel alipayBasicModel, String method) {
        alipayBasicModel.validateAndThrow();
        String tenantId = alipayBasicModel.getTenantId();
        String branchId = alipayBasicModel.getBranchId();
        String returnUrl = alipayBasicModel.getReturnUrl();
        String notifyUrl = alipayBasicModel.getNotifyUrl();
        String authToken = alipayBasicModel.getAuthToken();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        ValidateUtils.notNull(alipayAuthorizerInfo, "未检索到授权信息！");
        return callAlipayApi(alipayAuthorizerInfo, method, returnUrl, notifyUrl, authToken, JacksonUtils.writeValueAsString(alipayBasicModel, JsonInclude.Include.NON_NULL));
    }


    /***************************************************************支付API开始***************************************************************/
    /**
     * 统一收单交易退款查询
     *
     * @param alipayTradeFastPayRefundQueryModel
     * @return
     */
    public static Map<String, Object> alipayTradeFastPayRefundQuery(AlipayTradeFastPayRefundQueryModel alipayTradeFastPayRefundQueryModel) {
        return callAlipayApi(alipayTradeFastPayRefundQueryModel, "alipay.trade.fastpay.refund.query");
    }

    /**
     * 统一收单交易结算接口
     *
     * @param alipayTradeOrderSettleModel
     * @return
     */
    public static Map<String, Object> alipayTradeOrderSettle(AlipayTradeOrderSettleModel alipayTradeOrderSettleModel) {
        return callAlipayApi(alipayTradeOrderSettleModel, "alipay.trade.order.settle");
    }

    /**
     * 统一收单交易关闭接口
     *
     * @param alipayTradeCloseModel
     * @return
     */
    public static Map<String, Object> alipayTradeClose(AlipayTradeCloseModel alipayTradeCloseModel) {
        return callAlipayApi(alipayTradeCloseModel, "alipay.trade.close");
    }

    /**
     * 统一收单交易撤销接口
     *
     * @param alipayTradeCancelModel
     * @return
     */
    public static Map<String, Object> alipayTradeCancel(AlipayTradeCancelModel alipayTradeCancelModel) {
        return callAlipayApi(alipayTradeCancelModel, "alipay.trade.cancel");
    }

    /**
     * 统一收单交易退款接口
     *
     * @param alipayTradeRefundModel
     * @return
     */
    public static Map<String, Object> alipayTradeRefund(AlipayTradeRefundModel alipayTradeRefundModel) {
        return callAlipayApi(alipayTradeRefundModel, "alipay.trade.refund");
    }

    /**
     * 统一收单线下交易预创建
     *
     * @param alipayTradePreCreateModel
     * @return
     */
    public static Map<String, Object> alipayTradePreCreate(AlipayTradePreCreateModel alipayTradePreCreateModel) {
        return callAlipayApi(alipayTradePreCreateModel, "alipay.trade.precreate");
    }

    /**
     * 统一收单交易创建接口
     *
     * @param alipayTradeCreateModel
     * @return
     */
    public static Map<String, Object> alipayTradeCreate(AlipayTradeCreateModel alipayTradeCreateModel) {
        return callAlipayApi(alipayTradeCreateModel, "alipay.trade.create");
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
        return callAlipayApi(alipayTradeQueryModel, "alipay.trade.query");
    }

    /**
     * 口碑商品交易查询接口
     *
     * @param koubeiTradeItemOrderQueryModel
     * @return
     */
    public static Map<String, Object> koubeiTradeItemOrderQuery(KoubeiTradeItemOrderQueryModel koubeiTradeItemOrderQueryModel) {
        return callAlipayApi(koubeiTradeItemOrderQueryModel, "koubei.trade.itemorder.query");
    }

    /**
     * 口碑商品交易购买接口
     *
     * @param koubeiTradeItemOrderBuyModel
     * @return
     */
    public static Map<String, Object> koubeiTradeItemOrderBuy(KoubeiTradeItemOrderBuyModel koubeiTradeItemOrderBuyModel) {
        return callAlipayApi(koubeiTradeItemOrderBuyModel, "koubei.trade.itemorder.buy");
    }

    /**
     * 口碑商品交易退货接口
     *
     * @param koubeiTradeItemOrderRefundModel
     * @return
     */
    public static Map<String, Object> koubeiTradeItemOrderRefund(KoubeiTradeItemOrderRefundModel koubeiTradeItemOrderRefundModel) {
        return callAlipayApi(koubeiTradeItemOrderRefundModel, "koubei.trade.itemorder.refund");
    }

    /**
     * 资金授权冻结接口
     *
     * @param alipayFundAuthOrderFreezeModel
     * @return
     */
    public static Map<String, Object> alipayFundAuthOrderFreeze(AlipayFundAuthOrderFreezeModel alipayFundAuthOrderFreezeModel) {
        return callAlipayApi(alipayFundAuthOrderFreezeModel, "alipay.fund.auth.order.freeze");
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
        return callAlipayApi(koubeiTradeTicketTicketCodeSendModel, "koubei.trade.ticket.ticketcode.send");
    }

    /**
     * 口碑凭证延期接口
     *
     * @param koubeiTradeTicketTicketCodeDelayModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeDelay(KoubeiTradeTicketTicketCodeDelayModel koubeiTradeTicketTicketCodeDelayModel) {
        return callAlipayApi(koubeiTradeTicketTicketCodeDelayModel, "koubei.trade.ticket.ticketcode.delay");
    }

    /**
     * 口碑凭证码撤销核销
     *
     * @param koubeiTradeTicketTicketCodeCancelModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeCancel(KoubeiTradeTicketTicketCodeCancelModel koubeiTradeTicketTicketCodeCancelModel) {
        return callAlipayApi(koubeiTradeTicketTicketCodeCancelModel, "koubei.trade.ticket.ticketcode.cancel");
    }

    /**
     * 口碑凭证码查询
     *
     * @param koubeiTradeTicketTicketCodeQueryModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeQuery(KoubeiTradeTicketTicketCodeQueryModel koubeiTradeTicketTicketCodeQueryModel) {
        return callAlipayApi(koubeiTradeTicketTicketCodeQueryModel, "koubei.trade.ticket.ticketcode.query");
    }

    /**
     * 支付宝订单信息同步接口
     *
     * @param alipayTradeOrderInfoSyncModel
     * @return
     */
    public static Map<String, Object> alipayTradeOrderInfoSync(AlipayTradeOrderInfoSyncModel alipayTradeOrderInfoSyncModel) {
        return callAlipayApi(alipayTradeOrderInfoSyncModel, "alipay.trade.orderinfo.sync");
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
        return callAlipayApi(koubeiTradeOrderPreCreateModel, "koubei.trade.order.precreate");
    }

    /**
     * 网商银行全渠道收单业务订单创建
     *
     * @param myBankPaymentTradeOrderCreateModel
     * @return
     */
    public static Map<String, Object> myBankPaymentTradeOrderCreate(MyBankPaymentTradeOrderCreateModel myBankPaymentTradeOrderCreateModel) {
        return callAlipayApi(myBankPaymentTradeOrderCreateModel, "mybank.payment.trade.order.create");
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
        return callAlipayApi(aftAiFinFireEyeOcrImageQueryModel, "aft.aifin.fireeye.ocr.image.query");
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
        return callAlipayApi(alipayOpenPublicAccountResetModel, "alipay.open.public.account.reset");
    }

    /**
     * 获取关注者列表
     *
     * @param alipayOpenPublicFollowBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicFollowBatchQuery(AlipayOpenPublicFollowBatchQueryModel alipayOpenPublicFollowBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicFollowBatchQueryModel, "alipay.open.public.follow.batchquery");
    }

    /**
     * 消息模板领取接口
     *
     * @param alipayOpenPublicTemplateMessageGetModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTemplateMessageGet(AlipayOpenPublicTemplateMessageGetModel alipayOpenPublicTemplateMessageGetModel) {
        return callAlipayApi(alipayOpenPublicTemplateMessageGetModel, "alipay.open.public.template.message.get");
    }

    /**
     * 单发模板消息
     *
     * @param alipayOpenPublicMessageSingleSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageSingleSend(AlipayOpenPublicMessageSingleSendModel alipayOpenPublicMessageSingleSendModel) {
        return callAlipayApi(alipayOpenPublicMessageSingleSendModel, "alipay.open.public.message.single.send");
    }

    /**
     * 带参推广二维码接口
     *
     * @param alipayOpenPublicQrCodeCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicQrCodeCreate(AlipayOpenPublicQrCodeCreateModel alipayOpenPublicQrCodeCreateModel) {
        return callAlipayApi(alipayOpenPublicQrCodeCreateModel, "alipay.open.public.qrcode.create");
    }

    /**
     * 查询绑定商户会员号
     *
     * @param alipayOpenPublicAccountQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAccountQuery(AlipayOpenPublicAccountQueryModel alipayOpenPublicAccountQueryModel) {
        return callAlipayApi(alipayOpenPublicAccountQueryModel, "alipay.open.public.account.query");
    }

    /**
     * 解除绑定商户会员号O
     *
     * @param alipayOpenPublicAccountDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAccountDelete(AlipayOpenPublicAccountDeleteModel alipayOpenPublicAccountDeleteModel) {
        return callAlipayApi(alipayOpenPublicAccountDeleteModel, "alipay.open.public.account.delete");
    }

    /**
     * 标签修改接口
     *
     * @param alipayOpenPublicLifeLabelModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeLabelModify(AlipayOpenPublicLifeLabelModifyModel alipayOpenPublicLifeLabelModifyModel) {
        return callAlipayApi(alipayOpenPublicLifeLabelModifyModel, "alipay.open.public.life.label.modify");
    }

    /**
     * 标签批量查询接口
     *
     * @param alipayOpenPublicLifeLabelBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeLabelBatchQuery(AlipayOpenPublicLifeLabelBatchQueryModel alipayOpenPublicLifeLabelBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicLifeLabelBatchQueryModel, "alipay.open.public.life.label.batchquery");
    }

    /**
     * 用户取消标签接口
     *
     * @param alipayOpenPublicMatchUserLabelDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMatchUserLabelDelete(AlipayOpenPublicMatchUserLabelDeleteModel alipayOpenPublicMatchUserLabelDeleteModel) {
        return callAlipayApi(alipayOpenPublicMatchUserLabelDeleteModel, "alipay.open.public.matchuser.label.delete");
    }

    /**
     * 菜单列表查询接口
     *
     * @param alipayOpenPublicMenuBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMenuBatchQuery(AlipayOpenPublicMenuBatchQueryModel alipayOpenPublicMenuBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicMenuBatchQueryModel, "alipay.open.public.menu.batchquery");
    }

    /**
     * 个性化菜单删除
     *
     * @param alipayOpenPublicPersonalizedMenuDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedMenuDelete(AlipayOpenPublicPersonalizedMenuDeleteModel alipayOpenPublicPersonalizedMenuDeleteModel) {
        return callAlipayApi(alipayOpenPublicPersonalizedMenuDeleteModel, "alipay.open.public.personalized.menu.delete");
    }

    /**
     * 扩展区删除接口
     *
     * @param alipayOpenPublicPersonalizedExtensionDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedExtensionDelete(AlipayOpenPublicPersonalizedExtensionDeleteModel alipayOpenPublicPersonalizedExtensionDeleteModel) {
        return callAlipayApi(alipayOpenPublicPersonalizedExtensionDeleteModel, "alipay.open.public.personalized.extension.delete");
    }

    /**
     * 创建标签接口
     *
     * @param alipayOpenPublicLifeLabelCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeLabelCreate(AlipayOpenPublicLifeLabelCreateModel alipayOpenPublicLifeLabelCreateModel) {
        return callAlipayApi(alipayOpenPublicLifeLabelCreateModel, "alipay.open.public.life.label.create");
    }

    /**
     * 添加绑定商户会员号
     *
     * @param alipayOpenPublicAccountCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAccountCreate(AlipayOpenPublicAccountCreateModel alipayOpenPublicAccountCreateModel) {
        return callAlipayApi(alipayOpenPublicAccountCreateModel, "alipay.open.public.account.create");
    }

    /**
     * 服务窗短链自主生成接口
     *
     * @param alipayOpenPublicShortLinkCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicShortLinkCreate(AlipayOpenPublicShortLinkCreateModel alipayOpenPublicShortLinkCreateModel) {
        return callAlipayApi(alipayOpenPublicShortLinkCreateModel, "alipay.open.public.shortlink.create");
    }

    /**
     * 用户打标接口
     *
     * @param alipayOpenPublicMatchUserLabelCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMatchUserLabelCreate(AlipayOpenPublicMatchUserLabelCreateModel alipayOpenPublicMatchUserLabelCreateModel) {
        return callAlipayApi(alipayOpenPublicMatchUserLabelCreateModel, "alipay.open.public.matchuser.label.create");
    }

    /**
     * 群发消息
     *
     * @param alipayOpenPublicMessageTotalSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageTotalSend(AlipayOpenPublicMessageTotalSendModel alipayOpenPublicMessageTotalSendModel) {
        return callAlipayApi(alipayOpenPublicMessageTotalSendModel, "alipay.open.public.message.total.send");
    }

    /**
     * 异步单发消息
     *
     * @param alipayOpenPublicMessageCustomSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageCustomSend(AlipayOpenPublicMessageCustomSendModel alipayOpenPublicMessageCustomSendModel) {
        return callAlipayApi(alipayOpenPublicMessageCustomSendModel, "alipay.open.public.message.custom.send");
    }

    /**
     * 默认菜单更新接口
     *
     * @param alipayOpenPublicMenuModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMenuModify(AlipayOpenPublicMenuModifyModel alipayOpenPublicMenuModifyModel) {
        return callAlipayApi(alipayOpenPublicMenuModifyModel, "alipay.open.public.menu.modify");
    }

    /**
     * 个性化菜单创建
     * TODO: model 未实现
     *
     * @param alipayOpenPublicPersonalizedMenuCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedMenuCreate(AlipayOpenPublicPersonalizedMenuCreateModel alipayOpenPublicPersonalizedMenuCreateModel) {
        return callAlipayApi(alipayOpenPublicPersonalizedMenuCreateModel, "alipay.open.public.personalized.menu.create");
    }

    /**
     * 默认菜单创建接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMenuCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMenuCreate(AlipayOpenPublicMenuCreateModel alipayOpenPublicMenuCreateModel) {
        return callAlipayApi(alipayOpenPublicMenuCreateModel, "alipay.open.public.menu.create");
    }

    /**
     * 个性化扩展区创建接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicPersonalizedExtensionCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedExtensionCreate(AlipayOpenPublicPersonalizedExtensionCreateModel alipayOpenPublicPersonalizedExtensionCreateModel) {
        return callAlipayApi(alipayOpenPublicPersonalizedExtensionCreateModel, "alipay.open.public.personalized.extension.create");
    }

    /**
     * 查询用户分组列表
     *
     * @param alipayOpenPublicGroupBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupBatchQuery(AlipayOpenPublicGroupBatchQueryModel alipayOpenPublicGroupBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicGroupBatchQueryModel, "alipay.open.public.group.batchquery");
    }

    /**
     * 用户分组修改接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicGroupModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupModify(AlipayOpenPublicGroupModifyModel alipayOpenPublicGroupModifyModel) {
        return callAlipayApi(alipayOpenPublicGroupModifyModel, "alipay.open.public.group.batchquery");
    }

    /**
     * 用户分组删除接口
     *
     * @param alipayOpenPublicGroupDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupDelete(AlipayOpenPublicGroupDeleteModel alipayOpenPublicGroupDeleteModel) {
        return callAlipayApi(alipayOpenPublicGroupDeleteModel, "alipay.open.public.group.delete");
    }

    /**
     * 分组消息发送接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMessageGroupSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageGroupSend(AlipayOpenPublicMessageGroupSendModel alipayOpenPublicMessageGroupSendModel) {
        return callAlipayApi(alipayOpenPublicMessageGroupSendModel, "alipay.open.public.message.group.send");
    }

    /**
     * 用户分组创建接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicGroupCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupCreate(AlipayOpenPublicGroupCreateModel alipayOpenPublicGroupCreateModel) {
        return callAlipayApi(alipayOpenPublicGroupCreateModel, "alipay.open.public.group.create");
    }

    /**
     * 人群数量查询
     * TODO: model 未实现
     *
     * @param alipayOpenPublicGroupCrowdQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicGroupCrowdQuery(AlipayOpenPublicGroupCrowdQueryModel alipayOpenPublicGroupCrowdQueryModel) {
        return callAlipayApi(alipayOpenPublicGroupCrowdQueryModel, "alipay.open.public.group.crowd.query");
    }

    /**
     * 扩展区批量查询接口
     *
     * @param alipayOpenPublicPersonalizedExtensionBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPersonalizedExtensionBatchQuery(AlipayOpenPublicPersonalizedExtensionBatchQueryModel alipayOpenPublicPersonalizedExtensionBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicPersonalizedExtensionBatchQueryModel, "alipay.open.public.personalized.extension.batchquery");
    }

    /**
     * 默认扩展区创建接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicDefaultExtensionCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicDefaultExtensionCreate(AlipayOpenPublicDefaultExtensionCreateModel alipayOpenPublicDefaultExtensionCreateModel) {
        return callAlipayApi(alipayOpenPublicDefaultExtensionCreateModel, "alipay.open.public.default.extension.create");
    }

    /**
     * 标签删除接口
     *
     * @param alipayOpenPublicLifeLabelDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeLabelDelete(AlipayOpenPublicLifeLabelDeleteModel alipayOpenPublicLifeLabelDeleteModel) {
        return callAlipayApi(alipayOpenPublicLifeLabelDeleteModel, "alipay.open.public.life.label.delete");
    }

    /**
     * isv代创建生活号申请状态查询接口
     *
     * @param alipayOpenPublicLifeAgentCreateQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeAgentCreateQuery(AlipayOpenPublicLifeAgentCreateQueryModel alipayOpenPublicLifeAgentCreateQueryModel) {
        return callAlipayApi(alipayOpenPublicLifeAgentCreateQueryModel, "alipay.open.public.life.agentcreate.query");
    }

    /**
     * 下架生活号
     *
     * @param alipayOpenPublicLifeDebarkApplyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeDebarkApply(AlipayOpenPublicLifeDebarkApplyModel alipayOpenPublicLifeDebarkApplyModel) {
        return callAlipayApi(alipayOpenPublicLifeDebarkApplyModel, "alipay.open.public.life.debark.apply");
    }

    /**
     * 上架生活号
     *
     * @param alipayOpenPublicLifeAboardApplyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeAboardApply(AlipayOpenPublicLifeAboardApplyModel alipayOpenPublicLifeAboardApplyModel) {
        return callAlipayApi(alipayOpenPublicLifeAboardApplyModel, "alipay.open.public.life.aboard.apply");
    }

    /**
     * 生活号查询行业设置接口
     *
     * @param alipayOpenPublicSettingCategoryQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicSettingCategoryQuery(AlipayOpenPublicSettingCategoryQueryModel alipayOpenPublicSettingCategoryQueryModel) {
        return callAlipayApi(alipayOpenPublicSettingCategoryQueryModel, "alipay.open.public.setting.category.query");
    }

    /**
     * 生活号查询已发送消息接口
     *
     * @param alipayOpenPublicMessageQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageQuery(AlipayOpenPublicMessageQueryModel alipayOpenPublicMessageQueryModel) {
        return callAlipayApi(alipayOpenPublicMessageQueryModel, "alipay.open.public.message.query");
    }

    /**
     * 生活号消息撤回接口
     *
     * @param alipayOpenPublicLifeMsgRecallModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicLifeMsgRecall(AlipayOpenPublicLifeMsgRecallModel alipayOpenPublicLifeMsgRecallModel) {
        return callAlipayApi(alipayOpenPublicLifeMsgRecallModel, "alipay.open.public.life.msg.recall");
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
        return callAlipayApi(alipayOpenPublicLifeAgentCreateModel, "alipay.open.public.life.agent.create");
    }

    /**
     * 模板消息行业设置修改接口
     *
     * @param alipayOpenPublicTemplateMessageIndustryModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTemplateMessageIndustryModify(AlipayOpenPublicTemplateMessageIndustryModifyModel alipayOpenPublicTemplateMessageIndustryModifyModel) {
        return callAlipayApi(alipayOpenPublicTemplateMessageIndustryModifyModel, "alipay.open.public.template.message.industry.modify");
    }

    /**
     * 生活号关注用户查询接口
     *
     * @param alipayOpenPublicUserFollowQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicUserFollowQuery(AlipayOpenPublicUserFollowQueryModel alipayOpenPublicUserFollowQueryModel) {
        return callAlipayApi(alipayOpenPublicUserFollowQueryModel, "alipay.open.public.user.follow.query");
    }

    /**
     * 生活号广告位修改接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicAdvertModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAdvertModify(AlipayOpenPublicAdvertModifyModel alipayOpenPublicAdvertModifyModel) {
        return callAlipayApi(alipayOpenPublicAdvertModifyModel, "alipay.open.public.advert.modify");
    }

    /**
     * 生活号广告位添加接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicAdvertCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAdvertCreate(AlipayOpenPublicAdvertCreateModel alipayOpenPublicAdvertCreateModel) {
        return callAlipayApi(alipayOpenPublicAdvertCreateModel, "alipay.open.public.advert.create");
    }

    /**
     * 生活号广告位查询接口
     *
     * @param alipayOpenPublicAdvertBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAdvertBatchQuery(AlipayOpenPublicAdvertBatchQueryModel alipayOpenPublicAdvertBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicAdvertBatchQueryModel, "alipay.open.public.advert.batchquery");
    }

    /**
     * 生活号广告位删除接口
     *
     * @param alipayOpenPublicAdvertDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicAdvertDelete(AlipayOpenPublicAdvertDeleteModel alipayOpenPublicAdvertDeleteModel) {
        return callAlipayApi(alipayOpenPublicAdvertDeleteModel, "alipay.open.public.advert.delete");
    }

    /**
     * 国开行助学贷款还款计划查询接口
     *
     * @param alipayFundStudentLoanRepayQueryModel
     * @return
     */
    public static Map<String, Object> alipayFundStudentLoanRepayQuery(AlipayFundStudentLoanRepayQueryModel alipayFundStudentLoanRepayQueryModel) {
        return callAlipayApi(alipayFundStudentLoanRepayQueryModel, "alipay.fund.studentloan.repay.query");
    }

    /**
     * 营销位添加接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicTopicCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTopicCreate(AlipayOpenPublicTopicCreateModel alipayOpenPublicTopicCreateModel) {
        return callAlipayApi(alipayOpenPublicTopicCreateModel, "alipay.open.public.topic.create");
    }

    /**
     * 营销位修改接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicTopicModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTopicModify(AlipayOpenPublicTopicModifyModel alipayOpenPublicTopicModifyModel) {
        return callAlipayApi(alipayOpenPublicTopicModifyModel, "alipay.open.public.topic.modify");
    }

    /**
     * 营销位删除接口
     *
     * @param alipayOpenPublicTopicDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTopicDelete(AlipayOpenPublicTopicDeleteModel alipayOpenPublicTopicDeleteModel) {
        return callAlipayApi(alipayOpenPublicTopicDeleteModel, "alipay.open.public.topic.delete");
    }

    /**
     * 营销位查询接口
     *
     * @param alipayOpenPublicTopicBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicTopicBatchQuery(AlipayOpenPublicTopicBatchQueryModel alipayOpenPublicTopicBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicTopicBatchQueryModel, "alipay.open.public.topic.batchquery");
    }

    /**
     * 图文分析-按文章查询数据接口
     *
     * @param alipayOpenPublicSingleArticleDataBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicSingleArticleDataBatchQuery(AlipayOpenPublicSingleArticleDataBatchQueryModel alipayOpenPublicSingleArticleDataBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicSingleArticleDataBatchQueryModel, "alipay.open.public.singlearticle.data.batchquery");
    }

    /**
     * 用户分析数据查询接口
     *
     * @param alipayOpenPublicUserDataBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicUserDataBatchQuery(AlipayOpenPublicUserDataBatchQueryModel alipayOpenPublicUserDataBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicUserDataBatchQueryModel, "alipay.open.public.user.data.batchquery");
    }

    /**
     * 图文分析-按时间查询数据接口
     *
     * @param alipayOpenPublicArticleSummaryDataBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicArticleSummaryDataBatchQuery(AlipayOpenPublicArticleSummaryDataBatchQueryModel alipayOpenPublicArticleSummaryDataBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicArticleSummaryDataBatchQueryModel, "alipay.open.public.articlesummary.data.batchquery");
    }

    /**
     * 菜单分析数据查询接口
     *
     * @param alipayOpenPublicMenuDataBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMenuDataBatchQuery(AlipayOpenPublicMenuDataBatchQueryModel alipayOpenPublicMenuDataBatchQueryModel) {
        return callAlipayApi(alipayOpenPublicMenuDataBatchQueryModel, "alipay.open.public.menu.data.batchquery");
    }

    /**
     * 生活号基础信息修改接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicInfoModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicInfoModify(AlipayOpenPublicInfoModifyModel alipayOpenPublicInfoModifyModel) {
        return callAlipayApi(alipayOpenPublicInfoModifyModel, "alipay.open.public.info.modify");
    }

    /**
     * 添加收款账号接口
     * 允许开发者调用该接口将收款账号与当前生活号绑定，从而支持支付成功页引导推荐关注生活号
     *
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPayeeBindCreate(AlipayOpenPublicPayeeBindCreateModel alipayOpenPublicPayeeBindCreateModel) {
        return callAlipayApi(alipayOpenPublicPayeeBindCreateModel, "alipay.open.public.payee.bind.create");
    }

    /**
     * 解绑收款账号接口
     *
     * @param alipayOpenPublicPayeeBindDeleteModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPayeeBindDelete(AlipayOpenPublicPayeeBindDeleteModel alipayOpenPublicPayeeBindDeleteModel) {
        return callAlipayApi(alipayOpenPublicPayeeBindDeleteModel, "alipay.open.public.payee.bind.delete");
    }


    /**
     * 创建图文消息内容接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMessageContentCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageContentCreate(AlipayOpenPublicMessageContentCreateModel alipayOpenPublicMessageContentCreateModel) {
        return callAlipayApi(alipayOpenPublicMessageContentCreateModel, "alipay.open.public.message.content.create");
    }

    /**
     * 更新图文消息内容接口
     * TODO: model 未实现
     *
     * @param alipayOpenPublicMessageContentModifyModel
     * @return
     */
    public static Map<String, Object> alipayOpenPublicMessageContentModify(AlipayOpenPublicMessageContentModifyModel alipayOpenPublicMessageContentModifyModel) {
        return callAlipayApi(alipayOpenPublicMessageContentModifyModel, "alipay.open.public.message.content.modify");
    }

    /**
     * 缴费直连代扣签约前置校验
     * TODO: model 未实现
     *
     * @param alipayEbppPdeductSignValidateModel
     * @return
     */
    public static Map<String, Object> alipayEbppPdeductSignValidate(AlipayEbppPdeductSignValidateModel alipayEbppPdeductSignValidateModel) {
        return callAlipayApi(alipayEbppPdeductSignValidateModel, "alipay.ebpp.pdeduct.sign.validate");
    }

    /***************************************************************会员API开始***************************************************************/

    /**
     * 支付宝会员授权信息查询接口
     *
     * @param alipayUserInfoShareModel
     * @return
     */
    public static Map<String, Object> alipayUserInfoShare(AlipayUserInfoShareModel alipayUserInfoShareModel) {
        return callAlipayApi(alipayUserInfoShareModel, "alipay.user.info.share");
    }

    /**
     * 芝麻企业征信基于身份的协议授权
     *
     * @param alipayUserAuthZhiMaOrgIdentityApplyModel
     * @return
     */
    public static Map<String, Object> alipayUserAuthZhiMaOrgIdentityApply(AlipayUserAuthZhiMaOrgIdentityApplyModel alipayUserAuthZhiMaOrgIdentityApplyModel) {
        return callAlipayApi(alipayUserAuthZhiMaOrgIdentityApplyModel, "alipay.user.auth.zhimaorg.identity.apply");
    }

    /**
     * 查询是否在支付宝公益捐赠的接口
     *
     * @param alipayUserCharityRecordExistQueryModel
     * @return
     */
    public static Map<String, Object> alipayUserCharityRecordExistQuery(AlipayUserCharityRecordExistQueryModel alipayUserCharityRecordExistQueryModel) {
        return callAlipayApi(alipayUserCharityRecordExistQueryModel, "alipay.user.charity.recordexist.query");
    }

    /**
     * 身份认证记录查询
     *
     * @param alipayUserCertifyOpenQueryModel
     * @return
     */
    public static Map<String, Object> alipayUserCertifyOpenQuery(AlipayUserCertifyOpenQueryModel alipayUserCertifyOpenQueryModel) {
        return callAlipayApi(alipayUserCertifyOpenQueryModel, "alipay.user.certify.open.query");
    }

    /**
     * 身份认证初始化服务
     * TODO: model 未实现
     *
     * @param alipayUserCertifyOpenInitializeModel
     * @return
     */
    public static Map<String, Object> alipayUserCertifyOpenInitialize(AlipayUserCertifyOpenInitializeModel alipayUserCertifyOpenInitializeModel) {
        return callAlipayApi(alipayUserCertifyOpenInitializeModel, "alipay.user.certify.open.initialize");
    }

    /**
     * 身份认证开始认证
     *
     * @param alipayUserCertifyOpenCertifyModel
     * @return
     */
    public static Map<String, Object> alipayUserCertifyOpenCertify(AlipayUserCertifyOpenCertifyModel alipayUserCertifyOpenCertifyModel) {
        return callAlipayApi(alipayUserCertifyOpenCertifyModel, "alipay.user.certify.open.certify");
    }

    /**
     * 通用当面付二阶段接口
     *
     * @param alipayUserTwoStageCommonUseModel
     * @return
     */
    public static Map<String, Object> alipayUserTwoStageCommonUse(AlipayUserTwoStageCommonUseModel alipayUserTwoStageCommonUseModel) {
        return callAlipayApi(alipayUserTwoStageCommonUseModel, "alipay.user.twostage.common.use");
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
        return callAlipayApi(alipayOfflineMaterialImageUploadModel, "alipay.offline.material.image.upload");
    }

    /**
     * 会员卡模板创建
     *
     * @param alipayMarketingCardTemplateCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardTemplateCreate(AlipayMarketingCardTemplateCreateModel alipayMarketingCardTemplateCreateModel) {
        return callAlipayApi(alipayMarketingCardTemplateCreateModel, "alipay.marketing.card.template.create");
    }

    /**
     * 会员卡模板修改
     * TODO: model 未实现
     *
     * @param alipayMarketingCardTemplateModifyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardTemplateModify(AlipayMarketingCardTemplateModifyModel alipayMarketingCardTemplateModifyModel) {
        return callAlipayApi(alipayMarketingCardTemplateModifyModel, "alipay.marketing.card.template.modify");
    }

    /**
     * 会员卡模板查询接口
     * TODO: model 未实现
     *
     * @param alipayMarketingCardTemplateQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardTemplateQuery(AlipayMarketingCardTemplateQueryModel alipayMarketingCardTemplateQueryModel) {
        return callAlipayApi(alipayMarketingCardTemplateQueryModel, "alipay.marketing.card.template.query");
    }

    /**
     * 会员卡开卡表单模板配置
     * TODO: model 未实现
     *
     * @param alipayMarketingCardFormTemplateSetModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardFormTemplateSet(AlipayMarketingCardFormTemplateSetModel alipayMarketingCardFormTemplateSetModel) {
        return callAlipayApi(alipayMarketingCardFormTemplateSetModel, "alipay.marketing.card.formtemplate.set");
    }

    /**
     * 获取会员卡领卡投放链接
     * TODO: model 未实现
     *
     * @param alipayMarketingCardActivateUrlApplyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardActivateUrlApply(AlipayMarketingCardActivateUrlApplyModel alipayMarketingCardActivateUrlApplyModel) {
        return callAlipayApi(alipayMarketingCardActivateUrlApplyModel, "alipay.marketing.card.activateurl.apply");
    }

    /**
     * 查询用户提交的会员卡表单信息
     * TODO: model 未实现
     *
     * @param alipayMarketingCardActivateFormQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardActivateFormQuery(AlipayMarketingCardActivateFormQueryModel alipayMarketingCardActivateFormQueryModel) {
        return callAlipayApi(alipayMarketingCardActivateFormQueryModel, "alipay.marketing.card.activateform.query");
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
        return callAlipayApi(alipayMarketingCardUpdateModel, "alipay.marketing.card.update");
    }

    /**
     * 会员卡删卡
     *
     * @param alipayMarketingCardDeleteModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardDelete(AlipayMarketingCardDeleteModel alipayMarketingCardDeleteModel) {
        return callAlipayApi(alipayMarketingCardDeleteModel, "alipay.marketing.card.delete");
    }

    /**
     * 会员卡查询
     * TODO: model 未实现
     *
     * @param alipayMarketingCardQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardQuery(AlipayMarketingCardQueryModel alipayMarketingCardQueryModel) {
        return callAlipayApi(alipayMarketingCardQueryModel, "alipay.marketing.card.query");
    }

    /**
     * 会员卡模板外部权益修改
     * TODO: model 未实现
     *
     * @param alipayMarketingCardBenefitModifyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardBenefitModify(AlipayMarketingCardBenefitModifyModel alipayMarketingCardBenefitModifyModel) {
        return callAlipayApi(alipayMarketingCardBenefitModifyModel, "alipay.marketing.card.benefit.modify");
    }

    /**
     * 会员卡模板外部权益删除
     * TODO: model 未实现
     *
     * @param alipayMarketingCardBenefitDeleteModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardBenefitDelete(AlipayMarketingCardBenefitDeleteModel alipayMarketingCardBenefitDeleteModel) {
        return callAlipayApi(alipayMarketingCardBenefitDeleteModel, "alipay.marketing.card.benefit.delete");
    }

    /**
     * 会员卡模板外部权益创建
     * TODO: model 未实现
     *
     * @param alipayMarketingCardBenefitCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardBenefitCreate(AlipayMarketingCardBenefitCreateModel alipayMarketingCardBenefitCreateModel) {
        return callAlipayApi(alipayMarketingCardBenefitCreateModel, "alipay.marketing.card.benefit.create");
    }

    /**
     * 会员卡模板外部权益查询
     * TODO: model 未实现
     *
     * @param alipayMarketingCardBenefitQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardBenefitQuery(AlipayMarketingCardBenefitQueryModel alipayMarketingCardBenefitQueryModel) {
        return callAlipayApi(alipayMarketingCardBenefitQueryModel, "alipay.marketing.card.benefit.query");
    }

    /**
     * 会员卡模板批量查询
     * TODO: model 未实现
     *
     * @param alipayMarketingCardTemplateBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCardTemplateBatchQuery(AlipayMarketingCardTemplateBatchQueryModel alipayMarketingCardTemplateBatchQueryModel) {
        return callAlipayApi(alipayMarketingCardTemplateBatchQueryModel, "alipay.marketing.card.template.batchquery");
    }

    /**
     * 活动创建接口
     * TODO: model 未实现
     *
     * @param koubeiMarketingCampaignActivityCreateModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignActivityCreate(KoubeiMarketingCampaignActivityCreateModel koubeiMarketingCampaignActivityCreateModel) {
        return callAlipayApi(koubeiMarketingCampaignActivityCreateModel, "koubei.marketing.campaign.activity.create");
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
        return callAlipayApi(alipayOfflineMarketShopCategoryQueryModel, "alipay.offline.market.shop.category.query");
    }

    /**
     * 修改门店信息
     * TODO: model 未实现
     *
     * @param alipayOfflineMarketShopModifyModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopModify(AlipayOfflineMarketShopModifyModel alipayOfflineMarketShopModifyModel) {
        return callAlipayApi(alipayOfflineMarketShopModifyModel, "alipay.offline.market.shop.modify");
    }

    /**
     * 查询单个门店信息接口
     *
     * @param alipayOfflineMarketShopQueryDetailModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopQueryDetail(AlipayOfflineMarketShopQueryDetailModel alipayOfflineMarketShopQueryDetailModel) {
        return callAlipayApi(alipayOfflineMarketShopQueryDetailModel, "alipay.offline.market.shop.querydetail");
    }

    /**
     * 查询商户的门店编号列表
     *
     * @param alipayOfflineMarketShopBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopBatchQuery(AlipayOfflineMarketShopBatchQueryModel alipayOfflineMarketShopBatchQueryModel) {
        return callAlipayApi(alipayOfflineMarketShopBatchQueryModel, "alipay.offline.market.shop.batchquery");
    }

    /**
     * 门店摘要信息批量查询接口
     * TODO: model 未实现
     *
     * @param alipayOfflineMarketShopSummaryBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketShopSummaryBatchQuery(AlipayOfflineMarketShopSummaryBatchQueryModel alipayOfflineMarketShopSummaryBatchQueryModel) {
        return callAlipayApi(alipayOfflineMarketShopSummaryBatchQueryModel, "alipay.offline.market.shop.summary.batchquery");
    }

    /**
     * 业务流水批量查询接口
     * TODO: model 未实现
     *
     * @param alipayOfflineMarketApplyOrderBatchQueryModel
     * @return
     */
    public static Map<String, Object> alipayOfflineMarketApplyOrderBatchQuery(AlipayOfflineMarketApplyOrderBatchQueryModel alipayOfflineMarketApplyOrderBatchQueryModel) {
        return callAlipayApi(alipayOfflineMarketApplyOrderBatchQueryModel, "alipay.offline.market.applyorder.batchquery");
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
        return callAlipayApi(alipayOpenAgentMiniCreateModel, "alipay.open.agent.mini.create");
    }

    /**
     * 代签约APP支付产品
     * TODO: model 未实现
     *
     * @param alipayOpenAgentMobilePaySignModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentMobilePaySign(AlipayOpenAgentMobilePaySignModel alipayOpenAgentMobilePaySignModel) {
        return callAlipayApi(alipayOpenAgentMobilePaySignModel, "alipay.open.agent.mobilepay.sign");
    }

    /**
     * 代签约当面付产品
     * TODO: model 未实现
     *
     * @param alipayOpenAgentFaceToFaceSignModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentFaceToFaceSign(AlipayOpenAgentFaceToFaceSignModel alipayOpenAgentFaceToFaceSignModel) {
        return callAlipayApi(alipayOpenAgentFaceToFaceSignModel, "alipay.open.agent.facetoface.sign");
    }

    /**
     * 代签约芝麻信用（普惠版）产品
     * TODO: model 未实现
     *
     * @param alipayOpenAgentZhiMaBriefSignModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentZhiMaBriefSign(AlipayOpenAgentZhiMaBriefSignModel alipayOpenAgentZhiMaBriefSignModel) {
        return callAlipayApi(alipayOpenAgentZhiMaBriefSignModel, "alipay.open.agent.zhimabrief.sign");
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
        ValidateUtils.notNull(alipayAuthorizerInfo, "未检索到支付宝授权信息！");

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
        return callAlipayApi(alipayOpenAgentConfirmModel, "alipay.open.agent.confirm");
    }

    /**
     * 取消代商户签约、创建应用事务
     *
     * @param alipayOpenAgentCancelModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentCancel(AlipayOpenAgentCancelModel alipayOpenAgentCancelModel) {
        return callAlipayApi(alipayOpenAgentCancelModel, "alipay.open.agent.cancel");
    }

    /**
     * 查询申请单状态
     *
     * @param alipayOpenAgentOrderQueryModel
     * @return
     */
    public static Map<String, Object> alipayOpenAgentOrderQuery(AlipayOpenAgentOrderQueryModel alipayOpenAgentOrderQueryModel) {
        return callAlipayApi(alipayOpenAgentOrderQueryModel, "alipay.open.agent.order.query");
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
        return callAlipayApi(alipayOpenAgentOfflinePaymentSignModel, "alipay.open.agent.offlinepayment.sign");
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
        return callAlipayApi(alipayPassInstanceUpdateModel, "alipay.pass.instance.update");
    }

    /**
     * 更新卡集点
     *
     * @param koubeiMarketingToolPointsUpdateModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingToolPointsUpdate(KoubeiMarketingToolPointsUpdateModel koubeiMarketingToolPointsUpdateModel) {
        return callAlipayApi(koubeiMarketingToolPointsUpdateModel, "koubei.marketing.tool.points.update");
    }

    /**
     * 卡券模板创建
     *
     * @param alipayPassTemplateAddModel
     * @return
     */
    public static Map<String, Object> alipayPassTemplateAdd(AlipayPassTemplateAddModel alipayPassTemplateAddModel) {
        return callAlipayApi(alipayPassTemplateAddModel, "alipay.pass.template.add");
    }

    /**
     * 支付宝pass更新模版接口
     *
     * @param alipayPassTemplateUpdateModel
     * @return
     */
    public static Map<String, Object> alipayPassTemplateUpdate(AlipayPassTemplateUpdateModel alipayPassTemplateUpdateModel) {
        return callAlipayApi(alipayPassTemplateUpdateModel, "alipay.pass.template.update");
    }

    /**
     * 支付宝pass新建卡券实例接口
     *
     * @param alipayPassInstanceAddModel
     * @return
     */
    public static Map<String, Object> alipayPassInstanceAdd(AlipayPassInstanceAddModel alipayPassInstanceAddModel) {
        return callAlipayApi(alipayPassInstanceAddModel, "alipay.pass.instance.add");
    }

    /**
     * 发券授权
     *
     * @param koubeiMarketingToolPrizeSendAuthModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingToolPrizeSendAuth(KoubeiMarketingToolPrizeSendAuthModel koubeiMarketingToolPrizeSendAuthModel) {
        return callAlipayApi(koubeiMarketingToolPrizeSendAuthModel, "koubei.marketing.tool.prizesend.auth");
    }

    /**
     * 集点查询
     *
     * @param koubeiMarketingToolPointsQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingToolPointsQuery(KoubeiMarketingToolPointsQueryModel koubeiMarketingToolPointsQueryModel) {
        return callAlipayApi(koubeiMarketingToolPointsQueryModel, "koubei.marketing.tool.points.query");
    }
    /***************************************************************卡劵API结束***************************************************************/

    /***************************************************************营销API开始***************************************************************/
    /**
     * 招商门店分页查询接口
     *
     * @param koubeiMarketingCampaignRecruitShopQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignRecruitShopQuery(KoubeiMarketingCampaignRecruitShopQueryModel koubeiMarketingCampaignRecruitShopQueryModel) {
        return callAlipayApi(koubeiMarketingCampaignRecruitShopQueryModel, "koubei.marketing.campaign.recruit.shop.query");
    }

    /**
     * 口碑营销活动列表查询
     *
     * @param koubeiMarketingCampaignActivityBatchQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignActivityBatchQuery(KoubeiMarketingCampaignActivityBatchQueryModel koubeiMarketingCampaignActivityBatchQueryModel) {
        return callAlipayApi(koubeiMarketingCampaignActivityBatchQueryModel, "koubei.marketing.campaign.activity.batchquery");
    }

    /**
     * 活动修改接口
     * TODO: model 未实现
     *
     * @param koubeiMarketingCampaignActivityModifyModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignActivityModify(KoubeiMarketingCampaignActivityModifyModel koubeiMarketingCampaignActivityModifyModel) {
        return callAlipayApi(koubeiMarketingCampaignActivityModifyModel, "koubei.marketing.campaign.activity.modify");
    }

    /**
     * 活动详情查询
     *
     * @param koubeiMarketingCampaignActivityQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignActivityQuery(KoubeiMarketingCampaignActivityQueryModel koubeiMarketingCampaignActivityQueryModel) {
        return callAlipayApi(koubeiMarketingCampaignActivityQueryModel, "koubei.marketing.campaign.activity.query");
    }

    /**
     * 查询当前用户可用的模板列表
     *
     * @param alipayMarketingToolFengDieTemplateQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingToolFengDieTemplateQuery(AlipayMarketingToolFengDieTemplateQueryModel alipayMarketingToolFengDieTemplateQueryModel) {
        return callAlipayApi(alipayMarketingToolFengDieTemplateQueryModel, "alipay.marketing.tool.fengdie.template.query");
    }

    /**
     * 查询H5应用详情
     *
     * @param alipayMarketingToolFengDieActivityQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingToolFengDieActivityQuery(AlipayMarketingToolFengDieActivityQueryModel alipayMarketingToolFengDieActivityQueryModel) {
        return callAlipayApi(alipayMarketingToolFengDieActivityQueryModel, "alipay.marketing.tool.fengdie.activity.query");
    }

    /**
     * 创建H5应用
     * TODO: model 未实现
     *
     * @param alipayMarketingToolFengDieActivityCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingToolFengDieActivityCreate(AlipayMarketingToolFengDieActivityCreateModel alipayMarketingToolFengDieActivityCreateModel) {
        return callAlipayApi(alipayMarketingToolFengDieActivityCreateModel, "alipay.marketing.tool.fengdie.activity.create");
    }

    /**
     * 唤起凤蝶H5应用的编辑器
     *
     * @param alipayMarketingToolFengDieEditorQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingToolFengDieEditorQuery(AlipayMarketingToolFengDieEditorQueryModel alipayMarketingToolFengDieEditorQueryModel) {
        return callAlipayApi(alipayMarketingToolFengDieEditorQueryModel, "alipay.marketing.tool.fengdie.editor.query");
    }

    /**
     * 商户会员交易习惯查询接口
     *
     * @param koubeiMarketingDataTradeHabbitQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingDataTradeHabbitQuery(KoubeiMarketingDataTradeHabbitQueryModel koubeiMarketingDataTradeHabbitQueryModel) {
        return callAlipayApi(koubeiMarketingDataTradeHabbitQueryModel, "koubei.marketing.data.trade.habbit.query");
    }

    /**
     * 根据菜品类型查询菜品数据
     * TODO: model 未实现
     *
     * @param koubeiMarketingDataDishDiagnoseBatchQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingDataDishDiagnoseBatchQuery(KoubeiMarketingDataDishDiagnoseBatchQueryModel koubeiMarketingDataDishDiagnoseBatchQueryModel) {
        return callAlipayApi(koubeiMarketingDataDishDiagnoseBatchQueryModel, "koubei.marketing.data.dishdiagnose.batchquery");
    }

    /**
     * 菜品类型查询
     *
     * @param koubeiMarketingDataDishDiagnoseTypeBatchQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingDataDishDiagnoseTypeBatchQuery(KoubeiMarketingDataDishDiagnoseTypeBatchQueryModel koubeiMarketingDataDishDiagnoseTypeBatchQueryModel) {
        return callAlipayApi(koubeiMarketingDataDishDiagnoseTypeBatchQueryModel, "koubei.marketing.data.dishdiagnosetype.batchquery");
    }

    /**
     * 触发现金红包活动
     *
     * @param alipayMarketingCampaignCashTriggerModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCampaignCashTrigger(AlipayMarketingCampaignCashTriggerModel alipayMarketingCampaignCashTriggerModel) {
        return callAlipayApi(alipayMarketingCampaignCashTriggerModel, "alipay.marketing.campaign.cash.trigger");
    }

    /**
     * 更改现金活动状态
     *
     * @param alipayMarketingCampaignCashStatusModifyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCampaignCashStatusModify(AlipayMarketingCampaignCashStatusModifyModel alipayMarketingCampaignCashStatusModifyModel) {
        return callAlipayApi(alipayMarketingCampaignCashStatusModifyModel, "alipay.marketing.campaign.cash.status.modify");
    }

    /**
     * 现金活动列表查询
     *
     * @param alipayMarketingCampaignCashListQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCampaignCashListQuery(AlipayMarketingCampaignCashListQueryModel alipayMarketingCampaignCashListQueryModel) {
        return callAlipayApi(alipayMarketingCampaignCashListQueryModel, "alipay.marketing.campaign.cash.list.query");
    }

    /**
     * 现金活动详情查询
     *
     * @param alipayMarketingCampaignCashDetailQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCampaignCashDetailQuery(AlipayMarketingCampaignCashDetailQueryModel alipayMarketingCampaignCashDetailQueryModel) {
        return callAlipayApi(alipayMarketingCampaignCashDetailQueryModel, "alipay.marketing.campaign.cash.detail.query");
    }

    /**
     * 红包页面支付接口
     *
     * @param alipayFundCouponOrderPagePayModel
     * @return
     */
    public static Map<String, Object> alipayFundCouponOrderPagePay(AlipayFundCouponOrderPagePayModel alipayFundCouponOrderPagePayModel) {
        return callAlipayApi(alipayFundCouponOrderPagePayModel, "alipay.fund.coupon.order.page.pay");
    }

    /**
     * 红包无线支付接口
     *
     * @param alipayFundCouponOrderAppPayModel
     * @return
     */
    public static Map<String, Object> alipayFundCouponOrderAppPay(AlipayFundCouponOrderAppPayModel alipayFundCouponOrderAppPayModel) {
        return callAlipayApi(alipayFundCouponOrderAppPayModel, "alipay.fund.coupon.order.app.pay");
    }

    /**
     * 红包协议支付接口
     *
     * @param alipayFundCouponOrderAgreementPayModel
     * @return
     */
    public static Map<String, Object> alipayFundCouponOrderAgreementPay(AlipayFundCouponOrderAgreementPayModel alipayFundCouponOrderAgreementPayModel) {
        return callAlipayApi(alipayFundCouponOrderAgreementPayModel, "alipay.fund.coupon.order.agreement.pay");
    }

    /**
     * 红包打款接口
     *
     * @param alipayFundCouponOrderDisburseModel
     * @return
     */
    public static Map<String, Object> alipayFundCouponOrderDisburse(AlipayFundCouponOrderDisburseModel alipayFundCouponOrderDisburseModel) {
        return callAlipayApi(alipayFundCouponOrderDisburseModel, "alipay.fund.coupon.order.disburse");
    }

    /**
     * 红包退回接口
     *
     * @param alipayFundCouponOrderRefundModel
     * @return
     */
    public static Map<String, Object> alipayFundCouponOrderRefund(AlipayFundCouponOrderRefundModel alipayFundCouponOrderRefundModel) {
        return callAlipayApi(alipayFundCouponOrderRefundModel, "alipay.fund.coupon.order.refund");
    }

    /**
     * 红包明细查询接口
     *
     * @param alipayFundCouponOperationQueryModel
     * @return
     */
    public static Map<String, Object> alipayFundCouponOperationQuery(AlipayFundCouponOperationQueryModel alipayFundCouponOperationQueryModel) {
        return callAlipayApi(alipayFundCouponOperationQueryModel, "alipay.fund.coupon.operation.query");
    }

    /**
     * 一键营销商家中心PUSH消息接口
     *
     * @param koubeiMarketingDataMessageDeliverModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingDataMessageDeliver(KoubeiMarketingDataMessageDeliverModel koubeiMarketingDataMessageDeliverModel) {
        return callAlipayApi(koubeiMarketingDataMessageDeliverModel, "koubei.marketing.data.message.deliver");
    }

    /**
     * 活动下架接口
     *
     * @param koubeiMarketingCampaignActivityOfflineModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignActivityOffline(KoubeiMarketingCampaignActivityOfflineModel koubeiMarketingCampaignActivityOfflineModel) {
        return callAlipayApi(koubeiMarketingCampaignActivityOfflineModel, "koubei.marketing.campaign.activity.offline");
    }

    /**
     * 无资金券模板修改接口
     *
     * @param alipayMarketingCashLessVoucherTemplateModifyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCashLessVoucherTemplateModify(AlipayMarketingCashLessVoucherTemplateModifyModel alipayMarketingCashLessVoucherTemplateModifyModel) {
        return callAlipayApi(alipayMarketingCashLessVoucherTemplateModifyModel, "alipay.marketing.cashlessvoucher.template.modify");
    }

    /**
     * 券查询
     *
     * @param alipayMarketingVoucherQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingVoucherQuery(AlipayMarketingVoucherQueryModel alipayMarketingVoucherQueryModel) {
        return callAlipayApi(alipayMarketingVoucherQueryModel, "alipay.marketing.voucher.query");
    }

    /**
     * 发券接口
     *
     * @param alipayMarketingVoucherSendModel
     * @return
     */
    public static Map<String, Object> alipayMarketingVoucherSend(AlipayMarketingVoucherSendModel alipayMarketingVoucherSendModel) {
        return callAlipayApi(alipayMarketingVoucherSendModel, "alipay.marketing.voucher.send");
    }

    /**
     * 查询模板详情
     *
     * @param alipayMarketingVoucherTemplateDetailQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingVoucherTemplateDetailQuery(AlipayMarketingVoucherTemplateDetailQueryModel alipayMarketingVoucherTemplateDetailQueryModel) {
        return callAlipayApi(alipayMarketingVoucherTemplateDetailQueryModel, "alipay.marketing.voucher.templatedetail.query");
    }

    /**
     * 无资金券模板创建接口
     * TODO: model 未实现
     *
     * @param alipayMarketingCashLessVoucherTemplateCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCashLessVoucherTemplateCreate(AlipayMarketingCashLessVoucherTemplateCreateModel alipayMarketingCashLessVoucherTemplateCreateModel) {
        return callAlipayApi(alipayMarketingCashLessVoucherTemplateCreateModel, "alipay.marketing.cashlessvoucher.template.create");
    }

    /**
     * 商户使用场景规则PID查询
     *
     * @param alipayMarketingUseRulePidQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingUseRulePidQuery(AlipayMarketingUseRulePidQueryModel alipayMarketingUseRulePidQueryModel) {
        return callAlipayApi(alipayMarketingUseRulePidQueryModel, "alipay.marketing.userule.pid.query");
    }

    /**
     * 兑换券使用接口
     *
     * @param alipayMarketingExchangeVoucherUseModel
     * @return
     */
    public static Map<String, Object> alipayMarketingExchangeVoucherUse(AlipayMarketingExchangeVoucherUseModel alipayMarketingExchangeVoucherUseModel) {
        return callAlipayApi(alipayMarketingExchangeVoucherUseModel, "alipay.marketing.exchangevoucher.use");
    }

    /**
     * 查询券模板列表
     *
     * @param alipayMarketingVoucherTemplateListQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingVoucherTemplateListQuery(AlipayMarketingVoucherTemplateListQueryModel alipayMarketingVoucherTemplateListQueryModel) {
        return callAlipayApi(alipayMarketingVoucherTemplateListQueryModel, "alipay.marketing.voucher.templatelist.query");
    }

    /**
     * 查询券列表
     *
     * @param alipayMarketingVoucherListQueryModel
     * @return
     */
    public static Map<String, Object> alipayMarketingVoucherListQuery(AlipayMarketingVoucherListQueryModel alipayMarketingVoucherListQueryModel) {
        return callAlipayApi(alipayMarketingVoucherListQueryModel, "alipay.marketing.voucher.list.query");
    }

    /**
     * 删除券模板
     *
     * @param alipayMarketingVoucherTemplateDeleteModel
     * @return
     */
    public static Map<String, Object> alipayMarketingVoucherTemplateDelete(AlipayMarketingVoucherTemplateDeleteModel alipayMarketingVoucherTemplateDeleteModel) {
        return callAlipayApi(alipayMarketingVoucherTemplateDeleteModel, "alipay.marketing.voucher.template.delete");
    }

    /**
     * 修改券模板
     * TODO: model 未实现
     *
     * @param alipayMarketingCashVoucherTemplateModifyModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCashVoucherTemplateModify(AlipayMarketingCashVoucherTemplateModifyModel alipayMarketingCashVoucherTemplateModifyModel) {
        return callAlipayApi(alipayMarketingCashVoucherTemplateModifyModel, "alipay.marketing.cashvoucher.template.modify");
    }

    /**
     * 创建资金券模板
     *
     * @param alipayMarketingCashVoucherTemplateCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCashVoucherTemplateCreate(AlipayMarketingCashVoucherTemplateCreateModel alipayMarketingCashVoucherTemplateCreateModel) {
        return callAlipayApi(alipayMarketingCashVoucherTemplateCreateModel, "alipay.marketing.cashvoucher.template.create");
    }

    /**
     * 创建现金活动
     * TODO: model 未实现
     *
     * @param alipayMarketingCampaignCashCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingCampaignCashCreate(AlipayMarketingCampaignCashCreateModel alipayMarketingCampaignCashCreateModel) {
        return callAlipayApi(alipayMarketingCampaignCashCreateModel, "alipay.marketing.campaign.cash.create");
    }

    /**
     * 外部商户券码券核销
     *
     * @param alipayMarketingVoucherStockUseModel
     * @return
     */
    public static Map<String, Object> alipayMarketingVoucherStockUse(AlipayMarketingVoucherStockUseModel alipayMarketingVoucherStockUseModel) {
        return callAlipayApi(alipayMarketingVoucherStockUseModel, "alipay.marketing.voucher.stock.use");
    }

    /**
     * 口碑订单预咨询
     *
     * @param koubeiTradeOrderConsultModel
     * @return
     */
    public static Map<String, Object> koubeiTradeOrderConsult(KoubeiTradeOrderConsultModel koubeiTradeOrderConsultModel) {
        return callAlipayApi(koubeiTradeOrderConsultModel, "koubei.trade.order.consult");
    }

    /**
     * 小程序发送模板消息
     *
     * @param alipayOpenAppMiniTemplateMessageSendModel
     * @return
     */
    public static Map<String, Object> alipayOpenAppMiniTemplateMessageSend(AlipayOpenAppMiniTemplateMessageSendModel alipayOpenAppMiniTemplateMessageSendModel) {
        return callAlipayApi(alipayOpenAppMiniTemplateMessageSendModel, "alipay.open.app.mini.templatemessage.send");
    }

    /**
     * 用户口碑优惠资产查询接口
     *
     * @param koubeiMarketingCampaignUserAssetQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingCampaignUserAssetQuery(KoubeiMarketingCampaignUserAssetQueryModel koubeiMarketingCampaignUserAssetQueryModel) {
        return callAlipayApi(koubeiMarketingCampaignUserAssetQueryModel, "koubei.marketing.campaign.user.asset.query");
    }

    /**
     * 小程序生成推广二维码接口
     *
     * @param alipayOpenAppQRCodeCreateModel
     * @return
     */
    public static Map<String, Object> alipayOpenAppQRCodeCreate(AlipayOpenAppQRCodeCreateModel alipayOpenAppQRCodeCreateModel) {
        return callAlipayApi(alipayOpenAppQRCodeCreateModel, "alipay.open.app.qrcode.create");
    }

    /**
     * 当面付付款码解码
     *
     * @param alipayMarketingFaceToFaceDecodeUseModel
     * @return
     */
    public static Map<String, Object> alipayMarketingFaceToFaceDecodeUse(AlipayMarketingFaceToFaceDecodeUseModel alipayMarketingFaceToFaceDecodeUseModel) {
        return callAlipayApi(alipayMarketingFaceToFaceDecodeUseModel, "alipay.marketing.facetoface.decode.use");
    }

    /**
     * 商家给用户赠送彩票
     *
     * @param alipayCommerceLotteryPresentSendModel
     * @return
     */
    public static Map<String, Object> alipayCommerceLotteryPresentSend(AlipayCommerceLotteryPresentSendModel alipayCommerceLotteryPresentSendModel) {
        return callAlipayApi(alipayCommerceLotteryPresentSendModel, "alipay.commerce.lottery.present.send");
    }

    /**
     * 查询调用者指定时间范围内的彩票赠送列表
     *
     * @param alipayCommerceLotteryPresentListQueryModel
     * @return
     */
    public static Map<String, Object> alipayCommerceLotteryPresentListQuery(AlipayCommerceLotteryPresentListQueryModel alipayCommerceLotteryPresentListQueryModel) {
        return callAlipayApi(alipayCommerceLotteryPresentListQueryModel, "alipay.commerce.lottery.presentlist.query");
    }

    /**
     * 查询可用彩种列表
     *
     * @param alipayCommerceLotteryTypeListQueryModel
     * @return
     */
    public static Map<String, Object> alipayCommerceLotteryTypeListQuery(AlipayCommerceLotteryTypeListQueryModel alipayCommerceLotteryTypeListQueryModel) {
        return callAlipayApi(alipayCommerceLotteryTypeListQueryModel, "alipay.commerce.lottery.typelist.query");
    }

    /**
     * 口碑凭证码核销
     *
     * @param koubeiTradeTicketTicketCodeUseModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeUse(KoubeiTradeTicketTicketCodeUseModel koubeiTradeTicketTicketCodeUseModel) {
        return callAlipayApi(koubeiTradeTicketTicketCodeUseModel, "koubei.trade.ticket.ticketcode.use");
    }

    /**
     * 口碑凭证码同步
     * TODO: model 未实现
     *
     * @param koubeiTradeTicketTicketCodeSyncModel
     * @return
     */
    public static Map<String, Object> koubeiTradeTicketTicketCodeSync(KoubeiTradeTicketTicketCodeSyncModel koubeiTradeTicketTicketCodeSyncModel) {
        return callAlipayApi(koubeiTradeTicketTicketCodeSyncModel, "koubei.trade.ticket.ticketcode.sync");
    }

    /**
     * 创建云凤蝶空间
     *
     * @param alipayMarketingToolFengDieSpaceCreateModel
     * @return
     */
    public static Map<String, Object> alipayMarketingToolFengDieSpaceCreate(AlipayMarketingToolFengDieSpaceCreateModel alipayMarketingToolFengDieSpaceCreateModel) {
        return callAlipayApi(alipayMarketingToolFengDieSpaceCreateModel, "alipay.marketing.tool.fengdie.space.create");
    }

    /**
     * 商圈门店以及门店下面优惠券商品信息
     * TODO: model 未实现
     *
     * @param koubeiMarketingDataMallShopItemsQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingDataMallShopItemsQuery(KoubeiMarketingDataMallShopItemsQueryModel koubeiMarketingDataMallShopItemsQueryModel) {
        return callAlipayApi(koubeiMarketingDataMallShopItemsQueryModel, "koubei.marketing.data.mall.shopitems.query");
    }

    /**
     * 周边商圈查询
     * TODO: model 未实现
     *
     * @param koubeiMarketingDataNearMallQueryModel
     * @return
     */
    public static Map<String, Object> koubeiMarketingDataNearMallQuery(KoubeiMarketingDataNearMallQueryModel koubeiMarketingDataNearMallQueryModel) {
        return callAlipayApi(koubeiMarketingDataNearMallQueryModel, "koubei.marketing.data.nearmall.query");
    }

    /**
     * 营销规则分析
     *
     * @param alipayPromoRuleCenterRuleAnalyzeModel
     * @return
     */
    public static Map<String, Object> alipayPromoRuleCenterRuleAnalyze(AlipayPromoRuleCenterRuleAnalyzeModel alipayPromoRuleCenterRuleAnalyzeModel) {
        return callAlipayApi(alipayPromoRuleCenterRuleAnalyzeModel, "alipay.promorulecenter.rule.analyze");
    }
    /***************************************************************营销API结束***************************************************************/
}
