package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SpecialGoodsActivity extends BasicDomain {
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店id
     */
    private BigInteger branchId;
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
     * 特价金额
     */
    private BigDecimal specialPrice;
    /**
     * 折扣率
     */
    private BigDecimal discountRate;

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

    public BigDecimal getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(BigDecimal specialPrice) {
        this.specialPrice = specialPrice;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }
}
