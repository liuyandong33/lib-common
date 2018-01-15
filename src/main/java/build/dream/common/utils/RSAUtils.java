package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by liuyandong on 2017/7/21.
 */
public class RSAUtils {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String PADDING_MODE_RSA_NONE_NOPADDING = "RSA/None/NoPadding";
    public static final String PADDING_MODE_RSA_ECB_OAEPWITHSHA1ANDMGF1PADDING = "RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING";
    public static final String PADDING_MODE_RSA_ECB_PKCS1PADDING = "RSA/ECB/PKCS1Padding";

    public static String[] generateKeyPair(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(keySize, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        return new String[]{Base64.encodeBase64String(keyPair.getPublic().getEncoded()), Base64.encodeBase64String(keyPair.getPrivate().getEncoded())};
    }

    /**
     * 还原公钥
     * @param publicKey：公钥字符串
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PublicKey restorePublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        return restorePublicKey(keyBytes);
    }

    /**
     * 还原公钥
     * @param keyBytes：公钥字节数组
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PublicKey restorePublicKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }

    /**
     * 还原私钥
     * @param privateKey：私钥字符串
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PrivateKey restorePrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        return restorePrivateKey(keyBytes);
    }

    /**
     * 还原私钥
     * @param keyBytes：私钥字节数组
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PrivateKey restorePrivateKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }

    /**
     * 公钥加密
     * @param data：要加密的数据
     * @param publicKey：公钥
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encryptByPublicKey(String data, String publicKey, String paddingMode) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key key = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(paddingMode);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes(Constants.CHARSET_UTF_8)));
    }

    /**
     * 私钥加密
     * @param data：要加密的数据
     * @param privateKey：私钥
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encryptByPrivateKey(String data, String privateKey, String paddingMode) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, DecoderException, UnsupportedEncodingException {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(paddingMode);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes(Constants.CHARSET_UTF_8)));
    }

    /**
     * 公钥解密
     * @param encryptedData：已加密的数据
     * @param publicKey：公钥
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String decryptByPublicKey(String encryptedData, String publicKey, String paddingMode) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, DecoderException, UnsupportedEncodingException {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key key = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(paddingMode);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.decodeBase64(encryptedData)), Constants.CHARSET_UTF_8);
    }

    public static String decryptByPrivateKey(String encryptedData, String privateKey, String paddingMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(paddingMode);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.decodeBase64(encryptedData)), Constants.CHARSET_UTF_8);
    }
}
