package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.beans.WeiXinJsapiTicket;
import build.dream.common.constants.Constants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class WeChatUtils {
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

    public static final Map<String, String> generateJsApiConfig(String url, String appId, String appSecret) throws IOException {
        Map<String, String> obtainJsapiTicketRequestParameters = new HashMap<String, String>();
        obtainJsapiTicketRequestParameters.put("appId", appId);
        obtainJsapiTicketRequestParameters.put("appSecret", appSecret);
        obtainJsapiTicketRequestParameters.put("type", "jsapi");
        ApiRest obtainJsapiTicketApiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_OUT, "weiXin", "obtainJsapiTicket", obtainJsapiTicketRequestParameters);
        Validate.isTrue(obtainJsapiTicketApiRest.isSuccessful(), obtainJsapiTicketApiRest.getError());
        WeiXinJsapiTicket weiXinJsapiTicket = (WeiXinJsapiTicket) obtainJsapiTicketApiRest.getData();

        String ticket = weiXinJsapiTicket.getTicket();
        String nonceStr = RandomStringUtils.randomAlphanumeric(32);
        String timestamp = String.valueOf(System.currentTimeMillis());
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
}
