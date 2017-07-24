package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liuyandong on 2017/7/21.
 */
public class AESUtils {
    public static final String KEY_ALGORITHM = "AES";

    public static String encrypt(String data, String aesKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        SecretKey secretKey = new SecretKeySpec(DigestUtils.md5(aesKey), KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes(Constants.CHARSET_UTF_8)));
    }

    public static String decrypt(String encryptedData, String aesKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        SecretKey secretKey = new SecretKeySpec(DigestUtils.md5(aesKey), KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.decodeBase64(encryptedData)), Constants.CHARSET_UTF_8);
    }
}
