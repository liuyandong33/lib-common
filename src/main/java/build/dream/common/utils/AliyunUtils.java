package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AliyunUtils {
    public static final String ACCESS_KEY_ID = ConfigurationUtils.getConfiguration(Constants.ALIYUN_ACCESS_KEY_ID);
    public static final String ACCESS_KEY_SECRET = ConfigurationUtils.getConfiguration(Constants.ALIYUN_ACCESS_KEY_SECRET);
    public static final String DY_SMS_API_URL = "https://dysmsapi.aliyuncs.com";
    public static final String DY_PLS_API_URL = "https://dyplsapi.aliyuncs.com";

    /**
     * 生成签名
     *
     * @param requestParameters
     * @param accessSecret
     * @return
     */
    public static String generateSignature(Map<String, String> requestParameters, String accessSecret) {
        Map<String, String> sortedRequestParameters = new TreeMap<String, String>(requestParameters);
        List<String> requestParameterPairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedRequestParameters.entrySet()) {
            requestParameterPairs.add(UrlUtils.encode(entry.getKey(), Constants.CHARSET_NAME_UTF_8) + "=" + UrlUtils.encode(entry.getValue(), Constants.CHARSET_NAME_UTF_8));
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.REQUEST_METHOD_POST);
        stringBuilder.append("&");
        stringBuilder.append(UrlUtils.encode("/", Constants.CHARSET_NAME_UTF_8));
        stringBuilder.append("&");
        stringBuilder.append(UrlUtils.encode(StringUtils.join(requestParameterPairs, "&"), Constants.CHARSET_NAME_UTF_8));
        return Base64.encodeBase64String(HmacUtils.hmacSha1(accessSecret + "&", stringBuilder.toString()));
    }
}
