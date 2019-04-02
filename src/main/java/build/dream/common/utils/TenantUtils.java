package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.Tenant;
import scala.Tuple2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TenantUtils {
    public static Tenant obtainTenantInfo(BigInteger tenantId) {
        String tenantInfoJson = RedisUtils.hget(Constants.KEY_TENANT_INFOS, "_id_" + tenantId);
        ValidateUtils.notNull(tenantInfoJson, "商户信息不存在！");
        return JacksonUtils.readValue(tenantInfoJson, Tenant.class);
    }

    public static Tenant obtainTenantInfo(String tenantCode) {
        String tenantInfoJson = RedisUtils.hget(Constants.KEY_TENANT_INFOS, "_code_" + tenantCode);
        ValidateUtils.notNull(tenantInfoJson, "商户信息不存在！");
        return JacksonUtils.readValue(tenantInfoJson, Tenant.class);
    }

    public static void updateTenantInfo(BigInteger tenantId, Tuple2<String, String>... fields) {
        Map<String, String> updateTenantInfoRequestParameters = new HashMap<String, String>();
        updateTenantInfoRequestParameters.put("id", tenantId.toString());
        for (Tuple2<String, String> field : fields) {
            updateTenantInfoRequestParameters.put(field._1(), field._2());
        }
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "tenant", "updateTenantInfo", updateTenantInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
    }

    public static void updateTenantInfo(BigInteger tenantId, Map<String, String> fields) {
        Map<String, String> updateTenantInfoRequestParameters = new HashMap<String, String>(fields);
        updateTenantInfoRequestParameters.put("id", tenantId.toString());
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "tenant", "updateTenantInfo", updateTenantInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
    }

    public static String obtainPublicKey() {
        return WebSecurityUtils.obtainSystemUserUserDetails().getPublicKey();
    }

    public static String obtainPrivateKey() {
        return WebSecurityUtils.obtainSystemUserUserDetails().getPrivateKey();
    }
}
