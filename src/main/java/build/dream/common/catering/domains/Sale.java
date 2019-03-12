package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Sale extends BasicDomain {
    public static final String TABLE_NAME = "sale";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
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
    private BigDecimal totalAmount;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 应付金额
     */
    private BigDecimal payableAmount;
    /**
     * 实付金额
     */
    private BigDecimal paidAmount;

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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public static class Builder {
        private final Sale instance = new Sale();

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

        public Builder saleCode(String saleCode) {
            instance.setSaleCode(saleCode);
            return this;
        }

        public Builder saleTime(Date saleTime) {
            instance.setSaleTime(saleTime);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountAmount(BigDecimal discountAmount) {
            instance.setDiscountAmount(discountAmount);
            return this;
        }

        public Builder payableAmount(BigDecimal payableAmount) {
            instance.setPayableAmount(payableAmount);
            return this;
        }

        public Builder paidAmount(BigDecimal paidAmount) {
            instance.setPaidAmount(paidAmount);
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

        public Sale build() {
            Sale sale = new Sale();
            sale.setTenantId(instance.getTenantId());
            sale.setTenantCode(instance.getTenantCode());
            sale.setBranchId(instance.getBranchId());
            sale.setSaleCode(instance.getSaleCode());
            sale.setSaleTime(instance.getSaleTime());
            sale.setTotalAmount(instance.getTotalAmount());
            sale.setDiscountAmount(instance.getDiscountAmount());
            sale.setPayableAmount(instance.getPayableAmount());
            sale.setPaidAmount(instance.getPaidAmount());
            sale.setId(instance.getId());
            sale.setCreatedTime(instance.getCreatedTime());
            sale.setCreatedUserId(instance.getCreatedUserId());
            sale.setUpdatedTime(instance.getUpdatedTime());
            sale.setUpdatedUserId(instance.getUpdatedUserId());
            sale.setUpdatedRemark(instance.getUpdatedRemark());
            sale.setDeletedTime(instance.getDeletedTime());
            sale.setDeleted(instance.isDeleted());
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
