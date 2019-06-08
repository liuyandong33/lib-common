package build.dream.common.notify;

public enum AlipayAsyncNotifyType {
    /**
     * 支付宝统一收单交易关闭接口
     */
    ALIPAY_TRADE_CLOSE,

    /**
     * 支付宝统一收单线下交易预创建
     */
    ALIPAY_TRADE_PRE_CREATE,

    /**
     * 支付宝统一收单交易创建接口
     */
    ALIPAY_TRADE_CREATE,

    /**
     * 支付宝统一收单交易支付接口
     */
    ALIPAY_TRADE_PAY,

    /**
     * 口碑商品交易购买接口
     */
    KOUBEI_TRADE_ITEM_ORDER_BUY,

    /**
     * 口碑凭证码撤销核销
     */
    KOUBEI_TRADE_TICKET_TICKET_CODE_CANCEL,

    /**
     * 支付宝统一收单下单并支付页面接口
     */
    ALIPAY_TRADE_PAGE_PAY,

    /**
     * 支付宝手机网站支付接口2.0
     */
    ALIPAY_TRADE_WAP_PAY,

    /**
     * 支付宝app支付接口2.0
     */
    ALIPAY_TRADE_APP_PAY,

    /**
     * 资金授权冻结接口
     */
    ALIPAY_FUND_AUTH_ORDER_FREEZE,

    /**
     * 修改门店信息
     */
    ALIPAY_OFFLINE_MARKET_SHOP_MODIFY,

    /**
     * 创建门店信息
     */
    ALIPAY_OFFLINE_MARKET_SHOP_CREATE,

    /**
     * 服务市场商户确认订购通知
     */
    ALIPAY_OPEN_SERVICE_MARKET_ORDER_NOTIFY
}
