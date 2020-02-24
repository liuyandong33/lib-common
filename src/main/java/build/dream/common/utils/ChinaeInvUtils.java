package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.domains.saas.OauthClientDetail;
import build.dream.common.models.chinaeinv.InvoiceV3KpAsyncModel;
import build.dream.common.tuples.Tuple2;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.*;

public class ChinaeInvUtils {
    private static final String CHINAEINV_PROTOCOL = "https";
    private static final String CHINAEINV_HOST = "www.chinaeinv.com";
    private static final int CHINAEINV_PORT = 943;
    private static final String PATH_INVOICE_API = "/api/invoiceApi.jspa";

    public static String obtainUrl(String protocol, String host, int port, String path, Map<String, String> parameters) {
        return protocol + "://" + host + ":" + port + path + "?" + WebUtils.buildQueryString(parameters);
    }

    public static String obtainUrl(String protocol, String host, int port, String path, Tuple2<String, String>... parameters) {
        Map<String, String> map = new HashMap<String, String>();
        for (Tuple2<String, String> parameter : parameters) {
            map.put(parameter._1(), parameter._2());
        }
        return obtainUrl(protocol, host, port, path, map);
    }

    public static String obtainUrl(String path, Map<String, String> parameters) {
        return obtainUrl(CHINAEINV_PROTOCOL, CHINAEINV_HOST, CHINAEINV_PORT, path, parameters);
    }

    public static String obtainUrl(String path, Tuple2<String, String>... parameters) {
        return obtainUrl(CHINAEINV_PROTOCOL, CHINAEINV_HOST, CHINAEINV_PORT, path, parameters);
    }

    public static Map<String, Object> invoiceV3KpAsync(InvoiceV3KpAsyncModel invoiceV3KpAsyncModel) {
        invoiceV3KpAsyncModel.validateAndThrow();
        String appCode = invoiceV3KpAsyncModel.getAppCode();
        String cmdName = "chinaeinv.api.invoice.v3.kp_async";
        String body = JacksonUtils.writeValueAsString(invoiceV3KpAsyncModel, JsonInclude.Include.NON_NULL);

        byte[] data = body.getBytes(Constants.CHARSET_UTF_8);
        byte[] privateKey = new byte[1024];
        String sign = Base64.encodeBase64String(SignatureUtils.sign(data, privateKey, SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA));

        String url = obtainUrl(PATH_INVOICE_API, TupleUtils.buildTuple2("appCode", appCode), TupleUtils.buildTuple2("cmdName", cmdName), TupleUtils.buildTuple2("sign", sign));

        String result = OutUtils.doPostWithRequestBody(url, body, Constants.CHARSET_NAME_UTF_8, Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        return JacksonUtils.readValueAsMap(result, String.class, Object.class);
    }

    public static void main(String[] args) {
        InvoiceV3KpAsyncModel.Order order = new InvoiceV3KpAsyncModel.Order();
        order.setOrderNo(DigestUtils.md5Hex(UUID.randomUUID().toString()).toUpperCase());

        InvoiceV3KpAsyncModel.Invoice invoice = new InvoiceV3KpAsyncModel.Invoice();
        invoice.setTaxpayerCode("");
        invoice.setCustomerName("刘艳东");
        invoice.setDrawer("刘艳东");
        invoice.setTotalAmount(100D);

        InvoiceV3KpAsyncModel.Item item = new InvoiceV3KpAsyncModel.Item();
        item.setType("1");
        item.setName("黄焖鸡米饭");
        item.setAmount(100D);

        List<InvoiceV3KpAsyncModel.Item> items = new ArrayList<InvoiceV3KpAsyncModel.Item>();
        items.add(item);

        InvoiceV3KpAsyncModel invoiceV3KpAsyncModel = new InvoiceV3KpAsyncModel();
        invoiceV3KpAsyncModel.setAppCode("");
        invoiceV3KpAsyncModel.setSerialNo(UUID.randomUUID().toString());
        invoiceV3KpAsyncModel.setOrder(order);
        invoiceV3KpAsyncModel.setInvoice(invoice);
        invoiceV3KpAsyncModel.setItems(items);

        Map<String, Object> result = invoiceV3KpAsync(invoiceV3KpAsyncModel);
        System.out.println();

        String clientSecretPlaintext = DigestUtils.md5Hex(UUID.randomUUID().toString());
        OauthClientDetail oauthClientDetail = OauthClientDetail.builder()
                .clientId(UUID.randomUUID().toString())
                .clientSecret(BCryptUtils.encode(clientSecretPlaintext))
                .resourceIds(Constants.RESOURCE_ID_CATERING)
                .scope("all")
                .authorizedGrantTypes("password,refresh_token")
                .webServerRedirectUri("")
                .authorities("")
                .accessTokenValidity(60 * 60 * 24 * 30)
                .refreshTokenValidity(60 * 60 * 24 * 37)
                .additionalInformation("")
                .autoApproveScope("false")
                .build();
    }
}
