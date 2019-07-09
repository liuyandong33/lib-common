package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.Tenant;
import org.apache.commons.lang.StringUtils;
import scala.Tuple2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TenantUtils {
    public static Tenant obtainTenantInfo(BigInteger tenantId) {
        String tenantInfoJson = CommonRedisUtils.hget(Constants.KEY_TENANT_INFOS, "_id_" + tenantId);
        if (StringUtils.isBlank(tenantInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(tenantInfoJson, Tenant.class);
    }

    public static Tenant obtainTenantInfo(String tenantCode) {
        String tenantInfoJson = CommonRedisUtils.hget(Constants.KEY_TENANT_INFOS, "_code_" + tenantCode);
        if (StringUtils.isBlank(tenantInfoJson)) {
            return null;
        }
        return JacksonUtils.readValue(tenantInfoJson, Tenant.class);
    }

    public static void updateTenantInfo(BigInteger tenantId, BigInteger userId, Tuple2<String, String>... fields) {
        Map<String, String> updateTenantInfoRequestParameters = new HashMap<String, String>();
        updateTenantInfoRequestParameters.put("id", tenantId.toString());
        updateTenantInfoRequestParameters.put("userId", userId.toString());
        for (Tuple2<String, String> field : fields) {
            updateTenantInfoRequestParameters.put(field._1(), field._2());
        }
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "tenant", "updateTenantInfo", updateTenantInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
    }

    public static void updateTenantInfo(BigInteger tenantId, BigInteger userId, Map<String, String> fields) {
        Map<String, String> updateTenantInfoRequestParameters = new HashMap<String, String>(fields);
        updateTenantInfoRequestParameters.put("id", tenantId.toString());
        updateTenantInfoRequestParameters.put("userId", userId.toString());
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "tenant", "updateTenantInfo", updateTenantInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
    }

    public static String obtainPublicKey() {
        return WebSecurityUtils.obtainTenantUserDetails().getPublicKey();
    }

    public static String obtainPrivateKey() {
        return WebSecurityUtils.obtainTenantUserDetails().getPrivateKey();
    }
}
