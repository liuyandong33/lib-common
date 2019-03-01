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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AlipayUtils {
    private static final String ALIPAY_GATEWAY_URL = "https://openapi.alipay.com/gateway.do";
    private static final String ALIPAY_APP_TO_APP_AUTHORIZE_URL = "https://openauth.alipay.com/oauth2/appToAppAuth.htm";

    public static boolean verifySign(String originalString, String signType, String sign, String charset, String alipayPublicKey) throws IOException {
        if (Constants.RSA.equals(signType)) {
            signType = SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA;
        } else if (Constants.RSA2.equals(signType)) {
            signType = SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA;
        }
        return SignatureUtils.verifySign(originalString.getBytes(charset), Base64.decodeBase64(alipayPublicKey), Base64.decodeBase64(sign), signType);
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

    public static String buildRequestBody(AlipayAccount alipayAccount, String method, String format, String returnUrl, String charset, String notifyUrl, String appAuthToken, String bizContent) throws UnsupportedEncodingException {
        Map<String, String> requestParameters = buildRequestParameters(alipayAccount, method, format, returnUrl, charset, notifyUrl, appAuthToken, bizContent);
        return WebUtils.buildRequestBody(requestParameters, charset);
    }

    public static Map<String, String> buildRequestParameters(AlipayAccount alipayAccount, String method, String format, String returnUrl, String charset, String notifyUrl, String appAuthToken, String bizContent) throws UnsupportedEncodingException {
        String signType = alipayAccount.getSignType();

        Map<String, String> sortedRequestParameters = new TreeMap<String, String>();
        sortedRequestParameters.put("app_id", alipayAccount.getAppId());
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

        if (StringUtils.isNotBlank(appAuthToken)) {
            sortedRequestParameters.put("app_auth_token", appAuthToken);
        }
        sortedRequestParameters.put("biz_content", bizContent);

        String sign = Base64.encodeBase64String(SignatureUtils.sign(WebUtils.concat(sortedRequestParameters).getBytes(Constants.CHARSET_NAME_UTF_8), Base64.decodeBase64(alipayAccount.getApplicationPrivateKey()), SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA));
        sortedRequestParameters.put("sign", sign);
        return sortedRequestParameters;
    }

    public static String callAlipayApi(String requestBody) {
        WebResponse webResponse = OutUtils.doPostWithRequestBody(ALIPAY_GATEWAY_URL, null, requestBody);
        return webResponse.getResult();
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String format, String returnUrl, String charset, String notifyUrl, String appAuthToken, String bizContent) throws IOException {
        String requestBody = buildRequestBody(alipayAccount, method, format, returnUrl, charset, notifyUrl, appAuthToken, bizContent);

        String result = callAlipayApi(requestBody);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        Map<String, Object> responseMap = MapUtils.getMap(resultMap, method.replaceAll("\\.", "_") + "_response");

        ValidateUtils.isTrue(verifySign(GsonUtils.toJson(responseMap), alipayAccount.getSignType(), MapUtils.getString(resultMap, "sign"), charset, alipayAccount.getAlipayPublicKey()), "支付宝返回结果签名验证未通过！");

        String code = MapUtils.getString(responseMap, "code");
        String msg = MapUtils.getString(responseMap, "msg");
        ValidateUtils.isTrue("10000".equals(code), msg);

        if (responseMap.containsKey("sub_code")) {
            ValidateUtils.isTrue(false, MapUtils.getString(responseMap, "sub_msg"));
        }
        return responseMap;
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String returnUrl, String notifyUrl, String appAuthToken, String bizContent) throws IOException {
        return callAlipayApi(alipayAccount, method, Constants.JSON, returnUrl, Constants.UTF_8, notifyUrl, appAuthToken, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String notifyUrl, String appAuthToken, String bizContent) throws IOException {
        return callAlipayApi(alipayAccount, method, Constants.JSON, null, Constants.UTF_8, notifyUrl, appAuthToken, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String appAuthToken, String bizContent) throws IOException {
        return callAlipayApi(alipayAccount, method, Constants.JSON, null, Constants.UTF_8, null, appAuthToken, bizContent);
    }

    public static String buildRequestBody(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String format, String returnUrl, String charset, String signType, String notifyUrl, String bizContent) throws UnsupportedEncodingException {
        Map<String, String> requestParameters = buildRequestParameters(alipayAuthorizerInfo, method, format, returnUrl, charset, signType, notifyUrl, bizContent);
        return WebUtils.buildRequestBody(requestParameters, charset);
    }

    public static Map<String, String> buildRequestParameters(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String format, String returnUrl, String charset, String signType, String notifyUrl, String bizContent) throws UnsupportedEncodingException {
        String appId = alipayAuthorizerInfo.getAppId();
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>();
        sortedRequestParameters.put("app_id", alipayAuthorizerInfo.getAppId());
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

        sortedRequestParameters.put("app_auth_token", alipayAuthorizerInfo.getAppAuthToken());
        sortedRequestParameters.put("biz_content", bizContent);

        String privateKey = ConfigurationUtils.getConfiguration(appId + "." + Constants.ALIPAY_APPLICATION_PRIVATE_KEY);
        String sign = Base64.encodeBase64String(SignatureUtils.sign(WebUtils.concat(sortedRequestParameters).getBytes(Constants.CHARSET_NAME_UTF_8), Base64.decodeBase64(privateKey), SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA));
        sortedRequestParameters.put("sign", sign);
        return sortedRequestParameters;
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String format, String returnUrl, String charset, String notifyUrl, String bizContent) throws IOException {
        AlipayAccount alipayAccount = obtainAlipayAccount(alipayAuthorizerInfo.getAppId());
        String signType = alipayAccount.getSignType();

        String requestBody = buildRequestBody(alipayAuthorizerInfo, method, format, returnUrl, charset, signType, notifyUrl, bizContent);
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

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String returnUrl, String notifyUrl, String bizContent) throws IOException {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, returnUrl, Constants.CHARSET_NAME_UTF_8, notifyUrl, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String notifyUrl, String bizContent) throws IOException {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, null, Constants.CHARSET_NAME_UTF_8, notifyUrl, bizContent);
    }

    public static Map<String, Object> callAlipayApi(AlipayAuthorizerInfo alipayAuthorizerInfo, String method, String bizContent) throws IOException {
        return callAlipayApi(alipayAuthorizerInfo, method, Constants.JSON, null, Constants.CHARSET_NAME_UTF_8, null, bizContent);
    }

    public static Map<String, Object> alipayTradePay(AlipayTradePayModel alipayTradePayModel) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String alipayTradeWapPay(AlipayTradeWapPayModel alipayTradeWapPayModel) {
        try {
            alipayTradeWapPayModel.validateAndThrow();

            String tenantId = alipayTradeWapPayModel.getTenantId();
            String branchId = alipayTradeWapPayModel.getBranchId();
            String returnUrl = alipayTradeWapPayModel.getReturnUrl();
            String notifyUrl = alipayTradeWapPayModel.getNotifyUrl();

            AlipayAuthorizerInfo alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayTradeWapPayModel.getOutTradeNo(), notifyUrl);
            String signType = ConfigurationUtils.getConfiguration(alipayAuthorizerInfo.getAppId() + "." + Constants.ALIPAY_SIGN_TYPE);

            return ALIPAY_GATEWAY_URL + "?" + buildRequestBody(alipayAuthorizerInfo, "alipay.trade.wap.pay", Constants.JSON, returnUrl, Constants.UTF_8, signType, NotifyUtils.obtainAlipayNotifyUrl(), JacksonUtils.writeValueAsString(alipayTradeWapPayModel, JsonInclude.Include.NON_NULL));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String alipayTradePagePay(AlipayTradePagePayModel alipayTradePagePayModel) {
        try {
            alipayTradePagePayModel.validateAndThrow();

            String tenantId = alipayTradePagePayModel.getTenantId();
            String branchId = alipayTradePagePayModel.getBranchId();
            String returnUrl = alipayTradePagePayModel.getReturnUrl();
            String notifyUrl = alipayTradePagePayModel.getNotifyUrl();

            AlipayAuthorizerInfo alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayTradePagePayModel.getOutTradeNo(), notifyUrl);
            String signType = ConfigurationUtils.getConfiguration(alipayAuthorizerInfo.getAppId() + "." + Constants.ALIPAY_SIGN_TYPE);

            return ALIPAY_GATEWAY_URL + "?" + buildRequestBody(alipayAuthorizerInfo, "alipay.trade.page.pay", Constants.JSON, returnUrl, Constants.CHARSET_NAME_UTF_8, signType, NotifyUtils.obtainAlipayNotifyUrl(), JacksonUtils.writeValueAsString(alipayTradePagePayModel, JsonInclude.Include.NON_NULL));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> alipayTradeRefund(String tenantId, String branchId, AlipayTradeRefundModel alipayTradeRefundModel) {
        try {
            alipayTradeRefundModel.validateAndThrow();
            AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
            return callAlipayApi(alipayAuthorizerInfo, "alipay.trade.refund", JacksonUtils.writeValueAsString(alipayTradeRefundModel, JsonInclude.Include.NON_NULL));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public static Map<String, Object> alipayOfflineMarketShopCreate(String tenantId, String branchId, String notifyUrl, AlipayOfflineMarketShopCreateModel alipayOfflineMarketShopCreateModel) {
        try {
            alipayOfflineMarketShopCreateModel.validateAndThrow();
            AlipayAuthorizerInfo alipayAuthorizerInfo = null;
            if (StringUtils.isNotBlank(notifyUrl)) {
                alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayOfflineMarketShopCreateModel.getStoreId(), notifyUrl);
            } else {
                alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
                ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");
            }
            return callAlipayApi(alipayAuthorizerInfo, "alipay.offline.market.shop.create", NotifyUtils.obtainAlipayNotifyUrl(), JacksonUtils.writeValueAsString(alipayOfflineMarketShopCreateModel, JsonInclude.Include.NON_NULL));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> alipayOfflineMaterialImageUpload(String tenantId, String branchId, String appAuthToken, AlipayOfflineMaterialImageUploadModel alipayOfflineMaterialImageUploadModel) {
        try {
            AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
            ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
            Map<String, String> requestParameters = buildRequestParameters(alipayAccount, "alipay.offline.material.image.upload", Constants.JSON, null, Constants.UTF_8, null, appAuthToken, null);

            return callAlipayApi(alipayAccount, "alipay.offline.material.image.upload", null, appAuthToken, GsonUtils.toJson(alipayOfflineMaterialImageUploadModel, false));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateAppToAppAuthorizeUrl(String tenantId, String branchId, String redirectUri) throws IOException {
        AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
        ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
        return ALIPAY_APP_TO_APP_AUTHORIZE_URL + "?app_id=" + alipayAccount.getAppId() + "&redirect_uri=" + URLEncoder.encode(redirectUri, Constants.CHARSET_NAME_UTF_8);
    }

    public static String generatePublicAppAuthorizeUrl(String tenantId, String branchId, String scope, String redirectUri, String state) throws IOException {
        AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
        ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");

        StringBuilder publicAppAuthorizeUrl = new StringBuilder();
        publicAppAuthorizeUrl.append(ConfigurationUtils.getConfiguration(Constants.ALIPAY_PUBLIC_APP_AUTHORIZE_URL));
        publicAppAuthorizeUrl.append("?app_id=").append(alipayAccount.getAppId());
        publicAppAuthorizeUrl.append("&scope=").append(scope);
        publicAppAuthorizeUrl.append("&redirect_uri=").append(URLEncoder.encode(redirectUri, Constants.CHARSET_NAME_UTF_8));
        if (StringUtils.isNotBlank(state)) {
            publicAppAuthorizeUrl.append("&state=").append(state);
        }
        return publicAppAuthorizeUrl.toString();
    }

    public static String alipayTradeAppPay(AlipayTradeAppPayModel alipayTradeAppPayModel) {
        try {
            String tenantId = alipayTradeAppPayModel.getTenantId();
            String branchId = alipayTradeAppPayModel.getBranchId();
            String notifyUrl = alipayTradeAppPayModel.getNotifyUrl();

            AlipayAuthorizerInfo alipayAuthorizerInfo = saveNotifyRecord(tenantId, branchId, alipayTradeAppPayModel.getOutTradeNo(), notifyUrl);
            String signType = ConfigurationUtils.getConfiguration(alipayAuthorizerInfo.getAppId() + "." + Constants.ALIPAY_SIGN_TYPE);

            return buildRequestBody(alipayAuthorizerInfo, "alipay.trade.app.pay", Constants.JSON, null, Constants.CHARSET_NAME_UTF_8, signType, NotifyUtils.obtainAlipayNotifyUrl(), JacksonUtils.writeValueAsString(alipayTradeAppPayModel, JsonInclude.Include.NON_NULL));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> aftAiFinFireEyeOcrImageQuery(AftAiFinFireEyeOcrImageQueryModel aftAiFinFireEyeOcrImageQueryModel) {
        try {
            String tenantId = aftAiFinFireEyeOcrImageQueryModel.getTenantId();
            String branchId = aftAiFinFireEyeOcrImageQueryModel.getBranchId();
            AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
            ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");
            return callAlipayApi(alipayAuthorizerInfo, "aft.aifin.fireeye.ocr.image.query", JacksonUtils.writeValueAsString(aftAiFinFireEyeOcrImageQueryModel));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加收款账号接口
     * 允许开发者调用该接口将收款账号与当前生活号绑定，从而支持支付成功页引导推荐关注生活号
     *
     * @return
     */
    public static Map<String, Object> alipayOpenPublicPayeeBindCreate(AlipayOpenPublicPayeeBindCreateModel alipayOpenPublicPayeeBindCreateModel) {
        try {
            String tenantId = alipayOpenPublicPayeeBindCreateModel.getTenantId();
            String branchId = alipayOpenPublicPayeeBindCreateModel.getBranchId();
            AlipayAuthorizerInfo alipayAuthorizerInfo = obtainAlipayAuthorizerInfo(tenantId, branchId);
            ValidateUtils.notNull(alipayAuthorizerInfo, "未配置支付宝账号！");

            return callAlipayApi(alipayAuthorizerInfo, "alipay.open.public.payee.bind.create", JacksonUtils.writeValueAsString(alipayOpenPublicPayeeBindCreateModel));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 换取应用授权令牌
     *
     * @param alipayOpenAuthTokenAppModel
     * @return
     */
    public static AlipayAuthorizerInfo alipayOpenAuthTokenApp(AlipayOpenAuthTokenAppModel alipayOpenAuthTokenAppModel) {
        try {
            String tenantId = alipayOpenAuthTokenAppModel.getTenantId();
            String branchId = alipayOpenAuthTokenAppModel.getBranchId();
            AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
            ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
            Map<String, Object> resultMap = callAlipayApi(alipayAccount, "alipay.open.auth.token.app", null, JacksonUtils.writeValueAsString(alipayOpenAuthTokenAppModel, JsonInclude.Include.NON_NULL));

            AlipayAuthorizerInfo alipayAuthorizerInfo = new AlipayAuthorizerInfo();
            alipayAuthorizerInfo.setAppId(alipayAccount.getAppId());
            alipayAuthorizerInfo.setAppAuthToken(MapUtils.getString(resultMap, "app_auth_token"));
            alipayAuthorizerInfo.setUserId(MapUtils.getString(resultMap, "user_id"));
            alipayAuthorizerInfo.setAuthAppId(MapUtils.getString(resultMap, "auth_app_id"));
            alipayAuthorizerInfo.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
            alipayAuthorizerInfo.setReExpiresIn(MapUtils.getIntValue(resultMap, "re_expires_in"));
            alipayAuthorizerInfo.setAppRefreshToken(MapUtils.getString(resultMap, "app_refresh_token"));
            return alipayAuthorizerInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
}
