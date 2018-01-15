package build.dream.common.utils;

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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/21.
 */
public class RSAUtils {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String PADDING_MODE_RSA_NONE_NOPADDING = "RSA/None/NoPadding";
    public static final String PADDING_MODE_RSA_ECB_OAEPWITHSHA1ANDMGF1PADDING = "RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING";
    public static final String PADDING_MODE_RSA_ECB_PKCS1PADDING = "RSA/ECB/PKCS1Padding";

    public static Map<String, byte[]> generateKeyPair(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(keySize, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        Map<String, byte[]> keyMap = new HashMap<String, byte[]>();
        keyMap.put("publicKey", keyPair.getPublic().getEncoded());
        keyMap.put("privateKey", keyPair.getPrivate().getEncoded());
        return keyMap;
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
     * @param paddingMode：填充模式
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey, String paddingMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(paddingMode);
        cipher.init(Cipher.ENCRYPT_MODE, restorePublicKey(publicKey));
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     * @param data：要加密的数据
     * @param privateKey：私钥
     * @param paddingMode：填充模式
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey, String paddingMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(paddingMode);
        cipher.init(Cipher.ENCRYPT_MODE, restorePrivateKey(privateKey));
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     * @param encryptedData：已加密的数据
     * @param publicKey：公钥
     * @param paddingMode：填充模式
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, byte[] publicKey, String paddingMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(paddingMode);
        cipher.init(Cipher.DECRYPT_MODE, restorePublicKey(publicKey));
        return cipher.doFinal(encryptedData);
    }

    /**
     * 私钥解密
     * @param encryptedData：已加密的数据
     * @param privateKey：私钥
     * @param paddingMode：填充模式
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws UnsupportedEncodingException
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, byte[] privateKey, String paddingMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(paddingMode);
        cipher.init(Cipher.DECRYPT_MODE, restorePrivateKey(privateKey));
        return cipher.doFinal(encryptedData);
    }
}
