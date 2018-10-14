package build.dream.common.constants;

import build.dream.common.utils.CustomDateUtils;

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
    public static final Charset CHARSET_ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final String CHARSET_NAME_UTF_8 = "UTF-8";
    public static final String CHARSET_NAME_GBK = "GBK";
    public static final String CHARSET_NAME_ISO_8859_1 = "ISO-8859-1";

    public static final String FALSE = "false";
    public static final String TRUE = "true";

    /**
     * 配置文件名称常量
     */
    public static final String PRODUCTION_PROPERTIES = "production.properties";

    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";

    /**
     * 日期格式化相关常量
     */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String GMT = "GMT";

    public static final String DEPLOYMENT_ENVIRONMENT = "deployment.environment";
    public static final String PARTITION_CODE = "partition.code";
    public static final String SERVICE_NAME = "service.name";

    /**
     * 服务名称常量
     */
    public static final String SERVICE_NAME_CATERING = "catering";
    public static final String SERVICE_NAME_RETAIL = "retail";
    public static final String SERVICE_NAME_PLATFORM = "platform";
    public static final String SERVICE_NAME_OUT = "out";
    public static final String SERVICE_NAME_POSAPI = "posapi";
    public static final String SERVICE_NAME_APPAPI = "appapi";
    public static final String SERVICE_NAME_WEBAPI = "webapi";
    public static final String SERVICE_NAME_PORTAL = "portal";
    public static final String SERVICE_NAME_O2O = "o2o";
    public static final String SERVICE_NAME_GATEWAY = "gateway";
    public static final String SERVICE_NAME_JOB = "job";

    /**
     * 业态常量
     */
    public static final String BUSINESS_CATERING = "1";
    public static final String BUSINESS_RETAIL = "2";

    /**
     * 用户类型常量
     */
    public static final Integer USER_TYPE_TENANT = 1;
    public static final Integer USER_TYPE_TENANT_EMPLOYEE = 2;
    public static final Integer USER_TYPE_AGENT = 3;

    /**
     * 门店类型常量
     *
     * @see #BRANCH_TYPE_HEADQUARTERS: 总部
     * @see #BRANCH_TYPE_DIRECT_SALE_STORE: 直营店
     * @see #BRANCH_TYPE_FRANCHISE_STORE: 加盟店
     */
    public static final Integer BRANCH_TYPE_HEADQUARTERS = 1;
    public static final Integer BRANCH_TYPE_DIRECT_SALE_STORE = 2;
    public static final Integer BRANCH_TYPE_FRANCHISE_STORE = 3;

    /**
     * 门店状态常量
     *
     * @see #BRANCH_STATUS_ENABLED: 启用
     * @see #BRANCH_STATUS_DISABLED: 禁用
     */
    public static final Integer BRANCH_STATUS_ENABLED = 1;
    public static final Integer BRANCH_STATUS_DISABLED = 2;

    /**
     * sql 操作符常量
     */
    public static final String SQL_OPERATION_SYMBOL_IN = "IN";
    public static final String SQL_OPERATION_SYMBOL_NOT_IN = "NOT IN";
    public static final String SQL_OPERATION_SYMBOL_LIKE = "LIKE";
    public static final String SQL_OPERATION_SYMBOL_EQUAL = "=";
    public static final String SQL_OPERATION_SYMBOL_NOT_EQUAL = "!=";
    public static final String SQL_OPERATION_SYMBOL_LESS_THAN = "<";
    public static final String SQL_OPERATION_SYMBOL_LESS_THAN_EQUALS = "<=";
    public static final String SQL_OPERATION_SYMBOL_GREATER_THAN = ">";
    public static final String SQL_OPERATION_SYMBOL_GREATER_THAN_EQUALS = ">=";

    // 开发环境或测试环境参数错误错误信息
    public static final String PARAMETER_ERROR_MESSAGE_PATTERN = "参数(%s)错误！";
    // 生产环境参数错误错误信息
    public static final String API_PARAMETER_ERROR_MESSAGE = "API参数错误！";

    // session redis key 前缀
    public static final String SESSION_ID_PREFIX = "_session_id_";

    // Spring Security 默认密码
    public static final String SECURITY_DEFAULT_PASSWORD = "0";

    /**
     * 浏览器类型常量
     */
    public static final String BROWSER_TYPE_WEI_XIN = "weiXin";
    public static final String BROWSER_TYPE_ALIPAY = "alipay";
    public static final String BROWSER_TYPE_OTHER = "other";
    public static final String BROWSER_PLATFORM_OTHER = "other";
    public static final String BROWSER_PLATFORM_PC = "pc";
    public static final String BROWSER_PLATFORM_PHONE = "phone";

    /**
     * 支付类型常量
     */
    public static final Integer PAID_TYPE_WEI_XIN = 1;
    public static final Integer PAID_TYPE_ALIPAY = 2;
    public static final Integer PAID_TYPE_ELM = 11;
    public static final Integer PAID_TYPE_MT = 12;

    /**
     * 微信交易类型常量
     */
    public static final String WEI_XIN_PAY_TRADE_TYPE_JSAPI = "JSAPI";
    public static final String WEI_XIN_PAY_TRADE_TYPE_MINI_PROGRAM = "MINIPROGRAM";
    public static final String WEI_XIN_PAY_TRADE_TYPE_NATIVE = "NATIVE";
    public static final String WEI_XIN_PAY_TRADE_TYPE_APP = "APP";
    public static final String WEI_XIN_PAY_TRADE_TYPE_MWEB = "MWEB";
    public static final String WEI_XIN_PAY_TRADE_TYPE_MICROPAY = "MICROPAY";

    /**
     * 支付场景常量
     */
    public static final Integer PAID_SCENE_WEI_XIN_MICROPAY = 1;
    public static final Integer PAID_SCENE_WEI_XIN_JSAPI_PUBLIC_ACCOUNT = 2;
    public static final Integer PAID_SCENE_WEI_XIN_NATIVE = 3;
    public static final Integer PAID_SCENE_WEI_XIN_APP = 4;
    public static final Integer PAID_SCENE_WEI_XIN_MWEB = 5;
    public static final Integer PAID_SCENE_WEI_XIN_JSAPI_MINI_PROGRAM = 6;
    public static final Integer PAID_SCENE_ALIPAY_MOBILE_WEBSITE = 7;
    public static final Integer PAID_SCENE_ALIPAY_PC_WEBSITE = 8;
    public static final Integer PAID_SCENE_ALIPAY_APP = 9;

    // 微信支付场景
    public static final Integer[] WEI_XIN_PAID_SCENES = {PAID_SCENE_WEI_XIN_MICROPAY, PAID_SCENE_WEI_XIN_JSAPI_PUBLIC_ACCOUNT, PAID_SCENE_WEI_XIN_NATIVE, PAID_SCENE_WEI_XIN_APP, PAID_SCENE_WEI_XIN_MWEB, PAID_SCENE_WEI_XIN_JSAPI_MINI_PROGRAM};
    // 支付宝支付场景
    public static final Integer[] ALIPAY_PAID_SCENES = {PAID_SCENE_ALIPAY_MOBILE_WEBSITE, PAID_SCENE_ALIPAY_PC_WEBSITE, PAID_SCENE_ALIPAY_APP};
    // 所有支付场景
    public static final Integer[] PAID_SCENES = {PAID_SCENE_WEI_XIN_MICROPAY, PAID_SCENE_WEI_XIN_JSAPI_PUBLIC_ACCOUNT, PAID_SCENE_WEI_XIN_NATIVE, PAID_SCENE_WEI_XIN_APP, PAID_SCENE_WEI_XIN_MWEB, PAID_SCENE_WEI_XIN_JSAPI_MINI_PROGRAM, PAID_SCENE_ALIPAY_MOBILE_WEBSITE, PAID_SCENE_ALIPAY_PC_WEBSITE, PAID_SCENE_ALIPAY_APP};

    /**
     * 商户公钥Redis key
     */
    public static final String KEY_TENANT_PUBLIC_KEYS = "_tenant_public_keys";


    /**
     * 饿了么配置key
     */
    public static final String ELEME_APP_ID = "eleme.app.id";
    public static final String ELEME_APP_KEY = "eleme.app.key";
    public static final String ELEME_APP_SECRET = "eleme.app.secret";
    public static final String ELEME_SERVICE_URL = "eleme.service.url";
    public static final String KEY_ELEME_TOKENS = "_eleme_tokens";
    public static final String ELEME_TOKEN = "_eleme_token";

    /**
     * 美团回调类型
     *
     * @see #MEI_TUAN_CALLBACK_TYPE_ORDER_EFFECTIVE: 订单生效
     * @see #MEI_TUAN_CALLBACK_TYPE_ORDER_CANCEL: 订单取消
     * @see #MEI_TUAN_CALLBACK_TYPE_ORDER_REFUND: 订单退款
     * @see #MEI_TUAN_CALLBACK_TYPE_ORDER_CONFIRM: 订单确认
     * @see #MEI_TUAN_CALLBACK_TYPE_ORDER_SETTLED: 订单完成
     * @see #MEI_TUAN_CALLBACK_TYPE_ORDER_SHIPPING_STATUS:
     * @see #MEI_TUAN_CALLBACK_TYPE_POI_STATUS: 门店状态变化
     * @see #MEI_TUAN_CALLBACK_TYPE_BINDING_STORE:
     */
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_EFFECTIVE = 1;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_CANCEL = 2;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_REFUND = 3;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_CONFIRM = 4;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_SETTLED = 5;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_ORDER_SHIPPING_STATUS = 6;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_POI_STATUS = 7;
    public static final Integer MEI_TUAN_CALLBACK_TYPE_BINDING_STORE = 8;

    /**
     * 饿了么账号类型
     *
     * @see #ELEME_ACCOUNT_TYPE_CHAIN_ACCOUNT: 连锁账号
     * @see #ELEME_ACCOUNT_TYPE_INDEPENDENT_ACCOUNT: 独立账号
     */
    public static final Integer ELEME_ACCOUNT_TYPE_CHAIN_ACCOUNT = 1;
    public static final Integer ELEME_ACCOUNT_TYPE_INDEPENDENT_ACCOUNT = 2;

    /**
     * 支付账号Redis key
     *
     * @see #KEY_WEI_XIN_PAY_ACCOUNTS: 微信支付账号
     * @see #KEY_ALIPAY_ACCOUNTS: 支付宝账号
     * @see #KEY_UM_PAY_ACCOUNTS: 联动支付账号
     * @see #KEY_BANK_ACCOUNTS: 银行账号
     * @see #KEY_MIYA_ACCOUNTS: 米雅账号
     * @see #KEY_NEW_LAND_ACCOUNTS: 新大陆账号
     */
    public static final String KEY_WEI_XIN_PAY_ACCOUNTS = "_wei_xin_pay_accounts";
    public static final String KEY_ALIPAY_ACCOUNTS = "_alipay_accounts";
    public static final String KEY_UM_PAY_ACCOUNTS = "_um_pay_accounts";
    public static final String KEY_BANK_ACCOUNTS = "_back_accounts";
    public static final String KEY_MIYA_ACCOUNTS = "_miya_accounts";
    public static final String KEY_NEW_LAND_ACCOUNTS = "_new_land_accounts";

    // 网络错误错误信息
    public static final String NETWORK_ERROR_MESSAGE = "网络错误！";

    public static final Integer NOTIFY_TYPE_WEI_XIN_PAY = 1;
    public static final Integer NOTIFY_TYPE_ALIPAY = 2;
    public static final Integer NOTIFY_TYPE_UM_PAY = 3;
    public static final Integer NOTIFY_TYPE_WEI_XIN_REFUND = 4;

    /**
     * 微信卡券类型
     */
    public static final String CARD_TYPE_GROUPON = "GROUPON";
    public static final String CARD_TYPE_CASH = "CASH";
    public static final String CARD_TYPE_DISCOUNT = "DISCOUNT";
    public static final String CARD_TYPE_GIFT = "GIFT";
    public static final String CARD_TYPE_GENERAL_COUPON = "GENERAL_COUPON";

    /**
     * 商品类型
     *
     * @see #GOODS_STATUS_NORMAL: 正常
     * @see #GOODS_STATUS_STOP_SALE: 停售
     */
    public static final Integer GOODS_STATUS_NORMAL = 1;
    public static final Integer GOODS_STATUS_STOP_SALE = 2;

    /**
     * 商品计量类型
     *
     * @see #GOODS_METERING_MODE_BY_TIME: 按时间
     * @see #GOODS_METERING_MODE_BY_QUANTITY: 按数量
     */
    public static final Integer GOODS_METERING_MODE_BY_TIME = 1;
    public static final Integer GOODS_METERING_MODE_BY_QUANTITY = 2;

    // 中转微信授权地址
    public static final String TRANSFER_WEI_XIN_AUTHORIZE_URL = "transfer.wei.xin.authorize.url";
    // 中转支付宝授权地址
    public static final String TRANSFER_ALIPAY_AUTHORIZE_URL = "transfer.alipay.authorize.url";

    public static final String ALIPAY_PUBLIC_APP_AUTHORIZE_URL = "alipay.public.app.authorize.url";
    public static final String ALIPAY_APP_TO_APP_AUTHORIZE_URL = "alipay.app.to.app.authorize.url";

    // authorization_code
    public static final String AUTHORIZATION_CODE = "authorization_code";
    // refresh_token
    public static final String REFRESH_TOKEN = "refresh_token";

    /**
     * 部署环境
     */
    public static final String WWW = "www";
    public static final String BETA = "beta";
    public static final String TEST = "test";
    public static final String DEVELOPMENT = "development";

    /**
     * 智慧餐厅状态
     *
     * @see #SMART_RESTAURANT_STATUS_NORMAL: 正常
     * @see #SMART_RESTAURANT_STATUS_DISABLED: 禁用
     */
    public static final Integer SMART_RESTAURANT_STATUS_NORMAL = 1;
    public static final Integer SMART_RESTAURANT_STATUS_DISABLED = 2;

    // Type
    public static final String CONTENT_TYPE = "Content-Type";

    // HANDLER_METHOD
    public static final String HANDLER_METHOD = "HANDLER_METHOD";

    // RSA2
    public static final String RSA2 = "RSA2";
    // RSA
    public static final String RSA = "RSA";
    // JSON
    public static final String JSON = "JSON";
    // utf-8
    public static final String UTF_8 = "utf-8";

    /**
     * Json Schema 校验文件路径常量
     */
    public static final String ALIPAY_GOODS_DETAILS_SCHEMA_FILE_PATH = "build/dream/common/schemas/alipay/goodsDetailsSchema.json";
    public static final String ALIPAY_EXTEND_PARAMS_SCHEMA_FILE_PATH = "build/dream/common/schemas/alipay/extendParamsSchema.json";

    /**
     * 支付渠道常量
     *
     * @see #CHANNEL_TYPE_WEI_XIN: 微信支付
     * @see #CHANNEL_TYPE_ALIPAY: 支付宝支付
     * @see #CHANNEL_TYPE_JING_DONG: 京东支付
     */
    public static final int CHANNEL_TYPE_WEI_XIN = 1;
    public static final int CHANNEL_TYPE_ALIPAY = 2;
    public static final int CHANNEL_TYPE_JING_DONG = 3;

    public static final String SCENE_BAR_CODE = "bar_code";
    public static final String SCENE_WAVE_CODE = "wave_code";

    // 微信 access_toke Redis key
    public static final String KEY_WEI_XIN_ACCESS_TOKENS = "_wei_xin_access_tokens";
    // 微信 jsapi_ticket Redis key
    public static final String KEY_WEI_XIN_JSAPI_TICKETS = "_wei_xin_jsapi_tickets";

    // snsapi_base
    public static final String SNSAPI_BASE = "snsapi_base";
    // snsapi_userinfo
    public static final String SNSAPI_USERINFO = "snsapi_userinfo";
    // jsapi
    public static final String WEI_XIN_TICKET_TYPE_JSAPI = "jsapi";
    // wx_card
    public static final String WEI_XIN_TICKET_TYPE_WX_CARD = "wx_card";

    /**
     * BigDecimal 常量
     */
    public static final BigDecimal BIG_DECIMAL_ONE_HUNDRED = BigDecimal.valueOf(100L);
    public static final BigDecimal BIG_DECIMAL_TWO_HUNDRED = BigDecimal.valueOf(200L);
    public static final BigDecimal BIG_DECIMAL_THREE_HUNDRED = BigDecimal.valueOf(300L);
    public static final BigDecimal BIG_DECIMAL_FOUR_HUNDRED = BigDecimal.valueOf(400L);
    public static final BigDecimal BIG_DECIMAL_FIVE_HUNDRED = BigDecimal.valueOf(500L);
    public static final BigDecimal BIG_DECIMAL_SIX_HUNDRED = BigDecimal.valueOf(600L);
    public static final BigDecimal BIG_DECIMAL_SEVEN_HUNDRED = BigDecimal.valueOf(700L);
    public static final BigDecimal BIG_DECIMAL_EIGHT_HUNDRED = BigDecimal.valueOf(800L);
    public static final BigDecimal BIG_DECIMAL_NINE_HUNDRED = BigDecimal.valueOf(900L);
    public static final BigDecimal BIG_DECIMAL_ONE_THOUSAND = BigDecimal.valueOf(1000L);
    public static final BigDecimal BIG_DECIMAL_TWO_THOUSAND = BigDecimal.valueOf(2000L);
    public static final BigDecimal BIG_DECIMAL_THREE_THOUSAND = BigDecimal.valueOf(3000L);
    public static final BigDecimal BIG_DECIMAL_FOUR_THOUSAND = BigDecimal.valueOf(4000L);
    public static final BigDecimal BIG_DECIMAL_FIVE_THOUSAND = BigDecimal.valueOf(5000L);
    public static final BigDecimal BIG_DECIMAL_SIX_THOUSAND = BigDecimal.valueOf(6000L);
    public static final BigDecimal BIG_DECIMAL_SEVEN_THOUSAND = BigDecimal.valueOf(7000L);
    public static final BigDecimal BIG_DECIMAL_EIGHT_THOUSAND = BigDecimal.valueOf(8000L);
    public static final BigDecimal BIG_DECIMAL_NINE_THOUSAND = BigDecimal.valueOf(9000L);
    public static final BigDecimal BIG_DECIMAL_TEN_THOUSAND = BigDecimal.valueOf(10000L);
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
    public static final BigDecimal BIG_DECIMAL_ONE = BigDecimal.valueOf(1L);
    public static final BigDecimal BIG_DECIMAL_TWO = BigDecimal.valueOf(2L);
    public static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    public static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);
    public static final BigDecimal BIG_DECIMAL_FIVE = BigDecimal.valueOf(5L);
    public static final BigDecimal BIG_DECIMAL_SIX = BigDecimal.valueOf(6L);
    public static final BigDecimal BIG_DECIMAL_SEVEN = BigDecimal.valueOf(7L);
    public static final BigDecimal BIG_DECIMAL_EIGHT = BigDecimal.valueOf(8L);
    public static final BigDecimal BIG_DECIMAL_NINE = BigDecimal.valueOf(9L);
    public static final BigDecimal BIG_DECIMAL_TEN = BigDecimal.valueOf(10L);
    public static final BigDecimal BIG_DECIMAL_TWENTY = BigDecimal.valueOf(20L);
    public static final BigDecimal BIG_DECIMAL_THIRTY = BigDecimal.valueOf(30L);
    public static final BigDecimal BIG_DECIMAL_FORTY = BigDecimal.valueOf(40L);
    public static final BigDecimal BIG_DECIMAL_FIFTY = BigDecimal.valueOf(50L);
    public static final BigDecimal BIG_DECIMAL_SIXTY = BigDecimal.valueOf(60L);
    public static final BigDecimal BIG_DECIMAL_SEVENTY = BigDecimal.valueOf(70L);
    public static final BigDecimal BIG_DECIMAL_EIGHTY = BigDecimal.valueOf(80L);
    public static final BigDecimal BIG_DECIMAL_NINETY = BigDecimal.valueOf(90L);
    public static final BigDecimal BIG_DECIMAL_E = BigDecimal.valueOf(Math.E);
    public static final BigDecimal BIG_DECIMAL_PI = BigDecimal.valueOf(Math.PI);

    /**
     * BigInteger 常量
     */
    public static final BigInteger BIG_INTEGER_ONE_HUNDRED = BigInteger.valueOf(100L);
    public static final BigInteger BIG_INTEGER_TWO_HUNDRED = BigInteger.valueOf(200L);
    public static final BigInteger BIG_INTEGER_THREE_HUNDRED = BigInteger.valueOf(300L);
    public static final BigInteger BIG_INTEGER_FOUR_HUNDRED = BigInteger.valueOf(400L);
    public static final BigInteger BIG_INTEGER_FIVE_HUNDRED = BigInteger.valueOf(500L);
    public static final BigInteger BIG_INTEGER_SIX_HUNDRED = BigInteger.valueOf(600L);
    public static final BigInteger BIG_INTEGER_SEVEN_HUNDRED = BigInteger.valueOf(700L);
    public static final BigInteger BIG_INTEGER_EIGHT_HUNDRED = BigInteger.valueOf(800L);
    public static final BigInteger BIG_INTEGER_NINE_HUNDRED = BigInteger.valueOf(900L);
    public static final BigInteger BIG_INTEGER_ONE_THOUSAND = BigInteger.valueOf(1000L);
    public static final BigInteger BIG_INTEGER_TWO_THOUSAND = BigInteger.valueOf(2000L);
    public static final BigInteger BIG_INTEGER_THREE_THOUSAND = BigInteger.valueOf(3000L);
    public static final BigInteger BIG_INTEGER_FOUR_THOUSAND = BigInteger.valueOf(4000L);
    public static final BigInteger BIG_INTEGER_FIVE_THOUSAND = BigInteger.valueOf(5000L);
    public static final BigInteger BIG_INTEGER_SIX_THOUSAND = BigInteger.valueOf(6000L);
    public static final BigInteger BIG_INTEGER_SEVEN_THOUSAND = BigInteger.valueOf(7000L);
    public static final BigInteger BIG_INTEGER_EIGHT_THOUSAND = BigInteger.valueOf(8000L);
    public static final BigInteger BIG_INTEGER_NINE_THOUSAND = BigInteger.valueOf(9000L);
    public static final BigInteger BIG_INTEGER_TEN_THOUSAND = BigInteger.valueOf(10000L);
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
    public static final BigInteger BIG_INTEGER_ONE = BigInteger.valueOf(1L);
    public static final BigInteger BIG_INTEGER_TWO = BigInteger.valueOf(2L);
    public static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    public static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    public static final BigInteger BIG_INTEGER_FIVE = BigInteger.valueOf(5L);
    public static final BigInteger BIG_INTEGER_SIX = BigInteger.valueOf(6L);
    public static final BigInteger BIG_INTEGER_SEVEN = BigInteger.valueOf(7L);
    public static final BigInteger BIG_INTEGER_EIGHT = BigInteger.valueOf(8L);
    public static final BigInteger BIG_INTEGER_NINE = BigInteger.valueOf(9L);
    public static final BigInteger BIG_INTEGER_TEN = BigInteger.valueOf(10L);
    public static final BigInteger BIG_INTEGER_TWENTY = BigInteger.valueOf(20L);
    public static final BigInteger BIG_INTEGER_THIRTY = BigInteger.valueOf(30L);
    public static final BigInteger BIG_INTEGER_FORTY = BigInteger.valueOf(40L);
    public static final BigInteger BIG_INTEGER_FIFTY = BigInteger.valueOf(50L);
    public static final BigInteger BIG_INTEGER_SIXTY = BigInteger.valueOf(60L);
    public static final BigInteger BIG_INTEGER_SEVENTY = BigInteger.valueOf(70L);
    public static final BigInteger BIG_INTEGER_EIGHTY = BigInteger.valueOf(80L);
    public static final BigInteger BIG_INTEGER_NINETY = BigInteger.valueOf(90L);

    /**
     * 字母常量
     */
    public static final String UPPER_CASE_A = "A";
    public static final String UPPER_CASE_B = "B";
    public static final String UPPER_CASE_C = "C";
    public static final String UPPER_CASE_D = "D";
    public static final String UPPER_CASE_E = "E";
    public static final String UPPER_CASE_F = "F";
    public static final String UPPER_CASE_G = "G";
    public static final String UPPER_CASE_H = "H";
    public static final String UPPER_CASE_I = "I";
    public static final String UPPER_CASE_J = "J";
    public static final String UPPER_CASE_K = "K";
    public static final String UPPER_CASE_L = "L";
    public static final String UPPER_CASE_M = "M";
    public static final String UPPER_CASE_N = "N";
    public static final String UPPER_CASE_O = "O";
    public static final String UPPER_CASE_P = "P";
    public static final String UPPER_CASE_Q = "Q";
    public static final String UPPER_CASE_R = "R";
    public static final String UPPER_CASE_S = "S";
    public static final String UPPER_CASE_T = "T";
    public static final String UPPER_CASE_U = "U";
    public static final String UPPER_CASE_V = "V";
    public static final String UPPER_CASE_W = "W";
    public static final String UPPER_CASE_X = "X";
    public static final String UPPER_CASE_Y = "Y";
    public static final String UPPER_CASE_Z = "Z";
    public static final String LOWER_CASE_A = "a";
    public static final String LOWER_CASE_B = "b";
    public static final String LOWER_CASE_C = "c";
    public static final String LOWER_CASE_D = "d";
    public static final String LOWER_CASE_E = "e";
    public static final String LOWER_CASE_F = "f";
    public static final String LOWER_CASE_G = "g";
    public static final String LOWER_CASE_H = "h";
    public static final String LOWER_CASE_I = "i";
    public static final String LOWER_CASE_J = "j";
    public static final String LOWER_CASE_K = "k";
    public static final String LOWER_CASE_L = "l";
    public static final String LOWER_CASE_M = "m";
    public static final String LOWER_CASE_N = "n";
    public static final String LOWER_CASE_O = "o";
    public static final String LOWER_CASE_P = "p";
    public static final String LOWER_CASE_Q = "q";
    public static final String LOWER_CASE_R = "r";
    public static final String LOWER_CASE_S = "s";
    public static final String LOWER_CASE_T = "t";
    public static final String LOWER_CASE_U = "u";
    public static final String LOWER_CASE_V = "v";
    public static final String LOWER_CASE_W = "w";
    public static final String LOWER_CASE_X = "x";
    public static final String LOWER_CASE_Y = "y";
    public static final String LOWER_CASE_Z = "z";

    // HMAC-SHA1
    public static final String HMAC_SHA1 = "HMAC-SHA1";
    // OK
    public static final String OK = "OK";

    /**
     * 设备类型相关常量
     * DEVICE_TYPE_ANDROID: android
     * DEVICE_TYPE_IOS: ios
     */
    public static final int DEVICE_TYPE_ANDROID = 1;
    public static final int DEVICE_TYPE_IOS = 2;

    // 支付宝服务网关
    public static final String ALIPAY_GATEWAY_URL = "alipay.gateway.url";

    // 域名配置key
    public static final String HOME_URL = "home.url";

    /**
     * 数据库默认值
     */
    public static final int TINYINT_DEFAULT_VALUE = 0;
    public static final int INT_DEFAULT_VALUE = 0;
    public static final BigInteger BIGINT_DEFAULT_VALUE = BigInteger.ZERO;
    public static final BigDecimal DECIMAL_DEFAULT_VALUE = BigDecimal.ZERO;
    public static final Date DATETIME_DEFAULT_VALUE = CustomDateUtils.parse("1970-01-01 00:00:00", DEFAULT_DATE_PATTERN);
    public static final String VARCHAR_DEFAULT_VALUE = "";

    // md5
    public static final String MD5 = "MD5";
    // hmac_sha256
    public static final String HMAC_SHA256 = "HMAC_SHA256";
    // cdata 模式
    public static final String CDATA_FORMAT = "<![CDATA[%s]]>";

    /**
     * 商户信息Redis key
     */
    public static final String KEY_TENANT_INFOS = "_tenant_infos";

    /**
     * 极光推送相关配置
     */
    public static final String JPUSH_APP_KEY = "jpush.app.key";
    public static final String JPUSH_MASTER_SECRET = "jpush.master.secret";
    public static final String JPUSH_API_SERVICE_URL = "jpush.api.service.url";
    public static final String JPUSH_DEVICE_SERVICE_URL = "jpush.device.service.url";
    public static final String JPUSH_PUSH_URI = "/push";
    public static final String JPUSH_DEVICES_URI = "/devices";

    /**
     * 钉钉开放平台相关配置
     */
    public static final String KEY_DINGTALK_TOKEN = "_dingtalk_token";
    public static final String DINGTALK_CORP_ID = "dingtalk.corp.id";
    public static final String DINGTALK_CORP_SECRET = "dingtalk.corp.secret";
    public static final String DINGTALK_SERVICE_URL = "dingtalk.service.url";
    public static final String DINGTALK_GET_TOKEN_URI = "/gettoken";
    public static final String DINGTALK_CHAT_SEND_URI = "/chat/send";
    public static final String DINGTALK_SENDER = "dingtalk.sender";
    public static final String DINGTALK_CHAT_ID = "dingtalk.chat.id";

    // 支付方式编码，会员积分
    public static final String PAYMENT_CODE_HYJF = "HYJF";
    // 支付方式编码，会员钱包
    public static final String PAYMENT_CODE_HYQB = "HYQB";
    // 支付方式编码，微信支付
    public static final String PAYMENT_CODE_WX = "WX";
    // 支付方式编码，支付宝支付
    public static final String PAYMENT_CODE_ALIPAY = "ALIPAY";

    // 代理服务器主机名
    public static final String PROXY_SERVER_HOST_NAME = "proxy.server.host.name";
    // 代理服务器端口号
    public static final String PROXY_SERVER_PORT = "proxy.server.port";

    // RestTemplate 连接超时时间
    public static final String REST_TEMPLATE_CONNECT_TIMEOUT = "rest.template.connect.timeout";
    // RestTemplate 读取超时时间
    public static final String REST_TEMPLATE_READ_TIMEOUT = "rest.template.read.timeout";

    // 米雅接口地址
    public static final String MIYA_PAY_SERVICE_URL = "miya.pay.service.url";
    public static final String NEW_LAND_PAY_SERVICE_URL = "new.lang.pay.service.url";
    public static final String SDK_BARCODE_PAY = "sdkBarcodePay";
    public static final String SDK_BARCODE_POS_PAY = "sdkBarcodePosPay";
    public static final String SDK_REFUND_BARCODE_PAY = "sdkRefundBarcodePay";
    public static final String SDK_QRY_BARCODE_PAY = "sdkQryBarcodePay";
    public static final String PUB_SIG_QRY = "pubSigQry";
    public static final String PUB_SIG_PAY = "pubSigPay";
    public static final String NEW_LAND_PAY_VERSION_1_0_0 = "V1.0.0";
    public static final String ALIPAY = "ALIPAY";
    public static final String WXPAY = "WXPAY";
    public static final String YLPAY = "YLPAY";

    // 星期相关常量
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";
    public static final String SATURDAY = "SATURDAY";
    public static final String SUNDAY = "SUNDAY";

    // 月份相关常量
    public static final String JANUARY = "January";
    public static final String FEBRUARY = "February";
    public static final String MARCH = "March";
    public static final String APRIL = "April";
    public static final String MAY = "May";
    public static final String JUNE = "June";
    public static final String JULY = "July";
    public static final String AUGUST = "August";
    public static final String SEPTEMBER = "September";
    public static final String OCTOBER = "October";
    public static final String NOVEMBER = "November";
    public static final String DECEMBER = "December";

    public static final String KEY_WEI_XIN_COMPONENT_VERIFY_TICKET = "_wei_xin_component_verify_ticket";
    public static final String KEY_WEI_XIN_COMPONENT_ACCESS_TOKEN = "_wei_xin_component_access_token";

    // 基本数据类型
    public static final Class<?>[] BASIC_DATA_TYPES = {byte.class, short.class, int.class, long.class, float.class, double.class, char.class, boolean.class};

    // 微信授权token Redis key
    public static final String KEY_WEI_XIN_AUTHORIZER_TOKENS = "wei_xin_authorizer_tokens";

    /**
     * 微信授权类型常量
     *
     * @see #AUTHORIZER_TYPE_PUBLIC_ACCOUNT: 微信公众号
     * @see #AUTHORIZER_TYPE_MINI_PROGRAM: 微信小程序
     */
    public static final Integer AUTHORIZER_TYPE_PUBLIC_ACCOUNT = 1;
    public static final Integer AUTHORIZER_TYPE_MINI_PROGRAM = 2;

    /**
     * 获取微信信息的身份类型
     *
     * @see #IDENTITY_TYPE_PUBLIC_ACCOUNT: 微信公众号
     * @see #IDENTITY_TYPE_THIRD_PARTY_APPLICATION: 第三方应用
     */
    public static final Integer IDENTITY_TYPE_PUBLIC_ACCOUNT = 1;
    public static final Integer IDENTITY_TYPE_THIRD_PARTY_APPLICATION = 2;

    /**
     * 微信消息主题
     */
    public static final String WEI_XIN_MESSAGE_TOPIC = "_wei_xin_message_topic";

    public static final String CONTACT_WE_CHAT_ID_TYPE_WE_CHAT_ID = "type_wechatid";
    public static final String CONTACT_WE_CHAT_ID_TYPE_OPEN_ID = "type_openid";

    public static final String RESPONSE_CONTENT = "response_content";

    public static final String ANUBIS_APP_ID = "anubis.app.id";
    public static final String ANUBIS_APP_SECRET = "anubis.app.secret";
    public static final String KEY_ANUBIS_TOKENS = "_anubis_tokens";

    public static final String MAIL_SMTP_HOST = "mail.smtp.host";
    public static final String MAIL_SMTP_PORT = "mail.smtp.port";
    public static final String MAIL_SMTP_SSL_ENABLE = "mail.smtp.ssl.enable";
    public static final String MAIL_SMTP_SSL_SOCKET_FACTORY = "mail.smtp.ssl.socketFactory";
    public static final String MAIL_SMTP_SOCKET_FACTORY_CLASS = "mail.smtp.socketFactory.class";
    public static final String MAIL_SMTP_SOCKET_FACTORY_PORT = "mail.smtp.socketFactory.port";
    public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    public static final String MAIL_SMTP_TIMEOUT = "mail.smtp.timeout";
    public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    public static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    public static final String MAIL_SMTP_STARTTLS_REQUIRED = "mail.smtp.starttls.required";

    public static final String ALIYUN_ACCESS_KEY_ID = "aliyun.access.key.id";
    public static final String ALIYUN_ACCESS_KEY_SECRET = "aliyun.access.key.secret";

    public static final String PLATFORM_PUBLIC_KEY = "platform.public.key";
    public static final String PLATFORM_PRIVATE_KEY = "platform.private.key";

    /**
     * 银行编号
     *
     * @see #BANK_CODE_ICBC：工商银行（Industrial And Commercial Bank Of China）
     * @see #BANK_CODE_ABC：农业银行（Agricultural Bank Of China）
     * @see #BANK_CODE_BOC：中国银行（Bank Of China）
     * @see #BANK_CODE_CCB：建设银行（China Construction Bank）
     * @see #BANK_CODE_ICBC：招商银行（China Merchants Bank）
     * @see #BANK_CODE_PSBC：邮储银行（Postal Savings Bank of China）
     * @see #BANK_CODE_BCM：交通银行（Bank of Communications）
     * @see #BANK_CODE_SPDB：浦发银行（Shanghai Pudong Development Bank）
     * @see #BANK_CODE_CMBC：民生银行（China Minsheng Banking Corp）
     * @see #BANK_CODE_CIB：兴业银行
     * @see #BANK_CODE_PING_AN：平安银行
     * @see #BANK_CODE_HUA_XIA：中信银行（China Citic Bank）
     * @see #BANK_CODE_PSBC：华夏银行
     * @see #BANK_CODE_GUANG_FA：广发银行
     * @see #BANK_CODE_EVERBRIGHT：光大银行
     * @see #BANK_CODE_BOB：北京银行
     * @see #BANK_CODE_NING_BO：宁波银行
     */
    public static final String BANK_CODE_ICBC = "1002";
    public static final String BANK_CODE_ABC = "1005";
    public static final String BANK_CODE_BOC = "1026";
    public static final String BANK_CODE_CCB = "1003";
    public static final String BANK_CODE_CMB = "1001";
    public static final String BANK_CODE_PSBC = "1066";
    public static final String BANK_CODE_BCM = "1020";
    public static final String BANK_CODE_SPDB = "1004";
    public static final String BANK_CODE_CMBC = "1006";
    public static final String BANK_CODE_CIB = "1009";
    public static final String BANK_CODE_PING_AN = "1010";
    public static final String BANK_CODE_CITIC = "1021";
    public static final String BANK_CODE_HUA_XIA = "1025";
    public static final String BANK_CODE_GUANG_FA = "1027";
    public static final String BANK_CODE_EVERBRIGHT = "1022";
    public static final String BANK_CODE_BOB = "1032";
    public static final String BANK_CODE_NING_BO = "1056";

    public static final String SEQUENCE_NAME_TENANT_CODE = "tenant_code";
    public static final String SEQUENCE_NAME_AGENT_CODE = "agent_code";

    public static final String CHANNEL_TYPE_EXEC = "exec";
    public static final String CHANNEL_TYPE_SFTP = "sftp";

    public static Integer ACCESS_MODE_GET = 1;
    public static Integer ACCESS_MODE_POST = 2;
    public static Integer ACCESS_MODE_GET_SIGNATURE = 3;
    public static Integer ACCESS_MODE_POST_SIGNATURE = 4;
}
