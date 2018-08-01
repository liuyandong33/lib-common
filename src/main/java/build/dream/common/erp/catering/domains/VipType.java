package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class VipType extends BasicDomain {
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店id
     */
    private BigInteger branchId;
    /**
     * '会员类型名称'
     */
    private String name;
    /**
     * 优惠政策，1-无优惠，2-会员价，3-固定折扣
     */
    private Integer discountPolicy;
    /**
     * 折扣率
     */
    private BigDecimal discountRate = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 是否启用积分
     */
    private boolean enableBonus;
    /**
     * 积分系数，即多少钱积1积分
     */
    private Integer bonusCoefficient;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscountPolicy() {
        return discountPolicy;
    }

    public void setDiscountPolicy(Integer discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public boolean isEnableBonus() {
        return enableBonus;
    }

    public void setEnableBonus(boolean enableBonus) {
        this.enableBonus = enableBonus;
    }

    public Integer getBonusCoefficient() {
        return bonusCoefficient;
    }

    public void setBonusCoefficient(Integer bonusCoefficient) {
        this.bonusCoefficient = bonusCoefficient;
    }

    public static class Builder {
        private final VipType instance = new VipType();

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

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder discountPolicy(Integer discountPolicy) {
            instance.setDiscountPolicy(discountPolicy);
            return this;
        }

        public Builder discountRate(BigDecimal discountRate) {
            instance.setDiscountRate(discountRate);
            return this;
        }

        public Builder enableBonus(boolean enableBonus) {
            instance.setEnableBonus(enableBonus);
            return this;
        }

        public Builder bonusCoefficient(Integer bonusCoefficient) {
            instance.setBonusCoefficient(bonusCoefficient);
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

        public VipType build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
