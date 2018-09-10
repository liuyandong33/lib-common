package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OSSUtils {
    public static Map<String, String> obtainPolicy(String accessId, String accessKey, String host, String dir, Date expiration, List<Object[]> conditions, Map<String, String> callback) throws UnsupportedEncodingException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.ISO8601_DATE_PATTERN, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));

        Map<String, Object> policyMap = new HashMap<String, Object>();
        policyMap.put("expiration", simpleDateFormat.format(expiration));
        policyMap.put("conditions", conditions);

        String policy = Base64.encodeBase64String(GsonUtils.toJson(policyMap).getBytes(Constants.CHARSET_NAME_UTF_8));
        String signature = Base64.encodeBase64String(HmacUtils.hmacSha1(accessKey.getBytes(Constants.CHARSET_NAME_UTF_8), policy.getBytes(Constants.CHARSET_NAME_UTF_8)));

        Map<String, String> data = new HashMap<String, String>();
        data.put("accessId", accessId);
        data.put("policy", policy);
        data.put("signature", signature);
        data.put("dir", dir);
        data.put("host", host);
        data.put("callback", Base64.encodeBase64String(GsonUtils.toJson(callback).getBytes(Constants.CHARSET_NAME_UTF_8)));
        return data;
    }
}
