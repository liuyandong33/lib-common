package build.dream.common.utils;

import build.dream.common.models.unionpay.FrontTransReqModel;

import java.util.HashMap;
import java.util.Map;

public class UnionPayUtils {
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
        return null;
    }
}
