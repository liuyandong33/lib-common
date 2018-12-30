package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.exceptions.ApiException;
import build.dream.common.models.alipay.*;
import build.dream.common.models.notify.SaveNotifyRecordModel;
import build.dream.common.saas.domains.AlipayAccount;
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
        String alipayGatewayUrl = ConfigurationUtils.getConfiguration(Constants.ALIPAY_GATEWAY_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(alipayGatewayUrl, null, requestBody);
        return webResponse.getResult();
    }

    public static String callAlipayApi(Map<String, Object> requestParameters) {
        String alipayGatewayUrl = ConfigurationUtils.getConfiguration(Constants.ALIPAY_GATEWAY_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParametersAndFiles(alipayGatewayUrl, null, requestParameters);
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

    public static Map<String, Object> callAlipayApi(AlipayAccount alipayAccount, String method, String notifyUrl, String appAuthToken, String bizContent) throws IOException {
        return callAlipayApi(alipayAccount, method, Constants.JSON, null, Constants.UTF_8, notifyUrl, appAuthToken, bizContent);
    }

    public static Map<String, Object> alipayTradePay(AlipayTradePayModel alipayTradePayModel) {
        try {
            alipayTradePayModel.validateAndThrow();

            String tenantId = alipayTradePayModel.getTenantId();
            String branchId = alipayTradePayModel.getBranchId();
            String notifyUrl = alipayTradePayModel.getNotifyUrl();
            String appAuthToken = alipayTradePayModel.getAppAuthToken();

            AlipayAccount alipayAccount = null;
            if (StringUtils.isNotBlank(notifyUrl)) {
                alipayAccount = saveNotifyRecord(tenantId, branchId, alipayTradePayModel.getOutTradeNo(), notifyUrl);
            } else {
                alipayAccount = obtainAlipayAccount(tenantId, branchId);
                ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
            }
            return callAlipayApi(alipayAccount, "alipay.trade.pay", NotifyUtils.obtainAlipayNotifyUrl(), appAuthToken, JacksonUtils.writeValueAsString(alipayTradePayModel, JsonInclude.Include.NON_NULL));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static String alipayTradeWapPay(AlipayTradeWapPayModel alipayTradeWapPayModel) {
        try {
            alipayTradeWapPayModel.validateAndThrow();

            String tenantId = alipayTradeWapPayModel.getTenantId();
            String branchId = alipayTradeWapPayModel.getBranchId();
            String returnUrl = alipayTradeWapPayModel.getReturnUrl();
            String notifyUrl = alipayTradeWapPayModel.getNotifyUrl();
            AlipayAccount alipayAccount = saveNotifyRecord(tenantId, branchId, alipayTradeWapPayModel.getOutTradeNo(), notifyUrl);
            return ConfigurationUtils.getConfiguration(Constants.ALIPAY_GATEWAY_URL) + "?" + buildRequestBody(alipayAccount, "alipay.trade.wap.pay", Constants.JSON, returnUrl, Constants.UTF_8, NotifyUtils.obtainAlipayNotifyUrl(), null, JacksonUtils.writeValueAsString(alipayTradeWapPayModel, JsonInclude.Include.NON_NULL));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static Map<String, Object> alipayTradePagePay(AlipayTradePagePayModel alipayTradePagePayModel) {
        try {
            String tenantId = alipayTradePagePayModel.getTenantId();
            String branchId = alipayTradePagePayModel.getBranchId();
            String returnUrl = alipayTradePagePayModel.getReturnUrl();
            String notifyUrl = alipayTradePagePayModel.getNotifyUrl();
            String appAuthToken = alipayTradePagePayModel.getAppAuthToken();
            AlipayAccount alipayAccount = saveNotifyRecord(tenantId, branchId, alipayTradePagePayModel.getOutTradeNo(), notifyUrl);
            return callAlipayApi(alipayAccount, "alipay.trade.page.pay", Constants.JSON, returnUrl, Constants.CHARSET_NAME_UTF_8, NotifyUtils.obtainAlipayNotifyUrl(), appAuthToken, JacksonUtils.writeValueAsString(alipayTradePagePayModel, JsonInclude.Include.NON_NULL));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static Map<String, Object> alipayTradeRefund(String tenantId, String branchId, String appAuthToken, AlipayTradeRefundModel alipayTradeRefundModel) {
        try {
            alipayTradeRefundModel.validateAndThrow();
            AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
            return callAlipayApi(alipayAccount, "alipay.trade.refund", null, appAuthToken, GsonUtils.toJson(alipayTradeRefundModel, false));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private static AlipayAccount saveNotifyRecord(String tenantId, String branchId, String uuid, String notifyUrl) {
        AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
        ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");

        String serviceName = ConfigurationUtils.getConfiguration(Constants.SERVICE_NAME);
        if (Constants.SERVICE_NAME_PLATFORM.equals(serviceName)) {
            SaveNotifyRecordModel saveNotifyRecordModel = SaveNotifyRecordModel.builder()
                    .uuid(uuid)
                    .notifyUrl(notifyUrl)
                    .alipayPublicKey(alipayAccount.getAlipayPublicKey())
                    .alipaySignType(alipayAccount.getSignType())
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
            saveNotifyRecordRequestParameters.put("alipayPublicKey", alipayAccount.getAlipayPublicKey());
            saveNotifyRecordRequestParameters.put("alipaySignType", alipayAccount.getSignType());

            ApiRest saveNotifyRecordResult = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "notify", "saveNotifyRecord", saveNotifyRecordRequestParameters);
            ValidateUtils.isTrue(saveNotifyRecordResult.isSuccessful(), saveNotifyRecordResult.getError());
        }

        return alipayAccount;
    }

    public static Map<String, Object> alipayOfflineMarketShopCreate(String tenantId, String branchId, String notifyUrl, String appAuthToken, AlipayOfflineMarketShopCreateModel alipayOfflineMarketShopCreateModel) {
        try {
            alipayOfflineMarketShopCreateModel.validateAndThrow();
            AlipayAccount alipayAccount = null;
            if (StringUtils.isNotBlank(notifyUrl)) {
                alipayAccount = saveNotifyRecord(tenantId, branchId, alipayOfflineMarketShopCreateModel.getStoreId(), notifyUrl);
            } else {
                alipayAccount = obtainAlipayAccount(tenantId, branchId);
                ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
            }
            return callAlipayApi(alipayAccount, "alipay.offline.market.shop.create", NotifyUtils.obtainAlipayNotifyUrl(), appAuthToken, GsonUtils.toJson(alipayOfflineMarketShopCreateModel, false));

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
        String appToAppAuthorizeUrl = ConfigurationUtils.getConfiguration(Constants.ALIPAY_APP_TO_APP_AUTHORIZE_URL);
        return appToAppAuthorizeUrl + "?app_id=" + alipayAccount.getAppId() + "&redirect_uri=" + URLEncoder.encode(redirectUri, Constants.CHARSET_NAME_UTF_8);
    }

    public static Map<String, Object> alipayOpenAuthTokenApp(String tenantId, String branchId, AlipayOpenAuthTokenAppModel alipayOpenAuthTokenAppModel) {
        try {
            AlipayAccount alipayAccount = obtainAlipayAccount(tenantId, branchId);
            ValidateUtils.notNull(alipayAccount, "未配置支付宝账号！");
            return callAlipayApi(alipayAccount, "alipay.open.auth.token.app", null, null, GsonUtils.toJson(alipayOpenAuthTokenAppModel, false));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
}
