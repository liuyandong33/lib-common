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
    private String umPayId;
    /**
     * 联动支付私钥
     */
    private String merchantPrivateKey;

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

    public String getUmPayId() {
        return umPayId;
    }

    public void setUmPayId(String umPayId) {
        this.umPayId = umPayId;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
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

        public Builder umPayId(String umPayId) {
            instance.setUmPayId(umPayId);
            return this;
        }

        public Builder merchantPrivateKey(String merchantPrivateKey) {
            instance.setMerchantPrivateKey(merchantPrivateKey);
            return this;
        }

        @Override
        public UmPayAccount build() {
            UmPayAccount umPayAccount = super.build();
            umPayAccount.setTenantId(instance.getTenantId());
            umPayAccount.setBranchId(instance.getBranchId());
            umPayAccount.setUmPayId(instance.getUmPayId());
            umPayAccount.setMerchantPrivateKey(instance.getMerchantPrivateKey());
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
        public static final String MERCHANT_PRIVATE_KEY = "merchant_private_key";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String UM_PAY_ID = "umPayId";
        public static final String MERCHANT_PRIVATE_KEY = "merchantPrivateKey";
    }
}
