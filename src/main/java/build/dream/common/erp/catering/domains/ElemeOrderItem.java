package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ElemeOrderItem extends BasicDomain {
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
     * eleme_order.id
     */
    private BigInteger elemeOrderId;
    /**
     * 饿了么系统订单ID
     */
    private String orderId;
    /**
     * 饿了么分组ID
     */
    private BigInteger elemeOrderGroupId;
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

    public BigInteger getElemeOrderId() {
        return elemeOrderId;
    }

    public void setElemeOrderId(BigInteger elemeOrderId) {
        this.elemeOrderId = elemeOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigInteger getElemeOrderGroupId() {
        return elemeOrderGroupId;
    }

    public void setElemeOrderGroupId(BigInteger elemeOrderGroupId) {
        this.elemeOrderGroupId = elemeOrderGroupId;
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

    public static class Builder {
        private final ElemeOrderItem instance = new ElemeOrderItem();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder elemeOrderId(BigInteger elemeOrderId) {
            instance.setElemeOrderId(elemeOrderId);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder elemeOrderGroupId(BigInteger elemeOrderGroupId) {
            instance.setElemeOrderGroupId(elemeOrderGroupId);
            return this;
        }

        public Builder elemeItemId(BigInteger elemeItemId) {
            instance.setElemeItemId(elemeItemId);
            return this;
        }

        public Builder skuId(BigInteger skuId) {
            instance.setSkuId(skuId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder categoryId(BigInteger categoryId) {
            instance.setCategoryId(categoryId);
            return this;
        }

        public Builder price(BigDecimal price) {
            instance.setPrice(price);
            return this;
        }

        public Builder quantity(Integer quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder total(BigDecimal total) {
            instance.setTotal(total);
            return this;
        }

        public Builder extendCode(String extendCode) {
            instance.setExtendCode(extendCode);
            return this;
        }

        public Builder barCode(String barCode) {
            instance.setBarCode(barCode);
            return this;
        }

        public Builder weight(BigDecimal weight) {
            instance.setWeight(weight);
            return this;
        }

        public Builder userPrice(BigDecimal userPrice) {
            instance.setUserPrice(userPrice);
            return this;
        }

        public Builder shopPrice(BigDecimal shopPrice) {
            instance.setShopPrice(shopPrice);
            return this;
        }

        public Builder vfoodId(BigInteger vfoodId) {
            instance.setVfoodId(vfoodId);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public ElemeOrderItem build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String ELEME_ORDER_ID = "eleme_order_id";
        public static final String ORDER_ID = "order_id";
        public static final String ELEME_ORDER_GROUP_ID = "eleme_order_group_id";
        public static final String ELEME_ITEM_ID = "eleme_item_id";
        public static final String SKU_ID = "sku_id";
        public static final String NAME = "name";
        public static final String CATEGORY_ID = "category_id";
        public static final String PRICE = "price";
        public static final String QUANTITY = "quantity";
        public static final String TOTAL = "total";
        public static final String EXTEND_CODE = "extend_code";
        public static final String BAR_CODE = "bar_code";
        public static final String WEIGHT = "weight";
        public static final String USER_PRICE = "user_price";
        public static final String SHOP_PRICE = "shop_price";
        public static final String VFOOD_ID = "vfood_id";
    }
}
