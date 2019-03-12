package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class AlipayAccount extends BasicDomain {
    public static final String TABLE_NAME = "alipay_account";
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

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

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

    public static class Builder {
        private final AlipayAccount instance = new AlipayAccount();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

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

        public Builder storeId(String storeId) {
            instance.setStoreId(storeId);
            return this;
        }

        public Builder alipayPublicKey(String alipayPublicKey) {
            instance.setAlipayPublicKey(alipayPublicKey);
            return this;
        }

        public Builder applicationPublicKey(String applicationPublicKey) {
            instance.setApplicationPublicKey(applicationPublicKey);
            return this;
        }

        public Builder applicationPrivateKey(String applicationPrivateKey) {
            instance.setApplicationPrivateKey(applicationPrivateKey);
            return this;
        }

        public Builder signType(String signType) {
            instance.setSignType(signType);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public AlipayAccount build() {
            AlipayAccount alipayAccount = new AlipayAccount();
            alipayAccount.setTenantId(instance.getTenantId());
            alipayAccount.setBranchId(instance.getBranchId());
            alipayAccount.setAccount(instance.getAccount());
            alipayAccount.setAppId(instance.getAppId());
            alipayAccount.setPartnerId(instance.getPartnerId());
            alipayAccount.setAlipayPublicKey(instance.getAlipayPublicKey());
            alipayAccount.setApplicationPublicKey(instance.getApplicationPublicKey());
            alipayAccount.setApplicationPrivateKey(instance.getApplicationPrivateKey());
            alipayAccount.setSignType(instance.getSignType());
            alipayAccount.setId(instance.getId());
            alipayAccount.setCreatedTime(instance.getCreatedTime());
            alipayAccount.setCreatedUserId(instance.getCreatedUserId());
            alipayAccount.setUpdatedTime(instance.getUpdatedTime());
            alipayAccount.setUpdatedUserId(instance.getUpdatedUserId());
            alipayAccount.setUpdatedRemark(instance.getUpdatedRemark());
            alipayAccount.setDeletedTime(instance.getDeletedTime());
            alipayAccount.setDeleted(instance.isDeleted());
            return alipayAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String ACCOUNT = "account";
        public static final String APP_ID = "app_id";
        public static final String PARTNER_ID = "partner_id";
        public static final String STORE_ID = "store_id";
        public static final String ALIPAY_PUBLIC_KEY = "alipay_public_key";
        public static final String APPLICATION_PUBLIC_KEY = "application_public_key";
        public static final String APPLICATION_PRIVATE_KEY = "application_private_key";
        public static final String SIGN_TYPE = "sign_type";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String ACCOUNT = "account";
        public static final String APP_ID = "appId";
        public static final String PARTNER_ID = "partnerId";
        public static final String STORE_ID = "storeId";
        public static final String ALIPAY_PUBLIC_KEY = "alipayPublicKey";
        public static final String APPLICATION_PUBLIC_KEY = "applicationPublicKey";
        public static final String APPLICATION_PRIVATE_KEY = "applicationPrivateKey";
        public static final String SIGN_TYPE = "signType";
    }
}
