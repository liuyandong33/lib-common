package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class UnionPayAccount extends BasicDomain {
    public static final String TABLE_NAME = "wei_xin_pay_account";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;

    /**
     * 商户代码
     */
    private String merId;

    /**
     * 二级商户代码
     */
    private String subMerId;

    /**
     * 二级商户简称
     */
    private String subMerAbbr;

    /**
     * 二级商户名称
     */
    private String subMerName;

    /**
     * 加密证书ID
     */
    private String encryptCertId;

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

    public String getSubMerId() {
        return subMerId;
    }

    public void setSubMerId(String subMerId) {
        this.subMerId = subMerId;
    }

    public String getSubMerAbbr() {
        return subMerAbbr;
    }

    public void setSubMerAbbr(String subMerAbbr) {
        this.subMerAbbr = subMerAbbr;
    }

    public String getSubMerName() {
        return subMerName;
    }

    public void setSubMerName(String subMerName) {
        this.subMerName = subMerName;
    }

    public String getEncryptCertId() {
        return encryptCertId;
    }

    public void setEncryptCertId(String encryptCertId) {
        this.encryptCertId = encryptCertId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, UnionPayAccount> {
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

        public Builder subMerId(String subMerId) {
            instance.setSubMerId(subMerId);
            return this;
        }

        public Builder subMerAbbr(String subMerAbbr) {
            instance.setSubMerAbbr(subMerAbbr);
            return this;
        }

        public Builder subMerName(String subMerName) {
            instance.setSubMerName(subMerName);
            return this;
        }

        public Builder encryptCertId(String encryptCertId) {
            instance.setEncryptCertId(encryptCertId);
            return this;
        }

        @Override
        public UnionPayAccount build() {
            UnionPayAccount unionPayAccount = super.build();
            unionPayAccount.setTenantId(instance.getTenantId());
            unionPayAccount.setBranchId(instance.getBranchId());
            unionPayAccount.setMerId(instance.getMerId());
            unionPayAccount.setSubMerId(instance.getSubMerId());
            unionPayAccount.setSubMerAbbr(instance.getSubMerAbbr());
            unionPayAccount.setSubMerName(instance.getSubMerName());
            unionPayAccount.setEncryptCertId(instance.getEncryptCertId());
            return unionPayAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String MER_ID = "mer_id";
        public static final String SUB_MER_ID = "sub_mer_id";
        public static final String SUB_MER_ABBR = "sub_mer_abbr";
        public static final String SUB_MER_NAME = "sub_mer_name";
        public static final String ENCRYPT_CERT_ID = "encrypt_cert_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String MER_ID = "merId";
        public static final String SUB_MER_ID = "subMerId";
        public static final String SUB_MER_ABBR = "subMerAbbr";
        public static final String SUB_MER_NAME = "subMerName";
        public static final String ENCRYPT_CERT_ID = "encryptCertId";
    }
}
