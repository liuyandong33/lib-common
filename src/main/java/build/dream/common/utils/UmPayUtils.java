package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.umpay.ActiveScanCodeOrderModel;
import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UmPayUtils {
    private static String generateSign(Map<String, String> requestParameters, String merchantPrivateKey, String signType) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.putAll(requestParameters);
        sortedMap.remove("sign_type");

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getValue());
        }

        byte[] data = stringBuilder.toString().getBytes(Constants.CHARSET_UTF_8);
        if (Constants.RSA.equals(signType)) {
            return Base64.encodeBase64String(SignatureUtils.sign(data, Base64.decodeBase64(merchantPrivateKey), SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA));
        }
        return null;
    }

    public static Map<String, String> activeScanCodeOrder(ActiveScanCodeOrderModel activeScanCodeOrderModel) {
        String charset = activeScanCodeOrderModel.getCharset();
        String merId = activeScanCodeOrderModel.getMerId();
        String signType = activeScanCodeOrderModel.getSignType();
        String topic = activeScanCodeOrderModel.getTopic();
        String resFormat = activeScanCodeOrderModel.getResFormat();
        String version = activeScanCodeOrderModel.getVersion();
        String goodsId = activeScanCodeOrderModel.getGoodsId();
        String goodsInf = activeScanCodeOrderModel.getGoodsInf();
        String orderId = activeScanCodeOrderModel.getOrderId();
        String merDate = activeScanCodeOrderModel.getMerDate();
        Integer amount = activeScanCodeOrderModel.getAmount();
        String amtType = activeScanCodeOrderModel.getAmtType();
        String merPriv = activeScanCodeOrderModel.getMerPriv();
        String userIp = activeScanCodeOrderModel.getUserIp();
        String expand = activeScanCodeOrderModel.getExpand();
        Integer expireTime = activeScanCodeOrderModel.getExpireTime();
        String scanCodeType = activeScanCodeOrderModel.getScanCodeType();
        String merchantPrivateKey = activeScanCodeOrderModel.getMerchantPrivateKey();
        String platformPublicKey = activeScanCodeOrderModel.getPlatformPublicKey();

        String service = "active_scancode_order";

        Map<String, String> activeScanCodeOrderParameters = new HashMap<String, String>();
        activeScanCodeOrderParameters.put("service", service);
        activeScanCodeOrderParameters.put("charset", charset);
        activeScanCodeOrderParameters.put("mer_id", merId);
//        activeScanCodeOrderParameters.put("sign_type", signType);
        activeScanCodeOrderParameters.put("notify_url", "");
        activeScanCodeOrderParameters.put("res_format", resFormat);
        activeScanCodeOrderParameters.put("version", version);

        ApplicationHandler.ifNotBlankPut(activeScanCodeOrderParameters, "goods_id", goodsId);
        activeScanCodeOrderParameters.put("goods_inf", goodsInf);
        activeScanCodeOrderParameters.put("order_id", orderId);
        activeScanCodeOrderParameters.put("mer_date", merDate);
        activeScanCodeOrderParameters.put("amount", String.valueOf(amount));
        activeScanCodeOrderParameters.put("amt_type", amtType);
        ApplicationHandler.ifNotBlankPut(activeScanCodeOrderParameters, "mer_priv", merPriv);
        ApplicationHandler.ifNotBlankPut(activeScanCodeOrderParameters, "user_ip", userIp);
        ApplicationHandler.ifNotBlankPut(activeScanCodeOrderParameters, "expand", expand);
        if (expireTime != null) {
            activeScanCodeOrderParameters.put("expire_time", String.valueOf(expireTime));
        }
        activeScanCodeOrderParameters.put("scancode_type", scanCodeType);
        activeScanCodeOrderParameters.put("sign", generateSign(activeScanCodeOrderParameters, merchantPrivateKey, signType));
        activeScanCodeOrderParameters.put("sign_type", signType);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, activeScanCodeOrderParameters);
        String result = webResponse.getResult();

        Document document = Jsoup.parse(result);
        Elements metaElements = document.getElementsByTag("META");
        Element metaElement = metaElements.get(0);
        String content = metaElement.attr("CONTENT");
        String[] array = content.split("&");

        Map<String, String> resultMap = new HashMap<String, String>();
        for (String item : array) {
            int equalSignIndex = item.indexOf("=");
            resultMap.put(item.substring(0, equalSignIndex), item.substring(equalSignIndex + 1));
        }
        return resultMap;
    }
}
