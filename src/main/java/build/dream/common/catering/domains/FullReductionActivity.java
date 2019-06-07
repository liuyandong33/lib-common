package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;

@ShardingColumn(fieldName = FullReductionActivity.FieldName.TENANT_ID, columnName = FullReductionActivity.ColumnName.TENANT_ID)
public class FullReductionActivity extends BasicDomain {
    public static final String TABLE_NAME = "full_reduction_activity";
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 活动id
     */
    private BigInteger activityId;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 优惠方式，1-按金额优惠，2-按折扣率优惠
     */
    private Integer discountType;
    /**
     * 折扣率
     */
    private BigDecimal discountRate = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 折扣金额
     */
    private BigDecimal discountAmount = Constants.DECIMAL_DEFAULT_VALUE;

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

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public static class Builder extends BasicDomain.Builder<Builder, FullReductionActivity> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder activityId(BigInteger activityId) {
            instance.setActivityId(activityId);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountType(Integer discountType) {
            instance.setDiscountType(discountType);
            return this;
        }

        public Builder discountRate(BigDecimal discountRate) {
            instance.setDiscountRate(discountRate);
            return this;
        }

        public Builder discountAmount(BigDecimal discountAmount) {
            instance.setDiscountAmount(discountAmount);
            return this;
        }

        @Override
        public FullReductionActivity build() {
            FullReductionActivity fullReductionActivity = super.build();
            fullReductionActivity.setTenantId(instance.getTenantId());
            fullReductionActivity.setTenantCode(instance.getTenantCode());
            fullReductionActivity.setActivityId(instance.getActivityId());
            fullReductionActivity.setTotalAmount(instance.getTotalAmount());
            fullReductionActivity.setDiscountType(instance.getDiscountType());
            fullReductionActivity.setDiscountRate(instance.getDiscountRate());
            fullReductionActivity.setDiscountAmount(instance.getDiscountAmount());
            return fullReductionActivity;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String ACTIVITY_ID = "activity_id";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String DISCOUNT_TYPE = "discount_type";
        public static final String DISCOUNT_RATE = "discount_rate";
        public static final String DISCOUNT_AMOUNT = "discount_amount";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String ACTIVITY_ID = "activityId";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String DISCOUNT_TYPE = "discountType";
        public static final String DISCOUNT_RATE = "discountRate";
        public static final String DISCOUNT_AMOUNT = "discountAmount";
    }
}
