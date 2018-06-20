package build.dream.common.erp.catering.domains;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;

public class EffectiveActivity {
    /**
     * 活动ID
     */
    private BigInteger activityId;
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 开始时间
     */
    private Time startTime;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 结束时间
     */
    private Time endTime;
    /**
     * 活动类型，1-买A赠B活动，2-整单满减活动，3-特价商品活动，4-支付促销
     */
    private Integer type;
    /**
     * 活动状态，1-未执行，2-执行中，3-已终止，4-已过期
     */
    private Integer status;
    /**
     * 商品ID
     */
    private BigInteger goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品规格ID
     */
    private BigInteger goodsSpecificationId;
    /**
     * 商品规格名称
     */
    private String goodsSpecificationName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 购买数量，买赠活动专用
     */
    private BigDecimal buyQuantity;
    /**
     * 赠送商品ID，买赠活动专用
     */
    private BigInteger giveGoodsId;
    /**
     * 赠送商品名称，买赠活动专用
     */
    private String giveGoodsName;
    /**
     * 赠送商品规格ID，买赠活动专用
     */
    private BigInteger giveGoodsSpecificationId;
    /**
     * 正式商品规格名称，买赠活动专用
     */
    private String giveGoodsSpecificationName;
    /**
     * 赠送商品价格，买赠活动专用
     */
    private BigDecimal givePrice;
    /**
     * 赠送数量，买赠活动专用
     */
    private BigDecimal giveQuantity;
    /**
     * 总金额，整单满减活动、支付促销专用
     */
    private BigDecimal totalAmount;
    /**
     * 优惠方式，1-特价，2-折扣，整单满减活动、特价商品活动、支付促销专用
     */
    private Integer discountType;
    /**
     * 折扣率，整单满减活动、特价商品活动、支付促销专用
     */
    private BigDecimal discountRate;
    /**
     * 优惠金额，整单满减活动、支付促销专用
     */
    private BigDecimal discountAmount;
    /**
     * 特价金额，特价商品活动专用
     */
    private BigDecimal specialPrice;
    /**
     * 支付方式，1-微信支付，2-支付宝支付，3-现金支付，支付促销专用
     */
    private Integer paidType;

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigInteger getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(BigInteger goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public String getGoodsSpecificationName() {
        return goodsSpecificationName;
    }

    public void setGoodsSpecificationName(String goodsSpecificationName) {
        this.goodsSpecificationName = goodsSpecificationName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(BigDecimal buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public BigInteger getGiveGoodsId() {
        return giveGoodsId;
    }

    public void setGiveGoodsId(BigInteger giveGoodsId) {
        this.giveGoodsId = giveGoodsId;
    }

    public String getGiveGoodsName() {
        return giveGoodsName;
    }

    public void setGiveGoodsName(String giveGoodsName) {
        this.giveGoodsName = giveGoodsName;
    }

    public BigInteger getGiveGoodsSpecificationId() {
        return giveGoodsSpecificationId;
    }

    public void setGiveGoodsSpecificationId(BigInteger giveGoodsSpecificationId) {
        this.giveGoodsSpecificationId = giveGoodsSpecificationId;
    }

    public String getGiveGoodsSpecificationName() {
        return giveGoodsSpecificationName;
    }

    public void setGiveGoodsSpecificationName(String giveGoodsSpecificationName) {
        this.giveGoodsSpecificationName = giveGoodsSpecificationName;
    }

    public BigDecimal getGivePrice() {
        return givePrice;
    }

    public void setGivePrice(BigDecimal givePrice) {
        this.givePrice = givePrice;
    }

    public BigDecimal getGiveQuantity() {
        return giveQuantity;
    }

    public void setGiveQuantity(BigDecimal giveQuantity) {
        this.giveQuantity = giveQuantity;
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

    public BigDecimal getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(BigDecimal specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Integer getPaidType() {
        return paidType;
    }

    public void setPaidType(Integer paidType) {
        this.paidType = paidType;
    }
}
