package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.SystemUser;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils {
    public static String getServiceName(String business) {
        String serviceName = null;
        if (Constants.BUSINESS_CATERING.equals(business)) {
            serviceName = Constants.SERVICE_NAME_CATERING;
        } else if (Constants.BUSINESS_RETAIL.equals(business)) {
            serviceName = Constants.SERVICE_NAME_RETAIL;
        }
        return serviceName;
    }

    public static void loadServiceSystemUsers(List<SystemUser> systemUsers) throws IOException {
        CacheUtils.del(Constants.KEY_SERVICE_SYSTEM_USERS);
        Map<String, String> serviceSystemUserMap = new HashMap<String, String>();
        for (SystemUser systemUser : systemUsers) {
            serviceSystemUserMap.put(systemUser.getName(), systemUser.getId().toString());
        }
        if (MapUtils.isNotEmpty(serviceSystemUserMap)) {
            CacheUtils.hmset(Constants.KEY_SERVICE_SYSTEM_USERS, serviceSystemUserMap);
        }
    }

    public static BigInteger getServiceSystemUserId(String partitionCode, String serviceName) throws IOException {
        String userId = CacheUtils.hget(Constants.KEY_SERVICE_SYSTEM_USERS, partitionCode + ":" + serviceName);
        if (StringUtils.isNotBlank(userId)) {
            return BigInteger.valueOf(Long.valueOf(userId));
        }
        return null;
    }

    public static BigInteger getServiceSystemUserId() throws IOException {
        String partitionCode = PropertyUtils.getProperty(Constants.PARTITION_CODE);
        String serviceName = PropertyUtils.getProperty(Constants.SERVICE_NAME);
        String userId = CacheUtils.hget(Constants.KEY_SERVICE_SYSTEM_USERS, partitionCode + ":" + serviceName);
        if (StringUtils.isNotBlank(userId)) {
            return BigInteger.valueOf(Long.valueOf(userId));
        }
        return null;
    }
}
