package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.alipay.AlipayTradePayModel;
import build.dream.common.models.jingdong.FkmPayModel;
import build.dream.common.models.weixin.MicroPayModel;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

public class AggregatePayUtils {
    public static JSONObject scanCodePay(String tenantId, String branchId, int channelType, String outTradeNo, String authCode, String subject, int totalAmount, String notifyUrl, String ipAddress) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException, DocumentException {
        JSONObject result = null;
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
            result = JSONObject.fromObject(WeiXinPayUtils.microPay(tenantId, branchId, microPayModel));
        } else if (channelType == Constants.CHANNEL_TYPE_JING_DONG) {
            FkmPayModel fkmPayModel = new FkmPayModel();
            result = JingDongPayUtils.fkmPay(fkmPayModel);
        }
        return result;
    }
}
