package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class PaymentActivity extends BasicDomain {
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
     * 支付方式，1-微信支付，2-支付宝支付，3-现金支付'
     */
    private Integer paidType;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 优惠方式，1-按金额优惠，2-按折扣率优惠
     */
    private Integer discountType = Constants.DEVICE_TYPE_ANDROID;
    /**
     * 折扣率
     */
    private BigDecimal discountRate = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;

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

    public Integer getPaidType() {
        return paidType;
    }

    public void setPaidType(Integer paidType) {
        this.paidType = paidType;
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

    public static class Builder {
        private final PaymentActivity instance = new PaymentActivity();

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

        public Builder paidType(Integer paidType) {
            instance.setPaidType(paidType);
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

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
