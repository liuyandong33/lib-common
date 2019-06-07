package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = SalePayment.FieldName.TENANT_ID, columnName = SalePayment.ColumnName.TENANT_ID)
public class SalePayment extends BasicDomain {
    public static final String TABLE_NAME = "sale_payment";
    /**
     * sale id
     */
    private BigInteger saleId;
    /**
     * 销售时间
     */
    private Date saleTime;
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 支付方式id
     */
    private BigInteger paymentId;
    /**
     * 支付方式编码
     */
    private String paymentCode;
    /**
     * 支付方式名称
     */
    private String paymentName;
    /**
     * 支付金额
     */
    private BigDecimal paidAmount;

    public BigInteger getSaleId() {
        return saleId;
    }

    public void setSaleId(BigInteger saleId) {
        this.saleId = saleId;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public BigInteger getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(BigInteger paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SalePayment> {
        public Builder saleId(BigInteger saleId) {
            instance.setSaleId(saleId);
            return this;
        }

        public Builder saleTime(Date saleTime) {
            instance.setSaleTime(saleTime);
            return this;
        }

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder paymentId(BigInteger paymentId) {
            instance.setPaymentId(paymentId);
            return this;
        }

        public Builder paymentCode(String paymentCode) {
            instance.setPaymentCode(paymentCode);
            return this;
        }

        public Builder paymentName(String paymentName) {
            instance.setPaymentName(paymentName);
            return this;
        }

        public Builder paidAmount(BigDecimal paidAmount) {
            instance.setPaidAmount(paidAmount);
            return this;
        }

        @Override
        public SalePayment build() {
            SalePayment salePayment = super.build();
            salePayment.setSaleId(instance.getSaleId());
            salePayment.setSaleTime(instance.getSaleTime());
            salePayment.setTenantId(instance.getTenantId());
            salePayment.setTenantCode(instance.getTenantCode());
            salePayment.setBranchId(instance.getBranchId());
            salePayment.setPaymentId(instance.getPaymentId());
            salePayment.setPaymentCode(instance.getPaymentCode());
            salePayment.setPaymentName(instance.getPaymentName());
            salePayment.setPaidAmount(instance.getPaidAmount());
            return salePayment;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String SALE_ID = "sale_id";
        public static final String SALE_TIME = "sale_time";
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String PAYMENT_ID = "payment_id";
        public static final String PAYMENT_CODE = "payment_code";
        public static final String PAYMENT_NAME = "payment_name";
        public static final String PAID_AMOUNT = "paid_amount";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String SALE_ID = "saleId";
        public static final String SALE_TIME = "saleTime";
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String PAYMENT_ID = "paymentId";
        public static final String PAYMENT_CODE = "paymentCode";
        public static final String PAYMENT_NAME = "paymentName";
        public static final String PAID_AMOUNT = "paidAmount";
    }
}
