package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.notify.SaveAsyncNotifyModel;
import build.dream.common.notify.AlipayAsyncNotifyType;
import build.dream.common.saas.domains.AsyncNotify;
import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;

public class NotifyUtils {
    public static String obtainAlipayNotifyUrl(AlipayAsyncNotifyType alipayAsyncNotifyType) {
        switch (alipayAsyncNotifyType) {
            case ALIPAY_TRADE_CLOSE:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayTradeCloseCallback");
            case ALIPAY_TRADE_PRE_CREATE:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayTradePreCreateCallback");
            case ALIPAY_TRADE_CREATE:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayTradeCreateCallback");
            case ALIPAY_TRADE_PAY:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayTradePayCallback");
            case KOUBEI_TRADE_ITEM_ORDER_BUY:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "koubeiTradeItemOrderBuyCallback");
            case KOUBEI_TRADE_TICKET_TICKET_CODE_CANCEL:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "koubeiTradeTicketTicketCodeCancelCallback");
            case ALIPAY_TRADE_PAGE_PAY:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayTradePagePayCallback");
            case ALIPAY_TRADE_WAP_PAY:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayTradeWapPayCallback");
            case ALIPAY_TRADE_APP_PAY:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayTradeAppPayCallback");
            case ALIPAY_FUND_AUTH_ORDER_FREEZE:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayFundAuthOrderFreezeCallback");
            case ALIPAY_OFFLINE_MARKET_SHOP_MODIFY:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayOfflineMarketShopModifyCallback");
            case ALIPAY_OFFLINE_MARKET_SHOP_CREATE:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayOfflineMarketShopCreateCallback");
            case ALIPAY_OPEN_SERVICE_MARKET_ORDER_NOTIFY:
                return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "alipayOpenServiceMarketOrderNotifyCallback");
            default:
                return null;
        }
    }

    public static String obtainWeiXinPayNotifyUrl() {
        return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "weiXinPayCallback");
    }

    public static String obtainWeiXinRefundNotifyUrl() {
        return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "weiXinRefundCallback");
    }

    public static String obtainJingDongPayNotifyUrl() {
        return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "jingDongPayCallback");
    }

    /**
     * 保存异步通知
     *
     * @param saveAsyncNotifyModel
     * @return
     */
    public static AsyncNotify saveAsyncNotify(SaveAsyncNotifyModel saveAsyncNotifyModel) {
        String uuid = saveAsyncNotifyModel.getUuid();
        String topic = saveAsyncNotifyModel.getTopic();
        String alipayPublicKey = saveAsyncNotifyModel.getAlipayPublicKey();
        String alipaySignType = saveAsyncNotifyModel.getAlipaySignType();
        String weiXinPayApiSecretKey = saveAsyncNotifyModel.getWeiXinPayApiSecretKey();
        String weiXinPaySignType = saveAsyncNotifyModel.getWeiXinPaySignType();

        BigInteger userId = CommonUtils.getServiceSystemUserId();

        SearchModel searchModel = new SearchModel(true);
        searchModel.addSearchCondition(AsyncNotify.ColumnName.UUID, Constants.SQL_OPERATION_SYMBOL_EQUAL, uuid);
        AsyncNotify asyncNotify = DatabaseHelper.find(AsyncNotify.class, searchModel);
        if (asyncNotify == null) {
            asyncNotify = new AsyncNotify();
            asyncNotify.setUuid(uuid);
            asyncNotify.setTopic(topic);
            if (StringUtils.isNotBlank(alipayPublicKey)) {
                asyncNotify.setAlipayPublicKey(alipayPublicKey);
            }
            if (StringUtils.isNotBlank(alipaySignType)) {
                asyncNotify.setAlipaySignType(alipaySignType);
            }
            asyncNotify.setNotifyResult(Constants.NOTIFY_RESULT_NOT_NOTIFY);
            if (StringUtils.isNotBlank(weiXinPayApiSecretKey)) {
                asyncNotify.setWeiXinPayApiSecretKey(weiXinPayApiSecretKey);
            }
            if (StringUtils.isNotBlank(weiXinPaySignType)) {
                asyncNotify.setWeiXinPaySignType(weiXinPaySignType);
            }
            asyncNotify.setCreatedUserId(userId);
            asyncNotify.setUpdatedUserId(userId);
            asyncNotify.setUpdatedRemark("保存异步通知！");
            DatabaseHelper.insert(asyncNotify);
        } else {
            asyncNotify.setTopic(topic);
            asyncNotify.setAlipayPublicKey(StringUtils.isNotBlank(alipayPublicKey) ? alipayPublicKey : Constants.VARCHAR_DEFAULT_VALUE);
            asyncNotify.setAlipaySignType(StringUtils.isNotBlank(alipaySignType) ? alipaySignType : Constants.VARCHAR_DEFAULT_VALUE);
            asyncNotify.setWeiXinPayApiSecretKey(StringUtils.isNotBlank(weiXinPayApiSecretKey) ? weiXinPayApiSecretKey : Constants.VARCHAR_DEFAULT_VALUE);
            asyncNotify.setWeiXinPaySignType(StringUtils.isNotBlank(weiXinPaySignType) ? weiXinPaySignType : Constants.VARCHAR_DEFAULT_VALUE);
            asyncNotify.setUpdatedUserId(userId);
            asyncNotify.setUpdatedRemark("修改异步通知！");
            DatabaseHelper.update(asyncNotify);
        }

        return asyncNotify;
    }
}
