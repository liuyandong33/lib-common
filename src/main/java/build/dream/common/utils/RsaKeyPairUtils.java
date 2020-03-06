package build.dream.common.utils;

import build.dream.common.constants.RedisKeys;
import build.dream.common.domains.saas.RsaKeyPair;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RsaKeyPairUtils {
    public static RsaKeyPair obtainRsaKeyPair(Long tenantId) {
        String rsaKeyPairJson = CommonRedisUtils.hget(RedisKeys.KEY_RSA_KEY_PAIRS, tenantId.toString());
        if (StringUtils.isBlank(rsaKeyPairJson)) {
            return null;
        }
        return JacksonUtils.readValue(rsaKeyPairJson, RsaKeyPair.class);
    }

    public static RsaKeyPair obtainRsaKeyPair(String clientId) {
        String rsaKeyPairJson = CommonRedisUtils.hget(RedisKeys.KEY_RSA_KEY_PAIRS, clientId);
        if (StringUtils.isBlank(rsaKeyPairJson)) {
            return null;
        }
        return JacksonUtils.readValue(rsaKeyPairJson, RsaKeyPair.class);
    }

    public static void cacheRsaKeyPair(RsaKeyPair rsaKeyPair) {
        CommonRedisUtils.hset(RedisKeys.KEY_RSA_KEY_PAIRS, rsaKeyPair.getTenantId() != 0 ? rsaKeyPair.getTenantId().toString() : rsaKeyPair.getClientId(), JacksonUtils.writeValueAsString(rsaKeyPair));
    }

    public static void cacheRsaKeyPairs(List<RsaKeyPair> rsaKeyPairs) {
        Map<String, String> rsaKeyPairMap = rsaKeyPairs.stream().collect(Collectors.toMap(rsaKeyPair -> rsaKeyPair.getTenantId() != 0 ? rsaKeyPair.getTenantId().toString() : rsaKeyPair.getClientId(), rsaKeyPair -> JacksonUtils.writeValueAsString(rsaKeyPair)));
        CommonRedisUtils.hmset(RedisKeys.KEY_RSA_KEY_PAIRS, rsaKeyPairMap);
    }
}
