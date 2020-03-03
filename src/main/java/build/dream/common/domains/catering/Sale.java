package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class Sale extends BasicDomain {
    public static final String TABLE_NAME = "sale";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 销售编号
     */
    private String saleCode;
    /**
     * 销售时间
     */
    private Date saleTime;
    /**
     * 总金额
     */
    private Double totalAmount;
    /**
     * 优惠金额
     */
    private Double discountAmount;
    /**
     * 应付金额
     */
    private Double payableAmount;
    /**
     * 实付金额
     */
    private Double paidAmount;

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

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Sale> {
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

        public Builder saleCode(String saleCode) {
            instance.setSaleCode(saleCode);
            return this;
        }

        public Builder saleTime(Date saleTime) {
            instance.setSaleTime(saleTime);
            return this;
        }

        public Builder totalAmount(Double totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountAmount(Double discountAmount) {
            instance.setDiscountAmount(discountAmount);
            return this;
        }

        public Builder payableAmount(Double payableAmount) {
            instance.setPayableAmount(payableAmount);
            return this;
        }

        public Builder paidAmount(Double paidAmount) {
            instance.setPaidAmount(paidAmount);
            return this;
        }

        @Override
        public Sale build() {
            Sale sale = super.build();
            sale.setTenantId(instance.getTenantId());
            sale.setTenantCode(instance.getTenantCode());
            sale.setBranchId(instance.getBranchId());
            sale.setSaleCode(instance.getSaleCode());
            sale.setSaleTime(instance.getSaleTime());
            sale.setTotalAmount(instance.getTotalAmount());
            sale.setDiscountAmount(instance.getDiscountAmount());
            sale.setPayableAmount(instance.getPayableAmount());
            sale.setPaidAmount(instance.getPaidAmount());
            return sale;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String SALE_CODE = "sale_code";
        public static final String SALE_TIME = "sale_time";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String DISCOUNT_AMOUNT = "discount_amount";
        public static final String PAYABLE_AMOUNT = "payable_amount";
        public static final String PAID_AMOUNT = "paid_amount";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String SALE_CODE = "saleCode";
        public static final String SALE_TIME = "saleTime";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String DISCOUNT_AMOUNT = "discountAmount";
        public static final String PAYABLE_AMOUNT = "payableAmount";
        public static final String PAID_AMOUNT = "paidAmount";
    }
}
