package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.umpay.*;
import build.dream.common.domains.saas.UmPayAccount;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.*;

public class UmPayUtils {
    /**
     * 获取联动支付账号
     *
     * @param tenantId
     * @param branchId
     * @return
     */
    public static UmPayAccount obtainUmPayAccount(String tenantId, String branchId) {
        String umPayAccountJson = CommonRedisUtils.hget(Constants.KEY_UM_PAY_ACCOUNTS, tenantId + "_" + branchId);
        if (StringUtils.isBlank(umPayAccountJson)) {
            return null;
        }
        return JacksonUtils.readValue(umPayAccountJson, UmPayAccount.class);
    }

    /**
     * 获取联动支付账号
     *
     * @param tenantId
     * @param branchId
     * @return
     */
    public static UmPayAccount obtainUmPayAccount(BigInteger tenantId, BigInteger branchId) {
        return obtainUmPayAccount(tenantId.toString(), branchId.toString());
    }

    /**
     * 签名
     *
     * @param requestParameters
     * @param privateKey
     * @param signType
     * @return
     */
    public static String generateSign(Map<String, String> requestParameters, String privateKey, String signType) {
        Map<String, String> sortedMap = new TreeMap<String, String>(requestParameters);

        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            pairs.add(entry.getKey() + "=" + entry.getValue());
        }

