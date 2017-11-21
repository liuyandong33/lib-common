package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ElemeOrderItem extends BasicDomain {
    /**
     * 饿了么分组ID
     */
    private BigInteger elemeGroupId;
    /**
     * 饿了么食物ID
     */
    private BigInteger elemeItemId;
    /**
     * 饿了么菜品规格ID
     */
    private BigInteger skuId;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 订单中商品项的标识(注意，此处不是商品分类Id)
     */
    private BigInteger categoryId;
    /**
     * 商品单价
     */
    private BigDecimal price;
    /**
     * 商品数量
     */
    private Integer quantity;
    /**
     * 总价
     */
    private BigDecimal total;
    /**
     * 商品扩展码
     */
    private String extendCode;
    /**
     * 商品条形码
     */
    private String barCode;
    /**
     * 商品重量(单位克)
     */
    private BigDecimal weight;
    /**
     * 用户侧价格
     */
    private BigDecimal userPrice;
    /**
     * 商户侧价格
     */
    private BigDecimal shopPrice;
    /**
     * 商品ID
     */
    private BigInteger vfoodId;

    public BigInteger getElemeGroupId() {
        return elemeGroupId;
    }

    public void setElemeGroupId(BigInteger elemeGroupId) {
        this.elemeGroupId = elemeGroupId;
    }

    public BigInteger getElemeItemId() {
        return elemeItemId;
    }

    public void setElemeItemId(BigInteger elemeItemId) {
        this.elemeItemId = elemeItemId;
    }

    public BigInteger getSkuId() {
        return skuId;
    }

    public void setSkuId(BigInteger skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getExtendCode() {
        return extendCode;
    }

    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(BigDecimal userPrice) {
        this.userPrice = userPrice;
    }

    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    public BigInteger getVfoodId() {
        return vfoodId;
    }

    public void setVfoodId(BigInteger vfoodId) {
        this.vfoodId = vfoodId;
    }
}
