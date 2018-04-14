package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class BuyGiveActivity extends BasicDomain {
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
     * 购买商品id
     */
    private BigInteger buyGoodsId;
    /**
     * 购买商品规格id
     */
    private BigInteger buyGoodsSpecificationId;
    /**
     * 购买数量
     */
    private Integer buyQuantity;
    /**
     * 赠送商品id
     */
    private BigInteger giveGoodsId;
    /**
     * 赠送商品规格id
     */
    private BigInteger giveGoodsSpecificationId;
    /**
     * 赠送数量
     */
    private Integer giveQuantity;

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

    public BigInteger getBuyGoodsId() {
        return buyGoodsId;
    }

    public void setBuyGoodsId(BigInteger buyGoodsId) {
        this.buyGoodsId = buyGoodsId;
    }

    public BigInteger getBuyGoodsSpecificationId() {
        return buyGoodsSpecificationId;
    }

    public void setBuyGoodsSpecificationId(BigInteger buyGoodsSpecificationId) {
        this.buyGoodsSpecificationId = buyGoodsSpecificationId;
    }

    public Integer getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(Integer buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public BigInteger getGiveGoodsId() {
        return giveGoodsId;
    }

    public void setGiveGoodsId(BigInteger giveGoodsId) {
        this.giveGoodsId = giveGoodsId;
    }

    public BigInteger getGiveGoodsSpecificationId() {
        return giveGoodsSpecificationId;
    }

    public void setGiveGoodsSpecificationId(BigInteger giveGoodsSpecificationId) {
        this.giveGoodsSpecificationId = giveGoodsSpecificationId;
    }

    public Integer getGiveQuantity() {
        return giveQuantity;
    }

    public void setGiveQuantity(Integer giveQuantity) {
        this.giveQuantity = giveQuantity;
    }
}
