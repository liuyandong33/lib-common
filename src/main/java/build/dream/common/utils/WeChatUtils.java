package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class WeChatUtils {
    private static final String WE_CHAT_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";
    private static final String WE_CHAT_OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    public static String generateAuthorizeUrl(String appId, String scope, String redirectUri, String state) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(scope)) {
            scope = "snsapi_base";
        }
        StringBuffer authorizeUrl = new StringBuffer(WE_CHAT_AUTHORIZE_URL);
        authorizeUrl.append("?").append("appid=").append(appId);
        authorizeUrl.append("&redirect_uri=").append(URLEncoder.encode(redirectUri, "UTF-8"));
        authorizeUrl.append("&response_type=code");
        authorizeUrl.append("&scope=").append(scope);
        if (StringUtils.isNotBlank(state)) {
            if (state.length() > 128) {
                state = state.substring(0, 128);
            }
            authorizeUrl.append("&state=").append(state);
        }
        authorizeUrl.append("&#wechat_redirect");
        return authorizeUrl.toString();
    }

    public static ApiRest oAuthAccessToken(String appid, String secret, String code) throws IOException {
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("appid", appid);
        requestParameters.put("secret", secret);
        requestParameters.put("code", code);
        requestParameters.put("grant_type", "authorization_code");
        String result = WebUtils.doGetWithRequestParameters(WE_CHAT_OAUTH2_ACCESS_TOKEN_URL, requestParameters);
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

        ApiRest apiRest = new ApiRest();
        if (jsonObject.has("errcode")) {
            apiRest.setSuccessful(false);
            apiRest.setError(jsonObject.get("errmsg").getAsString());
        } else {
            Map<String, String> data = new HashMap<String, String>();
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                data.put(entry.getKey(), entry.getValue().getAsString());
            }
            apiRest.setData(data);
            apiRest.setSuccessful(true);
            apiRest.setMessage("获取access token 成功！");
        }
        return apiRest;
    }
}
