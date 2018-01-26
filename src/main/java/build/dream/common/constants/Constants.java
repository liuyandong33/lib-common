package build.dream.common.constants;

import java.nio.charset.Charset;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class Constants {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";
    public static final String FAIL = "FAIL";

    /**
     * 字符集相关常量
     */
    public static final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");
    public static final Charset CHARSET_GBK = Charset.forName("GBK");
    public static final String CHARSET_NAME_UTF_8 = "UTF-8";
    public static final String CHARSET_NAME_GBK = "GBK";

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

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DEPLOYMENT_ENVIRONMENT = "deployment.environment";
    public static final String PARTITION_CODE = "partition.code";
    public static final String SERVICE_NAME = "service.name";

    public static final String KEY_SERVICE_DOMAIN = "_service_domain";
    public static final String KEY_OUTSIDE_SERVICE_DOMAIN = "_outside_service_domain";

    public static final String SERVICE_NAME_CATERING = "catering";
    public static final String SERVICE_NAME_RETAIL = "retail";
    public static final String SERVICE_NAME_PLATFORM = "platform";
    public static final String SERVICE_NAME_OUT = "out";
    public static final String SERVICE_NAME_POSAPI = "posapi";
    public static final String SERVICE_NAME_APPAPI = "appapi";

    public static final String BUSINESS_CATERING = "1";
    public static final String BUSINESS_RETAIL = "2";

    public static final Integer USER_TYPE_TENANT = 1;
    public static final Integer USER_TYPE_TENANT_EMPLOYEE = 2;

    public static final Integer BRANCH_TYPE_HEADQUARTERS = 1;
    public static final Integer BRANCH_TYPE_DIRECT_SALE_STORE = 2;
    public static final Integer BRANCH_TYPE_FRANCHISE_STORE = 3;

    public static final Integer BRANCH_STATUS_ENABLED = 1;
    public static final Integer BRANCH_STATUS_DISABLED = 2;

    public static final String CLIENT_INFO_KEY_PREFIX = "_router_client_info_";

    public static final String SQL_OPERATION_SYMBOL_IN = "IN";
    public static final String SQL_OPERATION_SYMBOL_LIKE = "LIKE";
    public static final String SQL_OPERATION_SYMBOL_EQUALS = "=";
    public static final String SQL_OPERATION_SYMBOL_NOT_EQUALS = "!=";
    public static final String SQL_OPERATION_SYMBOL_LESS_THAN = "<";
    public static final String SQL_OPERATION_SYMBOL_LESS_THAN_EQUALS = "<=";
    public static final String SQL_OPERATION_SYMBOL_GREATER_THAN = ">";
    public static final String SQL_OPERATION_SYMBOL_GREATER_THAN_EQUALS = ">=";

    public static final String ELEME_MESSAGE_CHANNEL_TOPIC = "eleme.message.channel.topic";
    public static final String ELEME_CALLBACK_MESSAGE_CHANNEL_TOPIC = "eleme.callback.message.channel.topic";

    public static final String KEY_SERVICE_SYSTEM_USERS = "_service_system_users";

    public static final String PARAMETER_ERROR_MESSAGE_PATTERN = "参数(%s)错误！";

    public static final String KEY_ACCESS_LOGS = "_access_logs";

    public static final String SESSION_ID_PREFIX = "_session_id_";

    public static final String SECURITY_DEFAULT_PASSWORD = "0";
    public static final String API_PARAMETER_ERROR_MESSAGE = "API参数错误！";

    public static final String BROWSER_TYPE_WEI_XIN = "weiXin";
    public static final String BROWSER_TYPE_ALIPAY = "alipay";
    public static final String BROWSER_TYPE_OTHER = "other";
    public static final String BROWSER_PLATFORM_OTHER = "other";
    public static final String BROWSER_PLATFORM_PC = "pc";
    public static final String BROWSER_PLATFORM_PHONE = "phone";

    public static final Integer PAID_TYPE_WEI_XIN = 1;
    public static final Integer PAID_TYPE_ALIPAY = 2;

    public static final String WEI_XIN_PAY_TRADE_TYPE_JSAPI = "JSAPI";
    public static final String WEI_XIN_PAY_TRADE_TYPE_NATIVE = "NATIVE";
    public static final String WEI_XIN_PAY_TRADE_TYPE_APP = "APP";
    public static final String WEI_XIN_PAY_TRADE_TYPE_MWEB = "MWEB";
    public static final String WEI_XIN_PAY_TRADE_TYPE_MICROPAY = "MICROPAY";

    public static final Integer PAID_SCENE_WEI_XIN_PUBLIC_ACCOUNT = 1;
    public static final Integer PAID_SCENE_WEI_XIN_H5 = 2;
    public static final Integer PAID_SCENE_WEI_XIN_APP = 3;
    public static final Integer PAID_SCENE_WEI_XIN_NATIVE = 4;
    public static final Integer PAID_SCENE_ALIPAY_MOBILE_WEBSITE = 7;
    public static final Integer PAID_SCENE_ALIPAY_PC_WEBSITE = 8;
    public static final Integer PAID_SCENE_ALIPAY_APP = 9;

    public static final String KEY_TENANT_PUBLIC_KEYS = "_tenant_public_keys";


    public static final String ELEME_APP_ID = "eleme.app.id";
    public static final String ELEME_APP_KEY = "eleme.app.key";
    public static final String ELEME_APP_SECRET = "eleme.app.secret";
    public static final String ELEME_SERVICE_URL = "eleme.service.url";
    public static final String KEY_ELEME_TOKENS = "_eleme_tokens";
    public static final String ELEME_TOKEN = "_eleme_token";

    public static final String MEI_TUAN_MESSAGE_CHANNEL_TOPIC = "mei.tuan.message.channel.topic";
    public static final String MEI_TUAN_CALLBACK_MESSAGE_CHANNEL_TOPIC = "mei.tuan.callback.message.channel.topic";
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_EFFECTIVE = 1;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_CANCEL = 2;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_REFUND = 3;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_CONFIRM = 4;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_SETTLED = 5;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_SHIPPING_STATUS = 6;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_POI_STATUS = 7;

    public static final Integer ELEME_ACCOUNT_TYPE_CHAIN_ACCOUNT = 1;
    public static final Integer ELEME_ACCOUNT_TYPE_INDEPENDENT_ACCOUNT = 2;

    public static final String KEY_WEI_XIN_PAY_ACCOUNTS = "_wei_xin_pay_accounts";
    public static final String KEY_ALIPAY_ACCOUNTS = "_alipay_accounts";
    public static final String KEY_UM_PAY_ACCOUNTS = "_um_pay_accounts";
    public static final String KEY_BANK_ACCOUNTS = "_back_accounts";
    public static final String KEY_MIYA_PAY_ACCOUNTS = "_miya_pay_accounts";

    public static final String KEY_PLATFORM_PRIVATE_KEY = "_platform_private_key";

    public static final String NETWORK_ERROR_MESSAGE = "网络错误！";
    public static final String KEY_TENANT_SECRET_KEYS = "_tenant_secret_keys";

    public static final Integer NOTIFY_TYPE_WEI_XIN_PAY = 1;
    public static final Integer NOTIFY_TYPE_ALIPAY = 2;
    public static final Integer NOTIFY_TYPE_UM_PAY = 3;
    public static final Integer NOTIFY_TYPE_WEI_XIN_REFUND = 4;

    public static final String KEY_ELEME_CALLBACK_MESSAGE = "_eleme_callback_message";
}
