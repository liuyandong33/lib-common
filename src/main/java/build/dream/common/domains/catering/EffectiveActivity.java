package build.dream.common.domains.catering;

import java.sql.Time;
import java.util.Date;

public class EffectiveActivity {
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;
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
    private Long goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品规格ID
     */
    private Long goodsSpecificationId;
    /**
     * 商品规格名称
     */
    private String goodsSpecificationName;
    /**
     * 单价
     */
    private Double price;
    /**
     * 购买数量，买赠活动专用
     */
    private Double buyQuantity;
    /**
     * 赠送商品ID，买赠活动专用
     */
    private Long giveGoodsId;
    /**
     * 赠送商品名称，买赠活动专用
     */
    private String giveGoodsName;
    /**
     * 赠送商品规格ID，买赠活动专用
     */
    private Long giveGoodsSpecificationId;
    /**
     * 正式商品规格名称，买赠活动专用
     */
    private String giveGoodsSpecificationName;
    /**
     * 赠送商品价格，买赠活动专用
     */
    private Double givePrice;
    /**
     * 赠送数量，买赠活动专用
     */
    private Double giveQuantity;
    /**
     * 商品分类ID，买A赠B活动与特价商品活动专用，买A赠B活动中赠品对应的分类的ID，特价商品活动中特价商品对应的分类ID
     */
    private Long categoryId;
    /**
     * 商品分类ID，买A赠B活动与特价商品活动专用，买A赠B活动中赠品对应的分类的名称，特价商品活动中特价商品对应的分类名称
     */
    private String categoryName;
    /**
     * 总金额，整单满减活动、支付促销专用
     */
    private Double totalAmount;
    /**
     * 优惠方式，1-特价，2-折扣，整单满减活动、特价商品活动、支付促销专用
     */
    private Integer discountType;
    /**
     * 折扣率，整单满减活动、特价商品活动、支付促销专用
     */
    private Double discountRate;
    /**
     * 优惠金额，整单满减活动、支付促销专用
     */
    private Double discountAmount;
    /**
     * 特价金额，特价商品活动专用
     */
    private Double specialPrice;
    /**
     * 支付方式，1-微信支付，2-支付宝支付，3-现金支付，支付促销专用
     */
    private Integer paidType;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(Long goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public String getGoodsSpecificationName() {
        return goodsSpecificationName;
    }

    public void setGoodsSpecificationName(String goodsSpecificationName) {
        this.goodsSpecificationName = goodsSpecificationName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(Double buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public Long getGiveGoodsId() {
        return giveGoodsId;
    }

    public void setGiveGoodsId(Long giveGoodsId) {
        this.giveGoodsId = giveGoodsId;
    }

    public String getGiveGoodsName() {
        return giveGoodsName;
    }

    public void setGiveGoodsName(String giveGoodsName) {
        this.giveGoodsName = giveGoodsName;
    }

    public Long getGiveGoodsSpecificationId() {
        return giveGoodsSpecificationId;
    }

    public void setGiveGoodsSpecificationId(Long giveGoodsSpecificationId) {
        this.giveGoodsSpecificationId = giveGoodsSpecificationId;
    }

    public String getGiveGoodsSpecificationName() {
        return giveGoodsSpecificationName;
    }

    public void setGiveGoodsSpecificationName(String giveGoodsSpecificationName) {
        this.giveGoodsSpecificationName = giveGoodsSpecificationName;
    }

    public Double getGivePrice() {
        return givePrice;
    }

    public void setGivePrice(Double givePrice) {
        this.givePrice = givePrice;
    }

    public Double getGiveQuantity() {
        return giveQuantity;
    }

    public void setGiveQuantity(Double giveQuantity) {
        this.giveQuantity = giveQuantity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Integer getPaidType() {
        return paidType;
    }

    public void setPaidType(Integer paidType) {
        this.paidType = paidType;
    }
}
