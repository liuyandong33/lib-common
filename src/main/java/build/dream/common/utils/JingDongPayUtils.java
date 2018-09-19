package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.models.jingdong.FkmPayModel;
import build.dream.common.models.jingdong.UniOrderModel;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JingDongPayUtils {
    public static Map<String, String> callJingDongApi(String url, Map<String, Object> requestParameters) throws IOException, DocumentException {
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
        WebResponse webResponse = WebUtils.doPostWithRequestBody(url, headers, requestBody.toString(), null);
        String result = webResponse.getResult();
        Document document = DocumentHelper.parseText(result);
        Element rootElement = document.getRootElement();
        Element resultElement = rootElement.element("result");

        Map<String, String> resultMap = new HashMap<String, String>();

        String code = resultElement.element("code").getText();
        String desc = resultElement.element("desc").getText();
        ValidateUtils.isTrue("000000".equals(code), desc);

        String merchant = rootElement.element("merchant").getText();
        String encrypt = rootElement.element("encrypt").getText();
        return resultMap;
    }

    public static Map<String, String> uniOrder(UniOrderModel uniOrderModel) throws IOException, DocumentException {
        String url = "https://paygate.jd.com/service/uniorder";
        return callJingDongApi(url, ApplicationHandler.toMap(uniOrderModel));
    }

    public static Map<String, Object> fkmPay(FkmPayModel fkmPayModel) {
        return null;
    }

    public static void main(String[] args) throws IOException, DocumentException {
        UniOrderModel uniOrderModel = new UniOrderModel();
        uniOrderModel.setMerchant(UUID.randomUUID().toString());
        Map<String, String> result = uniOrder(uniOrderModel);
        System.out.println(result);
    }
}
