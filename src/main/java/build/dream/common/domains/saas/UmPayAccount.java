package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class UmPayAccount extends BasicDomain {
    public static final String TABLE_NAME = "um_pay_account";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 联动支付ID
     */
    private String merId;
    /**
     * 联动支付私钥
     */
    private String privateKey;

    private String platformCertificate;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
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

    public String getPlatformCertificate() {
        return platformCertificate;
    }

    public void setPlatformCertificate(String platformCertificate) {
        this.platformCertificate = platformCertificate;
    }

    public static class Builder extends BasicDomain.Builder<Builder, UmPayAccount> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(Long branchId) {
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

        public Builder platformCertificate(String platformCertificate) {
            instance.setPlatformCertificate(platformCertificate);
            return this;
        }

        @Override
        public UmPayAccount build() {
            UmPayAccount umPayAccount = super.build();
            umPayAccount.setTenantId(instance.getTenantId());
            umPayAccount.setBranchId(instance.getBranchId());
            umPayAccount.setMerId(instance.getMerId());
            umPayAccount.setPrivateKey(instance.getPrivateKey());
            umPayAccount.setPlatformCertificate(instance.getPlatformCertificate());
            return umPayAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String MER_ID = "mer_id";
        public static final String PRIVATE_KEY = "private_key";
        public static final String PLATFORM_CERTIFICATE = "platform_certificate";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String MER_ID = "merId";
        public static final String PRIVATE_KEY = "privateKey";
        public static final String PLATFORM_CERTIFICATE = "platformCertificate";
    }
}
