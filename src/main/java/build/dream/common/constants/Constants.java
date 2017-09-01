package build.dream.common.constants;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class Constants {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";

    /**
     * 字符集相关常量
     */
    public static final String CHARSET_UTF_8 = "UTF-8";
    public static final String CHARSET_GBK = "GBK";

    public static final String FALSE = "false";
    public static final String TRUE = "true";

    /**
     * redis 配置相关常量
     */
    public static final String JEDIS_SENTINEL_POOL = "JedisSentinelPool";
    public static final String JEDIS_POOL = "JedisPool";
    public static final String REDIS_POOL_TYPE = "redis.pool.type";
    public static final String REDIS_POOL_HOST = "redis.pool.host";
    public static final String REDIS_POOL_PORT = "redis.pool.port";
    public static final String REDIS_POOL_PASSWORD = "redis.pool.password";

    /**
     * 配置相关常量
     */
    public static final String PRODUCTION_PROPERTIES = "production.properties";

    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";

    /** 错误日志格式化，错误描述：controllerName.actionName-exceptionSimpleName-exceptionMessage-请求参数*/
    public static final String LOGGER_ERROR_FORMAT = "{}:{}.{}-{}-{}-{}";

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DEPLOYMENT_ENVIRONMENT = "deployment.environment";
    public static final String PARTITION_CODE = "partition.code";
    public static final String SERVICE_NAME = "service.name";

    public static final String KEY_SERVICE_DOMAIN = "_service_domain";
    public static final String KEY_OUTSIDE_SERVICE_DOMAIN = "_outside_service_domain";

    public static final String SERVICE_NAME_CATERING = "catering";
    public static final String SERVICE_NAME_RETAIL = "retail";
    public static final String SERVICE_NAME_PLATFORM = "platform";
    public static final String BUSINESS_CATERING = "1";
    public static final String BUSINESS_RETAIL = "2";

    public static final Integer USER_TYPE_TENANT = 1;
    public static final Integer USER_TYPE_TENANT_EMPLOYEE = 2;
}
