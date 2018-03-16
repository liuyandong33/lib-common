package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URLEncoder;

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
}
