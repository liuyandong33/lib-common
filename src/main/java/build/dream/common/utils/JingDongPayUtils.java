package build.dream.common.utils;

import build.dream.common.models.jingdongpay.UniOrderModel;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JingDongPayUtils {
    public static String callJingDongApi(String url, Map<String, Object> requestParameters) throws IOException {
        StringBuilder signXml = new StringBuilder();
        StringBuilder requestBody = new StringBuilder();
        StringBuilder encryptXml = new StringBuilder();

        signXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        signXml.append("<jdpay>");

        requestBody.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        requestBody.append("<jdpay>");

        for (Map.Entry<String, Object> entry : requestParameters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                signXml.append("<").append(key).append(">").append(value).append("</").append(key).append(">");

                if ("version".equals(key) || "merchant".equals(key)) {
                    requestBody.append("<").append(key).append(">").append(value).append("</").append(key).append(">");
                } else {
                    encryptXml.append("<").append(key).append(">").append(value).append("</").append(key).append(">");
                }
            }
        }
        signXml.append("</jdpay>");

        String sign = DigestUtils.sha256Hex(signXml.toString());
        encryptXml.append("<sign>").append(sign).append("</sign>");
        requestBody.append("<encrypt>").append(DigestUtils.sha256Hex(encryptXml.toString())).append("</encrypt>");

        requestBody.append("</jdpay>");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("content-type", "application/xml");
        return WebUtils.doPostWithRequestBody(url, headers, requestBody.toString(), null);
    }

    public static String uniOrder(UniOrderModel uniOrderModel) throws IOException {
        String url = "https://paygate.jd.com/service/uniorder";
        return callJingDongApi(url, ApplicationHandler.toMap(uniOrderModel));
    }

    public static void main(String[] args) throws IOException {
        UniOrderModel uniOrderModel = new UniOrderModel();
        uniOrderModel.setMerchant(UUID.randomUUID().toString());
        String result = uniOrder(uniOrderModel);
        System.out.println(result);
    }
}
