package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class AlipayDeveloperAccount extends BasicDomain {
    public static final String TABLE_NAME = "alipay_developer_account";
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
     * 支付宝公钥
     */
    private String alipayPublicKey;
    /**
     * 应用公钥
     */
    private String appPublicKey;
    /**
     * 应用私钥
     */
    private String appPrivateKey;
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

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getAppPublicKey() {
        return appPublicKey;
    }

    public void setAppPublicKey(String appPublicKey) {
        this.appPublicKey = appPublicKey;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public static class Builder extends BasicDomain.Builder<Builder, AlipayDeveloperAccount> {
        public Builder account(String account) {
            instance.setAccount(account);
            return this;
        }

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder partnerId(String partnerId) {
            instance.setPartnerId(partnerId);
            return this;
        }

        public Builder alipayPublicKey(String alipayPublicKey) {
            instance.setAlipayPublicKey(alipayPublicKey);
            return this;
        }

        public Builder appPublicKey(String appPublicKey) {
            instance.setAppPublicKey(appPublicKey);
            return this;
        }

        public Builder appPrivateKey(String appPrivateKey) {
            instance.setAppPrivateKey(appPrivateKey);
            return this;
        }

        public Builder signType(String signType) {
            instance.setSignType(signType);
            return this;
        }

        @Override
        public AlipayDeveloperAccount build() {
            AlipayDeveloperAccount alipayDeveloperAccount = super.build();
            alipayDeveloperAccount.setAccount(instance.getAccount());
            alipayDeveloperAccount.setAppId(instance.getAppId());
            alipayDeveloperAccount.setPartnerId(instance.getPartnerId());
            alipayDeveloperAccount.setAlipayPublicKey(instance.getAlipayPublicKey());
            alipayDeveloperAccount.setAppPublicKey(instance.getAppPublicKey());
            alipayDeveloperAccount.setAppPrivateKey(instance.getAppPrivateKey());
            alipayDeveloperAccount.setSignType(instance.getSignType());
            return alipayDeveloperAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String ACCOUNT = "account";
        public static final String APP_ID = "app_id";
        public static final String PARTNER_ID = "partner_id";
        public static final String ALIPAY_PUBLIC_KEY = "alipay_public_key";
        public static final String APPLICATION_PUBLIC_KEY = "application_public_key";
        public static final String APPLICATION_PRIVATE_KEY = "application_private_key";
        public static final String SIGN_TYPE = "sign_type";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String ACCOUNT = "account";
        public static final String APP_ID = "appId";
        public static final String PARTNER_ID = "partnerId";
        public static final String ALIPAY_PUBLIC_KEY = "alipayPublicKey";
        public static final String APPLICATION_PUBLIC_KEY = "applicationPublicKey";
        public static final String APPLICATION_PRIVATE_KEY = "applicationPrivateKey";
        public static final String SIGN_TYPE = "signType";
    }
}
