package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.SystemUser;
import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserUtils {
    public static SystemUser obtainUserInfo(String userId) {
        String userInfoJson = CommonRedisUtils.hget(Constants.KEY_USER_INFOS, userId);
        if (StringUtils.isBlank(userInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(userInfoJson, SystemUser.class);
    }

    public static SystemUser obtainUserInfo(BigInteger userId) {
        return obtainUserInfo(userId.toString());
    }

    public static List<Map<String, Object>> batchGetUsers(List<BigInteger> userIds) {
        Map<String, String> batchGetUsersRequestParameters = new HashMap<String, String>();
        batchGetUsersRequestParameters.put("userIds", StringUtils.join(userIds, ","));

        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "user", "batchGetUsers", batchGetUsersRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
        return (List<Map<String, Object>>) apiRest.getData();
    }
}
