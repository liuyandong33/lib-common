package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlUtils {
    public static String decode(String encryptedString) {
        return decode(encryptedString, Constants.CHARSET_NAME_UTF_8);
    }

    public static String decode(String encryptedString, String charsetName) {
        try {
            return URLDecoder.decode(encryptedString, charsetName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String encode(String originalString) {
        return encode(originalString, Constants.CHARSET_NAME_UTF_8);
    }

    public static String encode(String originalString, String charsetName) {
        try {
            return URLEncoder.encode(originalString, charsetName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
