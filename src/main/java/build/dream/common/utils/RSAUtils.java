package build.dream.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     *
     * @param publicKey：公钥字符串
     * @return
     */
    public static PublicKey restorePublicKey(String publicKey) {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        return restorePublicKey(keyBytes);
    }

    /**
     * 还原公钥
     *
     * @param keyBytes：公钥字节数组
     * @return
     */
    public static PublicKey restorePublicKey(byte[] keyBytes) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            return keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 还原私钥
     *
     * @param privateKey：私钥字符串
     * @return
     */
    public static PrivateKey restorePrivateKey(String privateKey) {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        return restorePrivateKey(keyBytes);
    }

    /**
     * 还原私钥
     *
     * @param keyBytes：私钥字节数组
     * @return
     */
    public static PrivateKey restorePrivateKey(byte[] keyBytes) {
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 公钥加密
     *
     * @param data：要加密的数据
     * @param publicKey：公钥
     * @param paddingMode：填充模式
     * @return
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey, String paddingMode) {
        return encryptByPublicKey(data, restorePublicKey(publicKey), paddingMode);
    }

    /**
     * 公钥加密
     *
     * @param data：要加密的数据
     * @param publicKey：公钥
     * @param paddingMode：填充模式
     * @return
     */
    public static byte[] encryptByPublicKey(byte[] data, PublicKey publicKey, String paddingMode) {
        try {
            Cipher cipher = Cipher.getInstance(paddingMode);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
            List<byte[]> splits = splitData(data, rsaPublicKey.getModulus().bitLength() / 8 - 11);

            byte[] encryptedData = new byte[0];
            for (byte[] split : splits) {
                encryptedData = ArrayUtils.addAll(encryptedData, cipher.doFinal(split));
            }
            return encryptedData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 私钥解密
     *
     * @param data：要加密的数据
     * @param privateKey：私钥
     * @param paddingMode：填充模式
     * @return
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey, String paddingMode) {
        return encryptByPrivateKey(data, restorePrivateKey(privateKey), paddingMode);
    }

    /**
     * 私钥加密
     *
     * @param data：要加密的数据
     * @param privateKey：私钥
     * @param paddingMode：填充模式
     * @return
     */
    public static byte[] encryptByPrivateKey(byte[] data, PrivateKey privateKey, String paddingMode) {
        try {
            Cipher cipher = Cipher.getInstance(paddingMode);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) privateKey;
            List<byte[]> splits = splitData(data, rsaPrivateKey.getModulus().bitLength() / 8 - 11);
            byte[] encryptedData = new byte[0];
            for (byte[] split : splits) {
                encryptedData = ArrayUtils.addAll(encryptedData, cipher.doFinal(split));
            }
            return encryptedData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 公钥解密
     *
     * @param encryptedData：已加密的数据
     * @param publicKey：公钥
     * @param paddingMode：填充模式
     * @return
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, byte[] publicKey, String paddingMode) {
        return decryptByPublicKey(encryptedData, restorePublicKey(publicKey), paddingMode);
    }

    /**
     * 公钥解密
     *
     * @param encryptedData：已加密的数据
     * @param publicKey：公钥
     * @param paddingMode：填充模式
     * @return
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, PublicKey publicKey, String paddingMode) {
        try {
            Cipher cipher = Cipher.getInstance(paddingMode);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);

            RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
            List<byte[]> splits = splitData(encryptedData, rsaPublicKey.getModulus().bitLength() / 8);
            byte[] data = new byte[0];
            for (byte[] split : splits) {
                data = ArrayUtils.addAll(data, cipher.doFinal(split));
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 私钥解密
     *
     * @param encryptedData：已加密的数据
     * @param privateKey：私钥
     * @param paddingMode：填充模式
     * @return
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, byte[] privateKey, String paddingMode) {
        return decryptByPrivateKey(encryptedData, restorePrivateKey(privateKey), paddingMode);
    }

    /**
     * 私钥解密
     *
     * @param encryptedData：已加密的数据
     * @param privateKey：私钥
     * @param paddingMode：填充模式
     * @return
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, PrivateKey privateKey, String paddingMode) {
        try {
            Cipher cipher = Cipher.getInstance(paddingMode);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) privateKey;
            List<byte[]> splits = splitData(encryptedData, rsaPrivateKey.getModulus().bitLength() / 8);
            byte[] data = new byte[0];
            for (byte[] split : splits) {
                data = ArrayUtils.addAll(data, cipher.doFinal(split));
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<byte[]> splitData(byte[] data, int length) {
        List<byte[]> splits = new ArrayList<byte[]>();
        int count = data.length / length;
        for (int index = 0; index < count; index++) {
            splits.add(ArrayUtils.subarray(data, index * length, (index + 1) * length));
        }
        if (data.length % length != 0) {
            splits.add(ArrayUtils.subarray(data, count * length, data.length + 1));
        }
        return splits;
    }
}
