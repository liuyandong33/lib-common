package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.alipay.AlipayTradePayModel;
import build.dream.common.models.weixin.MicroPayModel;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

public class AggregatePayUtils {
    public static JSONObject scanCodePay(int channelType, String outTradeNo, String authCode, String subject, long totalAmount) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        JSONObject result = null;
        if (channelType == Constants.CHANNEL_TYPE_WEI_XIN) {
            AlipayTradePayModel alipayTradePayModel = new AlipayTradePayModel();
            alipayTradePayModel.setOutTradeNo(outTradeNo);
            alipayTradePayModel.setAuthCode(authCode);
            alipayTradePayModel.setScene(Constants.SCENE_BAR_CODE);
            alipayTradePayModel.setSubject(subject);
            alipayTradePayModel.setTotalAmount(BigDecimal.valueOf(totalAmount).divide(BigDecimal.valueOf(100)).toString());

            String appId = null;
            result = AlipayUtils.alipayTradePay(appId, null, null, alipayTradePayModel);
        } else if (channelType == Constants.CHANNEL_TYPE_ALIPAY) {
            MicroPayModel microPayModel = new MicroPayModel();
            result = WeiXinPayUtils.microPay(microPayModel);
        } else if (channelType == Constants.CHANNEL_TYPE_JING_DONG) {
            result = JingDongPayUtils.fkmPay();
        }
        return result;
    }
}
