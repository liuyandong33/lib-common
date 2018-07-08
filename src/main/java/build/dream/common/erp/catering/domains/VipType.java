package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;

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
}
