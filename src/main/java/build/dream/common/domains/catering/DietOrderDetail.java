package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.annotations.Transient;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.util.Date;

@ShardingColumn(fieldName = DietOrderDetail.FieldName.TENANT_ID, columnName = DietOrderDetail.ColumnName.TENANT_ID)
public class DietOrderDetail extends BasicDomain {
    public static final String TABLE_NAME = "diet_order_detail";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * diet_order.id
     */
    private Long dietOrderId;
    /**
     * 餐厅订单ID，diet_order_group.id
     */
    private Long dietOrderGroupId;
    /**
     * 商品类型，1-普通商品，2-套餐，3-套餐明细
     */
    private Integer goodsType;
    /**
     * 产品ID，goods.id
     */
    private Long goodsId;
    /**
     * 产品名称，goods.name
     */
    private String goodsName;
    /**
     * 商品规格ID，goodsSpecification.id
     */
    private Long goodsSpecificationId;
    /**
     * 商品规格名称，goodsSpecification.name
     */
    private String goodsSpecificationName;
    /**
     * 套餐ID
     */
    private Long packageId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 套餐组ID
     */
    private Long packageGroupId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 套餐组名称
     */
    private String packageGroupName = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 商品分类id
     */
    private Long categoryId;
    /**
     * 商品分类名称
     */
    private String categoryName;
    /**
     * 单价
     */
    private Double price;
    /**
     * 口味加价
     */
    private Double attributeIncrease = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 总数量
     */
    private Double quantity;
    /**
     * 总金额
     */
    private Double totalAmount;
    /**
     * 优惠金额
     */
    private Double discountAmount;
    /**
     * 应付金额
     */
    private Double payableAmount;
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
    private Double discountShare;

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

    public Long getDietOrderId() {
        return dietOrderId;
    }

    public void setDietOrderId(Long dietOrderId) {
        this.dietOrderId = dietOrderId;
    }

    public Long getDietOrderGroupId() {
        return dietOrderGroupId;
    }

    public void setDietOrderGroupId(Long dietOrderGroupId) {
        this.dietOrderGroupId = dietOrderGroupId;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
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

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getPackageGroupId() {
        return packageGroupId;
    }

    public void setPackageGroupId(Long packageGroupId) {
        this.packageGroupId = packageGroupId;
    }

    public String getPackageGroupName() {
        return packageGroupName;
    }

    public void setPackageGroupName(String packageGroupName) {
        this.packageGroupName = packageGroupName;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAttributeIncrease() {
        return attributeIncrease;
    }

    public void setAttributeIncrease(Double attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
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

    public Double getDiscountShare() {
        return discountShare;
    }

    public void setDiscountShare(Double discountShare) {
        this.discountShare = discountShare;
    }

    public static class Builder extends BasicDomain.Builder<Builder, DietOrderDetail> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder dietOrderId(Long dietOrderId) {
            instance.setDietOrderId(dietOrderId);
            return this;
        }

        public Builder dietOrderGroupId(Long dietOrderGroupId) {
            instance.setDietOrderGroupId(dietOrderGroupId);
            return this;
        }

        public Builder goodsType(Integer goodsType) {
            instance.setGoodsType(goodsType);
            return this;
        }

        public Builder goodsId(Long goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsName(String goodsName) {
            instance.setGoodsName(goodsName);
            return this;
        }

        public Builder goodsSpecificationId(Long goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder goodsSpecificationName(String goodsSpecificationName) {
            instance.setGoodsSpecificationName(goodsSpecificationName);
            return this;
        }

        public Builder packageId(Long packageId) {
            instance.setPackageId(packageId);
            return this;
        }

        public Builder packageGroupId(Long packageGroupId) {
            instance.setPackageGroupId(packageGroupId);
            return this;
        }

        public Builder packageGroupName(String packageGroupName) {
            instance.setPackageGroupName(packageGroupName);
            return this;
        }

        public Builder categoryId(Long categoryId) {
            instance.setCategoryId(categoryId);
            return this;
        }

        public Builder categoryName(String categoryName) {
            instance.setCategoryName(categoryName);
            return this;
        }

        public Builder price(Double price) {
            instance.setPrice(price);
            return this;
        }

        public Builder attributeIncrease(Double attributeIncrease) {
            instance.setAttributeIncrease(attributeIncrease);
            return this;
        }

        public Builder quantity(Double quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder totalAmount(Double totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountAmount(Double discountAmount) {
            instance.setDiscountAmount(discountAmount);
            return this;
        }

        public Builder payableAmount(Double payableAmount) {
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

        @Override
        public DietOrderDetail build() {
            DietOrderDetail dietOrderDetail = super.build();
            dietOrderDetail.setTenantId(instance.getTenantId());
            dietOrderDetail.setTenantCode(instance.getTenantCode());
            dietOrderDetail.setBranchId(instance.getBranchId());
            dietOrderDetail.setDietOrderId(instance.getDietOrderId());
            dietOrderDetail.setDietOrderGroupId(instance.getDietOrderGroupId());
            dietOrderDetail.setGoodsType(instance.getGoodsType());
            dietOrderDetail.setGoodsId(instance.getGoodsId());
            dietOrderDetail.setGoodsName(instance.getGoodsName());
            dietOrderDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            dietOrderDetail.setGoodsSpecificationName(instance.getGoodsSpecificationName());
            dietOrderDetail.setPackageId(instance.getPackageId());
            dietOrderDetail.setPackageGroupId(instance.getPackageGroupId());
            dietOrderDetail.setPackageGroupName(instance.getPackageGroupName());
            dietOrderDetail.setCategoryId(instance.getCategoryId());
            dietOrderDetail.setCategoryName(instance.getCategoryName());
            dietOrderDetail.setPrice(instance.getPrice());
            dietOrderDetail.setAttributeIncrease(instance.getAttributeIncrease());
            dietOrderDetail.setQuantity(instance.getQuantity());
            dietOrderDetail.setTotalAmount(instance.getTotalAmount());
            dietOrderDetail.setDiscountAmount(instance.getDiscountAmount());
            dietOrderDetail.setPayableAmount(instance.getPayableAmount());
            dietOrderDetail.setLocalId(instance.getLocalId());
            dietOrderDetail.setLocalDietOrderId(instance.getLocalDietOrderId());
            dietOrderDetail.setLocalDietOrderGroupId(instance.getLocalDietOrderGroupId());
            dietOrderDetail.setLocalCreatedTime(instance.getLocalCreatedTime());
            dietOrderDetail.setLocalUpdatedTime(instance.getLocalUpdatedTime());
            dietOrderDetail.setDiscountShare(instance.getDiscountShare());
            return dietOrderDetail;
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
        public static final String DISCOUNT_SHARE = "discountShare";
    }
}
