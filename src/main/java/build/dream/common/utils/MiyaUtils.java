package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.miya.*;
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
        if (StringUtils.isBlank(miyaAccountJson)) {
            return null;
        }
        return JacksonUtils.readValue(miyaAccountJson, MiyaAccount.class);
    }

    private static String generateSign(Map<String, String> requestDomainRequestParameters, Map<String, String> dataDomainRequestParameters, String miyaKey) {
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

    private static String buildRequestBody(Map<String, String> requestDomainRequestParameters, Map<String, String> dataDomainRequestParameters) {
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

    private static String buildXml(Map<String, String> map) {
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

    private static Map<String, String> callMiyaSystem(Map<String, String> requestDomainRequestParameters, Map<String, String> dataDomainRequestParameters, String miyaKey) {
        requestDomainRequestParameters.put("A8", generateSign(requestDomainRequestParameters, dataDomainRequestParameters, miyaKey));
        String requestBody = buildRequestBody(requestDomainRequestParameters, dataDomainRequestParameters);
        String url = ConfigurationUtils.getConfiguration(Constants.MIYA_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, requestBody);
        Map<String, String> result = XmlUtils.xmlStringToMap(webResponse.getResult());
        ValidateUtils.isTrue(Constants.SUCCESS.equals(result.get("C1")), result.get("C4"));
        return result;
    }

    /**
     * 下单支付
     *
     * @param orderPayModel
     * @return
     */
    public static Map<String, String> orderPay(OrderPayModel orderPayModel) {
        orderPayModel.validateAndThrow();
        String tenantId = orderPayModel.getTenantId();
        String branchId = orderPayModel.getBranchId();
        String a4 = orderPayModel.getA4();
        String a5 = orderPayModel.getA5();
        String a10 = orderPayModel.getA10();
        String a11 = orderPayModel.getA11();
        String b1 = orderPayModel.getB1();
        String b2 = orderPayModel.getB2();
        String b3 = orderPayModel.getB3();
        String b4 = orderPayModel.getB4();
        String b5 = orderPayModel.getB5();
        String b6 = orderPayModel.getB6();
        String b7 = orderPayModel.getB7();
        String b8 = orderPayModel.getB8();
        String b15 = orderPayModel.getB15();

        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");

        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", a4);
        requestDomainRequestParameters.put("A5", a5);
        requestDomainRequestParameters.put("A6", "A");
        requestDomainRequestParameters.put("A7", "1.5");
        ApplicationHandler.ifNotBlankPut(requestDomainRequestParameters, "A10", a10);
        ApplicationHandler.ifNotBlankPut(requestDomainRequestParameters, "A11", a11);

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", b1);
        dataDomainRequestParameters.put("B2", b2);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B3", b3);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B4", b4);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B5", b5);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B6", b6);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B7", b7);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B8", b8);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B15", b15);

        return callMiyaSystem(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey());
    }

    /**
     * 订单查询
     *
     * @param orderQueryModel
     * @return
     */
    public static Map<String, String> orderQuery(OrderQueryModel orderQueryModel) {
        orderQueryModel.validateAndThrow();
        String tenantId = orderQueryModel.getTenantId();
        String branchId = orderQueryModel.getBranchId();
        String a4 = orderQueryModel.getA4();
        String a5 = orderQueryModel.getA5();
        String b1 = orderQueryModel.getB1();

        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");

        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", a4);
        requestDomainRequestParameters.put("A5", a5);
        requestDomainRequestParameters.put("A6", "B");
        requestDomainRequestParameters.put("A7", "1.5");

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", b1);

        return callMiyaSystem(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey());
    }

    /**
     * 退款
     *
     * @param refundModel
     * @return
     */
    public static Map<String, String> refund(RefundModel refundModel) {
        refundModel.validateAndThrow();
        String tenantId = refundModel.getTenantId();
        String branchId = refundModel.getBranchId();
        String a4 = refundModel.getA4();
        String a5 = refundModel.getA5();
        String b1 = refundModel.getB1();
        String b2 = refundModel.getB2();
        String b4 = refundModel.getB4();
        String b5 = refundModel.getB5();

        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");

        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", a4);
        requestDomainRequestParameters.put("A5", a5);
        requestDomainRequestParameters.put("A6", "C");
        requestDomainRequestParameters.put("A7", "1.5");

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", b1);
        dataDomainRequestParameters.put("B2", b2);
        dataDomainRequestParameters.put("B4", b4);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B5", b5);

        return callMiyaSystem(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey());
    }

    /**
     * 退款查询
     *
     * @param refundQueryModel
     * @return
     */
    public static Map<String, String> refundQuery(RefundQueryModel refundQueryModel) {
        refundQueryModel.validateAndThrow();
        String tenantId = refundQueryModel.getTenantId();
        String branchId = refundQueryModel.getBranchId();
        String a4 = refundQueryModel.getA4();
        String a5 = refundQueryModel.getA5();
        String b1 = refundQueryModel.getB1();
        String b2 = refundQueryModel.getB2();

        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");

        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", a4);
        requestDomainRequestParameters.put("A5", a5);
        requestDomainRequestParameters.put("A6", "D");
        requestDomainRequestParameters.put("A7", "1.5");

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", b1);
        dataDomainRequestParameters.put("B2", b2);

        return callMiyaSystem(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey());
    }

    /**
     * 撤销订单
     *
     * @param cancelOrderModel
     * @return
     */
    public static Map<String, String> cancelOrder(CancelOrderModel cancelOrderModel) {
        cancelOrderModel.validateAndThrow();
        String tenantId = cancelOrderModel.getTenantId();
        String branchId = cancelOrderModel.getBranchId();
        String a4 = cancelOrderModel.getA4();
        String a5 = cancelOrderModel.getA5();
        String b1 = cancelOrderModel.getB1();

        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");

        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", a4);
        requestDomainRequestParameters.put("A5", a5);
        requestDomainRequestParameters.put("A6", "E");
        requestDomainRequestParameters.put("A7", "1.5");

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", b1);

        return callMiyaSystem(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey());
    }

    /**
     * 预下单
     *
     * @param prepareOrderModel
     * @return
     */
    public static Map<String, String> prepareOrder(PrepareOrderModel prepareOrderModel) {
        prepareOrderModel.validateAndThrow();
        String tenantId = prepareOrderModel.getTenantId();
        String branchId = prepareOrderModel.getBranchId();
        String a4 = prepareOrderModel.getA4();
        String a5 = prepareOrderModel.getA5();
        String a10 = prepareOrderModel.getA10();
        String a12 = prepareOrderModel.getA12();
        String b1 = prepareOrderModel.getB1();
        String b3 = prepareOrderModel.getB3();
        String b4 = prepareOrderModel.getB4();
        String b5 = prepareOrderModel.getB5();
        String b13 = prepareOrderModel.getB13();

        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");

        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", a4);
        requestDomainRequestParameters.put("A5", a5);
        requestDomainRequestParameters.put("A6", "F");
        requestDomainRequestParameters.put("A7", "1.5");
        ApplicationHandler.ifNotBlankPut(requestDomainRequestParameters, "A10", a10);
        requestDomainRequestParameters.put("A12", a12);

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", b1);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B3", b3);
        dataDomainRequestParameters.put("B4", b4);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B5", b5);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B13", b13);

        return callMiyaSystem(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey());
    }

    /**
     * 创建订单
     *
     * @param createOrderModel
     * @return
     */
    public static Map<String, String> createOrder(CreateOrderModel createOrderModel) {
        createOrderModel.validateAndThrow();
        String tenantId = createOrderModel.getTenantId();
        String branchId = createOrderModel.getBranchId();
        String a4 = createOrderModel.getA4();
        String a5 = createOrderModel.getA5();
        String a11 = createOrderModel.getA11();
        String a12 = createOrderModel.getA12();
        String b1 = createOrderModel.getB1();
        String b3 = createOrderModel.getB3();
        String b4 = createOrderModel.getB4();
        String b5 = createOrderModel.getB5();
        String b11 = createOrderModel.getB11();
        String b12 = createOrderModel.getB12();
        String b13 = createOrderModel.getB3();
        String b14 = createOrderModel.getB14();
        String b16 = createOrderModel.getB16();
        String b17 = createOrderModel.getB17();
        String b18 = createOrderModel.getB18();

        MiyaAccount miyaAccount = obtainMiyaAccount(tenantId, branchId);
        ValidateUtils.notNull(miyaAccount, "商户未配置米雅账号！");

        Map<String, String> requestDomainRequestParameters = new HashMap<String, String>();
        requestDomainRequestParameters.put("A1", "A");
        requestDomainRequestParameters.put("A2", miyaAccount.getMiyaMerchantCode());
        requestDomainRequestParameters.put("A3", miyaAccount.getMiyaBranchCode());
        requestDomainRequestParameters.put("A4", a4);
        requestDomainRequestParameters.put("A5", a5);
        requestDomainRequestParameters.put("A6", "G");
        requestDomainRequestParameters.put("A7", "1.5");
        requestDomainRequestParameters.put("A11", a11);
        requestDomainRequestParameters.put("A12", a12);

        Map<String, String> dataDomainRequestParameters = new HashMap<String, String>();
        dataDomainRequestParameters.put("B1", b1);
        dataDomainRequestParameters.put("B3", b3);
        dataDomainRequestParameters.put("B4", b4);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B5", b5);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B11", b11);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B12", b12);
        dataDomainRequestParameters.put("B13", b13);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B14", b14);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B16", b16);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B17", b17);
        ApplicationHandler.ifNotBlankPut(dataDomainRequestParameters, "B18", b18);

        return callMiyaSystem(requestDomainRequestParameters, dataDomainRequestParameters, miyaAccount.getMiyaKey());
    }
}
