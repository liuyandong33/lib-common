package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.miya.RefundModel;
import build.dream.common.saas.domains.MiyaPayAccount;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiyaUtils {
    private static MiyaPayAccount obtainMiyaPayAccount(String tenantId, String branchId) {
        String miyaPayAccountJson = CacheUtils.hget(Constants.KEY_MIYA_PAY_ACCOUNTS, tenantId + "_" + branchId);
        MiyaPayAccount miyaPayAccount = null;
        if (StringUtils.isNotBlank(miyaPayAccountJson)) {
            miyaPayAccount = GsonUtils.fromJson(miyaPayAccountJson, MiyaPayAccount.class);
        }
        return miyaPayAccount;
    }

    public static String generateSign(Map<String, String> requestDomainRequestParameters, Map<String, String> dataDomainRequestParameters, String miyaKey) {
        Map<String, String> sortedMap = new HashMap<String, String>();
        sortedMap.putAll(requestDomainRequestParameters);
        sortedMap.putAll(dataDomainRequestParameters);

        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            String value = entry.getValue();
            if (StringUtils.isNotBlank(value)) {
                pairs.add(entry.getKey() + "=" + value);
            }
        }
        return DigestUtils.md5Hex("&" + StringUtils.join(pairs, "&") + "&KEY=" + miyaKey).toUpperCase();
    }

    public static String buildRequestBody(Map<String, String> requestDomainRequestParameters, Map<String, String> dataDomainRequestParameters) {
        StringBuilder requestBody = new StringBuilder("<xml>");
        requestBody.append("<request>");
        for (Map.Entry<String, String> entry : requestDomainRequestParameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            requestBody.append("<").append(key).append(">");
            if (StringUtils.isNotBlank(value)) {
                requestBody.append(String.format(Constants.CDATA_FORMAT, value));
            }
            requestBody.append("</").append(key).append(">");
        }
        requestBody.append("</request>");

        requestBody.append("<data>");
        for (Map.Entry<String, String> entry : dataDomainRequestParameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            requestBody.append("<").append(key).append(">");
            if (StringUtils.isNotBlank(value)) {
                requestBody.append(String.format(Constants.CDATA_FORMAT, value));
            }
            requestBody.append("</").append(key).append(">");
        }
        requestBody.append("</data>");
        requestBody.append("</xml>");
        return requestBody.toString();
    }

    public static Map<String, String> refund(String tenantId, String branchId, RefundModel refundModel) throws IOException, DocumentException {
        MiyaPayAccount miyaPayAccount = obtainMiyaPayAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaPayAccount, "商户未配置米雅账号！");
        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaPayAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaPayAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", refundModel.getPosId().toString());
        requestDomainRequestParameters.put("A5", refundModel.getCashierId().toString());
        requestDomainRequestParameters.put("A6", "C");
        requestDomainRequestParameters.put("A7", "1.5");

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", refundModel.getOrderNumber());
        dataDomainRequestParameters.put("B2", refundModel.getRefundNumber());
        dataDomainRequestParameters.put("B4", refundModel.getRefundAmount().toString());

        requestDomainRequestParameters.put("A8", generateSign(requestDomainRequestParameters, dataDomainRequestParameters, miyaPayAccount.getMiyaKey()));
        String requestBody = buildRequestBody(requestDomainRequestParameters, dataDomainRequestParameters);
        String url = ConfigurationUtils.getConfiguration(Constants.MIYA_PAY_SERVICE_URL);
        WebResponse webResponse = WebUtils.doPostWithRequestBody(url, requestBody);
        Map<String, String> result = WebUtils.xmlStringToMap(webResponse.getResult());
        ValidateUtils.isTrue(Constants.SUCCESS.equals(result.get("C1")), result.get("C4"));
        return result;
    }
}
