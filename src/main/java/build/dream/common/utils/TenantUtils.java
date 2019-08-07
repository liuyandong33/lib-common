package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.auth.CateringUserDetails;
import build.dream.common.auth.IotUserDetails;
import build.dream.common.beans.JDDJVenderInfo;
import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.Tenant;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import scala.Tuple2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
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
        UserDetails userDetails = WebSecurityUtils.obtainUserDetails();
        if (userDetails instanceof CateringUserDetails) {
            return ((CateringUserDetails) userDetails).getPublicKey();
        }

        if (userDetails instanceof IotUserDetails) {
            return ((IotUserDetails) userDetails).getPublicKey();
        }
        return null;
    }

    public static String obtainPrivateKey() {
        UserDetails userDetails = WebSecurityUtils.obtainUserDetails();
        if (userDetails instanceof CateringUserDetails) {
            return ((CateringUserDetails) userDetails).getPrivateKey();
        }

        if (userDetails instanceof IotUserDetails) {
            return ((IotUserDetails) userDetails).getPrivateKey();
        }
        return null;
    }

    public static String obtainPartitionCode() {
        UserDetails userDetails = WebSecurityUtils.obtainUserDetails();
        if (userDetails instanceof CateringUserDetails) {
            return ((CateringUserDetails) userDetails).getPartitionCode();
        }

        if (userDetails instanceof IotUserDetails) {
            return ((IotUserDetails) userDetails).getPartitionCode();
        }
        return null;
    }

    public static void cacheTenantInfo(Tenant tenant) {
        String tenantInfo = JacksonUtils.writeValueAsString(tenant);
        CommonRedisUtils.hset(Constants.KEY_TENANT_INFOS, "_id_" + tenant.getId(), tenantInfo);
        CommonRedisUtils.hset(Constants.KEY_TENANT_INFOS, "_code_" + tenant.getCode(), tenantInfo);
    }

    public static void rejoinCacheTenantInfos(List<Tenant> tenants) {
        Map<String, String> tenantInfos = new HashMap<String, String>();
        Map<String, String> jddjVenderInfos = new HashMap<String, String>();
        for (Tenant tenant : tenants) {
            BigInteger tenantId = tenant.getId();
            String tenantCode = tenant.getCode();
            String tenantInfo = JacksonUtils.writeValueAsString(tenant);
            tenantInfos.put("_id_" + tenantId, tenantInfo);
            tenantInfos.put("_code_" + tenantCode, tenantInfo);

            String jddjVenderId = tenant.getJddjVenderId();
            String jddjAppKey = tenant.getJddjAppKey();
            String jddjAppSecret = tenant.getJddjAppSecret();

            if (StringUtils.isBlank(jddjVenderId) || StringUtils.isBlank(jddjAppKey) || StringUtils.isBlank(jddjAppSecret)) {
                continue;
            }

            JDDJVenderInfo jddjVenderInfo = JDDJVenderInfo.builder()
                    .tenantId(tenantId)
                    .tenantCode(tenantCode)
                    .partitionCode(tenant.getPartitionCode())
                    .venderId(jddjVenderId)
                    .appKey(jddjAppKey)
                    .appSecret(jddjAppSecret)
                    .build();
            jddjVenderInfos.put(jddjAppKey, JacksonUtils.writeValueAsString(jddjVenderInfo));
        }
        CommonRedisUtils.del(Constants.KEY_TENANT_INFOS);
        if (MapUtils.isNotEmpty(tenantInfos)) {
            CommonRedisUtils.hmset(Constants.KEY_TENANT_INFOS, tenantInfos);
        }

        CommonRedisUtils.del(Constants.KEY_JDDJ_VENDER_INFOS);
        if (MapUtils.isNotEmpty(jddjVenderInfos)) {
            CommonRedisUtils.hmset(Constants.KEY_JDDJ_VENDER_INFOS, jddjVenderInfos);
        }
    }
}
