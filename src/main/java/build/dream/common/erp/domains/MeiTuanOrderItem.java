package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MeiTuanOrderItem extends BasicDomain {
    /**
     * mei_tuan_order id
     */
    private BigInteger meiTuanOrderId;
    /**
     * erp方菜品id
     */
    private String appFoodCode;
    /**
     * 餐盒数量
     */
    private Integer boxNum;
    /**
     * 餐盒价格
     */
    private BigDecimal boxPrice;
    /**
     * 菜品名称
     */
    private String foodName;
    /**
     * 菜品价格
     */
    private BigDecimal price;
    /**
     * erp方菜品sku
     */
    private String skuId;
    /**
     * 菜品份数
     */
    private Integer quantity;
    /**
     * 菜品单位
     */
    private String unit;
    /**
     * 菜品折扣
     */
    private BigDecimal foodDiscount;
    /**
     * 菜品属性
     */
    private String foodProperty;
    /**
     * 该订单中商家给美团的分成金额
     */
    private BigDecimal foodShareFeeChargeByPoi;
    /**
     * 商品所在的口袋，0为1号口袋，1为2号口袋，以此类推
     */
    private Integer cartId;

    public BigInteger getMeiTuanOrderId() {
        return meiTuanOrderId;
    }

    public void setMeiTuanOrderId(BigInteger meiTuanOrderId) {
        this.meiTuanOrderId = meiTuanOrderId;
    }

    public String getAppFoodCode() {
        return appFoodCode;
    }

    public void setAppFoodCode(String appFoodCode) {
        this.appFoodCode = appFoodCode;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public BigDecimal getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(BigDecimal boxPrice) {
        this.boxPrice = boxPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getFoodDiscount() {
        return foodDiscount;
    }

    public void setFoodDiscount(BigDecimal foodDiscount) {
        this.foodDiscount = foodDiscount;
    }

    public String getFoodProperty() {
        return foodProperty;
    }

    public void setFoodProperty(String foodProperty) {
        this.foodProperty = foodProperty;
    }

    public BigDecimal getFoodShareFeeChargeByPoi() {
        return foodShareFeeChargeByPoi;
    }

    public void setFoodShareFeeChargeByPoi(BigDecimal foodShareFeeChargeByPoi) {
        this.foodShareFeeChargeByPoi = foodShareFeeChargeByPoi;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
}
