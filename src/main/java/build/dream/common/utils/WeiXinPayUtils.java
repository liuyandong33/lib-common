package build.dream.common.utils;

import build.dream.common.models.weixin.MicroPayModel;
import build.dream.common.saas.domains.WeiXinPayAccount;
import net.sf.json.JSONObject;
import org.apache.commons.lang.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class WeiXinPayUtils {
    private static WeiXinPayAccount obtainWeiXinPayAccount(String mchId) {
        return null;
    }

    public static JSONObject microPay(String mchId, MicroPayModel microPayModel) {
        WeiXinPayAccount weiXinPayAccount = obtainWeiXinPayAccount(mchId);

        Map<String, String> microPayRequestParameters = new HashMap<String, String>();
        microPayRequestParameters.put("appid", weiXinPayAccount.getAppId());
        microPayRequestParameters.put("mch_id", weiXinPayAccount.getMchId());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "device_info", microPayModel.getDeviceInfo());
        microPayRequestParameters.put("nonce_str", RandomStringUtils.randomAlphanumeric(32));
        microPayRequestParameters.put("body", microPayModel.getBody());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "detail", microPayModel.getDetail());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "attach", microPayModel.getAttach());
        microPayRequestParameters.put("out_trade_no", microPayModel.getOutTradeNo());
        microPayRequestParameters.put("total_fee", microPayModel.getTotalFee().toString());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "fee_type", microPayModel.getFeeType());
        microPayRequestParameters.put("spbill_create_ip", microPayModel.getSpbillCreateIp());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "goods_tag", microPayModel.getGoodsTag());
        ApplicationHandler.ifNotBlankPut(microPayRequestParameters, "limit_pay", microPayModel.getLimitPay());
        microPayRequestParameters.put("auth_code", microPayModel.getAuthCode());
        if (microPayModel.getSceneInfoModel() != null) {
            microPayRequestParameters.put("scene_info", GsonUtils.toJson(microPayModel.getSceneInfoModel(), false));
        }

        return null;
    }

    public static JSONObject microPay(MicroPayModel microPayModel) {
        String mchId = "";
        return microPay(mchId, microPayModel);
    }
}
