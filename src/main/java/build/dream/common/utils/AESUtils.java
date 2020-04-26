package build.dream.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by liuyandong on 2017/7/21.
 */
public class AESUtils {
    public static final String KEY_ALGORITHM = "AES";
    public static final String ALGORITHM_AES_ECB_PKCS7PADDING = "AES/ECB/PKCS7Padding";
    public static final String ALGORITHM_AES_CBC_PKCS7PADDING = "AES/CBC/PKCS7Padding";
    public static final String ALGORITHM_AES_CBC_NOPADDING = "AES/CBC/NoPadding";
    public static final String PROVIDER_NAME_BC = "BC";

    private AESUtils() {
        throw new AssertionError("No build.dream.common.utils.AESUtils instances for you!");
    }

    public static byte[] encrypt(byte[] data, byte[] aesKey, String algorithm, String providerName) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(algorithm, providerName);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encrypt(byte[] data, byte[] aesKey, String algorithm) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encrypt(byte[] data, byte[] aesKey, byte[] iv, String algorithm) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(algorithm);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encrypt(byte[] data, byte[] aesKey, byte[] iv, String algorithm, String providerName) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(algorithm, providerName);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decrypt(byte[] encryptedData, byte[] aesKey, String algorithm, String providerName) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(algorithm, providerName);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decrypt(byte[] encryptedData, byte[] aesKey, byte[] iv, String algorithm) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(algorithm);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return cipher.doFinal(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decrypt(byte[] encryptedData, byte[] aesKey, byte[] iv, String algorithm, String providerName) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(algorithm, providerName);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return cipher.doFinal(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
