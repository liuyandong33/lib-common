package build.dream.common.catering.domains;

import build.dream.common.annotations.Transient;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class DietOrderDetail extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * diet_order.id
     */
    private BigInteger dietOrderId;
    /**
     * 餐厅订单ID，diet_order_group.id
     */
    private BigInteger dietOrderGroupId;
    /**
     * 商品类型，1-普通商品，2-套餐，3-套餐明细
     */
    private Integer goodsType;
    /**
     * 产品ID，goods.id
     */
    private BigInteger goodsId;
    /**
     * 产品名称，goods.name
     */
    private String goodsName;
    /**
     * 商品规格ID，goodsSpecification.id
     */
    private BigInteger goodsSpecificationId;
    /**
     * 商品规格名称，goodsSpecification.name
     */
    private String goodsSpecificationName;
    /**
     * 套餐ID
     */
    private BigInteger packageId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 套餐组ID
     */
    private BigInteger packageGroupId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 套餐组名称
     */
    private String packageGroupName = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 商品分类id
     */
    private BigInteger categoryId;
    /**
     * 商品分类名称
     */
    private String categoryName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 口味加价
     */
    private BigDecimal attributeIncrease = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 总数量
     */
    private BigDecimal quantity;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 应付金额
     */
    private BigDecimal payableAmount;
    /**
     * 本地ID
     */
    private String localId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 本地订单ID
     */
    private String localDietOrderId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 本地订单组ID
     */
    private String localDietOrderGroupId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 本地创建时间
     */
    private Date localCreatedTime = Constants.DATETIME_DEFAULT_VALUE;
    /**
     * 本地最后更新时间
     */
    private Date localUpdatedTime = Constants.DATETIME_DEFAULT_VALUE;

    /**
     * 优惠分摊金额，不映射数据库字段，方便计算整单优惠分摊
     */
    @Transient
    private BigDecimal discountShare;

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

    public BigInteger getDietOrderId() {
        return dietOrderId;
    }

    public void setDietOrderId(BigInteger dietOrderId) {
        this.dietOrderId = dietOrderId;
    }

    public BigInteger getDietOrderGroupId() {
        return dietOrderGroupId;
    }

    public void setDietOrderGroupId(BigInteger dietOrderGroupId) {
        this.dietOrderGroupId = dietOrderGroupId;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
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

    public BigInteger getPackageId() {
        return packageId;
    }

    public void setPackageId(BigInteger packageId) {
        this.packageId = packageId;
    }

    public BigInteger getPackageGroupId() {
        return packageGroupId;
    }

    public void setPackageGroupId(BigInteger packageGroupId) {
        this.packageGroupId = packageGroupId;
    }

    public String getPackageGroupName() {
        return packageGroupName;
    }

    public void setPackageGroupName(String packageGroupName) {
        this.packageGroupName = packageGroupName;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAttributeIncrease() {
        return attributeIncrease;
    }

    public void setAttributeIncrease(BigDecimal attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getLocalDietOrderId() {
        return localDietOrderId;
    }

    public void setLocalDietOrderId(String localDietOrderId) {
        this.localDietOrderId = localDietOrderId;
    }

    public String getLocalDietOrderGroupId() {
        return localDietOrderGroupId;
    }

    public void setLocalDietOrderGroupId(String localDietOrderGroupId) {
        this.localDietOrderGroupId = localDietOrderGroupId;
    }

    public Date getLocalCreatedTime() {
        return localCreatedTime;
    }

    public void setLocalCreatedTime(Date localCreatedTime) {
        this.localCreatedTime = localCreatedTime;
    }

    public Date getLocalUpdatedTime() {
        return localUpdatedTime;
    }

    public void setLocalUpdatedTime(Date localUpdatedTime) {
        this.localUpdatedTime = localUpdatedTime;
    }

    public BigDecimal getDiscountShare() {
        return discountShare;
    }

    public void setDiscountShare(BigDecimal discountShare) {
        this.discountShare = discountShare;
    }

    public static class Builder {
        private final DietOrderDetail instance = new DietOrderDetail();

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

        public Builder dietOrderId(BigInteger dietOrderId) {
            instance.setDietOrderId(dietOrderId);
            return this;
        }

        public Builder dietOrderGroupId(BigInteger dietOrderGroupId) {
            instance.setDietOrderGroupId(dietOrderGroupId);
            return this;
        }

        public Builder goodsType(Integer goodsType) {
            instance.setGoodsType(goodsType);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsName(String goodsName) {
            instance.setGoodsName(goodsName);
            return this;
        }

        public Builder goodsSpecificationId(BigInteger goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder goodsSpecificationName(String goodsSpecificationName) {
            instance.setGoodsSpecificationName(goodsSpecificationName);
            return this;
        }

        public Builder packageId(BigInteger packageId) {
            instance.setPackageId(packageId);
            return this;
        }

        public Builder packageGroupId(BigInteger packageGroupId) {
            instance.setPackageGroupId(packageGroupId);
            return this;
        }

        public Builder packageGroupName(String packageGroupName) {
            instance.setPackageGroupName(packageGroupName);
            return this;
        }

        public Builder categoryId(BigInteger categoryId) {
            instance.setCategoryId(categoryId);
            return this;
        }

        public Builder categoryName(String categoryName) {
            instance.setCategoryName(categoryName);
            return this;
        }

        public Builder price(BigDecimal price) {
            instance.setPrice(price);
            return this;
        }

        public Builder attributeIncrease(BigDecimal attributeIncrease) {
            instance.setAttributeIncrease(attributeIncrease);
            return this;
        }

        public Builder quantity(BigDecimal quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountAmount(BigDecimal discountAmount) {
            instance.setDiscountAmount(discountAmount);
            return this;
        }

        public Builder payableAmount(BigDecimal payableAmount) {
            instance.setPayableAmount(payableAmount);
            return this;
        }

        public Builder localId(String localId) {
            instance.setLocalId(localId);
            return this;
        }

        public Builder localDietOrderId(String localDietOrderId) {
            instance.setLocalDietOrderId(localDietOrderId);
            return this;
        }

        public Builder localDietOrderGroupId(String localDietOrderGroupId) {
            instance.setLocalDietOrderGroupId(localDietOrderGroupId);
            return this;
        }

        public Builder localCreatedTime(Date localCreatedTime) {
            instance.setLocalCreatedTime(localCreatedTime);
            return this;
        }

        public Builder localUpdatedTime(Date localUpdatedTime) {
            instance.setLocalUpdatedTime(localUpdatedTime);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public DietOrderDetail build() {
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
        public static final String DIET_ORDER_ID = "diet_order_id";
        public static final String DIET_ORDER_GROUP_ID = "diet_order_group_id";
        public static final String GOODS_TYPE = "goods_type";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_NAME = "goods_name";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String GOODS_SPECIFICATION_NAME = "goods_specification_name";
        public static final String PACKAGE_ID = "package_id";
        public static final String PACKAGE_GROUP_ID = "package_group_id";
        public static final String PACKAGE_GROUP_NAME = "package_group_name";
        public static final String CATEGORY_ID = "category_id";
        public static final String CATEGORY_NAME = "category_name";
        public static final String PRICE = "price";
        public static final String ATTRIBUTE_INCREASE = "attribute_increase";
        public static final String QUANTITY = "quantity";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String DISCOUNT_AMOUNT = "discount_amount";
        public static final String PAYABLE_AMOUNT = "payable_amount";
        public static final String LOCAL_ID = "local_id";
        public static final String LOCAL_DIET_ORDER_ID = "local_diet_order_id";
        public static final String LOCAL_DIET_ORDER_GROUP_ID = "local_diet_order_group_id";
        public static final String LOCAL_CREATED_TIME = "local_created_time";
        public static final String LOCAL_UPDATED_TIME = "local_updated_time";
        public static final String DISCOUNT_SHARE = "discount_share";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String DIET_ORDER_ID = "dietOrderId";
        public static final String DIET_ORDER_GROUP_ID = "dietOrderGroupId";
        public static final String GOODS_TYPE = "goodsType";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_NAME = "goodsName";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String GOODS_SPECIFICATION_NAME = "goodsSpecificationName";
        public static final String PACKAGE_ID = "packageId";
        public static final String PACKAGE_GROUP_ID = "packageGroupId";
        public static final String PACKAGE_GROUP_NAME = "packageGroupName";
        public static final String CATEGORY_ID = "categoryId";
        public static final String CATEGORY_NAME = "categoryName";
        public static final String PRICE = "price";
        public static final String ATTRIBUTE_INCREASE = "attributeIncrease";
        public static final String QUANTITY = "quantity";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String DISCOUNT_AMOUNT = "discountAmount";
        public static final String PAYABLE_AMOUNT = "payableAmount";
        public static final String LOCAL_ID = "localId";
        public static final String LOCAL_DIET_ORDER_ID = "localDietOrderId";
        public static final String LOCAL_DIET_ORDER_GROUP_ID = "localDietOrderGroupId";
        public static final String LOCAL_CREATED_TIME = "localCreatedTime";
        public static final String LOCAL_UPDATED_TIME = "localUpdatedTime";
    }
}
