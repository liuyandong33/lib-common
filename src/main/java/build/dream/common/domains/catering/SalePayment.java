package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.util.Date;

@ShardingColumn(fieldName = SalePayment.FieldName.TENANT_ID, columnName = SalePayment.ColumnName.TENANT_ID)
public class SalePayment extends BasicDomain {
    public static final String TABLE_NAME = "sale_payment";
    /**
     * sale id
     */
    private Long saleId;
    /**
     * 销售时间
     */
    private Date saleTime;
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 支付方式id
     */
    private Long paymentId;
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
    private Double paidAmount;

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
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

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SalePayment> {
        public Builder saleId(Long saleId) {
            instance.setSaleId(saleId);
            return this;
        }

        public Builder saleTime(Date saleTime) {
            instance.setSaleTime(saleTime);
            return this;
        }

        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder paymentId(Long paymentId) {
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

        public Builder paidAmount(Double paidAmount) {
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
