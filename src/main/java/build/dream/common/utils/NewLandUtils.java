package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.newland.BarcodePayModel;
import build.dream.common.saas.domains.NewLandAccount;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NewLandUtils {
    private static final Map<String, String> HEADERS = new HashMap<String, String>();

    static {
        HEADERS.put("Content-Type", "application/json");
    }

    private static NewLandAccount obtainNewLandAccount(String tenantId, String branchId) {
        String newLandAccountJson = CacheUtils.hget(Constants.KEY_NEW_LAND_ACCOUNTS, tenantId + "_" + branchId);
        NewLandAccount newLandAccount = null;
        if (StringUtils.isNotBlank(newLandAccountJson)) {
            newLandAccount = GsonUtils.fromJson(newLandAccountJson, NewLandAccount.class);
        }
        return newLandAccount;
    }

    private static String generateSign(Map<String, String> requestParameters, String secretKey) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.putAll(requestParameters);

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append(secretKey);
        return DigestUtils.md5Hex(stringBuilder.toString());
    }

    public static Map<String, String> barcodePay(String tenantId, String branchId, BarcodePayModel barcodePayModel) {
        NewLandAccount newLandAccount = obtainNewLandAccount(tenantId, branchId);
        ValidateUtils.notNull(newLandAccount, "未配置新大陆支付账号！");

        Map<String, String> barcodePayRequestParameters = new HashMap<String, String>();
        barcodePayRequestParameters.put("opSys", barcodePayModel.getOpSys());
        barcodePayRequestParameters.put("characterSet", barcodePayModel.getCharacterSet());

        String latitude = barcodePayModel.getLatitude();
        if (StringUtils.isNotBlank(latitude)) {
            barcodePayRequestParameters.put("latitude", latitude);
        }

        String longitude = barcodePayModel.getLongitude();
        if (StringUtils.isNotBlank(longitude)) {
            barcodePayRequestParameters.put("longitude", longitude);
        }

        barcodePayRequestParameters.put("orgNo", newLandAccount.getOrgNo());
        barcodePayRequestParameters.put("mercId", newLandAccount.getMchId());
        barcodePayRequestParameters.put("trmNo", newLandAccount.getTrmNo());

        String trmTyp = barcodePayModel.getTrmTyp();
        if (StringUtils.isNotBlank(trmTyp)) {
            barcodePayRequestParameters.put("trmTyp", trmTyp);
        }

        barcodePayRequestParameters.put("tradeNo", barcodePayModel.getTradeNo());
        barcodePayRequestParameters.put("txnTime", barcodePayModel.getTxnTime());

        barcodePayRequestParameters.put("signType", Constants.MD5);

        String addField = barcodePayModel.getAddField();
        if (StringUtils.isNotBlank(addField)) {
            barcodePayRequestParameters.put("addField", addField);
        }

        barcodePayRequestParameters.put("version", barcodePayModel.getVersion());
        barcodePayRequestParameters.put("amount", barcodePayModel.getAmount().toString());
        barcodePayRequestParameters.put("total_amount", barcodePayModel.getTotalAmount().toString());
        barcodePayRequestParameters.put("authCode", barcodePayModel.getAuthCode());
        barcodePayRequestParameters.put("payChannel", barcodePayModel.getPayChannel());

        String subject = barcodePayModel.getSubject();
        if (StringUtils.isNotBlank(subject)) {
            barcodePayRequestParameters.put("subject", subject);
        }

        String selOrderNo = barcodePayModel.getSelOrderNo();
        if (StringUtils.isNotBlank(selOrderNo)) {
            barcodePayRequestParameters.put("selOrderNo", selOrderNo);
        }

        String goodsTag = barcodePayModel.getGoodsTag();
        if (StringUtils.isNotBlank(goodsTag)) {
            barcodePayRequestParameters.put("goodsTag", goodsTag);
        }

        String attach = barcodePayModel.getAttach();
        if (StringUtils.isNotBlank(attach)) {
            barcodePayRequestParameters.put("attach", attach);
        }

        barcodePayRequestParameters.put("signValue", generateSign(barcodePayRequestParameters, newLandAccount.getSecretKey()));

        String url = ConfigurationUtils.getConfiguration(Constants.NEW_LAND_PAY_SERVICE_URL) + "/" + Constants.SDK_BARCODE_PAY + ".json";
        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, HEADERS, GsonUtils.toJson(barcodePayRequestParameters));
        Map<String, String> result = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, String.class);

        String message = result.get("message");
        ValidateUtils.isTrue("000000".equals(result.get("returnCode")), message);

        return result;
    }
}
