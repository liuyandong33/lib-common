package build.dream.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class CertificateUtils {
    public static final String CERTIFICATE_TYPE_X_509 = "X.509";

    /**
     * 还原证书
     *
     * @param certificate
     * @return
     */
    public static Certificate restoreCertificate(String certificate, String type) {
        byte[] certificateBytes = Base64.decodeBase64(certificate);
        return restoreCertificate(certificateBytes, type);
    }

    /**
     * 还原证书
     *
     * @param certificateBytes
     * @return
     */
    public static Certificate restoreCertificate(byte[] certificateBytes, String type) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(certificateBytes);
            CertificateFactory certificateFactory = CertificateFactory.getInstance(type);
            return certificateFactory.generateCertificate(byteArrayInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
