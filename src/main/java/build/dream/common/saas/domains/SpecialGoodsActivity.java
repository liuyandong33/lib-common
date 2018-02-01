package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SpecialGoodsActivity extends BasicDomain {
    /**
     * 活动id
     */
    private BigInteger activityId;
    /**
     * 购买商品id
     */
    private BigInteger goodsId;
    /**
     * 购买商品规格id
     */
    private BigInteger goodsSpecificationId;
    /**
     * 优惠方式，1-特价，2-折扣
     */
    private Integer discountType;
    /**
     * 商户特价金额
     */
    private BigDecimal tenantSpecialPrice;
    /**
     * 代理商金额
     */
    private BigDecimal agentSpecialPrice;
    /**
     * 商户折扣率
     */
    private BigDecimal tenantDiscountRate;
    /**
     * 代理商折扣率
     */
    private BigDecimal agentDiscountRate;

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public BigInteger getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(BigInteger goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getTenantSpecialPrice() {
        return tenantSpecialPrice;
    }

    public void setTenantSpecialPrice(BigDecimal tenantSpecialPrice) {
        this.tenantSpecialPrice = tenantSpecialPrice;
    }

    public BigDecimal getAgentSpecialPrice() {
        return agentSpecialPrice;
    }

    public void setAgentSpecialPrice(BigDecimal agentSpecialPrice) {
        this.agentSpecialPrice = agentSpecialPrice;
    }

    public BigDecimal getTenantDiscountRate() {
        return tenantDiscountRate;
    }

    public void setTenantDiscountRate(BigDecimal tenantDiscountRate) {
        this.tenantDiscountRate = tenantDiscountRate;
    }

    public BigDecimal getAgentDiscountRate() {
        return agentDiscountRate;
    }

    public void setAgentDiscountRate(BigDecimal agentDiscountRate) {
        this.agentDiscountRate = agentDiscountRate;
    }
}
