package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.http.MediaType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ArtificialIntelligenceUtils {
    private static String calculateSignature(String accessKey, String method, String accept, String body, String contentType, String date) {
        String bodyMd5 = Base64.encodeBase64String(DigestUtils.md5(body));
        String stringToSign = method + "\n" + accept + "\n" + bodyMd5 + "\n" + contentType + "\n" + date + "\n";

        String signature = Base64.encodeBase64String(HmacUtils.hmacSha1(accessKey, stringToSign));
        return signature;
    }

    public static Map<String, Object> imageTag(String accessId, String accessKey, int type, String imageUrl, String content) {
        String method = Constants.REQUEST_METHOD_POST;
        String accept = MediaType.APPLICATION_JSON_VALUE;
        String contentType = MediaType.APPLICATION_JSON_VALUE;
        String date = CustomDateUtils.buildISO8601SimpleDateFormat().format(new Date());

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("type", type);
        if (type == 0) {
            requestBody.put("image_url", imageUrl);
        } else if (type == 1) {
            requestBody.put("content", content);
        }

        String body = GsonUtils.toJson(requestBody);
        String signature = calculateSignature(accessKey, method, accept, body, contentType, date);

        String authorization = "Dataplus " + accessId + ":" + signature;

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("accept", accept);
        headers.put("content-type", contentType);
        headers.put("date", date);
        headers.put("Authorization", authorization);

        WebResponse webResponse = OutUtils.doPostWithRequestBody("", headers, body);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        int errno = MapUtils.getIntValue(resultMap, "errno");
        ValidateUtils.isTrue(errno == 0, MapUtils.getString(resultMap, "err_msg"));
        return resultMap;
    }
}
