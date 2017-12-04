package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;

public class SignatureUtils {
    public static final String SIGNATURE_ALGORITHM_SHA256_WITH_RSA = "SHA256withRSA";
    public static final String SIGNATURE_ALGORITHM_SHA1_WITH_RSA = "SHA1WithRSA";
    public static final String SIGNATURE_TYPE_SHA256_WITH_RSA = "SHA256withRSA";
    public static final String SIGNATURE_TYPE_SHA1_WITH_RSA = "SHA1WithRSA";
    public static final String OUTPUT_TYPE_BASE64 = "base64";
    public static final String OUTPUT_TYPE_HEX = "hex";

    /**
     * 获取签名器
     * @param signatureType：签名类型
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static Signature obtainSignature(String signatureType) throws NoSuchAlgorithmException {
        if (SIGNATURE_TYPE_SHA256_WITH_RSA.equals(signatureType)) {
            return Signature.getInstance(SIGNATURE_ALGORITHM_SHA256_WITH_RSA);
        } else if (SIGNATURE_TYPE_SHA1_WITH_RSA.equals(signatureType)) {
            return Signature.getInstance(SIGNATURE_ALGORITHM_SHA1_WITH_RSA);
        } else {
            throw new IllegalArgumentException("不支持的签名方式：" + signatureType);
        }
    }

    /**
     * 签名
     * @param data：数据
     * @param privateKey：私钥字符串
     * @return
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     */
    public static String sign(String data, String privateKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException, UnsupportedEncodingException {
        return sign(data, Constants.CHARSET_NAME_UTF_8, privateKey, SIGNATURE_ALGORITHM_SHA1_WITH_RSA, OUTPUT_TYPE_BASE64);
    }

    /**
     * 签名
     * @param data：数据
     * @param charsetName：字符集
     * @param privateKey：私钥字符串
     * @param signatureType：签名类型
     * @param outputType：输出类型
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static String sign(String data, String charsetName, String privateKey, String signatureType, String outputType) throws InvalidKeySpecException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, SignatureException {
        return sign(data, charsetName, RSAUtils.restorePrivateKey(privateKey), signatureType, outputType);
    }

    /**
     * 签名
     * @param data：数据
     * @param privateKey：私钥
     * @return
     * @throws SignatureException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     */
    public static String sign(String data, PrivateKey privateKey) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        return sign(data,Constants.CHARSET_NAME_UTF_8, privateKey, SIGNATURE_ALGORITHM_SHA1_WITH_RSA, OUTPUT_TYPE_BASE64);
    }

    /**
     * 签名
     * @param data：数据
     * @param charsetName：字符集
     * @param privateKey：私钥
     * @param signatureType：签名类型
     * @param outputType：输出类型
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     * @throws SignatureException
     */
    public static String sign(String data, String charsetName, PrivateKey privateKey, String signatureType, String outputType) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException {
        Signature signature = obtainSignature(signatureType);
        signature.initSign(privateKey);
        signature.update(data.getBytes(charsetName));
        if (OUTPUT_TYPE_BASE64.equals(outputType)) {
            return Base64.encodeBase64String(signature.sign());
        } else if (OUTPUT_TYPE_HEX.equals(outputType)) {
            return Hex.encodeHexString(signature.sign());
        } else {
            throw new IllegalArgumentException("不支持的输出方式：" + outputType);
        }
    }

    /**
     * 验证签名
     * @param data：数据
     * @param publicKey：公钥字符串
     * @param sign：签名
     * @return
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static boolean verifySign(String data, String publicKey, String sign) throws NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException, DecoderException, UnsupportedEncodingException {
        return verifySign(data, Constants.CHARSET_NAME_UTF_8, publicKey, SIGNATURE_TYPE_SHA1_WITH_RSA, OUTPUT_TYPE_BASE64, sign);
    }

    /**
     * 验证签名
     * @param data：数据
     * @param charsetName：字符集
     * @param publicKey：公钥字符串
     * @param signatureType：签名类型
     * @param outputType：输出类型
     * @param sign：签名
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws DecoderException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    public static boolean verifySign(String data, String charsetName, String publicKey, String signatureType, String outputType, String sign) throws InvalidKeySpecException, NoSuchAlgorithmException, DecoderException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        return verifySign(data, charsetName, RSAUtils.restorePublicKey(publicKey), signatureType, outputType, sign);
    }

    /**
     * 验证签名
     * @param data：数据
     * @param publicKey：公钥
     * @param sign：签名
     * @return
     * @throws DecoderException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    public static boolean verifySign(String data, PublicKey publicKey, String sign) throws DecoderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        return verifySign(data, Constants.CHARSET_NAME_UTF_8, publicKey, SIGNATURE_TYPE_SHA1_WITH_RSA, OUTPUT_TYPE_BASE64, sign);
    }

    /**
     * 验证签名
     * @param data：数据
     * @param certificate：证书
     * @param sign：签名
     * @return
     * @throws NoSuchAlgorithmException
     * @throws DecoderException
     * @throws SignatureException
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     */
    public static boolean verifySign(String data, Certificate certificate, String sign) throws NoSuchAlgorithmException, DecoderException, SignatureException, InvalidKeyException, UnsupportedEncodingException {
        return verifySign(data, Constants.CHARSET_NAME_UTF_8, certificate, SIGNATURE_TYPE_SHA1_WITH_RSA, OUTPUT_TYPE_BASE64, sign);
    }

    /**
     * 验证签名
     * @param data：数据
     * @param charsetName：字符集
     * @param certificate：证书
     * @param signatureType：签名类型
     * @param outputType：输出类型
     * @param sign：签名
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     * @throws SignatureException
     * @throws DecoderException
     */
    public static boolean verifySign(String data, String charsetName, Certificate certificate, String signatureType, String outputType, String sign) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException, DecoderException {
        Signature signature = obtainSignature(signatureType);
        signature.initVerify(certificate);
        return verifySign(data, charsetName, outputType, sign, signature);
    }

    /**
     * 验证签名
     * @param data：数据
     * @param charsetName：字符集
     * @param publicKey：公钥
     * @param signatureType：签名类型
     * @param outputType：输出类型
     * @param sign：签名
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static boolean verifySign(String data, String charsetName, PublicKey publicKey, String signatureType, String outputType, String sign) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, DecoderException, UnsupportedEncodingException {
        Signature signature = obtainSignature(signatureType);
        signature.initVerify(publicKey);
        return verifySign(data, charsetName, outputType, sign, signature);
    }

    /**
     * 验证签名
     * @param data：数据
     * @param charsetName：字符集
     * @param outputType：输出类型
     * @param sign：签名
     * @param signature：签名器
     * @return
     * @throws UnsupportedEncodingException
     * @throws SignatureException
     * @throws DecoderException
     */
    public static boolean verifySign(String data, String charsetName, String outputType, String sign, Signature signature) throws UnsupportedEncodingException, SignatureException, DecoderException {
        signature.update(data.getBytes(charsetName));
        if (OUTPUT_TYPE_BASE64.equals(outputType)) {
            return signature.verify(Base64.decodeBase64(sign));
        } else if (OUTPUT_TYPE_HEX.equals(outputType)) {
            return signature.verify(Hex.decodeHex(sign.toCharArray()));
        } else {
            throw new IllegalArgumentException("不支持的输出方式：" + outputType);
        }
    }
}