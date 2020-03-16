package build.dream.common.constants;

public class RedisKeys {
    /**
     * 客户端信息Redis key
     */
    public static final String KEY_OAUTH_CLIENT_DETAILS = "_oauth_client_details";

    /**
     * 饿了么授权token redis key
     */
    public static final String KEY_ELEME_TOKENS = "_eleme_tokens";

    /**
     * 支付账号Redis key
     *
     * @see #KEY_WEI_XIN_PAY_ACCOUNTS: 微信支付账号
     * @see #KEY_ALIPAY_ACCOUNTS: 支付宝账号
     * @see #KEY_UM_PAY_ACCOUNTS: 联动支付账号
     * @see #KEY_BANK_ACCOUNTS: 银行账号
     * @see #KEY_MIYA_ACCOUNTS: 米雅账号
     * @see #KEY_NEW_LAND_ACCOUNTS: 新大陆账号
     * @see #KEY_ALIPAY_AUTHORIZER_INFOS: 支付宝授权信息
     * @see #KEY_ALIPAY_DEVELOPER_ACCOUNTS: 支付宝开发者账号
     * @see #KEY_NEW_LAND_ORG_INFOS: 新大陆机构信息
     * @see #KEY_UNION_PAY_ACCOUNTS: 银联支付账号
     * @see #KEY_WEI_XIN_PAY_API_V3_KEYS: 微信支付api_v3秘钥
     */
    public static final String KEY_WEI_XIN_PAY_ACCOUNTS = "_wei_xin_pay_accounts";
    public static final String KEY_ALIPAY_ACCOUNTS = "_alipay_accounts";
    public static final String KEY_UM_PAY_ACCOUNTS = "_um_pay_accounts";
    public static final String KEY_BANK_ACCOUNTS = "_back_accounts";
    public static final String KEY_MIYA_ACCOUNTS = "_miya_accounts";
    public static final String KEY_NEW_LAND_ACCOUNTS = "_new_land_accounts";
    public static final String KEY_ALIPAY_AUTHORIZER_INFOS = "_alipay_authorizer_infos";
    public static final String KEY_ALIPAY_DEVELOPER_ACCOUNTS = "_alipay_developer_accounts";
    public static final String KEY_NEW_LAND_ORG_INFOS = "_new_land_org_infos";
    public static final String KEY_UNION_PAY_ACCOUNTS = "_union_pay_accounts";
    public static final String KEY_WEI_XIN_PAY_API_V3_KEYS = "_wei_xin_pay_api_v3_keys";

    /**
     * 钉钉开放平台token redis key
     */
    public static final String KEY_DINGTALK_TOKENS = "_dingtalk_tokens";

    public static final String KEY_WNS_ACCESS_TOKENS = "_wns_access_tokens";

    // 微信 access_toke Redis key
    public static final String KEY_WEI_XIN_ACCESS_TOKENS = "_wei_xin_access_tokens";
    // 微信 jsapi_ticket Redis key
    public static final String KEY_WEI_XIN_JSAPI_TICKETS = "_wei_xin_jsapi_tickets";

    public static final String KEY_WEI_XIN_COMPONENT_VERIFY_TICKETS = "_wei_xin_component_verify_tickets";
    public static final String KEY_WEI_XIN_COMPONENT_ACCESS_TOKENS = "_wei_xin_component_access_tokens";
    // 微信授权token Redis key
    public static final String KEY_WEI_XIN_AUTHORIZER_TOKENS = "wei_xin_authorizer_tokens";

    /**
     * 代理商信息 Redis key
     */
    public static final String KEY_AGENT_INFOS = "_agent_infos";

    /**
     * 商户信息Redis key
     */
    public static final String KEY_TENANT_INFOS = "_tenant_infos";

    public static final String KEY_JDDJ_TOKENS = "_jddj_tokens";
    public static final String KEY_JDDJ_CODES = "_jddj_codes";
    public static final String KEY_JDDJ_VENDER_INFOS = "_jddj_vender_infos";

    public static final String KEY_BATCH_PROCESSING_INFOS = "_batch_processing_infos";

    /**
     * 用户信息Redis key
     */
    public static final String KEY_USER_INFOS = "_user_infos";

    public static final String KEY_SU_NING_TOKENS = "_su_ning_tokens";

    public static final String KEY_ANUBIS_TOKENS = "_anubis_tokens";

    /**
     * rsa key pair redis key
     */
    public static final String KEY_RSA_KEY_PAIRS = "_rsa_key_pairs";

    public static final String KEY_PROVINCES = "_provinces";
    public static final String KEY_DISTRICTS = "_districts";
    public static final String KEY_PID_DISTRICTS = "_pid_districts";
}
