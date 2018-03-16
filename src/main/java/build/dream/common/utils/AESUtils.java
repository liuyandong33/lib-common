package build.dream.common.utils;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by liuyandong on 2017/7/21.
 */
public class AESUtils {
    public static final String KEY_ALGORITHM = "AES";
    public static final String ALGORITHM_AES_ECB_PKCS7PADDING = "AES/ECB/PKCS7Padding";
    public static final String ALGORITHM_AES_CBC_PKCS7PADDING = "AES/CBC/PKCS7Padding";
    public static final String PROVIDER_NAME_BC = "BC";

    public static byte[] encrypt(byte[] data, byte[] aesKey, String algorithm, String providerName) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(algorithm, providerName);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public static byte[] encrypt(byte[] data, byte[] aesKey, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] encryptedData, byte[] aesKey, String algorithm, String providerName) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(algorithm, providerName);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedData);
    }

    public static byte[] decrypt(byte[] encryptedData, byte[] aesKey, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedData);
    }

    public static byte[] decrypt(byte[] encryptedData, byte[] aesKey, byte[] iv, String algorithm, String providerName) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance(algorithm, providerName);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(encryptedData);
    }
}
