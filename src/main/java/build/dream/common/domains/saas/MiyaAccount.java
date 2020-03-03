package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class MiyaAccount extends BasicDomain {
    public static final String TABLE_NAME = "miya_account";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 门店ID
     */
    private Long branchId;
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

    public static class Builder extends BasicDomain.Builder<Builder, MiyaAccount> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(Long branchId) {
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

        @Override
        public MiyaAccount build() {
            MiyaAccount miyaAccount = super.build();
            miyaAccount.setTenantId(instance.getTenantId());
            miyaAccount.setBranchId(instance.getBranchId());
            miyaAccount.setMiyaMerchantCode(instance.getMiyaMerchantCode());
            miyaAccount.setMiyaKey(instance.getMiyaKey());
            miyaAccount.setMiyaBranchCode(instance.getMiyaBranchCode());
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
