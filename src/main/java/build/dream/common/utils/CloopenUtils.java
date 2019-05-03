package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloopenUtils {
    private static final String BASE_URL = "https://app.cloopen.com:8883";

    public static Map<String, Object> sendSms(String accountSid, String authToken, String appId, String to, String templateId, List<String> datas) {
        Date now = new Date();

        String timestamp = CustomDateUtils.format(now, "yyyyMMddHHmmss");
        String sig = DigestUtils.md2Hex(accountSid + authToken + timestamp).toUpperCase();
        String url = BASE_URL + "/" + CustomDateUtils.format(now, "yyyy-MM-dd") + "/Accounts/" + accountSid + "/SMS/TemplateSMS?sig=" + sig;

        String authorization = Base64.encodeBase64String(StringUtils.getBytesUtf8(accountSid + "," + timestamp));

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json;charset=utf-8");
        headers.put("Authorization", authorization);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("to", to);
        body.put("appId", appId);
        body.put("templateId", templateId);
        body.put("datas", datas);

        WebResponse webResponse = OutUtils.doPostWithRequestBody(url, headers, GsonUtils.toJson(body));
        String result = webResponse.getResult();
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        String statusCode = MapUtils.getString(resultMap, "statusCode");
        ValidateUtils.isTrue("000000".equals(statusCode), "短信发送失败！");
        return resultMap;
    }
}
