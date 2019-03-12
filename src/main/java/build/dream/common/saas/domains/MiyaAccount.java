package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class MiyaAccount extends BasicDomain {
    public static final String TABLE_NAME = "miya_account";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 米雅商户编号
     */
    private String miyaMerchantCode;
    /**
     * 米雅秘钥
     */
    private String miyaKey;
    /**
     * 米雅门店编号
     */
    private String miyaBranchCode;

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

    public String getMiyaMerchantCode() {
        return miyaMerchantCode;
    }

    public void setMiyaMerchantCode(String miyaMerchantCode) {
        this.miyaMerchantCode = miyaMerchantCode;
    }

    public String getMiyaKey() {
        return miyaKey;
    }

    public void setMiyaKey(String miyaKey) {
        this.miyaKey = miyaKey;
    }

    public String getMiyaBranchCode() {
        return miyaBranchCode;
    }

    public void setMiyaBranchCode(String miyaBranchCode) {
        this.miyaBranchCode = miyaBranchCode;
    }

    public static class Builder {
        private final MiyaAccount instance = new MiyaAccount();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder miyaMerchantCode(String miyaMerchantCode) {
            instance.setMiyaMerchantCode(miyaMerchantCode);
            return this;
        }

        public Builder miyaKey(String miyaKey) {
            instance.setMiyaKey(miyaKey);
            return this;
        }

        public Builder miyaBranchCode(String miyaBranchCode) {
            instance.setMiyaBranchCode(miyaBranchCode);
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

        public MiyaAccount build() {
            MiyaAccount miyaAccount = new MiyaAccount();
            miyaAccount.setTenantId(instance.getTenantId());
            miyaAccount.setBranchId(instance.getBranchId());
            miyaAccount.setMiyaMerchantCode(instance.getMiyaMerchantCode());
            miyaAccount.setMiyaKey(instance.getMiyaKey());
            miyaAccount.setMiyaBranchCode(instance.getMiyaBranchCode());
            miyaAccount.setId(instance.getId());
            miyaAccount.setCreatedTime(instance.getCreatedTime());
            miyaAccount.setCreatedUserId(instance.getCreatedUserId());
            miyaAccount.setUpdatedTime(instance.getUpdatedTime());
            miyaAccount.setUpdatedUserId(instance.getUpdatedUserId());
            miyaAccount.setUpdatedRemark(instance.getUpdatedRemark());
            miyaAccount.setDeletedTime(instance.getDeletedTime());
            miyaAccount.setDeleted(instance.isDeleted());
            return miyaAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String MIYA_MERCHANT_CODE = "miya_merchant_code";
        public static final String MIYA_KEY = "miya_key";
        public static final String MIYA_BRANCH_CODE = "miya_branch_code";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String MIYA_MERCHANT_CODE = "miyaMerchantCode";
        public static final String MIYA_KEY = "miyaKey";
        public static final String MIYA_BRANCH_CODE = "miyaBranchCode";
    }
}
