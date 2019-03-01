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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AlipayUtils {
    private static final String ALIPAY_GATEWAY_URL = "https://openapi.alipay.com/gateway.do";
    private static final String ALIPAY_APP_TO_APP_AUTHORIZE_URL = "https://openauth.alipay.com/oauth2/appToAppAuth.htm";

    public static boolean verifySign(String originalString, String signType, String sign, String charset, String alipayPublicKey) {
        if (Constants.RSA.equals(signType)) {
            signType = SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA;
        } else if (Constants.RSA2.equals(signType)) {
            signType = SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA;
        }

        byte[] data = org.apache.commons.codec.binary.StringUtils.getBytesUnchecked(originalString, charset);
        return SignatureUtils.verifySign(data, Base64.decodeBase64(alipayPublicKey), Base64.decodeBase64(sign), signType);
    }

    public static AlipayAccount obtainAlipayAccount(String tenantId, String branchId) {
        String alipayAccountJson = CacheUtils.hget(Constants.KEY_ALIPAY_ACCOUNTS, tenantId + "_" + branchId);
        AlipayAccount alipayAccount = null;
        if (StringUtils.isNotBlank(alipayAccountJson)) {
            alipayAccount = GsonUtils.fromJson(alipayAccountJson, AlipayAccount.class);
        }
        return alipayAccount;
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

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String format, String returnUrl, String charset, String notifyUrl, String appAuthToken, String bizContent) {
        String signType = alipayAccount.getSignType();
        BuildRequestBodyModel buildRequestBodyModel = BuildRequestBodyModel.builder()
                .appId(alipayAccount.getAppId())
                .method(method)
                .format(format)
                .returnUrl(returnUrl)
                .charset(charset)
                .signType(signType)
                .notifyUrl(notifyUrl)
                .appAuthToken(appAuthToken)
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

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String returnUrl, String notifyUrl, String appAuthToken, String bizContent) {
        return callAlipayApi(alipayAccount, method, Constants.JSON, returnUrl, Constants.UTF_8, notifyUrl, appAuthToken, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String notifyUrl, String appAuthToken, String bizContent) {
        return callAlipayApi(alipayAccount, method, Constants.JSON, null, Constants.UTF_8, notifyUrl, appAuthToken, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String appAuthToken, String bizContent) {
        return callAlipayApi(alipayAccount, method, Constants.JSON, null, Constants.UTF_8, null, appAuthToken, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String bizContent) {
        return callAlipayApi(alipayAccount, method, Constants.JSON, null, Constants.UTF_8, null, null, bizContent);
    }

    public static Map<String, String> buildRequestParameters(String appId, String method, String format, String returnUrl, String charset, String signType, String notifyUrl, String appAuthToken, String bizContent, String privateKey) {
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

    public static String buildRequestBody(String appId, String method, String format, String returnUrl, String charset, String signType, String notifyUrl, String appAuthToken, String bizContent, String privateKey) {
        Map<String, String> requestParameters = buildRequestParameters(appId, method, format, returnUrl, charset, signType, notifyUrl, appAuthToken, bizContent, privateKey);
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
        String appAuthToken = buildRequestBodyModel.getAppAuthToken();
        String bizContent = buildRequestBodyModel.getBizContent();
        String privateKey = buildRequestBodyModel.getPrivateKey();
        return buildRequestBody(appId, method, format, returnUrl, charset, signType, notifyUrl, appAuthToken, bizContent, privateKey);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String format, String returnUrl, String charset, String notifyUrl, String bizContent) {
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

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String returnUrl, String notifyUrl, String bizContent) {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, returnUrl, Constants.CHARSET_NAME_UTF_8, notifyUrl, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String notifyUrl, String bizContent) {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, null, Constants.CHARSET_NAME_UTF_8, notifyUrl, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String bizContent) {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, null, Constants.CHARSET_NAME_UTF_8, null, bizContent);
    }

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

    public static Map<String, Object> alipayTradeRefund(AlipayTradeRefundModel alipayTradeRefundModel) {
        alipayTradeRefundModel.validateAndThrow();

        String tenantId = alipayTradeRefundModel.getTenantId();
        String branchId = alipayTradeRefundModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.refund", JacksonUtils.writeValueAsString(alipayTradeRefundModel, JsonInclude.Include.NON_NULL));
    }

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
            ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");
        }
        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.shop.create", NotifyUtils.obtainAlipayNotifyUrl(), JacksonUtils.writeValueAsString(alipayOfflineMarketShopCreateModel, JsonInclude.Include.NON_NULL));
    }

    public static Map<String, Object> alipayOfflineMaterialImageUpload(AlipayOfflineMaterialImageUploadModel alipayOfflineMaterialImageUploadModel) {
        alipayOfflineMaterialImageUploadModel.validateAndThrow();

        String tenantId = alipayOfflineMaterialImageUploadModel.getTenantId();
        String branchId = alipayOfflineMaterialImageUploadModel.getBranchId();

        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");

        return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.material.image.upload", JacksonUtils.writeValueAsString(alipayOfflineMaterialImageUploadModel, JsonInclude.Include.NON_NULL));
    }

    public static String generateAppToAppAuthorizeUrl(String tenantId, String branchId, String redirectUri) {
        AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
        ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
        return ALIPAY_APP_TO_APP_AUTHORIZE_URL + "?app_id=" + alipayAccount.getAppId() + "&redirect_uri=" + UrlUtils.encode(redirectUri, Constants.CHARSET_NAME_UTF_8);
    }

    public static String generatePublicAppAuthorizeUrl(String tenantId, String branchId, String scope, String redirectUri, String state) {
        AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
        ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");

        StringBuilder publicAppAuthorizeUrl = new StringBuilder();
        publicAppAuthorizeUrl.append(ConfigurationUtils.getConfiguration(Constants.ALIPAY_PUBLIC_APP_AUTHORIZE_URL));
        publicAppAuthorizeUrl.append("?app_id=").append(alipayAccount.getAppId());
        publicAppAuthorizeUrl.append("&scope=").append(scope);
        publicAppAuthorizeUrl.append("&redirect_uri=").append(UrlUtils.encode(redirectUri, Constants.CHARSET_NAME_UTF_8));
        if (StringUtils.isNotBlank(state)) {
            publicAppAuthorizeUrl.append("&state=").append(state);
        }
        return publicAppAuthorizeUrl.toString();
    }

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

    public static Map<String, Object> aftAiFinFireEyeOcrImageQuery(AftAiFinFireEyeOcrImageQueryModel aftAiFinFireEyeOcrImageQueryModel) {
        String tenantId = aftAiFinFireEyeOcrImageQueryModel.getTenantId();
        String branchId = aftAiFinFireEyeOcrImageQueryModel.getBranchId();
        AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
        ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");
        return callAlipayApi(alipayAuthorizerInfo, "aft.aifin.fireeye.ocr.image.query", JacksonUtils.writeValueAsString(aftAiFinFireEyeOcrImageQueryModel));
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
        ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");

        return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.payee.bind.create", JacksonUtils.writeValueAsString(alipayOpenPublicPayeeBindCreateModel));
    }

    /**
     * 换取应用授权令牌
     *
     * @param alipayOpenAuthTokenAppModel
     * @return
     */
    public static AlipayAuthorizerInfo alipayOpenAuthTokenApp(AlipayOpenAuthTokenAppModel alipayOpenAuthTokenAppModel) {
        String tenantId = alipayOpenAuthTokenAppModel.getTenantId();
        String branchId = alipayOpenAuthTokenAppModel.getBranchId();
        AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
        ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
        Map<String, Object> resultMap = callAlipayApi(alipayAccount, "alipay.open.auth.token.app", JacksonUtils.writeValueAsString(alipayOpenAuthTokenAppModel, JsonInclude.Include.NON_NULL));

        AlipayAuthorizerInfo alipayAuthorizerInfo = new AlipayAuthorizerInfo();
        alipayAuthorizerInfo.setAppId(alipayAccount.getAppId());
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
}
