package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserUtils {
    public static Map<String, Object> obtainUserInfo(String loginName) {
        Map<String, String> obtainUserInfoRequestParameters = new HashMap<String, String>();
        obtainUserInfoRequestParameters.put("loginName", loginName);

        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "user", "obtainUserInfo", obtainUserInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());

        return (Map<String, Object>) apiRest.getData();
    }

    public static List<Map<String, Object>> batchGetUsers(List<BigInteger> userIds) {
        Map<String, String> batchGetUsersRequestParameters = new HashMap<String, String>();
        batchGetUsersRequestParameters.put("userIds", StringUtils.join(userIds, ","));

        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "user", "batchGetUsers", batchGetUsersRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
        return (List<Map<String, Object>>) apiRest.getData();
    }
}
