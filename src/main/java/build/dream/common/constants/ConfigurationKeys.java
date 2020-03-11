package build.dream.common.constants;

public class ConfigurationKeys {
    /**
     * 部署环境
     */
    public static final String DEPLOYMENT_ENVIRONMENT = "deployment.environment";

    /**
     * 分区码
     */
    public static final String PARTITION_CODE = "partition.code";

    /**
     * 服务名称
     */
    public static final String SERVICE_NAME = "service.name";

    /**
     * 服务端口
     */
    public static final String SERVER_PORT = "server.port";

    /**
     * 注册中心中服务名称
     */
    public static final String SPRING_APPLICATION_NAME = "spring.application.name";

    /**
     * 主域名
     */
    public static final String HOME_URL = "home.url";

    /**
     * 饿了么配置key
     */
    public static final String ELEME_APP_ID = "eleme.app.id";
    public static final String ELEME_APP_KEY = "eleme.app.key";
    public static final String ELEME_APP_SECRET = "eleme.app.secret";
    public static final String ELEME_SERVICE_URL = "eleme.service.url";

    /**
     * 雪花算法初始化配置
     */
    public static final String SNOWFLAKE_ID_CONFIGURATION_DATABASE_URL = "snowflake.id.configuration.database.url";
    public static final String SNOWFLAKE_ID_CONFIGURATION_DATABASE_USERNAME = "snowflake.id.configuration.database.username";
    public static final String SNOWFLAKE_ID_CONFIGURATION_DATABASE_PASSWORD = "snowflake.id.configuration.database.password";
    public static final String SNOWFLAKE_ID_CONFIGURATION_DATABASE_DRIVER_CLASS_NAME = "snowflake.id.configuration.database.driver-class-name";

    /**
     * 荣联短信平台配置
     */
    public static final String RONG_LIAN_ACCOUNT_SID = "rong.lian.account.sid";
    public static final String RONG_LIAN_AUTH_TOKEN = "rong.lian.auth.token";
    public static final String RONG_LIAN_APP_ID = "rong.lian.app.id";
    public static final String RONG_LIAN_VERIFICATION_CODE_TEMPLATE_ID = "rong.lian.verification.code.template.id";
    public static final String RONG_LIAN_AGENT_ACCOUNT_TEMPLATE_ID = "rong.lian.agent.account.template.id";

    /**
     * 短信验证码有效时间
     */
    public static final String VERIFICATION_CODE_TIMEOUT = "verification.code.timeout";

    /**
     * 短信通道
     */
    public static final String SMS_CHANNEL = "sms.channel";

    /**
     * 阿里云配置
     */
    public static final String ALIYUN_ACCESS_KEY_ID = "aliyun.access.key.id";
    public static final String ALIYUN_ACCESS_KEY_SECRET = "aliyun.access.key.secret";

    /**
     * 阿里云短信平台配置
     */
    public static final String ALIYUN_SMS_API_VERIFICATION_CODE_TEMPLATE_CODE = "aliyun.sms.api.verification.code.template.code";
    public static final String ALIYUN_SMS_API_AGENT_ACCOUNT_TEMPLATE_CODE = "aliyun.sms.api.agent.account.template.code";
    public static final String ALIYUN_SMS_API_SIGN_NAME = "aliyun.sms.api.sign.name";

    /**
     * 极光推送相关配置
     */
    public static final String JPUSH_APP_KEY = "jpush.app.key";
    public static final String JPUSH_MASTER_SECRET = "jpush.master.secret";
    public static final String JPUSH_PUSH_SERVICE_URL = "jpush.push.service.url";
    public static final String JPUSH_SMS_SERVICE_URL = "jpush.sms.service.url";
    public static final String JPUSH_SMS_SIGN_ID = "jpush.sms.sign.id";
    public static final String JPUSH_SMS_API_VERIFICATION_CODE_TEMP_ID = "jpush.sms.api.verification.code.temp.id";
    public static final String JPUSH_SMS_API_AGENT_ACCOUNT_TEMP_ID = "jpush.sms.api.agent.account.temp.id";

    // 代理服务器主机名
    public static final String PROXY_SERVER_HOST_NAME = "proxy.server.host.name";
    // 代理服务器端口号
    public static final String PROXY_SERVER_PORT = "proxy.server.port";

    public static final String WPOS_MQTT_TOPIC = "wpos.mqtt.topic";

    public static final String LOG_STACK_INFO = "log.stack.info";

    /**
     * 钉钉开放平台相关配置
     */
    public static final String DINGTALK_APP_KEY = "dingtalk.app.key";
    public static final String DINGTALK_APP_SECRET = "dingtalk.app.secret";

    /**
     * 联动支付服务地址
     */
    public static final String UM_PAY_SERVICE_URL = "um.pay.service.url";

    public static final String PLATFORM_PUBLIC_KEY = "platform.public.key";
    public static final String PLATFORM_PRIVATE_KEY = "platform.private.key";

    /**
     * 新大陆支付服务地址
     */
    public static final String NEW_LAND_PAY_SERVICE_URL = "new.lang.pay.service.url";

    public static final String ALIPAY_PUBLIC_APP_AUTHORIZE_URL = "alipay.public.app.authorize.url";

    /**
     * 京东到家服务域名
     */
    public static final String JDDJ_API_DOMAIN = "jddj.api.domain";

    /**
     * 米雅服务地址
     */
    public static final String MIYA_PAY_SERVICE_URL = "miya.pay.service.url";

    /**
     * 达达配送配置
     */
    public static final String DADA_APP_KEY = "dada.app.key";
    public static final String DADA_APP_SECRET = "dada.app.secret";
    public static final String DADA_API_DOMAIN = "dada.api.domain";

    /**
     * 苏宁配置
     */
    public static final String SU_NING_APP_KEY = "su.ning.app.key";
    public static final String SU_NING_APP_SECRET = "su.ning.app.secret";

    /**
     * 蜂鸟配送
     */
    public static final String ANUBIS_APP_ID = "anubis.app.id";
    public static final String ANUBIS_APP_SECRET = "anubis.app.secret";

    // RestTemplate 连接超时时间
    public static final String REST_TEMPLATE_CONNECT_TIMEOUT = "rest.template.connect.timeout";
    // RestTemplate 读取超时时间
    public static final String REST_TEMPLATE_READ_TIMEOUT = "rest.template.read.timeout";
}
