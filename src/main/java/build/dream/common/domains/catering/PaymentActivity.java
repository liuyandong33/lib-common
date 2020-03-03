package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

@ShardingColumn(fieldName = PaymentActivity.FieldName.TENANT_ID, columnName = PaymentActivity.ColumnName.TENANT_ID)
public class PaymentActivity extends BasicDomain {
    public static final String TABLE_NAME = "payment_activity";
    /**
     * 商户id
     */
    private Long tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 支付方式，1-微信支付，2-支付宝支付，3-现金支付'
     */
    private Integer paidType;
    /**
     * 总金额
     */
    private Double totalAmount;
    /**
     * 优惠方式，1-按金额优惠，2-按折扣率优惠
     */
    private Integer discountType = Constants.DEVICE_TYPE_ANDROID;
    /**
     * 折扣率
     */
    private Double discountRate = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 折扣金额
     */
    private Double discountAmount;

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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getPaidType() {
        return paidType;
    }

    public void setPaidType(Integer paidType) {
        this.paidType = paidType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public static class Builder extends BasicDomain.Builder<Builder, PaymentActivity> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder activityId(Long activityId) {
            instance.setActivityId(activityId);
            return this;
        }

        public Builder paidType(Integer paidType) {
            instance.setPaidType(paidType);
            return this;
        }

        public Builder totalAmount(Double totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountType(Integer discountType) {
            instance.setDiscountType(discountType);
            return this;
        }

        public Builder discountRate(Double discountRate) {
            instance.setDiscountRate(discountRate);
            return this;
        }

        public Builder discountAmount(Double discountAmount) {
            instance.setDiscountAmount(discountAmount);
            return this;
        }

        @Override
        public PaymentActivity build() {
            PaymentActivity paymentActivity = super.build();
            paymentActivity.setTenantId(instance.getTenantId());
            paymentActivity.setTenantCode(instance.getTenantCode());
            paymentActivity.setActivityId(instance.getActivityId());
            paymentActivity.setPaidType(instance.getPaidType());
            paymentActivity.setTotalAmount(instance.getTotalAmount());
            paymentActivity.setDiscountType(instance.getDiscountType());
            paymentActivity.setDiscountRate(instance.getDiscountRate());
            paymentActivity.setDiscountAmount(instance.getDiscountAmount());
            return paymentActivity;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String ACTIVITY_ID = "activity_id";
        public static final String PAID_TYPE = "paid_type";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String DISCOUNT_TYPE = "discount_type";
        public static final String DISCOUNT_RATE = "discount_rate";
        public static final String DISCOUNT_AMOUNT = "discount_amount";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String ACTIVITY_ID = "activityId";
        public static final String PAID_TYPE = "paidType";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String DISCOUNT_TYPE = "discountType";
        public static final String DISCOUNT_RATE = "discountRate";
        public static final String DISCOUNT_AMOUNT = "discountAmount";
    }
}
