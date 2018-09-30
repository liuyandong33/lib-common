package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;

import java.util.HashMap;
import java.util.Map;

public class UserUtils {
    public Map<String, Object> obtainUserInfo(String loginName) {
        Map<String, String> obtainUserInfoRequestParameters = new HashMap<String, String>();
        obtainUserInfoRequestParameters.put("loginName", loginName);

        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "user", "obtainUserInfo", obtainUserInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());

        return (Map<String, Object>) apiRest.getData();
    }
}
