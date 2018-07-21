package build.dream.common.constants;

import build.dream.common.utils.DateUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Date;

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
    public static final String SERVICE_NAME_PORTAL = "portal";
    public static final String SERVICE_NAME_O2O = "o2o";
    public static final String SERVICE_NAME_GATEWAY = "gateway";

    public static final String BUSINESS_CATERING = "1";
    public static final String BUSINESS_RETAIL = "2";

    public static final Integer USER_TYPE_TENANT = 1;
    public static final Integer USER_TYPE_TENANT_EMPLOYEE = 2;
    public static final Integer USER_TYPE_AGENT = 3;

    public static final Integer BRANCH_TYPE_HEADQUARTERS = 1;
    public static final Integer BRANCH_TYPE_DIRECT_SALE_STORE = 2;
    public static final Integer BRANCH_TYPE_FRANCHISE_STORE = 3;

    public static final Integer BRANCH_STATUS_ENABLED = 1;
    public static final Integer BRANCH_STATUS_DISABLED = 2;

    public static final String CLIENT_INFO_KEY_PREFIX = "_router_client_info_";

    public static final String SQL_OPERATION_SYMBOL_IN = "IN";
    public static final String SQL_OPERATION_SYMBOL_NOT_IN = "NOT IN";
    public static final String SQL_OPERATION_SYMBOL_LIKE = "LIKE";
    public static final String SQL_OPERATION_SYMBOL_EQUAL = "=";
    public static final String SQL_OPERATION_SYMBOL_NOT_EQUAL = "!=";
    public static final String SQL_OPERATION_SYMBOL_LESS_THAN = "<";
    public static final String SQL_OPERATION_SYMBOL_LESS_THAN_EQUALS = "<=";
    public static final String SQL_OPERATION_SYMBOL_GREATER_THAN = ">";
    public static final String SQL_OPERATION_SYMBOL_GREATER_THAN_EQUALS = ">=";

    public static final String ELEME_MESSAGE_CHANNEL_TOPIC = "eleme.message.channel.topic";
    public static final String ELEME_CALLBACK_MESSAGE_CHANNEL_TOPIC = "eleme.callback.message.channel.topic";
    public static final String MESSAGE_NOTIFICATION_MESSAGE_CHANNEL_TOPIC = "message.notification.message.channel.topic";

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
    public static final Integer PAID_TYPE_ELM = 11;
    public static final Integer PAID_TYPE_MT = 12;

    public static final String WEI_XIN_PAY_TRADE_TYPE_JSAPI = "JSAPI";
    public static final String WEI_XIN_PAY_TRADE_TYPE_MINI_PROGRAM = "MINIPROGRAM";
    public static final String WEI_XIN_PAY_TRADE_TYPE_NATIVE = "NATIVE";
    public static final String WEI_XIN_PAY_TRADE_TYPE_APP = "APP";
    public static final String WEI_XIN_PAY_TRADE_TYPE_MWEB = "MWEB";
    public static final String WEI_XIN_PAY_TRADE_TYPE_MICROPAY = "MICROPAY";

    public static final Integer PAID_SCENE_WEI_XIN_MICROPAY = 1;
    public static final Integer PAID_SCENE_WEI_XIN_JSAPI_PUBLIC_ACCOUNT = 2;
    public static final Integer PAID_SCENE_WEI_XIN_NATIVE = 3;
    public static final Integer PAID_SCENE_WEI_XIN_APP = 4;
    public static final Integer PAID_SCENE_WEI_XIN_MWEB = 5;
    public static final Integer PAID_SCENE_WEI_XIN_JSAPI_MINI_PROGRAM = 6;
    public static final Integer PAID_SCENE_ALIPAY_MOBILE_WEBSITE = 7;
    public static final Integer PAID_SCENE_ALIPAY_PC_WEBSITE = 8;
    public static final Integer PAID_SCENE_ALIPAY_APP = 9;

    public static final Integer[] WEI_XIN_PAID_SCENES = {PAID_SCENE_WEI_XIN_MICROPAY, PAID_SCENE_WEI_XIN_JSAPI_PUBLIC_ACCOUNT, PAID_SCENE_WEI_XIN_NATIVE, PAID_SCENE_WEI_XIN_APP, PAID_SCENE_WEI_XIN_MWEB, PAID_SCENE_WEI_XIN_JSAPI_MINI_PROGRAM};
    public static final Integer[] ALIPAY_PAID_SCENES = {PAID_SCENE_ALIPAY_MOBILE_WEBSITE, PAID_SCENE_ALIPAY_PC_WEBSITE, PAID_SCENE_ALIPAY_APP};
    public static final Integer[] PAID_SCENES = {PAID_SCENE_WEI_XIN_MICROPAY, PAID_SCENE_WEI_XIN_JSAPI_PUBLIC_ACCOUNT, PAID_SCENE_WEI_XIN_NATIVE, PAID_SCENE_WEI_XIN_APP, PAID_SCENE_WEI_XIN_MWEB, PAID_SCENE_WEI_XIN_JSAPI_MINI_PROGRAM, PAID_SCENE_ALIPAY_MOBILE_WEBSITE, PAID_SCENE_ALIPAY_PC_WEBSITE, PAID_SCENE_ALIPAY_APP};

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
    public static final Integer MEI_TUAN_CALLBACK_TYPE_BINDING_STORE = 8;

    public static final Integer ELEME_ACCOUNT_TYPE_CHAIN_ACCOUNT = 1;
    public static final Integer ELEME_ACCOUNT_TYPE_INDEPENDENT_ACCOUNT = 2;

    public static final String KEY_WEI_XIN_PAY_ACCOUNTS = "_wei_xin_pay_accounts";
    public static final String KEY_ALIPAY_ACCOUNTS = "_alipay_accounts";
    public static final String KEY_UM_PAY_ACCOUNTS = "_um_pay_accounts";
    public static final String KEY_BANK_ACCOUNTS = "_back_accounts";
    public static final String KEY_MIYA_PAY_ACCOUNTS = "_miya_pay_accounts";

    public static final String KEY_PLATFORM_PUBLIC_KEY = "_platform_public_key";
    public static final String KEY_PLATFORM_PRIVATE_KEY = "_platform_private_key";

    public static final String NETWORK_ERROR_MESSAGE = "网络错误！";
    public static final String KEY_TENANT_SECRET_KEYS = "_tenant_secret_keys";

    public static final Integer NOTIFY_TYPE_WEI_XIN_PAY = 1;
    public static final Integer NOTIFY_TYPE_ALIPAY = 2;
    public static final Integer NOTIFY_TYPE_UM_PAY = 3;
    public static final Integer NOTIFY_TYPE_WEI_XIN_REFUND = 4;

    public static final String KEY_ELEME_CALLBACK_MESSAGE = "_eleme_callback_message";

    public static final String CARD_TYPE_GROUPON = "GROUPON";
    public static final String CARD_TYPE_CASH = "CASH";
    public static final String CARD_TYPE_DISCOUNT = "DISCOUNT";
    public static final String CARD_TYPE_GIFT = "GIFT";
    public static final String CARD_TYPE_GENERAL_COUPON = "GENERAL_COUPON";

    public static final String KEY_MEI_TUAN_CALLBACK_MESSAGE = "_mei_tuan_callback_message";

    public static final Integer GOODS_STATUS_NORMAL = 1;
    public static final Integer GOODS_STATUS_STOP_SALE = 2;
    public static final Integer GOODS_METERING_MODE_BY_TIME = 1;
    public static final Integer GOODS_METERING_MODE_BY_QUANTITY = 2;

    public static final String WEI_XIN_AUTHORIZE_URL = "wei.xin.authorize.url";
    public static final String TRANSFER_WEI_XIN_AUTHORIZE_URL = "transfer.wei.xin.authorize.url";
    public static final String TRANSFER_ALIPAY_AUTHORIZE_URL = "transfer.alipay.authorize.url";
    public static final String ALIPAY_PUBLIC_APP_AUTHORIZE_URL = "alipay.public.app.authorize.url";

    public static final String WWW = "www";
    public static final String BETA = "beta";
    public static final String TEST = "test";
    public static final String DEVELOPMENT = "development";

    public static final Integer SMART_RESTAURANT_STATUS_NORMAL = 1;
    public static final Integer SMART_RESTAURANT_STATUS_DISABLED = 2;

    public static final String CONTENT_TYPE = "Content-Type";

    public static final String HANDLER_METHOD = "HANDLER_METHOD";

    public static final String RSA2 = "RSA2";
    public static final String RSA = "RSA";
    public static final String JSON = "JSON";
    public static final String UTF_8 = "utf-8";

    public static final String ALIPAY_GOODS_DETAILS_SCHEMA_FILE_PATH = "build/dream/common/schemas/alipay/goodsDetailsSchema.json";
    public static final String ALIPAY_EXTEND_PARAMS_SCHEMA_FILE_PATH = "build/dream/common/schemas/alipay/extendParamsSchema.json";

    public static final int CHANNEL_TYPE_WEI_XIN = 1;
    public static final int CHANNEL_TYPE_ALIPAY = 2;
    public static final int CHANNEL_TYPE_JING_DONG = 3;

    public static final String SCENE_BAR_CODE = "bar_code";
    public static final String SCENE_WAVE_CODE = "wave_code";

    public static final String WEI_XIN_API_URL = "wei.xin.api.url";
    public static final String WEI_XIN_OAUTH2_ACCESS_TOKEN_URI = "/sns/oauth2/access_token";
    public static final String WEI_XIN_OBTAIN_USER_INFO_URI = "/sns/userinfo";
    public static final String WEI_XIN_SEND_MASS_MESSAGE_URI = "/message/mass/send";

    public static final String SNSAPI_BASE = "snsapi_base";
    public static final String SNSAPI_USERINFO = "snsapi_userinfo";

    public static final BigDecimal BIG_DECIMAL_HUNDRED = BigDecimal.valueOf(100L);
    public static final BigDecimal BIG_DECIMAL_MINUS_ONE = BigDecimal.valueOf(-1L);
    public static final BigDecimal BIG_DECIMAL_MINUS_TWO = BigDecimal.valueOf(-2L);
    public static final BigDecimal BIG_DECIMAL_MINUS_THREE = BigDecimal.valueOf(-3L);
    public static final BigDecimal BIG_DECIMAL_MINUS_FOUR = BigDecimal.valueOf(-4L);
    public static final BigDecimal BIG_DECIMAL_MINUS_FIVE = BigDecimal.valueOf(-5L);
    public static final BigDecimal BIG_DECIMAL_MINUS_SIX = BigDecimal.valueOf(-6L);
    public static final BigDecimal BIG_DECIMAL_MINUS_SEVEN = BigDecimal.valueOf(-7L);
    public static final BigDecimal BIG_DECIMAL_MINUS_EIGHT = BigDecimal.valueOf(-8L);
    public static final BigDecimal BIG_DECIMAL_MINUS_NINE = BigDecimal.valueOf(-9L);
    public static final BigDecimal BIG_DECIMAL_MINUS_TEN = BigDecimal.valueOf(-10L);

    public static final BigInteger BIG_INTEGER_HUNDRED = BigInteger.valueOf(100L);
    public static final BigInteger BIG_INTEGER_MINUS_ONE = BigInteger.valueOf(-1L);
    public static final BigInteger BIG_INTEGER_MINUS_TWO = BigInteger.valueOf(-2L);
    public static final BigInteger BIG_INTEGER_MINUS_THREE = BigInteger.valueOf(-3L);
    public static final BigInteger BIG_INTEGER_MINUS_FOUR = BigInteger.valueOf(-4L);
    public static final BigInteger BIG_INTEGER_MINUS_FIVE = BigInteger.valueOf(-5L);
    public static final BigInteger BIG_INTEGER_MINUS_SIX = BigInteger.valueOf(-6L);
    public static final BigInteger BIG_INTEGER_MINUS_SEVEN = BigInteger.valueOf(-7L);
    public static final BigInteger BIG_INTEGER_MINUS_EIGHT = BigInteger.valueOf(-8L);
    public static final BigInteger BIG_INTEGER_MINUS_NINE = BigInteger.valueOf(-9L);
    public static final BigInteger BIG_INTEGER_MINUS_TEN = BigInteger.valueOf(-10L);

    public static final String HMAC_SHA1 = "HMAC-SHA1";
    public static final String OK = "OK";

    public static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final int DEVICE_TYPE_ANDROID = 1;
    public static final int DEVICE_TYPE_IOS = 2;

    public static final String ALIPAY_GATEWAY_URL = "alipay.gateway.url";

    public static final String HOME_URL = "home.url";

    public static final int TINYINT_DEFAULT_VALUE = 0;
    public static final int INT_DEFAULT_VALUE = 0;
    public static final BigInteger BIGINT_DEFAULT_VALUE = BigInteger.ZERO;
    public static final BigDecimal DECIMAL_DEFAULT_VALUE = BigDecimal.ZERO;
    public static final Date DATETIME_DEFAULT_VALUE = DateUtils.parse("1970-01-01 00:00:00", DEFAULT_DATE_PATTERN);
    public static final String VARCHAR_DEFAULT_VALUE = "";

    public static final String MD5 = "MD5";
    public static final String HMAC_SHA256 = "HMAC_SHA256";
    public static final String CDATA_FORMAT = "<![CDATA[%s]]>";

    public static final String WEI_XIN_PAY_API_URL = "wei.xin.pay.api.url";
    public static final String WEI_XIN_PAY_MICRO_PAY_URI = "/pay/micropay";
    public static final String WEI_XIN_PAY_REFUND_URI = "/secapi/pay/refund";

    public static final String KEY_TENANT_INFOS = "_tenant_infos";

    public static final String JPUSH_APP_KEY = "jpush.app.key";
    public static final String JPUSH_MASTER_SECRET = "jpush.master.secret";
    public static final String JPUSH_API_SERVICE_URL = "jpush.api.service.url";
    public static final String JPUSH_DEVICE_SERVICE_URL = "jpush.device.service.url";
    public static final String JPUSH_PUSH_URI = "/push";
    public static final String JPUSH_DEVICES_URI = "/devices";

    public static final String KEY_DINGTALK_TOKEN = "_dingtalk_token";
    public static final String DINGTALK_CORP_ID = "dingtalk.corp.id";
    public static final String DINGTALK_CORP_SECRET = "dingtalk.corp.secret";
    public static final String DINGTALK_SERVICE_URL = "dingtalk.service.url";
    public static final String DINGTALK_GET_TOKEN_URI = "/gettoken";
    public static final String DINGTALK_CHAT_SEND_URI = "/chat/send";
    public static final String DINGTALK_SENDER = "dingtalk.sender";
    public static final String DINGTALK_CHAT_ID = "dingtalk.chat.id";
}
