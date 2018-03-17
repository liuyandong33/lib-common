package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URLEncoder;

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
}
