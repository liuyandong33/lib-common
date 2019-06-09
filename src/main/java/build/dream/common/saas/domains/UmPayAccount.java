package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class UmPayAccount extends BasicDomain {
    public static final String TABLE_NAME = "um_pay_account";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 联动支付ID
     */
    private String merId;
    /**
     * 联动支付私钥
     */
    private String privateKey;

    private String platformPublicKey;

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

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPlatformPublicKey() {
        return platformPublicKey;
    }

    public void setPlatformPublicKey(String platformPublicKey) {
        this.platformPublicKey = platformPublicKey;
    }

    public static class Builder extends BasicDomain.Builder<Builder, UmPayAccount> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder merId(String merId) {
            instance.setMerId(merId);
            return this;
        }

        public Builder privateKey(String privateKey) {
            instance.setPrivateKey(privateKey);
            return this;
        }

        public Builder platformPublicKey(String platformPublicKey) {
            instance.setPlatformPublicKey(platformPublicKey);
            return this;
        }

        @Override
        public UmPayAccount build() {
            UmPayAccount umPayAccount = super.build();
            umPayAccount.setTenantId(instance.getTenantId());
            umPayAccount.setBranchId(instance.getBranchId());
            umPayAccount.setMerId(instance.getMerId());
            umPayAccount.setPrivateKey(instance.getPrivateKey());
            umPayAccount.setPlatformPublicKey(instance.getPlatformPublicKey());
            return umPayAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String UM_PAY_ID = "um_pay_id";
        public static final String PRIVATE_KEY = "private_key";
        public static final String PLATFORM_PUBLIC_KEY = "platform_public_key";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String UM_PAY_ID = "umPayId";
        public static final String PRIVATE_KEY = "privateKey";
        public static final String PLATFORM_PUBLIC_KEY = "platformPublicKey";
    }
}
