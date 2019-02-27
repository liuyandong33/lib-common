package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class ArtificialIntelligenceUtils {
    private static String generateSignature() {
        return null;
    }

    public static Map<String, Object> imageTag(String accessId, String accessKey, int type, String imageUrl, String content) {
        String method = Constants.REQUEST_METHOD_POST;
        String accept = "application/json";
        String contentType = "application/json";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, Constants.GMT));

        String date = simpleDateFormat.format(new Date());

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("type", type);
        if (type == 0) {
            requestBody.put("image_url", imageUrl);
        } else if (type == 1) {
            requestBody.put("content", content);
        }

        String bodyMd5 = Base64.encodeBase64String(DigestUtils.md5(GsonUtils.toJson(requestBody)));
        String stringToSign = method + "\n" + accept + "\n" + bodyMd5 + "\n" + contentType + "\n" + date + "\n";

        String signature = Base64.encodeBase64String(HmacUtils.hmacSha1(accessKey, stringToSign));

        String authHeader = "Dataplus " + accessId + ":" + signature;

        return null;
    }
}
