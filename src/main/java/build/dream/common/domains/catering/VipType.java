package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

@ShardingColumn(fieldName = VipType.FieldName.TENANT_ID, columnName = VipType.ColumnName.TENANT_ID)
public class VipType extends BasicDomain {
    public static final String TABLE_NAME = "vip_type";
    /**
     * 商户id
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店id
     */
    private Long branchId;
    /**
     * 会员分组ID
     */
    private Long vipGroupId;
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
    private Double discountRate = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 是否启用积分
     */
    private boolean enableBonus;
    /**
     * 积分系数，即多少钱积1积分
     */
    private Integer bonusCoefficient;

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

    public Long getVipGroupId() {
        return vipGroupId;
    }

    public void setVipGroupId(Long vipGroupId) {
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

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
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

    public static class Builder extends BasicDomain.Builder<Builder, VipType> {
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

        public Builder vipGroupId(Long vipGroupId) {
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

        public Builder discountRate(Double discountRate) {
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

        @Override
        public VipType build() {
            VipType vipType = super.build();
            vipType.setTenantId(instance.getTenantId());
            vipType.setTenantCode(instance.getTenantCode());
            vipType.setBranchId(instance.getBranchId());
            vipType.setVipGroupId(instance.getVipGroupId());
            vipType.setName(instance.getName());
            vipType.setDiscountPolicy(instance.getDiscountPolicy());
            vipType.setDiscountRate(instance.getDiscountRate());
            vipType.setEnableBonus(instance.isEnableBonus());
            vipType.setBonusCoefficient(instance.getBonusCoefficient());
            return vipType;
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
