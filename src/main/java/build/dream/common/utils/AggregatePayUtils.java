package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.aggregatepay.ScanCodePayModel;
import build.dream.common.models.alipay.AlipayTradePayModel;
import build.dream.common.models.jingdong.FkmPayModel;
import build.dream.common.models.weixinpay.MicroPayModel;
import org.dom4j.DocumentException;

import java.math.BigDecimal;
import java.util.Map;

public class AggregatePayUtils {
    public static Map<String, ? extends Object> scanCodePay(ScanCodePayModel scanCodePayModel) throws DocumentException {
        String tenantId = scanCodePayModel.getTenantId();
        String branchId = scanCodePayModel.getBranchId();
        int channelType = scanCodePayModel.getChannelType();
        String outTradeNo = scanCodePayModel.getOutTradeNo();
        String authCode = scanCodePayModel.getAuthCode();
        String subject = scanCodePayModel.getSubject();
        int totalAmount = scanCodePayModel.getTotalAmount();
        String notifyUrl = scanCodePayModel.getNotifyUrl();
        String ipAddress = scanCodePayModel.getIpAddress();

        Map<String, ? extends Object> result = null;
        if (channelType == Constants.CHANNEL_TYPE_WEI_XIN) {
            AlipayTradePayModel alipayTradePayModel = new AlipayTradePayModel();
            alipayTradePayModel.setOutTradeNo(outTradeNo);
            alipayTradePayModel.setAuthCode(authCode);
            alipayTradePayModel.setScene(Constants.SCENE_BAR_CODE);
            alipayTradePayModel.setSubject(subject);
            alipayTradePayModel.setTotalAmount(BigDecimal.valueOf(totalAmount).divide(BigDecimal.valueOf(100)).toString());

            String appId = null;
            result = AlipayUtils.alipayTradePay(tenantId, branchId, notifyUrl, null, alipayTradePayModel);
        } else if (channelType == Constants.CHANNEL_TYPE_ALIPAY) {
            MicroPayModel microPayModel = new MicroPayModel();
            microPayModel.setBody(subject);
            microPayModel.setOutTradeNo(outTradeNo);
            microPayModel.setTotalFee(totalAmount);
            microPayModel.setSpbillCreateIp(ipAddress);
            microPayModel.setAuthCode(authCode);
            result = WeiXinPayUtils.microPay(tenantId, branchId, microPayModel);
        } else if (channelType == Constants.CHANNEL_TYPE_JING_DONG) {
            FkmPayModel fkmPayModel = new FkmPayModel();
            result = JingDongPayUtils.fkmPay(fkmPayModel);
        }
        return result;
    }
}
