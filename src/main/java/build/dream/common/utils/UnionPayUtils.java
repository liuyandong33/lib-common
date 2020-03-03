package build.dream.common.utils;

import build.dream.common.constants.RedisKeys;
import build.dream.common.domains.saas.UnionPayAccount;
import build.dream.common.models.unionpay.FrontTransReqModel;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class UnionPayUtils {
    /**
     * 获取银联支付账号
     *
     * @param tenantId
     * @param branchId
     * @return
     */
    public static UnionPayAccount obtainUnionPayAccount(String tenantId, String branchId) {
        String unionPayAccountJson = CommonRedisUtils.hget(RedisKeys.KEY_UNION_PAY_ACCOUNTS, tenantId + "_" + branchId);
        if (StringUtils.isBlank(unionPayAccountJson)) {
            return null;
        }
        return JacksonUtils.readValue(unionPayAccountJson, UnionPayAccount.class);
    }

    public static Map<String, Object> frontTransReq(FrontTransReqModel frontTransReqModel) {
        String version = frontTransReqModel.getVersion();
        String encoding = frontTransReqModel.getEncoding();
        String bizType = frontTransReqModel.getBizType();
        String txnTime = frontTransReqModel.getTxnTime();
        String backUrl = frontTransReqModel.getBackUrl();
        String currencyCode = frontTransReqModel.getCurrencyCode();
        Integer txnAmt = frontTransReqModel.getTxnAmt();
        String txnType = frontTransReqModel.getTxnType();
        String txnSubType = frontTransReqModel.getTxnSubType();
        String accessType = frontTransReqModel.getAccessType();
        String channelType = frontTransReqModel.getChannelType();
        String merId = frontTransReqModel.getMerId();
        String orderId = frontTransReqModel.getOrderId();
        String orderDesc = frontTransReqModel.getOrderDesc();
        String subMerId = frontTransReqModel.getSubMerId();
        String subMerAbbr = frontTransReqModel.getSubMerAbbr();
        String subMerName = frontTransReqModel.getSubMerName();
        String issInsCode = frontTransReqModel.getIssInsCode();
        String instalTransInfo = frontTransReqModel.getInstalTransInfo();
        String encryptCertId = frontTransReqModel.getEncryptCertId();
        String frontUrl = frontTransReqModel.getFrontUrl();
        String customerInfo = frontTransReqModel.getCustomerInfo();
        String cardTransData = frontTransReqModel.getCardTransData();
        String accountPayChannel = frontTransReqModel.getAccountPayChannel();
        String accNo = frontTransReqModel.getAccNo();
        String accType = frontTransReqModel.getAccType();
        String certId = frontTransReqModel.getCertId();
        String reserved = frontTransReqModel.getReserved();
        String customerIp = frontTransReqModel.getCustomerIp();
        String orderTimeout = frontTransReqModel.getOrderTimeout();
        String accSplitData = frontTransReqModel.getAccSplitData();
        String riskRateInfo = frontTransReqModel.getRiskRateInfo();
        String ctrlRule = frontTransReqModel.getCtrlRule();
        String defaultPayType = frontTransReqModel.getDefaultPayType();
        String reqReserved = frontTransReqModel.getReqReserved();
        String frontFailUrl = frontTransReqModel.getFrontFailUrl();
        String supPayType = frontTransReqModel.getSupPayType();
        String payTimeout = frontTransReqModel.getPayTimeout();
        String termId = frontTransReqModel.getTermId();
        String userMac = frontTransReqModel.getUserMac();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("version", version);
        requestParameters.put("encoding", encoding);
        requestParameters.put("bizType", bizType);
        requestParameters.put("txnTime", txnTime);
        requestParameters.put("backUrl", backUrl);
        requestParameters.put("currencyCode", currencyCode);
        requestParameters.put("txnAmt", txnAmt.toString());
        requestParameters.put("txnType", txnType);
        requestParameters.put("txnSubType", txnSubType);
        requestParameters.put("accessType", accessType);
        requestParameters.put("channelType", channelType);
        requestParameters.put("merId", merId);
        requestParameters.put("orderId", orderId);
        requestParameters.put("orderDesc", orderDesc);
        requestParameters.put("subMerId", subMerId);
        requestParameters.put("subMerAbbr", subMerAbbr);
        requestParameters.put("subMerName", subMerName);
        requestParameters.put("issInsCode", issInsCode);
        requestParameters.put("instalTransInfo", instalTransInfo);
        requestParameters.put("encryptCertId", encryptCertId);
        requestParameters.put("frontUrl", frontUrl);
        requestParameters.put("customerInfo", customerInfo);
        requestParameters.put("cardTransData", cardTransData);
        requestParameters.put("accountPayChannel", accountPayChannel);
        requestParameters.put("accNo", accNo);
        requestParameters.put("accType", accType);
        requestParameters.put("certId", certId);
        requestParameters.put("reserved", reserved);
        requestParameters.put("customerIp", customerIp);
        requestParameters.put("orderTimeout", orderTimeout);
        requestParameters.put("accSplitData", accSplitData);
        requestParameters.put("riskRateInfo", riskRateInfo);
        requestParameters.put("ctrlRule", ctrlRule);
        requestParameters.put("defaultPayType", defaultPayType);
        requestParameters.put("reqReserved", reqReserved);
        requestParameters.put("frontFailUrl", frontFailUrl);
        requestParameters.put("supPayType", supPayType);
        requestParameters.put("payTimeout", payTimeout);
        requestParameters.put("termId", termId);
        requestParameters.put("userMac", userMac);

        String url = "https://gateway.test.95516.com/gateway/api/frontTransReq.do";
        String result = OutUtils.doPostWithForm(url, requestParameters);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        return resultMap;
    }
}
