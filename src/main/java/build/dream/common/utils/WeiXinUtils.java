package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.beans.*;
import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.constants.Constants;
import build.dream.common.domains.saas.WeiXinAuthorizerInfo;
import build.dream.common.domains.saas.WeiXinAuthorizerToken;
import build.dream.common.models.weixin.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

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

    public static String generateComponentLoginPageUrl(String componentAppId, String preAuthCode, String redirectUri, String authType) {
        return COMPONENT_LOGIN_PAGE_URL + "?component_appid=" + componentAppId + "&pre_auth_code=" + preAuthCode + "&redirect_uri=" + UrlUtils.encode(redirectUri, Constants.CHARSET_NAME_UTF_8) + "&auth_type=" + authType;
    }

    public static String generateAuthorizeUrl(String appId, String scope, String redirectUri, String state) {
        return generateAuthorizeUrl(appId, scope, redirectUri, state, null);
    }

    public static String generateAuthorizeUrl(String appId, String scope, String redirectUri, String state, String componentAppId) {
        if (StringUtils.isBlank(scope)) {
            scope = Constants.SNSAPI_BASE;
        }
        StringBuilder authorizeUrl = new StringBuilder(WEI_XIN_AUTHORIZE_URL);
        authorizeUrl.append("?").append("appid=").append(appId);
        authorizeUrl.append("&redirect_uri=").append(UrlUtils.encode(redirectUri, Constants.CHARSET_NAME_UTF_8));
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

    public static Map<String, String> buildJsApiConfig(String appId, String jsapiTicket, String url) {
        String nonceStr = RandomStringUtils.randomAlphanumeric(32);
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String str = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
        String signature = DigestUtils.sha1Hex(str);

        Map<String, String> config = new HashMap<String, String>();
        config.put("appId", appId);
        config.put("timestamp", timestamp);
        config.put("nonceStr", nonceStr);
        config.put("url", url);
        config.put("signature", signature);
        return config;
    }

    public static Map<String, String> buildJsApiConfigByPublicAccount(String url, String appId, String appSecret) {
        WeiXinJsapiTicket weiXinJsapiTicket = obtainJsapiTicketByPublicAccount(appId, appSecret, Constants.WEI_XIN_TICKET_TYPE_JSAPI);
        return buildJsApiConfig(appId, weiXinJsapiTicket.getTicket(), url);
    }

    public static Map<String, String> buildJsApiConfigByThirdParty(String url, String componentAppId, String authorizerAppId) {
        WeiXinJsapiTicket weiXinJsapiTicket = obtainJsapiTicketByOpenPlatform(componentAppId, authorizerAppId, Constants.WEI_XIN_TICKET_TYPE_JSAPI);
        return buildJsApiConfig(authorizerAppId, weiXinJsapiTicket.getTicket(), url);
    }

    /**
     * 通过code换取网页授权access_token
     *
     * @param appId
     * @param secret
     * @param code
     * @return
     */
    public static WeiXinOAuthToken obtainOAuthToken(String appId, String secret, String code) {
        Map<String, String> obtainOAuthTokenRequestParameters = new HashMap<String, String>();
        obtainOAuthTokenRequestParameters.put("appid", appId);
        obtainOAuthTokenRequestParameters.put("secret", secret);
        obtainOAuthTokenRequestParameters.put("code", code);
        obtainOAuthTokenRequestParameters.put("grant_type", "authorization_code");

        String url = WEI_XIN_API_URL + "/sns/oauth2/access_token";
        String result = OutUtils.doGet(url, obtainOAuthTokenRequestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));

        WeiXinOAuthToken weiXinOAuthToken = new WeiXinOAuthToken();
        weiXinOAuthToken.setAccessToken(MapUtils.getString(resultMap, "access_token"));
        weiXinOAuthToken.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
        weiXinOAuthToken.setRefreshToken(MapUtils.getString(resultMap, "refresh_token"));
        weiXinOAuthToken.setOpenId(MapUtils.getString(resultMap, "openid"));
        weiXinOAuthToken.setScope(MapUtils.getString(resultMap, "scope"));

        return weiXinOAuthToken;
    }

    /**
     * 通过code换取网页授权access_token
     *
     * @param appId
     * @param code
     * @param componentAppId
     * @param componentAccessToken
     * @return
     */
    public static WeiXinOAuthToken obtainOAuthToken(String appId, String code, String componentAppId, String componentAccessToken) {
        Map<String, String> obtainOAuthTokenRequestParameters = new HashMap<String, String>();
        obtainOAuthTokenRequestParameters.put("appid", appId);
        obtainOAuthTokenRequestParameters.put("code", code);
        obtainOAuthTokenRequestParameters.put("grant_type", "authorization_code");
        obtainOAuthTokenRequestParameters.put("component_appid", componentAppId);
        obtainOAuthTokenRequestParameters.put("component_access_token", componentAccessToken);

        String url = WEI_XIN_API_URL + "/sns/oauth2/component/access_token";
        String result = OutUtils.doGet(url, obtainOAuthTokenRequestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));

        WeiXinOAuthToken weiXinOAuthToken = new WeiXinOAuthToken();
        weiXinOAuthToken.setAccessToken(MapUtils.getString(resultMap, "access_token"));
        weiXinOAuthToken.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
        weiXinOAuthToken.setRefreshToken(MapUtils.getString(resultMap, "refresh_token"));
        weiXinOAuthToken.setOpenId(MapUtils.getString(resultMap, "openid"));
        weiXinOAuthToken.setScope(MapUtils.getString(resultMap, "scope"));

        return weiXinOAuthToken;
    }

    /**
     * 拉取用户信息
     *
     * @param authorizerAccessToken
     * @param openId
     * @param lang
     * @return
     */
    public static WeiXinUserInfo obtainUserInfoByThirdParty(String authorizerAccessToken, String openId, String lang) {
        return obtainUserInfo(authorizerAccessToken, openId, lang, Constants.IDENTITY_TYPE_THIRD_PARTY_APPLICATION);
    }

    /**
     * 拉取用户信息
     *
     * @param accessToken
     * @param openId
     * @param lang
     * @return
     */
    public static WeiXinUserInfo obtainUserInfo(String accessToken, String openId, String lang) {
        return obtainUserInfo(accessToken, openId, lang, Constants.IDENTITY_TYPE_PUBLIC_ACCOUNT);
    }

    /**
     * 拉取用户信息
     *
     * @param token
     * @param openId
     * @param lang
     * @param type
     * @return
     */
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
        String result = OutUtils.doGet(url, obtainUserInfoRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));

        WeiXinUserInfo weiXinUserInfo = new WeiXinUserInfo();
        weiXinUserInfo.setOpenId(MapUtils.getString(resultMap, "openid"));
        weiXinUserInfo.setNickname(MapUtils.getString(resultMap, "nickname"));
        weiXinUserInfo.setSex(MapUtils.getIntValue(resultMap, "sex"));
        weiXinUserInfo.setProvince(MapUtils.getString(resultMap, "province"));
        weiXinUserInfo.setCity(MapUtils.getString(resultMap, "city"));
        weiXinUserInfo.setCountry(MapUtils.getString(resultMap, "country"));
        weiXinUserInfo.setHeadImgUrl(MapUtils.getString(resultMap, "headimgurl"));
        weiXinUserInfo.setPrivilege(MapUtils.getString(resultMap, "privilege"));
        weiXinUserInfo.setUnionId(MapUtils.getString(resultMap, "unionid"));

        return weiXinUserInfo;
    }

    /**
     * 根据OpenID列表群发
     *
     * @param accessToken
     * @param sendMassMessageModel
     * @return
     */
    public static Map<String, Object> sendMassMessage(String accessToken, SendMassMessageModel sendMassMessageModel) {
        String url = WEI_XIN_API_URL + "/message/mass/send?access_token=" + accessToken;
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(sendMassMessageModel, JsonInclude.Include.NON_NULL), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取access_token
     *
     * @param appId
     * @return
     */
    private static WeiXinAccessToken obtainAccessToken(String appId) {
        String weiXinAccessTokenJson = CommonRedisUtils.hget(Constants.KEY_WEI_XIN_ACCESS_TOKENS, appId);
        if (StringUtils.isBlank(weiXinAccessTokenJson)) {
            return null;
        }
        WeiXinAccessToken weiXinAccessToken = JacksonUtils.readValue(weiXinAccessTokenJson, WeiXinAccessToken.class);
        if ((System.currentTimeMillis() - weiXinAccessToken.getFetchTime().getTime()) / 1000 >= weiXinAccessToken.getExpiresIn()) {
            return null;
        }
        return weiXinAccessToken;
    }

    /**
     * 获取access_token
     *
     * @param appId
     * @param secret
     * @return
     */
    public static WeiXinAccessToken obtainAccessToken(String appId, String secret) {
        WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId);
        if (Objects.nonNull(weiXinAccessToken)) {
            return weiXinAccessToken;
        }

        Map<String, String> obtainAccessTokenRequestParameters = new HashMap<String, String>();
        obtainAccessTokenRequestParameters.put("appid", appId);
        obtainAccessTokenRequestParameters.put("secret", secret);
        obtainAccessTokenRequestParameters.put("grant_type", "client_credential");
        String url = WEI_XIN_API_URL + "/cgi-bin/token";
        String result = OutUtils.doGet(url, obtainAccessTokenRequestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));

        weiXinAccessToken = new WeiXinAccessToken();
        weiXinAccessToken.setAccessToken(MapUtils.getString(resultMap, "access_token"));
        weiXinAccessToken.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
        weiXinAccessToken.setFetchTime(new Date());
        CommonRedisUtils.hset(Constants.KEY_WEI_XIN_ACCESS_TOKENS, appId, JacksonUtils.writeValueAsString(weiXinAccessToken));
        return weiXinAccessToken;
    }

    /**
     * 获取api_ticket
     *
     * @param appId
     * @param type
     * @return
     */
    private static WeiXinJsapiTicket obtainJsapiTicket(String appId, String type) {
        String weiXinJsapiTicketJson = CommonRedisUtils.hget(Constants.KEY_WEI_XIN_JSAPI_TICKETS + "_" + type, appId);
        if (StringUtils.isBlank(weiXinJsapiTicketJson)) {
            return null;
        }

        WeiXinJsapiTicket weiXinJsapiTicket = JacksonUtils.readValue(weiXinJsapiTicketJson, WeiXinJsapiTicket.class);
        if ((System.currentTimeMillis() - weiXinJsapiTicket.getFetchTime().getTime()) / 1000 >= weiXinJsapiTicket.getExpiresIn()) {
            return weiXinJsapiTicket;
        }
        return null;
    }

    /**
     * 获取api_ticket
     *
     * @param accessToken
     * @param appId
     * @param type
     * @return
     */
    private static WeiXinJsapiTicket getTicket(String accessToken, String appId, String type) {
        Map<String, String> obtainJsapiTicketRequestParameters = new HashMap<String, String>();
        obtainJsapiTicketRequestParameters.put("access_token", accessToken);
        obtainJsapiTicketRequestParameters.put("type", type);

        String url = WEI_XIN_API_URL + "/cgi-bin/ticket/getticket";
        String result = OutUtils.doGet(url, obtainJsapiTicketRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));

        WeiXinJsapiTicket weiXinJsapiTicket = new WeiXinJsapiTicket();
        weiXinJsapiTicket.setTicket(MapUtils.getString(resultMap, "ticket"));
        weiXinJsapiTicket.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
        weiXinJsapiTicket.setFetchTime(new Date());
        CommonRedisUtils.hset(Constants.KEY_WEI_XIN_JSAPI_TICKETS + "_" + type, appId, JacksonUtils.writeValueAsString(weiXinJsapiTicket));
        return weiXinJsapiTicket;
    }

    /**
     * 获取api_ticket
     *
     * @param appId
     * @param appSecret
     * @param type
     * @return
     */
    public static WeiXinJsapiTicket obtainJsapiTicketByPublicAccount(String appId, String appSecret, String type) {
        WeiXinJsapiTicket weiXinJsapiTicket = obtainJsapiTicket(appId, type);

        if (Objects.isNull(weiXinJsapiTicket)) {
            WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, appSecret);
            weiXinJsapiTicket = getTicket(weiXinAccessToken.getAccessToken(), appId, type);
        }
        return weiXinJsapiTicket;
    }

    /**
     * 获取api_ticket
     *
     * @param componentAppId
     * @param authorizerAppId
     * @param type
     * @return
     */
    public static WeiXinJsapiTicket obtainJsapiTicketByOpenPlatform(String componentAppId, String authorizerAppId, String type) {
        WeiXinJsapiTicket weiXinJsapiTicket = obtainJsapiTicket(authorizerAppId, type);

        if (Objects.isNull(weiXinJsapiTicket)) {
            String authorizerToken = obtainAuthorizerToken(componentAppId, authorizerAppId);
            weiXinJsapiTicket = getTicket(authorizerToken, authorizerAppId, type);
        }
        return weiXinJsapiTicket;
    }

    /**
     * 创建卡券
     *
     * @param baseInfoModel
     * @param advancedInfoModel
     * @param dealDetail
     * @param accessToken
     * @return
     */
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
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(groupon, JsonInclude.Include.NON_NULL), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));

        return resultMap;
    }

    /**
     * 发送模板消息
     *
     * @param appId
     * @param secret
     * @param sendTemplateMessageModel
     * @return
     */
    public static Map<String, Object> sendTemplateMessage(String appId, String secret, SendTemplateMessageModel sendTemplateMessageModel) {
        WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, secret);
        return sendTemplateMessage(weiXinAccessToken.getAccessToken(), sendTemplateMessageModel);
    }

    /**
     * 发送模板消息
     *
     * @param componentAppId
     * @param authorizerAppId
     * @param sendTemplateMessageModel
     * @return
     */
    public static Map<String, Object> sendTemplateMessageByThirdParty(String componentAppId, String authorizerAppId, SendTemplateMessageModel sendTemplateMessageModel) {
        return sendTemplateMessage(obtainAuthorizerToken(componentAppId, authorizerAppId), sendTemplateMessageModel);
    }

    /**
     * 发送模板消息
     *
     * @param accessToken
     * @param sendTemplateMessageModel
     * @return
     */
    public static Map<String, Object> sendTemplateMessage(String accessToken, SendTemplateMessageModel sendTemplateMessageModel) {
        String toUser = sendTemplateMessageModel.getToUser();
        String templateId = sendTemplateMessageModel.getTemplateId();
        String url = sendTemplateMessageModel.getUrl();
        Map<String, Object> miniProgram = sendTemplateMessageModel.getMiniProgram();
        Map<String, Object> data = sendTemplateMessageModel.getData();
        String color = sendTemplateMessageModel.getColor();

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("touser", toUser);
        body.put("template_id", templateId);
        if (StringUtils.isNotBlank(url)) {
            body.put("url", url);
        }

        if (MapUtils.isNotEmpty(miniProgram)) {
            body.put("miniprogram", miniProgram);
        }

        body.put("data", data);

        if (StringUtils.isNotBlank(color)) {
            body.put("color", color);
        }
        String _url = WEI_XIN_API_URL + "/cgi-bin/message/template/send?access_token=" + accessToken;
        String result = OutUtils.doPostWithRequestBody(_url, JacksonUtils.writeValueAsString(body), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));

        return resultMap;
    }

    /**
     * 获取第三方平台component_access_token
     *
     * @param componentAppId
     * @return
     */
    private static ComponentAccessToken obtainComponentAccessToken(String componentAppId) {
        String componentAccessTokenJson = CommonRedisUtils.hget(Constants.KEY_WEI_XIN_COMPONENT_ACCESS_TOKENS, componentAppId);
        if (StringUtils.isBlank(componentAccessTokenJson)) {
            return null;
        }

        ComponentAccessToken componentAccessToken = JacksonUtils.readValue(componentAccessTokenJson, ComponentAccessToken.class);
        if ((System.currentTimeMillis() - componentAccessToken.getFetchTime().getTime()) / 1000 < componentAccessToken.getExpiresIn()) {
            return componentAccessToken;
        }
        return null;
    }

    /**
     * 获取第三方平台component_access_token
     *
     * @param componentAppId
     * @param componentAppSecret
     * @return
     */
    private static ComponentAccessToken apiComponentToken(String componentAppId, String componentAppSecret) {
        String componentVerifyTicket = CommonRedisUtils.hget(Constants.KEY_WEI_XIN_COMPONENT_VERIFY_TICKETS, componentAppId);
        ValidateUtils.notBlank(componentVerifyTicket, "component_verify_ticket 不存在！");
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_component_token";
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        requestBody.put("component_appsecret", componentAppSecret);
        requestBody.put("component_verify_ticket", componentVerifyTicket);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));

        ComponentAccessToken componentAccessToken = new ComponentAccessToken();
        componentAccessToken.setComponentAccessToken(MapUtils.getString(resultMap, "component_access_token"));
        componentAccessToken.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
        componentAccessToken.setFetchTime(new Date());
        CommonRedisUtils.hset(Constants.KEY_WEI_XIN_COMPONENT_ACCESS_TOKENS, componentAppId, JacksonUtils.writeValueAsString(componentAccessToken));
        return componentAccessToken;
    }

    /**
     * 获取第三方平台component_access_token
     *
     * @param componentAppId
     * @param componentAppSecret
     * @return
     */
    public static ComponentAccessToken obtainComponentAccessToken(String componentAppId, String componentAppSecret) {
        ComponentAccessToken componentAccessToken = obtainComponentAccessToken(componentAppId);
        if (Objects.isNull(componentAccessToken)) {
            componentAccessToken = apiComponentToken(componentAppId, componentAppSecret);
        }
        return componentAccessToken;
    }

    /**
     * 获取预授权码pre_auth_code
     *
     * @param componentAppId
     * @param componentAppSecret
     * @return
     */
    public static String obtainPreAuthCode(String componentAppId, String componentAppSecret) {
        ComponentAccessToken componentAccessToken = obtainComponentAccessToken(componentAppId, componentAppSecret);
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_create_preauthcode?component_access_token=" + componentAccessToken.getComponentAccessToken();
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));
        return MapUtils.getString(resultMap, "pre_auth_code");
    }

    /**
     * 使用授权码换取公众号或小程序的接口调用凭据和授权信息
     *
     * @param componentAccessToken
     * @param componentAppId
     * @param authorizationCode
     * @return
     */
    public static WeiXinAuthorizerToken apiQueryAuth(String componentAccessToken, String componentAppId, String authorizationCode) {
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_query_auth?component_access_token=" + componentAccessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        requestBody.put("authorization_code", authorizationCode);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));

        Map<String, Object> authorizationInfo = MapUtils.getMap(resultMap, "authorization_info");
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
        CommonRedisUtils.hset(Constants.KEY_WEI_XIN_AUTHORIZER_TOKENS, componentAppId + "_" + authorizerAppId, JacksonUtils.writeValueAsString(weiXinAuthorizerToken));
        return weiXinAuthorizerToken;
    }

    /**
     * 获取公众号或小程序的授权token
     *
     * @param componentAppId
     * @param authorizerAppId
     * @return
     */
    public static WeiXinAuthorizerToken obtainWeiXinAuthorizerToken(String componentAppId, String authorizerAppId) {
        String tokenJson = CommonRedisUtils.hget(Constants.KEY_WEI_XIN_AUTHORIZER_TOKENS, componentAppId + "_" + authorizerAppId);
        ValidateUtils.notBlank(tokenJson, "授权信息不存在！");
        return JacksonUtils.readValue(tokenJson, WeiXinAuthorizerToken.class);
    }

    /**
     * 获取公众号或小程序的授权token
     *
     * @param componentAppId
     * @param authorizerAppId
     * @return
     */
    public static String obtainAuthorizerToken(String componentAppId, String authorizerAppId) {
        WeiXinAuthorizerToken weiXinAuthorizerToken = obtainWeiXinAuthorizerToken(componentAppId, authorizerAppId);
        return weiXinAuthorizerToken.getAuthorizerAccessToken();
    }

    /**
     * 自定义菜单创建接口
     *
     * @param accessToken
     * @param createMenuModel
     * @return
     */
    public static Map<String, Object> createMenu(String accessToken, CreateMenuModel createMenuModel) {
        createMenuModel.validateAndThrow();
        String url = WEI_XIN_API_URL + "/cgi-bin/menu/create?access_token=" + accessToken;
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(createMenuModel, JsonInclude.Include.NON_NULL), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 创建门店
     *
     * @param accessToken
     * @param addPoiModel
     * @return
     */
    public static Map<String, Object> addPoi(String accessToken, AddPoiModel addPoiModel) {
        addPoiModel.validateAndThrow();
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("business", addPoiModel);

        String url = WEI_XIN_API_URL + "/cgi-bin/poi/addpoi?access_token=" + accessToken;
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody, JsonInclude.Include.NON_NULL), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取授权方的帐号基本信息
     *
     * @param componentAccessToken
     * @param componentAppId
     * @param authorizerAppId
     * @return
     */
    public static WeiXinAuthorizerInfo apiGetAuthorizerInfo(String componentAccessToken, String componentAppId, String authorizerAppId) {
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_get_authorizer_info?component_access_token=" + componentAccessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        requestBody.put("authorizer_appid", authorizerAppId);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));

        Map<String, Object> authorizerInfo = MapUtils.getMap(resultMap, "authorizer_info");

        WeiXinAuthorizerInfo weiXinAuthorizerInfo = new WeiXinAuthorizerInfo();
        weiXinAuthorizerInfo.setNickName(MapUtils.getString(authorizerInfo, "nick_name"));

        String headImg = MapUtils.getString(authorizerInfo, "head_img");
        weiXinAuthorizerInfo.setHeadImg(StringUtils.isNotBlank(headImg) ? headImg : Constants.VARCHAR_DEFAULT_VALUE);

        weiXinAuthorizerInfo.setServiceTypeInfo(JacksonUtils.writeValueAsString(authorizerInfo.get("service_type_info")));
        weiXinAuthorizerInfo.setVerifyTypeInfo(JacksonUtils.writeValueAsString(authorizerInfo.get("verify_type_info")));
        weiXinAuthorizerInfo.setOriginalId(MapUtils.getString(authorizerInfo, "user_name"));
        weiXinAuthorizerInfo.setPrincipalName(MapUtils.getString(authorizerInfo, "principal_name"));

        String alias = MapUtils.getString(authorizerInfo, "alias");
        weiXinAuthorizerInfo.setAlias(StringUtils.isNotBlank(alias) ? alias : Constants.VARCHAR_DEFAULT_VALUE);

        weiXinAuthorizerInfo.setBusinessInfo(JacksonUtils.writeValueAsString(authorizerInfo.get("business_info")));
        weiXinAuthorizerInfo.setQrcodeUrl(MapUtils.getString(authorizerInfo, "qrcode_url"));
        weiXinAuthorizerInfo.setSignature(MapUtils.getString(authorizerInfo, "signature"));

        Object miniProgramInfo = authorizerInfo.get("MiniProgramInfo");
        if (Objects.nonNull(miniProgramInfo)) {
            weiXinAuthorizerInfo.setAuthorizerType(Constants.AUTHORIZER_TYPE_PUBLIC_ACCOUNT);
            weiXinAuthorizerInfo.setMiniProgramInfo(JacksonUtils.writeValueAsString(miniProgramInfo));
        } else {
            weiXinAuthorizerInfo.setAuthorizerType(Constants.AUTHORIZER_TYPE_MINI_PROGRAM);
            weiXinAuthorizerInfo.setMiniProgramInfo(Constants.VARCHAR_DEFAULT_VALUE);
        }

        Map<String, Object> authorizationInfo = MapUtils.getMap(resultMap, "authorization_info");
        weiXinAuthorizerInfo.setAuthorizerAppId(MapUtils.getString(authorizationInfo, "authorizer_appid"));
        weiXinAuthorizerInfo.setFuncInfo(JacksonUtils.writeValueAsString(authorizationInfo.get("func_info")));
        weiXinAuthorizerInfo.setComponentAppId(componentAppId);
        return weiXinAuthorizerInfo;
    }

    /**
     * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌
     *
     * @param componentAccessToken
     * @param componentAppId
     * @param authorizerAppId
     * @param authorizerRefreshToken
     * @return
     */
    public static WeiXinAuthorizerToken apiAuthorizerToken(String componentAccessToken, String componentAppId, String authorizerAppId, String authorizerRefreshToken) {
        String url = WEI_XIN_API_URL + "/cgi-bin/component/api_authorizer_token?component_access_token=" + componentAccessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("component_appid", componentAppId);
        requestBody.put("authorizer_appid", authorizerAppId);
        requestBody.put("authorizer_refresh_token", authorizerRefreshToken);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));

        WeiXinAuthorizerToken weiXinAuthorizerToken = new WeiXinAuthorizerToken();
        weiXinAuthorizerToken.setComponentAppId(componentAppId);
        weiXinAuthorizerToken.setAuthorizerAppId(authorizerAppId);
        weiXinAuthorizerToken.setAuthorizerAccessToken(MapUtils.getString(resultMap, "authorizer_access_token"));
        weiXinAuthorizerToken.setExpiresIn(MapUtils.getIntValue(resultMap, "expires_in"));
        weiXinAuthorizerToken.setAuthorizerRefreshToken(MapUtils.getString(resultMap, "authorizer_refresh_token"));
        weiXinAuthorizerToken.setFetchTime(new Date());
        return weiXinAuthorizerToken;
    }

    /**
     * 客服接口-发消息
     *
     * @param appId
     * @param secret
     * @param message
     * @return
     */
    public static Map<String, Object> sendCustomMessage(String appId, String secret, String message) {
        WeiXinAccessToken weiXinAccessToken = obtainAccessToken(appId, secret);
        return sendCustomMessage(weiXinAccessToken.getAccessToken(), message);
    }

    /**
     * 客服接口-发消息
     *
     * @param accessToken
     * @param message
     * @return
     */
    public static Map<String, Object> sendCustomMessage(String accessToken, String message) {
        String url = WEI_XIN_API_URL + "/cgi-bin/message/custom/send?access_token=" + accessToken;
        String result = OutUtils.doPostWithRequestBody(url, message, Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
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

        String result = OutUtils.doGet(url, requestParameters);
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

        String result = OutUtils.doGet(url, requestParameters);
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
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
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
        String authorizerAccessTokenJson = CommonRedisUtils.hget(Constants.KEY_WEI_XIN_AUTHORIZER_TOKENS, componentAppId + "_" + authorizerAppId);
        ValidateUtils.notBlank(authorizerAccessTokenJson, "未查询到 authorizer_access_token！");

        Map<String, Object> authorizerAccessToken = JacksonUtils.readValueAsMap(authorizerAccessTokenJson, String.class, Object.class);
        Map<String, String> getAccountBasicInfoRequestParameters = new HashMap<String, String>();
        getAccountBasicInfoRequestParameters.put("access_token", MapUtils.getString(authorizerAccessToken, "authorizerAccessToken"));

        String url = WEI_XIN_API_URL + "/cgi-bin/account/getaccountbasicinfo";
        String result = OutUtils.doGet(url, null, getAccountBasicInfoRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doGet(url, getTemplateDraftListRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doGet(url, getTemplateListRequestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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
        String result = OutUtils.doPostWithRequestBody(url, null, Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
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

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(MapUtils.getIntValue(resultMap, "errcode") == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    public static WeiXinAuthorizerInfo obtainWeiXinPublicAccount(String tenantId) {
        String serviceName = ConfigurationUtils.getConfiguration(ConfigurationKeys.SERVICE_NAME);
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
        String serviceName = ConfigurationUtils.getConfiguration(ConfigurationKeys.SERVICE_NAME);
        if (Constants.SERVICE_NAME_PLATFORM.equals(serviceName)) {
            SearchModel searchModel = new SearchModel(true);
            searchModel.addSearchCondition(WeiXinAuthorizerInfo.ColumnName.TENANT_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, tenantId);
            searchModel.addSearchCondition(WeiXinAuthorizerInfo.ColumnName.AUTHORIZER_TYPE, Constants.SQL_OPERATION_SYMBOL_EQUAL, Constants.AUTHORIZER_TYPE_MINI_PROGRAM);
            return DatabaseHelper.findAll(WeiXinAuthorizerInfo.class, searchModel);
        }

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

    /**
     * 获得模板ID
     *
     * @param accessToken
     * @param templateIdShort
     * @return
     */
    public static Map<String, Object> apiAddTemplate(String accessToken, String templateIdShort) {
        String url = WEI_XIN_API_URL + "/cgi-bin/template/api_add_template?access_token=" + accessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("template_id_short", templateIdShort);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取模板列表
     *
     * @param accessToken
     * @return
     */
    public static List<Map<String, Object>> getAllPrivateTemplate(String accessToken) {
        String url = WEI_XIN_API_URL + "/cgi-bin/template/get_all_private_template";
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("access_token", accessToken);
        String result = OutUtils.doGet(url, requestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));
        return (List<Map<String, Object>>) resultMap.get("template_list");
    }

    public static String obtainTemplateId(List<Map<String, Object>> templates, String title, String content, String example) {
        for (Map<String, Object> template : templates) {
            String templateTitle = MapUtils.getString(template, "title");
            String templateContent = MapUtils.getString(template, "content");
            String templateExample = MapUtils.getString(template, "example");
            if (title.equals(templateTitle) && content.equals(templateContent) && example.equals(templateExample)) {
                return MapUtils.getString(template, "template_id");
            }
        }
        return null;
    }

    /**
     * 设置所属行业
     *
     * @param accessToken
     * @param industryId1
     * @param industryId2
     * @return
     */
    public static Map<String, Object> apiSetIndustry(String accessToken, String industryId1, String industryId2) {
        String url = WEI_XIN_API_URL + "/cgi-bin/template/api_set_industry?access_token=" + accessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("industry_id1", industryId1);
        requestBody.put("industry_id2", industryId2);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取设置的行业信息
     *
     * @param accessToken
     * @return
     */
    public static Map<String, Object> getIndustry(String accessToken) {
        String url = WEI_XIN_API_URL + "/cgi-bin/template/get_industry";
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("access_token", accessToken);
        String result = OutUtils.doGet(url, requestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 删除模板
     *
     * @param accessToken
     * @param templateId
     * @return
     */
    public static Map<String, Object> delPrivateTemplate(String accessToken, String templateId) {
        String url = WEI_XIN_API_URL + "/cgi-bin/template/del_private_template?access_token=" + accessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("template_id", templateId);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 创建标签
     *
     * @param accessToken
     * @param name
     * @return
     */
    public static Map<String, Object> createTag(String accessToken, String name) {
        String url = WEI_XIN_API_URL + "/cgi-bin/tags/create?access_token=" + accessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("name", name);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取公众号已创建的标签
     *
     * @param accessToken
     * @return
     */
    public static Map<String, Object> obtainTags(String accessToken) {
        String url = WEI_XIN_API_URL + "/cgi-bin/tags/get";
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("access_token", accessToken);
        String result = OutUtils.doGet(url, requestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 编辑标签
     *
     * @param accessToken
     * @param id
     * @param name
     * @return
     */
    public static Map<String, Object> updateTag(String accessToken, String id, String name) {
        String url = WEI_XIN_API_URL + "/cgi-bin/tags/update?access_token=" + accessToken;
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("id", id);
        tag.put("name", name);

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("tag", tag);

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 删除标签
     *
     * @param accessToken
     * @param id
     * @return
     */
    public static Map<String, Object> deleteTag(String accessToken, String id) {
        String url = WEI_XIN_API_URL + "/cgi-bin/tags/delete?access_token=" + accessToken;

        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("id", id);

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("tag", tag);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取标签下粉丝列表
     *
     * @param accessToken
     * @param tagId
     * @param nextOpenId
     * @return
     */
    public static Map<String, Object> obtainUsers(String accessToken, String tagId, String nextOpenId) {
        String url = WEI_XIN_API_URL + "/cgi-bin/user/tag/get?access_token=" + accessToken;

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("tagid", tagId);

        if (StringUtils.isNotBlank(nextOpenId)) {
            requestBody.put("next_openid", nextOpenId);
        }

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 批量为用户打标签
     *
     * @param accessToken
     * @param openIdList
     * @param tagId
     * @return
     */
    public static Map<String, Object> batchTagging(String accessToken, List<String> openIdList, String tagId) {
        String url = WEI_XIN_API_URL + "/cgi-bin/tags/members/batchtagging?access_token=" + accessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("openid_list", openIdList);
        requestBody.put("tagid", tagId);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 批量为用户取消标签
     *
     * @param accessToken
     * @param openIdList
     * @param tagId
     * @return
     */
    public static Map<String, Object> batchUnTagging(String accessToken, List<String> openIdList, String tagId) {
        String url = WEI_XIN_API_URL + "/cgi-bin/tags/members/batchuntagging?access_token=" + accessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("openid_list", openIdList);
        requestBody.put("tagid", tagId);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 获取用户身上的标签列表
     *
     * @param accessToken
     * @param openId
     * @return
     */
    public static Map<String, Object> obtainTags(String accessToken, String openId) {
        String url = WEI_XIN_API_URL + "/cgi-bin/tags/getidlist?access_token=" + accessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("openid", openId);
        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        ValidateUtils.isTrue(!resultMap.containsKey("errcode"), MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }

    /**
     * 快速创建小程序
     *
     * @param componentAccessToken
     * @param name
     * @param code
     * @param codeType
     * @param legalPersonaWeChat
     * @param legalPersonaName
     * @param componentPhone
     * @return
     */
    public static Map<String, Object> fastRegisterWeApp(String componentAccessToken, String name, String code, String codeType, String legalPersonaWeChat, String legalPersonaName, String componentPhone) {
        String url = WEI_XIN_API_URL + "/cgi-bin/component/fastregisterweapp?action=create&component_access_token=" + componentAccessToken;
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("name", name);
        requestBody.put("code", code);
        requestBody.put("code_type", codeType);
        requestBody.put("legal_persona_wechat", legalPersonaWeChat);
        requestBody.put("legal_persona_name", legalPersonaName);
        requestBody.put("component_phone", componentPhone);

        String result = OutUtils.doPostWithRequestBody(url, JacksonUtils.writeValueAsString(requestBody), Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        int errcode = MapUtils.getIntValue(resultMap, "errcode");
        ValidateUtils.isTrue(errcode == 0, MapUtils.getString(resultMap, "errmsg"));
        return resultMap;
    }
}
