package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.miya.OrderPayModel;
import build.dream.common.models.miya.OrderQueryModel;
import build.dream.common.models.miya.RefundModel;
import build.dream.common.saas.domains.MiyaAccount;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class MiyaUtils {
    public static final Map<String, String> HEADERS = new HashMap<String, String>();

    static {
        HEADERS.put("Content-Type", "text/xml");
    }

    private static MiyaAccount obtainMiyaAccount(String tenantId, String branchId) {
        String miyaAccountJson = CommonRedisUtils.hget(Constants.KEY_MIYA_ACCOUNTS, tenantId + "_" + branchId);
        MiyaAccount miyaAccount = null;
        if (StringUtils.isNotBlank(miyaAccountJson)) {
            miyaAccount = GsonUtils.fromJson(miyaAccountJson, MiyaAccount.class);
        }
        return miyaAccount;
    }

    public static String generateSign(Map<String, String> requestDomainRequestParameters, Map<String, String> dataDomainRequestParameters, String miyaKey) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
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
        requestBody.append(buildXml(requestDomainRequestParameters));
        requestBody.append("</request>");

        requestBody.append("<data>");
        requestBody.append(buildXml(dataDomainRequestParameters));
        requestBody.append("</data>");

        requestBody.append("</xml>");
        return requestBody.toString();
    }

    public static String buildXml(Map<String, String> map) {
        StringBuilder xml = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            xml.append("<").append(key).append(">");
            if (StringUtils.isNotBlank(value)) {
                xml.append(String.format(Constants.CDATA_FORMAT, value));
            }
            xml.append("</").append(key).append(">");
        }
        return xml.toString();
    }

    public static Map<String, String> orderPay(OrderPayModel orderPayModel) {
        orderPayModel.validateAndThrow();
        String tenantId = orderPayModel.getTenantId();
        String branchId = orderPayModel.getBranchId();
        String a10 = orderPayModel.getA10();
        String a11 = orderPayModel.getA11();
        String b1 = orderPayModel.getB1();
        String b2 = orderPayModel.getB2();
        String b3 = orderPayModel.getB3();
        String b4 = orderPayModel.getB4();
        String b5 = orderPayModel.getB5();

        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");
        return null;
    }

    public static Map<String, String> refund(String tenantId, String branchId, RefundModel refundModel) {
        refundModel.validateAndThrow();
        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");
        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", refundModel.getPosId());
        requestDomainRequestParameters.put("A5", refundModel.getCashierId());
        requestDomainRequestParameters.put("A6", "C");
        requestDomainRequestParameters.put("A7", "1.5");

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", refundModel.getOrderNumber());
        dataDomainRequestParameters.put("B2", refundModel.getRefundNumber());
        dataDomainRequestParameters.put("B4", refundModel.getRefundAmount().toString());

        requestDomainRequestParameters.put("A8", generateSign(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey()));
        String requestBody = buildRequestBody(requestDomainRequestParameters, dataDomainRequestParameters);
        String url = ConfigurationUtils.getConfiguration(Constants.MIYA_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, requestBody);
        Map<String, String> result = XmlUtils.xmlStringToMap(webResponse.getResult());
        ValidateUtils.isTrue(Constants.SUCCESS.equals(result.get("C1")), result.get("C4"));
        return result;
    }

    public static Map<String, String> orderQuery(String tenantId, String branchId, OrderQueryModel orderQueryModel) {
        orderQueryModel.validateAndThrow();
        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");

        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", orderQueryModel.getPosId());
        requestDomainRequestParameters.put("A5", orderQueryModel.getCashierId());
        requestDomainRequestParameters.put("A6", "B");
        requestDomainRequestParameters.put("A7", "1.5");

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", orderQueryModel.getOrderNumber());

        requestDomainRequestParameters.put("A8", generateSign(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey()));
        String requestBody = buildRequestBody(requestDomainRequestParameters, dataDomainRequestParameters);
        String url = ConfigurationUtils.getConfiguration(Constants.MIYA_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, requestBody);
        Map<String, String> result = XmlUtils.xmlStringToMap(webResponse.getResult());
        ValidateUtils.isTrue(Constants.SUCCESS.equals(result.get("C1")), result.get("C4"));
        return result;
    }
}
