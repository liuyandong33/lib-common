package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class VipType extends BasicDomain {
    public static final String TABLE_NAME = "vip_type";
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
     * 会员分组ID
     */
    private BigInteger vipGroupId;
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

    public BigInteger getVipGroupId() {
        return vipGroupId;
    }

    public void setVipGroupId(BigInteger vipGroupId) {
        this.vipGroupId = vipGroupId;
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

        public Builder vipGroupId(BigInteger vipGroupId) {
            instance.setVipGroupId(vipGroupId);
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

        public VipType build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String VIP_GROUP_ID = "vip_group_id";
        public static final String NAME = "name";
        public static final String DISCOUNT_POLICY = "discount_policy";
        public static final String DISCOUNT_RATE = "discount_rate";
        public static final String ENABLE_BONUS = "enable_bonus";
        public static final String BONUS_COEFFICIENT = "bonus_coefficient";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String VIP_GROUP_ID = "vipGroupId";
        public static final String NAME = "name";
        public static final String DISCOUNT_POLICY = "discountPolicy";
        public static final String DISCOUNT_RATE = "discountRate";
        public static final String ENABLE_BONUS = "enableBonus";
        public static final String BONUS_COEFFICIENT = "bonusCoefficient";
    }
}
