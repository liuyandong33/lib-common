package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class BankAccount extends BasicDomain {
    public static final String TABLE_NAME = "bank_account";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 银行卡卡号
     */
    private String bankCardNumber;
    /**
     * 持卡人
     */
    private String cardholder;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 开户行编号
     */
    private String bankCode;

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

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public static class Builder extends BasicDomain.Builder<Builder, BankAccount> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder bankCardNumber(String bankCardNumber) {
            instance.setBankCardNumber(bankCardNumber);
            return this;
        }

        public Builder cardholder(String cardholder) {
            instance.setCardholder(cardholder);
            return this;
        }

        public Builder bankName(String bankName) {
            instance.setBankName(bankName);
            return this;
        }

        public Builder bankCode(String bankCode) {
            instance.setBankCode(bankCode);
            return this;
        }

        @Override
        public BankAccount build() {
            BankAccount bankAccount = super.build();
            bankAccount.setTenantId(instance.getTenantId());
            bankAccount.setBranchId(instance.getBranchId());
            bankAccount.setBankCardNumber(instance.getBankCardNumber());
            bankAccount.setCardholder(instance.getCardholder());
            bankAccount.setBankName(instance.getBankName());
            bankAccount.setBankCode(instance.getBankCode());
            return bankAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String BANK_CARD_NUMBER = "bank_card_number";
        public static final String CARDHOLDER = "cardholder";
        public static final String BANK_NAME = "bank_name";
        public static final String BANK_CODE = "bank_code";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String BANK_CARD_NUMBER = "bankCardNumber";
        public static final String CARDHOLDER = "cardholder";
        public static final String BANK_NAME = "bankName";
        public static final String BANK_CODE = "bankCode";
    }
}
