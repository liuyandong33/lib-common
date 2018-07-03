package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;

public class AlipayAccount extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 支付宝账号
     */
    private String account;
    /**
     * APPID
     */
    private String appId;
    /**
     * PID
     */
    private String partnerId;
    /**
     * 支付宝门店ID
     */
    private String storeId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;
    /**
     * 应用公钥
     */
    private String applicationPublicKey;
    /**
     * 应用私钥
     */
    private String applicationPrivateKey;
    /**
     * 签名方式，只能为RSA或RSA2
     */
    private String signType;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getApplicationPublicKey() {
        return applicationPublicKey;
    }

    public void setApplicationPublicKey(String applicationPublicKey) {
        this.applicationPublicKey = applicationPublicKey;
    }

    public String getApplicationPrivateKey() {
        return applicationPrivateKey;
    }

    public void setApplicationPrivateKey(String applicationPrivateKey) {
        this.applicationPrivateKey = applicationPrivateKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
