package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.beans.*;
import build.dream.common.constants.Constants;
import build.dream.common.models.weixin.*;
import build.dream.common.saas.domains.WeiXinAuthorizerInfo;
import build.dream.common.saas.domains.WeiXinAuthorizerToken;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class WeiXinUtils {
    private static final String WEI_XIN_API_URL = "https://api.weixin.qq.com";
    private static final String COMPONENT_LOGIN_PAGE_URL = "https://mp.weixin.qq.com/cgi-bin/componentloginpage";
    private static final String WEI_XIN_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";
    private static final Map<String, String> HEADERS = new HashMap<String, String>();

    static {
        HEADERS.put("Content-Type", "application/json;charset=UTF-8");
    }

    public static String generateComponentLoginPageUrl(String componentAppId, String preAuthCode, String redirectUri, String authType) throws UnsupportedEncodingException {
        return COMPONENT_LOGIN_PAGE_URL + "?component_appid=" + componentAppId + "&pre_auth_code=" + preAuthCode + "&redirect_uri=" + URLEncoder.encode(redirectUri, Constants.CHARSET_NAME_UTF_8) + "&auth_type=" + authType;
    }

    public static String generateAuthorizeUrl(String appId, String scope, String redirectUri, String state) throws IOException {
        return generateAuthorizeUrl(appId, scope, redirectUri, state, null);
    }

    public static String generateAuthorizeUrl(String appId, String scope, String redirectUri, String state, String componentAppId) throws IOException {
        if (StringUtils.isBlank(scope)) {
            scope = Constants.SNSAPI_BASE;
        }
        StringBuilder authorizeUrl = new StringBuilder(WEI_XIN_AUTHORIZE_URL);
        authorizeUrl.append("?").append("appid=").append(appId);
        authorizeUrl.append("&redirect_uri=").append(URLEncoder.encode(redirectUri, Constants.CHARSET_NAME_UTF_8));
        authorizeUrl.append("&response_type=code");
        authorizeUrl.append("&scope=").append(scope);
        authorizeUrl.append("&connect_redirect=1");
        if (StringUtils.isNotBlank(state)) {
            authorizeUrl.append("&state=");
            if (state.length() > 128) {
                authorizeUrl.append(state.substring(0, 128));
            } else {
                authorizeUrl.append(state);
            }
        }
        if (StringUtils.isNotBlank(componentAppId)) {
            authorizeUrl.append("&component_appid=").append(componentAppId);
        }
        authorizeUrl.append("&#wechat_redirect");
        return authorizeUrl.toString();
    }

    public static Map<String, String> generateJsApiConfig(String url, String appId, String appSecret) throws IOException {
        WeiXinJsapiTicket weiXinJsapiTicket = obtainJsapiTicket(appId, appSecret, Constants.WEI_XIN_TICKET_TYPE_JSAPI);

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

    public static WeiXinOAuthToken obtainOAuthToken(String appId, String secret, String code) {
        Map<String, String> obtainOAuthTokenRequestParameters = new HashMap<String, String>();
        obtainOAuthTokenRequestParameters.put("appid", appId);
        obtainOAuthTokenRequestParameters.put("secret", secret);
        obtainOAuthTokenRequestParameters.put("code", code);
        obtainOAuthTokenRequestParameters.put("grant_type", "authorization_code");

        String url = WEI_XIN_API_URL + "/sns/oauth2/access_token";
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, obtainOAuthTokenRequestParameters);

        JSONObject resultJsonObject = JSONObject.fromObject(webResponse.getResult());
        ValidateUtils.isTrue(!resultJsonObject.has("errcode"), resultJsonObject.optString("errmsg"));

        WeiXinOAuthToken weiXinOAuthToken = new WeiXinOAuthToken();
        weiXinOAuthToken.setAccessToken(resultJsonObject.getString("access_token"));
        weiXinOAuthToken.setExpiresIn(resultJsonObject.getInt("expires_in"));
        weiXinOAuthToken.setRefreshToken(resultJsonObject.getString("refresh_token"));
        weiXinOAuthToken.setOpenId(resultJsonObject.getString("openid"));
        weiXinOAuthToken.setScope(resultJsonObject.getString("scope"));

        return weiXinOAuthToken;
    }

    public static WeiXinOAuthToken obtainOAuthToken(String appId, String code, String componentAppId, String componentAccessToken) {
        Map<String, String> obtainOAuthTokenRequestParameters = new HashMap<String, String>();
        obtainOAuthTokenRequestParameters.put("appid", appId);
        obtainOAuthTokenRequestParameters.put("code", code);
        obtainOAuthTokenRequestParameters.put("grant_type", "authorization_code");
        obtainOAuthTokenRequestParameters.put("component_appid", componentAppId);
        obtainOAuthTokenRequestParameters.put("component_access_token", componentAccessToken);

        String url = WEI_XIN_API_URL + "/sns/oauth2/component/access_token";
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, obtainOAuthTokenRequestParameters);

        JSONObject resultJsonObject = JSONObject.fromObject(webResponse.getResult());
        ValidateUtils.isTrue(!resultJsonObject.has("errcode"), resultJsonObject.optString("errmsg"));

        WeiXinOAuthToken weiXinOAuthToken = new WeiXinOAuthToken();
        weiXinOAuthToken.setAccessToken(resultJsonObject.getString("access_token"));
        weiXinOAuthToken.setExpiresIn(resultJsonObject.getInt("expires_in"));
        weiXinOAuthToken.setRefreshToken(resultJsonObject.getString("refresh_token"));
        weiXinOAuthToken.setOpenId(resultJsonObject.getString("openid"));
        weiXinOAuthToken.setScope(resultJsonObject.getString("scope"));

        return weiXinOAuthToken;
    }

    public static WeiXinUserInfo obtainUserInfoByThirdParty(String authorizerAccessToken, String openId, String lang) {
        return obtainUserInfo(authorizerAccessToken, openId, lang, Constants.IDENTITY_TYPE_THIRD_PARTY_APPLICATION);
    }

    public static WeiXinUserInfo obtainUserInfo(String accessToken, String openId, String lang) {
        return obtainUserInfo(accessToken, openId, lang, Constants.IDENTITY_TYPE_PUBLIC_ACCOUNT);
    }

    public static WeiXinUserInfo obtainUserInfo(String token, String openId, String lang, int type) {
        Map<String, String> obtainUserInfoRequestParameters = new HashMap<String, String>();
        if (type == Constants.IDENTITY_TYPE_PUBLIC_ACCOUNT) {
            obtainUserInfoRequestParameters.put("access_token", token);
        } else if (type == Constants.IDENTITY_TYPE_THIRD_PARTY_APPLICATION) {
            obtainUserInfoRequestParameters.put("authorizer_access_token", token);
        }
        obtainUserInfoRequestParameters.put("openid", openId);
        if (StringUtils.isNotBlank(lang)) {
            obtainUserInfoRequestParameters.put("lang", lang);
        }

        String url = WEI_XIN_API_URL + "/sns/userinfo";
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, obtainUserInfoRequestParameters);
        JSONObject resultJsonObject = JSONObject.fromObject(webResponse.getResult());
        if (resultJsonObject.has("errcode")) {
            ValidateUtils.isTrue(false, resultJsonObject.optString("errmsg"));
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

    public static Map<String, Object> sendMassMessage(String accessToken, SendMassMessageModel sendMassMessageModel) throws IOException {
        String url = WEI_XIN_API_URL + "/message/mass/send?access_token=" + accessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, GsonUtils.toJson(sendMassMessageModel, false));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    public static WeiXinAccessToken obtainAccessToken(String appId, String secret) {
        String weiXinAccessTokenJson = CacheUtils.hget(Constants.KEY_WEI_XIN_ACCESS_TOKENS, appId);
        boolean isRetrieveAccessToken = false;
        WeiXinAccessToken weiXinAccessToken = null;
        if (StringUtils.isNotBlank(weiXinAccessTokenJson)) {
            weiXinAccessToken = GsonUtils.fromJson(weiXinAccessTokenJson, WeiXinAccessToken.class);
            if ((System.currentTimeMillis() - weiXinAccessToken.getFetchTime().getTime()) / 1000 >= weiXinAccessToken.getExpiresIn()) {
                isRetrieveAccessToken = true;
            }
        } else {
            isRetrieveAccessToken = true;
        }
        if (isRetrieveAccessToken) {
            Map<String, String> obtainAccessTokenRequestParameters = new HashMap<String, String>();
            obtainAccessTokenRequestParameters.put("appid", appId);
            obtainAccessTokenRequestParameters.put("secret", secret);
            obtainAccessTokenRequestParameters.put("grant_type", "client_credential");
            String url = WEI_XIN_API_URL + "/cgi-bin/token";
            WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, obtainAccessTokenRequestParameters);

            JSONObject resultJsonObject = JSONObject.fromObject(webResponse.getResult());
            ValidateUtils.isTrue(!resultJsonObject.has("errcode"), resultJsonObject.optString("errmsg"));

            weiXinAccessToken = new WeiXinAccessToken();
            weiXinAccessToken.setAccessToken(resultJsonObject.getString("access_token"));
            weiXinAccessToken.setExpiresIn(resultJsonObject.getInt("expires_in"));
            weiXinAccessToken.setFetchTime(new Date());
            CacheUtils.hset(Constants.KEY_WEI_XIN_ACCESS_TOKENS, appId, GsonUtils.toJson(weiXinAccessToken));
        }
        return weiXinAccessToken;
    }

    public static WeiXinJsapiTicket obtainJsapiTicket(String appId, String appSecret, String type) throws IOException {
        String weiXinJsapiTicketJson = CacheUtils.hget(Constants.KEY_WEI_XIN_JSAPI_TICKETS + "_" + type, appId);
        boolean isRetrieveJsapiTicket = false;
        WeiXinJsapiTicket weiXinJsapiTicket = null;
        if (StringUtils.isNotBlank(weiXinJsapiTicketJson)) {
            weiXinJsapiTicket = GsonUtils.fromJson(weiXinJsapiTicketJson, WeiXinJsapiTicket.class);
            if ((System.currentTimeMillis() - weiXinJsapiTicket.getFetchTime().getTime()) / 1000 >= weiXinJsapiTicket.getExpiresIn()) {
                isRetrieveJsapiTicket = true;
            }
        } else {
            isRetrieveJsapiTicket = true;
        }

        if (isRetrieveJsapiTicket) {
            WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, appSecret);
            Map<String, String> obtainJsapiTicketRequestParameters = new HashMap<String, String>();
            obtainJsapiTicketRequestParameters.put("access_token", weiXinAccessToken.getAccessToken());
            obtainJsapiTicketRequestParameters.put("type", type);

            String url = WEI_XIN_API_URL + "/cgi-bin/ticket/getticket";
            WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, obtainJsapiTicketRequestParameters);
            JSONObject resultJsonObject = JSONObject.fromObject(webResponse.getResult());
            ValidateUtils.isTrue(resultJsonObject.optInt("errcode") == 0, resultJsonObject.optString("errmsg"));

            weiXinJsapiTicket = new WeiXinJsapiTicket();
            weiXinJsapiTicket.setTicket(resultJsonObject.optString("ticket"));
            weiXinJsapiTicket.setExpiresIn(resultJsonObject.optInt("expires_in"));
            weiXinJsapiTicket.setFetchTime(new Date());
            CacheUtils.hset(Constants.KEY_WEI_XIN_JSAPI_TICKETS + "_" + type, appId, GsonUtils.toJson(weiXinJsapiTicket));
        }
        return weiXinJsapiTicket;
    }

    public static Map<String, Object> createGrouponCoupon(BaseInfoModel baseInfoModel, AdvancedInfoModel advancedInfoModel, String dealDetail, String accessToken) {
        Map<String, Object> groupon = new HashMap<String, Object>();
        groupon.put("base_info", baseInfoModel);
        groupon.put("advanced_info", advancedInfoModel);
        groupon.put("deal_detail", dealDetail);

        Map<String, Object> card = new HashMap<String, Object>();
        card.put("card_type", "GROUPON");
        card.put("groupon", groupon);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("card", card);

        String url = WEI_XIN_API_URL + "/card/create?access_token=" + accessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(groupon, false));
        Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errcode = MapUtils.getIntValue(result, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(result, "errmsg"));

        return result;
    }

    public static Map<String, Object> sendTemplateMessage(String appId, String secret, SendTemplateMessageModel sendTemplateMessageModel) {
        WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, secret);
        return sendTemplateMessage(weiXinAccessToken.getAccessToken(), sendTemplateMessageModel);
    }

    public static Map<String, Object> sendTemplateMessage(String accessToken, SendTemplateMessageModel sendTemplateMessageModel) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("touser", sendTemplateMessageModel.getOpenId());
        body.put("template_id", sendTemplateMessageModel.getTemplateId());
        body.put("url", sendTemplateMessageModel.getUrl());

        Map<String, Object> miniProgram = sendTemplateMessageModel.getMiniProgram();
        if (MapUtils.isNotEmpty(miniProgram)) {
            body.put("miniprogram", miniProgram);
        }
        body.put("data", sendTemplateMessageModel.getData());

        String color = sendTemplateMessageModel.getColor();
        if (StringUtils.isNotBlank(color)) {
            body.put("data", color);
        }
        String _url = WEI_XIN_API_URL + "/cgi-bin/message/template/send?access_token=" + accessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(_url, GsonUtils.toJson(body));
        Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errcode = MapUtils.getIntValue(result, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(result, "errmsg"));

        return result;
    }

    public static ComponentAccessToken obtainComponentAccessToken(String componentAppId, String componentAppSecret) {
        String componentAccessTokenJson = CacheUtils.hget(Constants.KEY_WEI_XIN_COMPONENT_ACCESS_TOKEN, componentAppId);
        boolean isRetrieveComponentAccessToken = false;

        ComponentAccessToken componentAccessToken = null;
        if (StringUtils.isNotBlank(componentAccessTokenJson)) {
            componentAccessToken = GsonUtils.fromJson(componentAccessTokenJson, ComponentAccessToken.class);
            if ((System.currentTimeMillis() - componentAccessToken.getFetchTime().getTime()) / 1000 >= componentAccessToken.getExpiresIn()) {
                isRetrieveComponentAccessToken = true;
            }
        } else {
            isRetrieveComponentAccessToken = true;
        }

        if (isRetrieveComponentAccessToken) {
            String componentVerifyTicket = CacheUtils.hget(Constants.KEY_WEI_XIN_COMPONENT_VERIFY_TICKET, componentAppId);
            ValidateUtils.notBlank(componentVerifyTicket, "component_verify_ticket 不存在！");
            String url = WEI_XIN_API_URL + "/cgi-bin/component/api_component_token";
            Map<String, Object> requestBody = new HashMap<String, Object>();
            requestBody.put("component_appid", componentAppId);
            requestBody.put("component_appsecret", componentAppSecret);
            requestBody.put("component_verify_ticket", componentVerifyTicket);
            WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
            Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
            ValidateUtils.isTrue(!result.containsKey("errcode"), MapUtils.getString(result, "errmsg"));

            componentAccessToken = new ComponentAccessToken();
            componentAccessToken.setComponentAccessToken(MapUtils.getString(result, "component_access_token"));
            componentAccessToken.setExpiresIn(MapUtils.getIntValue(result, "expires_in"));
            componentAccessToken.setFetchTime(new Date());
            CacheUtils.hset(Constants.KEY_WEI_XIN_COMPONENT_ACCESS_TOKEN, componentAppId, GsonUtils.toJson(componentAccessToken));
        }

        return componentAccessToken;
    }

    public static String obtainPreAuthCode(String componentAppId, String componentAppSecret) {
        ComponentAccessToken componentAccessToken = obtainComponentAccessToken(componentAppId, componentAppSecret);
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_create_preauthcode?component_access_token=" + componentAccessToken.getComponentAccessToken();
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);

        ValidateUtils.isTrue(!result.containsKey("errcode"), MapUtils.getString(result, "errmsg"));
        return MapUtils.getString(result, "pre_auth_code");
    }

    public static WeiXinAuthorizerToken apiQueryAuth(String componentAccessToken, String componentAppId, String authorizationCode) throws IOException {
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_query_auth?component_access_token=" + componentAccessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        requestBody.put("authorization_code", authorizationCode);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(!result.containsKey("errcode"), MapUtils.getString(result, "errmsg"));

        Map<String, Object> authorizationInfo = MapUtils.getMap(result, "authorization_info");
        String authorizerAppId = MapUtils.getString(authorizationInfo, "authorizer_appid");
        String authorizerAccessToken = MapUtils.getString(authorizationInfo, "authorizer_access_token");
        int expiresIn = MapUtils.getIntValue(authorizationInfo, "expires_in");
        String authorizerRefreshToken = MapUtils.getString(authorizationInfo, "authorizer_refresh_token");
        Date fetchTime = new Date();

        WeiXinAuthorizerToken weiXinAuthorizerToken = new WeiXinAuthorizerToken();
        weiXinAuthorizerToken.setComponentAppId(componentAppId);
        weiXinAuthorizerToken.setAuthorizerAppId(authorizerAppId);
        weiXinAuthorizerToken.setAuthorizerAccessToken(authorizerAccessToken);
        weiXinAuthorizerToken.setExpiresIn(expiresIn);
        weiXinAuthorizerToken.setAuthorizerRefreshToken(authorizerRefreshToken);
        weiXinAuthorizerToken.setFetchTime(fetchTime);

        Map<String, String> saveWeiXinAuthorizerTokenRequestParameters = new HashMap<String, String>();
        saveWeiXinAuthorizerTokenRequestParameters.put("componentAppId", componentAppId);
        saveWeiXinAuthorizerTokenRequestParameters.put("authorizerAppId", authorizerAppId);
        saveWeiXinAuthorizerTokenRequestParameters.put("authorizerAccessToken", authorizerAccessToken);
        saveWeiXinAuthorizerTokenRequestParameters.put("expiresIn", String.valueOf(expiresIn));
        saveWeiXinAuthorizerTokenRequestParameters.put("authorizerRefreshToken", authorizerRefreshToken);
        saveWeiXinAuthorizerTokenRequestParameters.put("fetchTime", new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(fetchTime));
        saveWeiXinAuthorizerTokenRequestParameters.put("userId", CommonUtils.getServiceSystemUserId().toString());
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "weiXin", "saveWeiXinAuthorizerToken", saveWeiXinAuthorizerTokenRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
        CacheUtils.hset(Constants.KEY_WEI_XIN_AUTHORIZER_TOKENS, componentAppId + "_" + authorizerAppId, GsonUtils.toJson(weiXinAuthorizerToken));
        return weiXinAuthorizerToken;
    }

    public static WeiXinAuthorizerToken obtainWeiXinAuthorizerToken(String componentAppId, String authorizerAppId) {
        String tokenJson = CacheUtils.hget(Constants.SERVICE_NAME_PLATFORM, componentAppId + "_" + authorizerAppId);
        ValidateUtils.notBlank(tokenJson, "授权信息不存在！");
        return GsonUtils.fromJson(tokenJson, WeiXinAuthorizerToken.class);
    }

    public static Map<String, Object> createMenu(String accessToken, CreateMenuModel createMenuModel) {
        createMenuModel.validateAndThrow();
        String url = WEI_XIN_API_URL + "/cgi-bin/menu/create?access_token=" + accessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(createMenuModel, false));
        Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errcode = MapUtils.getIntValue(result, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(result, "errmsg"));
        return result;
    }

    public static Map<String, Object> addPoi(String accessToken, AddPoiModel addPoiModel) {
        addPoiModel.validateAndThrow();
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("business", addPoiModel);

        String url = WEI_XIN_API_URL + "/cgi-bin/poi/addpoi?access_token=" + accessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody, false));
        Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errcode = MapUtils.getIntValue(result, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(result, "errmsg"));
        return result;
    }

    public static WeiXinAuthorizerInfo apiGetAuthorizerInfo(String componentAccessToken, String componentAppId, String authorizerAppId) {
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_get_authorizer_info?component_access_token=" + componentAccessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        requestBody.put("authorizer_appid", authorizerAppId);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(!result.containsKey("errcode"), MapUtils.getString(result, "errmsg"));

        Map<String, Object> authorizerInfo = MapUtils.getMap(result, "authorizer_info");

        WeiXinAuthorizerInfo weiXinAuthorizerInfo = new WeiXinAuthorizerInfo();
        weiXinAuthorizerInfo.setNickName(MapUtils.getString(authorizerInfo, "nick_name"));

        String headImg = MapUtils.getString(authorizerInfo, "head_img");
        weiXinAuthorizerInfo.setHeadImg(StringUtils.isNotBlank(headImg) ? headImg : Constants.VARCHAR_DEFAULT_VALUE);

        weiXinAuthorizerInfo.setServiceTypeInfo(GsonUtils.toJson(authorizerInfo.get("service_type_info")));
        weiXinAuthorizerInfo.setVerifyTypeInfo(GsonUtils.toJson(authorizerInfo.get("verify_type_info")));
        weiXinAuthorizerInfo.setOriginalId(MapUtils.getString(authorizerInfo, "user_name"));
        weiXinAuthorizerInfo.setPrincipalName(MapUtils.getString(authorizerInfo, "principal_name"));

        String alias = MapUtils.getString(authorizerInfo, "alias");
        weiXinAuthorizerInfo.setAlias(StringUtils.isNotBlank(alias) ? alias : Constants.VARCHAR_DEFAULT_VALUE);

        weiXinAuthorizerInfo.setBusinessInfo(GsonUtils.toJson(authorizerInfo.get("business_info")));
        weiXinAuthorizerInfo.setQrcodeUrl(MapUtils.getString(authorizerInfo, "qrcode_url"));
        weiXinAuthorizerInfo.setSignature(MapUtils.getString(authorizerInfo, "signature"));

        Object miniProgramInfo = authorizerInfo.get("MiniProgramInfo");
        if (miniProgramInfo != null) {
            weiXinAuthorizerInfo.setAuthorizerType(Constants.AUTHORIZER_TYPE_PUBLIC_ACCOUNT);
            weiXinAuthorizerInfo.setMiniProgramInfo(GsonUtils.toJson(miniProgramInfo));
        } else {
            weiXinAuthorizerInfo.setAuthorizerType(Constants.AUTHORIZER_TYPE_MINI_PROGRAM);
            weiXinAuthorizerInfo.setMiniProgramInfo(Constants.VARCHAR_DEFAULT_VALUE);
        }

        Map<String, Object> authorizationInfo = MapUtils.getMap(result, "authorization_info");
        weiXinAuthorizerInfo.setAuthorizerAppId(MapUtils.getString(authorizationInfo, "authorizer_appid"));
        weiXinAuthorizerInfo.setFuncInfo(GsonUtils.toJson(authorizationInfo.get("func_info")));
        weiXinAuthorizerInfo.setComponentAppId(componentAppId);
        return weiXinAuthorizerInfo;
    }

    public static WeiXinAuthorizerToken apiAuthorizerToken(String componentAccessToken, String componentAppId, String authorizerAppId, String authorizerRefreshToken) {
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_authorizer_token?component_access_token=" + componentAccessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        requestBody.put("authorizer_appid", authorizerAppId);
        requestBody.put("authorizer_refresh_token", authorizerRefreshToken);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));

        Map<String, Object> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(!result.containsKey("errcode"), MapUtils.getString(result, "errmsg"));

        WeiXinAuthorizerToken weiXinAuthorizerToken = new WeiXinAuthorizerToken();
        weiXinAuthorizerToken.setComponentAppId(componentAppId);
        weiXinAuthorizerToken.setAuthorizerAppId(authorizerAppId);
        weiXinAuthorizerToken.setAuthorizerAccessToken(MapUtils.getString(result, "authorizer_access_token"));
        weiXinAuthorizerToken.setExpiresIn(MapUtils.getIntValue(result, "expires_in"));
        weiXinAuthorizerToken.setAuthorizerRefreshToken(MapUtils.getString(result, "authorizer_refresh_token"));
        weiXinAuthorizerToken.setFetchTime(new Date());
        return weiXinAuthorizerToken;
    }

    public static Map<String, Object> sendCustomMessage(String appId, String secret, String message) {
        WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, secret);
        return sendCustomMessage(weiXinAccessToken.getAccessToken(), message);
    }

    public static Map<String, Object> sendCustomMessage(String accessToken, String message) {
        String url = WEI_XIN_API_URL + "/cgi-bin/message/custom/send?access_token=" + accessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, message);
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    public static Map<String, Object> getUser(String appId, String secret, String nextOpenId) {
        WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, secret);
        String accessToken = weiXinAccessToken.getAccessToken();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("access_token", accessToken);
        if (StringUtils.isNotBlank(nextOpenId)) {
            requestParameters.put("next_openid", nextOpenId);
        }
        String url = WEI_XIN_API_URL + "/cgi-bin/user/get";

        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, requestParameters);
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        if (resultMap.containsKey("errcode")) {
            ValidateUtils.isTrue(false, MapUtils.getString(resultMap, "errmsg"));
        }

        return resultMap;
    }

    public static Map<String, Object> getUserInfo(String appId, String secret, String openId, String lang) {
        WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, secret);
        String accessToken = weiXinAccessToken.getAccessToken();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("access_token", accessToken);
        requestParameters.put("openid", openId);
        if (StringUtils.isNotBlank(lang)) {
            requestParameters.put("lang", lang);
        }

        String url = WEI_XIN_API_URL + "/cgi-bin/user/info";

        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, requestParameters);
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        if (resultMap.containsKey("errcode")) {
            ValidateUtils.isTrue(false, MapUtils.getString(resultMap, "errmsg"));
        }

        return resultMap;
    }

    public static Map<String, Object> batchGetUserInfo(String appId, String secret, List<Map<String, String>> userList) {
        WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, secret);
        String accessToken = weiXinAccessToken.getAccessToken();

        String url = WEI_XIN_API_URL + "/cgi-bin/user/info/batchget?access_token=" + accessToken;

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("user_list", userList);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        if (resultMap.containsKey("errcode")) {
            ValidateUtils.isTrue(false, MapUtils.getString(resultMap, "errmsg"));
        }

        return resultMap;
    }

    /**
     * 获取帐号基本信息
     *
     * @param componentAppId
     * @param authorizerAppId
     * @return
     */
    public static Map<String, Object> getAccountBasicInfo(String componentAppId, String authorizerAppId) {
        String authorizerAccessTokenJson = CacheUtils.hget(Constants.KEY_WEI_XIN_AUTHORIZER_TOKENS, componentAppId + "_" + authorizerAppId);
        ValidateUtils.notBlank(authorizerAccessTokenJson, "未查询到 authorizer_access_token！");

        Map<String, Object> authorizerAccessToken = JacksonUtils.readValueAsMap(authorizerAccessTokenJson, String.class, Object.class);
        Map<String, String> getAccountBasicInfoRequestParameters = new HashMap<String, String>();
        getAccountBasicInfoRequestParameters.put("access_token", MapUtils.getString(authorizerAccessToken, "authorizerAccessToken"));

        String url = WEI_XIN_API_URL + "/cgi-bin/account/getaccountbasicinfo";
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, null, getAccountBasicInfoRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取草稿箱内的所有临时代码草稿
     *
     * @param componentAppId
     * @param componentAppSecret
     * @return
     */
    public static Map<String, Object> getTemplateDraftList(String componentAppId, String componentAppSecret) {
        ComponentAccessToken componentAccessToken = obtainComponentAccessToken(componentAppId, componentAppSecret);

        Map<String, String> getTemplateDraftListRequestParameters = new HashMap<String, String>();
        getTemplateDraftListRequestParameters.put("access_token", componentAccessToken.getComponentAccessToken());

        String url = WEI_XIN_API_URL + "/wxa/gettemplatedraftlist";
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, getTemplateDraftListRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取代码模版库中的所有小程序代码模版
     *
     * @param componentAppId
     * @param componentAppSecret
     * @return
     */
    public static Map<String, Object> getTemplateList(String componentAppId, String componentAppSecret) {
        ComponentAccessToken componentAccessToken = obtainComponentAccessToken(componentAppId, componentAppSecret);
        Map<String, String> getTemplateListRequestParameters = new HashMap<String, String>();
        getTemplateListRequestParameters.put("access_token", componentAccessToken.getComponentAccessToken());

        String url = WEI_XIN_API_URL + "/wxa/gettemplatelist";
        WebResponse webResponse = OutUtils.doGetWithRequestParameters(url, getTemplateListRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 将草稿箱的草稿选为小程序代码模版
     *
     * @param componentAppId
     * @param componentAppSecret
     * @param draftId
     * @return
     */
    public static Map<String, Object> addToTemplate(String componentAppId, String componentAppSecret, int draftId) {
        ComponentAccessToken componentAccessToken = obtainComponentAccessToken(componentAppId, componentAppSecret);
        String url = WEI_XIN_API_URL + "/wxa/addtotemplate?access_token=" + componentAccessToken.getComponentAccessToken();

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("draft_id", draftId);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 删除指定小程序代码模版
     *
     * @param componentAppId
     * @param componentAppSecret
     * @param templateId
     * @return
     */
    public static Map<String, Object> deleteTemplate(String componentAppId, String componentAppSecret, int templateId) {
        ComponentAccessToken componentAccessToken = obtainComponentAccessToken(componentAppId, componentAppSecret);
        String url = WEI_XIN_API_URL + "/wxa/deletetemplate?access_token=" + componentAccessToken.getComponentAccessToken();

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("template_id", templateId);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 为授权的小程序帐号上传小程序代码
     *
     * @param authorizerAccessToken
     * @param templateId
     * @param extJson
     * @param userVersion
     * @param userDesc
     * @return
     */
    public static Map<String, Object> commit(String authorizerAccessToken, int templateId, String extJson, String userVersion, String userDesc) {
        String url = "https://api.weixin.qq.com/wxa/commit?access_token=" + authorizerAccessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("template_id", templateId);
        requestBody.put("ext_json", extJson);
        requestBody.put("user_version", userVersion);
        requestBody.put("user_desc", userDesc);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    public static Map<String, Object> modifyDomain(String authorizerAccessToken, String action, String[] requestDomains, String[] wsRequestDomains, String[] uploadDomains, String[] downloadDomains) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("action", action);

        if (ArrayUtils.isNotEmpty(requestDomains)) {
            requestBody.put("requestdomain", requestDomains);
        }

        if (ArrayUtils.isNotEmpty(requestDomains)) {
            requestBody.put("wsrequestdomain", wsRequestDomains);
        }

        if (ArrayUtils.isNotEmpty(requestDomains)) {
            requestBody.put("uploaddomain", uploadDomains);
        }

        if (ArrayUtils.isNotEmpty(requestDomains)) {
            requestBody.put("downloaddomain", downloadDomains);
        }

        String url = WEI_XIN_API_URL + "/wxa/modify_domain?access_token=" + authorizerAccessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    public static Map<String, Object> setWebViewDomain(String authorizerAccessToken, String action, String webViewDomain) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("action", action);

        if (StringUtils.isNotEmpty(webViewDomain)) {
            requestBody.put("webviewdomain", webViewDomain);
        }

        String url = WEI_XIN_API_URL + "/wxa/setwebviewdomain?access_token=" + authorizerAccessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 绑定微信用户为小程序体验者
     *
     * @return
     */
    public static Map<String, Object> bindTester(String authorizerAccessToken, String weChatId) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("wechatid", weChatId);
        String url = WEI_XIN_API_URL + "/wxa/bind_tester?access_token=" + authorizerAccessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 解除绑定小程序的体验者
     *
     * @param authorizerAccessToken
     * @param weChatId
     * @return
     */
    public static Map<String, Object> unbindTester(String authorizerAccessToken, String weChatId) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("wechatid", weChatId);
        String url = WEI_XIN_API_URL + "/wxa/unbind_tester?access_token=" + authorizerAccessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取体验者列表
     *
     * @param authorizerAccessToken
     * @param action
     * @return
     */
    public static Map<String, Object> memberAuth(String authorizerAccessToken, String action) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("action", action);
        String url = WEI_XIN_API_URL + "/wxa/memberauth?access_token=" + authorizerAccessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取公众号关联的小程序
     *
     * @param authorizerAccessToken
     * @return
     */
    public static Map<String, Object> getWxAmpLink(String authorizerAccessToken) {
        String url = WEI_XIN_API_URL + "/cgi-bin/wxopen/wxamplinkget?access_token=" + authorizerAccessToken;
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, null);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 关联小程序
     *
     * @param authorizerAccessToken
     * @param appId
     * @param notifyUsers
     * @param showProfile
     * @return
     */
    public static Map<String, Object> wxAmpLink(String authorizerAccessToken, String appId, String notifyUsers, String showProfile) {
        String url = WEI_XIN_API_URL + "/cgi-bin/wxopen/wxamplink?access_token=" + authorizerAccessToken;

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("appid", appId);
        requestBody.put("notify_users", notifyUsers);
        requestBody.put("show_profile", showProfile);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 解除已关联的小程序
     *
     * @param authorizerAccessToken
     * @param appId
     * @return
     */
    public static Map<String, Object> wxAmpUnlink(String authorizerAccessToken, String appId) {
        String url = WEI_XIN_API_URL + "/cgi-bin/wxopen/wxampunlink?access_token=" + authorizerAccessToken;

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("appid", appId);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, GsonUtils.toJson(requestBody));
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    public static WeiXinAuthorizerInfo obtainWeiXinPublicAccount(String tenantId) {
        String serviceName = ConfigurationUtils.getConfiguration(Constants.SERVICE_NAME);
        if (Constants.SERVICE_NAME_PLATFORM.equals(serviceName)) {
            SearchModel searchModel = new SearchModel(true);
            searchModel.addSearchCondition(WeiXinAuthorizerInfo.ColumnName.TENANT_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, tenantId);
            searchModel.addSearchCondition(WeiXinAuthorizerInfo.ColumnName.AUTHORIZER_TYPE, Constants.SQL_OPERATION_SYMBOL_EQUAL, Constants.AUTHORIZER_TYPE_PUBLIC_ACCOUNT);
            return DatabaseHelper.find(WeiXinAuthorizerInfo.class, searchModel);
        } else {
            Map<String, String> requestParameters = new HashMap<String, String>();
            requestParameters.put("tenantId", tenantId);
            ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "weiXin", "obtainWeiXinPublicAccount", requestParameters);
            ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
            return (WeiXinAuthorizerInfo) apiRest.getData();
        }
    }

    public static List<WeiXinAuthorizerInfo> obtainWeiXinMiniPrograms(String tenantId) {
        String serviceName = ConfigurationUtils.getConfiguration(Constants.SERVICE_NAME);
        if (Constants.SERVICE_NAME_PLATFORM.equals(serviceName)) {
            SearchModel searchModel = new SearchModel(true);
            searchModel.addSearchCondition(WeiXinAuthorizerInfo.ColumnName.TENANT_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, tenantId);
            searchModel.addSearchCondition(WeiXinAuthorizerInfo.ColumnName.AUTHORIZER_TYPE, Constants.SQL_OPERATION_SYMBOL_EQUAL, Constants.AUTHORIZER_TYPE_MINI_PROGRAM);
            return DatabaseHelper.findAll(WeiXinAuthorizerInfo.class, searchModel);
        } else {
            Map<String, String> requestParameters = new HashMap<String, String>();
            requestParameters.put("tenantId", tenantId);
            ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "weiXin", "obtainWeiXinMiniPrograms", requestParameters);
            ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());

            List<Map<String, Object>> data = (List<Map<String, Object>>) apiRest.getData();

            List<WeiXinAuthorizerInfo> weiXinAuthorizerInfos = new ArrayList<WeiXinAuthorizerInfo>();
            for (Map<String, Object> map : data) {
                WeiXinAuthorizerInfo weiXinAuthorizerInfo = ApplicationHandler.buildObject(WeiXinAuthorizerInfo.class, map);
                weiXinAuthorizerInfos.add(weiXinAuthorizerInfo);
            }
            return weiXinAuthorizerInfos;
        }
    }
}
