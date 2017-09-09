package build.dream.common.erp.domains;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ElemeItem {
    private BigInteger id;
    /**
     * 饿了么分组ID
     */
    private BigInteger elemeGroupId;
    /**
     * 饿了么菜品ID
     */
    private BigInteger elemeItemId;
    /**
     * 饿了么菜品规格ID
     */
    private BigInteger skuId;
    /**
     * 订单中商品项的标识(注意，此处不是商品分类Id)
     */
    private BigInteger categoryId;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 数量
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
    private Date createTime;
    private BigInteger createUserId;
    private Date lastUpdateTime;
    private BigInteger lastUpdateUserId;
    private String lastUpdateRemark;
    private boolean deleted;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigInteger getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(BigInteger createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public BigInteger getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(BigInteger lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateRemark() {
        return lastUpdateRemark;
    }

    public void setLastUpdateRemark(String lastUpdateRemark) {
        this.lastUpdateRemark = lastUpdateRemark;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
