package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.SystemUser;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static void cacheUserInfo(SystemUser systemUser) {
        CommonRedisUtils.hset(Constants.KEY_USER_INFOS, systemUser.getId().toString(), JacksonUtils.writeValueAsString(systemUser));
    }

    public static List<SystemUser> batchGetUsers(List<BigInteger> userIds) {
        List<String> userInfos = CommonRedisUtils.hmget(Constants.KEY_USER_INFOS, userIds.stream().map(userId -> userId.toString()).collect(Collectors.toList()));
        List<SystemUser> systemUsers = new ArrayList<SystemUser>();
        userInfos.forEach(userInfo -> systemUsers.add(JacksonUtils.readValue(userInfo, SystemUser.class)));
        return systemUsers;
    }

    public static void rejoinCacheUserInfos(List<SystemUser> systemUsers) {
        Map<String, String> userInfos = new HashMap<String, String>();
        for (SystemUser systemUser : systemUsers) {
            userInfos.put(systemUser.getId().toString(), JacksonUtils.writeValueAsString(systemUser));
        }

        CommonRedisUtils.del(Constants.KEY_USER_INFOS);
        if (MapUtils.isNotEmpty(userInfos)) {
            CommonRedisUtils.hmset(Constants.KEY_USER_INFOS, userInfos);
        }
    }
}
