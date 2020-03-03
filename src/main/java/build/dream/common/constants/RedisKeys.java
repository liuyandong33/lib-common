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
}
