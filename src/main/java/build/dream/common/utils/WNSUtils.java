package build.dream.common.utils;

import build.dream.common.beans.WNSAccessToken;
import build.dream.common.constants.RedisKeys;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class WNSUtils {
    private static final String ACCESS_TOKEN_URL = "https://login.live.com/accesstoken.srf";

    public static WNSAccessToken obtainAccessToken(String clientId, String clientSecret) {
        String tokenJson = CommonRedisUtils.hget(RedisKeys.KEY_WNS_ACCESS_TOKENS, clientId);
        if (StringUtils.isNotBlank(tokenJson)) {
            return JacksonUtils.readValue(tokenJson, WNSAccessToken.class);
        }

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("grant_type", "client_credentials");
        requestParameters.put("client_id", clientId);
        requestParameters.put("client_secret", clientSecret);
        requestParameters.put("scope", "notify.windows.com");

        String result = OutUtils.doPostWithForm(ACCESS_TOKEN_URL, requestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        WNSAccessToken wnsAccessToken = new WNSAccessToken();
        wnsAccessToken.setAccessToken(MapUtils.getString(resultMap, "access_token"));
        wnsAccessToken.setTokenType(MapUtils.getString(resultMap, "token_type"));

        return wnsAccessToken;
    }
}
