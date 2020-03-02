package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.constants.RedisKeys;
import build.dream.common.domains.saas.OauthClientDetail;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OauthClientDetailUtils {
    public static void rejoinCacheOauthClientDetails(List<OauthClientDetail> oauthClientDetails) {
        Map<String, String> oauthClientDetailMap = oauthClientDetails.stream().collect(Collectors.toMap(oauthClientDetail -> oauthClientDetail.getClientId(), oauthClientDetail -> JacksonUtils.writeValueAsString(oauthClientDetail)));
        CommonRedisUtils.del(RedisKeys.KEY_OAUTH_CLIENT_DETAILS);
        if (MapUtils.isNotEmpty(oauthClientDetailMap)) {
            CommonRedisUtils.hmset(Constants.KEY_USER_INFOS, oauthClientDetailMap);
        }
    }

    public static OauthClientDetail obtainOauthClientDetail(String clientId) {
        String oauthClientDetailJson = CommonRedisUtils.get(clientId);
        if (StringUtils.isNotBlank(oauthClientDetailJson)) {
            return JacksonUtils.readValue(oauthClientDetailJson, OauthClientDetail.class);
        }
        return null;
    }
}