        byte[] data = StringUtils.join(pairs, "&").getBytes(Constants.CHARSET_GBK);
        if (Constants.RSA.equals(signType)) {
            return Base64.encodeBase64String(SignatureUtils.sign(data, Base64.decodeBase64(privateKey), SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA));
        }
        return null;
    }

    /**
     * 验签
     *
     * @param resultMap
     * @param platformCertificate
     * @return
     */
    public static boolean verifySign(Map<String, String> resultMap, String platformCertificate) {
        Map<String, String> sortedMap = new TreeMap<String, String>(resultMap);
        String sign = sortedMap.remove("sign");
        String signType = sortedMap.remove("sign_type");

        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            pairs.add(entry.getKey() + "=" + entry.getValue());
        }

        byte[] data = StringUtils.join(pairs, "&").getBytes(Constants.CHARSET_GBK);

        Certificate certificate = CertificateUtils.restoreCertificate(platformCertificate, CertificateUtils.CERTIFICATE_TYPE_X_509);
        if (Constants.RSA.equals(signType)) {
            return SignatureUtils.verifySign(data, certificate, Base64.decodeBase64(sign), SignatureUtils.SIGNATURE_TYPE_SHA1_WITH_RSA);
        }
        return false;
    }

    private static String encrypt(String data, String platformCertificate) {
        try {
            Certificate certificate = CertificateUtils.restoreCertificate(platformCertificate, CertificateUtils.CERTIFICATE_TYPE_X_509);
            PublicKey publicKey = certificate.getPublicKey();
            Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.encodeBase64String(cipher.doFinal(data.getBytes(Constants.CHARSET_GBK)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, String> parseResult(String result) {
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

    /**
     * 扫码支付下单-主扫
     *
     * @param activeScanCodeOrderModel
     * @return
     */
    public static Map<String, String> activeScanCodeOrder(ActiveScanCodeOrderModel activeScanCodeOrderModel) {
        activeScanCodeOrderModel.validateAndThrow();

        String charset = activeScanCodeOrderModel.getCharset();
        String merId = activeScanCodeOrderModel.getMerId();
        String signType = activeScanCodeOrderModel.getSignType();
        String resFormat = activeScanCodeOrderModel.getResFormat();
        String version = activeScanCodeOrderModel.getVersion();
        String privateKey = activeScanCodeOrderModel.getPrivateKey();
        String platformCertificate = activeScanCodeOrderModel.getPlatformCertificate();

        String topic = activeScanCodeOrderModel.getTopic();
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

        String service = "active_scancode_order";

        Map<String, String> activeScanCodeOrderParameters = new HashMap<String, String>();
        activeScanCodeOrderParameters.put("service", service);
        activeScanCodeOrderParameters.put("charset", charset);
        activeScanCodeOrderParameters.put("mer_id", merId);
        activeScanCodeOrderParameters.put("notify_url", NotifyUtils.obtainNotifyUrl(Constants.NOTIFY_TYPE_UM_PAY, "order_id"));
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
        activeScanCodeOrderParameters.put("sign", generateSign(activeScanCodeOrderParameters, privateKey, signType));
        activeScanCodeOrderParameters.put("sign_type", signType);

        NotifyUtils.saveUmPayAsyncNotify(orderId, topic, privateKey, platformCertificate);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, activeScanCodeOrderParameters);
        String result = webResponse.getResult();
        Map<String, String> resultMap = parseResult(result);
        ValidateUtils.isTrue(verifySign(resultMap, platformCertificate), "联动支付相应数据验签失败！");
        return resultMap;
    }

    /**
     * 扫码支付请求-被扫
     *
     * @return
     */
    public static Map<String, String> passiveScanCodePay(PassiveScanCodePayModel passiveScanCodePayModel) {
        passiveScanCodePayModel.validateAndThrow();

        String charset = passiveScanCodePayModel.getCharset();
        String merId = passiveScanCodePayModel.getMerId();
        String signType = passiveScanCodePayModel.getSignType();
        String resFormat = passiveScanCodePayModel.getResFormat();
        String version = passiveScanCodePayModel.getVersion();
        String privateKey = passiveScanCodePayModel.getPrivateKey();
        String platformCertificate = passiveScanCodePayModel.getPlatformCertificate();

        String topic = passiveScanCodePayModel.getTopic();
        String goodsId = passiveScanCodePayModel.getGoodsId();
        String goodsInf = passiveScanCodePayModel.getGoodsInf();
        String orderId = passiveScanCodePayModel.getOrderId();
        String merDate = passiveScanCodePayModel.getMerDate();
        Integer amount = passiveScanCodePayModel.getAmount();
        String amtType = passiveScanCodePayModel.getAmtType();
        String merPriv = passiveScanCodePayModel.getMerPriv();
        String userIp = passiveScanCodePayModel.getUserIp();
        String expand = passiveScanCodePayModel.getExpand();
        Integer expireTime = passiveScanCodePayModel.getExpireTime();
        String authCode = passiveScanCodePayModel.getAuthCode();
        String useDesc = passiveScanCodePayModel.getUseDesc();
        String scanCodeType = passiveScanCodePayModel.getScanCodeType();

        String service = "passive_scancode_pay";

        Map<String, String> passiveScanCodePayParameters = new HashMap<String, String>();
        passiveScanCodePayParameters.put("service", service);
        passiveScanCodePayParameters.put("charset", charset);
        passiveScanCodePayParameters.put("mer_id", merId);
        passiveScanCodePayParameters.put("notify_url", NotifyUtils.obtainNotifyUrl(Constants.NOTIFY_TYPE_UM_PAY, "order_id"));
        passiveScanCodePayParameters.put("res_format", resFormat);
        passiveScanCodePayParameters.put("version", version);

        ApplicationHandler.ifNotBlankPut(passiveScanCodePayParameters, "goods_id", goodsId);
        passiveScanCodePayParameters.put("goods_inf", goodsInf);
        passiveScanCodePayParameters.put("order_id", orderId);
        passiveScanCodePayParameters.put("mer_date", merDate);
        passiveScanCodePayParameters.put("amount", String.valueOf(amount));
        passiveScanCodePayParameters.put("amt_type", amtType);
        ApplicationHandler.ifNotBlankPut(passiveScanCodePayParameters, "mer_priv", merPriv);
        ApplicationHandler.ifNotBlankPut(passiveScanCodePayParameters, "user_ip", userIp);
        ApplicationHandler.ifNotBlankPut(passiveScanCodePayParameters, "expand", expand);
        if (expireTime != null) {
            passiveScanCodePayParameters.put("expire_time", String.valueOf(expireTime));
        }
        passiveScanCodePayParameters.put("auth_code", authCode);
        passiveScanCodePayParameters.put("use_desc", useDesc);
        passiveScanCodePayParameters.put("scancode_type", scanCodeType);
        passiveScanCodePayParameters.put("sign", generateSign(passiveScanCodePayParameters, privateKey, signType));
        passiveScanCodePayParameters.put("sign_type", signType);

        NotifyUtils.saveUmPayAsyncNotify(orderId, topic, privateKey, platformCertificate);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, passiveScanCodePayParameters);
        String result = webResponse.getResult();
        Map<String, String> resultMap = parseResult(result);
        ValidateUtils.isTrue(verifySign(resultMap, platformCertificate), "联动支付相应数据验签失败！");
        return resultMap;
    }

    /**
     * 公众号/立码支付
     *
     * @param publicNumberAndVerticalCodeModel
     * @return
     */
    public static Map<String, String> publicNumberAndVerticalCode(PublicNumberAndVerticalCodeModel publicNumberAndVerticalCodeModel) {
        publicNumberAndVerticalCodeModel.validateAndThrow();

        String charset = publicNumberAndVerticalCodeModel.getCharset();
        String merId = publicNumberAndVerticalCodeModel.getMerId();
        String signType = publicNumberAndVerticalCodeModel.getSignType();
        String resFormat = publicNumberAndVerticalCodeModel.getResFormat();
        String version = publicNumberAndVerticalCodeModel.getVersion();
        String privateKey = publicNumberAndVerticalCodeModel.getPrivateKey();
        String platformCertificate = publicNumberAndVerticalCodeModel.getPlatformCertificate();

        String topic = publicNumberAndVerticalCodeModel.getTopic();
        String orderId = publicNumberAndVerticalCodeModel.getOrderId();
        String merDate = publicNumberAndVerticalCodeModel.getMerDate();
        Integer amount = publicNumberAndVerticalCodeModel.getAmount();
        String amtType = publicNumberAndVerticalCodeModel.getAmtType();
        String userIp = publicNumberAndVerticalCodeModel.getUserIp();
        Integer expireTime = publicNumberAndVerticalCodeModel.getExpireTime();
        String merPriv = publicNumberAndVerticalCodeModel.getMerPriv();
        String expand = publicNumberAndVerticalCodeModel.getExpand();
        String goodsId = publicNumberAndVerticalCodeModel.getGoodsId();
        String goodsInf = publicNumberAndVerticalCodeModel.getGoodsInf();
        String isPublicNumber = publicNumberAndVerticalCodeModel.getIsPublicNumber();

        String service = "publicnumber_and_verticalcode";
        Map<String, String> publicNumberAndVerticalCodeParameters = new HashMap<String, String>();
        publicNumberAndVerticalCodeParameters.put("service", service);
        publicNumberAndVerticalCodeParameters.put("charset", charset);
        publicNumberAndVerticalCodeParameters.put("mer_id", merId);
        publicNumberAndVerticalCodeParameters.put("notify_url", NotifyUtils.obtainNotifyUrl(Constants.NOTIFY_TYPE_UM_PAY, "order_id"));
        publicNumberAndVerticalCodeParameters.put("res_format", resFormat);
        publicNumberAndVerticalCodeParameters.put("version", version);

        publicNumberAndVerticalCodeParameters.put("order_id", orderId);
        publicNumberAndVerticalCodeParameters.put("mer_date", merDate);
        publicNumberAndVerticalCodeParameters.put("amount", String.valueOf(amount));
        publicNumberAndVerticalCodeParameters.put("amt_type", amtType);
        ApplicationHandler.ifNotBlankPut(publicNumberAndVerticalCodeParameters, "user_ip", userIp);
        if (expireTime != null) {
            publicNumberAndVerticalCodeParameters.put("expire_time", String.valueOf(expireTime));
        }
        ApplicationHandler.ifNotBlankPut(publicNumberAndVerticalCodeParameters, "mer_priv", merPriv);
        ApplicationHandler.ifNotBlankPut(publicNumberAndVerticalCodeParameters, "expand", expand);
        ApplicationHandler.ifNotBlankPut(publicNumberAndVerticalCodeParameters, "goods_id", goodsId);
        publicNumberAndVerticalCodeParameters.put("goods_inf", goodsInf);
        publicNumberAndVerticalCodeParameters.put("is_public_number", isPublicNumber);
        publicNumberAndVerticalCodeParameters.put("sign", generateSign(publicNumberAndVerticalCodeParameters, privateKey, signType));
        publicNumberAndVerticalCodeParameters.put("sign_type", signType);

        NotifyUtils.saveUmPayAsyncNotify(orderId, topic, privateKey, platformCertificate);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, publicNumberAndVerticalCodeParameters);
        String result = webResponse.getResult();
        Map<String, String> resultMap = parseResult(result);
        ValidateUtils.isTrue(verifySign(resultMap, platformCertificate), "联动支付相应数据验签失败！");
        return resultMap;
    }

    /**
     * 商户查询订单状态
     *
     * @param merOrderInfoQueryModel
     * @return
     */
    public static Map<String, String> merOrderInfoQuery(MerOrderInfoQueryModel merOrderInfoQueryModel) {
        merOrderInfoQueryModel.validateAndThrow();

        String charset = merOrderInfoQueryModel.getCharset();
        String merId = merOrderInfoQueryModel.getMerId();
        String signType = merOrderInfoQueryModel.getSignType();
        String resFormat = merOrderInfoQueryModel.getResFormat();
        String version = merOrderInfoQueryModel.getVersion();
        String privateKey = merOrderInfoQueryModel.getPrivateKey();
        String platformCertificate = merOrderInfoQueryModel.getPlatformCertificate();

        String orderType = merOrderInfoQueryModel.getOrderType();
        String orderId = merOrderInfoQueryModel.getOrderId();
        String tradeNo = merOrderInfoQueryModel.getTradeNo();
        String merDate = merOrderInfoQueryModel.getMerDate();

        String service = "mer_order_info_query";
        Map<String, String> merOrderInfoQueryParameters = new HashMap<String, String>();
        merOrderInfoQueryParameters.put("service", service);
        merOrderInfoQueryParameters.put("charset", charset);
        merOrderInfoQueryParameters.put("mer_id", merId);
        merOrderInfoQueryParameters.put("res_format", resFormat);
        merOrderInfoQueryParameters.put("version", version);

        ApplicationHandler.ifNotBlankPut(merOrderInfoQueryParameters, "order_type", orderType);
        ApplicationHandler.ifNotBlankPut(merOrderInfoQueryParameters, "order_id", orderId);
        ApplicationHandler.ifNotBlankPut(merOrderInfoQueryParameters, "trade_no", tradeNo);
        merOrderInfoQueryParameters.put("mer_date", merDate);

        merOrderInfoQueryParameters.put("sign", generateSign(merOrderInfoQueryParameters, privateKey, signType));
        merOrderInfoQueryParameters.put("sign_type", signType);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, merOrderInfoQueryParameters);
        String result = webResponse.getResult();
        Map<String, String> resultMap = parseResult(result);
        ValidateUtils.isTrue(verifySign(resultMap, platformCertificate), "联动支付相应数据验签失败！");
        return resultMap;
    }

    /**
     * 商户撤销交易
     *
     * @param merCancelModel
     * @return
     */
    public static Map<String, String> merCancel(MerCancelModel merCancelModel) {
        merCancelModel.validateAndThrow();

        String charset = merCancelModel.getCharset();
        String merId = merCancelModel.getMerId();
        String signType = merCancelModel.getSignType();
        String resFormat = merCancelModel.getResFormat();
        String version = merCancelModel.getVersion();
        String privateKey = merCancelModel.getPrivateKey();
        String platformCertificate = merCancelModel.getPlatformCertificate();

        String orderId = merCancelModel.getOrderId();
        String merDate = merCancelModel.getMerDate();
        Integer amount = merCancelModel.getAmount();

        String service = "mer_cancel";
        Map<String, String> merCancelParameters = new HashMap<String, String>();
        merCancelParameters.put("service", service);
        merCancelParameters.put("charset", charset);
        merCancelParameters.put("mer_id", merId);
        merCancelParameters.put("res_format", resFormat);
        merCancelParameters.put("version", version);

        merCancelParameters.put("order_id", orderId);
        merCancelParameters.put("mer_date", merDate);
        merCancelParameters.put("amount", String.valueOf(amount));

        merCancelParameters.put("sign", generateSign(merCancelParameters, privateKey, signType));
        merCancelParameters.put("sign_type", signType);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, merCancelParameters);
        String result = webResponse.getResult();
        Map<String, String> resultMap = parseResult(result);
        ValidateUtils.isTrue(verifySign(resultMap, platformCertificate), "联动支付相应数据验签失败！");
        return resultMap;
    }

    /**
     * 商户退款请求
     *
     * @param merRefundModel
     * @return
     */
    public static Map<String, String> merRefund(MerRefundModel merRefundModel) {
        merRefundModel.validateAndThrow();

        String charset = merRefundModel.getCharset();
        String merId = merRefundModel.getMerId();
        String signType = merRefundModel.getSignType();
        String resFormat = merRefundModel.getResFormat();
        String version = merRefundModel.getVersion();
        String privateKey = merRefundModel.getPrivateKey();
        String platformCertificate = merRefundModel.getPlatformCertificate();

        String refundNo = merRefundModel.getRefundNo();
        String orderId = merRefundModel.getOrderId();
        String merDate = merRefundModel.getMerDate();
        Integer refundAmount = merRefundModel.getRefundAmount();
        Integer orgAmount = merRefundModel.getOrgAmount();

        String service = "mer_refund";
        Map<String, String> merRefundParameters = new HashMap<String, String>();
        merRefundParameters.put("service", service);
        merRefundParameters.put("charset", charset);
        merRefundParameters.put("mer_id", merId);
        merRefundParameters.put("res_format", resFormat);
        merRefundParameters.put("version", version);

        merRefundParameters.put("refund_no", refundNo);
        merRefundParameters.put("order_id", orderId);
        merRefundParameters.put("mer_date", merDate);
        merRefundParameters.put("refund_amount", String.valueOf(refundAmount));
        merRefundParameters.put("org_amount", String.valueOf(orgAmount));

        merRefundParameters.put("sign", generateSign(merRefundParameters, privateKey, signType));
        merRefundParameters.put("sign_type", signType);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, merRefundParameters);
        String result = webResponse.getResult();
        Map<String, String> resultMap = parseResult(result);
        ValidateUtils.isTrue(verifySign(resultMap, platformCertificate), "联动支付相应数据验签失败！");
        return resultMap;
    }

    /**
     * 商户退费订单状态查询
     *
     * @param merRefundQueryModel
     * @return
     */
    public static Map<String, String> merRefundQuery(MerRefundQueryModel merRefundQueryModel) {
        merRefundQueryModel.validateAndThrow();

        String charset = merRefundQueryModel.getCharset();
        String merId = merRefundQueryModel.getMerId();
        String signType = merRefundQueryModel.getSignType();
        String resFormat = merRefundQueryModel.getResFormat();
        String version = merRefundQueryModel.getVersion();
        String privateKey = merRefundQueryModel.getPrivateKey();
        String platformCertificate = merRefundQueryModel.getPlatformCertificate();

        String refundNo = merRefundQueryModel.getRefundNo();

        String service = "mer_refund_query";
        Map<String, String> merRefundQueryParameters = new HashMap<String, String>();
        merRefundQueryParameters.put("service", service);
        merRefundQueryParameters.put("charset", charset);
        merRefundQueryParameters.put("mer_id", merId);
        merRefundQueryParameters.put("res_format", resFormat);
        merRefundQueryParameters.put("version", version);

        merRefundQueryParameters.put("refund_no", refundNo);

        merRefundQueryParameters.put("sign", generateSign(merRefundQueryParameters, privateKey, signType));
        merRefundQueryParameters.put("sign_type", signType);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, merRefundQueryParameters);
        String result = webResponse.getResult();
        Map<String, String> resultMap = parseResult(result);
        ValidateUtils.isTrue(verifySign(resultMap, platformCertificate), "联动支付相应数据验签失败！");
        return resultMap;
    }

    /**
     * 退费信息补录
     *
     * @param refundInfoReplenishModel
     * @return
     */
    public static Map<String, String> refundInfoReplenish(RefundInfoReplenishModel refundInfoReplenishModel) {
        refundInfoReplenishModel.validateAndThrow();

        String charset = refundInfoReplenishModel.getCharset();
        String merId = refundInfoReplenishModel.getMerId();
        String signType = refundInfoReplenishModel.getSignType();
        String resFormat = refundInfoReplenishModel.getResFormat();
        String version = refundInfoReplenishModel.getVersion();
        String privateKey = refundInfoReplenishModel.getPrivateKey();
        String platformCertificate = refundInfoReplenishModel.getPlatformCertificate();

        String refundNo = refundInfoReplenishModel.getRefundNo();
        String cardHolder = refundInfoReplenishModel.getCardHolder();
        String cardId = refundInfoReplenishModel.getCardId();
        String gateId = refundInfoReplenishModel.getGateId();
        String cardBranchName = refundInfoReplenishModel.getCardBranchName();

        String service = "refund_info_replenish";
        Map<String, String> refundInfoReplenishParameters = new HashMap<String, String>();
        refundInfoReplenishParameters.put("service", service);
        refundInfoReplenishParameters.put("charset", charset);
        refundInfoReplenishParameters.put("mer_id", merId);
        refundInfoReplenishParameters.put("res_format", resFormat);
        refundInfoReplenishParameters.put("version", version);

        refundInfoReplenishParameters.put("refund_no", refundNo);
        refundInfoReplenishParameters.put("card_holder", encrypt(cardHolder, platformCertificate));
        refundInfoReplenishParameters.put("card_id", encrypt(cardId, platformCertificate));
        ApplicationHandler.ifNotBlankPut(refundInfoReplenishParameters, "gate_id", gateId);
        ApplicationHandler.ifNotBlankPut(refundInfoReplenishParameters, "card_branch_name", cardBranchName);

        refundInfoReplenishParameters.put("sign", generateSign(refundInfoReplenishParameters, privateKey, signType));
        refundInfoReplenishParameters.put("sign_type", signType);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, refundInfoReplenishParameters);
        String result = webResponse.getResult();
        Map<String, String> resultMap = parseResult(result);
        ValidateUtils.isTrue(verifySign(resultMap, platformCertificate), "联动支付相应数据验签失败！");
        return resultMap;
    }

    /**
     * 数据对账
     *
     * @param downloadSettleFileModel
     * @return
     */
    public static Map<String, String> downloadSettleFile(DownloadSettleFileModel downloadSettleFileModel) {
        downloadSettleFileModel.validateAndThrow();

        String signType = downloadSettleFileModel.getSignType();
        String merId = downloadSettleFileModel.getMerId();
        String version = downloadSettleFileModel.getVersion();
        String settleDate = downloadSettleFileModel.getSettleDate();
        String privateKey = downloadSettleFileModel.getPrivateKey();
        String platformCertificate = downloadSettleFileModel.getPlatformCertificate();

        String service = "download_settle_file";
        Map<String, String> downloadSettleFileParameters = new HashMap<String, String>();
        downloadSettleFileParameters.put("service", service);
        downloadSettleFileParameters.put("mer_id", merId);
        downloadSettleFileParameters.put("version", version);

        downloadSettleFileParameters.put("settle_date", settleDate);

        downloadSettleFileParameters.put("sign", generateSign(downloadSettleFileParameters, privateKey, signType));
        downloadSettleFileParameters.put("sign_type", signType);

        String url = ConfigurationUtils.getConfiguration(Constants.UM_PAY_SERVICE_URL);
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(url, downloadSettleFileParameters);
        String result = webResponse.getResult();
        String[] lines = result.split("\r\n");
        Map<String, String> header = new HashMap<String, String>();
        Map<String, String> footer = new HashMap<String, String>();
        List<Map<String, String>> tradeInfos = new ArrayList<Map<String, String>>();

        for (int index = 0; index < lines.length; index++) {
            String[] array = lines[index].split(",");
            if (index == 0) {
                header.put("merId", array[1]);
                header.put("settleDate", array[2]);
                header.put("version", array[3]);
                header.put("retCode", array[4]);
                header.put("retMsg", array[5]);
                continue;
            }

            if (index == lines.length - 1) {
                footer.put("merId", array[1]);
                footer.put("settleDate", array[2]);
                footer.put("numbers", array[3]);
                footer.put("totalAmount", array[4]);
                continue;
            }

            Map<String, String> tradeInfo = new HashMap<String, String>();
            tradeInfo.put("merId", array[0]);
            tradeInfo.put("goodsId", array[1]);
            tradeInfo.put("mobileId", array[2]);
            tradeInfo.put("orderId", array[3]);
            tradeInfo.put("merDate", array[4]);
            tradeInfo.put("payDate", array[5]);
            tradeInfo.put("amount", array[6]);
            tradeInfo.put("amtType", array[7]);
            tradeInfo.put("gateId", array[8]);
            tradeInfo.put("settleDate", array[9]);
            tradeInfo.put("transType", array[10]);
            tradeInfo.put("transState", array[11]);
            tradeInfo.put("bankCheck", array[12]);
            tradeInfo.put("productId", array[13]);
            tradeInfo.put("refundNo", array[14]);
            tradeInfo.put("transTime", array[15]);

            tradeInfos.add(tradeInfo);
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("header", header);
        data.put("footer", footer);
        data.put("tradeInfos", tradeInfos);
        return null;
    }
}
