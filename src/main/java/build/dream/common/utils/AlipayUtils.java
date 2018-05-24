package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.AlipayAccount;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static AlipayAccount obtainAlipayAccount(String appId) {
        AlipayAccount alipayAccount = new AlipayAccount();
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPHzZRoGi/U/se3toSS/2mnsE0ziajglXL9LH2F/U/VHvrnJMYC8KQPaFSgA5HvVOyRoNaFLq3ciy+1c76/npZ3rm1FYjaEEiUfCsoZR3SsvSKLqUeDCqdHl0deqEmQY8TOuxq+AfhAx+prETpknmagPJMyR1Ii5555P4Einsn7dMpAJsIF+TDjNuzWOvEp3G70RPDKQq4uDQ66l1kvJAdXD26MTzwRKPR6IpcFjdnexADaO/tbRdra+o1YuOqGwNVCG7kw4fTJPSnP3ROOqnDa9lLE/P/OKZ2A3jayfel4oafQnknVJaHhClv163fRvRVnU3onwq5npcIQ1cPlT7BAgMBAAECggEAPfJWgnIZpGZnFO+EF9NIUGv6WC66Tp9FH2gj9s5b2jNpB4vXptrANcpXHuxKQgbSSSF4DO9X+bqzX04PrlejAW8Dljth5nCR2aL80xkhFWdbrMuPsDe34hWYXAAN7A8ILFyeo5YDYwMFG11y3l4FwDf7p/yMbi/wQfY5dCG0OI1z1F85LSoodBk6iOzGLQVupQUPImFr/zbm9Aau8IrXLhjmPxbr3BQq1dGvr5tp48oWPfAO0dUy1w9NA+9Qx8CnaRE9ToIhZPmh4xlH/TdXWYy8sUYLfy62a36Y0uz8KvAQ3zOoKXVyqAcRgkhz2qP3ipZN8GZNAP81NPlLDRBBoQKBgQDC1G8fVIhAa+nUEix+LXYiCadH5pQyVohvALQGhB1716e9rLkK3FVGRrVeXidcrVqyKjnkL/pyWsWIHSgniym3LCAQdhyx6PDEjiRj0aJDy9AcboLwzWaQw+OKqZ6LQodyg1jFNlpoW6m+mrehdG42mApXam6kpRjgQEadEOkM9QKBgQC8DrllNTf6Rmb0VT6O5O/B7c1qitQ28MovTCzRg70+LOdqX/uJCF1oGl2zmzV4PJKH+fEAfvo16YRJVlXyjKLcWAw/mwFNTd2PKN7lCVFCT5UKAZkS4wgOou+JPnS7Ugs/AH2SigZc6CtENju8UhV+veZ+E5W8T29UlrmQJvdLHQKBgHvtks2UAKMxwWfTM5gDJOybxVs38TZf0qMBCIJIkVSQJbPB5WZiJp/wJDflnhYWcuV3dKGQXzdUQ+fD3CHjJGLOX4r5BmGocVYlsEIKO7PyNeuP5Bx2GvKkl91A7YdZhzyxDctMOo+9FqkWUw4ROHXjmlhmbACwv7UNTZ1k/0jtAoGAPicvpv97zL/P7xjtYBTSGOobZgcUNERIznECrww3U4FLyqCGZbfaBzoPlfjKJz79vusgd+V/lKnlCsf6B/vrJ6ACDFOSjpYZj+MWJ+R4cs4SmAgHK3LViuDXAikeM3reNKhY2EG98J7bDeROweLvL8BbmXenmWE3jmFyWu5F9RECgYEAmK2W8vSedbUlE+k9RUkBXhj9az5XKoFZ+0zXPQellJQYOMmE14Ihf+VlczpZ22jUxivT7VjvQQGccH79BVGBoa9XYTqHivv3tdm0RaSN+PIhPA6Xk07FhbOFrhQXVP7J9Dk6ygL0P+ndhj2gOermxg/9Kto3dAgm51wRMxmDIRk=";
        String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmFitWLPgXXYHdnlDmLLNaIgtzb5OZqGGuM3aJ1v54fTKf+1Eg/T+844/+zPZJqH53xbbnz7mPZnowjYs3YhzTdCF4bBLvjZpN1TlcHLvEiSJO8LQkzSr1Wd7EzXe3QQeuAap2v7VwMWY5clNK+fReWSME4pU3qAvk9qPh8pp1bfdVniSfAFuHzuIu7e/nFMLswKNsQFPvCPynp3HoqqKYzk6FN3aLP2NWLNfB2s3R646IKGzVmp9SrVqljhncdfdkzqG9Qoky+T7cPKZEKuQwm71pMkE56s55WdpRlG5R6vX6x1fratDdloVQYm7+nopE31ycsQqWBaj9cjUDF6PhwIDAQAB";
        String signType = Constants.RSA2;

        alipayAccount.setApplicationPrivateKey(privateKey);
        alipayAccount.setAlipayPublicKey(alipayPublicKey);
        alipayAccount.setSignType(signType);
        alipayAccount.setAppId(appId);
        return alipayAccount;
    }

    public static JSONObject callAlipayApi(String appId, String method, String format, String charset, String signType, String notifyUrl, String appAuthToken, Map<String, Object> bizContentMap) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>();
        sortedRequestParameters.put("app_id", appId);
        sortedRequestParameters.put("method", method);
        sortedRequestParameters.put("format", format);
        sortedRequestParameters.put("charset", charset);
        sortedRequestParameters.put("sign_type", signType);
        sortedRequestParameters.put("timestamp", new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date()));
        sortedRequestParameters.put("version", "1.0");
        if (StringUtils.isNotBlank(notifyUrl)) {
            sortedRequestParameters.put("notify_url", notifyUrl);
        }

        if (StringUtils.isNotBlank(appAuthToken)) {
            sortedRequestParameters.put("app_auth_token", appAuthToken);
        }
        sortedRequestParameters.put("biz_content", GsonUtils.toJson(bizContentMap));

        AlipayAccount alipayAccount = obtainAlipayAccount(appId);
        Validate.notNull(alipayAccount, "未配置支付宝账号！");

        String str = concat(sortedRequestParameters);

        String sign = Base64.encodeBase64String(SignatureUtils.sign(str.getBytes(Constants.CHARSET_NAME_UTF_8), Base64.decodeBase64(alipayAccount.getApplicationPrivateKey()), SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA));
        sortedRequestParameters.put("sign", sign);

        String alipayGatewayUrl = "https://openapi.alipay.com/gateway.do";
        String result = OutUtils.doPost(alipayGatewayUrl, WebUtils.buildRequestBody(sortedRequestParameters), null);

        JSONObject resultJsonObject = JSONObject.fromObject(result);
        JSONObject responseJsonObject = resultJsonObject.getJSONObject(method.replaceAll("\\.", "_") + "_response");

        Validate.isTrue(verifySign(responseJsonObject.toString(), signType, resultJsonObject.getString("sign"), charset, alipayAccount.getAlipayPublicKey()), "支付宝返回结果签名验证未通过！");

        String code = responseJsonObject.getString("code");
        String msg = responseJsonObject.getString("msg");
        Validate.isTrue("10000".equals(code), msg);

        if (responseJsonObject.has("sub_code")) {
            Validate.isTrue(false, responseJsonObject.getString("sub_msg"));
        }
        return responseJsonObject;
    }

    public static JSONObject callAlipayApi(String appId, String method, String signType, String notifyUrl, String appAuthToken, Map<String, Object> bizContentMap) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        return callAlipayApi(appId, method, Constants.JSON, Constants.UTF_8, signType, notifyUrl, appAuthToken, bizContentMap);
    }

    private static String concat(Map<String, String> requestParameters) {
        List<String> requestParameterPairs = new ArrayList<String>();
        Set<Map.Entry<String, String>> entries = requestParameters.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String value = entry.getValue();
            if (StringUtils.isNotBlank(value)) {
                requestParameterPairs.add(entry.getKey() + "=" + entry.getValue());
            }
        }
        return StringUtils.join(requestParameterPairs, "&");
    }

    public static boolean verifySign(String originalString, String signType, String sign, String charset, String alipayPublicKey) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (Constants.RSA.equals(signType)) {
            signType = SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA;
        } else if (Constants.RSA2.equals(signType)) {
            signType = SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA;
        }
        return SignatureUtils.verifySign(originalString.getBytes(charset), Base64.decodeBase64(alipayPublicKey), Base64.decodeBase64(sign), signType);
    }
}
