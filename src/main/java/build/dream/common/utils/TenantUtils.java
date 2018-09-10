package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.Tenant;
import scala.Tuple2;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TenantUtils {
    public static Tenant obtainTenantInfo(BigInteger tenantId) throws IOException {
        Map<String, String> obtainTenantInfoRequestParameters = new HashMap<String, String>();
        obtainTenantInfoRequestParameters.put("tenantId", tenantId.toString());

        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "tenant", "obtainTenantInfo", obtainTenantInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
        return (Tenant) apiRest.getData();
    }

    public static Tenant obtainTenantInfo(String tenantCode) throws IOException {
        Map<String, String> obtainTenantInfoRequestParameters = new HashMap<String, String>();
        obtainTenantInfoRequestParameters.put("tenantCode", tenantCode);
        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "tenant", "obtainTenantInfo", obtainTenantInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
        return (Tenant) apiRest.getData();
    }

    public static void updateTenantInfo(BigInteger tenantId, Tuple2<String, String>... fields) throws IOException {
        Map<String, String> updateTenantInfoRequestParameters = new HashMap<String, String>();
        updateTenantInfoRequestParameters.put("id", tenantId.toString());
        for (Tuple2<String, String> field : fields) {
            updateTenantInfoRequestParameters.put(field._1(), field._2());
        }
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(Constants.SERVICE_NAME_PLATFORM, "tenant", "updateTenantInfo", updateTenantInfoRequestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
    }
}
