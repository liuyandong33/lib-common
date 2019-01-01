package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class BeElemeUtils {
    private static String BE_ELE_ME_SERVICE_URL = "https://api-be.ele.me/";

    public static String generateSignature(Map<String, String> requestParameters) throws UnsupportedEncodingException {
        Map<String, String> sortedMap = new TreeMap<String, String>(requestParameters);

        List<String> requestParameterPairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            requestParameterPairs.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), Constants.CHARSET_NAME_UTF_8));
        }

        return DigestUtils.md5Hex(StringUtils.join(requestParameterPairs, "&")).toUpperCase();
    }

    public static String callBeElemeSystem(String cmd, String source, String body, String encrypt, String fields) throws UnsupportedEncodingException {
        long timestamp = System.currentTimeMillis();
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("cmd", cmd);
        requestParameters.put("timestamp", String.valueOf(timestamp));
        requestParameters.put("version", "3");
        requestParameters.put("ticket", UUID.randomUUID().toString());
        requestParameters.put("source", source);
        requestParameters.put("body", body);
        if (StringUtils.isNotBlank(encrypt)) {
            requestParameters.put("encrypt", encrypt);
        }

        if (StringUtils.isNotBlank(fields)) {
            requestParameters.put("fields", fields);
        }

        requestParameters.put("sign", generateSignature(requestParameters));
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(BE_ELE_ME_SERVICE_URL, requestParameters);
        return webResponse.getResult();
    }
}
