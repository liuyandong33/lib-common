package build.dream.common.utils;

import build.dream.common.beans.MqConfig;
import build.dream.common.constants.Constants;
import build.dream.common.domains.saas.WeiXinPayAccount;
import build.dream.common.models.aggregatepay.ScanCodePayModel;
import build.dream.common.models.alipay.AlipayTradePayModel;
import build.dream.common.models.weixinpay.MicroPayModel;

import java.util.Map;

public class AggregatePayUtils {
    private AggregatePayUtils() {
        throw new AssertionError("No build.dream.common.utils.AggregatePayUtils instances for you!");
    }

    public static Map<String, ? extends Object> scanCodePay(ScanCodePayModel scanCodePayModel) {
        String tenantId = scanCodePayModel.getTenantId();
        String branchId = scanCodePayModel.getBranchId();
        int channelType = scanCodePayModel.getChannelType();
        String outTradeNo = scanCodePayModel.getOutTradeNo();
        String authCode = scanCodePayModel.getAuthCode();
        String subject = scanCodePayModel.getSubject();
        int totalAmount = scanCodePayModel.getTotalAmount();
        MqConfig mqConfig = scanCodePayModel.getMqConfig();
        String ipAddress = scanCodePayModel.getIpAddress();

        Map<String, ? extends Object> result = null;
        if (channelType == Constants.CHANNEL_TYPE_WEI_XIN) {
            WeiXinPayAccount weiXinPayAccount = WeiXinPayUtils.obtainWeiXinPayAccount(tenantId, branchId);
            MicroPayModel microPayModel = MicroPayModel.builder()
                    .appId(weiXinPayAccount.getAppId())
                    .mchId(weiXinPayAccount.getMchId())
                    .apiKey(weiXinPayAccount.getApiKey())
                    .subAppId(weiXinPayAccount.getSubPublicAccountAppId())
                    .subMchId(weiXinPayAccount.getSubMchId())
                    .acceptanceModel(weiXinPayAccount.isAcceptanceModel())
                    .body(subject)
                    .outTradeNo(outTradeNo)
                    .totalFee(totalAmount)
                    .spbillCreateIp(ipAddress)
                    .authCode(authCode)
                    .build();
            result = WeiXinPayUtils.microPay(microPayModel);
        } else if (channelType == Constants.CHANNEL_TYPE_ALIPAY) {
            AlipayTradePayModel alipayTradePayModel = AlipayTradePayModel.builder()
                    .mqConfig(mqConfig)
                    .outTradeNo(outTradeNo)
                    .authCode(authCode)
                    .scene(Constants.SCENE_BAR_CODE)
                    .subject(subject)
                    .totalAmount(Double.valueOf(totalAmount) / 100)
                    .build();
            result = AlipayUtils.alipayTradePay(alipayTradePayModel);
        }
        return result;
    }
}
