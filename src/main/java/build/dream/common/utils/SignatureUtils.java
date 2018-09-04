package build.dream.common.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;

public class SignatureUtils {
    public static final String SIGNATURE_TYPE_SHA1_WITH_RSA = "SHA1WithRSA";
    public static final String SIGNATURE_TYPE_SHA256_WITH_RSA = "SHA256withRSA";

    /**
     * 获取签名器
     * @param signatureType：签名类型
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static Signature obtainSignature(String signatureType) throws NoSuchAlgorithmException {
        ValidateUtils.isTrue(SIGNATURE_TYPE_SHA1_WITH_RSA.equals(signatureType) || SIGNATURE_TYPE_SHA256_WITH_RSA.equals(signatureType), "不支持的签名方式：" + signatureType + "！");
        return Signature.getInstance(signatureType);
    }

    /**
     * 签名
     * @param data：代签名数据
     * @param privateKey：私钥
     * @param signatureType：签名方式
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static byte[] sign(byte[] data, byte[] privateKey, String signatureType) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        Signature signature = obtainSignature(signatureType);
        signature.initSign(RSAUtils.restorePrivateKey(privateKey));
        signature.update(data);
        return signature.sign();
    }

    /**
     * 验证签名
     * @param data：原始数据
     * @param certificate：整数
     * @param sign：签名
     * @param signatureType：签名类型
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static boolean verifySign(byte[] data, Certificate certificate, byte[] sign, String signatureType) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = obtainSignature(signatureType);
        signature.initVerify(certificate);
        signature.update(data);
        return signature.verify(sign);
    }

    /**
     * 验证签名
     * @param data：原始数据
     * @param publicKey：公钥
     * @param sign：签名
     * @param signatureType：签名方式
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static boolean verifySign(byte[] data, byte[] publicKey, byte[] sign, String signatureType) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        Signature signature = obtainSignature(signatureType);
        signature.initVerify(RSAUtils.restorePublicKey(publicKey));
        signature.update(data);
        return signature.verify(sign);
    }
}