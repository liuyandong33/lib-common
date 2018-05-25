package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.alipay.AlipayTradePayModel;
import build.dream.common.models.alipay.AlipayTradeWapPayModel;
import build.dream.common.saas.domains.AlipayAccount;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class AlipayUtils {
    public static String generateAlipaySystemOauthUrl(String appId, String scope, String redirectUri, String state) throws IOException {
        StringBuilder alipaySystemOauthUrl = new StringBuilder();
        alipaySystemOauthUrl.append(ConfigurationUtils.getConfiguration(Constants.ALIPAY_PUBLIC_APP_AUTHORIZE_URL));
        alipaySystemOauthUrl.append("?").append("app_id=").append(appId);
        alipaySystemOauthUrl.append("&scope=").append(scope);
        alipaySystemOauthUrl.append("&redirect_uri=").append(URLEncoder.encode(redirectUri, Constants.CHARSET_NAME_UTF_8));
        if (StringUtils.isNotBlank(state)) {
            alipaySystemOauthUrl.append("&state=").append(state);
        }
        return alipaySystemOauthUrl.toString();
    }

    public static boolean verifySign(String originalString, String signType, String sign, String charset, String alipayPublicKey) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (Constants.RSA.equals(signType)) {
            signType = SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA;
        } else if (Constants.RSA2.equals(signType)) {
            signType = SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA;
        }
        return SignatureUtils.verifySign(originalString.getBytes(charset), Base64.decodeBase64(alipayPublicKey), Base64.decodeBase64(sign), signType);
    }

    public static AlipayAccount obtainAlipayAccount(String appId) {
        String alipayAccountJson = CacheUtils.hget(Constants.KEY_ALIPAY_ACCOUNTS, appId);
        AlipayAccount alipayAccount = null;
        if (StringUtils.isNotBlank(alipayAccountJson)) {
            alipayAccount = GsonUtils.fromJson(alipayAccountJson, AlipayAccount.class);
        }
        return alipayAccount;
    }

    public static String buildRequestBody(AlipayAccount alipayAccount, String method, String format, String returnUrl, String charset, String notifyUrl, String appAuthToken, String bizContent) throws UnsupportedEncodingException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
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
        return WebUtils.buildRequestBody(sortedRequestParameters, charset);
    }

    public static String buildRequestBody(String appId, String method, String format, String returnUrl, String charset, String notifyUrl, String appAuthToken, String bizContent) throws UnsupportedEncodingException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        AlipayAccount alipayAccount = obtainAlipayAccount(appId);
        Validate.notNull(alipayAccount, "未配置支付宝账号！");

        return buildRequestBody(alipayAccount, method, format, returnUrl, charset, notifyUrl, appAuthToken, bizContent);
    }

    public static JSONObject callAlipayApi(String appId, String method, String format, String charset, String notifyUrl, String appAuthToken, String bizContent) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        AlipayAccount alipayAccount = obtainAlipayAccount(appId);
        Validate.notNull(alipayAccount, "未配置支付宝账号！");

        String requestBody = buildRequestBody(appId, method, format, null, charset, notifyUrl, appAuthToken, bizContent);

        String alipayGatewayUrl = "https://openapi.alipay.com/gateway.do";
        String result = OutUtils.doPost(alipayGatewayUrl, requestBody, null);

        JSONObject resultJsonObject = JSONObject.fromObject(result);
        JSONObject responseJsonObject = resultJsonObject.getJSONObject(method.replaceAll("\\.", "_") + "_response");

        Validate.isTrue(verifySign(responseJsonObject.toString(), alipayAccount.getSignType(), resultJsonObject.getString("sign"), charset, alipayAccount.getAlipayPublicKey()), "支付宝返回结果签名验证未通过！");

        String code = responseJsonObject.getString("code");
        String msg = responseJsonObject.getString("msg");
        Validate.isTrue("10000".equals(code), msg);

        if (responseJsonObject.has("sub_code")) {
            Validate.isTrue(false, responseJsonObject.getString("sub_msg"));
        }
        return responseJsonObject;
    }

    public static JSONObject callAlipayApi(String appId, String method, String notifyUrl, String appAuthToken, String bizContent) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        return callAlipayApi(appId, method, Constants.JSON, Constants.UTF_8, notifyUrl, appAuthToken, bizContent);
    }

    public static JSONObject alipayTradePay(String appId, String notifyUrl, String appAuthToken, AlipayTradePayModel alipayTradePayModel) throws InvalidKeySpecException, SignatureException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        alipayTradePayModel.validateAndThrow();
        return callAlipayApi(appId, "alipay.trade.pay", notifyUrl, appAuthToken, GsonUtils.toJson(alipayTradePayModel, false));
    }

    public static String alipayTradeWapPay(String appId, String returnUrl, String notifyUrl, AlipayTradeWapPayModel alipayTradeWapPayModel) throws NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException, UnsupportedEncodingException {
        alipayTradeWapPayModel.validateAndThrow();
        return buildRequestBody(appId, "alipay.trade.wap.pay", Constants.JSON, returnUrl, Constants.UTF_8, notifyUrl, null, GsonUtils.toJson(alipayTradeWapPayModel));
    }
}
