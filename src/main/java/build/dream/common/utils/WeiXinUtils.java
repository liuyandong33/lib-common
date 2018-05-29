package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.beans.WeiXinJsapiTicket;
import build.dream.common.beans.WeiXinOAuthAccessToken;
import build.dream.common.beans.WeiXinUserInfo;
import build.dream.common.constants.Constants;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class WeiXinUtils {
    public static String generateAuthorizeUrl(String appId, String scope, String redirectUri, String state) throws IOException {
        if (StringUtils.isBlank(scope)) {
            scope = "snsapi_base";
        }
        StringBuilder authorizeUrl = new StringBuilder(ConfigurationUtils.getConfiguration(Constants.WEI_XIN_AUTHORIZE_URL));
        authorizeUrl.append("?").append("appid=").append(appId);
        authorizeUrl.append("&redirect_uri=").append(URLEncoder.encode(redirectUri, "UTF-8"));
        authorizeUrl.append("&response_type=code");
        authorizeUrl.append("&scope=").append(scope);
        authorizeUrl.append("&connect_redirect=1");
        if (StringUtils.isNotBlank(state)) {
            if (state.length() > 128) {
                state = state.substring(0, 128);
            }
            authorizeUrl.append("&state=").append(state);
        }
        authorizeUrl.append("&#wechat_redirect");
        return authorizeUrl.toString();
    }

    public static Map<String, String> generateJsApiConfig(String url, String appId, String appSecret) throws IOException {
        Map<String, String> obtainJsapiTicketRequestParameters = new HashMap<String, String>();
        obtainJsapiTicketRequestParameters.put("appId", appId);
        obtainJsapiTicketRequestParameters.put("appSecret", appSecret);
        obtainJsapiTicketRequestParameters.put("type", "jsapi");
        ApiRest obtainJsapiTicketApiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_OUT, "weiXin", "obtainJsapiTicket", obtainJsapiTicketRequestParameters);
        Validate.isTrue(obtainJsapiTicketApiRest.isSuccessful(), obtainJsapiTicketApiRest.getError());
        WeiXinJsapiTicket weiXinJsapiTicket = (WeiXinJsapiTicket) obtainJsapiTicketApiRest.getData();

        String ticket = weiXinJsapiTicket.getTicket();
        String nonceStr = RandomStringUtils.randomAlphanumeric(32);
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String str = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
        String signature = DigestUtils.sha1Hex(str);

        Map<String, String> config = new HashMap<String, String>();
        config.put("appId", appId);
        config.put("timestamp", timestamp);
        config.put("nonceStr", nonceStr);
        config.put("url", url);
        config.put("signature", signature);
        return config;
    }

    public static WeiXinOAuthAccessToken obtainOAuthAccessToken(String appId, String secret, String code) throws IOException {
        Map<String, String> obtainOAuthAccessTokenRequestParameters = new HashMap<String, String>();
        obtainOAuthAccessTokenRequestParameters.put("appid", appId);
        obtainOAuthAccessTokenRequestParameters.put("secret", secret);
        obtainOAuthAccessTokenRequestParameters.put("code", code);
        obtainOAuthAccessTokenRequestParameters.put("grant_type", "authorization_code");

        String url = ConfigurationUtils.getConfiguration(Constants.WEI_XIN_API_URL) + Constants.WEI_XIN_OAUTH2_ACCESS_TOKEN_URI + "?" + WebUtils.buildQueryString(obtainOAuthAccessTokenRequestParameters);
        String result = OutUtils.doGet(url, null);

        JSONObject resultJsonObject = JSONObject.fromObject(result);
        Validate.isTrue(!resultJsonObject.has("errcode"), resultJsonObject.optString("errmsg"));

        WeiXinOAuthAccessToken weiXinOAuthAccessToken = new WeiXinOAuthAccessToken();
        weiXinOAuthAccessToken.setAccessToken(resultJsonObject.getString("access_token"));
        weiXinOAuthAccessToken.setExpiresIn(resultJsonObject.getInt("expires_in"));
        weiXinOAuthAccessToken.setRefreshToken(resultJsonObject.getString("refresh_token"));
        weiXinOAuthAccessToken.setOpenId(resultJsonObject.getString("openid"));
        weiXinOAuthAccessToken.setScope(resultJsonObject.getString("scope"));

        return weiXinOAuthAccessToken;
    }

    public static WeiXinUserInfo obtainUserInfo(String accessToken, String openId, String lang) throws IOException {
        Map<String, String> obtainUserInfoRequestParameters = new HashMap<String, String>();
        obtainUserInfoRequestParameters.put("access_token", accessToken);
        obtainUserInfoRequestParameters.put("openid", openId);
        if (StringUtils.isNotBlank(lang)) {
            obtainUserInfoRequestParameters.put("lang", lang);
        }

        String url = ConfigurationUtils.getConfiguration(Constants.WEI_XIN_API_URL) + Constants.WEI_XIN_OBTAIN_USER_INFO_URI + "?" + WebUtils.buildQueryString(obtainUserInfoRequestParameters);
        String result = OutUtils.doGet(url, null);
        JSONObject resultJsonObject = JSONObject.fromObject(result);
        if (resultJsonObject.has("errcode")) {
            Validate.isTrue(false, resultJsonObject.optString("errmsg"));
        }

        WeiXinUserInfo weiXinUserInfo = new WeiXinUserInfo();
        weiXinUserInfo.setOpenId(resultJsonObject.optString("openid"));
        weiXinUserInfo.setNickname(resultJsonObject.optString("nickname"));
        weiXinUserInfo.setSex(resultJsonObject.optInt("sex"));
        weiXinUserInfo.setProvince(resultJsonObject.optString("province"));
        weiXinUserInfo.setCity(resultJsonObject.optString("city"));
        weiXinUserInfo.setCountry(resultJsonObject.optString("country"));
        weiXinUserInfo.setHeadImgUrl(resultJsonObject.optString("headimgurl"));
        weiXinUserInfo.setPrivilege(StringUtils.join(resultJsonObject.optJSONArray("privilege"), ","));
        weiXinUserInfo.setUnionId(resultJsonObject.optString("unionid"));

        return weiXinUserInfo;
    }
}
